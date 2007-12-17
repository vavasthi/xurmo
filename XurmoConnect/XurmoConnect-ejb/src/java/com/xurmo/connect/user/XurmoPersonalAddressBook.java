/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPersonalAddressBook.java
 * Created on               : September 21, 2007, 1:03 AM
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
 * Entity class XurmoPersonalAddressBook
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoPersonalAddressBook")
@NamedQueries( {
    @NamedQuery(name = "XurmoPersonalAddressBook.findByUserid", query = "SELECT x FROM XurmoPersonalAddressBook x WHERE x.xurmoPersonalAddressBookPK.userid = :userid"),
    @NamedQuery(name = "XurmoPersonalAddressBook.findByUniqueId", query = "SELECT x FROM XurmoPersonalAddressBook x WHERE x.xurmoPersonalAddressBookPK.uniqueId = :uniqueId"),
    @NamedQuery(name = "XurmoPersonalAddressBook.findByContactName", query = "SELECT x FROM XurmoPersonalAddressBook x WHERE x.contactName = :contactName"),
    @NamedQuery(name = "XurmoPersonalAddressBook.findByNickname", query = "SELECT x FROM XurmoPersonalAddressBook x WHERE x.nickname = :nickname"),
    @NamedQuery(name = "XurmoPersonalAddressBook.findByBirthday", query = "SELECT x FROM XurmoPersonalAddressBook x WHERE x.birthday = :birthday"),
    @NamedQuery(name = "XurmoPersonalAddressBook.findByXurmoMember", query = "SELECT x FROM XurmoPersonalAddressBook x WHERE x.xurmoMember = :xurmoMember"),
    @NamedQuery(name = "XurmoPersonalAddressBook.findByXurmoMemberUserId", query = "SELECT x FROM XurmoPersonalAddressBook x WHERE x.xurmoMemberUserId = :xurmoMemberUserId"),
    @NamedQuery(name = "XurmoPersonalAddressBook.findByXurmoInvitationSent", query = "SELECT x FROM XurmoPersonalAddressBook x WHERE x.xurmoInvitationSent = :xurmoInvitationSent"),
    @NamedQuery(name = "XurmoPersonalAddressBook.findByUseridAndUniqueId", query = "SELECT x FROM XurmoPersonalAddressBook x WHERE x.xurmoPersonalAddressBookPK.userid = :userid and x.xurmoPersonalAddressBookPK.uniqueId = :uniqueId"),
    @NamedQuery(name = "XurmoPersonalAddressBook.findByXurmoInvitationSent", query = "SELECT x FROM XurmoPersonalAddressBook x WHERE x.xurmoInvitationSent = :xurmoInvitationSent"),
    @NamedQuery(name = "XurmoPersonalAddressBook.findByInviteToConnectEntries", query = "SELECT x FROM XurmoPersonalAddressBook x WHERE x.xurmoInvitationSent = false and x.xurmoMember = true and x.xurmoPersonalAddressBookPK.userid = :userid"),
    @NamedQuery(name = "XurmoPersonalAddressBook.findByInviteToJoinEntries", query = "SELECT x FROM XurmoPersonalAddressBook x WHERE x.xurmoInvitationSent = false and x.xurmoMember = false and x.xurmoPersonalAddressBookPK.userid = :userid"),
    @NamedQuery(name = "XurmoPersonalAddressBook.findByPhoneNumber", query = "select x from XurmoPersonalAddressBook x, XurmoPersonalAddressBookPhoneNumbers pn where pn.xurmoPersonalAddressBookPhoneNumbersPK.userid = x.xurmoPersonalAddressBookPK.userid and pn.phoneNumber = :phoneNumber and x.xurmoPersonalAddressBookPK.uniqueId = pn.xurmoPersonalAddressBookPhoneNumbersPK.uniqueId")
 })
public class XurmoPersonalAddressBook implements Serializable {

  /**
   * EmbeddedId primary key field
   */
  @EmbeddedId
  protected XurmoPersonalAddressBookPK xurmoPersonalAddressBookPK;

  @Column(name = "contactName", nullable = false)
  private String contactName;

  @Column(name = "nickname")
  private String nickname;

  @Column(name = "birthday")
  @Temporal(TemporalType.TIMESTAMP)
  private Date birthday;

  @Column(name = "xurmoMember", nullable = false)
  private boolean xurmoMember;

  @Column(name = "xurmoMemberUserId")
  private Integer xurmoMemberUserId;

  @Column(name = "xurmoInvitationSent", nullable = false)
  private boolean xurmoInvitationSent;
  
  /** Creates a new instance of XurmoPersonalAddressBook */
  public XurmoPersonalAddressBook() {
    this.xurmoInvitationSent = false;
  }

  /**
   * Creates a new instance of XurmoPersonalAddressBook with the specified values.
   * @param xurmoPersonalAddressBookPK the xurmoPersonalAddressBookPK of the XurmoPersonalAddressBook
   */
  public XurmoPersonalAddressBook(XurmoPersonalAddressBookPK xurmoPersonalAddressBookPK) {
    this.xurmoPersonalAddressBookPK = xurmoPersonalAddressBookPK;
    this.xurmoInvitationSent = false;
  }

