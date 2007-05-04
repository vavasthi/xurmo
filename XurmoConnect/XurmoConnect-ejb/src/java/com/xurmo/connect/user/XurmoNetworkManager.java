/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoNetworkManager.java
 * Created on               : April 1, 2007, 10:26 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoNetworkManager {
    
    public static XurmoNetworkManager instance() {
        if (self_ == null) {
            self_ = new XurmoNetworkManager();
        }
        return self_;
    }
    /** Creates a new instance of XurmoNetworkManager */
    private XurmoNetworkManager() {
    }
    private static XurmoNetworkManager self_ = null;
}
