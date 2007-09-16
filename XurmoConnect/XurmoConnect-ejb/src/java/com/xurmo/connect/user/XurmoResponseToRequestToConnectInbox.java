/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoResponseToRequestToConnectInbox.java
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
 * Entity class XurmoResponseToRequestToConnectInbox
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoResponseToRequestToConnectInbox")
@NamedQueries( {
    @NamedQuery(name = "XurmoResponseToRequestToConnectInbox.findByMessageId", query = "SELECT x FROM XurmoResponseToRequestToConnectInbox x WHERE x.messageId = :messageId"),
    @NamedQuery(name = "XurmoResponseToRequestToConnectInbox.findByResponseFrom", query = "SELECT x FROM XurmoResponseToRequestToConnectInbox x WHERE x.xurmoResponseToRequestToConnectInboxPK.responseFrom = :responseFrom"),
    @NamedQuery(name = "XurmoResponseToRequestToConnectInbox.findByResponseTo", query = "SELECT x FROM XurmoResponseToRequestToConnectInbox x WHERE x.xurmoResponseToRequestToConnectInboxPK.responseTo = :responseTo"),
    @NamedQuery(name = "XurmoResponseToRequestToConnectInbox.findByLinkId", query = "SELECT x FROM XurmoResponseToRequestToConnectInbox x WHERE x.linkId = :linkId"),
    @NamedQuery(name = "XurmoResponseToRequestToConnectInbox.findByRequestMessageId", query = "SELECT x FROM XurmoResponseToRequestToConnectInbox x WHERE x.requestMessageId = :requestMessageId"),
    @NamedQuery(name = "XurmoResponseToRequestToConnectInbox.findByMsg", query = "SELECT x FROM XurmoResponseToRequestToConnectInbox x WHERE x.msg = :msg")
  })
public class XurmoResponseToRequestToConnectInbox implements Serializable {

  /**
   * EmbeddedId primary key field
   */
  @EmbeddedId
  protected XurmoResponseToRequestToConnectInboxPK xurmoResponseToRequestToConnectInboxPK;

  @Column(name = "messageId", nullable = false)
  private int messageId;

  @Column(name = "linkId", nullable = false)
  private int linkId;

  @Column(name = "requestMessageId", nullable = false)
  private int requestMessageId;

  @Column(name = "msg", nullable = false)
  private String msg;
  
  /** Creates a new instance of XurmoResponseToRequestToConnectInbox */
  public XurmoResponseToRequestToConnectInbox() {
  }

  /**
   * Creates a new instance of XurmoResponseToRequestToConnectInbox with the specified values.
   * @param xurmoResponseToRequestToConnectInboxPK the xurmoResponseToRequestToConnectInboxPK of the XurmoResponseToRequestToConnectInbox
   */
  public XurmoResponseToRequestToConnectInbox(XurmoResponseToRequestToConnectInboxPK xurmoResponseToRequestToConnectInboxPK) {
    this.xurmoResponseToRequestToConnectInboxPK = xurmoResponseToRequestToConnectInboxPK;
  }

  /**
   * Creates a new instance of XurmoResponseToRequestToConnectInbox with the specified values.
   * @param xurmoResponseToRequestToConnectInboxPK the xurmoResponseToRequestToConnectInboxPK of the XurmoResponseToRequestToConnectInbox
   * @param messageId the messageId of the XurmoResponseToRequestToConnectInbox
   * @param linkId the linkId of the XurmoResponseToRequestToConnectInbox
   * @param requestMessageId the requestMessageId of the XurmoResponseToRequestToConnectInbox
   * @param msg the msg of the XurmoResponseToRequestToConnectInbox
   */
  public XurmoResponseToRequestToConnectInbox(XurmoResponseToRequestToConnectInboxPK xurmoResponseToRequestToConnectInboxPK, int messageId, int linkId, int requestMessageId, String msg) {
    this.xurmoResponseToRequestToConnectInboxPK = xurmoResponseToRequestToConnectInboxPK;
    this.messageId = messageId;
    this.linkId = linkId;
    this.requestMessageId = requestMessageId;
    this.msg = msg;
  }

