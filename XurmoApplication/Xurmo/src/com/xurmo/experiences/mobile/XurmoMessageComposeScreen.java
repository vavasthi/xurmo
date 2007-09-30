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
 * @file   XurmoMyNetworksScreen.java
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

import javax.microedition.io.*;

public class XurmoMessageComposeScreen extends XurmoScrollableScreen {
  XurmoRequestToConnectMessage[] requestToConnectList_;
  /**
   * Creates a new instance of XurmoHomeScreen
   */
  public XurmoMessageComposeScreen(Xurmo midlet) {
    super(midlet);
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    XurmoPanel[] panels = new XurmoPanel[4];
    currentPanel_ = 0;
    XurmoNetworkSummaryStatus status = midlet_.getNetworkSummaryStatus();
    String[] memberOfNetworks = status.memberOfNetworks_;
    String[] items = new String[memberOfNetworks.length + 1];
    for (int i = 0; i < memberOfNetworks.length; ++i) {
      items[i + 1] = memberOfNetworks[i];
    }
    panels[0] = new XurmoNavigationPanel(midlet, this, midlet_.home_, this.getWidth(), this.getHeight());
    panels[1] = new XurmoNumberSliderPanel(midlet, this.getWidth(), this.getHeight(), "Degrees", "Propagation Degrees of Separation", 4, 1, 6);
    panels[2] = new XurmoSelectorListPanel(midlet, this.getWidth(), this.getHeight(), ct.writeNewInteractionImage_, "Networks", midlet_.getNetworkSummaryStatus().availableNetworks_);
    panels[3] = new XurmoContentPanel(midlet, this, this.getWidth(), this.getHeight(), ct.writeNewInteractionImage_, "Content");
    panels_ = panels;
    panels_[currentPanel_].selected(true);
  }
  public void rightKey() {
    panels_[currentPanel_].rightKey();
  }
  public void leftKey() {
    panels_[currentPanel_].leftKey();
  }
  public void fireKey() {
    panels_[currentPanel_].fireKey();
  }
  protected XurmoPanel[] panels() {
    return panels_;
  }
  public void messageEditDone() {
    repaint();
    midlet_.getDisplay().setCurrent(this);
  }
  public void cancelMessageEdit() {
    repaint();
    midlet_.getDisplay().setCurrent(this);    
  }
  public void imageCaptureDone() {
    
    repaint();
    midlet_.getDisplay().setCurrent(this);
  }
  public void cancelImageCapture() {
    
    repaint();
    midlet_.getDisplay().setCurrent(this);
  }
}
