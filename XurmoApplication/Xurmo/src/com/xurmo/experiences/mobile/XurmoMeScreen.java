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

public class XurmoMeScreen extends XurmoCanvas {
  /**
   * Creates a new instance of XurmoHomeScreen
   */
  public XurmoMeScreen(Xurmo midlet) {
    super(midlet, false);
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    
    presence_ = new XurmoMyPresencePanel(midlet_, getWidth(), getHeight(), ct.meIconImage_, "My Presence");
    presence_.selected(true);
    currentPanel_ = 0;
    
    contacts_ = new XurmoNetworkSummaryPanel(midlet_, getWidth(), getHeight(), ct.meIconImage_, "My Contacts");

    home_ = new XurmoCollapsablePanel(midlet_, getWidth(), getHeight(), ct.friendsSmallImage_, "Home");
    
    panels_ = new XurmoCollapsablePanel[]{
      presence_,
      contacts_,
      home_
    };
  }
  public void paint(javax.microedition.lcdui.Graphics g) {
    drawBackgroundGradient(g);
    drawTitle(g);
    int x = 0;
    int y = tbHeight_;    
    for (int i = 0; i < panels_.length; ++i) {
      panels_[i].draw(g, x, y);
      y += panels_[i].h();
    }
/*    me_.draw(g, x, y);
    y += me_.h();
    mydoodles_.draw(g, x, y);
    y += mydoodles_.h();
    interactions_.draw(g, x, y);
    y += interactions_.h();
    friendsAndCommunity_.draw(g, x, y);
    y += friendsAndCommunity_.h();*/
  }
  public void downKey() {
    panels_[currentPanel_].selected(false);
    ++currentPanel_;
    if (currentPanel_ >= panels_.length) {
      currentPanel_ = 0;
    }
    panels_[currentPanel_].selected(true);
  }
  public void upKey() {
    
    panels_[currentPanel_].selected(false);
    --currentPanel_;
    if (currentPanel_ < 0) {
      currentPanel_ = panels_.length - 1;
    }
    panels_[currentPanel_].selected(true);
  }
  public void fireKey() {
    if (panels_[currentPanel_] == home_) {
      midlet_.transitionToHomeScreen();
    }
    else if (panels_[currentPanel_] == presence_) {
      midlet_.getDisplay().setCurrent(new XurmoPresenceEdit(this,"Editing Presence", midlet_.getHomeScreenData().presence));
    }
    else if (panels_[currentPanel_] == contacts_) {
      midlet_.uploadPhonebook();
    }
  }
  public void rightKey() {
  }
  public void leftKey() {
    midlet_.transitionToHomeScreen();
  }
  public void updatePresence(String presence) {
    midlet_.currentUser_.presence_ = presence;
    midlet_.updateHomeScreenData();
    midlet_.getDisplay().setCurrent(this);
  }
  public void cancelPresenceEdit() {
    midlet_.getDisplay().setCurrent(this);
  }
  int ypos_;
  private int currentPanel_;
  XurmoCollapsablePanel presence_;
  XurmoCollapsablePanel contacts_;
  XurmoCollapsablePanel home_;
  XurmoCollapsablePanel[] panels_;
}
