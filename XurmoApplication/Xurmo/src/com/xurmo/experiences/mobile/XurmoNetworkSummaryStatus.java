/*
 * XurmoNetworkSummaryStatus.java
 *
 * Created on September 9, 2007, 11:06 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author Vinay
 */
public class XurmoNetworkSummaryStatus {
  XurmoNetworkInteractionStatus status_;
  String[] memberOfNetworks_;
  XurmoUserGlobalData[] contactsAlreadyUser_;
  int numberOfContacts_;
  /** Creates a new instance of XurmoNetworkSummaryStatus */
  public XurmoNetworkSummaryStatus(int errorCode, 
      String cookie, 
      String cellName, 
      java.util.Vector memberOfNetworks,
      java.util.Vector contactsAlreadyUser,
      int numberOfContacts) {
    
    status_ = new XurmoNetworkInteractionStatus(errorCode, cookie, cellName);
    memberOfNetworks_ = new String[memberOfNetworks.size()];
    for (int i = 0; i < memberOfNetworks.size(); ++i) {
      memberOfNetworks_[i] = (String)(memberOfNetworks.elementAt(i));
    }
    contactsAlreadyUser_ = new XurmoUserGlobalData[contactsAlreadyUser.size()];
    for (int i = 0; i < contactsAlreadyUser.size(); ++i) {
      contactsAlreadyUser_[i] = (XurmoUserGlobalData)(contactsAlreadyUser.elementAt(i));
    }
    numberOfContacts_ = numberOfContacts;
  }
  public XurmoNetworkSummaryStatus() {
    
    status_ = new XurmoNetworkInteractionStatus(XurmoNetworkManagementWSInterface.NETWORK_INTERACTION_STATUS_SERVER_UNAVAILABLE, null, null);
    memberOfNetworks_ = new String[0];
    contactsAlreadyUser_ = new XurmoUserGlobalData[0];
    numberOfContacts_ = 0;
  }
}
