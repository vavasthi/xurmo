/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUser.java
 * Created on               : August 28, 2007, 10:20 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity class XurmoUser
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoUser")
@NamedQueries( {
        @NamedQuery(name = "XurmoUser.findByUserid", query = "SELECT x FROM XurmoUser x WHERE x.userid = :userid"),
        @NamedQuery(name = "XurmoUser.findByUsername", query = "SELECT x FROM XurmoUser x WHERE x.username = :username"),
        @NamedQuery(name = "XurmoUser.findBySalutation", query = "SELECT x FROM XurmoUser x WHERE x.salutation = :salutation"),
        @NamedQuery(name = "XurmoUser.findByFname", query = "SELECT x FROM XurmoUser x WHERE x.fname = :fname"),
        @NamedQuery(name = "XurmoUser.findByLname", query = "SELECT x FROM XurmoUser x WHERE x.lname = :lname"),
        @NamedQuery(name = "XurmoUser.findByPrimaryMobile", query = "SELECT x FROM XurmoUser x WHERE x.primaryMobile = :primaryMobile"),
        @NamedQuery(name = "XurmoUser.findByPrimaryMobileValidated", query = "SELECT x FROM XurmoUser x WHERE x.primaryMobileValidated = :primaryMobileValidated"),
        @NamedQuery(name = "XurmoUser.findByPrimaryEmail", query = "SELECT x FROM XurmoUser x WHERE x.primaryEmail = :primaryEmail"),
        @NamedQuery(name = "XurmoUser.findByPrimaryEmailValidated", query = "SELECT x FROM XurmoUser x WHERE x.primaryEmailValidated = :primaryEmailValidated"),
        @NamedQuery(name = "XurmoUser.findByGender", query = "SELECT x FROM XurmoUser x WHERE x.gender = :gender"),
        @NamedQuery(name = "XurmoUser.findByDob", query = "SELECT x FROM XurmoUser x WHERE x.dob = :dob"),
        @NamedQuery(name = "XurmoUser.findByImei", query = "SELECT x FROM XurmoUser x WHERE x.imei = :imei"),
        @NamedQuery(name = "XurmoUser.findByBtAddress", query = "SELECT x FROM XurmoUser x WHERE x.btAddress = :btAddress")
    })
