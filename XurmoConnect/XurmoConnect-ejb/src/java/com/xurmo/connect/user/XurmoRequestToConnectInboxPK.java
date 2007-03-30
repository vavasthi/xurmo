/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoRequestToConnectInboxPK.java
 * Created on               : March 30, 2007, 11:17 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoRequestToConnectInboxPK for entity class XurmoRequestToConnectInbox
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoRequestToConnectInboxPK implements Serializable {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "linkId", nullable = false)
    private int linkId;
    
    /** Creates a new instance of XurmoRequestToConnectInboxPK */
    public XurmoRequestToConnectInboxPK() {
    }

    /**
     * Creates a new instance of XurmoRequestToConnectInboxPK with the specified values.
     * @param linkId the linkId of the XurmoRequestToConnectInboxPK
     * @param source the source of the XurmoRequestToConnectInboxPK
     * @param username the username of the XurmoRequestToConnectInboxPK
     */
    public XurmoRequestToConnectInboxPK(int linkId, String source, String username) {
        this.linkId = linkId;
        this.source = source;
        this.username = username;
    }

    /**
     * Gets the username of this XurmoRequestToConnectInboxPK.
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the username of this XurmoRequestToConnectInboxPK to the specified value.
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the source of this XurmoRequestToConnectInboxPK.
     * @return the source
     */
    public String getSource() {
        return this.source;
    }

    /**
     * Sets the source of this XurmoRequestToConnectInboxPK to the specified value.
     * @param source the new source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Gets the linkId of this XurmoRequestToConnectInboxPK.
     * @return the linkId
     */
    public int getLinkId() {
        return this.linkId;
    }

    /**
     * Sets the linkId of this XurmoRequestToConnectInboxPK to the specified value.
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
     * Determines whether another object is equal to this XurmoRequestToConnectInboxPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoRequestToConnectInboxPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoRequestToConnectInboxPK)) {
            return false;
        }
        XurmoRequestToConnectInboxPK other = (XurmoRequestToConnectInboxPK)object;
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
        return "com.xurmo.connect.user.XurmoRequestToConnectInboxPK[linkId=" + linkId + ", source=" + source + ", username=" + username + "]";
    }
    
}
