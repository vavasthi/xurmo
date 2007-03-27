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
    public byte[] encrypt(String p) throws Exception {
        
        java.security.MessageDigest d = null;
        d = java.security.MessageDigest.getInstance("SHA-1");
        d.reset();
        d.update(p.getBytes());
        return d.digest();
    }
    public boolean validateEncryptedPassword(String password, byte[] encryptedPassword) {
        try {
            
            byte[] b = encrypt(password);
            if (b.length != encryptedPassword.length) {
                return false;
            } else {
                for (int i = 0; i < b.length; ++i) {
                    if (b[i] != encryptedPassword[i]) {
                        return false;
                    }
                }
            }
        } catch(Exception ex) {
            return false;
        }
        return true;
        
    }
    public String getRandomCookie(String str) {
        String c = str;
        java.util.Random r = new java.util.Random();
        while (c.length() < 100) {
            c += String.valueOf(r.nextInt());
        }
        return c;
    }
    private static XurmoUserEncryption self_ = null;
}
