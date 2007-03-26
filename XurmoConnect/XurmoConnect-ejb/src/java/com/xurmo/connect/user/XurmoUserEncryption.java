/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserEncryption.java
 * Created on               : March 26, 2007, 8:55 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoUserEncryption {
    
    public static XurmoUserEncryption instance() {
        if (self_ == null) {
            self_ = new XurmoUserEncryption();
        }
        return self_;
    }
    public static void fini() {
       self_ = null;
    }
    /** Creates a new instance of XurmoUserEncryption */
    private XurmoUserEncryption() {
    }
    public byte[] encrypt(String v) {
        return v.getBytes();
    }
    private static XurmoUserEncryption self_ = null;
}
