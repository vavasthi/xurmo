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

public class XurmoCollapsablePanel extends XurmoPanel {
  
  /**
   * Creates a new instance of XurmoCollapsablePanel
   */
  public XurmoCollapsablePanel(Xurmo midlet, int screenWidth, int screenHeight, Image icon, String title) {
    super(midlet, screenWidth, screenHeight);
    
    icon_ = icon;
    title_ = title;
    content_ = new Vector();
    selected(false);
  }
  public void addContent(String str) {
    content_.addElement(str);
  }
  protected void adjustHeights() {
    
    Font lf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    Font sf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    th_ = Math.max(lf.getHeight(), icon_.getHeight());
    h_ = th_;
    if (selected()) {
      
      h_ += 3 * sf.getHeight();
    }
  }
  public int h() {
    return h_;
  }
  protected void drawBoundingBox(Graphics g, int x, int y) {
    
    Font lf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    Font sf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    if (selected()) {
      g.setColor(ct.collapsablePanelSelectedTitleBackgroundValue_);
      g.drawRect(x, y, screenWidth_, h_);
      g.setColor(ct.collapsablePanelSelectedContentBackgroundColorValue_);
      g.fillRect(x, y,screenWidth_, h_ );
      g.setColor(ct.collapsablePanelSelectedTitleBackgroundValue_);
      g.fillRect(x, y,screenWidth_, th_ );
      g.setColor(ct.collapsablePanelSelectedForegroundColorValue_);
      g.drawImage(icon_, x + 1, y, g.LEFT | g.TOP);
      int w = icon_.getWidth();
      g.setFont(lf);
      g.drawString(title_, 40 , y, g.LEFT | g.TOP);
      y += th_;
      g.setFont(sf);
      for (int i = 0; i < content_.size() && i < 2; ++i) {
        
        g.drawString((String)(content_.elementAt(i)), 0, y, g.LEFT | g.TOP);
        y += sf.getHeight();
      }
    }
    else {
//      g.setColor(ct.collapsablePanelUnselectedBackgroundColorValue_);
//      g.fillRect(x, y, screenWidth_, th_);
      g.setColor(ct.collapsablePanelUnselectedForegroundColorValue_);
      g.drawImage(icon_, x + 1, y, g.LEFT | g.TOP);
      int w = icon_.getWidth();
      g.setFont(lf);
      g.drawString(title_, 40 , y, g.LEFT | g.TOP);
    }
  }
  public void draw(Graphics g, int x, int y) {
    Font of = g.getFont();
    int oc = g.getColor();
    drawBoundingBox(g, x, y);
    g.setColor(oc);
    g.setFont(of);
  }
    
  protected int th_;
  protected int h_;
  protected Image icon_;
  protected String title_;
  protected Vector content_;
}
