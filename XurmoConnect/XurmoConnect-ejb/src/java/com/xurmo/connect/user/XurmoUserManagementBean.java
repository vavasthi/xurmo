/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserManagementBean.java
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
public class XurmoUserManagementBean implements XurmoUserManagementRemote, XurmoUserManagementLocal {
    @PersistenceContext
    
    EntityManager em_;
    /**
     * Creates a new instance of XurmoUserManagementBean
     */
    public XurmoUserManagementBean() {
    }
    
    public int registerUser(String username,
            String password,
            String salutation,
            String fname,
            String lname,
            String mobile,
            boolean mobileValidated,
            String email,
            boolean emailValidated,
            String gender,
            Date dob,
            String imei,
            String btAddress,
            String mobileCountryCode,
            String mobileNetworkCode,
            String siteId,
            String cellId,
            String cellName) {
        //TODO implement registerUser
        int error = 0;
        XurmoCellLocationMap xclm = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em_);
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
                mobileValidated,
                email,
                emailValidated,
                gender,
                dob,
                imei,
                btAddress);
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
    
    public XurmoUserHomeScreenData doLogin(String username, String password, String imei, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String cellName) {
        
        String cookie = new String();
        XurmoUser xu = null;
        XurmoCellLocationMap xclm = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em_);        
        XurmoUserSessionManager.instance().removeSession(username, em_);
        try {
            
            xu = (XurmoUser) (em_.createNamedQuery("XurmoUser.findByUsername").setParameter("username", username).getSingleResult());
            if (XurmoUserEncryption.instance().validateEncryptedPassword(password, xu.getPassword())) {
                XurmoUserSession xus = XurmoUserSessionManager.instance().createSession(xu.getUsername(), XurmoUserEncryption.instance().getRandomCookie(mobileCountryCode + "-" + mobileNetworkCode + "-" + username), xclm.getLocationId(), em_);
                cookie = xus.getCookie();
            } else {
            return new XurmoUserHomeScreenData(xu.getUsername(), cookie, XurmoUserInteractionStatus.INTERACTIONFAILED_INVALID_USERNAME_OR_PASSWORD, "Unknown", "", "", "");
            }
        } catch (Exception ex) {
            return new XurmoUserHomeScreenData("", cookie, XurmoUserInteractionStatus.INTERACTIONFAILED_INVALID_USERNAME_OR_PASSWORD, "Unknown", "", "", "");
        }
        return new XurmoUserHomeScreenData(xu.getUsername(), cookie, XurmoUserInteractionStatus.INTERACTIONSTATUS_NO_ERROR, xclm.getLocation(), xu.getFname(), xu.getLname(), xu.getSalutation());
    }
    
    
    public XurmoUserManagementStatus doLogout(String username, String cookie, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String cellName) {
        
        XurmoLocationManager.updateLocation(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em_);
        XurmoUserSessionManager.instance().removeSession(username, em_);
        return new XurmoUserManagementStatus(XurmoUserInteractionStatus.INTERACTIONSTATUS_NO_ERROR, "", cellName);
    }
    
    public XurmoUserManagementStatus updateLocation(String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName) {
        return XurmoLocationManager.updateLocation(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em_);
    }
    public XurmoUserHomeScreenData getHomeScreenData(String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName) {
        
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
        if (xus != null && cookie.equals(xus.getCookie())) {
     
            XurmoCellLocationMap xclm 
                    = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em_);
            XurmoUser xu = (XurmoUser) (em_.createNamedQuery("XurmoUser.findByUsername").setParameter("username", username).getSingleResult());
            return new XurmoUserHomeScreenData(xu.getUsername(), xus.getCookie(), XurmoUserInteractionStatus.INTERACTIONSTATUS_NO_ERROR, xclm.getLocation(), xu.getFname(), xu.getLname(), xu.getSalutation());
        } else {
            return new XurmoUserHomeScreenData("", xus.getCookie(), XurmoUserInteractionStatus.INTERACTIONFAILED_USER_NOT_LOGGED_IN, "Unknown", "", "", "");
        }
    }

    public XurmoUserManagementStatus uploadPhoneBook(String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName, XurmoPhoneAddressBookSync addressBook) {
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
        if (xus != null && cookie.equals(xus.getCookie())) {
     
            XurmoCellLocationMap xclm 
                    = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em_);
            XurmoUser xu = (XurmoUser) (em_.createNamedQuery("XurmoUser.findByUsername").setParameter("username", username).getSingleResult());
            
            return XurmoPersonalAddressBookManager.uploadPhoneBook(xu, cookie, addressBook, cellName, em_);
        } else {
            return new XurmoUserManagementStatus(XurmoUserInteractionStatus.INTERACTIONFAILED_UPLOAD_ADDRESSBOOK_FAILED, "", cellName);
        }
    }

    public XurmoPhoneAddressBookSync downloadPhoneBook(String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName) {
        //TODO implement downloadPhoneBook
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
        if (xus != null && cookie.equals(xus.getCookie())) {
     
            XurmoCellLocationMap xclm 
                    = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em_);
            XurmoUser xu = (XurmoUser) (em_.createNamedQuery("XurmoUser.findByUsername").setParameter("username", username).getSingleResult());
            
            XurmoPhoneContactSync[] cs = new XurmoPhoneContactSync[2];
            cs[0] = new XurmoPhoneContactSync(1, "Vinay Avsthi", "Vinay", new Date());
            cs[1] = new XurmoPhoneContactSync(2, "Some Other Name", "SoN", new Date());
            XurmoPhoneAddressBookSync pabs = new XurmoPhoneAddressBookSync(cs);
            return pabs;
        } else {
            return new XurmoPhoneAddressBookSync(XurmoUserInteractionStatus.INTERACTIONFAILED_DOWNLOAD_ADDRESSBOOK_FAILED);
        }
    }

}