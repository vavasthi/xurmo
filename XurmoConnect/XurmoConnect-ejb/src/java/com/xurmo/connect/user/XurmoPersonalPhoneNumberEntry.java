/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPersonalPhoneNumberEntry.java
 * Created on               : March 28, 2007, 11:29 PM
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
 * Entity class XurmoPersonalPhoneNumberEntry
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoPersonalPhoneNumberEntry")
@NamedQueries( {
        @NamedQuery(name = "XurmoPersonalPhoneNumberEntry.findByUsername", query = "SELECT x FROM XurmoPersonalPhoneNumberEntry x WHERE x.xurmoPersonalPhoneNumberEntryPK.username = :username"),
        @NamedQuery(name = "XurmoPersonalPhoneNumberEntry.findByAddressType", query = "SELECT x FROM XurmoPersonalPhoneNumberEntry x WHERE x.xurmoPersonalPhoneNumberEntryPK.addressType = :addressType"),
        @NamedQuery(name = "XurmoPersonalPhoneNumberEntry.findByAddress", query = "SELECT x FROM XurmoPersonalPhoneNumberEntry x WHERE x.address = :address")
    })
public class XurmoPersonalPhoneNumberEntry implements Serializable {

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    protected XurmoPersonalPhoneNumberEntryPK xurmoPersonalPhoneNumberEntryPK;

    @Column(name = "address")
    private String address;
    
    /** Creates a new instance of XurmoPersonalPhoneNumberEntry */
    public XurmoPersonalPhoneNumberEntry() {
    }

    /**
     * Creates a new instance of XurmoPersonalPhoneNumberEntry with the specified values.
     * @param xurmoPersonalPhoneNumberEntryPK the xurmoPersonalPhoneNumberEntryPK of the XurmoPersonalPhoneNumberEntry
     */
    public XurmoPersonalPhoneNumberEntry(String username, String addressType, String address) {
        this.xurmoPersonalPhoneNumberEntryPK = new XurmoPersonalPhoneNumberEntryPK(username, addressType);
        this.address = address;
    }

    /**
     * Creates a new instance of XurmoPersonalPhoneNumberEntry with the specified values.
     * @param xurmoPersonalPhoneNumberEntryPK the xurmoPersonalPhoneNumberEntryPK of the XurmoPersonalPhoneNumberEntry
     */
    public XurmoPersonalPhoneNumberEntry(XurmoPersonalPhoneNumberEntryPK xurmoPersonalPhoneNumberEntryPK) {
        this.xurmoPersonalPhoneNumberEntryPK = xurmoPersonalPhoneNumberEntryPK;
    }

    /**
     * Creates a new instance of XurmoPersonalPhoneNumberEntryPK with the specified values.
     * @param addressType the addressType of the XurmoPersonalPhoneNumberEntryPK
     * @param username the username of the XurmoPersonalPhoneNumberEntryPK
     */
    public XurmoPersonalPhoneNumberEntry(String addressType, String username) {
        this.xurmoPersonalPhoneNumberEntryPK = new XurmoPersonalPhoneNumberEntryPK(addressType, username);
    }

    /**
     * Gets the xurmoPersonalPhoneNumberEntryPK of this XurmoPersonalPhoneNumberEntry.
     * @return the xurmoPersonalPhoneNumberEntryPK
     */
    public XurmoPersonalPhoneNumberEntryPK getXurmoPersonalPhoneNumberEntryPK() {
        return this.xurmoPersonalPhoneNumberEntryPK;
    }

    /**
     * Sets the xurmoPersonalPhoneNumberEntryPK of this XurmoPersonalPhoneNumberEntry to the specified value.
     * @param xurmoPersonalPhoneNumberEntryPK the new xurmoPersonalPhoneNumberEntryPK
     */
    public void setXurmoPersonalPhoneNumberEntryPK(XurmoPersonalPhoneNumberEntryPK xurmoPersonalPhoneNumberEntryPK) {
        this.xurmoPersonalPhoneNumberEntryPK = xurmoPersonalPhoneNumberEntryPK;
    }

    /**
     * Gets the address of this XurmoPersonalPhoneNumberEntry.
     * @return the address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Sets the address of this XurmoPersonalPhoneNumberEntry to the specified value.
     * @param address the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.xurmoPersonalPhoneNumberEntryPK != null ? this.xurmoPersonalPhoneNumberEntryPK.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoPersonalPhoneNumberEntry.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoPersonalPhoneNumberEntry object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoPersonalPhoneNumberEntry)) {
            return false;
        }
        XurmoPersonalPhoneNumberEntry other = (XurmoPersonalPhoneNumberEntry)object;
        if (this.xurmoPersonalPhoneNumberEntryPK != other.xurmoPersonalPhoneNumberEntryPK && (this.xurmoPersonalPhoneNumberEntryPK == null || !this.xurmoPersonalPhoneNumberEntryPK.equals(other.xurmoPersonalPhoneNumberEntryPK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoPersonalPhoneNumberEntry[xurmoPersonalPhoneNumberEntryPK=" + xurmoPersonalPhoneNumberEntryPK + "]";
    }
    
}
