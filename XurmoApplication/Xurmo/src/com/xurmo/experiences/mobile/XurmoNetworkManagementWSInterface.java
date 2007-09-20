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
 * @file   XurmoNetworkManagementWSInterface.java
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




public class XurmoNetworkManagementWSInterface {
  
//  private static final String serverName_ = new String("mirl.miel.mot.com");
  private static final String serverName_ = new String("www.xurmoconnect.com");
  private static final String baseURL_ = new String("http://" + serverName_ + "/XurmoConnect-ejb/");
  private static final String userAuthenticationAndSessionURL_ = baseURL_ + new String("XurmoNetworkManagementServiceBean");
  private static final String userAgent_ = new String("XurmoUA Profile/MIDP-2.0 Configuration/CLDC-1.1");
  private static XurmoNetworkManagementWSInterface self_ = null;
  /**
   * Creates a new instance of XurmoUserAuthenticationAndSessionWSInterface
   */
  private XurmoNetworkManagementWSInterface() {
  }
  public static XurmoNetworkManagementWSInterface instance() {
    
    if (self_ == null) {
      self_ = new XurmoNetworkManagementWSInterface();
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
  public static XurmoNetworkSummaryStatus getNetworkSummary(String username, String cookie) {
    String soapRequest = new String("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns0=\"http://user.connect.xurmo.com/jaws\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
        "<env:Header/>\n" +
        "<env:Body>\n" +
        "<ns0:getNetworkSummary>\n" +
        "<ns0:username>" + username + "</ns0:username>\n" +
        "<ns0:cookie>" + cookie + "</ns0:cookie>\n" +
        XurmoDevice.getLocationParameters() +
        "</ns0:getNetworkSummary>\n</env:Body>\n</env:Envelope>\n");
    try {
      String resp = sendRequest(soapRequest);
      return parseStatus(resp);
    } catch(IOException ioex) {
      ioex.printStackTrace();
    }
    return new XurmoNetworkSummaryStatus();
  }
  public static XurmoInviteSummary getInvitablePhoneBookEntries(String username, String cookie) {
    String soapRequest = new String("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns0=\"http://user.connect.xurmo.com/jaws\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
        "<env:Header/>\n" +
        "<env:Body>\n" +
        "<ns0:getInvitablePhoneBookEntries>\n" +
        "<ns0:username>" + username + "</ns0:username>\n" +
        "<ns0:cookie>" + cookie + "</ns0:cookie>\n" +
        XurmoDevice.getLocationParameters() +
        "</ns0:getInvitablePhoneBookEntries>\n</env:Body>\n</env:Envelope>\n");
    try {
      String resp = sendRequest(soapRequest);
      return parseInviteSummaryStatus(resp);
    } catch(IOException ioex) {
      ioex.printStackTrace();
    }
    return new XurmoInviteSummary();
  }
  public static boolean isInteractionSuccessful(int status) {
    return status == NETWORK_INTERACTION_SUCCESS;
  }
  public static XurmoNetworkSummaryStatus parseStatus(String resp) {
    
    try {
      String cookie = null;
      String errorCode = null;
      String cellName = null;
      String numberOfContacts = null;
      boolean doingContacts = false;
      String fname = null;
      String lname = null;
      String userid = null;
      String username = null;
      System.out.println("Response " + resp);
      InputStream is = new java.io.ByteArrayInputStream(resp.getBytes());
      InputStreamReader in = new InputStreamReader( is );
      java.util.Vector contactsAlreadyUser = new java.util.Vector();
      java.util.Vector memberOfNetworks = new java.util.Vector();
      //Initilialize XML parser
      KXmlParser parser = new KXmlParser();
      parser.setInput(in);
      while(true){
        int evt = parser.nextTag();
        switch(evt){
          case org.xmlpull.v1.XmlPullParser.START_TAG:
          {
            String tag = parser.getName();
            System.out.println(tag);
            if (tag.equalsIgnoreCase("ns1:errorcode")) {
              errorCode = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:cookie")) {
              cookie = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:cellname")) {
              cellName = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:numberofcontacts")) {
              
              numberOfContacts = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:contactsalreadyuser")) {

              doingContacts = true;
            } else if (tag.equalsIgnoreCase("ns1:memberofnetworks")) {

              String nw = new String(parser.nextText());
              memberOfNetworks.addElement(nw);
              doingContacts = false;
            } else if (tag.equalsIgnoreCase("ns1:fname")) {

              if (doingContacts) {
                fname = new String(parser.nextText());
              }
            } else if (tag.equalsIgnoreCase("ns1:lname")) {

              if (doingContacts) {
                lname = new String(parser.nextText());
              }
            } else if (tag.equalsIgnoreCase("ns1:userid")) {

              if (doingContacts) {
                userid = new String(parser.nextText());
              }
            } else if (tag.equalsIgnoreCase("ns1:username")) {

              if (doingContacts) {
                username = new String(parser.nextText());
              }
            }
         }
          break;
          case org.xmlpull.v1.XmlPullParser.END_TAG:
          {
            String tag = parser.getName();
            if (tag.equalsIgnoreCase("ns1:contactsalreadyuser")) {
              if (fname != null && lname != null && userid != null && username != null) {
                XurmoUserGlobalData xugd = new XurmoUserGlobalData(Integer.parseInt(userid), username, fname, lname);
                userid = null;
                username = null;
                fname = null;
                lname = null;
                contactsAlreadyUser.addElement(xugd);
                doingContacts = false;
              }
            } else if (tag.equalsIgnoreCase("env:envelope")) {
              if (cellName != null && cookie != null && errorCode != null && numberOfContacts != null) {
                System.out.println("Envelope close tag cellName =" + cellName + " cookie " + cookie + " errorCode " + errorCode + " number of contacts " + numberOfContacts);
                return new XurmoNetworkSummaryStatus(Integer.parseInt(errorCode), cookie, cellName, memberOfNetworks, contactsAlreadyUser, Integer.parseInt(numberOfContacts));
              } else {
                
                return new XurmoNetworkSummaryStatus();
              }
            }
            
          }
          break;
        }
      }
    } catch (org.xmlpull.v1.XmlPullParserException ppex) {
      
      ppex.printStackTrace();
      System.out.println("" +ppex.getLineNumber() + ":" + " Column " + ppex.getColumnNumber() + " " + ppex.getDetail());
      
    } catch(IOException e){
    }
    return new XurmoNetworkSummaryStatus();
  }
  public static XurmoInviteSummary parseInviteSummaryStatus(String resp) {
    
    try {
      String cookie = null;
      String errorCode = null;
      String cellName = null;
      String contactName = null;
      String member = null;
      String memberid = null;
      String mobileNumber = null;
      String uniqueId = null;
      System.out.println("Response " + resp);
      InputStream is = new java.io.ByteArrayInputStream(resp.getBytes());
      InputStreamReader in = new InputStreamReader( is );
      java.util.Vector connectableEntries = new java.util.Vector();
      java.util.Vector joinableEntries = new java.util.Vector();
      //Initilialize XML parser
      KXmlParser parser = new KXmlParser();
      parser.setInput(in);
      while(true){
        int evt = parser.nextTag();
        switch(evt){
          case org.xmlpull.v1.XmlPullParser.START_TAG:
          {
            String tag = parser.getName();
            System.out.println(tag);
            if (tag.equalsIgnoreCase("ns1:errorcode")) {
              errorCode = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:cookie")) {
              cookie = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:cellname")) {
              cellName = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:connectableentries")) {
                contactName = null;
                member = null;
                memberid = null;
                mobileNumber = null;
                uniqueId = null;

            } else if (tag.equalsIgnoreCase("ns1:joinableentries")) {
                contactName = null;
                member = null;
                memberid = null;
                mobileNumber = null;
                uniqueId = null;

            } else if (tag.equalsIgnoreCase("ns1:contactName")) {

                contactName = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:member")) {

                member = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:memberid")) {

                memberid = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:mobileNumber")) {

                mobileNumber = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:uniqueId")) {

                uniqueId = new String(parser.nextText());
            }
         }
          break;
          case org.xmlpull.v1.XmlPullParser.END_TAG:
          {
            String tag = parser.getName();
            if (tag.equalsIgnoreCase("ns1:connectableentries")) {
              if (contactName != null && member != null && memberid != null && mobileNumber != null && uniqueId != null) {
                XurmoInvitePhoneBookEntry xipbe 
                  = new XurmoInvitePhoneBookEntry(contactName, member, memberid, mobileNumber, uniqueId);
                contactName = null;
                member = null;
                memberid = null;
                mobileNumber = null;
                uniqueId = null;
                connectableEntries.addElement(xipbe);
              }
            }
            else if (tag.equalsIgnoreCase("ns1:joinableentries")) {
              if (contactName != null && member != null && memberid != null && mobileNumber != null && uniqueId != null) {
                XurmoInvitePhoneBookEntry xipbe 
                  = new XurmoInvitePhoneBookEntry(contactName, member, memberid, mobileNumber, uniqueId);
                contactName = null;
                member = null;
                memberid = null;
                mobileNumber = null;
                uniqueId = null;
                joinableEntries.addElement(xipbe);
              }
            } else if (tag.equalsIgnoreCase("env:envelope")) {
              if (cellName != null && cookie != null && errorCode != null ) {
                System.out.println("Envelope close tag cellName =" + cellName + " cookie " + cookie + " errorCode " + errorCode);
                return new XurmoInviteSummary(Integer.parseInt(errorCode), cookie, cellName, connectableEntries, joinableEntries);
              } else {
                
                return new XurmoInviteSummary();
              }
            }
            
          }
          break;
        }
      }
    } catch (org.xmlpull.v1.XmlPullParserException ppex) {
      
      ppex.printStackTrace();
      System.out.println("" +ppex.getLineNumber() + ":" + " Column " + ppex.getColumnNumber() + " " + ppex.getDetail());
      
    } catch(IOException e){
    }
    return new XurmoInviteSummary();
  }
  static public final int NETWORK_INTERACTION_SUCCESS = 0;
  static public final int NETWORK_INTERACTION_STATUS_SUCCESS_MOBILE_NOT_VALIDATED = 1;
  static public final int NETWORK_INTERACTION_STATUS_FAILURE_SESSION_NEVER_EXISTED = 2;
  static public final int NETWORK_INTERACTION_STATUS_FAILURE_MOBILE_NUMBER_AUTHENTICATION_FAILED = 3;
  static public final int NETWORK_INTERACTION_STATUS_FAILURE_EMAIL_AUTHENTICATION_FAILED = 4;
  static public final int NETWORK_INTERACTION_STATUS_FAILURE_ACCOUNT_CREATION_ERROR = 5;
  static public final int NETWORK_INTERACTION_STATUS_FAILURE_USER_DOES_NOT_EXIST = 6;
  static public final int NETWORK_INTERACTION_STATUS_FAILURE_ADDRESS_NOT_VALIDATED = 7;
  static public final int NETWORK_INTERACTION_STATUS_FAILURE_INCORRECT_USERNAME_OR_PASSWORD = 8;
  static public final int NETWORK_INTERACTION_STATUS_FAILURE_SESSION_TIMED_OUT = 9;
  static public final int NETWORK_INTERACTION_STATUS_FAILURE_USER_NOT_ACTIVE = 10;
  static public final int NETWORK_INTERACTION_STATUS_SERVER_UNAVAILABLE = 11;
  
  
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
