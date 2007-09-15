/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserNetworkSpecificPreferences.java
 * Created on               : September 15, 2007, 10:28 PM
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
 * Entity class XurmoUserNetworkSpecificPreferences
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoUserNetworkSpecificPreferences")
@NamedQueries( {
    @NamedQuery(name = "XurmoUserNetworkSpecificPreferences.findByUserid", query = "SELECT x FROM XurmoUserNetworkSpecificPreferences x WHERE x.xurmoUserNetworkSpecificPreferencesPK.userid = :userid"),
    @NamedQuery(name = "XurmoUserNetworkSpecificPreferences.findByLinkId", query = "SELECT x FROM XurmoUserNetworkSpecificPreferences x WHERE x.xurmoUserNetworkSpecificPreferencesPK.linkId = :linkId"),
    @NamedQuery(name = "XurmoUserNetworkSpecificPreferences.findByUseridAndLinkId", query = "SELECT x FROM XurmoUserNetworkSpecificPreferences x WHERE x.xurmoUserNetworkSpecificPreferencesPK.userid = :userid and x.xurmoUserNetworkSpecificPreferencesPK.linkId = :linkId"),
    @NamedQuery(name = "XurmoUserNetworkSpecificPreferences.findByReceiveDefaultMessagesDegrees", query = "SELECT x FROM XurmoUserNetworkSpecificPreferences x WHERE x.receiveDefaultMessagesDegrees = :receiveDefaultMessagesDegrees"),
    @NamedQuery(name = "XurmoUserNetworkSpecificPreferences.findByAllowSearchIntoYourNetwork", query = "SELECT x FROM XurmoUserNetworkSpecificPreferences x WHERE x.allowSearchIntoYourNetwork = :allowSearchIntoYourNetwork"),
    @NamedQuery(name = "XurmoUserNetworkSpecificPreferences.findByForwardMessagesOnDestinationPreferences", query = "SELECT x FROM XurmoUserNetworkSpecificPreferences x WHERE x.forwardMessagesOnDestinationPreferences = :forwardMessagesOnDestinationPreferences"),
    @NamedQuery(name = "XurmoUserNetworkSpecificPreferences.findByForwardMessagesToExternalNetworks", query = "SELECT x FROM XurmoUserNetworkSpecificPreferences x WHERE x.forwardMessagesToExternalNetworks = :forwardMessagesToExternalNetworks"),
    @NamedQuery(name = "XurmoUserNetworkSpecificPreferences.findByReceivePersonalEvenReminders", query = "SELECT x FROM XurmoUserNetworkSpecificPreferences x WHERE x.receivePersonalEvenReminders = :receivePersonalEvenReminders")
  })
public class XurmoUserNetworkSpecificPreferences implements Serializable {

  /**
   * EmbeddedId primary key field
   */
  @EmbeddedId
  protected XurmoUserNetworkSpecificPreferencesPK xurmoUserNetworkSpecificPreferencesPK;

  @Column(name = "receiveDefaultMessagesDegrees", nullable = false)
  private int receiveDefaultMessagesDegrees;

  @Column(name = "allowSearchIntoYourNetwork", nullable = false)
  private boolean allowSearchIntoYourNetwork;

  @Column(name = "forwardMessagesOnDestinationPreferences", nullable = false)
  private boolean forwardMessagesOnDestinationPreferences;

  @Column(name = "forwardMessagesToExternalNetworks", nullable = false)
  private boolean forwardMessagesToExternalNetworks;

  @Column(name = "receivePersonalEvenReminders", nullable = false)
  private boolean receivePersonalEvenReminders;
  
  /** Creates a new instance of XurmoUserNetworkSpecificPreferences */
  public XurmoUserNetworkSpecificPreferences() {
  }

  /**
   * Creates a new instance of XurmoUserNetworkSpecificPreferences with the specified values.
   * @param xurmoUserNetworkSpecificPreferencesPK the xurmoUserNetworkSpecificPreferencesPK of the XurmoUserNetworkSpecificPreferences
   */
  public XurmoUserNetworkSpecificPreferences(XurmoUserNetworkSpecificPreferencesPK xurmoUserNetworkSpecificPreferencesPK) {
    this.xurmoUserNetworkSpecificPreferencesPK = xurmoUserNetworkSpecificPreferencesPK;
  }

