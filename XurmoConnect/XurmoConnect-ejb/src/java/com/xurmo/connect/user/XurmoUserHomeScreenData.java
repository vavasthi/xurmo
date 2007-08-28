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
    public XurmoUserHomeScreenData(String cookie, int errorCode, String cellName, String fname, String lname, String salutation) {
        this.cookie = cookie;
        this.errorCode = errorCode;
        this.cellName = cellName;
        this.fname = fname;
        this.lname = lname;
        this.salutation = salutation;
    }
    String cookie;
    int errorCode;
    String cellName;
    String fname;
    String lname;
    String salutation;
}
