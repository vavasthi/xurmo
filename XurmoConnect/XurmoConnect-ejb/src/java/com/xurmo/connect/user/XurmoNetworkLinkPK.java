/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoNetworkLinkPK.java
 * Created on               : September 15, 2007, 11:54 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoNetworkLinkPK for entity class XurmoNetworkLink
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoNetworkLinkPK implements Serializable {

  @Column(name = "userid1", nullable = false)
  private int userid1;

  @Column(name = "userid2", nullable = false)
  private int userid2;

  @Column(name = "linkId", nullable = false)
  private int linkId;
  
  /** Creates a new instance of XurmoNetworkLinkPK */
  public XurmoNetworkLinkPK() {
  }

  /**
   * Creates a new instance of XurmoNetworkLinkPK with the specified values.
   * @param linkId the linkId of the XurmoNetworkLinkPK
   * @param userid2 the userid2 of the XurmoNetworkLinkPK
   * @param userid1 the userid1 of the XurmoNetworkLinkPK
   */
  public XurmoNetworkLinkPK(int linkId, int userid2, int userid1) {
    this.linkId = linkId;
    this.userid2 = userid2;
    this.userid1 = userid1;
  }

  /**
   * Gets the userid1 of this XurmoNetworkLinkPK.
   * @return the userid1
   */
  public int getUserid1() {
    return this.userid1;
  }

  /**
   * Sets the userid1 of this XurmoNetworkLinkPK to the specified value.
   * @param userid1 the new userid1
   */
  public void setUserid1(int userid1) {
    this.userid1 = userid1;
  }

  /**
   * Gets the userid2 of this XurmoNetworkLinkPK.
   * @return the userid2
   */
  public int getUserid2() {
    return this.userid2;
  }

  /**
   * Sets the userid2 of this XurmoNetworkLinkPK to the specified value.
   * @param userid2 the new userid2
   */
  public void setUserid2(int userid2) {
    this.userid2 = userid2;
  }

  /**
   * Gets the linkId of this XurmoNetworkLinkPK.
   * @return the linkId
   */
  public int getLinkId() {
    return this.linkId;
  }

  /**
   * Sets the linkId of this XurmoNetworkLinkPK to the specified value.
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
    hash += (int)userid2;
    hash += (int)userid1;
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoNetworkLinkPK.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoNetworkLinkPK object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoNetworkLinkPK)) {
      return false;
    }
    XurmoNetworkLinkPK other = (XurmoNetworkLinkPK)object;
    if (this.linkId != other.linkId) return false;
    if (this.userid2 != other.userid2) return false;
    if (this.userid1 != other.userid1) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoNetworkLinkPK[linkId=" + linkId + ", userid2=" + userid2 + ", userid1=" + userid1 + "]";
  }
  
}
