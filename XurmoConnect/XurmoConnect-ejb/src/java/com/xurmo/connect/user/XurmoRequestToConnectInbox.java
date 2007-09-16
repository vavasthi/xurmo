/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoRequestToConnectInbox.java
 * Created on               : September 16, 2007, 3:24 PM
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
 * Entity class XurmoRequestToConnectInbox
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoRequestToConnectInbox")
@NamedQueries( {
    @NamedQuery(name = "XurmoRequestToConnectInbox.findByMessageId", query = "SELECT x FROM XurmoRequestToConnectInbox x WHERE x.messageId = :messageId"),
    @NamedQuery(name = "XurmoRequestToConnectInbox.findByRequestFrom", query = "SELECT x FROM XurmoRequestToConnectInbox x WHERE x.xurmoRequestToConnectInboxPK.requestFrom = :requestFrom"),
    @NamedQuery(name = "XurmoRequestToConnectInbox.findByRequestTo", query = "SELECT x FROM XurmoRequestToConnectInbox x WHERE x.xurmoRequestToConnectInboxPK.requestTo = :requestTo"),
    @NamedQuery(name = "XurmoRequestToConnectInbox.findByLinkId", query = "SELECT x FROM XurmoRequestToConnectInbox x WHERE x.linkId = :linkId"),
    @NamedQuery(name = "XurmoRequestToConnectInbox.findByMsg", query = "SELECT x FROM XurmoRequestToConnectInbox x WHERE x.msg = :msg"),
    @NamedQuery(name = "XurmoRequestToConnectInbox.findByDisposed", query = "SELECT x FROM XurmoRequestToConnectInbox x WHERE x.disposed = :disposed"),
    @NamedQuery(name = "XurmoRequestToConnectInbox.findByResponseId", query = "SELECT x FROM XurmoRequestToConnectInbox x WHERE x.responseId = :responseId"),
    @NamedQuery(name = "XurmoRequestToConnectInbox.findByResponseMessageId", query = "SELECT x FROM XurmoRequestToConnectInbox x WHERE x.responseMessageId = :responseMessageId")
  })
public class XurmoRequestToConnectInbox implements Serializable {

  /**
   * EmbeddedId primary key field
   */
  @EmbeddedId
  protected XurmoRequestToConnectInboxPK xurmoRequestToConnectInboxPK;

  @Column(name = "messageId", nullable = false)
  private int messageId;

  @Column(name = "linkId", nullable = false)
  private int linkId;

  @Column(name = "msg", nullable = false)
  private String msg;

  @Column(name = "disposed", nullable = false)
  private boolean disposed;

  @Column(name = "responseId", nullable = false)
  private int responseId;

  @Column(name = "responseMessageId", nullable = false)
  private int responseMessageId;
  
  /** Creates a new instance of XurmoRequestToConnectInbox */
  public XurmoRequestToConnectInbox() {
  }

  /**
   * Creates a new instance of XurmoRequestToConnectInbox with the specified values.
   * @param xurmoRequestToConnectInboxPK the xurmoRequestToConnectInboxPK of the XurmoRequestToConnectInbox
   */
  public XurmoRequestToConnectInbox(XurmoRequestToConnectInboxPK xurmoRequestToConnectInboxPK) {
    this.xurmoRequestToConnectInboxPK = xurmoRequestToConnectInboxPK;
  }

  /**
   * Creates a new instance of XurmoRequestToConnectInbox with the specified values.
   * @param xurmoRequestToConnectInboxPK the xurmoRequestToConnectInboxPK of the XurmoRequestToConnectInbox
   * @param messageId the messageId of the XurmoRequestToConnectInbox
   * @param linkId the linkId of the XurmoRequestToConnectInbox
   * @param msg the msg of the XurmoRequestToConnectInbox
   * @param disposed the disposed of the XurmoRequestToConnectInbox
   * @param responseId the responseId of the XurmoRequestToConnectInbox
   * @param responseMessageId the responseMessageId of the XurmoRequestToConnectInbox
   */
  public XurmoRequestToConnectInbox(XurmoRequestToConnectInboxPK xurmoRequestToConnectInboxPK, int messageId, int linkId, String msg, boolean disposed, int responseId, int responseMessageId) {
    this.xurmoRequestToConnectInboxPK = xurmoRequestToConnectInboxPK;
    this.messageId = messageId;
    this.linkId = linkId;
    this.msg = msg;
    this.disposed = disposed;
    this.responseId = responseId;
    this.responseMessageId = responseMessageId;
  }

