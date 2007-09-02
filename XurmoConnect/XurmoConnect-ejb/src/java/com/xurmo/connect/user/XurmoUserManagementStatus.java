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
    public XurmoUserManagementStatus(int error, String cookie, String cellName) {
        super();
        error_ = error;
        cookie_ = cookie;
        cellName_ = cellName;
    }
    public int getError() {
        return error_;
    }
    public String getCookie() {
        return cookie_;
    }
    public String getCellName() {
        return cellName_;
    }
    private int error_;
    private String cookie_;
    private String cellName_;
}
