/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoMessageStatus.java
 * Created on               : March 31, 2007, 8:14 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoMessageStatus implements java.io.Serializable {
    
    /**
     * Creates a new instance of XurmoMessageStatus
     */
    public XurmoMessageStatus(int error, String cookie) {
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