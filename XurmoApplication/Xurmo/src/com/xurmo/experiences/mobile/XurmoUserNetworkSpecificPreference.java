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
public class XurmoUserNetworkSpecificPreference {
  
  /** Creates a new instance of XurmoUserPreference */
  public XurmoUserNetworkSpecificPreference(int linkId,
      String linkName,
      boolean allowSearchIntoYourNetwork,
      boolean forwardMessagesOnDestinationPreferences,
      boolean forwardMessagesToExternalNetworks,
      int receiveDefaultMessagesDegrees,
      boolean receiveInviteFromEverybody,
      boolean receivePersonalEvenReminders) {
    
    linkId_ = linkId;
    linkName_ = linkName;
    allowSearchIntoYourNetwork_ = allowSearchIntoYourNetwork;
    forwardMessagesOnDestinationPreferences_ = forwardMessagesOnDestinationPreferences;
    forwardMessagesToExternalNetworks_ = forwardMessagesToExternalNetworks;
    receiveDefaultMessagesDegrees_ = receiveDefaultMessagesDegrees;
    receiveInviteFromEverybody_ = receiveInviteFromEverybody;
    receivePersonalEvenReminders_ = receivePersonalEvenReminders;
  }
  private int linkId_;
  private String linkName_;
  private boolean allowSearchIntoYourNetwork_;
  private boolean forwardMessagesOnDestinationPreferences_;
  private boolean forwardMessagesToExternalNetworks_;
  private int receiveDefaultMessagesDegrees_;
  private boolean receiveInviteFromEverybody_;
  private boolean receivePersonalEvenReminders_;
}
