/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoMessageForALocationReturnStatus.java
 * Created on               : March 31, 2007, 8:14 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoMessageForALocationReturnStatus {
    
    /** Creates a new instance of XurmoMessageForALocationReturnStatus */
    public XurmoMessageForALocationReturnStatus(int error, String cookie) {
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