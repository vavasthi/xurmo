/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPersonalAddressBookPhoneNumbersPK.java
 * Created on               : September 9, 2007, 1:38 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoPersonalAddressBookPhoneNumbersPK for entity class XurmoPersonalAddressBookPhoneNumbers
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoPersonalAddressBookPhoneNumbersPK implements Serializable {

    @Column(name = "userid", nullable = false)
    private int userid;

    @Column(name = "uniqueId", nullable = false)
    private int uniqueId;

    @Column(name = "attributeId", nullable = false)
    private int attributeId;

    @Column(name = "entry", nullable = false)
    private int entry;
    
    /** Creates a new instance of XurmoPersonalAddressBookPhoneNumbersPK */
    public XurmoPersonalAddressBookPhoneNumbersPK() {
    }

    /**
     * Creates a new instance of XurmoPersonalAddressBookPhoneNumbersPK with the specified values.
     * @param entry the entry of the XurmoPersonalAddressBookPhoneNumbersPK
     * @param attributeId the attributeId of the XurmoPersonalAddressBookPhoneNumbersPK
     * @param uniqueId the uniqueId of the XurmoPersonalAddressBookPhoneNumbersPK
     * @param userid the userid of the XurmoPersonalAddressBookPhoneNumbersPK
     */
    public XurmoPersonalAddressBookPhoneNumbersPK(int entry, int attributeId, int uniqueId, int userid) {
        this.entry = entry;
        this.attributeId = attributeId;
        this.uniqueId = uniqueId;
        this.userid = userid;
    }

    /**
     * Gets the userid of this XurmoPersonalAddressBookPhoneNumbersPK.
     * @return the userid
     */
    public int getUserid() {
        return this.userid;
    }

    /**
     * Sets the userid of this XurmoPersonalAddressBookPhoneNumbersPK to the specified value.
     * @param userid the new userid
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     * Gets the uniqueId of this XurmoPersonalAddressBookPhoneNumbersPK.
     * @return the uniqueId
     */
    public int getUniqueId() {
        return this.uniqueId;
    }

    /**
     * Sets the uniqueId of this XurmoPersonalAddressBookPhoneNumbersPK to the specified value.
     * @param uniqueId the new uniqueId
     */
    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    /**
     * Gets the attributeId of this XurmoPersonalAddressBookPhoneNumbersPK.
     * @return the attributeId
     */
    public int getAttributeId() {
        return this.attributeId;
    }

    /**
     * Sets the attributeId of this XurmoPersonalAddressBookPhoneNumbersPK to the specified value.
     * @param attributeId the new attributeId
     */
    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }

    /**
     * Gets the entry of this XurmoPersonalAddressBookPhoneNumbersPK.
     * @return the entry
     */
    public int getEntry() {
        return this.entry;
    }

    /**
     * Sets the entry of this XurmoPersonalAddressBookPhoneNumbersPK to the specified value.
     * @param entry the new entry
     */
    public void setEntry(int entry) {
        this.entry = entry;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int)entry;
        hash += (int)attributeId;
        hash += (int)uniqueId;
        hash += (int)userid;
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoPersonalAddressBookPhoneNumbersPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoPersonalAddressBookPhoneNumbersPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoPersonalAddressBookPhoneNumbersPK)) {
            return false;
        }
        XurmoPersonalAddressBookPhoneNumbersPK other = (XurmoPersonalAddressBookPhoneNumbersPK)object;
        if (this.entry != other.entry) return false;
        if (this.attributeId != other.attributeId) return false;
        if (this.uniqueId != other.uniqueId) return false;
        if (this.userid != other.userid) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoPersonalAddressBookPhoneNumbersPK[entry=" + entry + ", attributeId=" + attributeId + ", uniqueId=" + uniqueId + ", userid=" + userid + "]";
    }
    
}
