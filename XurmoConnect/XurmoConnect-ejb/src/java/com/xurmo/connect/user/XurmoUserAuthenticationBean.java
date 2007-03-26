/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserAuthenticationBean.java
 * Created on               : March 26, 2007, 6:17 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author xurmo
 */
@Stateless (name = "ejb/XurmoUserAuthenticationBean")
public class XurmoUserAuthenticationBean implements XurmoUserAuthenticationRemote, XurmoUserAuthenticationLocal {
    @PersistenceContext
    
    EntityManager em_;
    /** Creates a new instance of XurmoUserAuthenticationBean */
    public XurmoUserAuthenticationBean() {
    }

    public int registerUser(String username, 
            String password, 
            String fname, 
            String lname, 
            String mobile, 
            String email) {
        //TODO implement registerUser
        int error = 0;
        if (!validUsername(username)) {
            error |= XurmoUserRegistrationStatus.USERNAME_INVALID_MASK;
        }
        if(!usernameExists(username)) {
            error |= XurmoUserRegistrationStatus.USERNAME_EXISTS_MASK;
        }
        if (!validPassword(password)) {
            error |= XurmoUserRegistrationStatus.PASSWORD_INVALID_MASK;
        }
        if (!validMobile(mobile)) {
            error |= XurmoUserRegistrationStatus.MOBILE_INVALID_MASK;
        }
        if (!mobileExists(mobile)) {
            error |= XurmoUserRegistrationStatus.MOBILE_EXISTS_MASK;
        }
        if (!validEmail(email)) {
            error |= XurmoUserRegistrationStatus.EMAIL_INVALID_MASK;
        }
        if (!emailExists(email)) {
            error |= XurmoUserRegistrationStatus.EMAIL_EXISTS_MASK;
        }
        if (error != XurmoUserRegistrationStatus.USER_REGISTRATION_NO_ERROR) {
            return error;
        }
        XurmoUser xu = new XurmoUser(username, 
                XurmoUserEncryption.instance().encrypt(password), 
                fname, 
                lname, 
                mobile, 
                email);
        em_.persist(xu);
        return XurmoUserRegistrationStatus.USER_REGISTRATION_NO_ERROR;
    }
    private boolean validUsername(String username) {
        return true;
    }
    private boolean validPassword(String password) {
        return true;
    }
    private boolean validMobile(String mobileNo) {
        return true;
    }
    private boolean validEmail(String email) {
        return true;
    }
    private boolean usernameExists(String username) {
        List res = em_.createNamedQuery("XurmoUser.findByUsername").
                setParameter("username", username).getResultList();
        if (res.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    private boolean mobileExists(String mobile) {
        List res = em_.createNamedQuery("XurmoUser.findByPrimaryMobile").
                setParameter("primaryMobile", mobile).getResultList();
        if (res.size() == 0) {
            return false;
        }
        else {
            return true;
        }
    }
    private boolean emailExists(String email) {
        List res = em_.createNamedQuery("XurmoUser.findByPrimaryEmail").
                setParameter("primaryEmail", email).getResultList();
        if (res.size() == 0) {
            return false;
        }
        else {
            return true;
        }
    }
}
