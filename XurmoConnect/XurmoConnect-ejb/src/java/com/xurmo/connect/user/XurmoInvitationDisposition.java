/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoInvitationDisposition.java
 * Created on               : March 30, 2007, 11:08 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoInvitationDisposition implements java.io.Serializable {
    
    /** Creates a new instance of XurmoInvitationDisposition */
    public XurmoInvitationDisposition(String destination, int responseId, int linkId) {
        destination_ = destination;
        responseId_ = responseId;
        linkId_ = linkId;
    }
    
    public String getDestination() {
        return destination_;
    }
    public int getResponseId() {
        return responseId_;
    }
    public int getLinkId() {
        return linkId_;
    }
    private String destination_;
    private int linkId_;
    private int responseId_;
    
    public static final int ACCEPT = 0x01;
    public static final int DECLINE = 0x02;
    public static final int DECLINE_SILENTLY = 0x03;
    public static final int POSTPONE = 0x04;
}
