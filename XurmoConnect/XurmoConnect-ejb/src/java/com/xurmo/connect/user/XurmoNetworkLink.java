/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoNetworkLink.java
 * Created on               : September 15, 2007, 11:54 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class XurmoNetworkLink
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoNetworkLink")
@NamedQueries( {
    @NamedQuery(name = "XurmoNetworkLink.findByUserid1", query = "SELECT x FROM XurmoNetworkLink x WHERE x.xurmoNetworkLinkPK.userid1 = :userid1"),
    @NamedQuery(name = "XurmoNetworkLink.findByUserid2", query = "SELECT x FROM XurmoNetworkLink x WHERE x.xurmoNetworkLinkPK.userid2 = :userid2"),
    @NamedQuery(name = "XurmoNetworkLink.findByUserid", query = "SELECT x FROM XurmoNetworkLink x WHERE x.xurmoNetworkLinkPK.userid1 = :userid or x.xurmoNetworkLinkPK.userid2 = :userid"),
    @NamedQuery(name = "XurmoNetworkLink.findByUserid1AndUserid2", query = "SELECT x FROM XurmoNetworkLink x WHERE (x.xurmoNetworkLinkPK.userid1 = :userid1 and x.xurmoNetworkLinkPK.userid2 = :userid2) or (x.xurmoNetworkLinkPK.userid1 = :userid2 and x.xurmoNetworkLinkPK.userid2 = :userid1)"),
    @NamedQuery(name = "XurmoNetworkLink.findByLinkId", query = "SELECT x FROM XurmoNetworkLink x WHERE x.xurmoNetworkLinkPK.linkId = :linkId"),
    @NamedQuery(name = "XurmoNetworkLink.findByCreationDate", query = "SELECT x FROM XurmoNetworkLink x WHERE x.creationDate = :creationDate")
  })
public class XurmoNetworkLink implements Serializable {

  /**
   * EmbeddedId primary key field
   */
  @EmbeddedId
  protected XurmoNetworkLinkPK xurmoNetworkLinkPK;

  @Column(name = "creationDate", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate;
  
  /** Creates a new instance of XurmoNetworkLink */
  public XurmoNetworkLink() {
  }

  /**
   * Creates a new instance of XurmoNetworkLink with the specified values.
   * @param xurmoNetworkLinkPK the xurmoNetworkLinkPK of the XurmoNetworkLink
   */
  public XurmoNetworkLink(XurmoNetworkLinkPK xurmoNetworkLinkPK) {
    this.xurmoNetworkLinkPK = xurmoNetworkLinkPK;
  }

  /**
   * Creates a new instance of XurmoNetworkLink with the specified values.
   * @param xurmoNetworkLinkPK the xurmoNetworkLinkPK of the XurmoNetworkLink
   * @param creationDate the creationDate of the XurmoNetworkLink
   */
  public XurmoNetworkLink(XurmoNetworkLinkPK xurmoNetworkLinkPK, Date creationDate) {
    this.xurmoNetworkLinkPK = xurmoNetworkLinkPK;
    this.creationDate = creationDate;
  }

  /**
   * Creates a new instance of XurmoNetworkLinkPK with the specified values.
   * @param linkId the linkId of the XurmoNetworkLinkPK
   * @param userid2 the userid2 of the XurmoNetworkLinkPK
   * @param userid1 the userid1 of the XurmoNetworkLinkPK
   */
  public XurmoNetworkLink(int linkId, int userid2, int userid1) {
    this.xurmoNetworkLinkPK = new XurmoNetworkLinkPK(linkId, userid2, userid1);
  }

  /**
   * Gets the xurmoNetworkLinkPK of this XurmoNetworkLink.
   * @return the xurmoNetworkLinkPK
   */
  public XurmoNetworkLinkPK getXurmoNetworkLinkPK() {
    return this.xurmoNetworkLinkPK;
  }

  /**
   * Sets the xurmoNetworkLinkPK of this XurmoNetworkLink to the specified value.
   * @param xurmoNetworkLinkPK the new xurmoNetworkLinkPK
   */
  public void setXurmoNetworkLinkPK(XurmoNetworkLinkPK xurmoNetworkLinkPK) {
    this.xurmoNetworkLinkPK = xurmoNetworkLinkPK;
  }

  /**
   * Gets the creationDate of this XurmoNetworkLink.
   * @return the creationDate
   */
  public Date getCreationDate() {
    return this.creationDate;
  }

  /**
   * Sets the creationDate of this XurmoNetworkLink to the specified value.
   * @param creationDate the new creationDate
   */
  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.xurmoNetworkLinkPK != null ? this.xurmoNetworkLinkPK.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoNetworkLink.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoNetworkLink object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoNetworkLink)) {
      return false;
    }
    XurmoNetworkLink other = (XurmoNetworkLink)object;
    if (this.xurmoNetworkLinkPK != other.xurmoNetworkLinkPK && (this.xurmoNetworkLinkPK == null || !this.xurmoNetworkLinkPK.equals(other.xurmoNetworkLinkPK))) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoNetworkLink[xurmoNetworkLinkPK=" + xurmoNetworkLinkPK + "]";
  }
  
}
