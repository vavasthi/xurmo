/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoNetworkRequestToConnectMessage.java
 * Created on               : September 23, 2007, 1:53 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoNetworkRequestToConnectMessage implements java.io.Serializable {
  
  public int requestFrom;
  public String usernameFrom;
  public int requestTo;
  public String usernameTo;
  public int messageId;
  public int linkId;
  public String linkName;
  public String msg;

    /** Creates a new instance of XurmoNetworkRequestToConnectMessage */
  public XurmoNetworkRequestToConnectMessage(int requestFrom, 
      String usernameFrom, 
      int requestTo, 
      String usernameTo, 
      int messageId, 
      int linkId,
      String linkName,
      String msg) {
    this.requestFrom = requestFrom;
    this.usernameFrom = usernameFrom;
    this.requestTo = requestTo;
    this.usernameTo = usernameTo;
    this.messageId = messageId;
    this.linkId = linkId;
    this.linkName = linkName;
    this.msg = msg;
  }
}
