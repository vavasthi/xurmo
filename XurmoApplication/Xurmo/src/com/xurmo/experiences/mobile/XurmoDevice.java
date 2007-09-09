// =====================================================================
//                           Xurmo Proprietary
//               (c) Copyright 2007, Xurmo, All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          August 7, 2007
// =====================================================================

/**
 *
 * @file   XurmoDevice.java
 * @author
 * @date   August 7, 2007
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

import java.util.Calendar;
import java.util.Date;

public class XurmoDevice {
  
  /**
   * Creates a new instance of XurmoDevice
   */
  private XurmoDevice() {
  }
  public static String getOneProperty(String name) {
    
    String propertyName = name;
    String property = System.getProperty(name);
    if (property == null) {
      return new String("Unknown");
    } else {
      return property;
    }
  }
  public static String getOnePropertyWithZeroDefault(String name) {
    
    String propertyName = name;
    String property = System.getProperty(name);
    if (property == null) {
      return new String("000");
    } else {
      return property;
    }
  }
  public static String cellId() {
    return getOneProperty("CellID");
  }
  public static String siteId() {
    return getOneProperty("LocAreaCode");
  }
  public static String imsi() {
    return getOneProperty("IMSI");
  }
  public static String msisdn() {
    return getOneProperty("MSISDN");
  }
  public static String batteryLevel() {
    return getOneProperty("batterylevel");
  }
  public static void updateLocation(String cellName) {
    if (!cellName.equals(unknownString_)) {

      cellName_ = cellName;
    }
  }
  public static String mobileCountryCode() {
    return getOneProperty("IMSI").substring(0,3);
  }
  public static String mobileNetworkCode() {
    return getOneProperty("IMSI").substring(3, 6);
  }
  public static String getTimezoneOffsetString() {
    if (timeZoneOffsetString_ == null) {
      timeZoneOffsetString_ = XurmoDevice.defaultTimeZone_;
      int plus = '+';
      int plusPos = timeZoneOffsetString_.indexOf(plus);
      int minus = '-';
      int minusPos = timeZoneOffsetString_.indexOf(minus);
      if (plusPos != -1) {
        timeZoneOffsetString_ = timeZoneOffsetString_.substring(plusPos);
      }
      else if(minusPos != -1) {
        
        timeZoneOffsetString_ = timeZoneOffsetString_.substring(minusPos);
      }
      else {
        timeZoneOffsetString_ = "+0:00";
      }
    }
    return timeZoneOffsetString_;
  }
  private static String getFixedWidthStringValue(int no, int width) {
    String cNo = String.valueOf(no);
    while (cNo.length() < width) {
      cNo = "0" + cNo;
    }
    return cNo;
  }
  private static String getYearInFourDigits(int no) {
    String cNo = String.valueOf(no);
    if (no < 10) {
      cNo = "200" + cNo;
    }
    else if (no < 100) {
      cNo = "19" + cNo;
    }
    return cNo;
  }
  public static String getXMLTime(Date dt) {
    
      Calendar c = Calendar.getInstance();
      c.setTime(dt);
      String out = new String("") 
      + getYearInFourDigits(c.get(Calendar.YEAR)) + "-" 
      + getFixedWidthStringValue(c.get(Calendar.MONTH),2) + "-" 
      + getFixedWidthStringValue(c.get(Calendar.DAY_OF_MONTH) + 1,2) 
      + "T" + getFixedWidthStringValue(c.get(Calendar.HOUR_OF_DAY),2) 
      + ":" + getFixedWidthStringValue(c.get(Calendar.MINUTE),2) 
      + ":" + getFixedWidthStringValue(c.get(Calendar.SECOND),2) 
      + "." + c.get(Calendar.MILLISECOND) 
      + XurmoDevice.getTimezoneOffsetString();
      return out;
  }
  public static String getLocationParameters() {
    String s = "<ns0:mobileCountryCode>" + XurmoDevice.mobileCountryCode() + "</ns0:mobileCountryCode>\n" +
        "<ns0:mobileNetworkCode>" + XurmoDevice.mobileNetworkCode() + "</ns0:mobileNetworkCode>\n" +
        "<ns0:siteId>" + XurmoDevice.siteId() + "</ns0:siteId>\n" +
        "<ns0:cellId>" + XurmoDevice.cellId() + "</ns0:cellId>\n" +
        "<ns0:cellName>" + XurmoDevice.cellName_ + "</ns0:cellName>\n";
    return s;
  }
  static final String unknownString_ = new String("Unknown");
  
  final static String defaultTimeZone_ = getOneProperty("default.timezone");
  final static String microeditionTimezone_ = getOneProperty("microedition.timezone");
  
  final static String imei_ = getOneProperty("IMEI");
  
  final static String funlightProduct_ = getOneProperty("funlight.product");
  final static String mixingSupported_ = getOneProperty("supports.mixing");
  final static String audioCaptureSupported_ = getOneProperty("supports.audio.capture");
  final static String videoCaptureSupported_ = getOneProperty("supports.video.capture");
  final static String recordingSupported_ = getOneProperty("supports.recording");
  
  final static String softwareVersion_ = getOneProperty("device.software.version");
  final static String deviceModel_ = getOneProperty("device.model");
  final static String maType_ = getOneProperty("MAType");
  final static String gprsState_ = getOneProperty("GPRSState");
  final static String smartCardSlots_ = getOneProperty("microedition.smartcardslots");
  static String cellName_ = new String("Unknown");
  
  static String cellId_ = getOneProperty("CellID");
  static String locAreaCode_ = getOneProperty("LocAreaCode");
  static String timeZoneOffsetString_ = null;
}
