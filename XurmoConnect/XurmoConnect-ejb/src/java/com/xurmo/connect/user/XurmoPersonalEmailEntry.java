/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPersonalEmailEntry.java
 * Created on               : March 28, 2007, 11:22 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class XurmoPersonalEmailEntry
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoPersonalEmailEntry")
@NamedQueries( {
        @NamedQuery(name = "XurmoPersonalEmailEntry.findByUsername", query = "SELECT x FROM XurmoPersonalEmailEntry x WHERE x.username = :username"),
        @NamedQuery(name = "XurmoPersonalEmailEntry.findByEmail", query = "SELECT x FROM XurmoPersonalEmailEntry x WHERE x.email = :email")
    })
public class XurmoPersonalEmailEntry implements Serializable {

    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email")
    private String email;
    
    /** Creates a new instance of XurmoPersonalEmailEntry */
    public XurmoPersonalEmailEntry() {
    }

    /**
     * Creates a new instance of XurmoPersonalEmailEntry with the specified values.
     * @param username the username of the XurmoPersonalEmailEntry
     */
    public XurmoPersonalEmailEntry(String username) {
        this.username = username;
    }

    /**
     * Creates a new instance of XurmoPersonalEmailEntry with the specified values.
     * @param username the username of the XurmoPersonalEmailEntry
     */
    public XurmoPersonalEmailEntry(String username, String email) {
        this.username = username;
        this.email = email;
    }
    /**
     * Gets the username of this XurmoPersonalEmailEntry.
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the username of this XurmoPersonalEmailEntry to the specified value.
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the email of this XurmoPersonalEmailEntry.
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of this XurmoPersonalEmailEntry to the specified value.
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.username != null ? this.username.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoPersonalEmailEntry.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoPersonalEmailEntry object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoPersonalEmailEntry)) {
            return false;
        }
        XurmoPersonalEmailEntry other = (XurmoPersonalEmailEntry)object;
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
        return "com.xurmo.connect.user.XurmoPersonalEmailEntry[username=" + username + "]";
    }
    
}
