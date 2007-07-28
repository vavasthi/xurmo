// =====================================================================
//                   Motorola Confidential Proprietary
//           (c) Copyright 2006, Motorola Inc. All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          May 5, 2007
// =====================================================================

/**
 *
 * @file   XurmoAuthenticationDataStore.java
 * @author
 * @date   May 5, 2007
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

import javax.microedition.rms.*;
import java.io.*;

public class XurmoAuthenticationDataStore {
  
  /** Creates a new instance of XurmoAuthenticationDataStore */
  private XurmoAuthenticationDataStore() {
    recordName_ = new String("XurmoUserAuthentication");
    if (loadUsernameAndPasswordIfExist()) {
      dataExists_ = true;
    } else {
      dataExists_ = false;
    }
  }
  public boolean dataExists() {
    return dataExists_;
  }
  public void setUsernameAndPassword(String username, String password) {
    username_ = username;
    password_ = password;
    storeUsernameAndPassword();
  }
  public static XurmoAuthenticationDataStore instance() {
    if (self_ == null) {
      self_ = new XurmoAuthenticationDataStore();
    }
    return self_;
  }
  private void storeUsernameAndPassword() {
    try {
      RecordStore rs = RecordStore.openRecordStore(recordName_, true);
      
      ByteArrayOutputStream bout = new ByteArrayOutputStream();
      DataOutputStream dout = new DataOutputStream( bout );
      
      dout.writeUTF(username_);
      dout.writeUTF(password_);
      dout.flush();
      byte[] data = bout.toByteArray();
      rs.addRecord(data, 0, data.length);
      System.out.println("create private rs");
      System.out.println(rs.getName());
    } catch (RecordStoreFullException e) {
      System.err.println("Create Address Book Error:");
      e.printStackTrace();
    } catch (RecordStoreNotFoundException e) {
      System.err.println("Create Address Book Error:");
      e.printStackTrace();
    } catch (RecordStoreException e) {
      System.err.println("Create Address Book Error:");
      e.printStackTrace();
    } catch (IOException e) {
      System.err.println("IO Exception");
      e.printStackTrace();
    }
  }
  private boolean loadUsernameAndPasswordIfExist() {
    try {
      RecordStore rs = RecordStore.openRecordStore(recordName_, true);
      
      byte[] data = rs.getRecord(1);
      System.out.println("Loading username and password");
      
      ByteArrayInputStream bin = new ByteArrayInputStream(data);
      DataInputStream din = new DataInputStream( bin );
      
      username_ = din.readUTF();
      password_ = din.readUTF();
      return true;
    } catch (RecordStoreFullException e) {
      System.err.println("Create Authentication Error:");
      e.printStackTrace();
    } catch (RecordStoreNotFoundException e) {
      System.err.println("Create Authentication Error:");
      e.printStackTrace();
    } catch (RecordStoreException e) {
      System.err.println("Create Authentication Error:");
      e.printStackTrace();
    } catch (IOException e) {
      System.err.println("IO Exception");
      e.printStackTrace();
    }
    return false;
  }
  private static XurmoAuthenticationDataStore self_ = null;
  private final String recordName_;
  private String username_;
  private String password_;
  private boolean dataExists_;
}
