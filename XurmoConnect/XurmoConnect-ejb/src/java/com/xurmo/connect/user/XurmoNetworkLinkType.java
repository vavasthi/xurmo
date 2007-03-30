/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoNetworkLinkType.java
 * Created on               : March 30, 2007, 8:53 PM
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
 * Entity class XurmoNetworkLinkType
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoNetworkLinkType")
@NamedQueries( {
        @NamedQuery(name = "XurmoNetworkLinkType.findByLinkId", query = "SELECT x FROM XurmoNetworkLinkType x WHERE x.linkId = :linkId"),
        @NamedQuery(name = "XurmoNetworkLinkType.findByLinkName", query = "SELECT x FROM XurmoNetworkLinkType x WHERE x.linkName = :linkName"),
        @NamedQuery(name = "XurmoNetworkLinkType.findAll", query = "SELECT x FROM XurmoNetworkLinkType x")
    })
public class XurmoNetworkLinkType implements Serializable {

    @Id
    @Column(name = "linkId", nullable = false)
    private Integer linkId;

    @Column(name = "linkName", nullable = false)
    private String linkName;
    
    /** Creates a new instance of XurmoNetworkLinkType */
    public XurmoNetworkLinkType() {
    }

    /**
     * Creates a new instance of XurmoNetworkLinkType with the specified values.
     * @param linkId the linkId of the XurmoNetworkLinkType
     */
    public XurmoNetworkLinkType(Integer linkId) {
        this.linkId = linkId;
    }

    /**
     * Creates a new instance of XurmoNetworkLinkType with the specified values.
     * @param linkId the linkId of the XurmoNetworkLinkType
     * @param linkName the linkName of the XurmoNetworkLinkType
     */
    public XurmoNetworkLinkType(Integer linkId, String linkName) {
        this.linkId = linkId;
        this.linkName = linkName;
    }

    /**
     * Gets the linkId of this XurmoNetworkLinkType.
     * @return the linkId
     */
    public Integer getLinkId() {
        return this.linkId;
    }

    /**
     * Sets the linkId of this XurmoNetworkLinkType to the specified value.
     * @param linkId the new linkId
     */
    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    /**
     * Gets the linkName of this XurmoNetworkLinkType.
     * @return the linkName
     */
    public String getLinkName() {
        return this.linkName;
    }

    /**
     * Sets the linkName of this XurmoNetworkLinkType to the specified value.
     * @param linkName the new linkName
     */
    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.linkId != null ? this.linkId.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoNetworkLinkType.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoNetworkLinkType object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoNetworkLinkType)) {
            return false;
        }
        XurmoNetworkLinkType other = (XurmoNetworkLinkType)object;
        if (this.linkId != other.linkId && (this.linkId == null || !this.linkId.equals(other.linkId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoNetworkLinkType[linkId=" + linkId + "]";
    }
    
}
