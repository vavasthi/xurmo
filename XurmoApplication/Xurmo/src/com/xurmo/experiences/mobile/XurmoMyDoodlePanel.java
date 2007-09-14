/*
 * XurmoMyDoodlePanel.java
 *
 * Created on August 24, 2007, 10:26 PM
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
public class XurmoMyDoodlePanel extends XurmoCollapsablePanel {
  
  /**
   * Creates a new instance of XurmoMyDoodlePanel
   */
  public XurmoMyDoodlePanel(Xurmo midlet, int screenWidth, int screenHeight, Image icon, String title) {
    
    super(midlet, screenWidth, screenHeight, icon, title);
  }
  public void draw(Graphics g, int x, int y) {
    Font of = g.getFont();
    int oc = g.getColor();
    int origY = y;
    drawBoundingBox(g, x, y);
    y = th_ + origY;
    if (selected()) {
      
      XurmoDoodleSummary mds = XurmoUserAuthenticationAndSessionWSInterface.instance().getDoodleSummary(midlet_.currentUser_.username_, midlet_.currentUser_.cookie_);
      g.drawString(mds.getSummaryTitleString(), 0, y, g.LEFT | g.TOP);
      y += g.getFont().getHeight();
      String[] sa = mds.getSummaryStrings();
      if (sa.length == 1) {
        g.drawString((String)sa[0], 0, y, g.LEFT | g.TOP);
      } else if(sa.length == 2) {
        
        g.drawString((String)sa[0], 0, y, g.LEFT | g.TOP);
        y += g.getFont().getHeight();
        g.drawString((String)sa[1], 0, y, g.LEFT | g.TOP);
      } else {
        
        g.drawString((String)sa[0], 0, y, g.LEFT | g.TOP);
        y += g.getFont().getHeight();
        g.drawString("more...", 0, y, g.LEFT | g.TOP);
      }
    }
    g.setColor(oc);
    g.setFont(of);
  }
}
