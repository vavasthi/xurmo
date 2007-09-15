/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserNetworkAndUserWhiteListPK.java
 * Created on               : September 15, 2007, 10:28 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoUserNetworkAndUserWhiteListPK for entity class XurmoUserNetworkAndUserWhiteList
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoUserNetworkAndUserWhiteListPK implements Serializable {

  @Column(name = "userid", nullable = false)
  private int userid;

  @Column(name = "linkId", nullable = false)
  private int linkId;

  @Column(name = "otherUserid", nullable = false)
  private int otherUserid;
  
  /** Creates a new instance of XurmoUserNetworkAndUserWhiteListPK */
  public XurmoUserNetworkAndUserWhiteListPK() {
  }

  /**
   * Creates a new instance of XurmoUserNetworkAndUserWhiteListPK with the specified values.
   * @param otherUserid the otherUserid of the XurmoUserNetworkAndUserWhiteListPK
   * @param linkId the linkId of the XurmoUserNetworkAndUserWhiteListPK
   * @param userid the userid of the XurmoUserNetworkAndUserWhiteListPK
   */
  public XurmoUserNetworkAndUserWhiteListPK(int otherUserid, int linkId, int userid) {
    this.otherUserid = otherUserid;
    this.linkId = linkId;
    this.userid = userid;
  }

  /**
   * Gets the userid of this XurmoUserNetworkAndUserWhiteListPK.
   * @return the userid
   */
  public int getUserid() {
    return this.userid;
  }

  /**
   * Sets the userid of this XurmoUserNetworkAndUserWhiteListPK to the specified value.
   * @param userid the new userid
   */
  public void setUserid(int userid) {
    this.userid = userid;
  }

  /**
   * Gets the linkId of this XurmoUserNetworkAndUserWhiteListPK.
   * @return the linkId
   */
  public int getLinkId() {
    return this.linkId;
  }

  /**
   * Sets the linkId of this XurmoUserNetworkAndUserWhiteListPK to the specified value.
   * @param linkId the new linkId
   */
  public void setLinkId(int linkId) {
    this.linkId = linkId;
  }

  /**
   * Gets the otherUserid of this XurmoUserNetworkAndUserWhiteListPK.
   * @return the otherUserid
   */
  public int getOtherUserid() {
    return this.otherUserid;
  }

  /**
   * Sets the otherUserid of this XurmoUserNetworkAndUserWhiteListPK to the specified value.
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
    hash += (int)linkId;
    hash += (int)userid;
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoUserNetworkAndUserWhiteListPK.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoUserNetworkAndUserWhiteListPK object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoUserNetworkAndUserWhiteListPK)) {
      return false;
    }
    XurmoUserNetworkAndUserWhiteListPK other = (XurmoUserNetworkAndUserWhiteListPK)object;
    if (this.otherUserid != other.otherUserid) return false;
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
    return "com.xurmo.connect.user.XurmoUserNetworkAndUserWhiteListPK[otherUserid=" + otherUserid + ", linkId=" + linkId + ", userid=" + userid + "]";
  }
  
}
