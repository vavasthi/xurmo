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

abstract public class XurmoScrollableScreen extends XurmoCanvas {
  /**
   * Creates a new instance of XurmoHomeScreen
   */
  public XurmoScrollableScreen(Xurmo midlet, XurmoPanel[] panels) {
    super(midlet, false);
    setFullScreenMode(true);
    panels_ = panels;
    currentPanel_ = 0;
  }
  public XurmoScrollableScreen(Xurmo midlet) {
    super(midlet, false);
    setFullScreenMode(true);
    panels_ = null;
    currentPanel_ = 0;
  }
  protected void setPanels(XurmoPanel[] panels) {
    panels_ = panels;
  }
  public void paint(javax.microedition.lcdui.Graphics g) {
    try {
      
      drawBackgroundGradient(g);
      drawTitle(g);
      int x = 0;
      int y = tbHeight_;
      int availableHeight = getHeight() - tbHeight_;
      int spanel = calculateStartingPanel(availableHeight);
      for (int i = spanel; i < panels_.length && y + panels_[i].h() < getHeight(); ++i) {
        panels_[i].draw(g, x, y);
        y += panels_[i].h();
      }
    } catch(NullPointerException npe) {
      npe.getMessage();
      npe.printStackTrace();
    }
  }
  private int calculateStartingPanel(int availableHeight) {
    for (int i = currentPanel_; i >= 0; --i) {
      availableHeight -= panels_[i].h();
      if (availableHeight < 0) {
        return i + 1;
      }
    }
    return 0;
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
  protected int currentPanel_;
  protected XurmoPanel[] panels_;
}
