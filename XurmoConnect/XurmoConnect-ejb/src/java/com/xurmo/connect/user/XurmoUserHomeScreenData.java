/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserHomeScreenData.java
 * Created on               : August 28, 2007, 11:27 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoUserHomeScreenData implements java.io.Serializable {
    
    /** Creates a new instance of XurmoUserHomeScreenData */
    public XurmoUserHomeScreenData(String username, String cookie, int errorCode, String cellName, String fname, String lname, String salutation) {
        this.username = username;
        this.cookie = cookie;
        this.errorCode = errorCode;
        this.cellName = cellName;
        this.fname = fname;
        this.lname = lname;
        this.salutation = salutation;
    }
    public String username;
    public String cookie;
    public int errorCode;
    public String cellName;
    public String fname;
    public String lname;
    public String salutation;
}
