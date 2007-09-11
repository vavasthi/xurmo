/*
 * XurmoNetworkSummaryPanel.java
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
public class XurmoMyPresencePanel extends XurmoCollapsablePanel {
  
  Xurmo midlet_;
  /**
   * Creates a new instance of XurmoNetworkSummaryPanel
   */
  public XurmoMyPresencePanel(Xurmo midlet, int screenWidth, int screenHeight, Image icon, String title) {
    
    super(screenWidth, screenHeight, icon, title);
    midlet_ = midlet;
  }
  public void draw(Graphics g, int x, int y) {
    Font of = g.getFont();
    int oc = g.getColor();
    int origY = y;
    drawBoundingBox(g, x, y);
    if (selected_ ) {
      y = th_ + origY;
      g.drawString(midlet_.getHomeScreenData().fname + " is " + midlet_.getHomeScreenData().presence, 0, y, g.LEFT | g.TOP);
      y += g.getFont().getHeight();
    }
    g.setColor(oc);
    g.setFont(of);
  }
}
