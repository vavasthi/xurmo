/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoResponseToRequestToConnectInbox.java
 * Created on               : March 29, 2007, 9:48 PM
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
 * Entity class XurmoResponseToRequestToConnectInbox
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoResponseToRequestToConnectInbox")
@NamedQueries( {
        @NamedQuery(name = "XurmoResponseToRequestToConnectInbox.findByUsername", query = "SELECT x FROM XurmoResponseToRequestToConnectInbox x WHERE x.xurmoResponseToRequestToConnectInboxPK.username = :username"),
        @NamedQuery(name = "XurmoResponseToRequestToConnectInbox.findBySource", query = "SELECT x FROM XurmoResponseToRequestToConnectInbox x WHERE x.xurmoResponseToRequestToConnectInboxPK.source = :source"),
        @NamedQuery(name = "XurmoResponseToRequestToConnectInbox.findByMsg", query = "SELECT x FROM XurmoResponseToRequestToConnectInbox x WHERE x.msg = :msg")
    })
public class XurmoResponseToRequestToConnectInbox implements Serializable {

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    protected XurmoResponseToRequestToConnectInboxPK xurmoResponseToRequestToConnectInboxPK;

    @Column(name = "msg", nullable = false)
    private String msg;
    
    /** Creates a new instance of XurmoResponseToRequestToConnectInbox */
    public XurmoResponseToRequestToConnectInbox() {
    }

    /**
     * Creates a new instance of XurmoResponseToRequestToConnectInbox with the specified values.
     * @param xurmoResponseToRequestToConnectInboxPK the xurmoResponseToRequestToConnectInboxPK of the XurmoResponseToRequestToConnectInbox
     */
    public XurmoResponseToRequestToConnectInbox(XurmoResponseToRequestToConnectInboxPK xurmoResponseToRequestToConnectInboxPK) {
        this.xurmoResponseToRequestToConnectInboxPK = xurmoResponseToRequestToConnectInboxPK;
    }

    /**
     * Creates a new instance of XurmoResponseToRequestToConnectInbox with the specified values.
     * @param xurmoResponseToRequestToConnectInboxPK the xurmoResponseToRequestToConnectInboxPK of the XurmoResponseToRequestToConnectInbox
     * @param msg the msg of the XurmoResponseToRequestToConnectInbox
     */
    public XurmoResponseToRequestToConnectInbox(XurmoResponseToRequestToConnectInboxPK xurmoResponseToRequestToConnectInboxPK, String msg) {
        this.xurmoResponseToRequestToConnectInboxPK = xurmoResponseToRequestToConnectInboxPK;
        this.msg = msg;
    }

    /**
     * Creates a new instance of XurmoResponseToRequestToConnectInboxPK with the specified values.
     * @param source the source of the XurmoResponseToRequestToConnectInboxPK
     * @param username the username of the XurmoResponseToRequestToConnectInboxPK
     */
    public XurmoResponseToRequestToConnectInbox(String source, String username) {
        this.xurmoResponseToRequestToConnectInboxPK = new XurmoResponseToRequestToConnectInboxPK(source, username);
    }

    /**
     * Creates a new instance of XurmoResponseToRequestToConnectInboxPK with the specified values.
     * @param source the source of the XurmoResponseToRequestToConnectInboxPK
     * @param username the username of the XurmoResponseToRequestToConnectInboxPK
     */
    public XurmoResponseToRequestToConnectInbox(String source, String username, String msg) {
        this.xurmoResponseToRequestToConnectInboxPK = new XurmoResponseToRequestToConnectInboxPK(source, username);
        this.msg = msg;
    }

    /**
     * Gets the xurmoResponseToRequestToConnectInboxPK of this XurmoResponseToRequestToConnectInbox.
     * @return the xurmoResponseToRequestToConnectInboxPK
     */
    public XurmoResponseToRequestToConnectInboxPK getXurmoResponseToRequestToConnectInboxPK() {
        return this.xurmoResponseToRequestToConnectInboxPK;
    }

    /**
     * Sets the xurmoResponseToRequestToConnectInboxPK of this XurmoResponseToRequestToConnectInbox to the specified value.
     * @param xurmoResponseToRequestToConnectInboxPK the new xurmoResponseToRequestToConnectInboxPK
     */
    public void setXurmoResponseToRequestToConnectInboxPK(XurmoResponseToRequestToConnectInboxPK xurmoResponseToRequestToConnectInboxPK) {
        this.xurmoResponseToRequestToConnectInboxPK = xurmoResponseToRequestToConnectInboxPK;
    }

    /**
     * Gets the msg of this XurmoResponseToRequestToConnectInbox.
     * @return the msg
     */
    public String getMsg() {
        return this.msg;
    }

    /**
     * Sets the msg of this XurmoResponseToRequestToConnectInbox to the specified value.
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
        hash += (this.xurmoResponseToRequestToConnectInboxPK != null ? this.xurmoResponseToRequestToConnectInboxPK.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoResponseToRequestToConnectInbox.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoResponseToRequestToConnectInbox object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoResponseToRequestToConnectInbox)) {
            return false;
        }
        XurmoResponseToRequestToConnectInbox other = (XurmoResponseToRequestToConnectInbox)object;
        if (this.xurmoResponseToRequestToConnectInboxPK != other.xurmoResponseToRequestToConnectInboxPK && (this.xurmoResponseToRequestToConnectInboxPK == null || !this.xurmoResponseToRequestToConnectInboxPK.equals(other.xurmoResponseToRequestToConnectInboxPK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoResponseToRequestToConnectInbox[xurmoResponseToRequestToConnectInboxPK=" + xurmoResponseToRequestToConnectInboxPK + "]";
    }
    
}
