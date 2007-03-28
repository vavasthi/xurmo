/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserSessionManager.java
 * Created on               : March 27, 2007, 9:39 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author xurmo
 */
public class XurmoUserSessionManager {
    
    public static XurmoUserSessionManager instance() {
        if (self_ == null) {
            self_ = new XurmoUserSessionManager();
        }
        return self_;
    }
    /** Creates a new instance of XurmoUserSessionManager */
    private XurmoUserSessionManager() {
    }
    public void removeSession(String username, EntityManager em) {
        
        try {
            
            XurmoUserSession xus
                    = (XurmoUserSession) (em.createNamedQuery("XurmoUserSession.findByUsername").setParameter("username", username).getSingleResult());
            em.remove(xus);
        } catch(Exception ex){
            
        }
    }
    public XurmoUserSession getSession(String username, EntityManager em) {
        
        XurmoUserSession xus = null;
        try {
            
            
            xus = (XurmoUserSession) (em.createNamedQuery("XurmoUserSession.findByUsername").setParameter("username", username).getSingleResult());
            xus.setLastUpdateTime(new java.util.Date());
        } catch(Exception ex){
            
        }
        return xus;
    }
    public XurmoUserSession createSession(String username, String cookie, String locationString, EntityManager em) {
        
        XurmoUserSession xus = new XurmoUserSession(username, cookie, locationString);
        em.persist(xus);
        return xus;
    }

    private static XurmoUserSessionManager self_ = null;
}
