/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserNetworkSpecificPreferencesPK.java
 * Created on               : September 15, 2007, 10:28 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoUserNetworkSpecificPreferencesPK for entity class XurmoUserNetworkSpecificPreferences
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoUserNetworkSpecificPreferencesPK implements Serializable {

  @Column(name = "userid", nullable = false)
  private int userid;

  @Column(name = "linkId", nullable = false)
  private int linkId;
  
  /** Creates a new instance of XurmoUserNetworkSpecificPreferencesPK */
  public XurmoUserNetworkSpecificPreferencesPK() {
  }

  /**
   * Creates a new instance of XurmoUserNetworkSpecificPreferencesPK with the specified values.
   * @param linkId the linkId of the XurmoUserNetworkSpecificPreferencesPK
   * @param userid the userid of the XurmoUserNetworkSpecificPreferencesPK
   */
  public XurmoUserNetworkSpecificPreferencesPK(int linkId, int userid) {
    this.linkId = linkId;
    this.userid = userid;
  }

  /**
   * Gets the userid of this XurmoUserNetworkSpecificPreferencesPK.
   * @return the userid
   */
  public int getUserid() {
    return this.userid;
  }

  /**
   * Sets the userid of this XurmoUserNetworkSpecificPreferencesPK to the specified value.
   * @param userid the new userid
   */
  public void setUserid(int userid) {
    this.userid = userid;
  }

  /**
   * Gets the linkId of this XurmoUserNetworkSpecificPreferencesPK.
   * @return the linkId
   */
  public int getLinkId() {
    return this.linkId;
  }

  /**
   * Sets the linkId of this XurmoUserNetworkSpecificPreferencesPK to the specified value.
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
    hash += (int)userid;
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoUserNetworkSpecificPreferencesPK.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoUserNetworkSpecificPreferencesPK object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoUserNetworkSpecificPreferencesPK)) {
      return false;
    }
    XurmoUserNetworkSpecificPreferencesPK other = (XurmoUserNetworkSpecificPreferencesPK)object;
    if (this.linkId != other.linkId) return false;
    if (this.userid != other.userid) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoUserNetworkSpecificPreferencesPK[linkId=" + linkId + ", userid=" + userid + "]";
  }
  
}
