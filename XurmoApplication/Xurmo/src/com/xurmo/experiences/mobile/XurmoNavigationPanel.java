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

public class XurmoNavigationPanel extends XurmoPanel {
  
  /**
   * Creates a new instance of XurmoCollapsablePanel
   */
  public XurmoNavigationPanel(Xurmo midlet, XurmoCanvas current, XurmoCanvas left, int screenWidth, int screenHeight) {
    super(midlet, screenWidth, screenHeight);
    current_ = current;
    left_ = left;
    selected(false);
  }
  protected void adjustHeights() {
    
    Font lf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    Font sf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    h_ = lf.getHeight();
  }
  protected void drawBoundingBox(Graphics g, int x, int y) {
    
    adjustHeights();
    Font lf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    Font lif = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD | Font.STYLE_ITALIC, Font.SIZE_LARGE);
    Font sf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    int origY = y;
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    
    g.setColor(ct.collapsablePanelUnselectedBackgroundColorValue_);
    g.drawRect(x, y, screenWidth_, h_);
    g.setColor(ct.collapsablePanelUnselectedForegroundColorValue_);
    g.setFont(lf);
    g.drawImage(ct.arrowLeftImage_, x, y, g.LEFT | g.TOP);
  }
  public void draw(Graphics g, int x, int y) {
    Font of = g.getFont();
    int oc = g.getColor();
    drawBoundingBox(g, x, y);
    g.setColor(oc);
    g.setFont(of);
  }

  public void leftKey() {
      midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, current_, left_, XurmoSliderCanvas.LEFT));
  }
  public int w() {
    return w_;
  }
  public int h() {
    return h_;
  }
  public int screenWidth() {
    return screenWidth_;
  }
  public int screenHeight() {
    return screenHeight_;
  }
  private int h_;
  private XurmoCanvas current_;
  private XurmoCanvas left_;
}
