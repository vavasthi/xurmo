/*
 * XurmoUserPreference.java
 *
 * Created on September 29, 2007, 11:51 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

import java.util.Vector;

/**
 *
 * @author Vinay
 */
public class XurmoUserPreference {
  
  /** Creates a new instance of XurmoUserPreference */
  public XurmoUserPreference(boolean allowSearchIntoYourNetwork,
      boolean forwardMessagesOnDestinationPreferences,
      boolean forwardMessagesToExternalNetworks,
      int receiveDefaultMessagesDegrees,
      boolean receiveInviteFromEverybody,
      boolean receivePersonalEvenReminders,
      Vector black,
      Vector white,
      Vector networkSpecificPreference,
      Vector networkSpecificUserLists,
      XurmoUserAuthenticationReturnStatus status) {
    
    allowSearchIntoYourNetwork_ = allowSearchIntoYourNetwork;
    forwardMessagesOnDestinationPreferences_ = forwardMessagesOnDestinationPreferences;
    forwardMessagesToExternalNetworks_ = forwardMessagesToExternalNetworks;
    receiveDefaultMessagesDegrees_ = receiveDefaultMessagesDegrees;
    receiveInviteFromEverybody_ = receiveInviteFromEverybody;
    receivePersonalEvenReminders_ = receivePersonalEvenReminders;
    black_ = black;
    white_ = white;
    networkSpecificPreference_ = networkSpecificPreference;
    networkSpecificUserLists_ = networkSpecificUserLists;
    status_ = status;
  }
  public XurmoUserPreference(boolean allowSearchIntoYourNetwork,
      boolean forwardMessagesOnDestinationPreferences,
      boolean forwardMessagesToExternalNetworks,
      int receiveDefaultMessagesDegrees,
      boolean receiveInviteFromEverybody,
      boolean receivePersonalEvenReminders,
      Vector black,
      Vector white,
      Vector networkSpecificPreference,
      Vector networkSpecificUserLists,
      String errorCode,
      String cookie,
      String cellName) {
    
    allowSearchIntoYourNetwork_ = allowSearchIntoYourNetwork;
    forwardMessagesOnDestinationPreferences_ = forwardMessagesOnDestinationPreferences;
    forwardMessagesToExternalNetworks_ = forwardMessagesToExternalNetworks;
    receiveDefaultMessagesDegrees_ = receiveDefaultMessagesDegrees;
    receiveInviteFromEverybody_ = receiveInviteFromEverybody;
    receivePersonalEvenReminders_ = receivePersonalEvenReminders;
    black_ = black;
    white_ = white;
    networkSpecificPreference_ = networkSpecificPreference;
    networkSpecificUserLists_ = networkSpecificUserLists;
    status_ = new XurmoUserAuthenticationReturnStatus(cookie, Integer.parseInt(errorCode), cellName);
  }
  public XurmoUserPreference() {
    
    allowSearchIntoYourNetwork_ = false;
    forwardMessagesOnDestinationPreferences_ = false;
    forwardMessagesToExternalNetworks_ = false;
    receiveDefaultMessagesDegrees_ = 4;
    receiveInviteFromEverybody_ = false;
    receivePersonalEvenReminders_ = false;
    black_ = new Vector();
    white_ = new Vector();
    networkSpecificPreference_ = new Vector();
    networkSpecificUserLists_ = new Vector();
    status_ = new XurmoUserAuthenticationReturnStatus();
  }
  private boolean allowSearchIntoYourNetwork_;
  private boolean forwardMessagesOnDestinationPreferences_;
  private boolean forwardMessagesToExternalNetworks_;
  private int receiveDefaultMessagesDegrees_;
  private boolean receiveInviteFromEverybody_;
  private boolean receivePersonalEvenReminders_;
  private Vector black_;
  private Vector white_;
  private Vector networkSpecificPreference_;
  private Vector networkSpecificUserLists_;
  private XurmoUserAuthenticationReturnStatus status_;
}
