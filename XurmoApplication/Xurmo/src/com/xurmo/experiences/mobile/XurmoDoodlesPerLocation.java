/*
 * XurmoGraffitiPerLocation.java
 *
 * Created on August 24, 2007, 9:33 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author Vinay
 */
public class XurmoDoodlesPerLocation {
  int locationId_;
  String locationName_;
  int messageCount_;
  
  /** Creates a new instance of XurmoGraffitiPerLocation */
  public XurmoDoodlesPerLocation(int locationId, String locationName, int messageCount) {
    
    locationId_ = locationId;
    locationName_ = locationName;
    messageCount_ = messageCount;
  }
  
}
