/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserAuthenticationBean.java
 * Created on               : March 26, 2007, 6:17 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author xurmo
 */
@Stateless(name = "ejb/XurmoUserAuthenticationBean")
public class XurmoUserAuthenticationBean implements XurmoUserAuthenticationRemote, XurmoUserAuthenticationLocal {
    @PersistenceContext
    
    EntityManager em_;
    /** Creates a new instance of XurmoUserAuthenticationBean */
    public XurmoUserAuthenticationBean() {
    }
    
    public int registerUser(String username,
            String password,
            String salutation,
            String fname,
            String lname,
            String mobile,
            String email,
            String gender,
            Date dob) {
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
        if (mobileExists(mobile)) {
            error |= XurmoUserRegistrationStatus.MOBILE_EXISTS_MASK;
        }
        if (!validEmail(email)) {
            error |= XurmoUserRegistrationStatus.EMAIL_INVALID_MASK;
        }
        if (emailExists(email)) {
            error |= XurmoUserRegistrationStatus.EMAIL_EXISTS_MASK;
        }
        if (error != XurmoUserRegistrationStatus.USER_REGISTRATION_NO_ERROR) {
            return error;
        }
        byte[] encodedPassword = null;
        try {
            
            encodedPassword
                    = XurmoUserEncryption.instance().encrypt(password);
        } catch(Exception ex) {
            error |= XurmoUserRegistrationStatus.PASSWORD_COULD_NOT_BE_ENCODED_MASK;
            return error;
        }
        XurmoUser xu = new XurmoUser(username,
                encodedPassword,
                salutation,
                fname,
                lname,
                mobile,
                email,
                gender,
                dob);
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
        } else {
            return false;
        }
    }
    private boolean mobileExists(String mobile) {
        List res = em_.createNamedQuery("XurmoUser.findByPrimaryMobile").
                setParameter("primaryMobile", mobile).getResultList();
        if (res.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
    private boolean emailExists(String email) {
        List res = em_.createNamedQuery("XurmoUser.findByPrimaryEmail").
                setParameter("primaryEmail", email).getResultList();
        if (res.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public XurmoUserAuthenticationReturnStatus doLogin(String username, String password, String imsi, String siteId, String cellId, String locationString) {
        
        int error = XurmoUserSignonStatus.SIGNONSTATUS_NO_ERROR;
        String cookie = new String();
        locationString = updateLocationMap(imsi, siteId, cellId, locationString);
        XurmoUserSessionManager.instance().removeSession(username, em_);
        try {
            
            XurmoUser xu = (XurmoUser) (em_.createNamedQuery("XurmoUser.findByUsername").setParameter("username", username).getSingleResult());
            if (XurmoUserEncryption.instance().validateEncryptedPassword(password, xu.getPassword())) {
                XurmoUserSession xus = XurmoUserSessionManager.instance().createSession(xu.getUsername(), XurmoUserEncryption.instance().getRandomCookie(imsi), locationString, em_);
                cookie = xus.getCookie();
            }
            else {
                error |= XurmoUserSignonStatus.SIGNONFAILED_INVALID_USERNAME_OR_PASSWORD_MASK;
            }
        } catch (Exception ex) {
            error |= XurmoUserSignonStatus.SIGNONFAILED_INVALID_USERNAME_OR_PASSWORD_MASK;
        }
        return new XurmoUserAuthenticationReturnStatus(error, cookie);
    }
    
    private String updateLocationMap(String imsi, String siteId, String cellId, String locationString) {
        
        String mobileCountryCode = imsi.substring(0, 3);
        String mobileNetworkCode = imsi.substring(3, 6);
        if (locationString != null && !locationString.equals("") && !locationString.equals("Unknown")) {
            Query q = em_.createNamedQuery("XurmoCellLocationMap.findByCellInfo");
            q.setParameter("siteId", siteId);
            q.setParameter("cellId", cellId);
            q.setParameter("mobileCountryCode", mobileCountryCode);
            q.setParameter("mobileNetworkCode", mobileNetworkCode);
            try {
                
                XurmoCellLocationMap xclm = (XurmoCellLocationMap)q.getSingleResult();
                locationString = xclm.getLocation();
            } catch (Exception ex) {
                
                XurmoCellLocationMap xclm = new XurmoCellLocationMap(cellId, siteId, mobileNetworkCode, mobileCountryCode, locationString);
                em_.persist(xclm);
            }
        } else {
            locationString = mobileCountryCode + "-" + mobileNetworkCode + "-" + siteId + "-" + cellId;
        }
        return locationString;
    }
    
    public XurmoUserAuthenticationReturnStatus updateLocation(String username, String cookie, String imsi, String siteId, String cellId, String locationString) {
        
        int error = XurmoUserSignonStatus.SIGNONSTATUS_NO_ERROR;
        locationString = updateLocationMap(imsi, siteId, cellId, locationString);
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
        if (xus != null && xus.getCookie() == cookie) {
            xus.setLocation(locationString);
            cookie = xus.getCookie();
        }
        return new XurmoUserAuthenticationReturnStatus(error, cookie);
    }
    public int doLogout(String username) {
        
        int error = XurmoUserSignonStatus.SIGNONSTATUS_NO_ERROR;
        XurmoUserSessionManager.instance().removeSession(username, em_);
        return error;
    }

    public XurmoUploadAddressBookReturnStatus uploadPersonalAddressBook(String username, String cookie, String fullName, XurmoElectronicAddress[] addresses, String email) {
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
        if (xus != null && xus.getCookie() == cookie) {
            return new XurmoUploadAddressBookReturnStatus(XurmoUserPersonalAddressBookManager.instance().uploadPersonalAddressBook(username, fullName, addresses, email, em_), cookie);
        } 
        else {
            return new XurmoUploadAddressBookReturnStatus(XurmoUserInteractionStatus.INTERACTIONFAILED_COULD_NOT_UPDATE_PROFILE, cookie);
        }
    }

    public XurmoInvitationSendStatus sendInvitations(String username, String cookie, String[] destinations, String msg) {
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
        if (xus != null && xus.getCookie() == cookie) {
            return new XurmoInvitationSendStatus(XurmoUserInvitationManager.instance().sendInvitation(username, destinations, msg, em_), cookie);
        } 
        else {
            return new XurmoInvitationSendStatus(XurmoUserInteractionStatus.INTERACTIONFAILED_COULD_NOT_SEND_INVITATION, cookie);
        }
    }
}
