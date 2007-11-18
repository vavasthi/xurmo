/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoCounters.java
 * Created on               : November 18, 2007, 11:08 AM
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
 * Entity class XurmoCounters
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoCounters")
@NamedQueries( {
    @NamedQuery(name = "XurmoCounters.findById", query = "SELECT x FROM XurmoCounters x WHERE x.id = :id"),
    @NamedQuery(name = "XurmoCounters.findByVal", query = "SELECT x FROM XurmoCounters x WHERE x.val = :val")
  })
public class XurmoCounters implements Serializable {

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "val", nullable = false)
  private int val;
  
  /** Creates a new instance of XurmoCounters */
  public XurmoCounters() {
  }

  /**
   * Creates a new instance of XurmoCounters with the specified values.
   * @param id the id of the XurmoCounters
   */
  public XurmoCounters(Integer id) {
    this.id = id;
  }

  /**
   * Creates a new instance of XurmoCounters with the specified values.
   * @param id the id of the XurmoCounters
   * @param val the val of the XurmoCounters
   */
  public XurmoCounters(Integer id, int val) {
    this.id = id;
    this.val = val;
  }

  /**
   * Gets the id of this XurmoCounters.
   * @return the id
   */
  public Integer getId() {
    return this.id;
  }

  /**
   * Sets the id of this XurmoCounters to the specified value.
   * @param id the new id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Gets the val of this XurmoCounters.
   * @return the val
   */
  public int getVal() {
    return this.val;
  }

  /**
   * Sets the val of this XurmoCounters to the specified value.
   * @param val the new val
   */
  public void setVal(int val) {
    this.val = val;
  }

  /**
   * Returns a hash code value for the object.  This implementation computes 
   * a hash code value based on the id fields in this object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.id != null ? this.id.hashCode() : 0);
    return hash;
  }

  /**
   * Determines whether another object is equal to this XurmoCounters.  The result is 
   * <code>true</code> if and only if the argument is not null and is a XurmoCounters object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof XurmoCounters)) {
      return false;
    }
    XurmoCounters other = (XurmoCounters)object;
    if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
    return true;
  }

  /**
   * Returns a string representation of the object.  This implementation constructs 
   * that representation based on the id fields.
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "com.xurmo.connect.user.XurmoCounters[id=" + id + "]";
  }
  
}
