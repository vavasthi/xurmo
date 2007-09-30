/*
 * XurmoMePanel.java
 *
 * Created on August 24, 2007, 10:35 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Font;


/**
 *
 * @author Vinay
 */
public class XurmoMePanel extends XurmoCollapsablePanel {
  XurmoHomeScreen screen_;
  /**
   * Creates a new instance of XurmoMePanel
   */
  public XurmoMePanel(Xurmo midlet, XurmoHomeScreen screen, int screenWidth, int screenHeight, Image icon, String title) {
    
    super(midlet, screenWidth, screenHeight, icon, title);
    screen_ = screen;
    createMenu();
  }
  void createMenu() {
    XurmoMePanelPopupMenuListener listener = new XurmoMePanelPopupMenuListener(midlet_, screen_);
    XurmoPopupMenu xpm = new XurmoPopupMenu(midlet_,
        this.screenWidth_,
        this.screenHeight_,
        listener.items(),
        listener);
    this.setMenu(xpm);
  }
  public void draw(Graphics g, int x, int y) {
    Font of = g.getFont();
    int oc = g.getColor();
    int origY = y;
    drawBoundingBox(g, x, y);
    if (selected()) {
      
      y = th_ + origY;
      g.drawString(midlet_.getHomeScreenData().fname + " " + midlet_.getHomeScreenData().lname, 0, y, g.LEFT | g.TOP);
      y += g.getFont().getHeight();
      g.drawString("@" + midlet_.getHomeScreenData().status.cellName_ + " " + midlet_.getHomeScreenData().presence, 0, y, g.LEFT | g.TOP);
    }
    g.setColor(oc);
    g.setFont(of);
  }
}
