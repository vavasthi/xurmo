/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPersonalAddressBookPhoneNumbers.java
 * Created on               : September 9, 2007, 1:38 AM
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
 * Entity class XurmoPersonalAddressBookPhoneNumbers
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoPersonalAddressBookPhoneNumbers")
@NamedQueries( {
        @NamedQuery(name = "XurmoPersonalAddressBookPhoneNumbers.findByUserid", query = "SELECT x FROM XurmoPersonalAddressBookPhoneNumbers x WHERE x.xurmoPersonalAddressBookPhoneNumbersPK.userid = :userid"),
        @NamedQuery(name = "XurmoPersonalAddressBookPhoneNumbers.findByUniqueId", query = "SELECT x FROM XurmoPersonalAddressBookPhoneNumbers x WHERE x.xurmoPersonalAddressBookPhoneNumbersPK.uniqueId = :uniqueId"),
        @NamedQuery(name = "XurmoPersonalAddressBookPhoneNumbers.findByAttributeId", query = "SELECT x FROM XurmoPersonalAddressBookPhoneNumbers x WHERE x.xurmoPersonalAddressBookPhoneNumbersPK.attributeId = :attributeId"),
        @NamedQuery(name = "XurmoPersonalAddressBookPhoneNumbers.findByUseridAttributeIdNonMemberNotInvitedEarlier", query = "SELECT x FROM XurmoPersonalAddressBookPhoneNumbers x, XurmoPersonalAddressBook pab, XurmoInvitationForLink xfl WHERE x.xurmoPersonalAddressBookPhoneNumbersPK.attributeId = :attributeId and x.xurmoPersonalAddressBookPhoneNumbersPK.userid = pab.xurmoPersonalAddressBookPK.userid and x.xurmoPersonalAddressBookPhoneNumbersPK.uniqueId = pab.xurmoPersonalAddressBookPK.uniqueId and pab.xurmoPersonalAddressBookPK.userid = :userid and pab.xurmoMember = false and x.phoneNumber not in (select "),
        @NamedQuery(name = "XurmoPersonalAddressBookPhoneNumbers.findByEntry", query = "SELECT x FROM XurmoPersonalAddressBookPhoneNumbers x WHERE x.xurmoPersonalAddressBookPhoneNumbersPK.entry = :entry"),
        @NamedQuery(name = "XurmoPersonalAddressBookPhoneNumbers.findByPhoneNumber", query = "SELECT x FROM XurmoPersonalAddressBookPhoneNumbers x WHERE x.phoneNumber = :phoneNumber")
    })
public class XurmoPersonalAddressBookPhoneNumbers implements Serializable {

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    protected XurmoPersonalAddressBookPhoneNumbersPK xurmoPersonalAddressBookPhoneNumbersPK;

    @Column(name = "phoneNumber")
    private String phoneNumber;
    
    /** Creates a new instance of XurmoPersonalAddressBookPhoneNumbers */
    public XurmoPersonalAddressBookPhoneNumbers() {
    }

    /**
     * Creates a new instance of XurmoPersonalAddressBookPhoneNumbers with the specified values.
     * @param xurmoPersonalAddressBookPhoneNumbersPK the xurmoPersonalAddressBookPhoneNumbersPK of the XurmoPersonalAddressBookPhoneNumbers
     */
    public XurmoPersonalAddressBookPhoneNumbers(XurmoPersonalAddressBookPhoneNumbersPK xurmoPersonalAddressBookPhoneNumbersPK) {
        this.xurmoPersonalAddressBookPhoneNumbersPK = xurmoPersonalAddressBookPhoneNumbersPK;
    }

    /**
     * Creates a new instance of XurmoPersonalAddressBookPhoneNumbersPK with the specified values.
     * @param entry the entry of the XurmoPersonalAddressBookPhoneNumbersPK
     * @param attributeId the attributeId of the XurmoPersonalAddressBookPhoneNumbersPK
     * @param uniqueId the uniqueId of the XurmoPersonalAddressBookPhoneNumbersPK
     * @param userid the userid of the XurmoPersonalAddressBookPhoneNumbersPK
     */
    public XurmoPersonalAddressBookPhoneNumbers(int userid, int entry, int uniqueId, int attributeId, String phoneNumber) {
        this.xurmoPersonalAddressBookPhoneNumbersPK = new XurmoPersonalAddressBookPhoneNumbersPK(entry, attributeId, uniqueId, userid);
        this.phoneNumber = phoneNumber;
    }

    /**
     * Creates a new instance of XurmoPersonalAddressBookPhoneNumbersPK with the specified values.
     * @param entry the entry of the XurmoPersonalAddressBookPhoneNumbersPK
     * @param attributeId the attributeId of the XurmoPersonalAddressBookPhoneNumbersPK
     * @param uniqueId the uniqueId of the XurmoPersonalAddressBookPhoneNumbersPK
     * @param userid the userid of the XurmoPersonalAddressBookPhoneNumbersPK
     */
    public XurmoPersonalAddressBookPhoneNumbers(int entry, int attributeId, int uniqueId, int userid) {
        this.xurmoPersonalAddressBookPhoneNumbersPK = new XurmoPersonalAddressBookPhoneNumbersPK(entry, attributeId, uniqueId, userid);
    }

    /**
     * Gets the xurmoPersonalAddressBookPhoneNumbersPK of this XurmoPersonalAddressBookPhoneNumbers.
     * @return the xurmoPersonalAddressBookPhoneNumbersPK
     */
    public XurmoPersonalAddressBookPhoneNumbersPK getXurmoPersonalAddressBookPhoneNumbersPK() {
        return this.xurmoPersonalAddressBookPhoneNumbersPK;
    }

    /**
     * Sets the xurmoPersonalAddressBookPhoneNumbersPK of this XurmoPersonalAddressBookPhoneNumbers to the specified value.
     * @param xurmoPersonalAddressBookPhoneNumbersPK the new xurmoPersonalAddressBookPhoneNumbersPK
     */
    public void setXurmoPersonalAddressBookPhoneNumbersPK(XurmoPersonalAddressBookPhoneNumbersPK xurmoPersonalAddressBookPhoneNumbersPK) {
        this.xurmoPersonalAddressBookPhoneNumbersPK = xurmoPersonalAddressBookPhoneNumbersPK;
    }

    /**
     * Gets the phoneNumber of this XurmoPersonalAddressBookPhoneNumbers.
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets the phoneNumber of this XurmoPersonalAddressBookPhoneNumbers to the specified value.
     * @param phoneNumber the new phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.xurmoPersonalAddressBookPhoneNumbersPK != null ? this.xurmoPersonalAddressBookPhoneNumbersPK.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoPersonalAddressBookPhoneNumbers.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoPersonalAddressBookPhoneNumbers object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoPersonalAddressBookPhoneNumbers)) {
            return false;
        }
        XurmoPersonalAddressBookPhoneNumbers other = (XurmoPersonalAddressBookPhoneNumbers)object;
        if (this.xurmoPersonalAddressBookPhoneNumbersPK != other.xurmoPersonalAddressBookPhoneNumbersPK && (this.xurmoPersonalAddressBookPhoneNumbersPK == null || !this.xurmoPersonalAddressBookPhoneNumbersPK.equals(other.xurmoPersonalAddressBookPhoneNumbersPK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoPersonalAddressBookPhoneNumbers[xurmoPersonalAddressBookPhoneNumbersPK=" + xurmoPersonalAddressBookPhoneNumbersPK + "]";
    }
    
}