  /**
   * Creates a new instance of XurmoPersonalAddressBook with the specified values.
   * @param xurmoPersonalAddressBookPK the xurmoPersonalAddressBookPK of the XurmoPersonalAddressBook
   * @param contactName the contactName of the XurmoPersonalAddressBook
   * @param xurmoMember the xurmoMember of the XurmoPersonalAddressBook
   * @param xurmoInvitationSent the xurmoInvitationSent of the XurmoPersonalAddressBook
   */
  public XurmoPersonalAddressBook(XurmoPersonalAddressBookPK xurmoPersonalAddressBookPK, String contactName, boolean xurmoMember, boolean xurmoInvitationSent) {
    this.xurmoPersonalAddressBookPK = xurmoPersonalAddressBookPK;
    this.contactName = contactName;
    this.xurmoMember = xurmoMember;
    this.xurmoInvitationSent = xurmoInvitationSent;
  }

  /**
   * Creates a new instance of XurmoPersonalAddressBookPK with the specified values.
   * @param uniqueId the uniqueId of the XurmoPersonalAddressBookPK
   * @param userid the userid of the XurmoPersonalAddressBookPK
   */
  public XurmoPersonalAddressBook(int uniqueId, int userid) {
    this.xurmoPersonalAddressBookPK = new XurmoPersonalAddressBookPK(uniqueId, userid);
    this.xurmoInvitationSent = false;
  }

  /**
   * Gets the xurmoPersonalAddressBookPK of this XurmoPersonalAddressBook.
   * @return the xurmoPersonalAddressBookPK
   */
  public XurmoPersonalAddressBookPK getXurmoPersonalAddressBookPK() {
    return this.xurmoPersonalAddressBookPK;
  }

  /**
   * Sets the xurmoPersonalAddressBookPK of this XurmoPersonalAddressBook to the specified value.
   * @param xurmoPersonalAddressBookPK the new xurmoPersonalAddressBookPK
   */
  public void setXurmoPersonalAddressBookPK(XurmoPersonalAddressBookPK xurmoPersonalAddressBookPK) {
    this.xurmoPersonalAddressBookPK = xurmoPersonalAddressBookPK;
  }

  /**
   * Gets the contactName of this XurmoPersonalAddressBook.
   * @return the contactName
   */
  public String getContactName() {
    return this.contactName;
  }

  /**
   * Sets the contactName of this XurmoPersonalAddressBook to the specified value.
   * @param contactName the new contactName
   */
  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  /**
   * Gets the nickname of this XurmoPersonalAddressBook.
   * @return the nickname
   */
  public String getNickname() {
    return this.nickname;
  }

  /**
   * Sets the nickname of this XurmoPersonalAddressBook to the specified value.
   * @param nickname the new nickname
   */
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  /**
   * Gets the birthday of this XurmoPersonalAddressBook.
   * @return the birthday
   */
  public Date getBirthday() {
    return this.birthday;
  }

  /**
   * Sets the birthday of this XurmoPersonalAddressBook to the specified value.
   * @param birthday the new birthday
   */
  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  /**
   * Gets the xurmoMember of this XurmoPersonalAddressBook.
   * @return the xurmoMember
   */
  public boolean getXurmoMember() {
    return this.xurmoMember;
  }

  /**
   * Sets the xurmoMember of this XurmoPersonalAddressBook to the specified value.
   * @param xurmoMember the new xurmoMember
   */
  public void setXurmoMember(boolean xurmoMember) {
    this.xurmoMember = xurmoMember;
  }

  /**
   * Gets the xurmoMemberUserId of this XurmoPersonalAddressBook.
   * @return the xurmoMemberUserId
   */
  public Integer getXurmoMemberUserId() {
    return this.xurmoMemberUserId;
  }

  /**
   * Sets the xurmoMemberUserId of this XurmoPersonalAddressBook to the specified value.
   * @param xurmoMemberUserId the new xurmoMemberUserId
   */
  public void setXurmoMemberUserId(Integer xurmoMemberUserId) {
    this.xurmoMemberUserId = xurmoMemberUserId;
  }

  /**
   * Gets the xurmoInvitationSent of this XurmoPersonalAddressBook.
   * @return the xurmoInvitationSent
   */
  public boolean getXurmoInvitationSent() {
    return this.xurmoInvitationSent;
  }

  /**
   * Sets the xurmoInvitationSent of this XurmoPersonalAddressBook to the specified value.
   * @param xurmoInvitationSent the new xurmoInvitationSent
   */
  public void setXurmoInvitationSent(boolean xurmoInvitationSent) {
    this.xurmoInvitationSent = xurmoInvitationSent;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.xurmoPersonalAddressBookPK != null ? this.xurmoPersonalAddressBookPK.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoPersonalAddressBook.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoPersonalAddressBook object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoPersonalAddressBook)) {
      return false;
    }
    XurmoPersonalAddressBook other = (XurmoPersonalAddressBook)object;
    if (this.xurmoPersonalAddressBookPK != other.xurmoPersonalAddressBookPK && (this.xurmoPersonalAddressBookPK == null || !this.xurmoPersonalAddressBookPK.equals(other.xurmoPersonalAddressBookPK))) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoPersonalAddressBook[xurmoPersonalAddressBookPK=" + xurmoPersonalAddressBookPK + "]";
  }
  
}
