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
 * @file   XurmoCollapsablePanel.java
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
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import java.util.Vector;

abstract public class XurmoPanel {
  Xurmo midlet_;
  /**
   * Creates a new instance of XurmoCollapsablePanel
   */
  public XurmoPanel(Xurmo midlet, int screenWidth, int screenHeight) {
    w_ = screenWidth;
    screenWidth_ = screenWidth;
    screenHeight_ = screenHeight;
    midlet_ = midlet;
    selected_ = false;
    menu_ = null;
  }
  abstract protected void adjustHeights();
  abstract public void draw(Graphics g, int x, int y);
  abstract public int h();
  public void drawMenuIfActive(Graphics g, int x, int y) {
    if (isMenuActive()) {
      
      menu_.draw(g, x, y);
    }
  }
  public void setMenu(XurmoPopupMenu menu) {
    menu_ = menu;
  }
  public int w() {
    return w_;
  }
  public int screenWidth() {
    return screenWidth_;
  }
  public int screenHeight() {
    return screenHeight_;
  }
  public void selected(boolean flag) {
    selected_ = flag;
    adjustHeights();
  }
  public boolean selected() {
    return selected_;
  }
  public boolean isMenuAvailable() {
    return menu_ != null;
  }
  public boolean isMenuActive() {
    return menu_ != null && menu_.visible_;
  }
  public void activateMenu() {
    if (menu_ != null) {
      menu_.show();
    }
  }
  public void deactivateMenu() {
    if (menu_ != null) {
      
      menu_.hide();
    }
  }
  public XurmoPopupMenu menu() {
    return menu_;
  }
  public void fireKey() {
    
    if (isMenuAvailable()) {
      if (isMenuActive()) {
        menu().fireKey();
      } else {
        
        activateMenu();
      }
    } else {
      // Some other default action.
      panelFireAction();
    }
  }
  public void panelFireAction() {
    
  }
  public void leftKey() {
    
  }
  public void rightKey() {
    
  }
  private boolean selected_;
  protected int w_;
  protected int screenWidth_;
  protected int screenHeight_;
  private XurmoPopupMenu menu_;
}