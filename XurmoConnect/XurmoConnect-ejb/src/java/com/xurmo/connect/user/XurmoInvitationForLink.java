/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoInvitationForLink.java
 * Created on               : March 30, 2007, 11:19 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoInvitationForLink implements java.io.Serializable {
    
    /** Creates a new instance of XurmoInvitationForLink */
    public XurmoInvitationForLink(String requestFromUser,
        String phoneNumberToUser,
        int linkId,
        String linkName,
        String message) {
      
        this.requestFromUser = requestFromUser;
        this.requestToUser = requestToUser;
        this.linkId = linkId;
        this.linkName = linkName;
        this.message = message;
    }
    public String requestFromUser;
    public String requestToUser;    
    public int linkId;
    public String linkName;
    public String message;
}
