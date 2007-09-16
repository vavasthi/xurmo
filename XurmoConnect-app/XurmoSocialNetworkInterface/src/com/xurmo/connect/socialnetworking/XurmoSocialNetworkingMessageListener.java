/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoSocialNetworkingMessageListener.java
 * Created on               : September 11, 2007, 4:02 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.socialnetworking;

import javax.jms.*;

/**
 *
 * @author xurmo
 */
public class XurmoSocialNetworkingMessageListener implements MessageListener {
  private XurmoJaikuMessageUpdater xjmu_;
  private XurmoTwitterMessageUpdater xtmu_;
  private Thread xjmuThread_;
  private Thread xtmuThread_;
  /** Creates a new instance of XurmoSocialNetworkingMessageListener */
  public XurmoSocialNetworkingMessageListener() {
    
     xjmu_ = new XurmoJaikuMessageUpdater();
     xtmu_ = new XurmoTwitterMessageUpdater();
     xjmuThread_ = new Thread(xjmu_);
     xtmuThread_ = new Thread(xtmu_);
     xjmuThread_.start();
     xtmuThread_.start();
  }
  public void onMessage(Message msg) {
    try {
      System.out.println("Message received..");
      boolean isPresence = msg.getBooleanProperty("Presence");
      TextMessage tm = (TextMessage)(msg);
      String jaikuUsername  = tm.getStringProperty("JaikuUser");
      String jaikuPersonalKey  = tm.getStringProperty("JaikuPersonalKey");
      String twitterUsername  = tm.getStringProperty("TwitterUser");
      String twitterPassword  = tm.getStringProperty("TwitterPassword");
      String country  = tm.getStringProperty("Country");
      String city  = tm.getStringProperty("City");
      String location  = tm.getStringProperty("Location");
      String presence = tm.getText();
      if (jaikuUsername != null && jaikuPersonalKey != null && !jaikuUsername.equals("") && !jaikuPersonalKey.equals("")) {
        
        xjmu_.addMessage(new XurmoJaikuUpdateMessage(jaikuUsername, jaikuPersonalKey, country, city, location, presence));
      }
      if (twitterUsername != null && twitterPassword != null && !twitterUsername.equals("") && !twitterPassword.equals("")) {
        
        xtmu_.addMessage(new XurmoTwitterUpdateMessage(twitterUsername, twitterPassword, country, city, location, presence));
      }
    } catch(JMSException jex) {
      System.out.println("Error in OnMessage" + jex.getMessage());
      jex.printStackTrace();
    }
  }
  public void waitForMain() {
    try {
      
      xtmuThread_.join();
      xjmuThread_.join();
    }
    catch(InterruptedException iex) {
      iex.printStackTrace();
      System.out.println("Wait for main interrupted");
    }
  }
}
