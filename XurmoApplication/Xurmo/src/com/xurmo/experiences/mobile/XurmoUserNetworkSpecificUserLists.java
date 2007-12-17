/*
 * XurmoUserNetworkSpecificUserLists.java
 *
 * Created on October 3, 2007, 6:39 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author Vinay
 */
public class XurmoUserNetworkSpecificUserLists {
  
  /** Creates a new instance of XurmoUserNetworkSpecificUserLists */
  public XurmoUserNetworkSpecificUserLists(int linkId, String linkName, java.util.Vector black, java.util.Vector white) {
    linkId_ = linkId;
    linkName_ = linkName;
    black_ = black;
    white_ = white;
  }
  int linkId_;
  String linkName_;
  java.util.Vector black_;
  java.util.Vector white_;
}
