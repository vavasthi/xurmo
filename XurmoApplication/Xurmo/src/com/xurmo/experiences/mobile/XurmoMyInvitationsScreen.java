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

public class XurmoMyInvitationsScreen extends XurmoScrollableScreen {
  XurmoInviteSummary invSummary_;
  /**
   * Creates a new instance of XurmoHomeScreen
   */
  public XurmoMyInvitationsScreen(Xurmo midlet) {
    super(midlet);
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    
    summary_ = new XurmoNetworkSummaryPanel(midlet_, getWidth(), getHeight(), ct.meIconImage_, "Summary");
    summary_.selected(true);
    currentPanel_ = 0;
    
    receivedInvitations_ = new XurmoCollapsablePanel(midlet_, getWidth(), getHeight(), ct.meIconImage_, "Received Invites");
    connectFromPhonebook_ = new XurmoCollapsablePanel(midlet_, getWidth(), getHeight(), ct.meIconImage_, "Invite to Connect");
    joinFromPhonebook_ = new XurmoCollapsablePanel(midlet_, getWidth(), getHeight(), ct.meIconImage_, "Invite to Join ");

    home_ = new XurmoCollapsablePanel(midlet_, getWidth(), getHeight(), ct.friendsSmallImage_, "Home");
    
    panels_ = new XurmoCollapsablePanel[]{
      summary_,
      receivedInvitations_ ,
      connectFromPhonebook_,
      joinFromPhonebook_,
      home_
    };
    invSummary_ = midlet_.getInvitablePhoneBookEntries();
  }
  public void rightKey() {
    if (panels_[currentPanel_] == connectFromPhonebook_ && XurmoNetworkManagementWSInterface.isInteractionSuccessful(invSummary_.status_.errorCode_)) {
     
      midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, this, new XurmoConnectScreen(midlet_, invSummary_.connectableEntries_, invSummary_.linkTypes_), XurmoSliderCanvas.RIGHT));
    }
    else if (panels_[currentPanel_] == joinFromPhonebook_ && XurmoNetworkManagementWSInterface.isInteractionSuccessful(invSummary_.status_.errorCode_)) {
     
      midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, this, new XurmoJoinScreen(midlet_, invSummary_.joinableEntries_, invSummary_.linkTypes_), XurmoSliderCanvas.RIGHT));
    }
    else if (panels_[currentPanel_] == receivedInvitations_ && XurmoNetworkManagementWSInterface.isInteractionSuccessful(invSummary_.status_.errorCode_)) {
      XurmoNetworkMessagesStatus status = midlet_.getNetworkMessages();
      midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, this, new XurmoNetworkMessagesScreen(midlet_, status.messages_, status.responseTypes_), XurmoSliderCanvas.RIGHT));
    }
  }
  public void leftKey() {
     midlet_.transitionToHomeScreen();
  }
  XurmoCollapsablePanel summary_;
  XurmoCollapsablePanel receivedInvitations_;
  XurmoCollapsablePanel connectFromPhonebook_;
  XurmoCollapsablePanel joinFromPhonebook_;
  XurmoCollapsablePanel home_;
}
