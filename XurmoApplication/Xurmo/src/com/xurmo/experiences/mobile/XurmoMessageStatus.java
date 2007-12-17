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
public class XurmoMessageStatus {
  
  /**
   * Creates a new instance of XurmoMessageStatus
   */
  public XurmoMessageStatus(String cookie, int errorCode, String cellName) {
    cookie_ = cookie;
    errorCode_ = errorCode;
    cellName_ = cellName;
  }
  public XurmoMessageStatus() {
    cookie_ = "";
    errorCode_ = XurmoMessageManagementWSInterface.MESSAGE_INTERACTION_SERVER_NOT_AVAILABLE;
    cellName_ = "Unknown";
  }
  String cookie_;
  int errorCode_;
  String cellName_;
}
