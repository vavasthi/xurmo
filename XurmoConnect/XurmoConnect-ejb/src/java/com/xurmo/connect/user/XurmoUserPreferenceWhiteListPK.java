/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserPreferenceWhiteListPK.java
 * Created on               : September 15, 2007, 10:28 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoUserPreferenceWhiteListPK for entity class XurmoUserPreferenceWhiteList
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoUserPreferenceWhiteListPK implements Serializable {

  @Column(name = "userid", nullable = false)
  private int userid;

  @Column(name = "otherUserid", nullable = false)
  private int otherUserid;
  
  /** Creates a new instance of XurmoUserPreferenceWhiteListPK */
  public XurmoUserPreferenceWhiteListPK() {
  }

  /**
   * Creates a new instance of XurmoUserPreferenceWhiteListPK with the specified values.
   * @param otherUserid the otherUserid of the XurmoUserPreferenceWhiteListPK
   * @param userid the userid of the XurmoUserPreferenceWhiteListPK
   */
  public XurmoUserPreferenceWhiteListPK(int otherUserid, int userid) {
    this.otherUserid = otherUserid;
    this.userid = userid;
  }

  /**
   * Gets the userid of this XurmoUserPreferenceWhiteListPK.
   * @return the userid
   */
  public int getUserid() {
    return this.userid;
  }

  /**
   * Sets the userid of this XurmoUserPreferenceWhiteListPK to the specified value.
   * @param userid the new userid
   */
  public void setUserid(int userid) {
    this.userid = userid;
  }

  /**
   * Gets the otherUserid of this XurmoUserPreferenceWhiteListPK.
   * @return the otherUserid
   */
  public int getOtherUserid() {
    return this.otherUserid;
  }

  /**
   * Sets the otherUserid of this XurmoUserPreferenceWhiteListPK to the specified value.
   * @param otherUserid the new otherUserid
   */
  public void setOtherUserid(int otherUserid) {
    this.otherUserid = otherUserid;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int)otherUserid;
    hash += (int)userid;
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoUserPreferenceWhiteListPK.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoUserPreferenceWhiteListPK object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoUserPreferenceWhiteListPK)) {
      return false;
    }
    XurmoUserPreferenceWhiteListPK other = (XurmoUserPreferenceWhiteListPK)object;
    if (this.otherUserid != other.otherUserid) return false;
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
    return "com.xurmo.connect.user.XurmoUserPreferenceWhiteListPK[otherUserid=" + otherUserid + ", userid=" + userid + "]";
  }
  
}
