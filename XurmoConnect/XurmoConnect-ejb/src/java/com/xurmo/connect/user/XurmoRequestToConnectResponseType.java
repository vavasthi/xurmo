/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoRequestToConnectResponseType.java
 * Created on               : March 30, 2007, 10:21 PM
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
 * Entity class XurmoRequestToConnectResponseType
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoRequestToConnectResponseType")
@NamedQueries( {
        @NamedQuery(name = "XurmoRequestToConnectResponseType.findByResponseId", query = "SELECT x FROM XurmoRequestToConnectResponseType x WHERE x.responseId = :responseId"),
        @NamedQuery(name = "XurmoRequestToConnectResponseType.findByResponseLabel", query = "SELECT x FROM XurmoRequestToConnectResponseType x WHERE x.responseLabel = :responseLabel"),
        @NamedQuery(name = "XurmoRequestToConnectResponseType.findAll", query = "SELECT x FROM XurmoRequestToConnectResponseType x")
    })
public class XurmoRequestToConnectResponseType implements Serializable {

    @Id
    @Column(name = "responseId", nullable = false)
    private Integer responseId;

    @Column(name = "responseLabel", nullable = false)
    private String responseLabel;
    
    /** Creates a new instance of XurmoRequestToConnectResponseType */
    public XurmoRequestToConnectResponseType() {
    }

    /**
     * Creates a new instance of XurmoRequestToConnectResponseType with the specified values.
     * @param responseId the responseId of the XurmoRequestToConnectResponseType
     */
    public XurmoRequestToConnectResponseType(Integer responseId) {
        this.responseId = responseId;
    }

    /**
     * Creates a new instance of XurmoRequestToConnectResponseType with the specified values.
     * @param responseId the responseId of the XurmoRequestToConnectResponseType
     * @param responseLabel the responseLabel of the XurmoRequestToConnectResponseType
     */
    public XurmoRequestToConnectResponseType(Integer responseId, String responseLabel) {
        this.responseId = responseId;
        this.responseLabel = responseLabel;
    }

    /**
     * Gets the responseId of this XurmoRequestToConnectResponseType.
     * @return the responseId
     */
    public Integer getResponseId() {
        return this.responseId;
    }

    /**
     * Sets the responseId of this XurmoRequestToConnectResponseType to the specified value.
     * @param responseId the new responseId
     */
    public void setResponseId(Integer responseId) {
        this.responseId = responseId;
    }

    /**
     * Gets the responseLabel of this XurmoRequestToConnectResponseType.
     * @return the responseLabel
     */
    public String getResponseLabel() {
        return this.responseLabel;
    }

    /**
     * Sets the responseLabel of this XurmoRequestToConnectResponseType to the specified value.
     * @param responseLabel the new responseLabel
     */
    public void setResponseLabel(String responseLabel) {
        this.responseLabel = responseLabel;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.responseId != null ? this.responseId.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoRequestToConnectResponseType.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoRequestToConnectResponseType object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoRequestToConnectResponseType)) {
            return false;
        }
        XurmoRequestToConnectResponseType other = (XurmoRequestToConnectResponseType)object;
        if (this.responseId != other.responseId && (this.responseId == null || !this.responseId.equals(other.responseId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoRequestToConnectResponseType[responseId=" + responseId + "]";
    }
    
}
