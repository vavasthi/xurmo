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
  public XurmoUserPreference() {
    black_ = new Vector();
    white_ = new Vector();
    networkSpecificPreference_ = new Vector();
    networkSpecificUserLists_ = new Vector();
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
