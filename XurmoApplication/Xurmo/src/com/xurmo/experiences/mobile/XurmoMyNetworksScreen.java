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

public class XurmoMyNetworksScreen extends XurmoCanvas {
  /**
   * Creates a new instance of XurmoHomeScreen
   */
  public XurmoMyNetworksScreen(Xurmo midlet) {
    super(midlet, false);
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    
    summary_ = new XurmoNetworkSummaryPanel(midlet_, getWidth(), getHeight(), ct.meIconImage_, "Network Summary");
    summary_.selected(true);
    currentPanel_ = 0;
    
    contacts_ = new XurmoCollapsablePanel(midlet_, getWidth(), getHeight(), ct.meIconImage_, "My Contacts");

    otherSocialNetworks_ = new XurmoCollapsablePanel(midlet_, getWidth(), getHeight(), ct.friendsSmallImage_, "Other Social Networks");
    invite_ = new XurmoCollapsablePanel(midlet_, getWidth(), getHeight(), ct.friendsSmallImage_, "Invite");
    home_ = new XurmoCollapsablePanel(midlet_, getWidth(), getHeight(), ct.friendsSmallImage_, "Home");
    
    panels_ = new XurmoCollapsablePanel[]{
      summary_,
      contacts_,
      invite_,
      otherSocialNetworks_,
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
  }
  public void rightKey() {
    if (panels_[currentPanel_] == otherSocialNetworks_) {
      midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, this, new XurmoMySocialNetworksScreen(midlet_), XurmoSliderCanvas.RIGHT));      
    }
    else if (panels_[currentPanel_] == invite_) {
      midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, this, new XurmoMyInvitationsScreen(midlet_), XurmoSliderCanvas.RIGHT));      
    }
  }
  public void leftKey() {
    midlet_.transitionToHomeScreen();
  }
  int ypos_;
  private int currentPanel_;
  XurmoCollapsablePanel summary_;
  XurmoCollapsablePanel contacts_;
  XurmoCollapsablePanel invite_;
  XurmoCollapsablePanel otherSocialNetworks_;
  XurmoCollapsablePanel home_;
  XurmoCollapsablePanel[] panels_;
}
