// =====================================================================
//                           Xurmo Priprietary
//                (c) Copyright 2007, Xurmo All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          November 21, 2006
// =====================================================================

/**
 *
 * @file   PacketDataServiceListener.java
 * @author
 * @date   November 21, 2006
 *
 * @brief
 *
 *
 */
// *********************************************************************
// Package
// *********************************************************************
package com.xurmo.experiences.mobile;
// *********************************************************************
// Imports
// *********************************************************************
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.microedition.io.*;
import javax.bluetooth.*;

public class XurmoBluetoothServiceListener implements DiscoveryListener {
  
  private DiscoveryAgent discoveryAgent_;
  private int serviceSearchCount_;
  private ServiceRecord serviceRecord_;
  private Vector deviceList_ = null;
  private Vector serviceList_ = null;
  private static XurmoBluetoothServiceListener self_ = null;
  private final int serviceName_ = 0x0100;
  private final int serviceDescription_ = 0x0101;
  private final int serviceProviderName_ = 0x0102;
  private LocalDevice local_ = null;
  
  public XurmoBluetoothServiceListener() throws BluetoothStateException {
    
    local_ = LocalDevice.getLocalDevice();
    discoveryAgent_ = local_.getDiscoveryAgent();
    serviceRecord_ = null;
  }
  public static XurmoBluetoothServiceListener instance() {
    if (self_ == null) {
      try {
        
        self_ = new XurmoBluetoothServiceListener();
      } catch(BluetoothStateException ex) {
        
      }
    }
    return self_;
  }
  public static void fini() {
    self_ = null;
  }
  static public String localBtAddress() {
    final String err = new String("Unknown BT");
    if (self_ == null) {
      return err;
    }
    if (self_.local_ != null) {
      
      String bt = self_.local_.getBluetoothAddress();
      if (bt == null) {
        return err;
      }
      return bt;
    } else {
      return err;
    }
  }
  
  /**
   * Completes a service search on each remote device in the list until all
   * devices are searched
   *
   * @param devList the list of remote Bluetooth devices to search
   *
   * @return true if a service is found; otherwise false if
   * no printer service was found on the devList provided
   */
  private void searchServices(RemoteDevice dev) throws BluetoothStateException{
    int[] attrSet = new int[] {0x0000, 0x0001, 0x0002, 0x0003, 0x0004, serviceName_, serviceDescription_, serviceProviderName_};
    
    UUID[] searchList = new UUID[2];
    searchList[0] = new UUID(0x0100);
    searchList[1] = new UUID("10110000110111101001101", false);

    discoveryAgent_.searchServices(attrSet,
                                   searchList,
                                   dev,
                                   this);
    synchronized (this) {
      try {
        this.wait();
      } catch (Exception e) {
      }
    }
  }
  
  public Vector findPeers() {
    
    try {
      deviceList_ = new Vector();
      discoveryAgent_.startInquiry(DiscoveryAgent.GIAC, this);
      synchronized (this) {
        try {
          this.wait();
        } catch (Exception e) {
        }
      }
      
    } catch (BluetoothStateException e) {
      return null;
    }
    return deviceList_;
  }
  public Vector findServices(RemoteDevice rd) {
    
    try {
      searchServices(rd);
    } catch(BluetoothStateException e) {
      
      return null;
    }
    return serviceList_;
  }
  
  public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
    
    deviceList_.addElement(new XurmoRemoteBluetoothDevice(btDevice, cod));
  }
  
  public void serviceSearchCompleted(int transID, int respCode) {
    
    synchronized (this) {
      try {
        this.notify();
      }catch (Exception e) {
      }
    }
  }
  /**
   * Called when service(s) are found during a service search.
   * This method provides the array of services that have been found.
   *
   * @param transID the transaction ID of the service search that is
   * posting the result
   *
   * @param service a list of services found during the search request
   *
   * @see DiscoveryAgent#searchServices
   */
  public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
    if (servRecord != null) {
      for (int i = 0; i < servRecord.length;++i) {
        serviceList_.addElement(servRecord[i]);
      }
    }
  }
  
  /**
   * Called when a device discovery transaction is
   * completed. The <code>discType</code> will be
   * <code>INQUIRY_COMPLETED</code> if the device discovery
   * transactions ended normally,
   * <code>INQUIRY_ERROR</code> if the device
   * discovery transaction failed to complete normally,
   * <code>INQUIRY_TERMINATED</code> if the device
   * discovery transaction was canceled by calling
   * <code>DiscoveryAgent.cancelInquiry()</code>.
   *
   * @param discType the type of request that was completed; one of
   * <code>INQUIRY_COMPLETED</code>, <code>INQUIRY_ERROR</code>
   * or <code>INQUIRY_TERMINATED</code>
   */
  public void inquiryCompleted(int discType) {
    synchronized (this) {
      try {
        this.notify();
      } catch (Exception e) {
      }
    }
  }
}
