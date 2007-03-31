/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoMessagesForALocationSourceDestinationPair.java
 * Created on               : March 31, 2007, 8:52 PM
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
 * Entity class XurmoMessagesForALocationSourceDestinationPair
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoMessagesForALocationSourceDestinationPair")
@NamedQueries( {
        @NamedQuery(name = "XurmoMessagesForALocationSourceDestinationPair.findByLocationId", query = "SELECT x FROM XurmoMessagesForALocationSourceDestinationPair x WHERE x.locationId = :locationId"),
        @NamedQuery(name = "XurmoMessagesForALocationSourceDestinationPair.findBySourceId", query = "SELECT x FROM XurmoMessagesForALocationSourceDestinationPair x WHERE x.sourceId = :sourceId"),
        @NamedQuery(name = "XurmoMessagesForALocationSourceDestinationPair.findByDestinationId", query = "SELECT x FROM XurmoMessagesForALocationSourceDestinationPair x WHERE x.destinationId = :destinationId"),
        @NamedQuery(name = "XurmoMessagesForALocationSourceDestinationPair.findByLocationIdAndDestinationId", query = "SELECT x FROM XurmoMessagesForALocationSourceDestinationPair x WHERE x.locationId = :locationId and x.destinationId = :destinationId"),
        @NamedQuery(name = "XurmoMessagesForALocationSourceDestinationPair.findByAllIds", query = "SELECT x FROM XurmoMessagesForALocationSourceDestinationPair x WHERE x.locationId = :locationId and x.sourceId = :sourceId and x.destinationId = :destinationId"),
        @NamedQuery(name = "XurmoMessagesForALocationSourceDestinationPair.findBySourceDestinationId", query = "SELECT x FROM XurmoMessagesForALocationSourceDestinationPair x WHERE x.sourceDestinationId = :sourceDestinationId")
    })
    

public class XurmoMessagesForALocationSourceDestinationPair implements Serializable {

    @Column(name = "locationId", nullable = false)
    private int locationId;

    @Column(name = "sourceId", nullable = false)
    private String sourceId;

    @Column(name = "destinationId", nullable = false)
    private String destinationId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sourceDestinationId", nullable = false)
    private Integer sourceDestinationId;
    
    /** Creates a new instance of XurmoMessagesForALocationSourceDestinationPair */
    public XurmoMessagesForALocationSourceDestinationPair() {
    }

    /**
     * Creates a new instance of XurmoMessagesForALocationSourceDestinationPair with the specified values.
     * @param sourceDestinationId the sourceDestinationId of the XurmoMessagesForALocationSourceDestinationPair
     * @param locationId the locationId of the XurmoMessagesForALocationSourceDestinationPair
     * @param sourceId the sourceId of the XurmoMessagesForALocationSourceDestinationPair
     * @param destinationId the destinationId of the XurmoMessagesForALocationSourceDestinationPair
     */
    public XurmoMessagesForALocationSourceDestinationPair(int locationId, String sourceId, String destinationId) {
        this.locationId = locationId;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
    }

    /**
     * Gets the locationId of this XurmoMessagesForALocationSourceDestinationPair.
     * @return the locationId
     */
    public int getLocationId() {
        return this.locationId;
    }

    /**
     * Sets the locationId of this XurmoMessagesForALocationSourceDestinationPair to the specified value.
     * @param locationId the new locationId
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    /**
     * Gets the sourceId of this XurmoMessagesForALocationSourceDestinationPair.
     * @return the sourceId
     */
    public String getSourceId() {
        return this.sourceId;
    }

    /**
     * Sets the sourceId of this XurmoMessagesForALocationSourceDestinationPair to the specified value.
     * @param sourceId the new sourceId
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * Gets the destinationId of this XurmoMessagesForALocationSourceDestinationPair.
     * @return the destinationId
     */
    public String getDestinationId() {
        return this.destinationId;
    }

    /**
     * Sets the destinationId of this XurmoMessagesForALocationSourceDestinationPair to the specified value.
     * @param destinationId the new destinationId
     */
    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    /**
     * Gets the sourceDestinationId of this XurmoMessagesForALocationSourceDestinationPair.
     * @return the sourceDestinationId
     */
    public Integer getSourceDestinationId() {
        return this.sourceDestinationId;
    }

    /**
     * Sets the sourceDestinationId of this XurmoMessagesForALocationSourceDestinationPair to the specified value.
     * @param sourceDestinationId the new sourceDestinationId
     */
    public void setSourceDestinationId(Integer sourceDestinationId) {
        this.sourceDestinationId = sourceDestinationId;
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
     * Determines whether another object is equal to this XurmoMessagesForALocationSourceDestinationPair.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoMessagesForALocationSourceDestinationPair object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoMessagesForALocationSourceDestinationPair)) {
            return false;
        }
        XurmoMessagesForALocationSourceDestinationPair other = (XurmoMessagesForALocationSourceDestinationPair)object;
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
        return "com.xurmo.connect.user.XurmoMessagesForALocationSourceDestinationPair[sourceDestinationId=" + sourceDestinationId + "]";
    }
    
}
