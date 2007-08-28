/*
 * XurmoRemoteBluetoothDevices.java
 *
 * Created on August 24, 2007, 8:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

import javax.bluetooth.RemoteDevice;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.ServiceRecord;
import java.util.Vector;

/**
 *
 * @author Vinay
 */
public class XurmoRemoteBluetoothDevice {
  RemoteDevice btDevice_;
  DeviceClass cod_;
  Vector services_; // ServiceRecord
  
  /** Creates a new instance of XurmoRemoteBluetoothDevices */
  public XurmoRemoteBluetoothDevice(RemoteDevice btDevice, DeviceClass cod) {
    
    btDevice_ = btDevice;
    cod_ = cod;
    services_ = null;
  }
  void addServiceRecord(Object service) {
    services_.addElement(service);
  }
}
