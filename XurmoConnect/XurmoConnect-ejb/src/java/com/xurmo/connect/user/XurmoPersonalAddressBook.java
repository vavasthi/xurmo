/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPersonalAddressBook.java
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
 * Entity class XurmoPersonalAddressBook
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoPersonalAddressBook")
@NamedQueries( {
        @NamedQuery(name = "XurmoPersonalAddressBook.findByUsername", query = "SELECT x FROM XurmoPersonalAddressBook x WHERE x.username = :username"),
        @NamedQuery(name = "XurmoPersonalAddressBook.findByFullName", query = "SELECT x FROM XurmoPersonalAddressBook x WHERE x.fullName = :fullName")
    })
public class XurmoPersonalAddressBook implements Serializable {

    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "fullName", nullable = false)
    private String fullName;
    
    /** Creates a new instance of XurmoPersonalAddressBook */
    public XurmoPersonalAddressBook() {
    }

    /**
     * Creates a new instance of XurmoPersonalAddressBook with the specified values.
     * @param username the username of the XurmoPersonalAddressBook
     */
    public XurmoPersonalAddressBook(String username) {
        this.username = username;
    }

    /**
     * Creates a new instance of XurmoPersonalAddressBook with the specified values.
     * @param username the username of the XurmoPersonalAddressBook
     * @param fullName the fullName of the XurmoPersonalAddressBook
     */
    public XurmoPersonalAddressBook(String username, String fullName) {
        this.username = username;
        this.fullName = fullName;
    }

    /**
     * Gets the username of this XurmoPersonalAddressBook.
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the username of this XurmoPersonalAddressBook to the specified value.
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the fullName of this XurmoPersonalAddressBook.
     * @return the fullName
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * Sets the fullName of this XurmoPersonalAddressBook to the specified value.
     * @param fullName the new fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
     * Determines whether another object is equal to this XurmoPersonalAddressBook.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoPersonalAddressBook object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoPersonalAddressBook)) {
            return false;
        }
        XurmoPersonalAddressBook other = (XurmoPersonalAddressBook)object;
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
        return "com.xurmo.connect.user.XurmoPersonalAddressBook[username=" + username + "]";
    }
    
}
