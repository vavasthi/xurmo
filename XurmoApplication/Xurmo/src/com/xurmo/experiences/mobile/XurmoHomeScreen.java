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

public class XurmoHomeScreen extends XurmoTransitionableScreen {
  Xurmo midlet_;
  /**
   * Creates a new instance of XurmoHomeScreen
   */
  public XurmoHomeScreen(Xurmo midlet, int screenWidth, int screenHeight) {
    midlet_ = midlet;
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    
    me_ = new XurmoMePanel(midlet_, screenWidth, screenHeight, ct.meIconImage_, "Me");
    me_.selected(true);
    currentPanel_ = 0;
    
    mydoodles_ = new XurmoMyDoodlePanel(midlet_, screenWidth, screenHeight, ct.myplaceIconImage_, "My Doodles");
    
    interactions_ = new XurmoCollapsablePanel(screenWidth, screenHeight, ct.interactionIconImage_, "Interactions");
    
    friendsAndCommunity_ = new XurmoCollapsablePanel(screenWidth, screenHeight, ct.friendsSmallImage_, "Friends & Community");
    exit_ = new XurmoCollapsablePanel(screenWidth, screenHeight, ct.friendsSmallImage_, "Exit");
    
    panels_ = new XurmoCollapsablePanel[]{
      me_,
      mydoodles_,
      interactions_,
      friendsAndCommunity_,
      exit_
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
    if (panels_[currentPanel_] == exit_) {
      midlet_.exitMIDlet();
    }
  }
  int ypos_;
  private int currentPanel_;
  XurmoCollapsablePanel me_;
  XurmoCollapsablePanel mydoodles_;
  XurmoCollapsablePanel interactions_;
  XurmoCollapsablePanel friendsAndCommunity_;
  XurmoCollapsablePanel exit_;
  XurmoCollapsablePanel[] panels_;
}
