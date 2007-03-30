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
    public XurmoInvitationForLink(int linkId, String destination) {
        
        linkId_ = linkId;
        destination_ = destination;
    }
    public int getLinkId() {
        return linkId_;
    }
    public String getDestination() {
        return destination_;
    }
    private int linkId_;
    private String destination_;
    
}
