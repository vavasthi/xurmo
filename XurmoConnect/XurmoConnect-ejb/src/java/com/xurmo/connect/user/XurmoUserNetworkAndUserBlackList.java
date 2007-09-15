/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserNetworkAndUserBlackList.java
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
 * Entity class XurmoUserNetworkAndUserBlackList
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoUserNetworkAndUserBlackList")
@NamedQueries( {
    @NamedQuery(name = "XurmoUserNetworkAndUserBlackList.findByUserid", query = "SELECT x FROM XurmoUserNetworkAndUserBlackList x WHERE x.xurmoUserNetworkAndUserBlackListPK.userid = :userid"),
    @NamedQuery(name = "XurmoUserNetworkAndUserBlackList.findByLinkId", query = "SELECT x FROM XurmoUserNetworkAndUserBlackList x WHERE x.xurmoUserNetworkAndUserBlackListPK.linkId = :linkId"),
    @NamedQuery(name = "XurmoUserNetworkAndUserBlackList.findByUseridLinkIdAndOtherUserid", query = "SELECT x FROM XurmoUserNetworkAndUserBlackList x WHERE x.xurmoUserNetworkAndUserBlackListPK.linkId = :linkId and x.xurmoUserNetworkAndUserBlackListPK.userid = :userid and x.xurmoUserNetworkAndUserBlackListPK.otherUserid = :otherUserid"),
    @NamedQuery(name = "XurmoUserNetworkAndUserBlackList.findByOtherUserid", query = "SELECT x FROM XurmoUserNetworkAndUserBlackList x WHERE x.xurmoUserNetworkAndUserBlackListPK.otherUserid = :otherUserid")
  })
public class XurmoUserNetworkAndUserBlackList implements Serializable {

  /**
   * EmbeddedId primary key field
   */
  @EmbeddedId
  protected XurmoUserNetworkAndUserBlackListPK xurmoUserNetworkAndUserBlackListPK;
  
  /** Creates a new instance of XurmoUserNetworkAndUserBlackList */
  public XurmoUserNetworkAndUserBlackList() {
  }

  /**
   * Creates a new instance of XurmoUserNetworkAndUserBlackList with the specified values.
   * @param xurmoUserNetworkAndUserBlackListPK the xurmoUserNetworkAndUserBlackListPK of the XurmoUserNetworkAndUserBlackList
   */
  public XurmoUserNetworkAndUserBlackList(XurmoUserNetworkAndUserBlackListPK xurmoUserNetworkAndUserBlackListPK) {
    this.xurmoUserNetworkAndUserBlackListPK = xurmoUserNetworkAndUserBlackListPK;
  }

  /**
   * Creates a new instance of XurmoUserNetworkAndUserBlackListPK with the specified values.
   * @param otherUserid the otherUserid of the XurmoUserNetworkAndUserBlackListPK
   * @param linkId the linkId of the XurmoUserNetworkAndUserBlackListPK
   * @param userid the userid of the XurmoUserNetworkAndUserBlackListPK
   */
  public XurmoUserNetworkAndUserBlackList(int otherUserid, int linkId, int userid) {
    this.xurmoUserNetworkAndUserBlackListPK = new XurmoUserNetworkAndUserBlackListPK(otherUserid, linkId, userid);
  }

  /**
   * Gets the xurmoUserNetworkAndUserBlackListPK of this XurmoUserNetworkAndUserBlackList.
   * @return the xurmoUserNetworkAndUserBlackListPK
   */
  public XurmoUserNetworkAndUserBlackListPK getXurmoUserNetworkAndUserBlackListPK() {
    return this.xurmoUserNetworkAndUserBlackListPK;
  }

  /**
   * Sets the xurmoUserNetworkAndUserBlackListPK of this XurmoUserNetworkAndUserBlackList to the specified value.
   * @param xurmoUserNetworkAndUserBlackListPK the new xurmoUserNetworkAndUserBlackListPK
   */
  public void setXurmoUserNetworkAndUserBlackListPK(XurmoUserNetworkAndUserBlackListPK xurmoUserNetworkAndUserBlackListPK) {
    this.xurmoUserNetworkAndUserBlackListPK = xurmoUserNetworkAndUserBlackListPK;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.xurmoUserNetworkAndUserBlackListPK != null ? this.xurmoUserNetworkAndUserBlackListPK.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoUserNetworkAndUserBlackList.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoUserNetworkAndUserBlackList object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoUserNetworkAndUserBlackList)) {
      return false;
    }
    XurmoUserNetworkAndUserBlackList other = (XurmoUserNetworkAndUserBlackList)object;
    if (this.xurmoUserNetworkAndUserBlackListPK != other.xurmoUserNetworkAndUserBlackListPK && (this.xurmoUserNetworkAndUserBlackListPK == null || !this.xurmoUserNetworkAndUserBlackListPK.equals(other.xurmoUserNetworkAndUserBlackListPK))) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoUserNetworkAndUserBlackList[xurmoUserNetworkAndUserBlackListPK=" + xurmoUserNetworkAndUserBlackListPK + "]";
  }
  
}
