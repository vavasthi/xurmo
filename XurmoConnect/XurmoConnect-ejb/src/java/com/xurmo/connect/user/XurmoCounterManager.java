/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoCounterManager.java
 * Created on               : November 18, 2007, 11:08 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import javax.persistence.EntityManager;
/**
 *
 * @author xurmo
 */
public class XurmoCounterManager {
  
  static final int messageIdCounter_ = 0x01;
  /** Creates a new instance of XurmoCounterManager */
  private XurmoCounterManager() {
  }
  
  static int getNextMessageId(EntityManager em) {
    XurmoCounters xc = null;
    int nv = 1;
    try {
      xc = (XurmoCounters)em.createNamedQuery("XurmoCounters.findById").setParameter("id", messageIdCounter_).getSingleResult();
      nv = xc.getVal() + 1;
      xc.setVal(nv);
      em.persist(xc);
    }
    catch(Exception ex) {
      System.out.println("XurmoCounters Exception " + ex);
      ex.printStackTrace();
      
      nv = 1;
      xc = new XurmoCounters(messageIdCounter_, nv);
      em.persist(xc);
    }
    return nv;
  }
}
