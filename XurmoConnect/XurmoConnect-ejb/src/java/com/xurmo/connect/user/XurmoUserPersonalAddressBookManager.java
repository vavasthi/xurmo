/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserPersonalAddressBookManager.java
 * Created on               : March 28, 2007, 10:51 PM
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
public class XurmoUserPersonalAddressBookManager {
    
    public static XurmoUserPersonalAddressBookManager instance() {
        
        if (self_ == null) {
            self_ = new XurmoUserPersonalAddressBookManager();
        }
        return self_;
    }
    /**
     * Creates a new instance of XurmoUserPersonalAddressBookManager
     */
    private XurmoUserPersonalAddressBookManager() {
    }
    public int uploadPersonalAddressBook(String username, String fullName, XurmoElectronicAddress[] addresses, String email, EntityManager em) {

        int error = XurmoUserInteractionStatus.INTERACTIONSTATUS_NO_ERROR;
        try {
            
            XurmoPersonalAddressBook xpab = new XurmoPersonalAddressBook(username, fullName);
            em.persist(xpab);
            XurmoPersonalPhoneNumberEntry[] xppnea = new XurmoPersonalPhoneNumberEntry[addresses.length];
            for (int i = 0; i < addresses.length; ++i) {
                xppnea[i] = new XurmoPersonalPhoneNumberEntry(username, addresses[i].getAddressType(), addresses[i].getAddress());
                em.persist(xppnea[i]);
            }
            XurmoPersonalEmailEntry xpee = new XurmoPersonalEmailEntry(username, email);
            em.persist(xpee);
        }
        catch(Exception ex) {
            error |= XurmoUserInteractionStatus.INTERACTIONFAILED_COULD_NOT_UPDATE_PROFILE;
        }
        return error;
    }
    private static XurmoUserPersonalAddressBookManager self_ = null;
}
