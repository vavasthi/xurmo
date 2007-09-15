/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserPreferenceDetails.java
 * Created on               : September 16, 2007, 1:36 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoUserPreferenceDetails implements java.io.Serializable {
  
  public int userid;
  private XurmoUserManagementStatus status;
  public int receiveDefaultMessagesDegrees;
  public boolean allowSearchIntoYourNetwork;
  public boolean forwardMessagesOnDestinationPreferences;
  public boolean forwardMessagesToExternalNetworks;
  public boolean receivePersonalEvenReminders;
  public int[] black;
  public int[] white;
  public XurmoUserNetworkSpecificPreferenceDetails[] networkSpecificPreference;
  public XurmoUserNetworkSpecificUserLists[] networkSpecificUserLists;

  /**
   * Creates a new instance of XurmoUserPreferenceDetails
   */
  public XurmoUserPreferenceDetails(int userid,
      int receiveDefaultMessagesDegrees,
      boolean allowSearchIntoYourNetwork,
      boolean forwardMessagesOnDestinationPreferences,
      boolean forwardMessagesToExternalNetworks,
      boolean receivePersonalEvenReminders,
      int[] black,
      int[] white,
      XurmoUserNetworkSpecificPreferenceDetails[] networkSpecificPreference,
      XurmoUserNetworkSpecificUserLists[] networkSpecificUserLists) {
    this.userid = userid;
    this.status = null;
    this.receiveDefaultMessagesDegrees = receiveDefaultMessagesDegrees;
    this.allowSearchIntoYourNetwork = allowSearchIntoYourNetwork;
    this.forwardMessagesOnDestinationPreferences = forwardMessagesOnDestinationPreferences;
    this.forwardMessagesToExternalNetworks = forwardMessagesToExternalNetworks;
    this.receivePersonalEvenReminders = receivePersonalEvenReminders;
    this.black = black;
    this.white = white;
    this.networkSpecificPreference = networkSpecificPreference;
    this.networkSpecificUserLists = networkSpecificUserLists;
  }
  /**
   * Creates a new instance of XurmoUserPreferenceDetails
   */
  public XurmoUserPreferenceDetails(int userid) {
    this.userid = userid;
    this.status = null;
    this.receiveDefaultMessagesDegrees = 4;
    this.allowSearchIntoYourNetwork = false;
    this.forwardMessagesOnDestinationPreferences = false;
    this.forwardMessagesToExternalNetworks = false;
    this.receivePersonalEvenReminders = true;
    this.black = new int[0];
    this.white = new int[0];
    this.networkSpecificPreference = new XurmoUserNetworkSpecificPreferenceDetails[0];
     this.networkSpecificUserLists = new XurmoUserNetworkSpecificUserLists[0];
  }
  /**
   * Creates a new instance of XurmoUserPreferenceDetails
   */
  public XurmoUserPreferenceDetails() {
    this.userid = userid;
    this.status = new XurmoUserManagementStatus(XurmoUserInteractionStatus.INTERACTIONFAILED_USER_NOT_LOGGED_IN, "", "");
    this.receiveDefaultMessagesDegrees = 4;
    this.allowSearchIntoYourNetwork = false;
    this.forwardMessagesOnDestinationPreferences = false;
    this.forwardMessagesToExternalNetworks = false;
    this.receivePersonalEvenReminders = true;
    this.black = new int[0];
    this.white = new int[0];
    this.networkSpecificPreference = new XurmoUserNetworkSpecificPreferenceDetails[0];
     this.networkSpecificUserLists = new XurmoUserNetworkSpecificUserLists[0];
  }
  public void setStatus(XurmoUserManagementStatus status) {
    this.status = status;
  }
  public XurmoUserManagementStatus getStatus() {
    return status;
  }
}
