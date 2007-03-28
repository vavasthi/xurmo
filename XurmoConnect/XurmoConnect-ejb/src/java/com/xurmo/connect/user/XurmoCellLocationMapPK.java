/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoCellLocationMapPK.java
 * Created on               : March 27, 2007, 8:47 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Primary Key class XurmoCellLocationMapPK for entity class XurmoCellLocationMap
 * 
 * @author xurmo
 */
@Embeddable
public class XurmoCellLocationMapPK implements Serializable {

    @Column(name = "mobileCountryCode", nullable = false)
    private String mobileCountryCode;

    @Column(name = "mobileNetworkCode", nullable = false)
    private String mobileNetworkCode;

    @Column(name = "siteId", nullable = false)
    private String siteId;

    @Column(name = "cellId", nullable = false)
    private String cellId;
    
    /** Creates a new instance of XurmoCellLocationMapPK */
    public XurmoCellLocationMapPK() {
    }

    /**
     * Creates a new instance of XurmoCellLocationMapPK with the specified values.
     * @param cellId the cellId of the XurmoCellLocationMapPK
     * @param siteId the siteId of the XurmoCellLocationMapPK
     * @param mobileNetworkCode the mobileNetworkCode of the XurmoCellLocationMapPK
     * @param mobileCountryCode the mobileCountryCode of the XurmoCellLocationMapPK
     */
    public XurmoCellLocationMapPK(String cellId, String siteId, String mobileNetworkCode, String mobileCountryCode) {
        this.cellId = cellId;
        this.siteId = siteId;
        this.mobileNetworkCode = mobileNetworkCode;
        this.mobileCountryCode = mobileCountryCode;
    }

    /**
     * Gets the mobileCountryCode of this XurmoCellLocationMapPK.
     * @return the mobileCountryCode
     */
    public String getMobileCountryCode() {
        return this.mobileCountryCode;
    }

    /**
     * Sets the mobileCountryCode of this XurmoCellLocationMapPK to the specified value.
     * @param mobileCountryCode the new mobileCountryCode
     */
    public void setMobileCountryCode(String mobileCountryCode) {
        this.mobileCountryCode = mobileCountryCode;
    }

    /**
     * Gets the mobileNetworkCode of this XurmoCellLocationMapPK.
     * @return the mobileNetworkCode
     */
    public String getMobileNetworkCode() {
        return this.mobileNetworkCode;
    }

    /**
     * Sets the mobileNetworkCode of this XurmoCellLocationMapPK to the specified value.
     * @param mobileNetworkCode the new mobileNetworkCode
     */
    public void setMobileNetworkCode(String mobileNetworkCode) {
        this.mobileNetworkCode = mobileNetworkCode;
    }

    /**
     * Gets the siteId of this XurmoCellLocationMapPK.
     * @return the siteId
     */
    public String getSiteId() {
        return this.siteId;
    }

    /**
     * Sets the siteId of this XurmoCellLocationMapPK to the specified value.
     * @param siteId the new siteId
     */
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    /**
     * Gets the cellId of this XurmoCellLocationMapPK.
     * @return the cellId
     */
    public String getCellId() {
        return this.cellId;
    }

    /**
     * Sets the cellId of this XurmoCellLocationMapPK to the specified value.
     * @param cellId the new cellId
     */
    public void setCellId(String cellId) {
        this.cellId = cellId;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.cellId != null ? this.cellId.hashCode() : 0);
        hash += (this.siteId != null ? this.siteId.hashCode() : 0);
        hash += (this.mobileNetworkCode != null ? this.mobileNetworkCode.hashCode() : 0);
        hash += (this.mobileCountryCode != null ? this.mobileCountryCode.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoCellLocationMapPK.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoCellLocationMapPK object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoCellLocationMapPK)) {
            return false;
        }
        XurmoCellLocationMapPK other = (XurmoCellLocationMapPK)object;
        if (this.cellId != other.cellId && (this.cellId == null || !this.cellId.equals(other.cellId))) return false;
        if (this.siteId != other.siteId && (this.siteId == null || !this.siteId.equals(other.siteId))) return false;
        if (this.mobileNetworkCode != other.mobileNetworkCode && (this.mobileNetworkCode == null || !this.mobileNetworkCode.equals(other.mobileNetworkCode))) return false;
        if (this.mobileCountryCode != other.mobileCountryCode && (this.mobileCountryCode == null || !this.mobileCountryCode.equals(other.mobileCountryCode))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoCellLocationMapPK[cellId=" + cellId + ", siteId=" + siteId + ", mobileNetworkCode=" + mobileNetworkCode + ", mobileCountryCode=" + mobileCountryCode + "]";
    }
    
}
