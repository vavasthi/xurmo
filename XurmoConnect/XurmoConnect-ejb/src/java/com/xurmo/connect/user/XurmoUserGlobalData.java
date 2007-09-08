/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserGlobalData.java
 * Created on               : March 28, 2007, 4:58 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import bsh.This;

/**
 *
 * @author xurmo
 */
public class XurmoUserGlobalData implements java.io.Serializable {
    
    public int userid;
    public String username;
    public String fname;
    public String lname;
    /** Creates a new instance of XurmoUserGlobalData */
    public XurmoUserGlobalData(int userid, String username, String fname, String lname) {
        this.userid = userid;
        this.username = username;
        this.fname = fname;
        this.lname = lname;
    }
}
