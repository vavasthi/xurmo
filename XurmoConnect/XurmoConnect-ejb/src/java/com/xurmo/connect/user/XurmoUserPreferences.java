/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserPreferences.java
 * Created on               : September 15, 2007, 10:28 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class XurmoUserPreferences
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoUserPreferences")
@NamedQueries( {
    @NamedQuery(name = "XurmoUserPreferences.findByUserid", query = "SELECT x FROM XurmoUserPreferences x WHERE x.userid = :userid"),
    @NamedQuery(name = "XurmoUserPreferences.findByReceiveDefaultMessagesDegrees", query = "SELECT x FROM XurmoUserPreferences x WHERE x.receiveDefaultMessagesDegrees = :receiveDefaultMessagesDegrees"),
    @NamedQuery(name = "XurmoUserPreferences.findByAllowSearchIntoYourNetwork", query = "SELECT x FROM XurmoUserPreferences x WHERE x.allowSearchIntoYourNetwork = :allowSearchIntoYourNetwork"),
    @NamedQuery(name = "XurmoUserPreferences.findByForwardMessagesOnDestinationPreferences", query = "SELECT x FROM XurmoUserPreferences x WHERE x.forwardMessagesOnDestinationPreferences = :forwardMessagesOnDestinationPreferences"),
    @NamedQuery(name = "XurmoUserPreferences.findByForwardMessagesToExternalNetworks", query = "SELECT x FROM XurmoUserPreferences x WHERE x.forwardMessagesToExternalNetworks = :forwardMessagesToExternalNetworks"),
    @NamedQuery(name = "XurmoUserPreferences.findByReceivePersonalEventReminders", query = "SELECT x FROM XurmoUserPreferences x WHERE x.receivePersonalEventReminders = :receivePersonalEventReminders")
  })
public class XurmoUserPreferences implements Serializable {

  @Id
  @Column(name = "userid", nullable = false)
  private Integer userid;

  @Column(name = "receiveDefaultMessagesDegrees", nullable = false)
  private int receiveDefaultMessagesDegrees;

  @Column(name = "allowSearchIntoYourNetwork", nullable = false)
  private boolean allowSearchIntoYourNetwork;

  @Column(name = "forwardMessagesOnDestinationPreferences", nullable = false)
  private boolean forwardMessagesOnDestinationPreferences;

  @Column(name = "forwardMessagesToExternalNetworks", nullable = false)
  private boolean forwardMessagesToExternalNetworks;

  @Column(name = "receivePersonalEventReminders", nullable = false)
  private boolean receivePersonalEventReminders;
  
  @Column(name = "receiveInviteFromEverybody", nullable = false)
  private boolean receiveInviteFromEverybody;

    
  /** Creates a new instance of XurmoUserPreferences */
  public XurmoUserPreferences() {
  }

  /**
   * Creates a new instance of XurmoUserPreferences with the specified values.
   * @param userid the userid of the XurmoUserPreferences
   */
  public XurmoUserPreferences(Integer userid) {
    this.userid = userid;
  }

  /**
   * Creates a new instance of XurmoUserPreferences with the specified values.
   * @param userid the userid of the XurmoUserPreferences
   * @param receiveDefaultMessagesDegrees the receiveDefaultMessagesDegrees of the XurmoUserPreferences
   * @param allowSearchIntoYourNetwork the allowSearchIntoYourNetwork of the XurmoUserPreferences
   * @param forwardMessagesOnDestinationPreferences the forwardMessagesOnDestinationPreferences of the XurmoUserPreferences
   * @param forwardMessagesToExternalNetworks the forwardMessagesToExternalNetworks of the XurmoUserPreferences
   * @param receivePersonalEventReminders the receivePersonalEventReminders of the XurmoUserPreferences
   */
  public XurmoUserPreferences(Integer userid, int receiveDefaultMessagesDegrees, boolean allowSearchIntoYourNetwork, boolean forwardMessagesOnDestinationPreferences, boolean forwardMessagesToExternalNetworks, boolean receivePersonalEventReminders, boolean receiveInviteFromEverybody) {
    this.userid = userid;
    this.receiveDefaultMessagesDegrees = receiveDefaultMessagesDegrees;
    this.allowSearchIntoYourNetwork = allowSearchIntoYourNetwork;
    this.forwardMessagesOnDestinationPreferences = forwardMessagesOnDestinationPreferences;
    this.forwardMessagesToExternalNetworks = forwardMessagesToExternalNetworks;
    this.receivePersonalEventReminders = receivePersonalEventReminders;
    this.receiveInviteFromEverybody = receiveInviteFromEverybody;
  }

