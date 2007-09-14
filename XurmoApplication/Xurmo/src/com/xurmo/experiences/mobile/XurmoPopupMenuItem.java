/*
 * XurmoPopupMenuItem.java
 *
 * Created on September 14, 2007, 6:48 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author Vinay
 */
public class XurmoPopupMenuItem {
  String item_;
  boolean selected_;
  /** Creates a new instance of XurmoPopupMenuItem */
  public XurmoPopupMenuItem(String item) {
    
    item_ = item;
    selected_ = false;
  }
  public void draw(javax.microedition.lcdui.Graphics g, int x, int y, int w, int h, XurmoTheme ct) {
    int bc = ct.collapsablePanelUnselectedBackgroundColorValue_;
    int fc = ct.collapsablePanelUnselectedForegroundColorValue_;
    if (selected_) {
      bc = ct.collapsablePanelSelectedTitleBackgroundValue_;
      fc = ct.collapsablePanelSelectedForegroundColorValue_;
    }
    g.setColor(bc);
    g.fillRoundRect(x, y, w, h, 5, 5);
    g.setColor(fc);
    g.drawString(item_, x, y, g.LEFT | g.TOP);    
  }
}
