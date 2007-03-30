/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoRequestToConnectInbox.java
 * Created on               : March 30, 2007, 11:17 PM
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
 * Entity class XurmoRequestToConnectInbox
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoRequestToConnectInbox")
@NamedQueries( {
        @NamedQuery(name = "XurmoRequestToConnectInbox.findByUsername", query = "SELECT x FROM XurmoRequestToConnectInbox x WHERE x.xurmoRequestToConnectInboxPK.username = :username"),
        @NamedQuery(name = "XurmoRequestToConnectInbox.findBySource", query = "SELECT x FROM XurmoRequestToConnectInbox x WHERE x.xurmoRequestToConnectInboxPK.source = :source"),
        @NamedQuery(name = "XurmoRequestToConnectInbox.findByLinkId", query = "SELECT x FROM XurmoRequestToConnectInbox x WHERE x.xurmoRequestToConnectInboxPK.linkId = :linkId"),
        @NamedQuery(name = "XurmoRequestToConnectInbox.findByUsernameSourceAndLinkId", query = "SELECT x FROM XurmoRequestToConnectInbox x WHERE x.xurmoRequestToConnectInboxPK.linkId = :linkId and x.xurmoRequestToConnectInboxPK.source = :source and x.xurmoRequestToConnectInboxPK.username = :username"),
        @NamedQuery(name = "XurmoRequestToConnectInbox.findByMsg", query = "SELECT x FROM XurmoRequestToConnectInbox x WHERE x.msg = :msg")
    })
public class XurmoRequestToConnectInbox implements Serializable {

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    protected XurmoRequestToConnectInboxPK xurmoRequestToConnectInboxPK;

    @Column(name = "msg", nullable = false)
    private String msg;
    
    /** Creates a new instance of XurmoRequestToConnectInbox */
    public XurmoRequestToConnectInbox() {
    }

    /**
     * Creates a new instance of XurmoRequestToConnectInbox with the specified values.
     * @param xurmoRequestToConnectInboxPK the xurmoRequestToConnectInboxPK of the XurmoRequestToConnectInbox
     */
    public XurmoRequestToConnectInbox(XurmoRequestToConnectInboxPK xurmoRequestToConnectInboxPK) {
        this.xurmoRequestToConnectInboxPK = xurmoRequestToConnectInboxPK;
    }

    /**
     * Creates a new instance of XurmoRequestToConnectInbox with the specified values.
     * @param xurmoRequestToConnectInboxPK the xurmoRequestToConnectInboxPK of the XurmoRequestToConnectInbox
     * @param msg the msg of the XurmoRequestToConnectInbox
     */
    public XurmoRequestToConnectInbox(XurmoRequestToConnectInboxPK xurmoRequestToConnectInboxPK, String msg) {
        this.xurmoRequestToConnectInboxPK = xurmoRequestToConnectInboxPK;
        this.msg = msg;
    }

    /**
     * Creates a new instance of XurmoRequestToConnectInboxPK with the specified values.
     * @param linkId the linkId of the XurmoRequestToConnectInboxPK
     * @param source the source of the XurmoRequestToConnectInboxPK
     * @param username the username of the XurmoRequestToConnectInboxPK
     */
    public XurmoRequestToConnectInbox(int linkId, String source, String username, String msg) {
        this.xurmoRequestToConnectInboxPK = new XurmoRequestToConnectInboxPK(linkId, source, username);
        this.msg = msg;
    }

    /**
     * Creates a new instance of XurmoRequestToConnectInboxPK with the specified values.
     * @param linkId the linkId of the XurmoRequestToConnectInboxPK
     * @param source the source of the XurmoRequestToConnectInboxPK
     * @param username the username of the XurmoRequestToConnectInboxPK
     */
    public XurmoRequestToConnectInbox(int linkId, String source, String username) {
        this.xurmoRequestToConnectInboxPK = new XurmoRequestToConnectInboxPK(linkId, source, username);
    }

    /**
     * Gets the xurmoRequestToConnectInboxPK of this XurmoRequestToConnectInbox.
     * @return the xurmoRequestToConnectInboxPK
     */
    public XurmoRequestToConnectInboxPK getXurmoRequestToConnectInboxPK() {
        return this.xurmoRequestToConnectInboxPK;
    }

    /**
     * Sets the xurmoRequestToConnectInboxPK of this XurmoRequestToConnectInbox to the specified value.
     * @param xurmoRequestToConnectInboxPK the new xurmoRequestToConnectInboxPK
     */
    public void setXurmoRequestToConnectInboxPK(XurmoRequestToConnectInboxPK xurmoRequestToConnectInboxPK) {
        this.xurmoRequestToConnectInboxPK = xurmoRequestToConnectInboxPK;
    }

    /**
     * Gets the msg of this XurmoRequestToConnectInbox.
     * @return the msg
     */
    public String getMsg() {
        return this.msg;
    }

    /**
     * Sets the msg of this XurmoRequestToConnectInbox to the specified value.
     * @param msg the new msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.xurmoRequestToConnectInboxPK != null ? this.xurmoRequestToConnectInboxPK.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoRequestToConnectInbox.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoRequestToConnectInbox object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoRequestToConnectInbox)) {
            return false;
        }
        XurmoRequestToConnectInbox other = (XurmoRequestToConnectInbox)object;
        if (this.xurmoRequestToConnectInboxPK != other.xurmoRequestToConnectInboxPK && (this.xurmoRequestToConnectInboxPK == null || !this.xurmoRequestToConnectInboxPK.equals(other.xurmoRequestToConnectInboxPK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoRequestToConnectInbox[xurmoRequestToConnectInboxPK=" + xurmoRequestToConnectInboxPK + "]";
    }
    
}
