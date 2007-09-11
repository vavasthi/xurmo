/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : JaikuMessageUpdater.java
 * Created on               : September 11, 2007, 4:38 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.socialnetworking;

import java.net.HttpURLConnection;
import java.net.URL;


/**
 *
 * @author xurmo
 */
public class XurmoTwitterMessageUpdater implements java.lang.Runnable {
  
  java.util.concurrent.ConcurrentLinkedQueue<XurmoTwitterUpdateMessage> messageQueue_;
  /** Creates a new instance of JaikuMessageUpdater */
  public XurmoTwitterMessageUpdater() {
    messageQueue_ = new java.util.concurrent.ConcurrentLinkedQueue<XurmoTwitterUpdateMessage>();
  }
  public void run() {
    
    while(true) {
      boolean queueEmpty = true;
      synchronized(this) {
        
        queueEmpty = (messageQueue_.peek() == null);
        if (queueEmpty) {
          try {
            wait();
          } catch(InterruptedException iex) {
            
          }
        }
      }
      XurmoTwitterUpdateMessage tum = messageQueue_.poll();
      if (tum != null) {
        if (!updateTwitter(tum)) {
          //messageQueue_.offer(tum);
        }
      }
    }
  }
  public synchronized void addMessage(XurmoTwitterUpdateMessage tum) {
    messageQueue_.offer(tum);
    notify();
  }
  private boolean updateTwitter(XurmoTwitterUpdateMessage tum) {
    
    String b64Source = tum.username_ + ":" + tum.password_;
    String b64 = new String(XurmoBase64EncoderStream.encode(b64Source.getBytes()));
    
    try {
      
      URL url = new URL("http://twitter.com/statuses/update.xml");
      HttpURLConnection conn = (HttpURLConnection)(url.openConnection());
      conn.setRequestMethod("POST");
      conn.setRequestProperty("Authorization", "Basic " + b64);
      conn.setDoOutput(true);
      java.io.OutputStreamWriter wr = new java.io.OutputStreamWriter(conn.getOutputStream());
      String data = "status=" + tum.presence_ +
          " @" + tum.location_ +
          " in " + tum.country_;
      System.out.println("Doing twitter post " + data);
      wr.write(data);
      wr.flush();
// Get the response
      java.io.BufferedReader rd = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream()));
      String line;
      while ((line = rd.readLine()) != null) {
        
        System.out.println(line);
      }
      wr.close();
      rd.close();
      return true;
    } catch(java.net.MalformedURLException murl) {
      murl.printStackTrace();
    } catch(java.io.IOException ioex) {
      ioex.printStackTrace();
    }
    return false;
  }
}
