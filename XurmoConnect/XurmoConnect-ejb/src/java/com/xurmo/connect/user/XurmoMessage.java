/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoMessage.java
 * Created on               : November 18, 2007, 2:38 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import bsh.This;

/**
 *
 * @author xurmo
 */
public class XurmoMessage implements java.io.Serializable {
  
  /** Creates a new instance of XurmoMessage */
  private XurmoMessage(String messageId, 
      int linkId,
      String linkName,
      int senderid,
      String senderUsername,
      String senderFname,
      String senderLname,
      String senderSalutation,
      int degreesOfSeparation, 
      String content) {
    
    this.messageId = messageId;
    this.linkId = linkId;
    this.linkName = linkName;
    this.senderid = senderid;
    this.senderUsername = senderUsername;
    this.senderFname = senderFname;
    this.senderLname = senderLname;
    this.senderSalutation = senderSalutation;
    this.degreesOfSeparation = degreesOfSeparation;
    this.content = content;
  }
  public static XurmoMessage create(XurmoMessageForNetwork xmfn, XurmoNetworkLinkType xnlt, XurmoUser sender) {

    return new XurmoMessage(xmfn.xurmoMessageForNetworkPK.getMessageId(),
        xmfn.xurmoMessageForNetworkPK.getLinkId(),
        xnlt.getLinkName(),
        xmfn.getUserId(),
        sender.getUsername(),
        sender.getFname(),
        sender.getLname(),
        sender.getSalutation(),
        xmfn.getDegreesOfSeparation(),
        new String(xmfn.getContent()));
  }
  public String messageId;
  public int linkId;
  public String linkName;
  public int senderid;
  public String senderUsername;
  public String senderFname;
  public String senderLname;
  public String senderSalutation;
  public int degreesOfSeparation;
  public String content;
}
