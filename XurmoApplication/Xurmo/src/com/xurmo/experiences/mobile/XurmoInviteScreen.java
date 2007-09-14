// =====================================================================
//                           Xurmo Proprietary
//               (c) Copyright 2007, Xurmo, All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          April 25, 2007
// =====================================================================

/**
 *
 * @file   XurmoMyNetworksScreen.java
 * @author
 * @date   April 25, 2007
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

import javax.microedition.io.*;

public class XurmoInviteScreen extends XurmoScrollableScreen {
  /**
   * Creates a new instance of XurmoHomeScreen
   */
  public XurmoInviteScreen(Xurmo midlet) {
    super(midlet);
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    
    XurmoSelectablePanel p1 = new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2");
    p1.selected(true);
    currentPanel_ = 0;
    
    XurmoPanel[] panels = new XurmoSelectablePanel[] {
      p1,
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2"),
      new XurmoSelectablePanel(midlet, getWidth(), getHeight(), "Line1", "Line2")
    };
    panels_ = panels;
  }
  public void fireKey() {
    XurmoSelectablePanel xsp = (XurmoSelectablePanel)(panels_[currentPanel_]);
    if (xsp.ticked_) {
      xsp.ticked_ = false;
    } else {
      xsp.ticked_ = true;
    }
  }
  public void rightKey() {
  }
  public void leftKey() {
    midlet_.transitionToHomeScreen();
  }
  int ypos_;
}
