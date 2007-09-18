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
  public XurmoInvitationSendStatus sendInvitations(String username, String cookie, XurmoInvitationForLink[] invitations, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString) {
    XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
    if (xus != null && cookie.equals(xus.getCookie())) {
      XurmoLocationManager.updateLocation(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, locationString, em_);
      return new XurmoInvitationSendStatus(XurmoUserInvitationManager.instance().sendInvitation(username, invitations, em_), cookie);
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
  
  public XurmoInvitationDispositionStatus disposeInvitations(String username, String cookie, XurmoInvitationDisposition[] invitationDisposition, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName) {
    
    XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
    
    if (xus != null && cookie.equals(xus.getCookie())) {
      XurmoLocationManager.updateLocation(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em_);
      javax.persistence.Query tuq = em_.createNamedQuery("XurmoUser.findByUsername");
      tuq.setParameter("username", username);
      XurmoUser tu = (XurmoUser)(tuq.getSingleResult());
      for (int i = 0; i < invitationDisposition.length; ++i) {

      javax.persistence.Query fuq = em_.createNamedQuery("XurmoUser.findByUsername");
      fuq.setParameter("username", invitationDisposition[i].requestFromUser);
      XurmoUser fu = (XurmoUser)(fuq.getSingleResult());

      switch(invitationDisposition[i].disposition) {
          case XurmoInvitationDisposition.ACCEPT:
          {
            XurmoNetworkLink xnl = new XurmoNetworkLink(invitationDisposition[i].linkId, fu.getUserid(), tu.getUserid());
            Query qry = em_.createNamedQuery("XurmoRequestToConnectInbox.findByRequestFromRequestToAndLinkId");
            qry.setParameter("requestFrom", fu.getUserid());
            qry.setParameter("requestTo", tu.getUserid());
            qry.setParameter("linkId", invitationDisposition[i].linkId);
            XurmoRequestToConnectInbox inv = (XurmoRequestToConnectInbox)qry.getSingleResult();
            inv.setDisposed(true);
            inv.setResponseId(XurmoInvitationDisposition.ACCEPT);
            em_.persist(inv);
            em_.persist(xnl);
          }
          break;
          case XurmoInvitationDisposition.DECLINE_SILENTLY:
          case XurmoInvitationDisposition.DECLINE:
          {
            Query qry = em_.createNamedQuery("XurmoRequestToConnectInbox.findByRequestFromRequestToAndLinkId");
            qry.setParameter("requestFrom", fu.getUserid());
            qry.setParameter("requestTo", tu.getUserid());
            qry.setParameter("linkId", invitationDisposition[i].linkId);
            XurmoRequestToConnectInbox inv = (XurmoRequestToConnectInbox)qry.getSingleResult();
            inv.setDisposed(true);
            inv.setResponseId(XurmoInvitationDisposition.DECLINE);
            em_.persist(inv);
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
  public XurmoInvitationForLink[] getPendingInvitations(String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName) {
    
    XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
    if (xus != null && cookie.equals(xus.getCookie())) {
      javax.persistence.Query uq = em_.createNamedQuery("XurmoUser.findByUsername");
      uq.setParameter("username", username);
      XurmoUser xu = (XurmoUser)uq.getSingleResult();
      XurmoCellLocationMap xclm
          = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em_);
      javax.persistence.Query rtcq = em_.createNativeQuery("XurmoRequestToConnectInbox.findPendingByRequestTo");
      rtcq.setParameter("requestTo", xu.getUserid());
      java.util.List l = rtcq.getResultList();
      XurmoInvitationForLink[] retValue = new XurmoInvitationForLink[l.size()];
      java.util.Iterator itr = l.iterator();
      int k = 0;
      while (itr.hasNext()) {
        XurmoRequestToConnectInbox rtci = (XurmoRequestToConnectInbox)itr.next();
        javax.persistence.Query xnltq = em_.createNamedQuery("XurmoNetworkLinkType.findByLinkId");
        xnltq.setParameter("linkId", rtci.getLinkId());        
        XurmoNetworkLinkType xnlt = (XurmoNetworkLinkType)xnltq.getSingleResult();
        javax.persistence.Query rfuq = em_.createNamedQuery("XurmoUser.findByUserid");
        rfuq.setParameter("userid", rtci.xurmoRequestToConnectInboxPK.getRequestFrom());
        XurmoUser rfu = (XurmoUser)rfuq.getSingleResult();
        retValue[k] = new XurmoInvitationForLink(rfu.getUsername(),
            "",
            rtci.getLinkId(),
            rtci.getUniqueId(),
            xnlt.getLinkName(),
            rtci.getMsg());
        ++k;
      }
      return retValue;
    }
    //TODO implement getNetworkSummary
    return new XurmoInvitationForLink[0];
  }
  public XurmoNetworkSummaryStatus getNetworkSummary(String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName) {
    
    XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em_);
    if (xus != null && cookie.equals(xus.getCookie())) {
      javax.persistence.Query uq = em_.createNamedQuery("XurmoUser.findByUsername");
      uq.setParameter("username", username);
      XurmoUser xu = (XurmoUser)uq.getSingleResult();
      XurmoCellLocationMap xclm
          = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em_);
      String[] memberOfNetworks = XurmoNetworkManager.memberOfNetworks(xu.getUserid(), em_);
      int numberOfContacts = XurmoNetworkManager.numberOfContacts(xu.getUserid(), em_);
      XurmoUserGlobalData[] contactsAlreadyUser = XurmoNetworkManager.contactsAlreadyUser(username, em_);
      return new XurmoNetworkSummaryStatus(cookie, xclm.getLocation(), memberOfNetworks, numberOfContacts, contactsAlreadyUser);
    }
    //TODO implement getNetworkSummary
    return new XurmoNetworkSummaryStatus(XurmoNetworkInteractionStatus.NETWORKINTERACTION_COULD_NOT_GET_SUMMARY, cookie, cellName);
  }
  
}
