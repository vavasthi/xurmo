/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserMessageThroughNetworkPK.java
 * Created on               : November 18, 2007, 1:59 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoUserMessageThroughNetworkPK for entity class XurmoUserMessageThroughNetwork
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoUserMessageThroughNetworkPK implements Serializable {

  @Column(name = "messageId", nullable = false)
  private String messageId;

  @Column(name = "userid", nullable = false)
  private int userid;
  
  /** Creates a new instance of XurmoUserMessageThroughNetworkPK */
  public XurmoUserMessageThroughNetworkPK() {
  }

  /**
   * Creates a new instance of XurmoUserMessageThroughNetworkPK with the specified values.
   * @param userid the userid of the XurmoUserMessageThroughNetworkPK
   * @param messageId the messageId of the XurmoUserMessageThroughNetworkPK
   */
  public XurmoUserMessageThroughNetworkPK(int userid, String messageId) {
    this.userid = userid;
    this.messageId = messageId;
  }

  /**
   * Gets the messageId of this XurmoUserMessageThroughNetworkPK.
   * @return the messageId
   */
  public String getMessageId() {
    return this.messageId;
  }

  /**
   * Sets the messageId of this XurmoUserMessageThroughNetworkPK to the specified value.
   * @param messageId the new messageId
   */
  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  /**
   * Gets the userid of this XurmoUserMessageThroughNetworkPK.
   * @return the userid
   */
  public int getUserid() {
    return this.userid;
  }

  /**
   * Sets the userid of this XurmoUserMessageThroughNetworkPK to the specified value.
   * @param userid the new userid
   */
  public void setUserid(int userid) {
    this.userid = userid;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int)userid;
    hash += (this.messageId != null ? this.messageId.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoUserMessageThroughNetworkPK.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoUserMessageThroughNetworkPK object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoUserMessageThroughNetworkPK)) {
      return false;
    }
    XurmoUserMessageThroughNetworkPK other = (XurmoUserMessageThroughNetworkPK)object;
    if (this.userid != other.userid) return false;
    if (this.messageId != other.messageId && (this.messageId == null || !this.messageId.equals(other.messageId))) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoUserMessageThroughNetworkPK[userid=" + userid + ", messageId=" + messageId + "]";
  }
  
}
