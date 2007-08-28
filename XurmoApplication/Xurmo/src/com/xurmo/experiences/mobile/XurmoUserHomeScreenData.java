// =====================================================================
//                           Xurmo Proprietary
//               (c) Copyright 2007, Xurmo, All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          August 16, 2007
// =====================================================================

/**
 *
 * @file   XurmoUserHomeScreenData.java
 * @author
 * @date   August 16, 2007
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



public class XurmoUserHomeScreenData {
  
  /**
   * Creates a new instance of XurmoUserHomeScreenData
   */
  public XurmoUserHomeScreenData(XurmoUserAuthenticationReturnStatus status,
                               String fname,
                               String lname) {
    this.status = status;
    this.fname = fname;
    this.lname = lname;
    this.valid = true;
  }
  public XurmoUserHomeScreenData(String cookie, 
                               int errorCode, 
                               String cellName,
                               String fname,
                               String lname) {
    this.status = new XurmoUserAuthenticationReturnStatus(cookie, errorCode, cellName);
    this.fname = fname;
    this.lname = lname;
    this.valid = true;
  }
  
  public XurmoUserHomeScreenData() {
    this.status = new XurmoUserAuthenticationReturnStatus();
    this.valid = false;
  }
  public XurmoUserAuthenticationReturnStatus status;
  public String fname;
  public String lname;
  public boolean valid;
}
