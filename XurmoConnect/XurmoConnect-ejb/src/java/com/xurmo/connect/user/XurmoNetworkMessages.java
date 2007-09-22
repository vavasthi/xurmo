/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoNetworkMessages.java
 * Created on               : September 23, 2007, 1:57 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import bsh.This;

/**
 *
 * @author xurmo
 */
public class XurmoNetworkMessages implements java.io.Serializable {
  public XurmoNetworkInteractionStatus status;
  public XurmoNetworkRequestToConnectMessage[] requestToConnect;
  public XurmoRequestToConnectResponseType[] responseType;
  /** Creates a new instance of XurmoNetworkSummaryStatus */
  public XurmoNetworkMessages(String cookie, String cellName, XurmoNetworkRequestToConnectMessage[] requestToConnect, XurmoRequestToConnectResponseType[] responseType) {
    this.status = new XurmoNetworkInteractionStatus(cookie, cellName);
    this.requestToConnect = requestToConnect;
    this.responseType = responseType;
  }
  public XurmoNetworkMessages(int error, String cookie, String cellName) {
    this.status = new XurmoNetworkInteractionStatus(error, cookie, cellName);
    this.requestToConnect = new XurmoNetworkRequestToConnectMessage[0];
    this.responseType = new XurmoRequestToConnectResponseType[0]; 
  }
}
