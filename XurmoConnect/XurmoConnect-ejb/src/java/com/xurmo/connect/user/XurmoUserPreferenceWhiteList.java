/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserPreferenceWhiteList.java
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
 * Entity class XurmoUserPreferenceWhiteList
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoUserPreferenceWhiteList")
@NamedQueries( {
    @NamedQuery(name = "XurmoUserPreferenceWhiteList.findByUserid", query = "SELECT x FROM XurmoUserPreferenceWhiteList x WHERE x.xurmoUserPreferenceWhiteListPK.userid = :userid"),
    @NamedQuery(name = "XurmoUserPreferenceWhiteList.findByUseridAndOtherUserid", query = "SELECT x FROM XurmoUserPreferenceWhiteList x WHERE x.xurmoUserPreferenceWhiteListPK.userid = :userid and x.xurmoUserPreferenceWhiteListPK.otherUserid = :otherUserid"),
    @NamedQuery(name = "XurmoUserPreferenceWhiteList.findByOtherUserid", query = "SELECT x FROM XurmoUserPreferenceWhiteList x WHERE x.xurmoUserPreferenceWhiteListPK.otherUserid = :otherUserid")
  })
public class XurmoUserPreferenceWhiteList implements Serializable {

  /**
   * EmbeddedId primary key field
   */
  @EmbeddedId
  protected XurmoUserPreferenceWhiteListPK xurmoUserPreferenceWhiteListPK;
  
  /** Creates a new instance of XurmoUserPreferenceWhiteList */
  public XurmoUserPreferenceWhiteList() {
  }

  /**
   * Creates a new instance of XurmoUserPreferenceWhiteList with the specified values.
   * @param xurmoUserPreferenceWhiteListPK the xurmoUserPreferenceWhiteListPK of the XurmoUserPreferenceWhiteList
   */
  public XurmoUserPreferenceWhiteList(XurmoUserPreferenceWhiteListPK xurmoUserPreferenceWhiteListPK) {
    this.xurmoUserPreferenceWhiteListPK = xurmoUserPreferenceWhiteListPK;
  }

  /**
   * Creates a new instance of XurmoUserPreferenceWhiteListPK with the specified values.
   * @param otherUserId the otherUserId of the XurmoUserPreferenceWhiteListPK
   * @param userid the userid of the XurmoUserPreferenceWhiteListPK
   */
  public XurmoUserPreferenceWhiteList(int otherUserId, int userid) {
    this.xurmoUserPreferenceWhiteListPK = new XurmoUserPreferenceWhiteListPK(otherUserId, userid);
  }

  /**
   * Gets the xurmoUserPreferenceWhiteListPK of this XurmoUserPreferenceWhiteList.
   * @return the xurmoUserPreferenceWhiteListPK
   */
  public XurmoUserPreferenceWhiteListPK getXurmoUserPreferenceWhiteListPK() {
    return this.xurmoUserPreferenceWhiteListPK;
  }

  /**
   * Sets the xurmoUserPreferenceWhiteListPK of this XurmoUserPreferenceWhiteList to the specified value.
   * @param xurmoUserPreferenceWhiteListPK the new xurmoUserPreferenceWhiteListPK
   */
  public void setXurmoUserPreferenceWhiteListPK(XurmoUserPreferenceWhiteListPK xurmoUserPreferenceWhiteListPK) {
    this.xurmoUserPreferenceWhiteListPK = xurmoUserPreferenceWhiteListPK;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.xurmoUserPreferenceWhiteListPK != null ? this.xurmoUserPreferenceWhiteListPK.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoUserPreferenceWhiteList.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoUserPreferenceWhiteList object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoUserPreferenceWhiteList)) {
      return false;
    }
    XurmoUserPreferenceWhiteList other = (XurmoUserPreferenceWhiteList)object;
    if (this.xurmoUserPreferenceWhiteListPK != other.xurmoUserPreferenceWhiteListPK && (this.xurmoUserPreferenceWhiteListPK == null || !this.xurmoUserPreferenceWhiteListPK.equals(other.xurmoUserPreferenceWhiteListPK))) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoUserPreferenceWhiteList[xurmoUserPreferenceWhiteListPK=" + xurmoUserPreferenceWhiteListPK + "]";
  }
  
}
