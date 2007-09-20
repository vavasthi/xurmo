/*
 * XurmoInviteSummary.java
 *
 * Created on September 20, 2007, 10:20 PM
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
public class XurmoInviteSummary {
  
  public Vector connectableEntries_;
  public Vector joinableEntries_;
  public XurmoNetworkInteractionStatus status_;
  
  /** Creates a new instance of XurmoInviteSummary */
  public XurmoInviteSummary(int errorCode,
      String cookie,
      String cellName,
      java.util.Vector connectableEntries,
      java.util.Vector joinableEntries) {

    status_ = new XurmoNetworkInteractionStatus(errorCode, cookie, cellName);
    connectableEntries_ = connectableEntries;
    joinableEntries_ = joinableEntries;
  }
    public XurmoInviteSummary() {
    
    status_ = new XurmoNetworkInteractionStatus(XurmoNetworkManagementWSInterface.NETWORK_INTERACTION_STATUS_SERVER_UNAVAILABLE, null, null);
    connectableEntries_ = new Vector();
    joinableEntries_ = new Vector();
  }
}
