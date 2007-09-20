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
  java.util.Vector invitableEntries_;
  /**
   * Creates a new instance of XurmoHomeScreen
   */
  public XurmoInviteScreen(Xurmo midlet, java.util.Vector invitableEntries) {
    super(midlet);
    invitableEntries_ = invitableEntries;
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    XurmoPanel[] panels = new XurmoPanel[invitableEntries_.size()];
    currentPanel_ = 0;
    for (int i = 0; i < invitableEntries_.size(); ++i) {
      XurmoInvitePhoneBookEntry pbe = (XurmoInvitePhoneBookEntry)(invitableEntries_.elementAt(i));
      panels[i] = new XurmoSelectablePanel(midlet, getWidth(), getHeight(), pbe.contactName, pbe.mobileNumber);
    }    
    panels_ = panels;
    panels_[currentPanel_].selected(true);
  }
  public void fireKey() {
    if (panels_[currentPanel_] instanceof XurmoSelectablePanel) {
      
      XurmoSelectablePanel xsp = (XurmoSelectablePanel)(panels_[currentPanel_]);
      if (xsp.ticked_) {
        xsp.ticked_ = false;
      } else {
        xsp.ticked_ = true;
      }
    }
  }
  public void rightKey() {
    System.out.println("Right key called with currentPanel =" + currentPanel_);
    if (panels_[currentPanel_] instanceof XurmoNumberSliderPanel) {
      XurmoNumberSliderPanel xnsp = (XurmoNumberSliderPanel)(panels_[currentPanel_]);
      xnsp.increment();
    }
  }
  public void leftKey() {
    System.out.println("Left key called with currentPanel =" + currentPanel_);
    if (panels_[currentPanel_] instanceof XurmoNumberSliderPanel) {
      XurmoNumberSliderPanel xnsp = (XurmoNumberSliderPanel)(panels_[currentPanel_]);
      xnsp.decrement();
    } else {
      
      midlet_.transitionToHomeScreen();
    }
  }
  int ypos_;
}
