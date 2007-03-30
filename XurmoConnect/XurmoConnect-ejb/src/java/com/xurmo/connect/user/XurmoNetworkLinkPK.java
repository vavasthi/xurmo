/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoNetworkLinkPK.java
 * Created on               : March 30, 2007, 11:32 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoNetworkLinkPK for entity class XurmoNetworkLink
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoNetworkLinkPK implements Serializable {

    @Column(name = "username1", nullable = false)
    private String username1;

    @Column(name = "username2", nullable = false)
    private String username2;

    @Column(name = "linkId", nullable = false)
    private int linkId;
    
    /** Creates a new instance of XurmoNetworkLinkPK */
    public XurmoNetworkLinkPK() {
    }

    /**
     * Creates a new instance of XurmoNetworkLinkPK with the specified values.
     * @param linkId the linkId of the XurmoNetworkLinkPK
     * @param username2 the username2 of the XurmoNetworkLinkPK
     * @param username1 the username1 of the XurmoNetworkLinkPK
     */
    public XurmoNetworkLinkPK(int linkId, String username2, String username1) {
        this.linkId = linkId;
        this.username2 = username2;
        this.username1 = username1;
    }

    /**
     * Gets the username1 of this XurmoNetworkLinkPK.
     * @return the username1
     */
    public String getUsername1() {
        return this.username1;
    }

    /**
     * Sets the username1 of this XurmoNetworkLinkPK to the specified value.
     * @param username1 the new username1
     */
    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    /**
     * Gets the username2 of this XurmoNetworkLinkPK.
     * @return the username2
     */
    public String getUsername2() {
        return this.username2;
    }

    /**
     * Sets the username2 of this XurmoNetworkLinkPK to the specified value.
     * @param username2 the new username2
     */
    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    /**
     * Gets the linkId of this XurmoNetworkLinkPK.
     * @return the linkId
     */
    public int getLinkId() {
        return this.linkId;
    }

    /**
     * Sets the linkId of this XurmoNetworkLinkPK to the specified value.
     * @param linkId the new linkId
     */
    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int)linkId;
        hash += (this.username2 != null ? this.username2.hashCode() : 0);
        hash += (this.username1 != null ? this.username1.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoNetworkLinkPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoNetworkLinkPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoNetworkLinkPK)) {
            return false;
        }
        XurmoNetworkLinkPK other = (XurmoNetworkLinkPK)object;
        if (this.linkId != other.linkId) return false;
        if (this.username2 != other.username2 && (this.username2 == null || !this.username2.equals(other.username2))) return false;
        if (this.username1 != other.username1 && (this.username1 == null || !this.username1.equals(other.username1))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoNetworkLinkPK[linkId=" + linkId + ", username2=" + username2 + ", username1=" + username1 + "]";
    }
    
}
