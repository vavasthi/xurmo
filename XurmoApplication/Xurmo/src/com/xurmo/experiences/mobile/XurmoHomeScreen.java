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

public class XurmoHomeScreen extends XurmoCanvas {
  /**
   * Creates a new instance of XurmoHomeScreen
   */
  public XurmoHomeScreen(Xurmo midlet) {
    super(midlet, false);
    setFullScreenMode(true);
    XurmoThemeManager.init(midlet);
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    
    me_ = new XurmoMePanel(midlet_, getWidth(), getHeight(), ct.meIconImage_, "Me");
    me_.selected(true);
    currentPanel_ = 0;
    
    mydoodles_ = new XurmoMyDoodlePanel(midlet_, getWidth(), getHeight(), ct.myplaceIconImage_, "My Doodles");
    
    interactions_ = new XurmoCollapsablePanel(getWidth(), getHeight(), ct.interactionIconImage_, "Interactions");
    
    friendsAndCommunity_ = new XurmoCollapsablePanel(getWidth(), getHeight(), ct.friendsSmallImage_, "Friends & Community");
    exit_ = new XurmoCollapsablePanel(getWidth(), getHeight(), ct.friendsSmallImage_, "Exit");
    
    panels_ = new XurmoCollapsablePanel[]{
      me_,
      mydoodles_,
      interactions_,
      friendsAndCommunity_,
      exit_
    };
    repaint();
  }
  public void paint(javax.microedition.lcdui.Graphics g) {
    try {
      
    drawBackgroundGradient(g);
    drawTitle(g);
    int x = 0;
    int y = tbHeight_;
    for (int i = 0; i < panels_.length; ++i) {
      panels_[i].draw(g, x, y);
      y += panels_[i].h();
    }
    }
    catch(NullPointerException npe) {
      npe.getMessage();
      npe.printStackTrace();
    }
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
  public void keyPressed(int keyCode) {
    switch(getGameAction(keyCode)) {
      case DOWN:
        downKey();
        break;
      case UP:
        upKey();
        break;
      case FIRE:
        fireKey();
        break;
      case RIGHT:
      {
          midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, this, new XurmoMyNetworksScreen(midlet_), XurmoSliderCanvas.RIGHT));
      }        
        break;
      case LEFT:
      {
          midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, this, this, XurmoSliderCanvas.LEFT));
      }        
        break;
      default:
        break;
    }
    repaint();
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
