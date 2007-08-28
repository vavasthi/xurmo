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
 * @file   XurmoUserAuthenticationAndSessionStatus.java
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



public class XurmoUserAuthenticationAndSessionStatus {
  
  /**
   * Creates a new instance of XurmoUserAuthenticationAndSessionStatus
   */
  public XurmoUserAuthenticationAndSessionStatus(String cookie, int errorCode) {
    
    this.cookie = cookie;
    this.errorCode = errorCode;
  }
  private String cookie;
  private int errorCode;
}
