/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoCellLocationMap.java
 * Created on               : March 27, 2007, 8:47 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
        @NamedQuery(name = "XurmoCellLocationMap.findByMobileCountryCode", query = "SELECT x FROM XurmoCellLocationMap x WHERE x.xurmoCellLocationMapPK.mobileCountryCode = :mobileCountryCode"),
        @NamedQuery(name = "XurmoCellLocationMap.findByMobileNetworkCode", query = "SELECT x FROM XurmoCellLocationMap x WHERE x.xurmoCellLocationMapPK.mobileNetworkCode = :mobileNetworkCode"),
        @NamedQuery(name = "XurmoCellLocationMap.findBySiteId", query = "SELECT x FROM XurmoCellLocationMap x WHERE x.xurmoCellLocationMapPK.siteId = :siteId"),
        @NamedQuery(name = "XurmoCellLocationMap.findByCellId", query = "SELECT x FROM XurmoCellLocationMap x WHERE x.xurmoCellLocationMapPK.cellId = :cellId"),
        @NamedQuery(name = "XurmoCellLocationMap.findByLocation", query = "SELECT x FROM XurmoCellLocationMap x WHERE x.location = :location"),
        @NamedQuery(name = "XurmoCellLocationMap.findByCellInfo", query = "SELECT x FROM XurmoCellLocationMap x WHERE x.xurmoCellLocationMapPK.mobileCountryCode = :mobileCountryCode and x.xurmoCellLocationMapPK.mobileNetworkCode = :mobileNetworkCode and x.xurmoCellLocationMapPK.siteId = :siteId and x.xurmoCellLocationMapPK.cellId = :cellId")
    })
public class XurmoCellLocationMap implements Serializable {

    /**
     * EmbeddedId primary key field
     */
    @EmbeddedId
    protected XurmoCellLocationMapPK xurmoCellLocationMapPK;

    @Column(name = "location", nullable = false)
    private String location;
    
    /** Creates a new instance of XurmoCellLocationMap */
    public XurmoCellLocationMap() {
    }

    /**
     * Creates a new instance of XurmoCellLocationMap with the specified values.
     * @param xurmoCellLocationMapPK the xurmoCellLocationMapPK of the XurmoCellLocationMap
     */
    public XurmoCellLocationMap(XurmoCellLocationMapPK xurmoCellLocationMapPK) {
        this.xurmoCellLocationMapPK = xurmoCellLocationMapPK;
    }

    /**
     * Creates a new instance of XurmoCellLocationMap with the specified values.
     * @param xurmoCellLocationMapPK the xurmoCellLocationMapPK of the XurmoCellLocationMap
     * @param location the location of the XurmoCellLocationMap
     */
    public XurmoCellLocationMap(XurmoCellLocationMapPK xurmoCellLocationMapPK, String location) {
        this.xurmoCellLocationMapPK = xurmoCellLocationMapPK;
        this.location = location;
    }

    /**
     * Creates a new instance of XurmoCellLocationMapPK with the specified values.
     * @param cellId the cellId of the XurmoCellLocationMapPK
     * @param siteId the siteId of the XurmoCellLocationMapPK
     * @param mobileNetworkCode the mobileNetworkCode of the XurmoCellLocationMapPK
     * @param mobileCountryCode the mobileCountryCode of the XurmoCellLocationMapPK
     */
    public XurmoCellLocationMap(String cellId, String siteId, String mobileNetworkCode, String mobileCountryCode) {
        this.xurmoCellLocationMapPK = new XurmoCellLocationMapPK(cellId, siteId, mobileNetworkCode, mobileCountryCode);
    }
    /**
     * Creates a new instance of XurmoCellLocationMapPK with the specified values.
     * @param cellId the cellId of the XurmoCellLocationMapPK
     * @param siteId the siteId of the XurmoCellLocationMapPK
     * @param mobileNetworkCode the mobileNetworkCode of the XurmoCellLocationMapPK
     * @param mobileCountryCode the mobileCountryCode of the XurmoCellLocationMapPK
     * @param location the location of this particular cell
     */
    public XurmoCellLocationMap(String cellId, String siteId, String mobileNetworkCode, String mobileCountryCode, String location) {
        this.xurmoCellLocationMapPK = new XurmoCellLocationMapPK(cellId, siteId, mobileNetworkCode, mobileCountryCode);
        this.location = location;
    }

    /**
     * Gets the xurmoCellLocationMapPK of this XurmoCellLocationMap.
     * @return the xurmoCellLocationMapPK
     */
    public XurmoCellLocationMapPK getXurmoCellLocationMapPK() {
        return this.xurmoCellLocationMapPK;
    }

    /**
     * Sets the xurmoCellLocationMapPK of this XurmoCellLocationMap to the specified value.
     * @param xurmoCellLocationMapPK the new xurmoCellLocationMapPK
     */
    public void setXurmoCellLocationMapPK(XurmoCellLocationMapPK xurmoCellLocationMapPK) {
        this.xurmoCellLocationMapPK = xurmoCellLocationMapPK;
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
        hash += (this.xurmoCellLocationMapPK != null ? this.xurmoCellLocationMapPK.hashCode() : 0);
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
        if (this.xurmoCellLocationMapPK != other.xurmoCellLocationMapPK && (this.xurmoCellLocationMapPK == null || !this.xurmoCellLocationMapPK.equals(other.xurmoCellLocationMapPK))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoCellLocationMap[xurmoCellLocationMapPK=" + xurmoCellLocationMapPK + "]";
    }
    
}
