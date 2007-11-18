/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserMessageThroughNetwork.java
 * Created on               : November 18, 2007, 1:59 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class XurmoUserMessageThroughNetwork
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoUserMessageThroughNetwork")
@NamedQueries( {
    @NamedQuery(name = "XurmoUserMessageThroughNetwork.findByMessageId", query = "SELECT x FROM XurmoUserMessageThroughNetwork x WHERE x.xurmoUserMessageThroughNetworkPK.messageId = :messageId"),
    @NamedQuery(name = "XurmoUserMessageThroughNetwork.findByUserid", query = "SELECT x FROM XurmoUserMessageThroughNetwork x WHERE x.xurmoUserMessageThroughNetworkPK.userid = :userid"),
    @NamedQuery(name = "XurmoUserMessageThroughNetwork.findByUseridAndStatus", query = "SELECT x FROM XurmoUserMessageThroughNetwork x WHERE x.xurmoUserMessageThroughNetworkPK.userid = :userid and x.status = :status"),
    @NamedQuery(name = "XurmoUserMessageThroughNetwork.findByStatus", query = "SELECT x FROM XurmoUserMessageThroughNetwork x WHERE x.status = :status")
  })
public class XurmoUserMessageThroughNetwork implements Serializable {

  /**
   * EmbeddedId primary key field
   */
  @EmbeddedId
  protected XurmoUserMessageThroughNetworkPK xurmoUserMessageThroughNetworkPK;

  @Column(name = "status", nullable = false)
  private char status;
  
  /** Creates a new instance of XurmoUserMessageThroughNetwork */
  public XurmoUserMessageThroughNetwork() {
  }

  /**
   * Creates a new instance of XurmoUserMessageThroughNetwork with the specified values.
   * @param xurmoUserMessageThroughNetworkPK the xurmoUserMessageThroughNetworkPK of the XurmoUserMessageThroughNetwork
   */
  public XurmoUserMessageThroughNetwork(XurmoUserMessageThroughNetworkPK xurmoUserMessageThroughNetworkPK) {
    this.xurmoUserMessageThroughNetworkPK = xurmoUserMessageThroughNetworkPK;
  }

  /**
   * Creates a new instance of XurmoUserMessageThroughNetwork with the specified values.
   * @param xurmoUserMessageThroughNetworkPK the xurmoUserMessageThroughNetworkPK of the XurmoUserMessageThroughNetwork
   * @param status the status of the XurmoUserMessageThroughNetwork
   */
  public XurmoUserMessageThroughNetwork(XurmoUserMessageThroughNetworkPK xurmoUserMessageThroughNetworkPK, char status) {
    this.xurmoUserMessageThroughNetworkPK = xurmoUserMessageThroughNetworkPK;
    this.status = status;
  }

  /**
   * Creates a new instance of XurmoUserMessageThroughNetworkPK with the specified values.
   * @param userid the userid of the XurmoUserMessageThroughNetworkPK
   * @param messageId the messageId of the XurmoUserMessageThroughNetworkPK
   */
  public XurmoUserMessageThroughNetwork(int userid, String messageId) {
    this.xurmoUserMessageThroughNetworkPK = new XurmoUserMessageThroughNetworkPK(userid, messageId);
  }

  /**
   * Gets the xurmoUserMessageThroughNetworkPK of this XurmoUserMessageThroughNetwork.
   * @return the xurmoUserMessageThroughNetworkPK
   */
  public XurmoUserMessageThroughNetworkPK getXurmoUserMessageThroughNetworkPK() {
    return this.xurmoUserMessageThroughNetworkPK;
  }

  /**
   * Sets the xurmoUserMessageThroughNetworkPK of this XurmoUserMessageThroughNetwork to the specified value.
   * @param xurmoUserMessageThroughNetworkPK the new xurmoUserMessageThroughNetworkPK
   */
  public void setXurmoUserMessageThroughNetworkPK(XurmoUserMessageThroughNetworkPK xurmoUserMessageThroughNetworkPK) {
    this.xurmoUserMessageThroughNetworkPK = xurmoUserMessageThroughNetworkPK;
  }

  /**
   * Gets the status of this XurmoUserMessageThroughNetwork.
   * @return the status
   */
  public char getStatus() {
    return this.status;
  }

  /**
   * Sets the status of this XurmoUserMessageThroughNetwork to the specified value.
   * @param status the new status
   */
  public void setStatus(char status) {
    this.status = status;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.xurmoUserMessageThroughNetworkPK != null ? this.xurmoUserMessageThroughNetworkPK.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoUserMessageThroughNetwork.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoUserMessageThroughNetwork object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoUserMessageThroughNetwork)) {
      return false;
    }
    XurmoUserMessageThroughNetwork other = (XurmoUserMessageThroughNetwork)object;
    if (this.xurmoUserMessageThroughNetworkPK != other.xurmoUserMessageThroughNetworkPK && (this.xurmoUserMessageThroughNetworkPK == null || !this.xurmoUserMessageThroughNetworkPK.equals(other.xurmoUserMessageThroughNetworkPK))) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoUserMessageThroughNetwork[xurmoUserMessageThroughNetworkPK=" + xurmoUserMessageThroughNetworkPK + "]";
  }
  
}
