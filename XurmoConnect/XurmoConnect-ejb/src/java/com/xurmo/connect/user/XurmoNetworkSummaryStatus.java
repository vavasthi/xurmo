/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoNetworkSummaryStatus.java
 * Created on               : September 9, 2007, 2:02 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoNetworkSummaryStatus {
    public XurmoNetworkInteractionStatus status;
    public String[] memberOfNetworks;
    public int numberOfContacts;
    public XurmoUserGlobalData[] contactsAlreadyUser;
    /** Creates a new instance of XurmoNetworkSummaryStatus */
    public XurmoNetworkSummaryStatus(String cookie, String[] memberOfNetworks, int numberOfContacts, XurmoUserGlobalData[] contactsAlreadyUser) {
        this.status = new XurmoNetworkInteractionStatus(cookie);
        this.memberOfNetworks = memberOfNetworks;
        this.numberOfContacts = numberOfContacts;
        this.contactsAlreadyUser = contactsAlreadyUser;
    }    
    public XurmoNetworkSummaryStatus(int error, String cookie) {
        this.status = new XurmoNetworkInteractionStatus(error, cookie);
        this.memberOfNetworks = new String[0];
        this.numberOfContacts = 0;
        this.contactsAlreadyUser = new XurmoUserGlobalData[0];
    }    
}
