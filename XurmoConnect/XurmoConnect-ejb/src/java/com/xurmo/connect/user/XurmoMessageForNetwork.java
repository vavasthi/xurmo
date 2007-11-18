/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoMessageForNetwork.java
 * Created on               : November 18, 2007, 11:01 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class XurmoMessageForNetwork
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoMessageForNetwork")
@NamedQueries( {
    @NamedQuery(name = "XurmoMessageForNetwork.findByMessageId", query = "SELECT x FROM XurmoMessageForNetwork x WHERE x.xurmoMessageForNetworkPK.messageId = :messageId"),
    @NamedQuery(name = "XurmoMessageForNetwork.findByLinkId", query = "SELECT x FROM XurmoMessageForNetwork x WHERE x.xurmoMessageForNetworkPK.linkId = :linkId"),
    @NamedQuery(name = "XurmoMessageForNetwork.findByUserId", query = "SELECT x FROM XurmoMessageForNetwork x WHERE x.userId = :userId"),
    @NamedQuery(name = "XurmoMessageForNetwork.findByDegreesOfSeparation", query = "SELECT x FROM XurmoMessageForNetwork x WHERE x.degreesOfSeparation = :degreesOfSeparation"),
    @NamedQuery(name = "XurmoMessageForNetwork.findByStatus", query = "SELECT x FROM XurmoMessageForNetwork x WHERE x.status = :status"),
    @NamedQuery(name = "XurmoMessageForNetwork.findByDestinationUserid", query = "SELECT x FROM XurmoMessageForNetwork x and XurmoUserMessageThroughNetwork mtn WHERE mtn.xurmoUserMessageThroughNetworkPK.messageId =  x.xurmoMessageForNetworkPK.messageId and mtn.xurmoUserMessageThroughNetworkPK.userid = :userid"),
    @NamedQuery(name = "XurmoMessageForNetwork.findByDestinationUseridAndStatus", query = "SELECT x FROM XurmoMessageForNetwork x and XurmoUserMessageThroughNetwork mtn WHERE mtn.xurmoUserMessageThroughNetworkPK.messageId =  x.xurmoMessageForNetworkPK.messageId and mtn.xurmoUserMessageThroughNetworkPK.userid = :userid and mtn.status = :status")
  })
public class XurmoMessageForNetwork implements Serializable {

  /**
   * EmbeddedId primary key field
   */
  @EmbeddedId
  protected XurmoMessageForNetworkPK xurmoMessageForNetworkPK;

  @Column(name = "userId", nullable = false)
  private int userId;

  @Column(name = "degreesOfSeparation", nullable = false)
  private int degreesOfSeparation;

  @Lob
  @Column(name = "content", nullable = false)
  private byte [] content;

  @Column(name = "status", nullable = false)
  private char status;
  
  /** Creates a new instance of XurmoMessageForNetwork */
  public XurmoMessageForNetwork() {
  }

  /**
   * Creates a new instance of XurmoMessageForNetwork with the specified values.
   * @param xurmoMessageForNetworkPK the xurmoMessageForNetworkPK of the XurmoMessageForNetwork
   */
  public XurmoMessageForNetwork(XurmoMessageForNetworkPK xurmoMessageForNetworkPK) {
    this.xurmoMessageForNetworkPK = xurmoMessageForNetworkPK;
  }

  /**
   * Creates a new instance of XurmoMessageForNetwork with the specified values.
   * @param xurmoMessageForNetworkPK the xurmoMessageForNetworkPK of the XurmoMessageForNetwork
   * @param userId the userId of the XurmoMessageForNetwork
   * @param degreesOfSeparation the degreesOfSeparation of the XurmoMessageForNetwork
   * @param content the content of the XurmoMessageForNetwork
   * @param status the status of the XurmoMessageForNetwork
   */
  public XurmoMessageForNetwork(XurmoMessageForNetworkPK xurmoMessageForNetworkPK, int userId, int degreesOfSeparation, byte [] content, char status) {
    this.xurmoMessageForNetworkPK = xurmoMessageForNetworkPK;
    this.userId = userId;
    this.degreesOfSeparation = degreesOfSeparation;
    this.content = content;
    this.status = status;
  }

  /**
   * Creates a new instance of XurmoMessageForNetworkPK with the specified values.
   * @param linkId the linkId of the XurmoMessageForNetworkPK
   * @param messageId the messageId of the XurmoMessageForNetworkPK
   */
  public XurmoMessageForNetwork(int linkId, String messageId) {
    this.xurmoMessageForNetworkPK = new XurmoMessageForNetworkPK(linkId, messageId);
  }

  /**
   * Gets the xurmoMessageForNetworkPK of this XurmoMessageForNetwork.
   * @return the xurmoMessageForNetworkPK
   */
  public XurmoMessageForNetworkPK getXurmoMessageForNetworkPK() {
    return this.xurmoMessageForNetworkPK;
  }

  /**
   * Sets the xurmoMessageForNetworkPK of this XurmoMessageForNetwork to the specified value.
   * @param xurmoMessageForNetworkPK the new xurmoMessageForNetworkPK
   */
  public void setXurmoMessageForNetworkPK(XurmoMessageForNetworkPK xurmoMessageForNetworkPK) {
    this.xurmoMessageForNetworkPK = xurmoMessageForNetworkPK;
  }

  /**
   * Gets the userId of this XurmoMessageForNetwork.
   * @return the userId
   */
  public int getUserId() {
    return this.userId;
  }

  /**
   * Sets the userId of this XurmoMessageForNetwork to the specified value.
   * @param userId the new userId
   */
  public void setUserId(int userId) {
    this.userId = userId;
  }

  /**
   * Gets the degreesOfSeparation of this XurmoMessageForNetwork.
   * @return the degreesOfSeparation
   */
  public int getDegreesOfSeparation() {
    return this.degreesOfSeparation;
  }

  /**
   * Sets the degreesOfSeparation of this XurmoMessageForNetwork to the specified value.
   * @param degreesOfSeparation the new degreesOfSeparation
   */
  public void setDegreesOfSeparation(int degreesOfSeparation) {
    this.degreesOfSeparation = degreesOfSeparation;
  }

  /**
   * Gets the content of this XurmoMessageForNetwork.
   * @return the content
   */
  public byte [] getContent() {
    return this.content;
  }

  /**
   * Sets the content of this XurmoMessageForNetwork to the specified value.
   * @param content the new content
   */
  public void setContent(byte [] content) {
    this.content = content;
  }

  /**
   * Gets the status of this XurmoMessageForNetwork.
   * @return the status
   */
  public char getStatus() {
    return this.status;
  }

  /**
   * Sets the status of this XurmoMessageForNetwork to the specified value.
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
    hash += (this.xurmoMessageForNetworkPK != null ? this.xurmoMessageForNetworkPK.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoMessageForNetwork.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoMessageForNetwork object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoMessageForNetwork)) {
      return false;
    }
    XurmoMessageForNetwork other = (XurmoMessageForNetwork)object;
    if (this.xurmoMessageForNetworkPK != other.xurmoMessageForNetworkPK && (this.xurmoMessageForNetworkPK == null || !this.xurmoMessageForNetworkPK.equals(other.xurmoMessageForNetworkPK))) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoMessageForNetwork[xurmoMessageForNetworkPK=" + xurmoMessageForNetworkPK + "]";
  }
  
}
