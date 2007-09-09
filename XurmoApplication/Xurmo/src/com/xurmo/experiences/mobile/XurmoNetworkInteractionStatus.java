/*
 * XurmoNetworkInteractionStatus.java
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
public class XurmoNetworkInteractionStatus {
  int errorCode_;
  String cookie_;
  String cellName_;
  /** Creates a new instance of XurmoNetworkInteractionStatus */
  public XurmoNetworkInteractionStatus(int errorCode, String cookie, String cellName) {
    
    errorCode_ = errorCode;
    cookie_ = cookie;
    cellName_ = cellName;
  }
  
}
