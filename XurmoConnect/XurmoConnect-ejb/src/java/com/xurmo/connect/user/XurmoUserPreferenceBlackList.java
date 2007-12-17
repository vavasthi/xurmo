/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserPreferenceBlackList.java
 * Created on               : September 15, 2007, 10:28 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class XurmoUserPreferenceBlackList
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoUserPreferenceBlackList")
@NamedQueries( {
    @NamedQuery(name = "XurmoUserPreferenceBlackList.findByUserid", query = "SELECT x FROM XurmoUserPreferenceBlackList x WHERE x.xurmoUserPreferenceBlackListPK.userid = :userid"),
    @NamedQuery(name = "XurmoUserPreferenceBlackList.findByUseridAndOtherUserid", query = "SELECT x FROM XurmoUserPreferenceBlackList x WHERE x.xurmoUserPreferenceBlackListPK.userid = :userid and x.xurmoUserPreferenceBlackListPK.otherUserid = :otherUserid"),
    @NamedQuery(name = "XurmoUserPreferenceBlackList.findByOtherUserid", query = "SELECT x FROM XurmoUserPreferenceBlackList x WHERE x.xurmoUserPreferenceBlackListPK.otherUserid = :otherUserid")
  })
public class XurmoUserPreferenceBlackList implements Serializable {

  /**
   * EmbeddedId primary key field
   */
  @EmbeddedId
  protected XurmoUserPreferenceBlackListPK xurmoUserPreferenceBlackListPK;
  
  /** Creates a new instance of XurmoUserPreferenceBlackList */
  public XurmoUserPreferenceBlackList() {
  }

  /**
   * Creates a new instance of XurmoUserPreferenceBlackList with the specified values.
   * @param xurmoUserPreferenceBlackListPK the xurmoUserPreferenceBlackListPK of the XurmoUserPreferenceBlackList
   */
  public XurmoUserPreferenceBlackList(XurmoUserPreferenceBlackListPK xurmoUserPreferenceBlackListPK) {
    this.xurmoUserPreferenceBlackListPK = xurmoUserPreferenceBlackListPK;
  }

  /**
   * Creates a new instance of XurmoUserPreferenceBlackListPK with the specified values.
   * @param otherUserId the otherUserId of the XurmoUserPreferenceBlackListPK
   * @param userid the userid of the XurmoUserPreferenceBlackListPK
   */
  public XurmoUserPreferenceBlackList(int otherUserId, int userid) {
    this.xurmoUserPreferenceBlackListPK = new XurmoUserPreferenceBlackListPK(otherUserId, userid);
  }

  /**
   * Gets the xurmoUserPreferenceBlackListPK of this XurmoUserPreferenceBlackList.
   * @return the xurmoUserPreferenceBlackListPK
   */
  public XurmoUserPreferenceBlackListPK getXurmoUserPreferenceBlackListPK() {
    return this.xurmoUserPreferenceBlackListPK;
  }

  /**
   * Sets the xurmoUserPreferenceBlackListPK of this XurmoUserPreferenceBlackList to the specified value.
   * @param xurmoUserPreferenceBlackListPK the new xurmoUserPreferenceBlackListPK
   */
  public void setXurmoUserPreferenceBlackListPK(XurmoUserPreferenceBlackListPK xurmoUserPreferenceBlackListPK) {
    this.xurmoUserPreferenceBlackListPK = xurmoUserPreferenceBlackListPK;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.xurmoUserPreferenceBlackListPK != null ? this.xurmoUserPreferenceBlackListPK.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoUserPreferenceBlackList.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoUserPreferenceBlackList object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoUserPreferenceBlackList)) {
      return false;
    }
    XurmoUserPreferenceBlackList other = (XurmoUserPreferenceBlackList)object;
    if (this.xurmoUserPreferenceBlackListPK != other.xurmoUserPreferenceBlackListPK && (this.xurmoUserPreferenceBlackListPK == null || !this.xurmoUserPreferenceBlackListPK.equals(other.xurmoUserPreferenceBlackListPK))) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoUserPreferenceBlackList[xurmoUserPreferenceBlackListPK=" + xurmoUserPreferenceBlackListPK + "]";
  }
  
}
