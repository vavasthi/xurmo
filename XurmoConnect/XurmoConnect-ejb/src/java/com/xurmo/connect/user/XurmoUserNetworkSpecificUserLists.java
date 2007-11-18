/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserNetworkSpecificUserLists.java
 * Created on               : September 16, 2007, 1:47 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoUserNetworkSpecificUserLists implements java.io.Serializable {
  public int linkId;
  public String linkName;
  public int[] black;
  public int[] white;
  /** Creates a new instance of XurmoUserNetworkSpecificUserLists */
  public XurmoUserNetworkSpecificUserLists(int linkId, String linkName, int[] black, int[] white) {
    
    this.linkId = linkId;
    this.linkName = linkName;
    this.black = black;
    this.white = white;
  }
  
}
