/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoMessageForALocation.java
 * Created on               : March 31, 2007, 8:59 PM
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
 * Entity class XurmoMessageForALocation
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoMessageForALocation")
@NamedQueries( {
        @NamedQuery(name = "XurmoMessageForALocation.findBySourceDestinationId", query = "SELECT x FROM XurmoMessageForALocation x WHERE x.sourceDestinationId = :sourceDestinationId"),
        @NamedQuery(name = "XurmoMessageForALocation.findByMsg", query = "SELECT x FROM XurmoMessageForALocation x WHERE x.msg = :msg")
    })
public class XurmoMessageForALocation implements Serializable {

    @Id
    @Column(name = "sourceDestinationId", nullable = false)
    private Integer sourceDestinationId;

    @Column(name = "msg")
    private String msg;
    
    /** Creates a new instance of XurmoMessageForALocation */
    public XurmoMessageForALocation() {
    }

    /**
     * Creates a new instance of XurmoMessageForALocation with the specified values.
     * @param sourceDestinationId the sourceDestinationId of the XurmoMessageForALocation
     */
    public XurmoMessageForALocation(Integer sourceDestinationId) {
        this.sourceDestinationId = sourceDestinationId;
    }

    /**
     * Creates a new instance of XurmoMessageForALocation with the specified values.
     * @param sourceDestinationId the sourceDestinationId of the XurmoMessageForALocation
     */
    public XurmoMessageForALocation(Integer sourceDestinationId, String msg) {
        this.sourceDestinationId = sourceDestinationId;
        this.msg = msg;
    }

    /**
     * Gets the sourceDestinationId of this XurmoMessageForALocation.
     * @return the sourceDestinationId
     */
    public Integer getSourceDestinationId() {
        return this.sourceDestinationId;
    }

    /**
     * Sets the sourceDestinationId of this XurmoMessageForALocation to the specified value.
     * @param sourceDestinationId the new sourceDestinationId
     */
    public void setSourceDestinationId(Integer sourceDestinationId) {
        this.sourceDestinationId = sourceDestinationId;
    }

    /**
     * Gets the msg of this XurmoMessageForALocation.
     * @return the msg
     */
    public String getMsg() {
        return this.msg;
    }

    /**
     * Sets the msg of this XurmoMessageForALocation to the specified value.
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
        hash += (this.sourceDestinationId != null ? this.sourceDestinationId.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoMessageForALocation.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoMessageForALocation object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoMessageForALocation)) {
            return false;
        }
        XurmoMessageForALocation other = (XurmoMessageForALocation)object;
        if (this.sourceDestinationId != other.sourceDestinationId && (this.sourceDestinationId == null || !this.sourceDestinationId.equals(other.sourceDestinationId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoMessageForALocation[sourceDestinationId=" + sourceDestinationId + "]";
    }
    
}
