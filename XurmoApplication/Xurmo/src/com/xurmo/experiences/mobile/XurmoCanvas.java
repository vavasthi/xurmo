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
  public XurmoCanvas(Xurmo midlet, boolean flag) {
    super(flag);
    midlet_ = midlet;
    int titleHeight = 0;
    Font f = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    titleHeight += f.getHeight();
    f = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    titleHeight += f.getHeight();
    tbHeight_ = XurmoThemeManager.instance().getCurrentTheme().backgroundTopImage_.getHeight();
    screens_ = new XurmoTransitionableScreeWithPosition[2];
    currentScreen_ = 0;
    oldScreen_ = 0;
    screens_[0] = new XurmoTransitionableScreeWithPosition(0, tbHeight_, new XurmoHomeScreen(midlet_, this.getWidth(), this.getHeight()));;
    screens_[1] = new XurmoTransitionableScreeWithPosition(0 + this.getWidth(), tbHeight_, new XurmoMainScreen(midlet_));
  }
  protected void drawBackgroundGradient(Graphics g) {
    int oc = g.getColor();
    int sColor = XurmoThemeManager.instance().getCurrentTheme().gradientStartColor_;
    int eColor = XurmoThemeManager.instance().getCurrentTheme().gradientEndColor_;
    int sr = (sColor & 0xff0000) >> 16;
    int sg = (sColor & 0x00ff00) >> 8;
    int sb = sColor & 0x0000ff;
    
    int er = (eColor & 0xff0000) >> 16;
    int eg = (eColor & 0x00ff00) >> 8;
    int eb = eColor & 0x0000ff;
    
    int rDelta = (er - sr)*100 / this.getHeight();
    int gDelta = (eg - sg)*100 / this.getHeight();
    int bDelta = (eb - sb)*100 / this.getHeight();
    sr = sr * 100;
    sg = sg * 100;
    sb = sb * 100;
    for (int i = 0; i < getHeight(); ++i) {
      int cr = (sr + (i * rDelta))/100;
      int cg = (sg + (i * gDelta))/100;
      int cb = (sb + (i * bDelta))/100;
      g.setColor(cr, cg, cb);
        g.drawLine(0, i, getWidth(), i);
    }
    g.setColor(oc);
  }
  protected void drawTitle(Graphics g) {
//    g.drawImage(XurmoThemeManager.instance().getCurrentTheme().backgroundTopImage_, 0, 0, g.LEFT | g.TOP);
    g.drawImage(XurmoThemeManager.instance().getCurrentTheme().titlebarLogo_, 0, 0, g.LEFT | g.TOP);
    Font sf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    g.setFont(sf);
    g.drawString(XurmoDevice.defaultTimeZone_, this.getWidth(), 0, g.RIGHT | g.TOP);
    int oc = g.getColor();
    g.setColor(XurmoThemeManager.instance().getCurrentTheme().titleForegroundColor_);
    Font f = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    g.setFont(f);
    int y = 0;
    f = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    g.setFont(f);
    g.drawString("xtend ur mobile!", this.getWidth() / 2, y, g.HCENTER | g.TOP);
    g.setColor(oc);
  }
  public void paint(Graphics g) {
    this.drawBackgroundGradient(g);
//    int oc = g.getColor();
//    g.setColor(255,255,255);
//    g.fillRect(0, 0, getWidth(), getHeight());
//    g.setColor(oc);
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
      case RIGHT:
      {
          XurmoUserAuthenticationAndSessionWSInterface.instance().uploadPhoneBook(midlet_.currentUser_.username_, midlet_.currentUser_.cookie_);
          midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, this, this, XurmoSliderCanvas.RIGHT));
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
  XurmoTransitionableScreeWithPosition[] screens_;
  protected final int tbHeight_;
  int currentScreen_;
  int oldScreen_;
}
