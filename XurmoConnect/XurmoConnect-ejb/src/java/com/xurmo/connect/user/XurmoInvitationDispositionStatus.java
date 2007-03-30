/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoInvitationDispositionStatus.java
 * Created on               : March 30, 2007, 11:05 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoInvitationDispositionStatus implements java.io.Serializable {
    
    /** Creates a new instance of XurmoInvitationDispositionStatus */
    public XurmoInvitationDispositionStatus(int error, String cookie) {
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
