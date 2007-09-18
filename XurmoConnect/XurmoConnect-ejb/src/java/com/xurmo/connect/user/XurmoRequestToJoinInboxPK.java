/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoRequestToJoinInboxPK.java
 * Created on               : September 18, 2007, 10:52 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoRequestToJoinInboxPK for entity class XurmoRequestToJoinInbox
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoRequestToJoinInboxPK implements Serializable {

  @Column(name = "source", nullable = false)
  private int source;

  @Column(name = "linkId", nullable = false)
  private int linkId;

  @Column(name = "phoneNumber", nullable = false)
  private String phoneNumber;
  
  /** Creates a new instance of XurmoRequestToJoinInboxPK */
  public XurmoRequestToJoinInboxPK() {
  }

  /**
   * Creates a new instance of XurmoRequestToJoinInboxPK with the specified values.
   * @param phoneNumber the phoneNumber of the XurmoRequestToJoinInboxPK
   * @param linkId the linkId of the XurmoRequestToJoinInboxPK
   * @param source the source of the XurmoRequestToJoinInboxPK
   */
  public XurmoRequestToJoinInboxPK(String phoneNumber, int linkId, int source) {
    this.phoneNumber = phoneNumber;
    this.linkId = linkId;
    this.source = source;
  }

  /**
   * Gets the source of this XurmoRequestToJoinInboxPK.
   * @return the source
   */
  public int getSource() {
    return this.source;
  }

  /**
   * Sets the source of this XurmoRequestToJoinInboxPK to the specified value.
   * @param source the new source
   */
  public void setSource(int source) {
    this.source = source;
  }

  /**
   * Gets the linkId of this XurmoRequestToJoinInboxPK.
   * @return the linkId
   */
  public int getLinkId() {
    return this.linkId;
  }

  /**
   * Sets the linkId of this XurmoRequestToJoinInboxPK to the specified value.
   * @param linkId the new linkId
   */
  public void setLinkId(int linkId) {
    this.linkId = linkId;
  }

  /**
   * Gets the phoneNumber of this XurmoRequestToJoinInboxPK.
   * @return the phoneNumber
   */
  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  /**
   * Sets the phoneNumber of this XurmoRequestToJoinInboxPK to the specified value.
   * @param phoneNumber the new phoneNumber
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.phoneNumber != null ? this.phoneNumber.hashCode() : 0);
    hash += (int)linkId;
    hash += (int)source;
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoRequestToJoinInboxPK.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoRequestToJoinInboxPK object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoRequestToJoinInboxPK)) {
      return false;
    }
    XurmoRequestToJoinInboxPK other = (XurmoRequestToJoinInboxPK)object;
    if (this.phoneNumber != other.phoneNumber && (this.phoneNumber == null || !this.phoneNumber.equals(other.phoneNumber))) return false;
    if (this.linkId != other.linkId) return false;
    if (this.source != other.source) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoRequestToJoinInboxPK[phoneNumber=" + phoneNumber + ", linkId=" + linkId + ", source=" + source + "]";
  }
  
}
