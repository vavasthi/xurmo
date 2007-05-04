/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoLocationManager.java
 * Created on               : May 4, 2007, 7:10 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoLocationManager {
    
    /** Creates a new instance of XurmoLocationManager */
    private XurmoLocationManager() {
    }
    public static XurmoUserManagementStatus updateLocation(String username, String cookie, String imsi, String siteId, String cellId, String locationString, javax.persistence.EntityManager em) {
        
        int error = XurmoUserSignonStatus.SIGNONSTATUS_NO_ERROR;
        String mobileCountryCode = imsi.substring(0, 3);
        String mobileNetworkCode = imsi.substring(3, 6);
        XurmoMessageForALocationManager.instance().processMessagesInALocation(mobileCountryCode, mobileNetworkCode, siteId, cellId, username, em);
        locationString = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, locationString, em);
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em);
        if (xus != null && cookie.equals(xus.getCookie())) {
            xus.setLocation(locationString);
            cookie = xus.getCookie();
        }
        return new XurmoUserManagementStatus(XurmoError.Success, cookie);
    }
    public static String updateLocationMap(String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString, javax.persistence.EntityManager em) {
        
        if (locationString != null && !locationString.equals("") && !locationString.equals("Unknown")) {
            javax.persistence.Query q = em.createNamedQuery("XurmoCellLocationMap.findByAllIds");
            q.setParameter("siteId", siteId);
            q.setParameter("cellId", cellId);
            q.setParameter("mobileCountryCode", mobileCountryCode);
            q.setParameter("mobileNetworkCode", mobileNetworkCode);
            try {
                
                XurmoCellLocationMap xclm = (XurmoCellLocationMap)q.getSingleResult();
                locationString = xclm.getLocation();
            } catch (Exception ex) {
                
                XurmoCellLocationMap xclm = new XurmoCellLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, locationString);
                em.persist(xclm);
            }
        } else {
            locationString = mobileCountryCode + "-" + mobileNetworkCode + "-" + siteId + "-" + cellId;
        }
        return locationString;
    }
}
