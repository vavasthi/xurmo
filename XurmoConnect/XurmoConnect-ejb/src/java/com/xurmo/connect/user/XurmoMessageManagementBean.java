/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoMessageManagementBean.java
 * Created on               : May 4, 2007, 7:06 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import javax.ejb.Stateless;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;
import org.jboss.util.platform.Java;

/**
 *
 * @author xurmo
 */
@Stateless(name = "ejb/XurmoMessageManagementBean")
public class XurmoMessageManagementBean implements XurmoMessageManagementRemote, XurmoMessageManagementLocal {
  @PersistenceContext
  
  EntityManager em_;
  
  /** Creates a new instance of XurmoMessageManagementBean */
  public XurmoMessageManagementBean() {
  }
  public XurmoMessageStatus enqueueMessage(String sourceId, String destinationId, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String cellName, String msg, String cookie) {
    
    try {
      XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(sourceId, em_);
      if (xus != null && cookie.equals(xus.getCookie())) {
        
        XurmoLocationManager.updateLocation(sourceId, cookie, mobileCountryCode, mobileCountryCode, siteId, cellId, cellName, em_);
        return XurmoMessageForALocationManager.instance().enqueueMessage(sourceId, destinationId, mobileCountryCode, mobileNetworkCode, siteId, cellId, msg, cookie, em_);
      }
    } catch(Exception ex) {
    }
    return new XurmoMessageStatus(XurmoUserInteractionStatus.INTERACTIONFAILED_USER_NOT_LOGGED_IN, "", "");
  }
  
  public XurmoMessageStatus sendMessageToNetwork(String username, String cookie, String[] linkNames, int degreesOfSeparation, String content, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String cellName) {
    try {
      XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
      if (xus != null && cookie.equals(xus.getCookie())) {
        
        XurmoCellLocationMap xclm
            = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em_);
        XurmoUser xu = (XurmoUser) (em_.createNamedQuery("XurmoUser.findByUsername").setParameter("username", username).getSingleResult());
        int userId = xu.getUserid();
        String nmi = "Msg-" + userId + "-" + XurmoCounterManager.getNextMessageId(em_);
        for (int i = 0; i < linkNames.length; ++i) {
          
          int linkId = XurmoNetworkManager.getLinkId(em_, linkNames[i]);
          XurmoMessageForNetworkPK mnpk = new XurmoMessageForNetworkPK(linkId, nmi + "-" + linkNames[i]);
          XurmoMessageForNetwork xmn = new XurmoMessageForNetwork(mnpk, userId, degreesOfSeparation, content.getBytes(), 'N');
          em_.persist(xmn);
          XurmoMessageForNetworkManager.flushNetworkMessages(em_);
        }
        return new XurmoMessageStatus(XurmoUserInteractionStatus.INTERACTIONSTATUS_NO_ERROR, xus.getCookie(), xclm.getLocation());
      }
    } catch(Exception ex) {
      
      System.out.println("Send Message To Network Exception " + ex);
      ex.printStackTrace();
    }
    return new XurmoMessageStatus(XurmoUserInteractionStatus.INTERACTIONFAILED_USER_NOT_LOGGED_IN, "", "");
  }

  public XurmoMessages getUserMessages(String username, String cookie, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String cellName) {
    
    try {
      XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
      if (xus != null && cookie.equals(xus.getCookie())) {
        
        XurmoCellLocationMap xclm
            = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em_);
        XurmoUser xu = (XurmoUser) (em_.createNamedQuery("XurmoUser.findByUsername").setParameter("username", username).getSingleResult());
        java.util.Vector<XurmoMessage> messages = new java.util.Vector<XurmoMessage>();
        XurmoMessageForNetworkManager.getUserMessages(xu, messages, true, em_);
        return new XurmoMessages(XurmoUserInteractionStatus.INTERACTIONSTATUS_NO_ERROR, xus.getCookie(), xclm.getLocation(), messages);
      }
    } catch(Exception ex) {
    }
    return new XurmoMessages(XurmoUserInteractionStatus.INTERACTIONFAILED_USER_NOT_LOGGED_IN, "", "");
  }

  public void flushNetworkMessages() {
    
    XurmoMessageForNetworkManager.flushNetworkMessages(em_);
  }
  
  
}
