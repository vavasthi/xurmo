/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPersonalPhoneNumberEntryPK.java
 * Created on               : March 28, 2007, 11:29 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoPersonalPhoneNumberEntryPK for entity class XurmoPersonalPhoneNumberEntry
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoPersonalPhoneNumberEntryPK implements Serializable {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "addressType", nullable = false)
    private String addressType;
    
    /** Creates a new instance of XurmoPersonalPhoneNumberEntryPK */
    public XurmoPersonalPhoneNumberEntryPK() {
    }

    /**
     * Creates a new instance of XurmoPersonalPhoneNumberEntryPK with the specified values.
     * @param addressType the addressType of the XurmoPersonalPhoneNumberEntryPK
     * @param username the username of the XurmoPersonalPhoneNumberEntryPK
     */
    public XurmoPersonalPhoneNumberEntryPK(String addressType, String username) {
        this.addressType = addressType;
        this.username = username;
    }

    /**
     * Gets the username of this XurmoPersonalPhoneNumberEntryPK.
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the username of this XurmoPersonalPhoneNumberEntryPK to the specified value.
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the addressType of this XurmoPersonalPhoneNumberEntryPK.
     * @return the addressType
     */
    public String getAddressType() {
        return this.addressType;
    }

    /**
     * Sets the addressType of this XurmoPersonalPhoneNumberEntryPK to the specified value.
     * @param addressType the new addressType
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.addressType != null ? this.addressType.hashCode() : 0);
        hash += (this.username != null ? this.username.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoPersonalPhoneNumberEntryPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoPersonalPhoneNumberEntryPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoPersonalPhoneNumberEntryPK)) {
            return false;
        }
        XurmoPersonalPhoneNumberEntryPK other = (XurmoPersonalPhoneNumberEntryPK)object;
        if (this.addressType != other.addressType && (this.addressType == null || !this.addressType.equals(other.addressType))) return false;
        if (this.username != other.username && (this.username == null || !this.username.equals(other.username))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoPersonalPhoneNumberEntryPK[addressType=" + addressType + ", username=" + username + "]";
    }
    
}
