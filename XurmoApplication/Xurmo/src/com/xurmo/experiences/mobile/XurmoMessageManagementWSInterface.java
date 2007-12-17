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
 * @file   XurmoMessageManagementWSInterface.java
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




public class XurmoMessageManagementWSInterface {
  
//  private static final String serverName_ = new String("mirl.miel.mot.com");
  private static final String serverName_ = new String("www.xurmoconnect.com");
  private static final String baseURL_ = new String("http://" + serverName_ + "/XurmoConnect-ejb/");
  private static final String soapURL_ = baseURL_ + new String("XurmoMessageManagementServiceBean");
  private static final String userAgent_ = new String("XurmoUA Profile/MIDP-2.0 Configuration/CLDC-1.1");
  private static XurmoMessageManagementWSInterface self_ = null;
  /**
   * Creates a new instance of XurmoUserAuthenticationAndSessionWSInterface
   */
  private XurmoMessageManagementWSInterface() {
  }
  public static XurmoMessageManagementWSInterface instance() {
    
    if (self_ == null) {
      self_ = new XurmoMessageManagementWSInterface();
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
  public static XurmoMessageStatus sendMessageToNetwork(String username, String cookie, String[] linkNames, int dos, String content) {
    String networks = new String("");
    for (int i = 0; i < linkNames.length; ++i) {
      networks += "<ns0:linkNames>" + linkNames[i] + "</ns0:linkNames>\n";
    }
    String soapRequest = new String("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns0=\"http://user.connect.xurmo.com/jaws\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
        "<env:Header/>\n" +
        "<env:Body>\n" +
        "<ns0:sendMessageToNetwork>\n" +
        "<ns0:username>" + username + "</ns0:username>\n" +
        "<ns0:cookie>" + cookie + "</ns0:cookie>\n" +
        networks +
        "<ns0:degreesOfSeparation>" + dos + "</ns0:degreesOfSeparation>\n" +
        "<ns0:content>" + content + "</ns0:content>\n" +
        XurmoDevice.getLocationParameters() +
        "</ns0:sendMessageToNetwork>\n</env:Body>\n</env:Envelope>\n");
    System.out.println("Sending message to network " + soapRequest);
    try {
      String resp = sendRequest(soapRequest);
      return parseStatus(resp);
    } catch(IOException ioex) {
      ioex.printStackTrace();
    }
    return new XurmoMessageStatus();
  }
  public static XurmoReceivedMessages getUserMessages(String username, String cookie) {

    String soapRequest = new String("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns0=\"http://user.connect.xurmo.com/jaws\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
        "<env:Header/>\n" +
        "<env:Body>\n" +
        "<ns0:getUserMessages>\n" +
        "<ns0:username>" + username + "</ns0:username>\n" +
        "<ns0:cookie>" + cookie + "</ns0:cookie>\n" +
        XurmoDevice.getLocationParameters() +
        "</ns0:getUserMessages>\n</env:Body>\n</env:Envelope>\n");
    System.out.println("Sending message to network " + soapRequest);
    try {
      String resp = sendRequest(soapRequest);
      return parseReceivedMessages(resp);
    } catch(IOException ioex) {
      ioex.printStackTrace();
    }
    return new XurmoReceivedMessages();
  }
  public static boolean isInteractionSuccessful(int status) {
    return status == MESSAGE_INTERACTION_NO_ERROR;
  }
  public static XurmoMessageStatus parseStatus(String resp) {
    
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
            } 
          }
          break;
          case org.xmlpull.v1.XmlPullParser.END_TAG:
          {
            String tag = parser.getName();
            if (tag.equalsIgnoreCase("env:envelope")) {
              if (cellName != null && cookie != null && errorCode != null && numberOfContacts != null) {
                System.out.println("Envelope close tag cellName =" + cellName + " cookie " + cookie + " errorCode " + errorCode);
                return new XurmoMessageStatus(cookie, Integer.parseInt(errorCode), cellName);
              } else {
                
                return new XurmoMessageStatus();
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
    return new XurmoMessageStatus();
  }
  
  public static XurmoReceivedMessages parseReceivedMessages(String resp) {
    
    try {
      String cookie = null;
      String errorCode = null;
      String cellName = null;

      InputStream is = new java.io.ByteArrayInputStream(resp.getBytes());
      InputStreamReader in = new InputStreamReader( is );
      java.util.Vector messages = new java.util.Vector();
      
      String content = null;
      String degreesOfSeparation = null;
      String linkId = null;
      String linkName = null;
      String messageId = null;
      String senderFname = null;
      String senderLname = null;
      String senderSalutation = null;
      String senderUsername = null;
      String userid = null;

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
            } else if(tag.equalsIgnoreCase("ns1:content")) {
              content = new String(parser.nextText());
            } else if(tag.equalsIgnoreCase("ns1:degreesOfSeparation")) {
              degreesOfSeparation = new String(parser.nextText());
            } else if(tag.equalsIgnoreCase("ns1:linkId")) {
              linkId = new String(parser.nextText());
            } else if(tag.equalsIgnoreCase("ns1:linkName")) {
              linkName = new String(parser.nextText());
            } else if(tag.equalsIgnoreCase("ns1:messageId")) {
              messageId = new String(parser.nextText());
            } else if(tag.equalsIgnoreCase("ns1:senderFname")) {
              senderFname = new String(parser.nextText());
            } else if(tag.equalsIgnoreCase("ns1:senderLname")) {
              senderLname = new String(parser.nextText());
            } else if(tag.equalsIgnoreCase("ns1:senderSalutation")) {
              senderSalutation = new String(parser.nextText());
            } else if(tag.equalsIgnoreCase("ns1:senderUsername")) {
              senderUsername = new String(parser.nextText());
            } else if(tag.equalsIgnoreCase("ns1:userid")) {
              userid = new String(parser.nextText());
            } 
          }
          break;
          case org.xmlpull.v1.XmlPullParser.END_TAG:
          {
            String tag = parser.getName();
            if (tag.equalsIgnoreCase("ns1:message")) {
              if (content != null &&
                  degreesOfSeparation != null &&
                  linkId != null &&
                  linkName != null &&
                  messageId != null &&
                  senderFname != null &&
                  senderLname != null &&
                  senderSalutation != null &&
                  senderUsername != null &&
                  userid != null) {
                
                System.out.println("Message tag close messageId  =" + messageId + " linkName " + linkName + " senderUsername " + senderUsername);
                XurmoMessage msg = new XurmoMessage(Integer.parseInt(userid),
                senderUsername,
                senderSalutation,
                senderFname,
                senderLname,
                messageId,
                Integer.parseInt(linkId),
                linkName,
                Integer.parseInt(degreesOfSeparation),
                content);
                messages.addElement(msg);
              }
              content = null;
              degreesOfSeparation = null;
              linkId = null;
              linkName = null;
              messageId = null;
              senderFname = null;
              senderLname = null;
              senderSalutation = null;
              senderUsername = null;
              userid = null;

            } else if (tag.equalsIgnoreCase("env:envelope")) {
              if (cellName != null && cookie != null && errorCode != null && messages.size() > 0) {
                System.out.println("Envelope close tag cellName =" + cellName + " cookie " + cookie + " errorCode " + errorCode);
                return XurmoReceivedMessages.create(cookie, Integer.parseInt(errorCode), cellName, messages);
              } else {
                
                return new XurmoReceivedMessages();
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
    return new XurmoReceivedMessages();
  }
  public static String getStringMessage(int errorCode) {
    if (errorCode < messages_.length) {
      return messages_[errorCode];
    }
    return messages_[messages_.length - 1];
  }
  public static final int MESSAGE_INTERACTION_NO_ERROR = 0;
  public static final int MESSAGE_INTERACTION_COULD_NOT_UPDATE_PROFILE = 0x01;
  public static final int MESSAGE_INTERACTION_COULD_NOT_SEND_INVITATION = 0x02;
  public static final int
      MESSAGE_INTERACTION_COULD_NOT_SEND_MESSAGE_FOR_A_LOCATION = 0x03;
  public static final int MESSAGE_INTERACTION_USER_NOT_LOGGED_IN = 0x04;
  public static final int
      MESSAGE_INTERACTION_INVALID_USERNAME_OR_PASSWORD = 0x05;
  public static final int MESSAGE_INTERACTION_UPLOAD_ADDRESSBOOK_FAILED = 0x06;
  public static final int
      MESSAGE_INTERACTION_DOWNLOAD_ADDRESSBOOK_FAILED = 0x07;
  public static final int
      MESSAGE_INTERACTION_FATAL_ERROR_WHILE_SETTING_PREFERENCES = 0x08;
  public static final int
      MESSAGE_INTERACTION_COULD_NOT_RETRIEVE_INVITABLE_ENTRIES = 0x09;
  public static final int
      MESSAGE_INTERACTION_SERVER_NOT_AVAILABLE = 0x10;
  
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
