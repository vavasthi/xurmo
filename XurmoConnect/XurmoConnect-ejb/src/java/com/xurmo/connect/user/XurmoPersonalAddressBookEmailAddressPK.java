/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPersonalAddressBookEmailAddressPK.java
 * Created on               : September 3, 2007, 12:51 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoPersonalAddressBookEmailAddressPK for entity class XurmoPersonalAddressBookEmailAddress
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoPersonalAddressBookEmailAddressPK implements Serializable {

    @Column(name = "userid", nullable = false)
    private int userid;

    @Column(name = "uniqueId", nullable = false)
    private int uniqueId;

    @Column(name = "attributeId", nullable = false)
    private int attributeId;
    
    /** Creates a new instance of XurmoPersonalAddressBookEmailAddressPK */
    public XurmoPersonalAddressBookEmailAddressPK() {
    }

    /**
     * Creates a new instance of XurmoPersonalAddressBookEmailAddressPK with the specified values.
     * @param attributeId the attributeId of the XurmoPersonalAddressBookEmailAddressPK
     * @param uniqueId the uniqueId of the XurmoPersonalAddressBookEmailAddressPK
     * @param userid the userid of the XurmoPersonalAddressBookEmailAddressPK
     */
    public XurmoPersonalAddressBookEmailAddressPK(int attributeId, int uniqueId, int userid) {
        this.attributeId = attributeId;
        this.uniqueId = uniqueId;
        this.userid = userid;
    }

    /**
     * Gets the userid of this XurmoPersonalAddressBookEmailAddressPK.
     * @return the userid
     */
    public int getUserid() {
        return this.userid;
    }

    /**
     * Sets the userid of this XurmoPersonalAddressBookEmailAddressPK to the specified value.
     * @param userid the new userid
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     * Gets the uniqueId of this XurmoPersonalAddressBookEmailAddressPK.
     * @return the uniqueId
     */
    public int getUniqueId() {
        return this.uniqueId;
    }

    /**
     * Sets the uniqueId of this XurmoPersonalAddressBookEmailAddressPK to the specified value.
     * @param uniqueId the new uniqueId
     */
    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    /**
     * Gets the attributeId of this XurmoPersonalAddressBookEmailAddressPK.
     * @return the attributeId
     */
    public int getAttributeId() {
        return this.attributeId;
    }

    /**
     * Sets the attributeId of this XurmoPersonalAddressBookEmailAddressPK to the specified value.
     * @param attributeId the new attributeId
     */
    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int)attributeId;
        hash += (int)uniqueId;
        hash += (int)userid;
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoPersonalAddressBookEmailAddressPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoPersonalAddressBookEmailAddressPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoPersonalAddressBookEmailAddressPK)) {
            return false;
        }
        XurmoPersonalAddressBookEmailAddressPK other = (XurmoPersonalAddressBookEmailAddressPK)object;
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
        return "com.xurmo.connect.user.XurmoPersonalAddressBookEmailAddressPK[attributeId=" + attributeId + ", uniqueId=" + uniqueId + ", userid=" + userid + "]";
    }
    
}
