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

abstract public class XurmoInviteScreen extends XurmoScrollableScreen {
  java.util.Vector invitableEntries_;
  /**
   * Creates a new instance of XurmoHomeScreen
   */
  public XurmoInviteScreen(Xurmo midlet, java.util.Vector invitableEntries, java.util.Vector linkTypes) {
    super(midlet);
    invitableEntries_ = invitableEntries;
    System.out.println("Creating Invite Screen.. Invitable Entries = " + invitableEntries_.size());
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    XurmoPanel[] panels = new XurmoPanel[invitableEntries_.size()];
    currentPanel_ = 0;
    for (int i = 0; i < invitableEntries_.size(); ++i) {
      XurmoInvitePhoneBookEntry pbe = (XurmoInvitePhoneBookEntry)(invitableEntries_.elementAt(i));
      panels[i] = new XurmoInviteEntryPanel(midlet, getWidth(), getHeight(), pbe.contactName, pbe.mobileNumber, linkTypes);
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
          xsp.clear();
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
      XurmoInviteEntryPanel ep = (XurmoInviteEntryPanel)(panels_[i]);
      XurmoInvitePhoneBookEntry pbe = (XurmoInvitePhoneBookEntry)(invitableEntries_.elementAt(i));
      if (ep.ticked_) {
        
        out += "<ns0:invitationsForLink>\n";
        out += "<ns0:linkId>" + ep.linkId_ + "</ns0:linkId>\n";
        if (ep.linkName_ != null) {
          out += "<ns0:linkName>" + ep.linkName_ + "</ns0:linkName>\n";
        } else {
          
          out += "<ns0:linkName/>\n";
        }
        out += "<ns0:message>" + midlet_.currentUser_.username_ + " has invited you to his network." + "</ns0:message>\n";
        out += "<ns0:phoneNumberToUser>" + pbe.mobileNumber + "</ns0:phoneNumberToUser>\n";
        out += "<ns0:requestFromUser>" + midlet_.currentUser_.username_ + "</ns0:requestFromUser>\n";
        out += "<ns0:uniqueId>" + pbe.uniqueId + "</ns0:uniqueId>\n";
        out += "</ns0:invitationsForLink>\n";
      }
    }
    midlet_.setNetworkSummaryStatus(XurmoNetworkManagementWSInterface.sendInvitations(midlet_.currentUser_.username_, midlet_.currentUser_.cookie_, out));
    if (XurmoNetworkManagementWSInterface.isInteractionSuccessful(midlet_.networkSummary_.status_.errorCode_)) {
      
      midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, this, new XurmoMyNetworksScreen(midlet_), XurmoSliderCanvas.RIGHT));
    } else {
      
      midlet_.getDisplay().setCurrent(new XurmoSliderWithOneAction(midlet_, this, new XurmoMyNetworksScreen(midlet_), "Invitation failed", XurmoNetworkManagementWSInterface.getStringMessage(midlet_.networkSummary_.status_.errorCode_),XurmoSliderCanvas.RIGHT));
    }
  }
  protected XurmoPanel[] panels() {
    return panels_;
  }
}
