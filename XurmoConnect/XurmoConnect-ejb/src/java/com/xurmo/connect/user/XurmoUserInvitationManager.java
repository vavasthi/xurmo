/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserInvitationManager.java
 * Created on               : March 29, 2007, 9:54 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;
import javax.persistence.EntityManager;
import org.apache.xalan.templates.XUnresolvedVariable;

/**
 *
 * @author xurmo
 */
public class XurmoUserInvitationManager {
  
  public static XurmoUserInvitationManager instance() {
    if (self_ == null) {
      self_ = new XurmoUserInvitationManager();
    }
    return self_;
  }
  public int sendInvitation(String username, 
      XurmoInvitationForLink[] invitations,
      EntityManager em) {
    
    try {
      
      for (int i = 0; i < invitations.length; ++i) {
        javax.persistence.Query fq = em.createNamedQuery("XurmoUser.findByUsername");
        fq.setParameter("username", username);
        XurmoUser fu = (XurmoUser)(fq.getSingleResult());
        
        javax.persistence.Query tq = em.createNamedQuery("XurmoUser.findByPrimaryMobile");
        tq.setParameter("primaryMobile", invitations[i].phoneNumberToUser);
        XurmoPersonalAddressBookManager.setInvitationSent(fu.getUserid(), invitations[i].uniqueId, em);
        try {
          
          XurmoUser tu = (XurmoUser)(tq.getSingleResult());
          XurmoRequestToConnectInboxPK pk = new XurmoRequestToConnectInboxPK(tu.getUserid(), fu.getUserid());
          XurmoRequestToConnectInbox rtc = new XurmoRequestToConnectInbox(pk);
          rtc.setDisposed(false);
          rtc.setLinkId(invitations[i].linkId);
          rtc.setMsg(invitations[i].message);
          rtc.setUniqueId(invitations[i].uniqueId);
          em.persist(rtc);
        }
        catch (javax.persistence.NoResultException nre) {
          // The destination phone number is not a member, need to send a request to join.
          XurmoRequestToJoinInbox rtjm 
              = new XurmoRequestToJoinInbox(invitations[i].phoneNumberToUser, invitations[i].linkId, fu.getUserid());
          rtjm.setMsg(invitations[i].message);
          rtjm.setUniqueId(invitations[i].uniqueId);
          em.persist(rtjm);
          XurmoShortMessageServiceInterface.sendSMS(rtjm);
        }        
      }
      return XurmoUserInteractionStatus.INTERACTIONSTATUS_NO_ERROR;
    } catch(Exception ex) {
      return XurmoUserInteractionStatus.INTERACTIONFAILED_COULD_NOT_SEND_INVITATION;
    }
  }
  public XurmoInvitePhoneBookEntry[] getInviteToJoinEntries(XurmoUser xus, String cookie, javax.persistence.EntityManager em) {
    
    return getInviteEntries(xus, cookie, "XurmoPersonalAddressBook.findByInviteToJoinEntries", em);
  } 
  public XurmoInvitePhoneBookEntry[] getInviteToConnectEntries(XurmoUser xus, String cookie, javax.persistence.EntityManager em) {
    
    return getInviteEntries(xus, cookie, "XurmoPersonalAddressBook.findByInviteToConnectEntries", em);
  } 
  public XurmoInvitePhoneBookEntry[] getInviteEntries(XurmoUser xus, String cookie, String namedQuery, javax.persistence.EntityManager em) {
    
    javax.persistence.Query q = em.createNamedQuery(namedQuery);
    q.setParameter("userid", xus.getUserid());
    java.util.List l = q.getResultList();
    java.util.Vector<XurmoInvitePhoneBookEntry> out = new java.util.Vector<XurmoInvitePhoneBookEntry>();
    java.util.Iterator i = l.iterator();
    while (i.hasNext()) {
      XurmoPersonalAddressBook pab = (XurmoPersonalAddressBook)(i.next());
      javax.persistence.Query pnq = em.createNamedQuery("XurmoPersonalAddressBookPhoneNumbers.findByUseridAndAttributeId");
      pnq.setParameter("attributeId", 16);
      pnq.setParameter("userid", pab.xurmoPersonalAddressBookPK.getUserid());
      java.util.Iterator pni = pnq.getResultList().iterator();
      while (pni.hasNext()) {
        XurmoPersonalAddressBookPhoneNumbers pn = (XurmoPersonalAddressBookPhoneNumbers)(pni.next());
        out.add(new XurmoInvitePhoneBookEntry(pab.xurmoPersonalAddressBookPK.getUniqueId(), pab.getXurmoMember(), pab.getXurmoMemberUserId(), pab.getContactName(), pn.getPhoneNumber()));
      }
    }
    XurmoInvitePhoneBookEntry[] aOut = new XurmoInvitePhoneBookEntry[out.size()];
    return out.toArray(aOut);
  } 
  /** Creates a new instance of XurmoUserInvitationManager */
  private XurmoUserInvitationManager() {
  }
  private static XurmoUserInvitationManager self_ = null;
}
