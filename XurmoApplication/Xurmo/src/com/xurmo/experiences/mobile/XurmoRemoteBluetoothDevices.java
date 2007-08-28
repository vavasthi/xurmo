/*
 * XurmoRemoteBluetoothDevices.java
 *
 * Created on August 24, 2007, 8:25 PM
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
public class XurmoRemoteBluetoothDevices {
  private static Vector bluetoothDevices_ = null;
  /**
   * Creates a new instance of XurmoRemoteBluetoothDevices
   */
  private XurmoRemoteBluetoothDevices() {
  }
  public static void findMarkers() {
    bluetoothDevices_ = new Vector();
    Vector devices = XurmoBluetoothServiceListener.instance().findPeers();
    for (int i = 0; i < devices.size(); ++i) {
      XurmoRemoteBluetoothDevice bd = (XurmoRemoteBluetoothDevice)(devices.elementAt(i));
      Vector services = XurmoBluetoothServiceListener.instance().findServices(bd.btDevice_);
      if (services.size() > 0) {
        bd.addServiceRecord(services.elementAt(i));
        bluetoothDevices_.addElement(bd);
      }
    }
    XurmoBluetoothServiceListener.fini();
  }
}