  /**
   * Creates a new instance of XurmoUserNetworkSpecificPreferences with the specified values.
   * @param xurmoUserNetworkSpecificPreferencesPK the xurmoUserNetworkSpecificPreferencesPK of the XurmoUserNetworkSpecificPreferences
   * @param receiveDefaultMessagesDegrees the receiveDefaultMessagesDegrees of the XurmoUserNetworkSpecificPreferences
   * @param allowSearchIntoYourNetwork the allowSearchIntoYourNetwork of the XurmoUserNetworkSpecificPreferences
   * @param forwardMessagesOnDestinationPreferences the forwardMessagesOnDestinationPreferences of the XurmoUserNetworkSpecificPreferences
   * @param forwardMessagesToExternalNetworks the forwardMessagesToExternalNetworks of the XurmoUserNetworkSpecificPreferences
   * @param receivePersonalEvenReminders the receivePersonalEvenReminders of the XurmoUserNetworkSpecificPreferences
   */
  public XurmoUserNetworkSpecificPreferences(XurmoUserNetworkSpecificPreferencesPK xurmoUserNetworkSpecificPreferencesPK, int receiveDefaultMessagesDegrees, boolean allowSearchIntoYourNetwork, boolean forwardMessagesOnDestinationPreferences, boolean forwardMessagesToExternalNetworks, boolean receivePersonalEvenReminders) {
    this.xurmoUserNetworkSpecificPreferencesPK = xurmoUserNetworkSpecificPreferencesPK;
    this.receiveDefaultMessagesDegrees = receiveDefaultMessagesDegrees;
    this.allowSearchIntoYourNetwork = allowSearchIntoYourNetwork;
    this.forwardMessagesOnDestinationPreferences = forwardMessagesOnDestinationPreferences;
    this.forwardMessagesToExternalNetworks = forwardMessagesToExternalNetworks;
    this.receivePersonalEvenReminders = receivePersonalEvenReminders;
  }

  /**
   * Creates a new instance of XurmoUserNetworkSpecificPreferencesPK with the specified values.
   * @param linkId the linkId of the XurmoUserNetworkSpecificPreferencesPK
   * @param userid the userid of the XurmoUserNetworkSpecificPreferencesPK
   */
  public XurmoUserNetworkSpecificPreferences(int linkId, int userid) {
    this.xurmoUserNetworkSpecificPreferencesPK = new XurmoUserNetworkSpecificPreferencesPK(linkId, userid);
  }

  /**
   * Gets the xurmoUserNetworkSpecificPreferencesPK of this XurmoUserNetworkSpecificPreferences.
   * @return the xurmoUserNetworkSpecificPreferencesPK
   */
  public XurmoUserNetworkSpecificPreferencesPK getXurmoUserNetworkSpecificPreferencesPK() {
    return this.xurmoUserNetworkSpecificPreferencesPK;
  }

  /**
   * Sets the xurmoUserNetworkSpecificPreferencesPK of this XurmoUserNetworkSpecificPreferences to the specified value.
   * @param xurmoUserNetworkSpecificPreferencesPK the new xurmoUserNetworkSpecificPreferencesPK
   */
  public void setXurmoUserNetworkSpecificPreferencesPK(XurmoUserNetworkSpecificPreferencesPK xurmoUserNetworkSpecificPreferencesPK) {
    this.xurmoUserNetworkSpecificPreferencesPK = xurmoUserNetworkSpecificPreferencesPK;
  }

  /**
   * Gets the receiveDefaultMessagesDegrees of this XurmoUserNetworkSpecificPreferences.
   * @return the receiveDefaultMessagesDegrees
   */
  public int getReceiveDefaultMessagesDegrees() {
    return this.receiveDefaultMessagesDegrees;
  }

