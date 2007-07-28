// =====================================================================
//                   Motorola Confidential Proprietary
//           (c) Copyright 2006, Motorola Inc. All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          May 4, 2007
// =====================================================================

/**
 *
 * @file   XurmoProperties.java
 * @author
 * @date   May 4, 2007
 *
 * @brief
 *
 *
 */
// *********************************************************************
// Package
// *********************************************************************
package com.xurmo.application;
// *********************************************************************
// Imports
// *********************************************************************



public class XurmoProperties {
  
  private static XurmoProperties self_ = null;
  
  private String microeditionConfiguration_;
  private String cldc_;
  private String locale_;
  private String encoding_;
  private String imsi_;
  private String imei_;
  private String msisdn_;
  private String cellName_;
  /**
   * Creates a new instance of XurmoProperties
   */
  private XurmoProperties() {
    
    microeditionConfiguration_ = System.getProperty("microedition.configuration");
    cldc_ = System.getProperty("microedition.profiles");
    locale_ = System.getProperty("microedition.locale");
    encoding_ = System.getProperty("microedition.encoding");
    imsi_ = System.getProperty("IMSI");
    imei_ = System.getProperty("IMEI");
    msisdn_ = System.getProperty("MSISDN");
    cellName_ = new String("Unknown");
  }
  public static XurmoProperties instance() {
    if (self_ == null) {
      self_ = new XurmoProperties();
    }
    return self_;
  }
  public void setCellName(String cellName) {
    cellName_ = cellName;
  }
  
  public String getTimeZone() {
    return System.getProperty("microedition.timezone");
  }
  public String getMicroeditionConfiguration() {
    
    return microeditionConfiguration_;
  }
  public String getCLDC() {
    return cldc_;
  }
  public String getLocale() {
    return locale_;
  }
  public String getEncoding() {
    
    return encoding_;
  }
  public String getCellID() {
    
    return  System.getProperty("CellID");
  }
  public String getLocAreaCode() {
    return System.getProperty("LocAreaCode");
  }
  public String getIMSI() {
    
    return System.getProperty("IMSI");
  }
  public String getIMEI() {
    
    return System.getProperty("IMEI");
  }
  public String getMSISDN() {
    
    return System.getProperty("MSISDN");
  }
  public String getCellName() {
    return cellName_;
  }
}
