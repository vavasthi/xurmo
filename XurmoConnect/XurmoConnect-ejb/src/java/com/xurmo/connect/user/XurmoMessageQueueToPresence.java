/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoMessageQueueToPresence.java
 * Created on               : September 11, 2007, 10:38 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import javax.jms.*;
import javax.naming.*;

/**
 *
 * @author xurmo
 */
public class XurmoMessageQueueToPresence {
  private static QueueConnection qc_ = null;
  private static Queue q_ = null;
  private static QueueSession qs_ = null;
  private static QueueSender sender_ = null;
  
  /** Creates a new instance of XurmoMessageQueueToPresence */
  private XurmoMessageQueueToPresence() {
  }
  public static void updatePresencePortals(String presence, String twitterUsername, String twitterPassword, String jaikuUsername, String jaikuPersonalKey, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName, javax.persistence.EntityManager em) {
    
    javax.persistence.Query q = em.createNamedQuery("XurmoCountries.findByMobileCountryCode");
    q.setParameter("mobileCountryCode", mobileCountryCode);
    XurmoCountries xc = (XurmoCountries)(q.getSingleResult());
    String country = xc.getCountryName();
    String city = new String("");
    String location = cellName;
    if (cellName.equals("Unknown")) {
      location = mobileCountryCode + "-" + mobileNetworkCode + "-" + siteId + "-" + cellId;
    }
    try {
      if (qc_ == null) {
        
        InitialContext ic = new InitialContext();
        
        QueueConnectionFactory qcf
            = (QueueConnectionFactory)ic.lookup("ConnectionFactory");
        q_ = (Queue) ic.lookup("queue/presencePortals");
        
        qc_ = qcf.createQueueConnection();
        qs_ = qc_.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        sender_ = qs_.createSender(q_);
      }
      TextMessage msg = qs_.createTextMessage();
      msg.setBooleanProperty("Presence", true);
      msg.setStringProperty("JaikuUser", jaikuUsername);
      msg.setStringProperty("JaikuPersonalKey", jaikuPersonalKey);
      msg.setStringProperty("TwitterUser", twitterUsername);
      msg.setStringProperty("TwitterPassword", twitterPassword);
      msg.setStringProperty("Country", country);
      msg.setStringProperty("City", city);
      msg.setStringProperty("Location", location);
      msg.setText(presence);
      sender_.send(msg);
    } catch (NamingException e) {
      System.out.println("JNDI API lookup failed: " +
          e.toString());
      qc_ = null;
    } catch (JMSException e) {
      System.out.println("Exception occurred: " +
          e.toString());
      qc_ = null;
    }
  }
}