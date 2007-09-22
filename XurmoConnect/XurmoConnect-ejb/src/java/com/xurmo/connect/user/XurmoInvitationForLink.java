/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoInvitationForLink.java
 * Created on               : March 30, 2007, 11:19 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import bsh.This;

/**
 *
 * @author xurmo
 */
public class XurmoInvitationForLink implements java.io.Serializable {
    
    /** Creates a new instance of XurmoInvitationForLink */
    public XurmoInvitationForLink(
        int linkId,
        String linkName,
        String message,
        String phoneNumberToUser,
        String requestFromUser,
        int uniqueId) {
      
        this.requestFromUser = requestFromUser;
        this.phoneNumberToUser = phoneNumberToUser;
        this.uniqueId = uniqueId;
        this.linkId = linkId;
        this.linkName = linkName;
        this.message = message;
    }
    public XurmoInvitationForLink() {
      
    }
    public String requestFromUser;
    public String phoneNumberToUser;
    public int uniqueId;
    public int linkId;
    public String linkName;
    public String message;
}
