/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoErrors.java
 * Created on               : May 4, 2007, 9:56 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class XurmoErrors
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoErrors")
@NamedQueries( {
        @NamedQuery(name = "XurmoErrors.findByError", query = "SELECT x FROM XurmoErrors x WHERE x.error = :error"),
        @NamedQuery(name = "XurmoErrors.findByErrorStr", query = "SELECT x FROM XurmoErrors x WHERE x.errorStr = :errorStr"),
        @NamedQuery(name = "XurmoErrors.findByErrorMsg", query = "SELECT x FROM XurmoErrors x WHERE x.errorMsg = :errorMsg"),
        @NamedQuery(name = "XurmoErrors.findAll", query = "SELECT x FROM XurmoErrors x")
    })
public class XurmoErrors implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "error", nullable = false)
    private Integer error;

    @Column(name = "errorStr")
    private String errorStr;

    @Column(name = "errorMsg")
    private String errorMsg;
    
    /** Creates a new instance of XurmoErrors */
    public XurmoErrors() {
    }

    /**
     * Creates a new instance of XurmoErrors with the specified values.
     * @param error the error of the XurmoErrors
     */
    public XurmoErrors(Integer error) {
        this.error = error;
    }

    /**
     * Gets the error of this XurmoErrors.
     * @return the error
     */
    public Integer getError() {
        return this.error;
    }

    /**
     * Sets the error of this XurmoErrors to the specified value.
     * @param error the new error
     */
    public void setError(Integer error) {
        this.error = error;
    }

    /**
     * Gets the errorStr of this XurmoErrors.
     * @return the errorStr
     */
    public String getErrorStr() {
        return this.errorStr;
    }

    /**
     * Sets the errorStr of this XurmoErrors to the specified value.
     * @param errorStr the new errorStr
     */
    public void setErrorStr(String errorStr) {
        this.errorStr = errorStr;
    }

    /**
     * Gets the errorMsg of this XurmoErrors.
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return this.errorMsg;
    }

    /**
     * Sets the errorMsg of this XurmoErrors to the specified value.
     * @param errorMsg the new errorMsg
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.error != null ? this.error.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoErrors.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoErrors object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoErrors)) {
            return false;
        }
        XurmoErrors other = (XurmoErrors)object;
        if (this.error != other.error && (this.error == null || !this.error.equals(other.error))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoErrors[error=" + error + "]";
    }
    
}
