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

public class XurmoMyNetworksScreen extends XurmoTransitionableScreen {
  Xurmo midlet_;
  /**
   * Creates a new instance of XurmoHomeScreen
   */
  public XurmoMyNetworksScreen(Xurmo midlet, int screenWidth, int screenHeight) {
    midlet_ = midlet;
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    
    contacts_ = new XurmoMePanel(midlet_, screenWidth, screenHeight, ct.meIconImage_, "My Contacts");
    contacts_.selected(true);
    currentPanel_ = 0;
    
    networks_ = new XurmoCollapsablePanel(screenWidth, screenHeight, ct.friendsSmallImage_, "Networks");
    home_ = new XurmoCollapsablePanel(screenWidth, screenHeight, ct.friendsSmallImage_, "Home");
    
    panels_ = new XurmoCollapsablePanel[]{
      contacts_,
      networks_,
      home_
    };
  }
  public void draw(javax.microedition.lcdui.Graphics g, int x, int y) {
    
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
  }
  int ypos_;
  private int currentPanel_;
  XurmoCollapsablePanel contacts_;
  XurmoCollapsablePanel networks_;
  XurmoCollapsablePanel home_;
  XurmoCollapsablePanel[] panels_;
}
