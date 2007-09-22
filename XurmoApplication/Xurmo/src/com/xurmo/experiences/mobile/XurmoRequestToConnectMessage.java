/*
 * XurmoRequestToConnectMessage.java
 *
 * Created on September 23, 2007, 2:25 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author Vinay
 */
public class XurmoRequestToConnectMessage {
  public int linkId;
  public String linkName;
  public int messageId;
  public String msg;
  public int requestFrom;
  public int requestTo;
  public String usernameFrom;
  public String usernameTo;
  /** Creates a new instance of XurmoRequestToConnectMessage */
  public XurmoRequestToConnectMessage(int linkId,
      String linkName,
      int messageId,
      String msg,
      int requestFrom,
      int requestTo,
      String usernameFrom,
      String usernameTo) {

    this.linkId = linkId;
    this.linkName = linkName;
    this.messageId = messageId;
    this.msg = msg;
    this.requestFrom = requestFrom;
    this.requestTo = requestTo;
    this.usernameFrom = usernameFrom;
    this.usernameTo = usernameTo;
  }
}
