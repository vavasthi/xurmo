// =====================================================================
//                           Xurmo Proprietary
//               (c) Copyright 2007, Xurmo, All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          August 23, 2007
// =====================================================================

/**
 *
 * @file   XurmoCurrentUser.java
 * @author
 * @date   August 23, 2007
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



public class XurmoCurrentUser {
  
  /**
   * Creates a new instance of XurmoCurrentUser
   */
  public XurmoCurrentUser() {
    username_ = null;
    password_ = null;
    cookie_ = null;
    cellName_ = null;
    loggedIn_ = false;
  }
  public XurmoCurrentUser(String username, String password, String cookie, String cellName) {
    username_ = username;
    password_ = password;
    cookie_ = cookie;
    cellName_ = cellName;
    loggedIn_ = true;
  }
  public void invalidate() {
    
    username_ = null;
    password_ = null;
    cookie_ = null;
    cellName_ = null;
    loggedIn_ = false;
  }
  public void loggedIn(String username, String password, String cookie, String cellName) {
    
    username_ = username;
    password_ = password;
    cookie_ = cookie;
    cellName_ = cellName;
    loggedIn_ = true;
  }
  public void setUsernameAndPassword(String username, String password) {
    
    username_ = username;
    password_ = password;
    cookie_ = null;
    cellName_ = null;
    loggedIn_ = false;
  }
  boolean loggedIn_;
  String username_;
  String password_;
  String cookie_;
  String cellName_;
}
