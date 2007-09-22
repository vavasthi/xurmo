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
  
  Vector connectableEntries_;
  Vector joinableEntries_;
  Vector linkTypes_;
  public XurmoNetworkInteractionStatus status_;
  
  /** Creates a new instance of XurmoInviteSummary */
  public XurmoInviteSummary(int errorCode,
      String cookie,
      String cellName,
      Vector connectableEntries,
      Vector joinableEntries,
      Vector linkTypes) {

    status_ = new XurmoNetworkInteractionStatus(errorCode, cookie, cellName);
    connectableEntries_ = connectableEntries;
    joinableEntries_ = joinableEntries;
    linkTypes_ = linkTypes;
  }
    public XurmoInviteSummary() {
    
    status_ = new XurmoNetworkInteractionStatus(XurmoNetworkManagementWSInterface.NETWORK_INTERACTION_SERVER_NOT_AVAILABLE, null, null);
    connectableEntries_ = new Vector();
    joinableEntries_ = new Vector();
    linkTypes_ = new Vector();
  }
}
