/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoErrorBean.java
 * Created on               : May 4, 2007, 9:59 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author xurmo
 */
@Stateless(name = "ejb/XurmoErrorBean")
public class XurmoErrorBean implements XurmoErrorRemote, XurmoErrorLocal {
    @PersistenceContext
    
    EntityManager em_;
    
    /** Creates a new instance of XurmoErrorBean */
    public XurmoErrorBean() {
    }

    public XurmoError[] getErrorMessages() {
        List res = em_.createNamedQuery("XurmoErrors.findAll").getResultList();
        XurmoError[] xe = new XurmoError[res.size()];
        java.util.Iterator i = res.iterator();
        int pos = 0;
        while (i.hasNext()) {
            XurmoErrors xes = (XurmoErrors)i.next();
            xe[pos] = new XurmoError(xes.getError(), xes.getErrorStr(), xes.getErrorMsg());
            ++pos;
        }
        return xe;
    }
    
}
