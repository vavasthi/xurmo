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
 * @file   XurmoHomeScreen.java
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

public class XurmoHomeScreen extends XurmoScrollableScreen {
  /**
   * Creates a new instance of XurmoHomeScreen
   */
  public XurmoHomeScreen(Xurmo midlet) {
    super(midlet, new XurmoCollapsablePanel[3]);
    XurmoThemeManager.init(midlet);
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    me_ = new XurmoMePanel(midlet_, this, getWidth(), getHeight(), ct.meIconImage_, "Me");
    me_.selected(true);
    network_ = new XurmoNetworkPanel(midlet_, this, getWidth(), getHeight(), ct.friendsSmallImage_, "Network");
    exit_ = new XurmoCollapsablePanel(midlet_, getWidth(), getHeight(), ct.friendsSmallImage_, "Exit");
    
    panels_[0] = me_;
    panels_[1] = network_;
    panels_[2] = exit_;
    repaint();
  }
  public void fireKey() {
    if (panels_[currentPanel_] == exit_) {
      midlet_.exitMIDlet();
    }
    else {
      defaultFireKey();
    }
  }
  public void rightKey() {
    if (panels_[currentPanel_] == this.me_) {
//      midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, this, new XurmoMeScreen(midlet_), XurmoSliderCanvas.RIGHT));
    }
    else if (panels_[currentPanel_] == this.network_) {
      midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, this, new XurmoMyNetworksScreen(midlet_), XurmoSliderCanvas.RIGHT));
    }
  }
  public void updatePresence(String presence) {
    midlet_.currentUser_.presence_ = presence;
    repaint();
    midlet_.updateHomeScreenData();
    midlet_.getDisplay().setCurrent(this);
  }
  public void cancelPresenceEdit() {
    midlet_.getDisplay().setCurrent(this);
  }

  XurmoCollapsablePanel me_;
  XurmoCollapsablePanel network_;
  XurmoCollapsablePanel exit_;
}
