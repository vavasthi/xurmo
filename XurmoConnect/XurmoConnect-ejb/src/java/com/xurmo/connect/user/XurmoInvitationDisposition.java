/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoInvitationDisposition.java
 * Created on               : March 30, 2007, 11:08 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoInvitationDisposition implements java.io.Serializable {
  
  public String requestFromUser;
  public String requestToUser;
  public int linkId;
  public String linkName;
  public String message;
  public int disposition;
  /** Creates a new instance of XurmoInvitationDisposition */
  public XurmoInvitationDisposition(String requestFromUser,
      String requestToUser,
      int linkId,
      String linkName,
      String message,
      int disposition) {
    
    this.requestFromUser = requestFromUser;
    this.requestToUser = requestToUser;
    this.linkId = linkId;
    this.linkName = linkName;
    this.message = message;
    this.disposition = disposition;
  }
  
  public static final int ACCEPT = 0x01;
  public static final int DECLINE = 0x02;
  public static final int DECLINE_SILENTLY = 0x03;
  public static final int POSTPONE = 0x04;
}
