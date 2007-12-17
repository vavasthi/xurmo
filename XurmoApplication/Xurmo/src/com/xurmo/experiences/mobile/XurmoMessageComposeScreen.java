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
  XurmoNumberSliderPanel numberSliderPanel_;
  XurmoSelectorListPanel selectorListPanel_;
  XurmoContentPanel contentPanel_;
  XurmoNavigationPanel sendMsg_;

  /**
   * Creates a new instance of XurmoHomeScreen
   */
  public XurmoMessageComposeScreen(Xurmo midlet) {
    super(midlet);
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    XurmoPanel[] panels = new XurmoPanel[5];
    currentPanel_ = 0;
    XurmoNetworkSummaryStatus status = midlet_.getNetworkSummaryStatus();
    String[] memberOfNetworks = status.memberOfNetworks_;
    String[] items = new String[memberOfNetworks.length + 1];
    for (int i = 0; i < memberOfNetworks.length; ++i) {
      items[i + 1] = memberOfNetworks[i];
    }
    numberSliderPanel_ = new XurmoNumberSliderPanel(midlet, this.getWidth(), this.getHeight(), "Degrees", "Propagation Degrees of Separation", 4, 1, 6);
    selectorListPanel_ = new XurmoSelectorListPanel(midlet, this.getWidth(), this.getHeight(), ct.writeNewInteractionImage_, "Networks", midlet_.getNetworkSummaryStatus().availableNetworks_);
    contentPanel_ = new XurmoContentPanel(midlet, this, this.getWidth(), this.getHeight(), ct.writeNewInteractionImage_, "Content");
    sendMsg_ = new XurmoNavigationPanel(midlet, this, midlet_.home_, this.getWidth(), this.getHeight());

    panels[0] = new XurmoNavigationPanel(midlet, this, midlet_.home_, this.getWidth(), this.getHeight());
    panels[1] = numberSliderPanel_;
    panels[2] = selectorListPanel_;
    panels[3] = contentPanel_;
    panels[4] = sendMsg_;
    panels_ = panels;
    panels_[currentPanel_].selected(true);
  }
  public void rightKey() {
    if (panels_[currentPanel_] == sendMsg_) {
      if (!sendMessage()) {
        System.out.println("Error in sending message..");
      }
    }
    else {
      
      panels_[currentPanel_].rightKey();
    }
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
  private boolean sendMessage() {
    try {
      
      midlet_.sendMessage(numberSliderPanel_.value(), 
          selectorListPanel_.getSelectedValues(), 
          contentPanel_.getMessage());
    }
    catch(java.io.IOException ioex) {
      return false;
    }
    return true;
  }
}
