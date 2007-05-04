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
    public XurmoMessageStatus(MessageStatus error, String cookie) {
        error_ = error;
        cookie_ = cookie;
    }
    public MessageStatus getError() {
        return error_;
    }
    public String getCookie() {
        return cookie_;
    }
    enum MessageStatus {
        SUCCESS,
        USER_NOT_LOGGED_IN,
        COULD_NOT_SEND_MESSAGE_FOR_A_LOCATION
    };
    private MessageStatus error_;
    private String cookie_;
}