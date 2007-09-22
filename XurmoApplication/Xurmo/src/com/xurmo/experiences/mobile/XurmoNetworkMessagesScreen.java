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

public class XurmoNetworkMessagesScreen extends XurmoScrollableScreen {
  XurmoRequestToConnectMessage[] requestToConnectList_;
  /**
   * Creates a new instance of XurmoHomeScreen
   */
  public XurmoNetworkMessagesScreen(Xurmo midlet, XurmoRequestToConnectMessage[] requestToConnectList, XurmoNetworkMessageResponseType[] responseTypes) {
    super(midlet);
    requestToConnectList_ = requestToConnectList;
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    XurmoPanel[] panels = new XurmoPanel[requestToConnectList_.length];
    currentPanel_ = 0;
    for (int i = 0; i < requestToConnectList_.length; ++i) {
      XurmoRequestToConnectMessage rtc = requestToConnectList_[i];
      panels[i] = new XurmoNetworkMessageEntryPanel(midlet, getWidth(), getHeight(), rtc.usernameFrom, rtc.linkName, rtc.msg, responseTypes);
    }
    panels_ = panels;
    panels_[currentPanel_].selected(true);
  }
  public void defaultFireKey() {
    if (panels_[currentPanel_] instanceof XurmoSelectablePanel) {
      
      XurmoSelectablePanel xsp = (XurmoSelectablePanel)(panels_[currentPanel_]);
      if (!xsp.ticked_) { // The option is not selected
        if (!xsp.isMenuActive()) { // The menu is not active, select the option and activate the menu.
          
          xsp.ticked_ = true;
          xsp.activateMenu();
        } else { // The menu is active, this should never happen
          xsp.deactivateMenu();
          xsp.ticked_ = false;
        }
      } else { // The option is selected
        
        if (!xsp.isMenuActive()) { // and the menu is not active, so just unselect the option
          
          xsp.ticked_ = false;
          xsp.deactivateMenu();
        } else { // and the menu is active, just run the menu command and deactivate the menu.
          xsp.menu().fireKey();
          xsp.deactivateMenu();
        }
      }
    }
  }
  public void leftKey() {
    midlet_.transitionToHomeScreen();
  }
  public void rightKey() {
    System.out.println("Right key called with currentPanel =" + currentPanel_);
    String out = new String("");
    for (int i = 0; i < panels_.length; ++i) {
      XurmoNetworkMessageEntryPanel ep = (XurmoNetworkMessageEntryPanel)(panels_[i]);
      XurmoRequestToConnectMessage rtcm = requestToConnectList_[i];
      if (ep.ticked_) {
        
        out += "<ns0:invitationDisposition>\n";        
        if (ep.responseString_ != null) {
          out += "<ns0:disposition>" + ep.responseId_ + "</ns0:disposition>\n";
          out += "<ns0:linkId>" + rtcm.linkId + "</ns0:linkId>\n";
          out += "<ns0:linkName>" + rtcm.linkName + "</ns0:linkName>\n";
        } else {
          
          out += "<ns0:disposition/>\n";
          out += "<ns0:linkId>" + rtcm.linkId + "</ns0:linkId>\n";
          out += "<ns0:linkName>" + rtcm.linkName + "</ns0:linkName>\n";
        }
        out += "<ns0:requestFromUser>" + rtcm.requestFrom + "</ns0:requestFromUser>\n";
        out += "<ns0:requestToUser>" + rtcm.requestTo+ "</ns0:requestToUser>\n";
        out += "</ns0:invitationDisposition>\n";
      }
    }
    midlet_.setNetworkSummaryStatus(XurmoNetworkManagementWSInterface.disposeInvitations(midlet_.currentUser_.username_, midlet_.currentUser_.cookie_, out));
    if (XurmoNetworkManagementWSInterface.isInteractionSuccessful(midlet_.networkSummary_.status_.errorCode_)) {
      
      midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, this, new XurmoMyNetworksScreen(midlet_), XurmoSliderCanvas.RIGHT));
    } else {
      
      midlet_.getDisplay().setCurrent(new XurmoSliderWithOneAction(midlet_, this, new XurmoMyNetworksScreen(midlet_), "Invitation disposition failed", XurmoNetworkManagementWSInterface.getStringMessage(midlet_.networkSummary_.status_.errorCode_),XurmoSliderCanvas.RIGHT));
    }
  }
  protected XurmoPanel[] panels() {
    return panels_;
  }
}
