/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserPreferenceBlackListPK.java
 * Created on               : September 15, 2007, 10:28 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoUserPreferenceBlackListPK for entity class XurmoUserPreferenceBlackList
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoUserPreferenceBlackListPK implements Serializable {

  @Column(name = "userid", nullable = false)
  private int userid;

  @Column(name = "otherUserId", nullable = false)
  private int otherUserId;
  
  /** Creates a new instance of XurmoUserPreferenceBlackListPK */
  public XurmoUserPreferenceBlackListPK() {
  }

  /**
   * Creates a new instance of XurmoUserPreferenceBlackListPK with the specified values.
   * @param otherUserId the otherUserId of the XurmoUserPreferenceBlackListPK
   * @param userid the userid of the XurmoUserPreferenceBlackListPK
   */
  public XurmoUserPreferenceBlackListPK(int otherUserId, int userid) {
    this.otherUserId = otherUserId;
    this.userid = userid;
  }

  /**
   * Gets the userid of this XurmoUserPreferenceBlackListPK.
   * @return the userid
   */
  public int getUserid() {
    return this.userid;
  }

  /**
   * Sets the userid of this XurmoUserPreferenceBlackListPK to the specified value.
   * @param userid the new userid
   */
  public void setUserid(int userid) {
    this.userid = userid;
  }

  /**
   * Gets the otherUserId of this XurmoUserPreferenceBlackListPK.
   * @return the otherUserId
   */
  public int getOtherUserId() {
    return this.otherUserId;
  }

  /**
   * Sets the otherUserId of this XurmoUserPreferenceBlackListPK to the specified value.
   * @param otherUserId the new otherUserId
   */
  public void setOtherUserId(int otherUserId) {
    this.otherUserId = otherUserId;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int)otherUserId;
    hash += (int)userid;
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoUserPreferenceBlackListPK.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoUserPreferenceBlackListPK object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoUserPreferenceBlackListPK)) {
      return false;
    }
    XurmoUserPreferenceBlackListPK other = (XurmoUserPreferenceBlackListPK)object;
    if (this.otherUserId != other.otherUserId) return false;
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
    return "com.xurmo.connect.user.XurmoUserPreferenceBlackListPK[otherUserId=" + otherUserId + ", userid=" + userid + "]";
  }
  
}
