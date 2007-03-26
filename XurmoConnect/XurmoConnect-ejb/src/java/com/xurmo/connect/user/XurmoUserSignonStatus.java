/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserSignonStatus.java
 * Created on               : March 26, 2007, 8:26 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoUserSignonStatus {
    
    /** Creates a new instance of XurmoUserSignonStatus */
    public XurmoUserSignonStatus() {
    }
    public static final int SIGNONFAILED_TEMPORARY_NOT_AVAILABLE_MASK = 0x01;
    public static final int SIGNONFAILED_ACCOUNT_LOCKED_MASK = 0x02;
    public static final int SIGNONFAILED_INVALID_USERNAME_OR_PASSWORD_MASK = 0x04;   
}
