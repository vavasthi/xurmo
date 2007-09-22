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
  
  /**
   * Creates a new instance of XurmoNetworkSummaryPanel
   */
  public XurmoNetworkSummaryPanel(Xurmo midlet, int screenWidth, int screenHeight, Image icon, String title) {
    
    super(midlet, screenWidth, screenHeight, icon, title);
  }
  public void draw(Graphics g, int x, int y) {
    Font of = g.getFont();
    int oc = g.getColor();
    int origY = y;
    drawBoundingBox(g, x, y);
    XurmoNetworkSummaryStatus networkSummary = midlet_.getNetworkSummaryStatus();
    if (selected()) {
      if (networkSummary.status_.errorCode_ == XurmoNetworkManagementWSInterface.NETWORK_INTERACTION_NO_ERROR) {
        
      y = th_ + origY;
      g.drawString("Total " + networkSummary.numberOfContacts_ + " contacts of which " + networkSummary.contactsAlreadyUser_.length + " are already members of Xurmo", 0, y, g.LEFT | g.TOP);
      y += g.getFont().getHeight();
      g.drawString("Member of  " + networkSummary.memberOfNetworks_.length + " networks of Xurmo", 0, y, g.LEFT | g.TOP);
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
