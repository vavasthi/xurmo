// =====================================================================
//                           Xurmo Proprietary
//               (c) Copyright 2007, Xurmo, All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          August 9, 2007
// =====================================================================

/**
 *
 * @file   XurmoUserAuthenticationReturnStatus.java
 * @author
 * @date   August 9, 2007
 *
 * @brief
 *
 *
 */
// *********************************************************************
// Package
// *********************************************************************
package com.xurmo.experiences.mobile;
// *********************************************************************
// Imports
// *********************************************************************



public class XurmoUserAuthenticationReturnStatus {
  
  /**
   * Creates a new instance of XurmoUserAuthenticationReturnStatus
   */
  public XurmoUserAuthenticationReturnStatus(String cookie, int errorCode, String cellName) {
    cookie_ = cookie;
    errorCode_ = errorCode;
    cellName_ = cellName;
  }
  public XurmoUserAuthenticationReturnStatus() {
    cookie_ = "";
    errorCode_ = XurmoUserAuthenticationAndSessionWSInterface.USER_AUTHENTICATION_STATUS_SERVER_UNAVAILABLE;
    cellName_ = "Unknown";
  }
  String cookie_;
  int errorCode_;
  String cellName_;
}
