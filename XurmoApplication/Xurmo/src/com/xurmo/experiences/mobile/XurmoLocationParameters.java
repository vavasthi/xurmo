/*
 * XurmoLocationParameters.java
 *
 * Created on April 19, 2007, 10:59 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author a12733
 */
public class XurmoLocationParameters {
  
  public XurmoLocationParameters() {
    
    countryId = "000";
    networkId = "000";
    locId = "0000";
    cellId = "0000";
    cellName = "Unknown";
    btNodes = new XurmoBluetoothNodeInfo[0];
  }
  /**
   * Creates a new instance of XurmoLocationParameters
   */
  public XurmoLocationParameters(String countryId,
                                  String networkId,
                                  String locId,
                                  String cellId,
                                  String cellName,
                                  XurmoBluetoothNodeInfo[] btNodes) {
    this.countryId = countryId;
    this.networkId = networkId;
    this.locId = locId;
    this.cellId = cellId;
    this.cellName = cellName;
    this.btNodes = btNodes;
    XurmoDevice.updateLocation(cellName);
  }

  public String countryId;
  public String networkId;
  public String locId;
  public String cellId;
  public String cellName;
  public XurmoBluetoothNodeInfo[] btNodes;
}
