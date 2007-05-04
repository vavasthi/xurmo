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

/**
 *
 * @author xurmo
 */
@Stateless(name = "ejb/XurmoMessageManagementBean")
public class XurmoMessageManagementBean implements com.xurmo.connect.user.XurmoMessageManagementRemote, com.xurmo.connect.user.XurmoMessageManagementLocal {
    @PersistenceContext
    
    EntityManager em_;
    
    /** Creates a new instance of XurmoMessageManagementBean */
    public XurmoMessageManagementBean() {
    }
    public XurmoMessageStatus enqueueMessage(String sourceId, String destinationId, String imsi, String siteId, String cellId, String locationString, String msg, String cookie) {
        
        String mobileCountryCode = imsi.substring(0, 3);
        String mobileNetworkCode = imsi.substring(3, 6);
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(sourceId, em_);
        if (xus != null && cookie.equals(xus.getCookie())) {
            XurmoLocationManager.updateLocation(sourceId, cookie, imsi, siteId, cellId, locationString, em_);
            return XurmoMessageForALocationManager.instance().enqueueMessage(sourceId, destinationId, mobileCountryCode, mobileNetworkCode, siteId, cellId, msg, cookie, em_);
        }
        return new XurmoMessageStatus(XurmoError.UserNotLoggedIn, cookie);
    }
    
    
}
