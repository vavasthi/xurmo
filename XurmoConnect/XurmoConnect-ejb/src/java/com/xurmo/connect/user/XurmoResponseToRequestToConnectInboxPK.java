/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoResponseToRequestToConnectInboxPK.java
 * Created on               : September 16, 2007, 3:24 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoResponseToRequestToConnectInboxPK for entity class XurmoResponseToRequestToConnectInbox
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoResponseToRequestToConnectInboxPK implements Serializable {

  @Column(name = "responseFrom", nullable = false)
  private int responseFrom;

  @Column(name = "responseTo", nullable = false)
  private int responseTo;
  
  /** Creates a new instance of XurmoResponseToRequestToConnectInboxPK */
  public XurmoResponseToRequestToConnectInboxPK() {
  }

  /**
   * Creates a new instance of XurmoResponseToRequestToConnectInboxPK with the specified values.
   * @param responseTo the responseTo of the XurmoResponseToRequestToConnectInboxPK
   * @param responseFrom the responseFrom of the XurmoResponseToRequestToConnectInboxPK
   */
  public XurmoResponseToRequestToConnectInboxPK(int responseTo, int responseFrom) {
    this.responseTo = responseTo;
    this.responseFrom = responseFrom;
  }

  /**
   * Gets the responseFrom of this XurmoResponseToRequestToConnectInboxPK.
   * @return the responseFrom
   */
  public int getResponseFrom() {
    return this.responseFrom;
  }

  /**
   * Sets the responseFrom of this XurmoResponseToRequestToConnectInboxPK to the specified value.
   * @param responseFrom the new responseFrom
   */
  public void setResponseFrom(int responseFrom) {
    this.responseFrom = responseFrom;
  }

  /**
   * Gets the responseTo of this XurmoResponseToRequestToConnectInboxPK.
   * @return the responseTo
   */
  public int getResponseTo() {
    return this.responseTo;
  }

  /**
   * Sets the responseTo of this XurmoResponseToRequestToConnectInboxPK to the specified value.
   * @param responseTo the new responseTo
   */
  public void setResponseTo(int responseTo) {
    this.responseTo = responseTo;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int)responseTo;
    hash += (int)responseFrom;
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoResponseToRequestToConnectInboxPK.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoResponseToRequestToConnectInboxPK object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoResponseToRequestToConnectInboxPK)) {
      return false;
    }
    XurmoResponseToRequestToConnectInboxPK other = (XurmoResponseToRequestToConnectInboxPK)object;
    if (this.responseTo != other.responseTo) return false;
    if (this.responseFrom != other.responseFrom) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoResponseToRequestToConnectInboxPK[responseTo=" + responseTo + ", responseFrom=" + responseFrom + "]";
  }
  
}
