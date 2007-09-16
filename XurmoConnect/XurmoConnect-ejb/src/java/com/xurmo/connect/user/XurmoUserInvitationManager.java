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
  public int sendInvitation(String username, XurmoInvitationForLink[] invitations, String msg, EntityManager em) {
    
    try {
      
      for (int i = 0; i < invitations.length; ++i) {
        javax.persistence.Query fq = em.createNamedQuery("XurmoUser.findByUsername");
        fq.setParameter("username", username);
        XurmoUser fu = (XurmoUser)(fq.getSingleResult());
        
        javax.persistence.Query tq = em.createNamedQuery("XurmoUser.findByUsername");
        tq.setParameter("username", invitations[i].requestToUser);
        XurmoUser tu = (XurmoUser)(tq.getSingleResult());
        
        XurmoRequestToConnectInboxPK pk = new XurmoRequestToConnectInboxPK(tu.getUserid(), fu.getUserid());
        XurmoRequestToConnectInbox rtc = new XurmoRequestToConnectInbox(pk);
        rtc.setDisposed(false);
        rtc.setLinkId(invitations[i].linkId);
        rtc.setMsg(invitations[i].message);
        em.persist(rtc);
      }
      return XurmoUserInteractionStatus.INTERACTIONSTATUS_NO_ERROR;
    } catch(Exception ex) {
      return XurmoUserInteractionStatus.INTERACTIONFAILED_COULD_NOT_SEND_INVITATION;
    }
  }
  XurmoInvitePhoneBookEntry[] getPhoneBookEntriesForInvitation(int userid, javax.persistence.EntityManager em) {
    return null;
  }
  /** Creates a new instance of XurmoUserInvitationManager */
  private XurmoUserInvitationManager() {
  }
  private static XurmoUserInvitationManager self_ = null;
}
