/*
 * XurmoNetworkLinkType.java
 *
 * Created on September 21, 2007, 5:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author Vinay
 */
public class XurmoNetworkMessageResponseType {
  int responseId;
  String responseString;
  /** Creates a new instance of XurmoNetworkLinkType */
  public XurmoNetworkMessageResponseType(int responseId, String responseString) {
    this.responseId = responseId;
    this.responseString = responseString;
  }
  
}
