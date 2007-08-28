// =====================================================================
//                           Xurmo Proprietary
//               (c) Copyright 2007, Xurmo, All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          December 20, 2006
// =====================================================================

/**
 *
 * @file   XurmoCanvas.java
 * @author
 * @date   April 24, 2007
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

import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import java.io.*;


public class XurmoCanvas extends GameCanvas {
  Xurmo midlet_;
  /**
   * Creates a new instance of XurmoCanvas
   */
  public XurmoCanvas(Xurmo midlet) {
    super(false);
    midlet_ = midlet;
    int titleHeight = 0;
    Font f = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    titleHeight += f.getHeight();
    f = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    titleHeight += f.getHeight();
    XurmoThemeManager.init(this.getWidth(), this.getHeight(), titleHeight, this.getHeight() - titleHeight);
    tbHeight_ = XurmoThemeManager.instance().getCurrentTheme().backgroundTopImage_.getHeight();
    screens_ = new XurmoTransitionableScreeWithPosition[2];
    currentScreen_ = 0;
    oldScreen_ = 0;
    screens_[0] = new XurmoTransitionableScreeWithPosition(0, tbHeight_, new XurmoHomeScreen(midlet_, this.getWidth(), this.getHeight()));;
    screens_[1] = new XurmoTransitionableScreeWithPosition(0 + this.getWidth(), tbHeight_, new XurmoMainScreen(midlet_));
  }
  private void drawTitle(Graphics g) {
    g.drawImage(XurmoThemeManager.instance().getCurrentTheme().backgroundTopImage_, 0, 0, g.LEFT | g.TOP);
    int oc = g.getColor();
    g.setColor(XurmoThemeManager.instance().getCurrentTheme().titleForegroundColor_);
    Font f = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    g.setFont(f);
    int y = 0;
    g.drawString("Xurmo", this.getWidth() / 2, y, g.HCENTER | g.TOP);
    y += f.getHeight();
    f = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    g.setFont(f);
    g.drawString("hav u xperienced it yet?", this.getWidth() / 2, y, g.HCENTER | g.TOP);
    g.setColor(oc);
  }
  public void paint(Graphics g) {
    int oc = g.getColor();
    g.setColor(255,255,255);
    g.fillRect(0, 0, getWidth(), getHeight());
    g.setColor(oc);
    drawTitle(g);
    screens_[currentScreen_].draw(g);
  }
  public void keyPressed(int keyCode) {
    switch(getGameAction(keyCode)) {
      case DOWN:
        screens_[currentScreen_].screen_.downKey();
        break;
      case UP:
        screens_[currentScreen_].screen_.upKey();
        break;
      case FIRE:
        screens_[currentScreen_].screen_.fireKey();
        break;
      default:
        break;
    }
    repaint();
  }
  XurmoTransitionableScreeWithPosition[] screens_;
  private final int tbHeight_;
  int currentScreen_;
  int oldScreen_;
}
