/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : UserAuthenticationReturnStatus.java
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
public class UserAuthenticationReturnStatus implements Serializable {
    
    /** Creates a new instance of UserAuthenticationReturnStatus */
    public UserAuthenticationReturnStatus(int error, String cookie) {
        super();
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
