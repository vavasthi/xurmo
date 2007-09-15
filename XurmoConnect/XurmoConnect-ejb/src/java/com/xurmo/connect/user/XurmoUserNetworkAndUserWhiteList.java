/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserNetworkAndUserWhiteList.java
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
 * Entity class XurmoUserNetworkAndUserWhiteList
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoUserNetworkAndUserWhiteList")
@NamedQueries( {
    @NamedQuery(name = "XurmoUserNetworkAndUserWhiteList.findByUserid", query = "SELECT x FROM XurmoUserNetworkAndUserWhiteList x WHERE x.xurmoUserNetworkAndUserWhiteListPK.userid = :userid"),
    @NamedQuery(name = "XurmoUserNetworkAndUserWhiteList.findByLinkId", query = "SELECT x FROM XurmoUserNetworkAndUserWhiteList x WHERE x.xurmoUserNetworkAndUserWhiteListPK.linkId = :linkId"),
    @NamedQuery(name = "XurmoUserNetworkAndUserWhiteList.findByUseridLinkIdAndOtherUserid", query = "SELECT x FROM XurmoUserNetworkAndUserWhiteList x WHERE x.xurmoUserNetworkAndUserWhiteListPK.linkId = :linkId and x.xurmoUserNetworkAndUserWhiteListPK.userid = :userid and x.xurmoUserNetworkAndUserWhiteListPK.otherUserid = :otherUserid"),
    @NamedQuery(name = "XurmoUserNetworkAndUserWhiteList.findByOtherUserid", query = "SELECT x FROM XurmoUserNetworkAndUserWhiteList x WHERE x.xurmoUserNetworkAndUserWhiteListPK.otherUserid = :otherUserid")
  })
public class XurmoUserNetworkAndUserWhiteList implements Serializable {

  /**
   * EmbeddedId primary key field
   */
  @EmbeddedId
  protected XurmoUserNetworkAndUserWhiteListPK xurmoUserNetworkAndUserWhiteListPK;
  
  /** Creates a new instance of XurmoUserNetworkAndUserWhiteList */
  public XurmoUserNetworkAndUserWhiteList() {
  }

  /**
   * Creates a new instance of XurmoUserNetworkAndUserWhiteList with the specified values.
   * @param xurmoUserNetworkAndUserWhiteListPK the xurmoUserNetworkAndUserWhiteListPK of the XurmoUserNetworkAndUserWhiteList
   */
  public XurmoUserNetworkAndUserWhiteList(XurmoUserNetworkAndUserWhiteListPK xurmoUserNetworkAndUserWhiteListPK) {
    this.xurmoUserNetworkAndUserWhiteListPK = xurmoUserNetworkAndUserWhiteListPK;
  }

  /**
   * Creates a new instance of XurmoUserNetworkAndUserWhiteListPK with the specified values.
   * @param otherUserid the otherUserid of the XurmoUserNetworkAndUserWhiteListPK
   * @param linkId the linkId of the XurmoUserNetworkAndUserWhiteListPK
   * @param userid the userid of the XurmoUserNetworkAndUserWhiteListPK
   */
  public XurmoUserNetworkAndUserWhiteList(int otherUserid, int linkId, int userid) {
    this.xurmoUserNetworkAndUserWhiteListPK = new XurmoUserNetworkAndUserWhiteListPK(otherUserid, linkId, userid);
  }

  /**
   * Gets the xurmoUserNetworkAndUserWhiteListPK of this XurmoUserNetworkAndUserWhiteList.
   * @return the xurmoUserNetworkAndUserWhiteListPK
   */
  public XurmoUserNetworkAndUserWhiteListPK getXurmoUserNetworkAndUserWhiteListPK() {
    return this.xurmoUserNetworkAndUserWhiteListPK;
  }

  /**
   * Sets the xurmoUserNetworkAndUserWhiteListPK of this XurmoUserNetworkAndUserWhiteList to the specified value.
   * @param xurmoUserNetworkAndUserWhiteListPK the new xurmoUserNetworkAndUserWhiteListPK
   */
  public void setXurmoUserNetworkAndUserWhiteListPK(XurmoUserNetworkAndUserWhiteListPK xurmoUserNetworkAndUserWhiteListPK) {
    this.xurmoUserNetworkAndUserWhiteListPK = xurmoUserNetworkAndUserWhiteListPK;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.xurmoUserNetworkAndUserWhiteListPK != null ? this.xurmoUserNetworkAndUserWhiteListPK.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoUserNetworkAndUserWhiteList.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoUserNetworkAndUserWhiteList object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoUserNetworkAndUserWhiteList)) {
      return false;
    }
    XurmoUserNetworkAndUserWhiteList other = (XurmoUserNetworkAndUserWhiteList)object;
    if (this.xurmoUserNetworkAndUserWhiteListPK != other.xurmoUserNetworkAndUserWhiteListPK && (this.xurmoUserNetworkAndUserWhiteListPK == null || !this.xurmoUserNetworkAndUserWhiteListPK.equals(other.xurmoUserNetworkAndUserWhiteListPK))) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoUserNetworkAndUserWhiteList[xurmoUserNetworkAndUserWhiteListPK=" + xurmoUserNetworkAndUserWhiteListPK + "]";
  }
  
}
