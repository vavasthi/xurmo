// =====================================================================
//                           Xurmo Proprietary
//               (c) Copyright 2007, Xurmo, All Rights Reserved
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
 * @file   XurmoUserAuthenticationAndSessionWSInterface.java
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
package com.xurmo.experiences.mobile;
// *********************************************************************
// Imports
// *********************************************************************
import java.io.*;
import org.kxml2.io.*;




public class XurmoUserAuthenticationAndSessionWSInterface {
  
//  private static final String serverName_ = new String("mirl.miel.mot.com");
  private static final String serverName_ = new String("www.xurmoconnect.com");
  private static final String baseURL_ = new String("http://" + serverName_ + "/XurmoConnect-ejb/");
  private static final String userAuthenticationAndSessionURL_ = baseURL_ + new String("XurmoUserManagementServiceBean");
  private static final String userAgent_ = new String("XurmoUA Profile/MIDP-2.0 Configuration/CLDC-1.1");
  private static XurmoUserAuthenticationAndSessionWSInterface self_ = null;
  /**
   * Creates a new instance of XurmoUserAuthenticationAndSessionWSInterface
   */
  private XurmoUserAuthenticationAndSessionWSInterface() {
  }
  public static XurmoUserAuthenticationAndSessionWSInterface instance() {
    
    if (self_ == null) {
      self_ = new XurmoUserAuthenticationAndSessionWSInterface();
    }
    return self_;
  }
  public static String sendRequest(String request) throws IOException {
    
    
    javax.microedition.io.HttpConnection conn
        = (javax.microedition.io.HttpConnection)javax.microedition.io.Connector.open(userAuthenticationAndSessionURL_);
    conn.setRequestMethod(conn.POST);
    conn.setRequestProperty("User-Agent", userAgent_);
    conn.setRequestProperty("Content-Length",String.valueOf(request.length()));
    DataOutputStream dos = new DataOutputStream(conn.openOutputStream());
    dos.write(request.getBytes());
    dos.flush();
    DataInputStream dis = new DataInputStream(conn.openInputStream());
    StringBuffer sb = new StringBuffer();
    int ch;
    while ((ch = dis.read()) != -1) {
      sb.append((char)ch);
    }
    String resp = sb.toString();
    dis.close();
    dos.close();
    conn.close();
    return resp;
  }
  public static XurmoUserAuthenticationReturnStatus registerUser(String username, String password, String salutation, String firstName, String lastName, String mobile, String email, String gender, String dob) {
    String soapRequest = new String("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns0=\"http://user.connect.xurmo.com/jaws\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
        "<env:Header/>\n" +
        "<env:Body>\n" +
        "<ns0:createUser>\n" +
        "<ns0:username>" + username + "</ns0:username>\n" +
        "<ns0:password>" + password + "</ns0:password>\n" +
        "<ns0:salutation>" + salutation + "</ns0:salutation>\n" +
        "<ns0:fname>" + firstName + "</ns0:fname>\n" +
        "<ns0:lname>" + lastName + "</ns0:lname>\n" +
        "<ns0:mobile>" + mobile + "</ns0:mobile>\n" +
        "<ns0:email>" + email + "</ns0:email>\n" +
        "<ns0:gender>" + gender + "</ns0:gender>\n" +
        "<ns0:dob>" + dob + "</ns0:dob>\n" +
        "<ns0:imei>" + XurmoDevice.imei_ + "</ns0:imei>\n" +
        "<ns0:btAddress>" + XurmoBluetoothServiceListener.instance().localBtAddress() + "</ns0:btAddress>\n" +
        XurmoDevice.getLocationParameters() +
        "</ns0:createUser>\n</env:Body>\n</env:Envelope>\n");
    try {
      String resp = sendRequest(soapRequest);
      return parseStatus(resp);
    } catch(IOException ioex) {
      ioex.printStackTrace();
    }
    return new XurmoUserAuthenticationReturnStatus();
  }
  public static XurmoUserHomeScreenData loginUser(String username, String password) {
    String soapRequest = new String("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns0=\"http://user.connect.xurmo.com/jaws\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
        "<env:Header/>\n" +
        "<env:Body>\n" +
        "<ns0:doLogin>\n" +
        "<ns0:username>" + username + "</ns0:username>\n" +
        "<ns0:password>" + password + "</ns0:password>\n" +
        "<ns0:imei>" + XurmoDevice.imei_ + "</ns0:imei>\n" +
        XurmoDevice.getLocationParameters() +
        "</ns0:doLogin>\n</env:Body>\n</env:Envelope>\n");
    try {
      String resp = sendRequest(soapRequest);
      return parseHomeScreenData(resp);
    } catch(IOException ioex) {
      ioex.printStackTrace();
    }
    return new XurmoUserHomeScreenData();
  }
  public static XurmoUserHomeScreenData uploadPhoneBook(String username, String cookie) {
    String soapRequest = new String("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns0=\"http://user.connect.xurmo.com/jaws\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
        "<env:Header/>\n" +
        "<env:Body>\n" +
        "<ns0:uploadPhoneBook>\n" +
        "<ns0:username>" + username + "</ns0:username>\n" +
        "<ns0:cookie>" + cookie + "</ns0:cookie>\n" +
        XurmoDevice.getLocationParameters() +
        XurmoPhoneBookInterface.getUploadContactXML() +
        "</ns0:uploadPhoneBook>\n</env:Body>\n</env:Envelope>\n");
    try {
      String resp = sendRequest(soapRequest);
      return parseHomeScreenData(resp);
    } catch(IOException ioex) {
      ioex.printStackTrace();
    }
    return new XurmoUserHomeScreenData();
  }
  public static XurmoUserAuthenticationReturnStatus logoutUser(String username, String cookie) {
    String soapRequest = new String("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns0=\"http://user.connect.xurmo.com/jaws\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
        "<env:Header/>\n" +
        "<env:Body>\n" +
        "<ns0:doLogout>\n" +
        "<ns0:username>" + username + "</ns0:username>\n" +
        "<ns0:cookie>" + cookie+ "</ns0:cookie>\n" +
        "</ns0:doLogout>\n</env:Body>\n</env:Envelope>\n");
    try {
      String resp = sendRequest(soapRequest);
      return parseStatus(resp);
    } catch(IOException ioex) {
      ioex.printStackTrace();
    }
    return new XurmoUserAuthenticationReturnStatus();
  }
  public static XurmoUserAuthenticationReturnStatus updateLocation(String username, String cookie, String presence) {
    String soapRequest = new String("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns0=\"http://user.connect.xurmo.com/jaws\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
        "<env:Header/>\n" +
        "<env:Body>\n" +
        "<ns0:updateLocation>\n" +
        "<ns0:username>" + username + "</ns0:username>\n" +
        "<ns0:cookie>" + cookie+ "</ns0:cookie>\n" +
        "<ns0:imei>" + XurmoDevice.imei_ + "</ns0:imei>\n" +
        "<ns0:presence>" + presence + "</ns0:presence>\n" +
        XurmoDevice.getLocationParameters() +
        "</ns0:updateLocation>\n</env:Body>\n</env:Envelope>\n");
    try {
      String resp = sendRequest(soapRequest);
      return parseStatus(resp);
    } catch(IOException ioex) {
      ioex.printStackTrace();
    }
    return new XurmoUserAuthenticationReturnStatus();
  }
  public static XurmoUserHomeScreenData homeScreenData(String username, String cookie, String presence) {
    String soapRequest = new String("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns0=\"http://user.connect.xurmo.com/jaws\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
        "<env:Header/>\n" +
        "<env:Body>\n" +
        "<ns0:getHomeScreenData>\n" +
        "<ns0:username>" + username + "</ns0:username>\n" +
        "<ns0:cookie>" + cookie+ "</ns0:cookie>\n" +
        "<ns0:imei>" + XurmoDevice.imei_ + "</ns0:imei>\n" +
        "<ns0:presence>" + presence + "</ns0:presence>\n" +
        XurmoDevice.getLocationParameters() +
        "</ns0:getHomeScreenData>\n</env:Body>\n</env:Envelope>\n");
    try {
      String resp = sendRequest(soapRequest);
      return parseHomeScreenData(resp);
    } catch(IOException ioex) {
      ioex.printStackTrace();
    }
    return new XurmoUserHomeScreenData();
  }
  public static String getAuthenticationStringMessage(XurmoUserAuthenticationReturnStatus status) {
    if (status == null) {
      return messages_[USER_AUTHENTICATION_STATUS_SERVER_UNAVAILABLE];
    } else if (status.errorCode_ >= messages_.length - 1) {
      return messages_[messages_.length - 1];
    }
    return messages_[status.errorCode_];
  }
  public static boolean isAuthenticationStatusSuccessful(int status) {
    return status == USER_AUTHENTICATION_SUCCESS;
  }
  public static XurmoUserAuthenticationReturnStatus parseStatus(String resp) {
    
    try {
      String cookie = null;
      String errorCode = null;
      String cellName = null;
      InputStream is = new java.io.ByteArrayInputStream(resp.getBytes());
      InputStreamReader in = new InputStreamReader( is );
      //Initilialize XML parser
      KXmlParser parser = new KXmlParser();
      parser.setInput(in);
      while(true){
        int evt = parser.nextTag();
        switch(evt){
          case org.xmlpull.v1.XmlPullParser.START_TAG:
          {
            String tag = parser.getName();
            if (tag.equalsIgnoreCase("ns1:errorcode")) {
              errorCode = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:cookie")) {
              cookie = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:cellName")) {
              cellName = new String(parser.nextText());
            }
          }
          break;
          case org.xmlpull.v1.XmlPullParser.END_TAG:
          {
            String tag = parser.getName();
            if (tag.equalsIgnoreCase("env:envelope")) {
              if (cellName != null && cookie != null && errorCode != null) {
                
                return new XurmoUserAuthenticationReturnStatus(cookie, Integer.parseInt(errorCode), cellName);
              } else {
                
                return new XurmoUserAuthenticationReturnStatus();
              }
            }
            
          }
          break;
        }
      }
    } catch (org.xmlpull.v1.XmlPullParserException ppex) {
      
    } catch(IOException e){
    }
    return new XurmoUserAuthenticationReturnStatus();
  }
  public static XurmoUserHomeScreenData parseHomeScreenData(String resp) {
    
    try {
      String fname = null;
      String lname = null;
      String cookie = null;
      String errorCode = null;
      String cellName = null;
      String salutation = null;
      String username = null;
      String presence = null;
      XurmoUserAuthenticationReturnStatus status = null;
      InputStream is = new java.io.ByteArrayInputStream(resp.getBytes());
      InputStreamReader in = new InputStreamReader( is );
      //Initilialize XML parser
      KXmlParser parser = new KXmlParser();
      parser.setInput(in);
      while(true){
        int evt = parser.nextTag();
        switch(evt){
          case org.xmlpull.v1.XmlPullParser.START_TAG:
          {
            String tag = parser.getName();
            if (tag.equalsIgnoreCase("ns1:fname")) {
              fname = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:lname")) {
              lname = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:errorcode")) {
              errorCode = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:cookie")) {
              cookie = new String(parser.nextText());
            } else if(tag.equalsIgnoreCase("ns1:cellName")) {
              cellName = new String(parser.nextText());
            } else if(tag.equalsIgnoreCase("ns1:salutation")) {
              salutation = new String(parser.nextText());
            } else if(tag.equalsIgnoreCase("ns1:username")) {
              username = new String(parser.nextText());
            } else if(tag.equalsIgnoreCase("ns1:presence")) {
              presence = new String(parser.nextText());
            }
          }
          break;
          case org.xmlpull.v1.XmlPullParser.END_TAG:
          {
            String tag = parser.getName();
            if (tag.equalsIgnoreCase("env:envelope")) {
              if (fname != null && lname != null && errorCode != null && cookie != null && cellName != null && presence != null) {
                
              return new XurmoUserHomeScreenData(username, cookie, Integer.parseInt(errorCode), cellName, fname, lname, salutation, presence);
              }
              else {
                
              return new XurmoUserHomeScreenData();
              }
            }
            
          }
          break;
        }
      }
    } catch (org.xmlpull.v1.XmlPullParserException ppex) {
      
    } catch(IOException e){
    }
    return new XurmoUserHomeScreenData();
  }
  public XurmoDoodleSummary getDoodleSummary(String username, String cookie) {
    XurmoDoodleSummary mds = new XurmoDoodleSummary();
    mds.addDoodleSummaryForALocation(1, "Forum", 3);
    mds.addDoodleSummaryForALocation(7, "Bangalore Central", 5);
    return mds;
  }
  static public final int USER_AUTHENTICATION_SUCCESS = 0;
  static public final int USER_AUTHENTICATION_STATUS_SUCCESS_MOBILE_NOT_VALIDATED = 1;
  static public final int USER_AUTHENTICATION_STATUS_FAILURE_SESSION_NEVER_EXISTED = 2;
  static public final int USER_AUTHENTICATION_STATUS_FAILURE_MOBILE_NUMBER_AUTHENTICATION_FAILED = 3;
  static public final int USER_AUTHENTICATION_STATUS_FAILURE_EMAIL_AUTHENTICATION_FAILED = 4;
  static public final int USER_AUTHENTICATION_STATUS_FAILURE_ACCOUNT_CREATION_ERROR = 5;
  static public final int USER_AUTHENTICATION_STATUS_FAILURE_USER_DOES_NOT_EXIST = 6;
  static public final int USER_AUTHENTICATION_STATUS_FAILURE_ADDRESS_NOT_VALIDATED = 7;
  static public final int USER_AUTHENTICATION_STATUS_FAILURE_INCORRECT_USERNAME_OR_PASSWORD = 8;
  static public final int USER_AUTHENTICATION_STATUS_FAILURE_SESSION_TIMED_OUT = 9;
  static public final int USER_AUTHENTICATION_STATUS_FAILURE_USER_NOT_ACTIVE = 10;
  static public final int USER_AUTHENTICATION_STATUS_SERVER_UNAVAILABLE = 11;
  
  
  static public final String[] messages_ = {new String("Success"),
  new String("Success but mobile not validated."),
  new String("Success, Session never existed"),
  new String("Failure, Mobile Number Authentication Failed"),
  new String("Failure, Email Authentication Failed"),
  new String("Failure, Account Creation Error"),
  new String("Failure, User Does Not Exist"),
  new String("Failure, Address Not Validated"),
  new String("Failure, Incorrect Username or Password"),
  new String("Failure, Session Timedout"),
  new String("Failure, User Not Active"),
  new String("Failure, Service is not available or sent garbled message."),
  new String("Unknown Status..")
  };
  
}
