/*
 * XurmoMessage.java
 *
 * Created on December 18, 2007, 12:34 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author Vinay
 */
public class XurmoMessage {
  
  XurmoReceivedContentItem[] items_;
  int senderid_;
  String senderUsernam_;
  String senderSaluation_;
  String senderFname_;
  String senderLname_;
  String messageId_;
  int linkId_;
  String linkName_;
  int degreesOfSeparation_;
  /** Creates a new instance of XurmoMessage */
  public XurmoMessage(int senderid,
      String senderUsername,
      String senderSaluation,
      String senderFname,
      String senderLname,
      String messageId,
      int linkId,
      String linkName,
      int degreesOfSeparation,
      String content) {

    try {
      
    byte[] buf = XurmoBase64DecoderStream.decode(content.getBytes());
    java.io.ByteArrayInputStream bis = new java.io.ByteArrayInputStream(buf);
    java.io.DataInputStream dis = new java.io.DataInputStream(bis);
    int size = dis.readInt();
    items_ = new XurmoReceivedContentItem[size];
    for (int i = 0; i < size; ++i) {
      items_[i] = XurmoReceivedContentItem.streamIn(dis);
    }
    }
    catch(java.io.IOException ioex) {
      System.out.println("Error in parsing message..");
    }
  }
}
