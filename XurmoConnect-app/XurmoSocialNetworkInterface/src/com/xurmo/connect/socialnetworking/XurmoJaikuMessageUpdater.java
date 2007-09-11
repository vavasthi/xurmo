/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoJaikuMessageUpdater.java
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
public class XurmoJaikuMessageUpdater implements java.lang.Runnable {
  
  java.util.concurrent.ConcurrentLinkedQueue<XurmoJaikuUpdateMessage> messageQueue_;
  /**
   * Creates a new instance of XurmoJaikuMessageUpdater
   */
  public XurmoJaikuMessageUpdater() {
    messageQueue_ = new java.util.concurrent.ConcurrentLinkedQueue<XurmoJaikuUpdateMessage>();
  }
  public void run() {
    
    while(true) {
      boolean queueEmpty = true;
      synchronized(this) {
        
        queueEmpty = (messageQueue_.peek() == null);
        if (queueEmpty) {
          try {
            System.out.println("Waiting to receive message..");
            wait();
            System.out.println("Wait over, message received..");
          } catch(InterruptedException iex) {
            
          }
        }
      }
      XurmoJaikuUpdateMessage jum = messageQueue_.poll();
      if (jum != null) {
        if (!updateJaiku(jum)) {
          
          // messageQueue_.offer(jum);
        }
      }
    }
  }
  public synchronized void addMessage(XurmoJaikuUpdateMessage jum) {
    messageQueue_.offer(jum);
    notify();
  }
  private boolean updateJaiku(XurmoJaikuUpdateMessage jum) {
    
    try {
      
      URL url = new URL("http://api.jaiku.com/json");
      HttpURLConnection conn = (HttpURLConnection)(url.openConnection());
      conn.setRequestMethod("POST");
      conn.setDoOutput(true);
      java.io.OutputStreamWriter wr = new java.io.OutputStreamWriter(conn.getOutputStream());
      String data = "user=" + jum.username_ +
          "&personal_key=" + jum.personalKey_ +
          "&method=presence.send&message=" + jum.presence_ +
          "&location=" + jum.location_ + "," + jum.city_ + "," + jum.country_;
      System.out.println("Posting " +data);
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