  /**
   * Sets the receiveDefaultMessagesDegrees of this XurmoUserNetworkSpecificPreferences to the specified value.
   * @param receiveDefaultMessagesDegrees the new receiveDefaultMessagesDegrees
   */
  public void setReceiveDefaultMessagesDegrees(int receiveDefaultMessagesDegrees) {
    this.receiveDefaultMessagesDegrees = receiveDefaultMessagesDegrees;
  }

  /**
   * Gets the allowSearchIntoYourNetwork of this XurmoUserNetworkSpecificPreferences.
   * @return the allowSearchIntoYourNetwork
   */
  public boolean getAllowSearchIntoYourNetwork() {
    return this.allowSearchIntoYourNetwork;
  }

  /**
   * Sets the allowSearchIntoYourNetwork of this XurmoUserNetworkSpecificPreferences to the specified value.
   * @param allowSearchIntoYourNetwork the new allowSearchIntoYourNetwork
   */
  public void setAllowSearchIntoYourNetwork(boolean allowSearchIntoYourNetwork) {
    this.allowSearchIntoYourNetwork = allowSearchIntoYourNetwork;
  }

  /**
   * Gets the forwardMessagesOnDestinationPreferences of this XurmoUserNetworkSpecificPreferences.
   * @return the forwardMessagesOnDestinationPreferences
   */
  public boolean getForwardMessagesOnDestinationPreferences() {
    return this.forwardMessagesOnDestinationPreferences;
  }

  /**
   * Sets the forwardMessagesOnDestinationPreferences of this XurmoUserNetworkSpecificPreferences to the specified value.
   * @param forwardMessagesOnDestinationPreferences the new forwardMessagesOnDestinationPreferences
   */
  public void setForwardMessagesOnDestinationPreferences(boolean forwardMessagesOnDestinationPreferences) {
    this.forwardMessagesOnDestinationPreferences = forwardMessagesOnDestinationPreferences;
  }

  /**
   * Gets the forwardMessagesToExternalNetworks of this XurmoUserNetworkSpecificPreferences.
   * @return the forwardMessagesToExternalNetworks
   */
  public boolean getForwardMessagesToExternalNetworks() {
    return this.forwardMessagesToExternalNetworks;
  }

  /**
   * Sets the forwardMessagesToExternalNetworks of this XurmoUserNetworkSpecificPreferences to the specified value.
   * @param forwardMessagesToExternalNetworks the new forwardMessagesToExternalNetworks
   */
  public void setForwardMessagesToExternalNetworks(boolean forwardMessagesToExternalNetworks) {
    this.forwardMessagesToExternalNetworks = forwardMessagesToExternalNetworks;
  }

  /**
   * Gets the receivePersonalEvenReminders of this XurmoUserNetworkSpecificPreferences.
   * @return the receivePersonalEvenReminders
   */
  public boolean getReceivePersonalEvenReminders() {
    return this.receivePersonalEvenReminders;
  }

  /**
   * Sets the receivePersonalEvenReminders of this XurmoUserNetworkSpecificPreferences to the specified value.
   * @param receivePersonalEvenReminders the new receivePersonalEvenReminders
   */
  public void setReceivePersonalEvenReminders(boolean receivePersonalEvenReminders) {
    this.receivePersonalEvenReminders = receivePersonalEvenReminders;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.xurmoUserNetworkSpecificPreferencesPK != null ? this.xurmoUserNetworkSpecificPreferencesPK.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoUserNetworkSpecificPreferences.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoUserNetworkSpecificPreferences object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoUserNetworkSpecificPreferences)) {
      return false;
    }
    XurmoUserNetworkSpecificPreferences other = (XurmoUserNetworkSpecificPreferences)object;
    if (this.xurmoUserNetworkSpecificPreferencesPK != other.xurmoUserNetworkSpecificPreferencesPK && (this.xurmoUserNetworkSpecificPreferencesPK == null || !this.xurmoUserNetworkSpecificPreferencesPK.equals(other.xurmoUserNetworkSpecificPreferencesPK))) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoUserNetworkSpecificPreferences[xurmoUserNetworkSpecificPreferencesPK=" + xurmoUserNetworkSpecificPreferencesPK + "]";
  }
  
}
