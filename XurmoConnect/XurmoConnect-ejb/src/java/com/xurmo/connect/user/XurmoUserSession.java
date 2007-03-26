/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserSession.java
 * Created on               : March 26, 2007, 7:40 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class XurmoUserSession
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoUserSession")
@NamedQueries( {
        @NamedQuery(name = "XurmoUserSession.findByUsername", query = "SELECT x FROM XurmoUserSession x WHERE x.username_ = :username"),
        @NamedQuery(name = "XurmoUserSession.findByCookie", query = "SELECT x FROM XurmoUserSession x WHERE x.cookie_ = :cookie"),
        @NamedQuery(name = "XurmoUserSession.findByLastUpdateTime", query = "SELECT x FROM XurmoUserSession x WHERE x.lastUpdateTime_ = :lastUpdateTime")
    })
public class XurmoUserSession implements Serializable {

    @Id
    @Column(name = "username", nullable = false)
    private String username_;

    @Column(name = "cookie", nullable = false)
    private String cookie_;

    @Column(name = "lastUpdateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime_;
    
    /** Creates a new instance of XurmoUserSession */
    public XurmoUserSession() {
    }

    /**
     * Creates a new instance of XurmoUserSession with the specified values.
     * @param username the username of the XurmoUserSession
     */
    public XurmoUserSession(String username) {
        username_ = username;
    }

    /**
     * Creates a new instance of XurmoUserSession with the specified values.
     * @param username the username of the XurmoUserSession
     * @param cookie the cookie of the XurmoUserSession
     */
    public XurmoUserSession(String username, String cookie) {
        username_ = username;
        cookie_ = cookie;
    }

    /**
     * Gets the username of this XurmoUserSession.
     * @return the username
     */
    public String getUsername() {
        return username_;
    }

    /**
     * Sets the username of this XurmoUserSession to the specified value.
     * @param username the new username
     */
    public void setUsername(String username) {
        username_ = username;
    }

    /**
     * Gets the cookie of this XurmoUserSession.
     * @return the cookie
     */
    public String getCookie() {
        return cookie_;
    }

    /**
     * Sets the cookie of this XurmoUserSession to the specified value.
     * @param cookie the new cookie
     */
    public void setCookie(String cookie) {
        cookie_ = cookie;
    }

    /**
     * Gets the lastUpdateTime of this XurmoUserSession.
     * @return the lastUpdateTime
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime_;
    }

    /**
     * Sets the lastUpdateTime of this XurmoUserSession to the specified value.
     * @param lastUpdateTime the new lastUpdateTime
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        lastUpdateTime_ = lastUpdateTime;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username_ != null ? username_.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoUserSession.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoUserSession object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoUserSession)) {
            return false;
        }
        XurmoUserSession other = (XurmoUserSession)object;
        if (username_ != other.username_ && (username_ == null || !username_.equals(other.username_))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoUserSession[username=" + username_ + "]";
    }
    
}
