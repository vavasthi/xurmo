/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserManagementStatus.java
 * Created on               : March 27, 2007, 11:18 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;

/**
 *
 * @author xurmo
 */
public class XurmoUserManagementStatus implements Serializable {
    
    /**
     * Creates a new instance of XurmoUserManagementStatus
     */
    public XurmoUserManagementStatus(UserAuthenticationStatus error, String cookie) {
        super();
        error_ = error;
        cookie_ = cookie;
    }
    public UserAuthenticationStatus getError() {
        return error_;
    }
    public String getCookie() {
        return cookie_;
    }
    public enum UserAuthenticationStatus {
        SUCCESS,
        INVALID_USERNAME_OR_PASSWORD
    }
    private UserAuthenticationStatus error_;
    private String cookie_;
}