  /**
   * Gets the userid of this XurmoUserPreferences.
   * @return the userid
   */
  public Integer getUserid() {
    return this.userid;
  }

  /**
   * Sets the userid of this XurmoUserPreferences to the specified value.
   * @param userid the new userid
   */
  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  /**
   * Gets the receiveDefaultMessagesDegrees of this XurmoUserPreferences.
   * @return the receiveDefaultMessagesDegrees
   */
  public int getReceiveDefaultMessagesDegrees() {
    return this.receiveDefaultMessagesDegrees;
  }

  /**
   * Sets the receiveDefaultMessagesDegrees of this XurmoUserPreferences to the specified value.
   * @param receiveDefaultMessagesDegrees the new receiveDefaultMessagesDegrees
   */
  public void setReceiveDefaultMessagesDegrees(int receiveDefaultMessagesDegrees) {
    this.receiveDefaultMessagesDegrees = receiveDefaultMessagesDegrees;
  }

  /**
   * Gets the allowSearchIntoYourNetwork of this XurmoUserPreferences.
   * @return the allowSearchIntoYourNetwork
   */
  public boolean getAllowSearchIntoYourNetwork() {
    return this.allowSearchIntoYourNetwork;
  }

  /**
   * Sets the allowSearchIntoYourNetwork of this XurmoUserPreferences to the specified value.
   * @param allowSearchIntoYourNetwork the new allowSearchIntoYourNetwork
   */
  public void setAllowSearchIntoYourNetwork(boolean allowSearchIntoYourNetwork) {
    this.allowSearchIntoYourNetwork = allowSearchIntoYourNetwork;
  }

  /**
   * Gets the forwardMessagesOnDestinationPreferences of this XurmoUserPreferences.
   * @return the forwardMessagesOnDestinationPreferences
   */
  public boolean getForwardMessagesOnDestinationPreferences() {
    return this.forwardMessagesOnDestinationPreferences;
  }

  /**
   * Sets the forwardMessagesOnDestinationPreferences of this XurmoUserPreferences to the specified value.
   * @param forwardMessagesOnDestinationPreferences the new forwardMessagesOnDestinationPreferences
   */
  public void setForwardMessagesOnDestinationPreferences(boolean forwardMessagesOnDestinationPreferences) {
    this.forwardMessagesOnDestinationPreferences = forwardMessagesOnDestinationPreferences;
  }

  /**
   * Gets the forwardMessagesToExternalNetworks of this XurmoUserPreferences.
   * @return the forwardMessagesToExternalNetworks
   */
  public boolean getForwardMessagesToExternalNetworks() {
    return this.forwardMessagesToExternalNetworks;
  }

  /**
   * Sets the forwardMessagesToExternalNetworks of this XurmoUserPreferences to the specified value.
   * @param forwardMessagesToExternalNetworks the new forwardMessagesToExternalNetworks
   */
  public void setForwardMessagesToExternalNetworks(boolean forwardMessagesToExternalNetworks) {
    this.forwardMessagesToExternalNetworks = forwardMessagesToExternalNetworks;
  }

  /**
   * Gets the receivePersonalEventReminders of this XurmoUserPreferences.
   * @return the receivePersonalEventReminders
   */
  public boolean getReceivePersonalEventReminders() {
    return this.receivePersonalEventReminders;
  }

  /**
   * Sets the receivePersonalEventReminders of this XurmoUserPreferences to the specified value.
   * @param receivePersonalEventReminders the new receivePersonalEventReminders
   */
  public void setReceivePersonalEventReminders(boolean receivePersonalEventReminders) {
    this.receivePersonalEventReminders = receivePersonalEventReminders;
  }

  /**
   * Gets the receiveInviteFromEverybody of this XurmoUserPreferences.
   * @return the receiveInviteFromEverybody
   */
  public boolean getReceiveReceiveInviteFromEverybody() {
    return this.receiveInviteFromEverybody;
  }

  /**
   * Sets the receiveInviteFromEverybody of this XurmoUserPreferences to the specified value.
   * @param receiveInviteFromEverybody the new receiveReceiveInviteFromEverybody
   */
  public void setReceiveReceiveInviteFromEverybody(boolean receiveInviteFromEverybody) {
    this.receiveInviteFromEverybody = receiveInviteFromEverybody;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.userid != null ? this.userid.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoUserPreferences.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoUserPreferences object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoUserPreferences)) {
      return false;
    }
    XurmoUserPreferences other = (XurmoUserPreferences)object;
    if (this.userid != other.userid && (this.userid == null || !this.userid.equals(other.userid))) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoUserPreferences[userid=" + userid + "]";
  }
  
}
