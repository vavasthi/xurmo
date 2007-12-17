/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoMessageForNetworkManager.java
 * Created on               : November 18, 2007, 1:02 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import javax.xml.registry.infomodel.EmailAddress;

/**
 *
 * @author xurmo
 */
public class XurmoMessageForNetworkManager {
  
  /** Creates a new instance of XurmoMessageForNetworkManager */
  public XurmoMessageForNetworkManager() {
  }
  
  static public void flushNetworkMessages(javax.persistence.EntityManager em) {
    javax.persistence.Query q = em.createNamedQuery("XurmoMessageForNetwork.findByStatus");
    q.setParameter("status", 'N');
    java.util.List rl = q.getResultList();
    java.util.Iterator ri = rl.iterator();
    System.out.println("Messages to be Delivered.." + rl.size());
    while (ri.hasNext()) {
      XurmoMessageForNetwork xmfn = (XurmoMessageForNetwork)(ri.next());
      java.util.Vector<XurmoUser> xuv
          = getMatchingUsers(xmfn.getUserId(), xmfn.getDegreesOfSeparation(), xmfn.xurmoMessageForNetworkPK.getLinkId(), em);
      for (int i = 0; i < xuv.size(); ++i) {
        
        XurmoUser xu = xuv.elementAt(i);
        XurmoUserMessageThroughNetwork xumtn
            = new XurmoUserMessageThroughNetwork(new XurmoUserMessageThroughNetworkPK(xu.getUserid(), xmfn.xurmoMessageForNetworkPK.getMessageId()),
            'N');
        em.persist(xumtn);
      }
      xmfn.setStatus('D');
      em.persist(xmfn);
    }
  }
  
  static private java.util.Vector<XurmoUser> getMatchingUsers(int userId, int dos, int linkId, javax.persistence.EntityManager em) {
    java.util.Vector<XurmoUser> xuv = new java.util.Vector<XurmoUser>();
    getMatchingUsersForLevel(userId, userId, dos, linkId, xuv, em);
    return xuv;
  }
  static private void getMatchingUsersForLevel(int sUserId, int cUserId, int dos, int linkId, java.util.Vector<XurmoUser> xuv, javax.persistence.EntityManager em) {
    
    if (dos == 0) {
      
      System.out.println("Returning from matching users since dos = 0");
      return;
    } else {
      
      System.out.println("Continuing from matching users since dos = " + dos);
      javax.persistence.Query q = em.createNamedQuery("XurmoNetworkLink.findByUseridAndLinkId");
      q.setParameter("userid", cUserId);
      q.setParameter("linkId", linkId);
      java.util.List ll = q.getResultList();
      java.util.Iterator li = ll.iterator();
      while (li.hasNext()) {
        XurmoNetworkLink xnl = (XurmoNetworkLink)(li.next());
        int otherUserId = addIfNotAlreadySeenAndWillingToReceiveMessage(xuv, sUserId, cUserId, dos, xnl, em);
        if (otherUserId != -1) { // If -1, then either the user did not receive or was not willing to forward
          
          getMatchingUsersForLevel(sUserId, otherUserId, dos - 1, linkId, xuv, em);
          System.out.println("Recursing with dos = " + (dos - 1) + " sUserId =" + sUserId + " otherUserId =" + otherUserId);
        } else {
          System.out.println("addIfNotAlreadySeen returned -1");
        }
      }
    }
  }
  
  static private int addIfNotAlreadySeenAndWillingToReceiveMessage(java.util.Vector<XurmoUser> xuv,
      int sUserId,
      int userid,
      int dos,
      XurmoNetworkLink xnl,
      javax.persistence.EntityManager em) {
    
    int otherUserid = xnl.xurmoNetworkLinkPK.getUserid1();
    if (otherUserid == userid) {
      otherUserid = xnl.xurmoNetworkLinkPK.getUserid2();
    }
    if (otherUserid != sUserId) {
      
      XurmoUser xu = (XurmoUser)(em.createNamedQuery("XurmoUser.findByUserid").setParameter("userid", userid).getSingleResult());
      if (XurmoUserPreferenceManager.shouldForwardMessagesOnDestinationPreferences(userid, sUserId, xnl.xurmoNetworkLinkPK.getLinkId(), em)) {
        
        XurmoUser ou = (XurmoUser)(em.createNamedQuery("XurmoUser.findByUserid").setParameter("userid", otherUserid).getSingleResult());
        if (XurmoUserPreferenceManager.willReceiveMessages(sUserId, userid, dos, xnl.xurmoNetworkLinkPK.getLinkId(), em)) {
          if (!alreadyExists(xuv, ou)) {
            xuv.add(ou);
          }
        }
      } else {
        // If the user is not willing to forward, stop the forward and do not traverse this node.
        otherUserid = -1;
      }
    }
    else {
      otherUserid = -1;
    }
    return otherUserid;
  }
  
  static private boolean alreadyExists(java.util.Vector<XurmoUser> xuv, XurmoUser xu) {
    for (int i = 0; i < xuv.size(); ++i) {
      if (xuv.elementAt(i).getUserid() == xu.getUserid()) {
        return true;
      }
    }
    return false;
  }
  static public void getUserMessages(XurmoUser xu, java.util.Vector<XurmoMessage> messages, boolean unreadOnly, javax.persistence.EntityManager em) {
    
    javax.persistence.Query q = em.createNamedQuery("XurmoMessageForNetwork.findByDestinationUserid");
    if (unreadOnly) {
      q = em.createNamedQuery("XurmoMessageForNetwork.findByDestinationUseridAndStatus");
      q.setParameter("status", 'N');
    }
    q.setParameter("userid", xu.getUserid());
    java.util.List ml = q.getResultList();
    java.util.Iterator mi = ml.iterator();
    while (mi.hasNext()) {
      XurmoMessageForNetwork xmfn = (XurmoMessageForNetwork)(mi.next());
      XurmoNetworkLinkType xnlt = (XurmoNetworkLinkType)(em.createNamedQuery("XurmoNetworkLinkType.findByLinkId").setParameter("linkId", xmfn.xurmoMessageForNetworkPK.getLinkId()).getSingleResult());
      messages.add(XurmoMessage.create(xmfn, xnlt, xu));
    }
  }
}
