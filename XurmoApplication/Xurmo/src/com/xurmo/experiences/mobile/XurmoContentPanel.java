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

public class XurmoContentPanel extends XurmoPanel {
  
  /**
   * Creates a new instance of XurmoCollapsablePanel
   */
  public XurmoContentPanel(Xurmo midlet, XurmoMessageComposeScreen screen, int screenWidth, int screenHeight, Image icon, String title) {
    super(midlet, screenWidth, screenHeight);
    screen_ = screen;
    title_ = title;
    icon_ = icon;
    currentItemType_ = XurmoContentItem.STRING;
    currentItem_ = null;
    createNewItem();
    items_ = new Vector();
    selected(false);
  }
  protected void adjustHeights() {
    
    Font lf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    Font sf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    th_ = lf.getHeight();
    h_ = th_;
    if (selected()) {
      
      h_ += this.screenHeight() / 3;
    }
  }
  private void createNewItem() {
    
      if (currentItem_ != null && currentItem_.state_ == XurmoContentItem.DONE) {
        items_.addElement(currentItem_);
        currentItem_ = null;
      }
      switch(currentItemType_) {
        case XurmoContentItem.STRING:
        {
          if (currentItem_ == null || currentItem_.state_ == XurmoContentItem.DONE) {
            
            currentItem_ = new XurmoStringItem(screen_);
            System.out.println("Creating a new string item");
          }
        }
        case XurmoContentItem.AUDIO:
        {
          if (currentItem_ == null || currentItem_.state_ == XurmoContentItem.DONE) {
            
            currentItem_ = new XurmoAudioItem(screen_);
          }
        }
        case XurmoContentItem.IMAGE:
        {
          
          if (currentItem_ == null || currentItem_.state_ == XurmoContentItem.DONE) {
            currentItem_ = new XurmoImageItem(screen_);
          }
        }
      }
  }
  protected void drawBoundingBox(Graphics g, int x, int y) {
    
    adjustHeights();
    Font lf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    Font lif = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD | Font.STYLE_ITALIC, Font.SIZE_LARGE);
    Font sf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    int origY = y;
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    if (selected()) {
      
      g.setColor(ct.collapsablePanelSelectedTitleBackgroundValue_);
      g.fillRect(x, y, screenWidth_, th_);
      g.setColor(ct.collapsablePanelSelectedForegroundColorValue_);
      g.setFont(lf);
      g.drawString(title_, 0 , y, g.LEFT | g.TOP);
      g.drawString("[" + XurmoContentItem.contentType[this.currentItemType_] + "] Items :" + items_.size(), this.screenWidth_, y, g.RIGHT|g.TOP);
      y += lf.getHeight();
      g.setFont(sf);
    } else {
      g.setColor(ct.collapsablePanelUnselectedBackgroundColorValue_);
      g.drawRect(x, y, screenWidth_, h_);
      g.setColor(ct.collapsablePanelUnselectedForegroundColorValue_);
      g.setFont(lf);
      g.drawString(title_, 0 , y, g.LEFT | g.TOP);
    }
  }
  public void draw(Graphics g, int x, int y) {
    Font of = g.getFont();
    int oc = g.getColor();
    drawBoundingBox(g, x, y);
    if (selected() && currentItem_ != null) {
      
      currentItem_.draw(g, x, y + th_);
    }
    g.setColor(oc);
    g.setFont(of);
  }
  public void panelFireAction() {
    if (currentItem_ != null) {
      currentItem_.fireKey();
    }
  }
  public void rightKey() {
    switch(currentItemType_) {
      case XurmoContentItem.STRING:
        currentItemType_ = XurmoContentItem.AUDIO;
        break;
      case XurmoContentItem.AUDIO:
        currentItemType_ = XurmoContentItem.IMAGE;
        break;
      case XurmoContentItem.IMAGE:
        currentItemType_ = XurmoContentItem.STRING;
        break;
    }
    createNewItem();
  }
  public void leftKey() {
    switch(currentItemType_) {
      case XurmoContentItem.AUDIO:
        currentItemType_ = XurmoContentItem.STRING;
        break;
      case XurmoContentItem.IMAGE:
        currentItemType_ = XurmoContentItem.AUDIO;
        break;
      case XurmoContentItem.STRING:
        currentItemType_ = XurmoContentItem.IMAGE;
        break;
    }
    createNewItem();
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
  private int th_;
  private int h_;
  private String title_;
  private Vector items_;
  private Image icon_;
  private int currentItemType_;
  private XurmoContentItem currentItem_;
  private XurmoMessageComposeScreen screen_;
}