public class XurmoUser implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid", nullable = false)
    private int userid;

    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Lob
    @Column(name = "password", nullable = false)
    private byte [] password;

    @Column(name = "salutation", nullable = false)
    private String salutation;

    @Column(name = "fname", nullable = false)
    private String fname;

    @Column(name = "lname", nullable = false)
    private String lname;

    @Column(name = "primaryMobile", nullable = false)
    private String primaryMobile;

    @Column(name = "primaryMobileValidated", nullable = false)
    private boolean primaryMobileValidated;

    @Column(name = "primaryEmail", nullable = false)
    private String primaryEmail;

    @Column(name = "primaryEmailValidated", nullable = false)
    private boolean primaryEmailValidated;

    @Column(name = "gender")
    private Character gender;

    @Column(name = "dob", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @Column(name = "imei", nullable = false)
    private String imei;

    @Column(name = "btAddress", nullable = false)
    private String btAddress;
    
    /** Creates a new instance of XurmoUser */
    public XurmoUser() {
    }

    /**
     * Creates a new instance of XurmoUser with the specified values.
     * @param username the username of the XurmoUser
     */
    public XurmoUser(String username) {
        this.username = username;
    }

    /**
     * Creates a new instance of XurmoUser with the specified values.
     * @param username the username of the XurmoUser
     * @param userid the userid of the XurmoUser
     * @param password the password of the XurmoUser
     * @param salutation the salutation of the XurmoUser
     * @param fname the fname of the XurmoUser
     * @param lname the lname of the XurmoUser
     * @param primaryMobile the primaryMobile of the XurmoUser
     * @param primaryMobileValidated the primaryMobileValidated of the XurmoUser
     * @param primaryEmail the primaryEmail of the XurmoUser
     * @param primaryEmailValidated the primaryEmailValidated of the XurmoUser
     * @param dob the dob of the XurmoUser
     * @param imei the imei of the XurmoUser
     * @param btAddress the btAddress of the XurmoUser
     */
    public XurmoUser(String username, byte [] password, String salutation, String fname, String lname, String primaryMobile, boolean primaryMobileValidated, String primaryEmail, boolean primaryEmailValidated, String gender, Date dob, String imei, String btAddress) {
        this.username = username;
        this.password = password;
        this.salutation = salutation;
        this.fname = fname;
        this.lname = lname;
        this.primaryMobile = primaryMobile;
        this.primaryMobileValidated = primaryMobileValidated;
        this.primaryEmail = primaryEmail;
        this.primaryEmailValidated = primaryEmailValidated;
        this.gender = gender.charAt(0);
        this.dob = dob;
        this.imei = imei;
        this.btAddress = btAddress;
    }

    /**
     * Gets the userid of this XurmoUser.
     * @return the userid
     */
    public int getUserid() {
        return this.userid;
    }

    /**
     * Sets the userid of this XurmoUser to the specified value.
     * @param userid the new userid
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     * Gets the username of this XurmoUser.
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the username of this XurmoUser to the specified value.
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of this XurmoUser.
     * @return the password
     */
    public byte [] getPassword() {
        return this.password;
    }

    /**
     * Sets the password of this XurmoUser to the specified value.
     * @param password the new password
     */
    public void setPassword(byte [] password) {
        this.password = password;
    }

    /**
     * Gets the salutation of this XurmoUser.
     * @return the salutation
     */
    public String getSalutation() {
        return this.salutation;
    }

    /**
     * Sets the salutation of this XurmoUser to the specified value.
     * @param salutation the new salutation
     */
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    /**
     * Gets the fname of this XurmoUser.
     * @return the fname
     */
    public String getFname() {
        return this.fname;
    }

    /**
     * Sets the fname of this XurmoUser to the specified value.
     * @param fname the new fname
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * Gets the lname of this XurmoUser.
     * @return the lname
     */
    public String getLname() {
        return this.lname;
    }

    /**
     * Sets the lname of this XurmoUser to the specified value.
     * @param lname the new lname
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * Gets the primaryMobile of this XurmoUser.
     * @return the primaryMobile
     */
    public String getPrimaryMobile() {
        return this.primaryMobile;
    }

    /**
     * Sets the primaryMobile of this XurmoUser to the specified value.
     * @param primaryMobile the new primaryMobile
     */
    public void setPrimaryMobile(String primaryMobile) {
        this.primaryMobile = primaryMobile;
    }

    /**
     * Gets the primaryMobileValidated of this XurmoUser.
     * @return the primaryMobileValidated
     */
    public boolean getPrimaryMobileValidated() {
        return this.primaryMobileValidated;
    }

    /**
     * Sets the primaryMobileValidated of this XurmoUser to the specified value.
     * @param primaryMobileValidated the new primaryMobileValidated
     */
    public void setPrimaryMobileValidated(boolean primaryMobileValidated) {
        this.primaryMobileValidated = primaryMobileValidated;
    }

    /**
     * Gets the primaryEmail of this XurmoUser.
     * @return the primaryEmail
     */
    public String getPrimaryEmail() {
        return this.primaryEmail;
    }

    /**
     * Sets the primaryEmail of this XurmoUser to the specified value.
     * @param primaryEmail the new primaryEmail
     */
    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    /**
     * Gets the primaryEmailValidated of this XurmoUser.
     * @return the primaryEmailValidated
     */
    public boolean getPrimaryEmailValidated() {
        return this.primaryEmailValidated;
    }

    /**
     * Sets the primaryEmailValidated of this XurmoUser to the specified value.
     * @param primaryEmailValidated the new primaryEmailValidated
     */
    public void setPrimaryEmailValidated(boolean primaryEmailValidated) {
        this.primaryEmailValidated = primaryEmailValidated;
    }

    /**
     * Gets the gender of this XurmoUser.
     * @return the gender
     */
    public Character getGender() {
        return this.gender;
    }

    /**
     * Sets the gender of this XurmoUser to the specified value.
     * @param gender the new gender
     */
    public void setGender(Character gender) {
        this.gender = gender;
    }

    /**
     * Gets the dob of this XurmoUser.
     * @return the dob
     */
    public Date getDob() {
        return this.dob;
    }

    /**
     * Sets the dob of this XurmoUser to the specified value.
     * @param dob the new dob
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Gets the imei of this XurmoUser.
     * @return the imei
     */
    public String getImei() {
        return this.imei;
    }

    /**
     * Sets the imei of this XurmoUser to the specified value.
     * @param imei the new imei
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     * Gets the btAddress of this XurmoUser.
     * @return the btAddress
     */
    public String getBtAddress() {
        return this.btAddress;
    }

    /**
     * Sets the btAddress of this XurmoUser to the specified value.
     * @param btAddress the new btAddress
     */
    public void setBtAddress(String btAddress) {
        this.btAddress = btAddress;
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
        return "com.xurmo.connect.user.XurmoUser[username=" + username + "]";
    }
    
}
