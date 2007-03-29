/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUploadAddressBookReturnStatus.java
 * Created on               : March 29, 2007, 9:19 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;

/**
 *
 * @author xurmo
 */
public class XurmoUploadAddressBookReturnStatus implements Serializable {
    
    /** Creates a new instance of XurmoUploadAddressBookReturnStatus */
    public XurmoUploadAddressBookReturnStatus(int error, String cookie) {
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
