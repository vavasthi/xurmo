/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoInvitationSendStatus.java
 * Created on               : March 29, 2007, 9:51 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoInvitationSendStatus {
    
    /** Creates a new instance of XurmoInvitationSendStatus */
    public XurmoInvitationSendStatus(int error, String cookie) {
        error_ = error;
        cookie_ = cookie;
    }
    public int getError() {
        return error_;
    }
    public String getCookie() {
        return cookie_;
    }
    private int error_;
    private String cookie_;
}
