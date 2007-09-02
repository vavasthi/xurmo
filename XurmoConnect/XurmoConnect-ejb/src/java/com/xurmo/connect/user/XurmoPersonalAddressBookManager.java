/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPersonalAddressBookManager.java
 * Created on               : September 3, 2007, 1:13 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoPersonalAddressBookManager {
    
    /**
     * Creates a new instance of XurmoPersonalAddressBookManager
     */
    public XurmoPersonalAddressBookManager() {
    }
    public static XurmoUserManagementStatus uploadPhoneBook(XurmoUser xus, String cookie, XurmoPhoneAddressBookSync addressBook, String cellName, javax.persistence.EntityManager em) {
     
        javax.persistence.Query pabq = em.createNamedQuery("XurmoPersonalAddressBook.findByUserid");
        pabq.setParameter("userid", xus.getUserid());
        if (pabq.getResultList().size() > 0) {
            
        }
        else {
            XurmoPersonalAddressBook pab = addressBook.getPersonalAddressBookBean(xus.getUserid());
            XurmoPersonalAddressBookAddress[] paba = addressBook.getPersonalAddressBookAddresses(xus.getUserid());
            XurmoPersonalAddressBookEmailAddress[] pabea = addressBook.getPersonalAddressBookEmailAddresses(xus.getUserid());
            XurmoPersonalAddressBookPhoneNumbers[] pabpn = addressBook.getPersonalAddressBookPhoneNumbers(xus.getUserid());
            for (int i = 0; i < pabpn.length; ++i) {
                em.persist(pabpn[i]);
            }
            for (int i = 0; i < pabea.length; ++i) {
                em.persist(pabea[i]);
            }
            for (int i = 0; i < paba.length; ++i) {
                em.persist(paba[i]);
            }
            em.persist(pab);
        }
        return new XurmoUserManagementStatus(XurmoUserInteractionStatus.INTERACTIONSTATUS_NO_ERROR, cookie, cellName);
    }    
}
