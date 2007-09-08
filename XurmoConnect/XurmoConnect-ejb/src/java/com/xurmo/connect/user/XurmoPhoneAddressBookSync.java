/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPhoneAddressBookSync.java
 * Created on               : September 3, 2007, 5:05 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoPhoneAddressBookSync implements java.io.Serializable {
    public int errorCode;
    
    /** Creates a new instance of XurmoPhoneAddressBookSync */
    public XurmoPhoneAddressBookSync(XurmoPhoneContactSync[] contact) {
        this.contact = contact;
        this.errorCode = XurmoUserInteractionStatus.INTERACTIONSTATUS_NO_ERROR;
    }
    /** Creates a new instance of XurmoPhoneAddressBookSync */
    public XurmoPhoneAddressBookSync(int errorCode) {
        this.errorCode = errorCode;
        contact = new XurmoPhoneContactSync[0];
    }
    public int numberOfContacts() {
        return contact.length;
    }
    public XurmoPhoneContactSync contactAt(int i) {
        return contact[i];
    }
    public XurmoPhoneContactSync[] contact;
}
