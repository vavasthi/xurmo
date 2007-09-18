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
  public boolean member;
  public int memberid;
  public String contactName;
  public String mobileNumber;
  /** Creates a new instance of XurmoInvitePhoneBookEntry */
  public XurmoInvitePhoneBookEntry(int uniqueId, boolean member, int memberid, String contactName, String mobileNumber) {
    
    this.uniqueId = uniqueId;
    this.member = member;
    this.memberid = memberid;
    this.contactName = contactName;
    this.mobileNumber = mobileNumber;
  }
}
