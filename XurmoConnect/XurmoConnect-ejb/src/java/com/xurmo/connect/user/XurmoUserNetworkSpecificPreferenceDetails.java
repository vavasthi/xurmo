/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserNetworkSpecificPreferenceDetails.java
 * Created on               : September 16, 2007, 1:43 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoUserNetworkSpecificPreferenceDetails implements java.io.Serializable {
  public int linkId;
  public String linkName;
  public int receiveDefaultMessagesDegrees;
  public boolean allowSearchIntoYourNetwork;
  public boolean forwardMessagesOnDestinationPreferences;
  public boolean forwardMessagesToExternalNetworks;
  public boolean receivePersonalEventReminders;
  public boolean receiveInviteFromEverybody;
  public XurmoUserNetworkSpecificPreferenceDetails(int linkId,
      String linkName,
      int receiveDefaultMessagesDegrees,
      boolean allowSearchIntoYourNetwork,
      boolean forwardMessagesOnDestinationPreferences,
      boolean forwardMessagesToExternalNetworks,
      boolean receivePersonalEventReminders,
      boolean receiveInviteFromEverybody) {
    this.linkId = linkId;
    this.linkName = linkName;
    this.receiveDefaultMessagesDegrees = receiveDefaultMessagesDegrees;
    this.allowSearchIntoYourNetwork = allowSearchIntoYourNetwork;
    this.forwardMessagesOnDestinationPreferences = forwardMessagesOnDestinationPreferences;
    this.forwardMessagesToExternalNetworks = forwardMessagesToExternalNetworks;
    this.receivePersonalEventReminders = receivePersonalEventReminders;
    this.receiveInviteFromEverybody = receiveInviteFromEverybody;
  }  
}
