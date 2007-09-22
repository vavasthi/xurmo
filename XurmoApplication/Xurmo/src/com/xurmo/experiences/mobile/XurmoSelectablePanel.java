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

public class XurmoSelectablePanel extends XurmoPanel {
  
  /**
   * Creates a new instance of XurmoCollapsablePanel
   */
  public XurmoSelectablePanel(Xurmo midlet, int screenWidth, int screenHeight, String line1, String line2) {
    super(midlet, screenWidth, screenHeight);
    line1_ = line1;
    line2_ = line2;
    ticked_ = false;
    selected(false);
  }
  protected void adjustHeights() {
    
    Font lf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    Font sf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    h_ = lf.getHeight() + sf.getHeight();
  }
  protected void drawBoundingBox(Graphics g, int x, int y) {
    
    Font lf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    Font sf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    int origY = y;
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    String s = additionalText();
    if (selected()) {
      g.setColor(ct.collapsablePanelSelectedTitleBackgroundValue_);
      g.drawRect(x, y, screenWidth_, h_);
      g.setColor(ct.collapsablePanelSelectedForegroundColorValue_);
      g.setFont(lf);
      g.drawString(line1_, 0 , y, g.LEFT | g.TOP);
      y += lf.getHeight();
      g.setFont(sf);
      g.drawString(line2_, 0 , y, g.LEFT | g.TOP);    
      if(s != null) {
        g.drawString(s, screenWidth_, y, g.RIGHT | g.TOP);
      }
    }
    else {
      g.setColor(ct.collapsablePanelUnselectedBackgroundColorValue_);
      g.drawRect(x, y, screenWidth_, h_);
      g.setColor(ct.collapsablePanelUnselectedForegroundColorValue_);
      g.setFont(lf);
      g.drawString(line1_, 0 , y, g.LEFT | g.TOP);
      y += lf.getHeight();
      g.setFont(sf);
      g.drawString(line2_, 0 , y, g.LEFT | g.TOP);    
      if(s != null) {
        g.drawString(s, screenWidth_, y, g.RIGHT | g.TOP);
      }
    }
    if (ticked_) {
      g.drawImage(ct.checkmarkImage_, 0, y, Graphics.LEFT | Graphics.BOTTOM);
    }
  }
  public void draw(Graphics g, int x, int y) {
    Font of = g.getFont();
    int oc = g.getColor();
    drawBoundingBox(g, x, y);
    g.setColor(oc);
    g.setFont(of);
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
  public String additionalText() {
    return null;
  }
  public void clear() {
    
  }
  private int h_;
  protected boolean ticked_;
  private String line1_;
  private String line2_;
}
