/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoRequestToConnectInboxPK.java
 * Created on               : September 16, 2007, 3:24 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoRequestToConnectInboxPK for entity class XurmoRequestToConnectInbox
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoRequestToConnectInboxPK implements Serializable {

  @Column(name = "requestFrom", nullable = false)
  private int requestFrom;

  @Column(name = "requestTo", nullable = false)
  private int requestTo;
  
  /** Creates a new instance of XurmoRequestToConnectInboxPK */
  public XurmoRequestToConnectInboxPK() {
  }

  /**
   * Creates a new instance of XurmoRequestToConnectInboxPK with the specified values.
   * @param requestTo the requestTo of the XurmoRequestToConnectInboxPK
   * @param requestFrom the requestFrom of the XurmoRequestToConnectInboxPK
   */
  public XurmoRequestToConnectInboxPK(int requestTo, int requestFrom) {
    this.requestTo = requestTo;
    this.requestFrom = requestFrom;
  }

  /**
   * Gets the requestFrom of this XurmoRequestToConnectInboxPK.
   * @return the requestFrom
   */
  public int getRequestFrom() {
    return this.requestFrom;
  }

  /**
   * Sets the requestFrom of this XurmoRequestToConnectInboxPK to the specified value.
   * @param requestFrom the new requestFrom
   */
  public void setRequestFrom(int requestFrom) {
    this.requestFrom = requestFrom;
  }

  /**
   * Gets the requestTo of this XurmoRequestToConnectInboxPK.
   * @return the requestTo
   */
  public int getRequestTo() {
    return this.requestTo;
  }

  /**
   * Sets the requestTo of this XurmoRequestToConnectInboxPK to the specified value.
   * @param requestTo the new requestTo
   */
  public void setRequestTo(int requestTo) {
    this.requestTo = requestTo;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int)requestTo;
    hash += (int)requestFrom;
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoRequestToConnectInboxPK.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoRequestToConnectInboxPK object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoRequestToConnectInboxPK)) {
      return false;
    }
    XurmoRequestToConnectInboxPK other = (XurmoRequestToConnectInboxPK)object;
    if (this.requestTo != other.requestTo) return false;
    if (this.requestFrom != other.requestFrom) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoRequestToConnectInboxPK[requestTo=" + requestTo + ", requestFrom=" + requestFrom + "]";
  }
  
}
