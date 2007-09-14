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
  }
  abstract protected void adjustHeights();
  abstract public void draw(Graphics g, int x, int y);  
  abstract public int h();
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
  private boolean selected_;
  protected int w_;
  protected int screenWidth_;
  protected int screenHeight_; 
}