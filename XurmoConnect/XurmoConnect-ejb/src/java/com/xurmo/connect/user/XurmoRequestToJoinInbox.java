/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoRequestToJoinInbox.java
 * Created on               : September 18, 2007, 10:52 PM
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
 * Entity class XurmoRequestToJoinInbox
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoRequestToJoinInbox")
@NamedQueries( {
    @NamedQuery(name = "XurmoRequestToJoinInbox.findByMessageId", query = "SELECT x FROM XurmoRequestToJoinInbox x WHERE x.messageId = :messageId"),
    @NamedQuery(name = "XurmoRequestToJoinInbox.findBySource", query = "SELECT x FROM XurmoRequestToJoinInbox x WHERE x.xurmoRequestToJoinInboxPK.source = :source"),
    @NamedQuery(name = "XurmoRequestToJoinInbox.findByLinkId", query = "SELECT x FROM XurmoRequestToJoinInbox x WHERE x.xurmoRequestToJoinInboxPK.linkId = :linkId"),
    @NamedQuery(name = "XurmoRequestToJoinInbox.findByPhoneNumber", query = "SELECT x FROM XurmoRequestToJoinInbox x WHERE x.xurmoRequestToJoinInboxPK.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "XurmoRequestToJoinInbox.findByMsg", query = "SELECT x FROM XurmoRequestToJoinInbox x WHERE x.msg = :msg"),
    @NamedQuery(name = "XurmoRequestToJoinInbox.findByUniqueId", query = "SELECT x FROM XurmoRequestToJoinInbox x WHERE x.uniqueId = :uniqueId")
  })
public class XurmoRequestToJoinInbox implements Serializable {

  /**
   * EmbeddedId primary key field
   */
  @EmbeddedId
  protected XurmoRequestToJoinInboxPK xurmoRequestToJoinInboxPK;

  @Column(name = "messageId", nullable = false)
  private int messageId;

  @Column(name = "msg", nullable = false)
  private String msg;

  @Column(name = "uniqueId", nullable = false)
  private int uniqueId;
  
  /** Creates a new instance of XurmoRequestToJoinInbox */
  public XurmoRequestToJoinInbox() {
  }

  /**
   * Creates a new instance of XurmoRequestToJoinInbox with the specified values.
   * @param xurmoRequestToJoinInboxPK the xurmoRequestToJoinInboxPK of the XurmoRequestToJoinInbox
   */
  public XurmoRequestToJoinInbox(XurmoRequestToJoinInboxPK xurmoRequestToJoinInboxPK) {
    this.xurmoRequestToJoinInboxPK = xurmoRequestToJoinInboxPK;
  }

  /**
   * Creates a new instance of XurmoRequestToJoinInbox with the specified values.
   * @param xurmoRequestToJoinInboxPK the xurmoRequestToJoinInboxPK of the XurmoRequestToJoinInbox
   * @param messageId the messageId of the XurmoRequestToJoinInbox
   * @param msg the msg of the XurmoRequestToJoinInbox
   * @param uniqueId the uniqueId of the XurmoRequestToJoinInbox
   */
  public XurmoRequestToJoinInbox(XurmoRequestToJoinInboxPK xurmoRequestToJoinInboxPK, int messageId, String msg, int uniqueId) {
    this.xurmoRequestToJoinInboxPK = xurmoRequestToJoinInboxPK;
    this.messageId = messageId;
    this.msg = msg;
    this.uniqueId = uniqueId;
  }

  /**
   * Creates a new instance of XurmoRequestToJoinInboxPK with the specified values.
   * @param phoneNumber the phoneNumber of the XurmoRequestToJoinInboxPK
   * @param linkId the linkId of the XurmoRequestToJoinInboxPK
   * @param source the source of the XurmoRequestToJoinInboxPK
   */
  public XurmoRequestToJoinInbox(String phoneNumber, int linkId, int source) {
    this.xurmoRequestToJoinInboxPK = new XurmoRequestToJoinInboxPK(phoneNumber, linkId, source);
  }

  /**
   * Gets the xurmoRequestToJoinInboxPK of this XurmoRequestToJoinInbox.
   * @return the xurmoRequestToJoinInboxPK
   */
  public XurmoRequestToJoinInboxPK getXurmoRequestToJoinInboxPK() {
    return this.xurmoRequestToJoinInboxPK;
  }

  /**
   * Sets the xurmoRequestToJoinInboxPK of this XurmoRequestToJoinInbox to the specified value.
   * @param xurmoRequestToJoinInboxPK the new xurmoRequestToJoinInboxPK
   */
  public void setXurmoRequestToJoinInboxPK(XurmoRequestToJoinInboxPK xurmoRequestToJoinInboxPK) {
    this.xurmoRequestToJoinInboxPK = xurmoRequestToJoinInboxPK;
  }

  /**
   * Gets the messageId of this XurmoRequestToJoinInbox.
   * @return the messageId
   */
  public int getMessageId() {
    return this.messageId;
  }

  /**
   * Sets the messageId of this XurmoRequestToJoinInbox to the specified value.
   * @param messageId the new messageId
   */
  public void setMessageId(int messageId) {
    this.messageId = messageId;
  }

  /**
   * Gets the msg of this XurmoRequestToJoinInbox.
   * @return the msg
   */
  public String getMsg() {
    return this.msg;
  }

  /**
   * Sets the msg of this XurmoRequestToJoinInbox to the specified value.
   * @param msg the new msg
   */
  public void setMsg(String msg) {
    this.msg = msg;
  }

  /**
   * Gets the uniqueId of this XurmoRequestToJoinInbox.
   * @return the uniqueId
   */
  public int getUniqueId() {
    return this.uniqueId;
  }

  /**
   * Sets the uniqueId of this XurmoRequestToJoinInbox to the specified value.
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
    hash += (this.xurmoRequestToJoinInboxPK != null ? this.xurmoRequestToJoinInboxPK.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoRequestToJoinInbox.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoRequestToJoinInbox object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoRequestToJoinInbox)) {
      return false;
    }
    XurmoRequestToJoinInbox other = (XurmoRequestToJoinInbox)object;
    if (this.xurmoRequestToJoinInboxPK != other.xurmoRequestToJoinInboxPK && (this.xurmoRequestToJoinInboxPK == null || !this.xurmoRequestToJoinInboxPK.equals(other.xurmoRequestToJoinInboxPK))) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoRequestToJoinInbox[xurmoRequestToJoinInboxPK=" + xurmoRequestToJoinInboxPK + "]";
  }
  
}
