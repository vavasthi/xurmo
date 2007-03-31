/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoCellLocationMap.java
 * Created on               : March 31, 2007, 8:23 PM
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
 * Entity class XurmoCellLocationMap
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoCellLocationMap")
@NamedQueries( {
        @NamedQuery(name = "XurmoCellLocationMap.findByMobileCountryCode", query = "SELECT x FROM XurmoCellLocationMap x WHERE x.mobileCountryCode = :mobileCountryCode"),
        @NamedQuery(name = "XurmoCellLocationMap.findByMobileNetworkCode", query = "SELECT x FROM XurmoCellLocationMap x WHERE x.mobileNetworkCode = :mobileNetworkCode"),
        @NamedQuery(name = "XurmoCellLocationMap.findBySiteId", query = "SELECT x FROM XurmoCellLocationMap x WHERE x.siteId = :siteId"),
        @NamedQuery(name = "XurmoCellLocationMap.findByCellId", query = "SELECT x FROM XurmoCellLocationMap x WHERE x.cellId = :cellId"),
        @NamedQuery(name = "XurmoCellLocationMap.findByAllIds", query = "SELECT x FROM XurmoCellLocationMap x WHERE x.mobileCountryCode = :mobileCountryCode and x.mobileNetworkCode = :mobileNetworkCode and x.siteId = :siteId and x.cellId = :cellId"),
        @NamedQuery(name = "XurmoCellLocationMap.findByLocationId", query = "SELECT x FROM XurmoCellLocationMap x WHERE x.locationId = :locationId"),
        @NamedQuery(name = "XurmoCellLocationMap.findByLocation", query = "SELECT x FROM XurmoCellLocationMap x WHERE x.location = :location")
    })
public class XurmoCellLocationMap implements Serializable {

    @Column(name = "mobileCountryCode", nullable = false)
    private String mobileCountryCode;

    @Column(name = "mobileNetworkCode", nullable = false)
    private String mobileNetworkCode;

    @Column(name = "siteId", nullable = false)
    private String siteId;

    @Column(name = "cellId", nullable = false)
    private String cellId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "locationId", nullable = false)
    private Integer locationId;

    @Column(name = "location", nullable = false)
    private String location;
    
    /** Creates a new instance of XurmoCellLocationMap */
    public XurmoCellLocationMap() {
    }

    /**
     * Creates a new instance of XurmoCellLocationMap with the specified values.
     * @param locationId the locationId of the XurmoCellLocationMap
     * @param mobileCountryCode the mobileCountryCode of the XurmoCellLocationMap
     * @param mobileNetworkCode the mobileNetworkCode of the XurmoCellLocationMap
     * @param siteId the siteId of the XurmoCellLocationMap
     * @param cellId the cellId of the XurmoCellLocationMap
     * @param location the location of the XurmoCellLocationMap
     */
    public XurmoCellLocationMap(String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String location) {
        this.locationId = locationId;
        this.mobileCountryCode = mobileCountryCode;
        this.mobileNetworkCode = mobileNetworkCode;
        this.siteId = siteId;
        this.cellId = cellId;
        this.location = location;
    }

    /**
     * Gets the mobileCountryCode of this XurmoCellLocationMap.
     * @return the mobileCountryCode
     */
    public String getMobileCountryCode() {
        return this.mobileCountryCode;
    }

    /**
     * Sets the mobileCountryCode of this XurmoCellLocationMap to the specified value.
     * @param mobileCountryCode the new mobileCountryCode
     */
    public void setMobileCountryCode(String mobileCountryCode) {
        this.mobileCountryCode = mobileCountryCode;
    }

    /**
     * Gets the mobileNetworkCode of this XurmoCellLocationMap.
     * @return the mobileNetworkCode
     */
    public String getMobileNetworkCode() {
        return this.mobileNetworkCode;
    }

    /**
     * Sets the mobileNetworkCode of this XurmoCellLocationMap to the specified value.
     * @param mobileNetworkCode the new mobileNetworkCode
     */
    public void setMobileNetworkCode(String mobileNetworkCode) {
        this.mobileNetworkCode = mobileNetworkCode;
    }

    /**
     * Gets the siteId of this XurmoCellLocationMap.
     * @return the siteId
     */
    public String getSiteId() {
        return this.siteId;
    }

    /**
     * Sets the siteId of this XurmoCellLocationMap to the specified value.
     * @param siteId the new siteId
     */
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    /**
     * Gets the cellId of this XurmoCellLocationMap.
     * @return the cellId
     */
    public String getCellId() {
        return this.cellId;
    }

    /**
     * Sets the cellId of this XurmoCellLocationMap to the specified value.
     * @param cellId the new cellId
     */
    public void setCellId(String cellId) {
        this.cellId = cellId;
    }

    /**
     * Gets the locationId of this XurmoCellLocationMap.
     * @return the locationId
     */
    public Integer getLocationId() {
        return this.locationId;
    }

    /**
     * Sets the locationId of this XurmoCellLocationMap to the specified value.
     * @param locationId the new locationId
     */
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    /**
     * Gets the location of this XurmoCellLocationMap.
     * @return the location
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Sets the location of this XurmoCellLocationMap to the specified value.
     * @param location the new location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.locationId != null ? this.locationId.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoCellLocationMap.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoCellLocationMap object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoCellLocationMap)) {
            return false;
        }
        XurmoCellLocationMap other = (XurmoCellLocationMap)object;
        if (this.locationId != other.locationId && (this.locationId == null || !this.locationId.equals(other.locationId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoCellLocationMap[locationId=" + locationId + "]";
    }
    
}
