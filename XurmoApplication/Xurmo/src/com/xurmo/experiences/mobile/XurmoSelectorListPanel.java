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

public class XurmoSelectorListPanel extends XurmoCollapsablePanel {
  
  /**
   * Creates a new instance of XurmoCollapsablePanel
   */
  public XurmoSelectorListPanel(Xurmo midlet, int screenWidth, int screenHeight, Image icon, String title, String[] listOfItems) {
    super(midlet, screenWidth, screenHeight, icon, title);
    listOfItems_ = listOfItems;
    selectionFlag_ = new boolean[listOfItems_.length];
    currentItem_ = 0;
    selected(false);
  }
  protected void adjustHeights() {
    
    Font lf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    Font sf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    th_ = lf.getHeight();
    h_ = th_;
    if (selected()) {
      
      h_ += sf.getHeight();
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
      y += lf.getHeight();
      g.setFont(sf);
      int si = this.renderFromItem(g);
      int xpos = 0;
      for (int i = si; i < listOfItems_.length; ++i) {
        int cw = sf.stringWidth(listOfItems_[i]);
        if (i == currentItem_) {
          
          g.setColor(ct.collapsablePanelSelectedTitleBackgroundValue_);
          g.fillRect(xpos, y, cw, sf.getHeight());
          g.setColor(ct.collapsablePanelSelectedForegroundColorValue_);
          g.drawString(listOfItems_[i], xpos, y, g.LEFT | g.TOP);
        } else {
          
          g.setColor(ct.collapsablePanelUnselectedBackgroundColorValue_);
          g.drawRect(xpos, y, cw, sf.getHeight());
          g.setColor(ct.collapsablePanelUnselectedForegroundColorValue_);
          g.drawString(listOfItems_[i], xpos, y, g.LEFT | g.TOP);
        }
        if (selectionFlag_[i]) {
          g.drawImage(ct.checkmarkImage_, xpos, y, g.LEFT | g.TOP);
        }
        xpos += cw + 2;
      }
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
    g.setColor(oc);
    g.setFont(of);
  }
  public void rightKey() {
    if (currentItem_ < listOfItems_.length - 1) {
      ++currentItem_;
    } else {
      currentItem_ = 0;
    }
  }
  public void leftKey() {
    if (currentItem_ > 0) {
      --currentItem_;
    } else {
      currentItem_ = listOfItems_.length - 1;
    }
  }
  public void panelFireAction() {
    if (selectionFlag_[currentItem_]) {
      selectionFlag_[currentItem_] = false;
    }
    else {
      
      selectionFlag_[currentItem_] = true;
      rightKey();
    }
  }
  public String[] getSelectedValues() {
    
    int kount = 0;
    for (int i = 0; i < selectionFlag_.length; ++i) {
      if (selectionFlag_[i]) {
        ++kount;
      }
    }
    String[] out = new String[kount];
    int j = 0;
    for (int i = 0; i < selectionFlag_.length; ++i) {
      if (selectionFlag_[i]) {
        out[j] = listOfItems_[i];
        ++j;
      }
    }
    return out;
  }
  private int renderFromItem(Graphics g) {
    int sItem = currentItem_;
    Font f = g.getFont();
    int tw = 0;
    
    // If the current items itself is larger than screen size, just render it.
    if (f.stringWidth(listOfItems_[currentItem_]) + 2 > w_) {
      return currentItem_;
    }
    for (int i = currentItem_; i >= 0; --i) {
      int ciw = f.stringWidth(listOfItems_[sItem]);
      tw += ciw + 2;
      if (tw > w_) {
        return i;
      }
    }
    // If reached here, render from start.
    return 0;
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
  private String[] listOfItems_;
  private boolean[] selectionFlag_;
  private int currentItem_;
}