  /**
   * Creates a new instance of XurmoResponseToRequestToConnectInboxPK with the specified values.
   * @param responseTo the responseTo of the XurmoResponseToRequestToConnectInboxPK
   * @param responseFrom the responseFrom of the XurmoResponseToRequestToConnectInboxPK
   */
  public XurmoResponseToRequestToConnectInbox(int responseTo, int responseFrom) {
    this.xurmoResponseToRequestToConnectInboxPK = new XurmoResponseToRequestToConnectInboxPK(responseTo, responseFrom);
  }

  /**
   * Gets the xurmoResponseToRequestToConnectInboxPK of this XurmoResponseToRequestToConnectInbox.
   * @return the xurmoResponseToRequestToConnectInboxPK
   */
  public XurmoResponseToRequestToConnectInboxPK getXurmoResponseToRequestToConnectInboxPK() {
    return this.xurmoResponseToRequestToConnectInboxPK;
  }

  /**
   * Sets the xurmoResponseToRequestToConnectInboxPK of this XurmoResponseToRequestToConnectInbox to the specified value.
   * @param xurmoResponseToRequestToConnectInboxPK the new xurmoResponseToRequestToConnectInboxPK
   */
  public void setXurmoResponseToRequestToConnectInboxPK(XurmoResponseToRequestToConnectInboxPK xurmoResponseToRequestToConnectInboxPK) {
    this.xurmoResponseToRequestToConnectInboxPK = xurmoResponseToRequestToConnectInboxPK;
  }

  /**
   * Gets the messageId of this XurmoResponseToRequestToConnectInbox.
   * @return the messageId
   */
  public int getMessageId() {
    return this.messageId;
  }

  /**
   * Sets the messageId of this XurmoResponseToRequestToConnectInbox to the specified value.
   * @param messageId the new messageId
   */
  public void setMessageId(int messageId) {
    this.messageId = messageId;
  }

  /**
   * Gets the linkId of this XurmoResponseToRequestToConnectInbox.
   * @return the linkId
   */
  public int getLinkId() {
    return this.linkId;
  }

  /**
   * Sets the linkId of this XurmoResponseToRequestToConnectInbox to the specified value.
   * @param linkId the new linkId
   */
  public void setLinkId(int linkId) {
    this.linkId = linkId;
  }

  /**
   * Gets the requestMessageId of this XurmoResponseToRequestToConnectInbox.
   * @return the requestMessageId
   */
  public int getRequestMessageId() {
    return this.requestMessageId;
  }

  /**
   * Sets the requestMessageId of this XurmoResponseToRequestToConnectInbox to the specified value.
   * @param requestMessageId the new requestMessageId
   */
  public void setRequestMessageId(int requestMessageId) {
    this.requestMessageId = requestMessageId;
  }

  /**
   * Gets the msg of this XurmoResponseToRequestToConnectInbox.
   * @return the msg
   */
  public String getMsg() {
    return this.msg;
  }

  /**
   * Sets the msg of this XurmoResponseToRequestToConnectInbox to the specified value.
   * @param msg the new msg
   */
  public void setMsg(String msg) {
    this.msg = msg;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.xurmoResponseToRequestToConnectInboxPK != null ? this.xurmoResponseToRequestToConnectInboxPK.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoResponseToRequestToConnectInbox.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoResponseToRequestToConnectInbox object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoResponseToRequestToConnectInbox)) {
      return false;
    }
    XurmoResponseToRequestToConnectInbox other = (XurmoResponseToRequestToConnectInbox)object;
    if (this.xurmoResponseToRequestToConnectInboxPK != other.xurmoResponseToRequestToConnectInboxPK && (this.xurmoResponseToRequestToConnectInboxPK == null || !this.xurmoResponseToRequestToConnectInboxPK.equals(other.xurmoResponseToRequestToConnectInboxPK))) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoResponseToRequestToConnectInbox[xurmoResponseToRequestToConnectInboxPK=" + xurmoResponseToRequestToConnectInboxPK + "]";
  }
  
}
