// =====================================================================
//                           Xurmo Proprietary
//               (c) Copyright 2007, Xurmo, All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          August 14, 2007
// =====================================================================

/**
 *
 * @file   XurmoLoginUserPanel.java
 * @author
 * @date   August 14, 2007
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

import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Command;

public class XurmoLoginUserPanel extends Form {
  
  private TextField username_;
  private TextField password_;
  Command login_;
  Command register_;
  Command exit_;
  
  
  /**
   * Creates a new instance of XurmoLoginUserPanel
   */
  public XurmoLoginUserPanel() {
    super("Sign in to Xurmo");
    username_ = new TextField("Username",null, 32, TextField.ANY);
    append(username_);
    password_ = new TextField("Password",null, 32, TextField.PASSWORD);
    append(password_);
    login_ = new Command("Sign in", Command.ITEM, 1);
    addCommand(login_);
    register_ = new Command("Sign Up", Command.ITEM, 2);
    addCommand(register_);
    exit_ = new Command("Exit", Command.EXIT, 1);
    addCommand(exit_);
  }
  public String getUsername() {
    return username_.getString();
  }
  public String getPassword() {
    return password_.getString();
  }
}
