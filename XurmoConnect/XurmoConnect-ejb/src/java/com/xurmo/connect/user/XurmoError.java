/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoError.java
 * Created on               : May 4, 2007, 10:01 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoError implements java.io.Serializable {
    
    /** Creates a new instance of XurmoError */
    public XurmoError(int error, String errorString, String errorMessage) {
        error_ = error;
        errorString_ = errorString;
        errorMessage_ = errorMessage;
    }
    
    public int getError() {
        return error_;
    }
    public String errorString() {
        return errorString_;
    }
    public String errorMessage(){
        return errorMessage_;
    }
    public static final int Success = 0;
    public static final int InvalidUsernameOrPassword = 1;
    public static final int CouldNotSendMessageForALocation = 2;
    public static final int UserNotLoggedIn = 3;
    private int error_;
    private String errorString_;
    private String errorMessage_;
}
