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
public class XurmoMessages implements java.io.Serializable {
    
    /**
     * Creates a new instance of XurmoMessageStatus
     */
    public XurmoMessages(int errorCode, String cookie, String cellName, java.util.Vector<XurmoMessage> message) {
        this.errorCode = errorCode;
        this.cookie = cookie;
        this.cellName = cellName;
        this.message = new XurmoMessage[message.size()];
        this.message = message.toArray(this.message);
    }
    /**
     * Creates a new instance of XurmoMessageStatus
     */
    public XurmoMessages(int error, String cookie, String cellName) {
        this.errorCode = errorCode;
        this.cookie = cookie;
        this.cellName = cellName;
        this.message = new XurmoMessage[0];
    }
    public int errorCode;
    public String cookie;
    public String cellName;
    public XurmoMessage[] message;
}