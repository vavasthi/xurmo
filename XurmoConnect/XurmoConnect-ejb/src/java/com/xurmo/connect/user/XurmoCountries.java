/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoCountries.java
 * Created on               : September 11, 2007, 10:46 PM
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
 * Entity class XurmoCountries
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoCountries")
@NamedQueries( {
    @NamedQuery(name = "XurmoCountries.findByMobileCountryCode", query = "SELECT x FROM XurmoCountries x WHERE x.mobileCountryCode = :mobileCountryCode"),
    @NamedQuery(name = "XurmoCountries.findByCountryName", query = "SELECT x FROM XurmoCountries x WHERE x.countryName = :countryName")
  })
public class XurmoCountries implements Serializable {

  @Id
  @Column(name = "mobileCountryCode", nullable = false)
  private String mobileCountryCode;

  @Column(name = "countryName", nullable = false)
  private String countryName;
  
  /** Creates a new instance of XurmoCountries */
  public XurmoCountries() {
  }

  /**
   * Creates a new instance of XurmoCountries with the specified values.
   * @param mobileCountryCode the mobileCountryCode of the XurmoCountries
   */
  public XurmoCountries(String mobileCountryCode) {
    this.mobileCountryCode = mobileCountryCode;
  }

  /**
   * Creates a new instance of XurmoCountries with the specified values.
   * @param mobileCountryCode the mobileCountryCode of the XurmoCountries
   * @param countryName the countryName of the XurmoCountries
   */
  public XurmoCountries(String mobileCountryCode, String countryName) {
    this.mobileCountryCode = mobileCountryCode;
    this.countryName = countryName;
  }

  /**
   * Gets the mobileCountryCode of this XurmoCountries.
   * @return the mobileCountryCode
   */
  public String getMobileCountryCode() {
    return this.mobileCountryCode;
  }

  /**
   * Sets the mobileCountryCode of this XurmoCountries to the specified value.
   * @param mobileCountryCode the new mobileCountryCode
   */
  public void setMobileCountryCode(String mobileCountryCode) {
    this.mobileCountryCode = mobileCountryCode;
  }

  /**
   * Gets the countryName of this XurmoCountries.
   * @return the countryName
   */
  public String getCountryName() {
    return this.countryName;
  }

  /**
   * Sets the countryName of this XurmoCountries to the specified value.
   * @param countryName the new countryName
   */
  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.mobileCountryCode != null ? this.mobileCountryCode.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoCountries.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoCountries object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoCountries)) {
      return false;
    }
    XurmoCountries other = (XurmoCountries)object;
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
    return "com.xurmo.connect.user.XurmoCountries[mobileCountryCode=" + mobileCountryCode + "]";
  }
  
}
