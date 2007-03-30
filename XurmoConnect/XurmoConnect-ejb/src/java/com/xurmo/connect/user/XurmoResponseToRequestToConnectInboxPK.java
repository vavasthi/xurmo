/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoResponseToRequestToConnectInboxPK.java
 * Created on               : March 30, 2007, 11:41 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoResponseToRequestToConnectInboxPK for entity class XurmoResponseToRequestToConnectInbox
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoResponseToRequestToConnectInboxPK implements Serializable {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "linkId", nullable = false)
    private int linkId;
    
    /** Creates a new instance of XurmoResponseToRequestToConnectInboxPK */
    public XurmoResponseToRequestToConnectInboxPK() {
    }

    /**
     * Creates a new instance of XurmoResponseToRequestToConnectInboxPK with the specified values.
     * @param linkId the linkId of the XurmoResponseToRequestToConnectInboxPK
     * @param source the source of the XurmoResponseToRequestToConnectInboxPK
     * @param username the username of the XurmoResponseToRequestToConnectInboxPK
     */
    public XurmoResponseToRequestToConnectInboxPK(int linkId, String source, String username) {
        this.linkId = linkId;
        this.source = source;
        this.username = username;
    }

    /**
     * Gets the username of this XurmoResponseToRequestToConnectInboxPK.
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the username of this XurmoResponseToRequestToConnectInboxPK to the specified value.
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the source of this XurmoResponseToRequestToConnectInboxPK.
     * @return the source
     */
    public String getSource() {
        return this.source;
    }

    /**
     * Sets the source of this XurmoResponseToRequestToConnectInboxPK to the specified value.
     * @param source the new source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Gets the linkId of this XurmoResponseToRequestToConnectInboxPK.
     * @return the linkId
     */
    public int getLinkId() {
        return this.linkId;
    }

    /**
     * Sets the linkId of this XurmoResponseToRequestToConnectInboxPK to the specified value.
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
        hash += (this.source != null ? this.source.hashCode() : 0);
        hash += (this.username != null ? this.username.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoResponseToRequestToConnectInboxPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoResponseToRequestToConnectInboxPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoResponseToRequestToConnectInboxPK)) {
            return false;
        }
        XurmoResponseToRequestToConnectInboxPK other = (XurmoResponseToRequestToConnectInboxPK)object;
        if (this.linkId != other.linkId) return false;
        if (this.source != other.source && (this.source == null || !this.source.equals(other.source))) return false;
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
        return "com.xurmo.connect.user.XurmoResponseToRequestToConnectInboxPK[linkId=" + linkId + ", source=" + source + ", username=" + username + "]";
    }
    
}
