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
public class XurmoNetworkInteractionStatus implements java.io.Serializable {
    
    /** Creates a new instance of XurmoInvitationDispositionStatus */
    public XurmoNetworkInteractionStatus(int error, String cookie) {
        error_ = error;
        cookie_ = cookie;
    }
    public XurmoNetworkInteractionStatus(String cookie) {
        error_ = XurmoNetworkInteractionStatus.NETWORKINTERACTION_NO_ERROR;
        cookie_ = cookie;
    }
    public int getError() {
        return error_;
    }
    public String getCookie() {
        return cookie_;
    }
    public static final int NETWORKINTERACTION_NO_ERROR = 0;
    public static final int NETWORKINTERACTION_COULD_NOT_GET_SUMMARY = 0x01;
    public static final int NETWORKINTERACTION_COULD_NOT_SEND_INVITATION = 0x02;
    public static final int NETWORKINTERACTION_COULD_NOT_SEND_MESSAGE_FOR_A_LOCATION = 0x03;
    public static final int NETWORKINTERACTION_USER_NOT_LOGGED_IN = 0x04;
    public static final int NETWORKINTERACTION_INVALID_USERNAME_OR_PASSWORD = 0x05;
    public static final int NETWORKINTERACTION_UPLOAD_ADDRESSBOOK_FAILED = 0x06;
    public static final int NETWORKINTERACTION_DOWNLOAD_ADDRESSBOOK_FAILED = 0x07;

    private int error_;
    private String cookie_;    
}
