/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUser.java
 * Created on               : March 26, 2007, 6:52 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class XurmoUser
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoUser")
@NamedQueries( {
        @NamedQuery(name = "XurmoUser.findByUsername", query = "SELECT x FROM XurmoUser x WHERE x.username_ = :username"),
        @NamedQuery(name = "XurmoUser.findByFname", query = "SELECT x FROM XurmoUser x WHERE x.fname_ = :fname"),
        @NamedQuery(name = "XurmoUser.findByLname", query = "SELECT x FROM XurmoUser x WHERE x.lname_ = :lname"),
        @NamedQuery(name = "XurmoUser.findByPrimaryMobile", query = "SELECT x FROM XurmoUser x WHERE x.primaryMobile_ = :primaryMobile"),
        @NamedQuery(name = "XurmoUser.findByPrimaryEmail", query = "SELECT x FROM XurmoUser x WHERE x.primaryEmail_ = :primaryEmail"),
        @NamedQuery(name = "XurmoUser.findByLoggedIn", query = "SELECT x FROM XurmoUser x WHERE x.loggedIn_ = :loggedIn"),
        @NamedQuery(name = "XurmoUser.findByLocation", query = "SELECT x FROM XurmoUser x WHERE x.location_ = :location")
    })
public class XurmoUser implements Serializable {

    @Id
    @Column(name = "username", nullable = false)
    private String username_;

    @Lob
    @Column(name = "password", nullable = false)
    private byte [] password_;

    @Column(name = "fname", nullable = false)
    private String fname_;

    @Column(name = "lname", nullable = false)
    private String lname_;

    @Column(name = "primaryMobile", nullable = false)
    private String primaryMobile_;

    @Column(name = "primaryEmail", nullable = false)
    private String primaryEmail_;

    @Column(name = "loggedIn")
    private Boolean loggedIn_;

    @Column(name = "location")
    private String location_;
    
    /** Creates a new instance of XurmoUser */
    public XurmoUser() {
        loggedIn_  = false;
    }

    /**
     * Creates a new instance of XurmoUser with the specified values.
     * @param username the username of the XurmoUser
     */
    public XurmoUser(String username) {
        username_ = username;
        loggedIn_ = false;
    }

    /**
     * Creates a new instance of XurmoUser with the specified values.
     * @param username the username of the XurmoUser
     * @param password the password of the XurmoUser
     * @param fname the fname of the XurmoUser
     * @param lname the lname of the XurmoUser
     * @param primaryMobile the primaryMobile of the XurmoUser
     * @param primaryEmail the primaryEmail of the XurmoUser
     */
    public XurmoUser(String username, 
            byte [] password, 
            String fname, 
            String lname, 
            String primaryMobile, 
            String primaryEmail) {
        username_ = username;
        password_ = password;
        fname_ = fname;
        lname_ = lname;
        primaryMobile_ = primaryMobile;
        primaryEmail_ = primaryEmail;
    }

    /**
     * Gets the username of this XurmoUser.
     * @return the username
     */
    public String getUsername() {
        return username_;
    }

    /**
     * Sets the username of this XurmoUser to the specified value.
     * @param username the new username
     */
    public void setUsername(String username) {
        username_ = username;
    }

    /**
     * Gets the password of this XurmoUser.
     * @return the password
     */
    public byte [] getPassword() {
        return password_;
    }

    /**
     * Sets the password of this XurmoUser to the specified value.
     * @param password the new password
     */
    public void setPassword(byte [] password) {
        password_ = password;
    }

    /**
     * Gets the fname of this XurmoUser.
     * @return the fname
     */
    public String getFname() {
        return fname_;
    }

    /**
     * Sets the fname of this XurmoUser to the specified value.
     * @param fname the new fname
     */
    public void setFname(String fname) {
       fname_ = fname;
    }

    /**
     * Gets the lname of this XurmoUser.
     * @return the lname
     */
    public String getLname() {
        return lname_;
    }

    /**
     * Sets the lname of this XurmoUser to the specified value.
     * @param lname the new lname
     */
    public void setLname(String lname) {
        lname_ = lname;
    }

    /**
     * Gets the primaryMobile of this XurmoUser.
     * @return the primaryMobile
     */
    public String getPrimaryMobile() {
        return primaryMobile_;
    }

    /**
     * Sets the primaryMobile of this XurmoUser to the specified value.
     * @param primaryMobile the new primaryMobile
     */
    public void setPrimaryMobile(String primaryMobile) {
        primaryMobile_ = primaryMobile;
    }

    /**
     * Gets the primaryEmail of this XurmoUser.
     * @return the primaryEmail
     */
    public String getPrimaryEmail() {
        return primaryEmail_;
    }

    /**
     * Sets the primaryEmail of this XurmoUser to the specified value.
     * @param primaryEmail the new primaryEmail
     */
    public void setPrimaryEmail(String primaryEmail) {
        primaryEmail_ = primaryEmail;
    }

    /**
     * Gets the loggedIn of this XurmoUser.
     * @return the loggedIn
     */
    public Boolean getLoggedIn() {
        return loggedIn_;
    }

    /**
     * Sets the loggedIn of this XurmoUser to the specified value.
     * @param loggedIn the new loggedIn
     */
    public void setLoggedIn(Boolean loggedIn) {
        loggedIn_ = loggedIn;
    }

    /**
     * Gets the location of this XurmoUser.
     * @return the location
     */
    public String getLocation() {
        return location_;
    }

    /**
     * Sets the location of this XurmoUser to the specified value.
     * @param location the new location
     */
    public void setLocation(String location) {
        location_ = location;
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
     * Determines whether another object is equal to this XurmoUser.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoUser object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoUser)) {
            return false;
        }
        XurmoUser other = (XurmoUser)object;
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
        return "com.xurmo.connect.user.XurmoUser[username=" + username_ + "]";
    }
    
}
