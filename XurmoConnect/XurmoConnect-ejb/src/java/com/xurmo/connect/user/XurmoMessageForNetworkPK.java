/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoMessageForNetworkPK.java
 * Created on               : November 18, 2007, 11:01 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoMessageForNetworkPK for entity class XurmoMessageForNetwork
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoMessageForNetworkPK implements Serializable {

  @Column(name = "messageId", nullable = false)
  private String messageId;

  @Column(name = "linkId", nullable = false)
  private int linkId;
  
  /** Creates a new instance of XurmoMessageForNetworkPK */
  public XurmoMessageForNetworkPK() {
  }

  /**
   * Creates a new instance of XurmoMessageForNetworkPK with the specified values.
   * @param linkId the linkId of the XurmoMessageForNetworkPK
   * @param messageId the messageId of the XurmoMessageForNetworkPK
   */
  public XurmoMessageForNetworkPK(int linkId, String messageId) {
    this.linkId = linkId;
    this.messageId = messageId;
  }

  /**
   * Gets the messageId of this XurmoMessageForNetworkPK.
   * @return the messageId
   */
  public String getMessageId() {
    return this.messageId;
  }

  /**
   * Sets the messageId of this XurmoMessageForNetworkPK to the specified value.
   * @param messageId the new messageId
   */
  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  /**
   * Gets the linkId of this XurmoMessageForNetworkPK.
   * @return the linkId
   */
  public int getLinkId() {
    return this.linkId;
  }

  /**
   * Sets the linkId of this XurmoMessageForNetworkPK to the specified value.
   * @param linkId the new linkId
   */
  public void setLinkId(int linkId) {
    this.linkId = linkId;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int)linkId;
    hash += (this.messageId != null ? this.messageId.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoMessageForNetworkPK.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoMessageForNetworkPK object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoMessageForNetworkPK)) {
      return false;
    }
    XurmoMessageForNetworkPK other = (XurmoMessageForNetworkPK)object;
    if (this.linkId != other.linkId) return false;
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
    return "com.xurmo.connect.user.XurmoMessageForNetworkPK[linkId=" + linkId + ", messageId=" + messageId + "]";
  }
  
}
