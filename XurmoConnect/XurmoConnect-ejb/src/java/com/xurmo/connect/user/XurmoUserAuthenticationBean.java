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
        String mobileCountryCode = imsi.substring(0, 3);
        String mobileNetworkCode = imsi.substring(3, 6);
        locationString = updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, locationString);
        XurmoUserSessionManager.instance().removeSession(username, em_);
        try {
            
            XurmoUser xu = (XurmoUser) (em_.createNamedQuery("XurmoUser.findByUsername").setParameter("username", username).getSingleResult());
            if (XurmoUserEncryption.instance().validateEncryptedPassword(password, xu.getPassword())) {
                XurmoUserSession xus = XurmoUserSessionManager.instance().createSession(xu.getUsername(), XurmoUserEncryption.instance().getRandomCookie(imsi), locationString, em_);
                cookie = xus.getCookie();
            } else {
                error |= XurmoUserSignonStatus.SIGNONFAILED_INVALID_USERNAME_OR_PASSWORD_MASK;
            }
        } catch (Exception ex) {
            error |= XurmoUserSignonStatus.SIGNONFAILED_INVALID_USERNAME_OR_PASSWORD_MASK;
        }
        return new XurmoUserAuthenticationReturnStatus(error, cookie);
    }
    
    private String updateLocationMap(String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString) {
        
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
                
                XurmoCellLocationMap xclm = new XurmoCellLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, locationString);
                em_.persist(xclm);
            }
        } else {
            locationString = mobileCountryCode + "-" + mobileNetworkCode + "-" + siteId + "-" + cellId;
        }
        return locationString;
    }
    
    public XurmoUserAuthenticationReturnStatus updateLocation(String username, String cookie, String imsi, String siteId, String cellId, String locationString) {
        
        int error = XurmoUserSignonStatus.SIGNONSTATUS_NO_ERROR;
        String mobileCountryCode = imsi.substring(0, 3);
        String mobileNetworkCode = imsi.substring(3, 6);
        XurmoMessageForALocationManager.instance().processMessagesInALocation(mobileCountryCode, mobileNetworkCode, siteId, cellId, username, em_);
        locationString = updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, locationString);
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
        if (xus != null && cookie.equals(xus.getCookie())) {
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
        if (xus != null && cookie.equals(xus.getCookie())) {
            return new XurmoUploadAddressBookReturnStatus(XurmoUserPersonalAddressBookManager.instance().uploadPersonalAddressBook(username, fullName, addresses, email, em_), cookie);
        } else {
            return new XurmoUploadAddressBookReturnStatus(XurmoUserInteractionStatus.INTERACTIONFAILED_COULD_NOT_UPDATE_PROFILE, cookie);
        }
    }
    
    public XurmoInvitationSendStatus sendInvitations(String username, String cookie, XurmoInvitationForLink[] invitations, String msg) {
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
        if (xus != null && cookie.equals(xus.getCookie())) {
            return new XurmoInvitationSendStatus(XurmoUserInvitationManager.instance().sendInvitation(username, invitations, msg, em_), cookie);
        } else {
            return new XurmoInvitationSendStatus(XurmoUserInteractionStatus.INTERACTIONFAILED_COULD_NOT_SEND_INVITATION, cookie);
        }
    }
    public XurmoNetworkLinkType[] getNetworkTypes(String username, String cookie) throws XurmoCouldNotRetrieveNetworkLinkTypeException {
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
        System.out.println("New Cookie :" + cookie + " old cookie :" + xus.getCookie());
        if (xus != null && cookie.equals(xus.getCookie())) {
            
            List res = em_.createNamedQuery("XurmoNetworkLinkType.findAll").getResultList();
            XurmoNetworkLinkType[] out = new XurmoNetworkLinkType[res.size()];
            int i = 0;
            for(java.util.Iterator itr = res.iterator(); itr.hasNext(); ) {
                out[i] = (XurmoNetworkLinkType)(itr.next());
                ++i;
            }
            return out;
        }
        throw new XurmoCouldNotRetrieveNetworkLinkTypeException();
    }
    public XurmoRequestToConnectResponseType[] getRequestToConnectResponseTypes(String username, String cookie) throws XurmoCouldNotRetrieveRequestToConnectResponseTypesException {
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
        System.out.println("New Cookie :" + cookie + " old cookie :" + xus.getCookie());
        if (xus != null && cookie.equals(xus.getCookie())) {
            
            List res = em_.createNamedQuery("XurmoRequestToConnectResponseType.findAll").getResultList();
            XurmoRequestToConnectResponseType[] out = new XurmoRequestToConnectResponseType[res.size()];
            int i = 0;
            for(java.util.Iterator itr = res.iterator(); itr.hasNext(); ) {
                out[i] = (XurmoRequestToConnectResponseType)(itr.next());
                ++i;
            }
            return out;
        }
        throw new XurmoCouldNotRetrieveRequestToConnectResponseTypesException();
    }
    
    public XurmoMessageForALocationReturnStatus enqueueMessage(String sourceId, String destinationId, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String msg, String cookie) {
        
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(sourceId, em_);
        if (xus != null && cookie.equals(xus.getCookie())) {
            return XurmoMessageForALocationManager.instance().enqueueMessage(sourceId, destinationId, mobileCountryCode, mobileNetworkCode, siteId, cellId, msg, cookie, em_);
        }
        return new XurmoMessageForALocationReturnStatus(XurmoUserInteractionStatus.INTERACTIONFAILED_USER_NOT_LOGGED_IN, cookie);
    }
    
    public XurmoInvitationDispositionStatus disposeInvitations(String username, String cookie, XurmoInvitationDisposition[] invitationDisposition, String msg) {
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
        if (xus != null && cookie.equals(xus.getCookie())) {
            
            for (int i = 0; i < invitationDisposition.length; ++i) {
                switch(invitationDisposition[i].getResponseId()) {
                    case XurmoInvitationDisposition.ACCEPT:
                    {
                        XurmoNetworkLink xnl = new XurmoNetworkLink(invitationDisposition[i].getLinkId(), username, invitationDisposition[i].getDestination());
                        Query qry = em_.createNamedQuery("XurmoRequestToConnectInbox.findByUsernameSourceAndLinkId");
                        qry.setParameter("username", username);
                        qry.setParameter("source", invitationDisposition[i].getDestination());
                        qry.setParameter("linkId", invitationDisposition[i].getLinkId());
                        XurmoRequestToConnectInbox inv = (XurmoRequestToConnectInbox)qry.getSingleResult();
                        em_.remove(inv);
                        em_.persist(xnl);
                    }
                    break;
                    case XurmoInvitationDisposition.DECLINE:
                    {
                        XurmoResponseToRequestToConnectInbox xnl = new XurmoResponseToRequestToConnectInbox(invitationDisposition[i].getLinkId(), username, invitationDisposition[i].getDestination(), msg);
                        Query qry = em_.createNamedQuery("XurmoRequestToConnectInbox.findByUsernameSourceAndLinkId");
                        qry.setParameter("username", username);
                        qry.setParameter("source", invitationDisposition[i].getDestination());
                        qry.setParameter("linkId", invitationDisposition[i].getLinkId());
                        XurmoRequestToConnectInbox inv = (XurmoRequestToConnectInbox)qry.getSingleResult();
                        em_.remove(inv);
                        em_.persist(xnl);
                    }
                    break;
                    case XurmoInvitationDisposition.DECLINE_SILENTLY:
                    {
                        Query qry = em_.createNamedQuery("XurmoRequestToConnectInbox.findByUsernameSourceAndLinkId");
                        qry.setParameter("username", username);
                        qry.setParameter("source", invitationDisposition[i].getDestination());
                        qry.setParameter("linkId", invitationDisposition[i].getLinkId());
                        XurmoRequestToConnectInbox inv = (XurmoRequestToConnectInbox)qry.getSingleResult();
                        em_.remove(inv);
                    }
                    break;
                    case XurmoInvitationDisposition.POSTPONE:
                        break;
                }
            }
            return new XurmoInvitationDispositionStatus(XurmoUserInteractionStatus.INTERACTIONSTATUS_NO_ERROR, cookie);
        } else {
            return new XurmoInvitationDispositionStatus(XurmoUserInteractionStatus.INTERACTIONFAILED_USER_NOT_LOGGED_IN, cookie);
        }
    }
}