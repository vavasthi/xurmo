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
    public static XurmoUserManagementStatus updateLocation(String username, String cookie, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String cellName, javax.persistence.EntityManager em) {
        
        int error = XurmoUserSignonStatus.SIGNONSTATUS_NO_ERROR;
        XurmoCellLocationMap xclm = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em);
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em);
        if (xus != null && cookie.equals(xus.getCookie())) {
            xus.setLocationId(xclm.getLocationId());
            cookie = xus.getCookie();
        }
        return new XurmoUserManagementStatus(XurmoError.Success, cookie);
    }
    public static XurmoCellLocationMap updateLocationMap(String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String cellName, javax.persistence.EntityManager em) {
        
        XurmoCellLocationMap xclm;
        boolean incomingCellNameIsNotNull = true;
        javax.persistence.Query q = em.createNamedQuery("XurmoCellLocationMap.findByAllIds");
        q.setParameter("siteId", siteId);
        q.setParameter("cellId", cellId);
        q.setParameter("mobileCountryCode", mobileCountryCode);
        q.setParameter("mobileNetworkCode", mobileNetworkCode);
        if (cellName == null || cellName.equals("") || cellName.equals("Unknown")) {
            cellName = new String("Unknown");
            incomingCellNameIsNotNull = false;
        }
        try {
            
            xclm = (XurmoCellLocationMap)q.getSingleResult();
        } catch (Exception ex) {
            
            xclm = new XurmoCellLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName);
            em.persist(xclm);
        }
        if (xclm.getLocation().equals("Unknown") && incomingCellNameIsNotNull ) {
            xclm.setLocation(cellName);
            em.persist(xclm);
        }
        return xclm;
    }
}
