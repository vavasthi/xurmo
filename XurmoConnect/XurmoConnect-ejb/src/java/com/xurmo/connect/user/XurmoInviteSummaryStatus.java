/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoNetworkSummaryStatus.java
 * Created on               : September 9, 2007, 2:02 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import bsh.This;

/**
 *
 * @author xurmo
 */
public class XurmoInviteSummaryStatus implements java.io.Serializable {
    public XurmoNetworkInteractionStatus status;
    public XurmoInvitePhoneBookEntry[] connectableEntries;
    public XurmoInvitePhoneBookEntry[] joinableEntries;
    public XurmoNetworkLinkType[] linkTypes;
    /** Creates a new instance of XurmoNetworkSummaryStatus */
    public XurmoInviteSummaryStatus(String cookie, String cellName, XurmoInvitePhoneBookEntry[] connectableEntries, XurmoInvitePhoneBookEntry[] joinableEntries, XurmoNetworkLinkType[] linkTypes) {
        this.status = new XurmoNetworkInteractionStatus(cookie, cellName);
        this.connectableEntries = connectableEntries;
        this.joinableEntries = joinableEntries;
        this.linkTypes = linkTypes;
    }    
    public XurmoInviteSummaryStatus(int error, String cookie, String cellName) {
        this.status = new XurmoNetworkInteractionStatus(error, cookie, cellName);
        this.connectableEntries= new XurmoInvitePhoneBookEntry[0];
        this.joinableEntries= new XurmoInvitePhoneBookEntry[0];
        this.linkTypes = new XurmoNetworkLinkType[0];
    }    
}
