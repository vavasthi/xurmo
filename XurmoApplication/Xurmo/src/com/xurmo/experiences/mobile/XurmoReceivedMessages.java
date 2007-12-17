/*
 * XurmoMessageStatus.java
 *
 * Created on December 17, 2007, 6:58 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author Vinay
 */
public class XurmoReceivedMessages {
  
  /**
   * Creates a new instance of XurmoMessageStatus
   */
  public XurmoReceivedMessages(String cookie, int errorCode, String cellName, XurmoMessage messages[]) {
    cookie_ = cookie;
    errorCode_ = errorCode;
    cellName_ = cellName;
    messages_ = messages;
  }
  public static XurmoReceivedMessages create(String cookie, 
      int errorCode, 
      String cellName, 
      java.util.Vector messages) {
    XurmoMessage[] msgs = new XurmoMessage[messages.size()];
    for (int i = 0; i < messages.size(); ++i) {
      msgs[i] = (XurmoMessage)(messages.elementAt(i));
    }
    return new XurmoReceivedMessages(cookie, errorCode, cellName, msgs);
  }
  public XurmoReceivedMessages() {
    cookie_ = "";
    errorCode_ = XurmoMessageManagementWSInterface.MESSAGE_INTERACTION_SERVER_NOT_AVAILABLE;
    cellName_ = "Unknown";
    messages_ = null;
  }
  String cookie_;
  int errorCode_;
  String cellName_;
  XurmoMessage[] messages_;
}
