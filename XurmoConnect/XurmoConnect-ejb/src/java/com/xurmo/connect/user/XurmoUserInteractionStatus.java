/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserInteractionStatus.java
 * Created on               : March 28, 2007, 11:38 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoUserInteractionStatus {
    
    /** Creates a new instance of XurmoUserInteractionStatus */
    public XurmoUserInteractionStatus() {
    }
    public static final int INTERACTIONSTATUS_NO_ERROR = 0;
    public static final int INTERACTIONFAILED_COULD_NOT_UPDATE_PROFILE = 0x01;
    public static final int INTERACTIONFAILED_COULD_NOT_SEND_INVITATION = 0x02;
    public static final int INTERACTIONFAILED_COULD_NOT_SEND_MESSAGE_FOR_A_LOCATION = 0x03;
    public static final int INTERACTIONFAILED_USER_NOT_LOGGED_IN = 0x04;
    public static final int INTERACTIONFAILED_INVALID_USERNAME_OR_PASSWORD = 0x05;

}
