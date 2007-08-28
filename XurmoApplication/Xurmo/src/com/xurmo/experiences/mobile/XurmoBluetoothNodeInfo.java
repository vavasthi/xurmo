/*
 * XurmoBluetoothNodeInfo.java
 *
 * Created on April 19, 2007, 9:18 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author a12733
 */
public class XurmoBluetoothNodeInfo {
  
  /**
   * Creates a new instance of XurmoBluetoothNodeInfo
   */
  public XurmoBluetoothNodeInfo(int locationId, String btAddress, String btName) {
    this.locationId = locationId;
    this.btAddress = btAddress;
    this.btName = btName;
  }
  public int locationId;
  public String btAddress;
  public String btName;
}
