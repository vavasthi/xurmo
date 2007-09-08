/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPersonalAddressBookAddress.java
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
 * Entity class XurmoPersonalAddressBookAddress
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoPersonalAddressBookAddress")
@NamedQueries( {
        @NamedQuery(name = "XurmoPersonalAddressBookAddress.findByUserid", query = "SELECT x FROM XurmoPersonalAddressBookAddress x WHERE x.xurmoPersonalAddressBookAddressPK.userid = :userid"),
        @NamedQuery(name = "XurmoPersonalAddressBookAddress.findByUniqueId", query = "SELECT x FROM XurmoPersonalAddressBookAddress x WHERE x.xurmoPersonalAddressBookAddressPK.uniqueId = :uniqueId"),
        @NamedQuery(name = "XurmoPersonalAddressBookAddress.findByAttributeId", query = "SELECT x FROM XurmoPersonalAddressBookAddress x WHERE x.xurmoPersonalAddressBookAddressPK.attributeId = :attributeId"),
        @NamedQuery(name = "XurmoPersonalAddressBookAddress.findByEntry", query = "SELECT x FROM XurmoPersonalAddressBookAddress x WHERE x.xurmoPersonalAddressBookAddressPK.entry = :entry"),
        @NamedQuery(name = "XurmoPersonalAddressBookAddress.findByAddress", query = "SELECT x FROM XurmoPersonalAddressBookAddress x WHERE x.address = :address")
    })
public class XurmoPersonalAddressBookAddress implements Serializable {

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    protected XurmoPersonalAddressBookAddressPK xurmoPersonalAddressBookAddressPK;

    @Column(name = "address")
    private String address;
    
    /** Creates a new instance of XurmoPersonalAddressBookAddress */
    public XurmoPersonalAddressBookAddress() {
    }

    /**
     * Creates a new instance of XurmoPersonalAddressBookAddress with the specified values.
     * @param xurmoPersonalAddressBookAddressPK the xurmoPersonalAddressBookAddressPK of the XurmoPersonalAddressBookAddress
     */
    public XurmoPersonalAddressBookAddress(XurmoPersonalAddressBookAddressPK xurmoPersonalAddressBookAddressPK) {
        this.xurmoPersonalAddressBookAddressPK = xurmoPersonalAddressBookAddressPK;
    }

    /**
     * Creates a new instance of XurmoPersonalAddressBookAddressPK with the specified values.
     * @param entry the entry of the XurmoPersonalAddressBookAddressPK
     * @param attributeId the attributeId of the XurmoPersonalAddressBookAddressPK
     * @param uniqueId the uniqueId of the XurmoPersonalAddressBookAddressPK
     * @param userid the userid of the XurmoPersonalAddressBookAddressPK
     */
    public XurmoPersonalAddressBookAddress(int userid, int entry, int uniqueId, int attributeId, String address) {
        this.xurmoPersonalAddressBookAddressPK = new XurmoPersonalAddressBookAddressPK(entry, attributeId, uniqueId, userid);
        this.address = address;
    }

    /**
     * Creates a new instance of XurmoPersonalAddressBookAddressPK with the specified values.
     * @param entry the entry of the XurmoPersonalAddressBookAddressPK
     * @param attributeId the attributeId of the XurmoPersonalAddressBookAddressPK
     * @param uniqueId the uniqueId of the XurmoPersonalAddressBookAddressPK
     * @param userid the userid of the XurmoPersonalAddressBookAddressPK
     */
    public XurmoPersonalAddressBookAddress(int entry, int attributeId, int uniqueId, int userid) {
        this.xurmoPersonalAddressBookAddressPK = new XurmoPersonalAddressBookAddressPK(entry, attributeId, uniqueId, userid);
    }

    /**
     * Gets the xurmoPersonalAddressBookAddressPK of this XurmoPersonalAddressBookAddress.
     * @return the xurmoPersonalAddressBookAddressPK
     */
    public XurmoPersonalAddressBookAddressPK getXurmoPersonalAddressBookAddressPK() {
        return this.xurmoPersonalAddressBookAddressPK;
    }

    /**
     * Sets the xurmoPersonalAddressBookAddressPK of this XurmoPersonalAddressBookAddress to the specified value.
     * @param xurmoPersonalAddressBookAddressPK the new xurmoPersonalAddressBookAddressPK
     */
    public void setXurmoPersonalAddressBookAddressPK(XurmoPersonalAddressBookAddressPK xurmoPersonalAddressBookAddressPK) {
        this.xurmoPersonalAddressBookAddressPK = xurmoPersonalAddressBookAddressPK;
    }

    /**
     * Gets the address of this XurmoPersonalAddressBookAddress.
     * @return the address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Sets the address of this XurmoPersonalAddressBookAddress to the specified value.
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
        hash += (this.xurmoPersonalAddressBookAddressPK != null ? this.xurmoPersonalAddressBookAddressPK.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoPersonalAddressBookAddress.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoPersonalAddressBookAddress object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoPersonalAddressBookAddress)) {
            return false;
        }
        XurmoPersonalAddressBookAddress other = (XurmoPersonalAddressBookAddress)object;
        if (this.xurmoPersonalAddressBookAddressPK != other.xurmoPersonalAddressBookAddressPK && (this.xurmoPersonalAddressBookAddressPK == null || !this.xurmoPersonalAddressBookAddressPK.equals(other.xurmoPersonalAddressBookAddressPK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoPersonalAddressBookAddress[xurmoPersonalAddressBookAddressPK=" + xurmoPersonalAddressBookAddressPK + "]";
    }
    
}
