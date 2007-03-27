/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserRegistrationStatus.java
 * Created on               : March 26, 2007, 6:22 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoUserRegistrationStatus {
    
    /**
     * Creates a new instance of XurmoUserRegistrationStatus
     */
    public XurmoUserRegistrationStatus() {
    }
    public static final int USER_REGISTRATION_NO_ERROR = 0;
    
    public static final int USERNAME_EXISTS_MASK = 0x01;
    public static final int USERNAME_INVALID_MASK = 0x02;
    public static final int MOBILE_EXISTS_MASK = 0x04;
    public static final int MOBILE_INVALID_MASK = 0x08;
    public static final int EMAIL_EXISTS_MASK = 0x10;
    public static final int EMAIL_INVALID_MASK = 0x20;
    public static final int PASSWORD_INVALID_MASK = 0x40;
    public static final int PASSWORD_COULD_NOT_BE_ENCODED_MASK = 0x80;
}
