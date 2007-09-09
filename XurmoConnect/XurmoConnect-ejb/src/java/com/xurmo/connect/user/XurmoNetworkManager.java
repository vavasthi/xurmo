/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoNetworkManager.java
 * Created on               : April 1, 2007, 10:26 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import org.jboss.util.platform.Java;

/**
 *
 * @author xurmo
 */
public class XurmoNetworkManager {
    
    public static String[] memberOfNetworks(String username, javax.persistence.EntityManager em) {
        javax.persistence.Query q = em.createNamedQuery("XurmoNetworkLinkType.findUniqueByUsername");
        q.setParameter("username", username);
        java.util.List l = q.getResultList();
        java.util.Iterator li = l.iterator();
        String[] out = new String[l.size()];
        int i = 0;
        while (li.hasNext()) {
            XurmoNetworkLinkType xnlt = (XurmoNetworkLinkType)li.next();
            out[i] = xnlt.getLinkName();
            ++i;
        }
        return out;
    }
    public static int numberOfContacts(int userid, javax.persistence.EntityManager em) {
        javax.persistence.Query q = em.createNamedQuery("XurmoPersonalAddressBook.findByUserid");
        q.setParameter("userid", userid);
        java.util.List l = q.getResultList();
        return l.size();
    }
    public static XurmoUserGlobalData[] contactsAlreadyUser(String username, javax.persistence.EntityManager em) {
        javax.persistence.Query q = em.createNamedQuery("XurmoUser.findByPersonalAddressBookMatch");
        q.setParameter("username", username);
        java.util.List l = q.getResultList();
        java.util.Iterator itr = l.iterator();
        XurmoUserGlobalData[] out = new XurmoUserGlobalData[l.size()];
        int j = 0;
        while (itr.hasNext()) {
            XurmoUser xu = (XurmoUser)itr.next();
            out[j] = new XurmoUserGlobalData(xu.getUserid(), xu.getUsername(), xu.getFname(), xu.getLname());
            ++j;
        }
        return out;
    }
}
