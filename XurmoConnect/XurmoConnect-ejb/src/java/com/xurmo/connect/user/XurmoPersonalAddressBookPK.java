/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPersonalAddressBookPK.java
 * Created on               : September 18, 2007, 10:05 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoPersonalAddressBookPK for entity class XurmoPersonalAddressBook
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoPersonalAddressBookPK implements Serializable {

  @Column(name = "userid", nullable = false)
  private int userid;

  @Column(name = "uniqueId", nullable = false)
  private int uniqueId;
  
  /** Creates a new instance of XurmoPersonalAddressBookPK */
  public XurmoPersonalAddressBookPK() {
  }

  /**
   * Creates a new instance of XurmoPersonalAddressBookPK with the specified values.
   * @param uniqueId the uniqueId of the XurmoPersonalAddressBookPK
   * @param userid the userid of the XurmoPersonalAddressBookPK
   */
  public XurmoPersonalAddressBookPK(int uniqueId, int userid) {
    this.uniqueId = uniqueId;
    this.userid = userid;
  }

  /**
   * Gets the userid of this XurmoPersonalAddressBookPK.
   * @return the userid
   */
  public int getUserid() {
    return this.userid;
  }

  /**
   * Sets the userid of this XurmoPersonalAddressBookPK to the specified value.
   * @param userid the new userid
   */
  public void setUserid(int userid) {
    this.userid = userid;
  }

  /**
   * Gets the uniqueId of this XurmoPersonalAddressBookPK.
   * @return the uniqueId
   */
  public int getUniqueId() {
    return this.uniqueId;
  }

  /**
   * Sets the uniqueId of this XurmoPersonalAddressBookPK to the specified value.
   * @param uniqueId the new uniqueId
   */
  public void setUniqueId(int uniqueId) {
    this.uniqueId = uniqueId;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int)uniqueId;
    hash += (int)userid;
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoPersonalAddressBookPK.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoPersonalAddressBookPK object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoPersonalAddressBookPK)) {
      return false;
    }
    XurmoPersonalAddressBookPK other = (XurmoPersonalAddressBookPK)object;
    if (this.uniqueId != other.uniqueId) return false;
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
    return "com.xurmo.connect.user.XurmoPersonalAddressBookPK[uniqueId=" + uniqueId + ", userid=" + userid + "]";
  }
  
}
