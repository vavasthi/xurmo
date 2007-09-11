/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoSocialNetworkingMain.java
 * Created on               : September 11, 2007, 3:57 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.socialnetworking;

import javax.jms.*;
import javax.naming.*;

/**
 *
 * @author xurmo
 */
public class XurmoSocialNetworkingMain {
  private static QueueConnection qc_ = null;
  private static Queue q_ = null;
  private static QueueSession qs_ = null;
  private static QueueReceiver receiver_ = null;
  
  /** Creates a new instance of XurmoSocialNetworkingMain */
  public XurmoSocialNetworkingMain() {
  }
  public static void main(String[] args) {
    XurmoSocialNetworkingMessageListener listener = null;
    try {
      
      if (qc_ == null) {
        
        InitialContext ic = new InitialContext();
        
        QueueConnectionFactory qcf
            = (QueueConnectionFactory)ic.lookup("ConnectionFactory");
        q_ = (Queue) ic.lookup("queue/presencePortals");
        
        qc_ = qcf.createQueueConnection();
        qs_ = qc_.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        receiver_ = qs_.createReceiver(q_);
        listener = new XurmoSocialNetworkingMessageListener();
        receiver_.setMessageListener(listener);
        qc_.start();
      }
    } catch (NamingException e) {
      System.out.println("JNDI API lookup failed: " +
          e.toString());
      qc_ = null;
    } catch (JMSException e) {
      System.out.println("Exception occurred: " +
          e.toString());
      qc_ = null;
    }
    if (listener != null) {
      listener.waitForMain();
    }
  }
}
