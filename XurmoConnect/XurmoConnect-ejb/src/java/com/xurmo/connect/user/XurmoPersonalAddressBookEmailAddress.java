/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPersonalAddressBookEmailAddress.java
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
 * Entity class XurmoPersonalAddressBookEmailAddress
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoPersonalAddressBookEmailAddress")
@NamedQueries( {
        @NamedQuery(name = "XurmoPersonalAddressBookEmailAddress.findByUserid", query = "SELECT x FROM XurmoPersonalAddressBookEmailAddress x WHERE x.xurmoPersonalAddressBookEmailAddressPK.userid = :userid"),
        @NamedQuery(name = "XurmoPersonalAddressBookEmailAddress.findByUniqueId", query = "SELECT x FROM XurmoPersonalAddressBookEmailAddress x WHERE x.xurmoPersonalAddressBookEmailAddressPK.uniqueId = :uniqueId"),
        @NamedQuery(name = "XurmoPersonalAddressBookEmailAddress.findByAttributeId", query = "SELECT x FROM XurmoPersonalAddressBookEmailAddress x WHERE x.xurmoPersonalAddressBookEmailAddressPK.attributeId = :attributeId"),
        @NamedQuery(name = "XurmoPersonalAddressBookEmailAddress.findByEntry", query = "SELECT x FROM XurmoPersonalAddressBookEmailAddress x WHERE x.xurmoPersonalAddressBookEmailAddressPK.entry = :entry"),
        @NamedQuery(name = "XurmoPersonalAddressBookEmailAddress.findByEmailAddress", query = "SELECT x FROM XurmoPersonalAddressBookEmailAddress x WHERE x.emailAddress = :emailAddress")
    })
public class XurmoPersonalAddressBookEmailAddress implements Serializable {

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    protected XurmoPersonalAddressBookEmailAddressPK xurmoPersonalAddressBookEmailAddressPK;

    @Column(name = "emailAddress")
    private String emailAddress;
    
    /** Creates a new instance of XurmoPersonalAddressBookEmailAddress */
    public XurmoPersonalAddressBookEmailAddress() {
    }

    /**
     * Creates a new instance of XurmoPersonalAddressBookEmailAddress with the specified values.
     * @param xurmoPersonalAddressBookEmailAddressPK the xurmoPersonalAddressBookEmailAddressPK of the XurmoPersonalAddressBookEmailAddress
     */
    public XurmoPersonalAddressBookEmailAddress(XurmoPersonalAddressBookEmailAddressPK xurmoPersonalAddressBookEmailAddressPK) {
        this.xurmoPersonalAddressBookEmailAddressPK = xurmoPersonalAddressBookEmailAddressPK;
    }

    /**
     * Creates a new instance of XurmoPersonalAddressBookEmailAddressPK with the specified values.
     * @param entry the entry of the XurmoPersonalAddressBookEmailAddressPK
     * @param attributeId the attributeId of the XurmoPersonalAddressBookEmailAddressPK
     * @param uniqueId the uniqueId of the XurmoPersonalAddressBookEmailAddressPK
     * @param userid the userid of the XurmoPersonalAddressBookEmailAddressPK
     */
    public XurmoPersonalAddressBookEmailAddress(int userid, int entry, int uniqueId, int attributeId, String emailAddress) {
        this.xurmoPersonalAddressBookEmailAddressPK = new XurmoPersonalAddressBookEmailAddressPK(entry, attributeId, uniqueId, userid);
        this.emailAddress = emailAddress;
    }

    /**
     * Creates a new instance of XurmoPersonalAddressBookEmailAddressPK with the specified values.
     * @param entry the entry of the XurmoPersonalAddressBookEmailAddressPK
     * @param attributeId the attributeId of the XurmoPersonalAddressBookEmailAddressPK
     * @param uniqueId the uniqueId of the XurmoPersonalAddressBookEmailAddressPK
     * @param userid the userid of the XurmoPersonalAddressBookEmailAddressPK
     */
    public XurmoPersonalAddressBookEmailAddress(int entry, int attributeId, int uniqueId, int userid) {
        this.xurmoPersonalAddressBookEmailAddressPK = new XurmoPersonalAddressBookEmailAddressPK(entry, attributeId, uniqueId, userid);
    }
    /**
     * Gets the xurmoPersonalAddressBookEmailAddressPK of this XurmoPersonalAddressBookEmailAddress.
     * @return the xurmoPersonalAddressBookEmailAddressPK
     */
    public XurmoPersonalAddressBookEmailAddressPK getXurmoPersonalAddressBookEmailAddressPK() {
        return this.xurmoPersonalAddressBookEmailAddressPK;
    }

    /**
     * Sets the xurmoPersonalAddressBookEmailAddressPK of this XurmoPersonalAddressBookEmailAddress to the specified value.
     * @param xurmoPersonalAddressBookEmailAddressPK the new xurmoPersonalAddressBookEmailAddressPK
     */
    public void setXurmoPersonalAddressBookEmailAddressPK(XurmoPersonalAddressBookEmailAddressPK xurmoPersonalAddressBookEmailAddressPK) {
        this.xurmoPersonalAddressBookEmailAddressPK = xurmoPersonalAddressBookEmailAddressPK;
    }

    /**
     * Gets the emailAddress of this XurmoPersonalAddressBookEmailAddress.
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Sets the emailAddress of this XurmoPersonalAddressBookEmailAddress to the specified value.
     * @param emailAddress the new emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.xurmoPersonalAddressBookEmailAddressPK != null ? this.xurmoPersonalAddressBookEmailAddressPK.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoPersonalAddressBookEmailAddress.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoPersonalAddressBookEmailAddress object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoPersonalAddressBookEmailAddress)) {
            return false;
        }
        XurmoPersonalAddressBookEmailAddress other = (XurmoPersonalAddressBookEmailAddress)object;
        if (this.xurmoPersonalAddressBookEmailAddressPK != other.xurmoPersonalAddressBookEmailAddressPK && (this.xurmoPersonalAddressBookEmailAddressPK == null || !this.xurmoPersonalAddressBookEmailAddressPK.equals(other.xurmoPersonalAddressBookEmailAddressPK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoPersonalAddressBookEmailAddress[xurmoPersonalAddressBookEmailAddressPK=" + xurmoPersonalAddressBookEmailAddressPK + "]";
    }
    
}