  /**
   * Creates a new instance of XurmoRequestToConnectInboxPK with the specified values.
   * @param requestTo the requestTo of the XurmoRequestToConnectInboxPK
   * @param requestFrom the requestFrom of the XurmoRequestToConnectInboxPK
   */
  public XurmoRequestToConnectInbox(int requestTo, int requestFrom) {
    this.xurmoRequestToConnectInboxPK = new XurmoRequestToConnectInboxPK(requestTo, requestFrom);
  }

  /**
   * Gets the xurmoRequestToConnectInboxPK of this XurmoRequestToConnectInbox.
   * @return the xurmoRequestToConnectInboxPK
   */
  public XurmoRequestToConnectInboxPK getXurmoRequestToConnectInboxPK() {
    return this.xurmoRequestToConnectInboxPK;
  }

  /**
   * Sets the xurmoRequestToConnectInboxPK of this XurmoRequestToConnectInbox to the specified value.
   * @param xurmoRequestToConnectInboxPK the new xurmoRequestToConnectInboxPK
   */
  public void setXurmoRequestToConnectInboxPK(XurmoRequestToConnectInboxPK xurmoRequestToConnectInboxPK) {
    this.xurmoRequestToConnectInboxPK = xurmoRequestToConnectInboxPK;
  }

  /**
   * Gets the messageId of this XurmoRequestToConnectInbox.
   * @return the messageId
   */
  public int getMessageId() {
    return this.messageId;
  }

  /**
   * Sets the messageId of this XurmoRequestToConnectInbox to the specified value.
   * @param messageId the new messageId
   */
  public void setMessageId(int messageId) {
    this.messageId = messageId;
  }

  /**
   * Gets the linkId of this XurmoRequestToConnectInbox.
   * @return the linkId
   */
  public int getLinkId() {
    return this.linkId;
  }

  /**
   * Sets the linkId of this XurmoRequestToConnectInbox to the specified value.
   * @param linkId the new linkId
   */
  public void setLinkId(int linkId) {
    this.linkId = linkId;
  }

  /**
   * Gets the msg of this XurmoRequestToConnectInbox.
   * @return the msg
   */
  public String getMsg() {
    return this.msg;
  }

  /**
   * Sets the msg of this XurmoRequestToConnectInbox to the specified value.
   * @param msg the new msg
   */
  public void setMsg(String msg) {
    this.msg = msg;
  }

  /**
   * Gets the disposed of this XurmoRequestToConnectInbox.
   * @return the disposed
   */
  public boolean getDisposed() {
    return this.disposed;
  }

  /**
   * Sets the disposed of this XurmoRequestToConnectInbox to the specified value.
   * @param disposed the new disposed
   */
  public void setDisposed(boolean disposed) {
    this.disposed = disposed;
  }

  /**
   * Gets the responseId of this XurmoRequestToConnectInbox.
   * @return the responseId
   */
  public int getResponseId() {
    return this.responseId;
  }

  /**
   * Sets the responseId of this XurmoRequestToConnectInbox to the specified value.
   * @param responseId the new responseId
   */
  public void setResponseId(int responseId) {
    this.responseId = responseId;
  }

  /**
   * Gets the responseMessageId of this XurmoRequestToConnectInbox.
   * @return the responseMessageId
   */
  public int getResponseMessageId() {
    return this.responseMessageId;
  }

  /**
   * Sets the responseMessageId of this XurmoRequestToConnectInbox to the specified value.
   * @param responseMessageId the new responseMessageId
   */
  public void setResponseMessageId(int responseMessageId) {
    this.responseMessageId = responseMessageId;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.xurmoRequestToConnectInboxPK != null ? this.xurmoRequestToConnectInboxPK.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoRequestToConnectInbox.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoRequestToConnectInbox object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoRequestToConnectInbox)) {
      return false;
    }
    XurmoRequestToConnectInbox other = (XurmoRequestToConnectInbox)object;
    if (this.xurmoRequestToConnectInboxPK != other.xurmoRequestToConnectInboxPK && (this.xurmoRequestToConnectInboxPK == null || !this.xurmoRequestToConnectInboxPK.equals(other.xurmoRequestToConnectInboxPK))) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoRequestToConnectInbox[xurmoRequestToConnectInboxPK=" + xurmoRequestToConnectInboxPK + "]";
  }
  
}
