/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserManager.java
 * Created on               : September 21, 2007, 12:14 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoUserManager {
  
  /** Creates a new instance of XurmoUserManager */
  private  XurmoUserManager() {
  }
  public static XurmoUserHomeScreenData getHomeScreenData(String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName, javax.persistence.EntityManager em) {
    
    XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em);
    if (xus != null && cookie.equals(xus.getCookie())) {
      
      XurmoCellLocationMap xclm
          = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em);
      XurmoUser xu = (XurmoUser) (em.createNamedQuery("XurmoUser.findByUsername").setParameter("username", username).getSingleResult());
      return new XurmoUserHomeScreenData(xu.getUsername(), xus.getCookie(), XurmoUserInteractionStatus.INTERACTIONSTATUS_NO_ERROR, xclm.getLocation(), xu.getFname(), xu.getLname(), xu.getSalutation(), xu.getPresence());
    } else {
      return new XurmoUserHomeScreenData("", xus.getCookie(), XurmoUserInteractionStatus.INTERACTIONFAILED_USER_NOT_LOGGED_IN, "Unknown", "", "", "", "");
    }
  }
  public static void updatePresence(String username, String cookie, String imei, String presence, String twitterUsername, String twitterPassword, String jaikuUsername, String jaikuPersonalKey, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName, javax.persistence.EntityManager em) {
    
      XurmoUser xu = (XurmoUser) (em.createNamedQuery("XurmoUser.findByUsername").setParameter("username", username).getSingleResult());
      boolean updatedPresence = false;
      if (!xu.getPresence().equals(presence)) {
        updatedPresence = true;
      }
      if (presence != null && !presence.equals("") && !presence.equals("Unknown") && updatedPresence) {
        xu.setPresence(presence);
        em.persist(xu);
      }
      if (updatedPresence) {
        
        XurmoMessageQueueToPresence.updatePresencePortals(presence, twitterUsername, twitterPassword, jaikuUsername, jaikuPersonalKey, mobileCountryCode, mobileNetworkCode,  siteId, cellId, cellName, em);
      }
  }
}
