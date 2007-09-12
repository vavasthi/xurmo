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
    super(midlet, new XurmoCollapsablePanel[5]);
    XurmoThemeManager.init(midlet);
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    me_ = new XurmoMePanel(midlet_, getWidth(), getHeight(), ct.meIconImage_, "Me");
    me_.selected(true);
    mydoodles_ = new XurmoMyDoodlePanel(midlet_, getWidth(), getHeight(), ct.myplaceIconImage_, "My Doodles");
    
    interactions_ = new XurmoCollapsablePanel(getWidth(), getHeight(), ct.interactionIconImage_, "Interactions");
    
    friendsAndCommunity_ = new XurmoCollapsablePanel(getWidth(), getHeight(), ct.friendsSmallImage_, "Friends & Community");
    exit_ = new XurmoCollapsablePanel(getWidth(), getHeight(), ct.friendsSmallImage_, "Exit");
    
    panels_[0] = me_;
    panels_[1] = mydoodles_;
    panels_[2] = interactions_;
    panels_[3] = friendsAndCommunity_;
    panels_[4] = exit_;
    repaint();
  }
  public void fireKey() {
    if (panels_[currentPanel_] == exit_) {
      midlet_.exitMIDlet();
    }
  }
  public void rightKey() {
    if (panels_[currentPanel_] == this.me_) {
      midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, this, new XurmoMeScreen(midlet_), XurmoSliderCanvas.RIGHT));
    }
    else if (panels_[currentPanel_] == this.interactions_) {
      midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, this, new XurmoInteractionsScreen(midlet_), XurmoSliderCanvas.RIGHT));
    }
    else if (panels_[currentPanel_] == this.friendsAndCommunity_) {
      midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, this, new XurmoMyNetworksScreen(midlet_), XurmoSliderCanvas.RIGHT));
    }
  }
  public void leftKey() {
  }
  XurmoCollapsablePanel me_;
  XurmoCollapsablePanel mydoodles_;
  XurmoCollapsablePanel interactions_;
  XurmoCollapsablePanel friendsAndCommunity_;
  XurmoCollapsablePanel exit_;
}
