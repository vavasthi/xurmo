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
public class XurmoNetworkSummaryPanel extends XurmoCollapsablePanel {
  
  XurmoNetworkSummaryStatus networkSummary_;
  /**
   * Creates a new instance of XurmoNetworkSummaryPanel
   */
  public XurmoNetworkSummaryPanel(Xurmo midlet, int screenWidth, int screenHeight, Image icon, String title) {
    
    super(midlet, screenWidth, screenHeight, icon, title);
    networkSummary_ = XurmoNetworkManagementWSInterface.getNetworkSummary(midlet_.currentUser_.username_, midlet_.currentUser_.cookie_);
  }
  public void draw(Graphics g, int x, int y) {
    Font of = g.getFont();
    int oc = g.getColor();
    int origY = y;
    drawBoundingBox(g, x, y);
    if (selected()) {
      if (networkSummary_.status_.errorCode_ == XurmoNetworkManagementWSInterface.NETWORK_INTERACTION_SUCCESS) {
        
      y = th_ + origY;
      g.drawString("Total " + networkSummary_.numberOfContacts_ + " contacts of which " + networkSummary_.contactsAlreadyUser_.length + " are already members of Xurmo", 0, y, g.LEFT | g.TOP);
      y += g.getFont().getHeight();
      g.drawString("Member of  " + networkSummary_.memberOfNetworks_.length + " networks of Xurmo", 0, y, g.LEFT | g.TOP);
      }
      else {
        
      y = th_ + origY;
      g.drawString("Could not retrieve network summary for", 0, y, g.LEFT | g.TOP);
      y += g.getFont().getHeight();
      g.drawString("user " + midlet_.getHomeScreenData().salutation + " " + midlet_.getHomeScreenData().fname + " " + midlet_.getHomeScreenData().lname, 0, y, g.LEFT | g.TOP);
      }
    }
    g.setColor(oc);
    g.setFont(of);
  }
}
