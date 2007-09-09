/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoNetworkManagementBean.java
 * Created on               : May 4, 2007, 7:29 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.util.Iterator;
import javax.ejb.Stateless;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author xurmo
 */
@Stateless(name = "ejb/XurmoNetworkManagementBean")
public class XurmoNetworkManagementBean implements XurmoNetworkManagementRemote, XurmoNetworkManagementLocal {
    @PersistenceContext
    
    EntityManager em_;
    
    /** Creates a new instance of XurmoNetworkManagementBean */
    public XurmoNetworkManagementBean() {
    }
    public XurmoInvitationSendStatus sendInvitations(String username, String cookie, XurmoInvitationForLink[] invitations, String msg, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString) {
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
        if (xus != null && cookie.equals(xus.getCookie())) {
            XurmoLocationManager.updateLocation(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, locationString, em_);
            return new XurmoInvitationSendStatus(XurmoUserInvitationManager.instance().sendInvitation(username, invitations, msg, em_), cookie);
        } else {
            return new XurmoInvitationSendStatus(XurmoUserInteractionStatus.INTERACTIONFAILED_COULD_NOT_SEND_INVITATION, cookie);
        }
    }
    public XurmoNetworkLinkType[] getNetworkTypes(String username, String cookie, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString) throws XurmoCouldNotRetrieveNetworkLinkTypeException {
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
        System.out.println("New Cookie :" + cookie + " old cookie :" + xus.getCookie());
        if (xus != null && cookie.equals(xus.getCookie())) {
            
            XurmoLocationManager.updateLocation(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, locationString, em_);
            List res = em_.createNamedQuery("XurmoNetworkLinkType.findAll").getResultList();
            XurmoNetworkLinkType[] out = new XurmoNetworkLinkType[res.size()];
            int i = 0;
            for(Iterator itr = res.iterator(); itr.hasNext(); ) {
                out[i] = (XurmoNetworkLinkType)(itr.next());
                ++i;
            }
            return out;
        }
        throw new XurmoCouldNotRetrieveNetworkLinkTypeException();
    }
    public XurmoRequestToConnectResponseType[] getRequestToConnectResponseTypes(String username, String cookie, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString) throws XurmoCouldNotRetrieveRequestToConnectResponseTypesException {
        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
        System.out.println("New Cookie :" + cookie + " old cookie :" + xus.getCookie());
        if (xus != null && cookie.equals(xus.getCookie())) {
            
            XurmoLocationManager.updateLocation(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, locationString, em_);
            List res = em_.createNamedQuery("XurmoRequestToConnectResponseType.findAll").getResultList();
            XurmoRequestToConnectResponseType[] out = new XurmoRequestToConnectResponseType[res.size()];
            int i = 0;
            for(Iterator itr = res.iterator(); itr.hasNext(); ) {
                out[i] = (XurmoRequestToConnectResponseType)(itr.next());
                ++i;
            }
            return out;
        }
        throw new XurmoCouldNotRetrieveRequestToConnectResponseTypesException();
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

    public XurmoNetworkSummaryStatus getNetworkSummary(String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName) {

        XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
        if (xus != null && cookie.equals(xus.getCookie())) {
           XurmoCellLocationMap xclm 
                    = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em_);
             String[] memberOfNetworks = XurmoNetworkManager.memberOfNetworks(username, em_);
            int numberOfContacts = XurmoNetworkManager.numberOfContacts(username, em_);
            XurmoUserGlobalData[] contactsAlreadyUser = XurmoNetworkManager.contactsAlreadyUser(username, em_);
            return new XurmoNetworkSummaryStatus(cookie, memberOfNetworks, numberOfContacts, contactsAlreadyUser);
        }
       //TODO implement getNetworkSummary
        return new XurmoNetworkSummaryStatus(XurmoNetworkInteractionStatus.NETWORKINTERACTION_COULD_NOT_GET_SUMMARY, cookie);
    }
    
}
