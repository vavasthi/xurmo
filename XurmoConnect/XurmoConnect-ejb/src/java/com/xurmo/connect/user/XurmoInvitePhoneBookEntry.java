/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoInvitePhoneBookEntry.java
 * Created on               : September 16, 2007, 2:33 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoInvitePhoneBookEntry {
  public int uniqueId;
  public String fname;
  public String lname;
  public String mobileNumber;
  /** Creates a new instance of XurmoInvitePhoneBookEntry */
  public XurmoInvitePhoneBookEntry(int uniqueId, String fname, String lname, String mobileNumber) {
    
    this.uniqueId = uniqueId;
    this.fname = fname;
    this.lname = lname;
    this.mobileNumber = mobileNumber;
  }
}
