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
  private static final String soapURL_ = baseURL_ + new String("XurmoNetworkManagementServiceBean");
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
        = (javax.microedition.io.HttpConnection)javax.microedition.io.Connector.open(soapURL_);
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
  public static XurmoNetworkMessagesStatus getNetworkMessages(String username, String cookie) {
    String soapRequest = new String("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns0=\"http://user.connect.xurmo.com/jaws\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
        "<env:Header/>\n" +
        "<env:Body>\n" +
        "<ns0:getNetworkMessages>\n" +
        "<ns0:username>" + username + "</ns0:username>\n" +
        "<ns0:cookie>" + cookie + "</ns0:cookie>\n" +
        XurmoDevice.getLocationParameters() +
        "</ns0:getNetworkMessages>\n</env:Body>\n</env:Envelope>\n");
    try {
      String resp = sendRequest(soapRequest);
      return parseNetworkMessageStatus(resp);
    } catch(IOException ioex) {
      ioex.printStackTrace();
    }
    return new XurmoNetworkMessagesStatus();
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
  public static XurmoNetworkSummaryStatus sendInvitations(String username, String cookie, String invitationsForLink) {
    String soapRequest = new String("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns0=\"http://user.connect.xurmo.com/jaws\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
        "<env:Header/>\n" +
        "<env:Body>\n" +
        "<ns0:sendInvitation>\n" +
        "<ns0:username>" + username + "</ns0:username>\n" +
        "<ns0:cookie>" + cookie + "</ns0:cookie>\n" +
        invitationsForLink +
        XurmoDevice.getLocationParameters() +
        "</ns0:sendInvitation>\n</env:Body>\n</env:Envelope>\n");
    try {
      String resp = sendRequest(soapRequest);
      return parseStatus(resp);
    } catch(IOException ioex) {
      ioex.printStackTrace();
    }
    return new XurmoNetworkSummaryStatus();
  }
  public static XurmoNetworkSummaryStatus disposeInvitations(String username, String cookie, String invitationDisposition) {
    String soapRequest = new String("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns0=\"http://user.connect.xurmo.com/jaws\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
        "<env:Header/>\n" +
        "<env:Body>\n" +
        "<ns0:disposeInvitations>\n" +
        "<ns0:username>" + username + "</ns0:username>\n" +
        "<ns0:cookie>" + cookie + "</ns0:cookie>\n" +
        invitationDisposition +
        XurmoDevice.getLocationParameters() +
        "</ns0:disposeInvitations>\n</env:Body>\n</env:Envelope>\n");
    try {
      String resp = sendRequest(soapRequest);
      return parseStatus(resp);
    } catch(IOException ioex) {
      ioex.printStackTrace();
    }
    return new XurmoNetworkSummaryStatus();
  }
  public static boolean isInteractionSuccessful(int status) {
    return status == NETWORK_INTERACTION_NO_ERROR;
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
      InputStream is = new java.io.ByteArrayInputStream(resp.getBytes());
      InputStreamReader in = new InputStreamReader( is );
      java.util.Vector contactsAlreadyUser = new java.util.Vector();
      java.util.Vector memberOfNetworks = new java.util.Vector();
      java.util.Vector availableNetworks = new java.util.Vector();
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
            } else if (tag.equalsIgnoreCase("ns1:availablenetwork")) {
              
              String an = new String(parser.nextText());
              availableNetworks.addElement(an);
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
                return new XurmoNetworkSummaryStatus(Integer.parseInt(errorCode), cookie, cellName, memberOfNetworks, contactsAlreadyUser, Integer.parseInt(numberOfContacts), availableNetworks);
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
      String linkId = null;
      String linkName = null;
      InputStream is = new java.io.ByteArrayInputStream(resp.getBytes());
      InputStreamReader in = new InputStreamReader( is );
      java.util.Vector connectableEntries = new java.util.Vector();
      java.util.Vector joinableEntries = new java.util.Vector();
      java.util.Vector linkTypes = new java.util.Vector();
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
              
            } else if (tag.equalsIgnoreCase("ns1:linktypes")) {
              linkId = null;
              linkName = null;
              
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
            } else if (tag.equalsIgnoreCase("ns1:linkId")) {
              
              linkId = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:linkName")) {
              
              linkName = new String(parser.nextText());
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
            } else if (tag.equalsIgnoreCase("ns1:joinableentries")) {
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
            } else if (tag.equalsIgnoreCase("ns1:linktypes")) {
              if (linkId != null && linkName != null) {
                XurmoNetworkLinkType xnlt
                    = new XurmoNetworkLinkType(Integer.parseInt(linkId), linkName);
                linkId = null;
                linkName = null;
                linkTypes.addElement(xnlt);
              }
            } else if (tag.equalsIgnoreCase("env:envelope")) {
              if (cellName != null && cookie != null && errorCode != null ) {
                System.out.println("Envelope close tag cellName =" + cellName + " cookie " + cookie + " errorCode " + errorCode);
                return new XurmoInviteSummary(Integer.parseInt(errorCode), cookie, cellName, connectableEntries, joinableEntries, linkTypes);
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
  public static XurmoNetworkMessagesStatus parseNetworkMessageStatus(String resp) {
    
    try {
      String cookie = null;
      String errorCode = null;
      String cellName = null;
      String linkId = null;
      String linkName = null;
      String messageId = null;
      String msg = null;
      String requestFrom = null;
      String requestTo = null;
      String usernameFrom = null;
      String usernameTo = null;
      String responseId = null;
      String responseLabel = null;
      InputStream is = new java.io.ByteArrayInputStream(resp.getBytes());
      InputStreamReader in = new InputStreamReader( is );
      java.util.Vector requestToConnectList = new java.util.Vector();
      java.util.Vector responseTypeList = new java.util.Vector();
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
            } else if (tag.equalsIgnoreCase("ns1:requesttoconnect")) {
              linkId = null;
              linkName = null;
              messageId = null;
              msg = null;
              requestFrom = null;
              requestTo = null;
              usernameFrom = null;
              usernameTo = null;
              
            } else if (tag.equalsIgnoreCase("ns1:responsetype")) {
              responseId = null;
              responseLabel = null;
              
            } else if (tag.equalsIgnoreCase("ns1:linkid")) {
              
              linkId = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:linkname")) {
              
              linkName = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:messageid")) {
              
              messageId = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:msg")) {
              
              msg = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:requestFrom")) {
              
              requestFrom = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:requestTo")) {
              
              requestTo = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:usernameFrom")) {
              
              usernameFrom = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:usernameto")) {
              
              usernameTo = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:responseid")) {
              
              responseId = new String(parser.nextText());
            } else if (tag.equalsIgnoreCase("ns1:responseLabel")) {
              
              responseLabel = new String(parser.nextText());
            }
          }
          break;
          case org.xmlpull.v1.XmlPullParser.END_TAG:
          {
            String tag = parser.getName();
            if (tag.equalsIgnoreCase("ns1:requesttoconnect")) {
              if (linkId != null && 
                  linkName != null && 
                  messageId != null && 
                  msg != null && 
                  requestFrom != null &&
                  requestTo != null &&
                  usernameFrom != null &&
                  usernameTo != null) {

                XurmoRequestToConnectMessage rtcm
                    = new XurmoRequestToConnectMessage(Integer.parseInt(linkId),
                    linkName,
                    Integer.parseInt(messageId),
                    msg,
                    Integer.parseInt(requestFrom),
                    Integer.parseInt(requestTo),
                    usernameFrom,
                    usernameTo);
              linkId = null;
              linkName = null;
              messageId = null;
              msg = null;
              requestFrom = null;
              requestTo = null;
              usernameFrom = null;
              usernameTo = null;
              requestToConnectList.addElement(rtcm);
              }
            } else if (tag.equalsIgnoreCase("ns1:responsetype")) {
              if (responseId != null && 
                  responseLabel != null) {

                XurmoNetworkMessageResponseType nmrt
                    = new XurmoNetworkMessageResponseType(Integer.parseInt(responseId),
                    responseLabel);
              responseId = null;
              responseLabel = null;
              responseTypeList.addElement(nmrt);
              }
            } else if (tag.equalsIgnoreCase("env:envelope")) {
              if (cellName != null && cookie != null && errorCode != null ) {
                System.out.println("Envelope close tag cellName =" + cellName + " cookie " + cookie + " errorCode " + errorCode);
                return new XurmoNetworkMessagesStatus(Integer.parseInt(errorCode), cookie, cellName, requestToConnectList, responseTypeList);
              } else {
                
                return new XurmoNetworkMessagesStatus();
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
    return new XurmoNetworkMessagesStatus();
  }
  public static String getStringMessage(int errorCode) {
    if (errorCode < messages_.length) {
      return messages_[errorCode];
    }
    return messages_[messages_.length - 1];
  }
  public static final int NETWORK_INTERACTION_NO_ERROR = 0;
  public static final int NETWORK_INTERACTION_COULD_NOT_UPDATE_PROFILE = 0x01;
  public static final int NETWORK_INTERACTION_COULD_NOT_SEND_INVITATION = 0x02;
  public static final int
      NETWORK_INTERACTION_COULD_NOT_SEND_MESSAGE_FOR_A_LOCATION = 0x03;
  public static final int NETWORK_INTERACTION_USER_NOT_LOGGED_IN = 0x04;
  public static final int
      NETWORK_INTERACTION_INVALID_USERNAME_OR_PASSWORD = 0x05;
  public static final int NETWORK_INTERACTION_UPLOAD_ADDRESSBOOK_FAILED = 0x06;
  public static final int
      NETWORK_INTERACTION_DOWNLOAD_ADDRESSBOOK_FAILED = 0x07;
  public static final int
      NETWORK_INTERACTION_FATAL_ERROR_WHILE_SETTING_PREFERENCES = 0x08;
  public static final int
      NETWORK_INTERACTION_COULD_NOT_RETRIEVE_INVITABLE_ENTRIES = 0x09;
  public static final int
      NETWORK_INTERACTION_SERVER_NOT_AVAILABLE = 0x10;
  
  static public final String[] messages_ = {new String("Success"),
  new String("Profile could not be updated"),
  new String("Invitation could not be sent."),
  new String("Message could not be sent."),
  new String("User is not logged in."),
  new String("Invalid username or password"),
  new String("Addressbook upload failed."),
  new String("Download addressbook failed."),
  new String("Preferences could not be updated."),
  new String("Invitation could not be sent."),
  new String("Xurmo is temporarily not available."),
  new String("Unknown Status..")
  };
  
}
