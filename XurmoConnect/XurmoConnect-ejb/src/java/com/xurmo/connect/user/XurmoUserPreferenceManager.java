/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserPreferenceManager.java
 * Created on               : September 15, 2007, 10:31 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.util.Vector;
import org.hibernate.reflection.java.JavaXFactory;

/**
 *
 * @author xurmo
 */
public class XurmoUserPreferenceManager {
  
  /** Creates a new instance of XurmoUserPreferenceManager */
  private  XurmoUserPreferenceManager() {
  }
  private static boolean isInWhiteList(int userid, int fromUserid, int linkId, javax.persistence.EntityManager em) throws XurmoUserPreferenceRetrievalException{
    
    javax.persistence.Query lq = em.createNamedQuery("XurmoUserNetworkAndUserWhiteList.findByUseridLinkIdAndOtherUserid");
    lq.setParameter("userid", userid);
    lq.setParameter("linkId", linkId);
    lq.setParameter("otherUserid", fromUserid);
    try {
      
      XurmoUserNetworkAndUserWhiteList xunuwl = (XurmoUserNetworkAndUserWhiteList)lq.getSingleResult();
      return true;
    } catch(javax.persistence.NoResultException nrefl) {
      
    } catch (Exception ex) {
      throw new XurmoUserPreferenceRetrievalException(ex);
    }
    
    javax.persistence.Query q = em.createNamedQuery("XurmoUserPreferenceWhiteList.findByUseridAndOtherUserid");
    q.setParameter("userid", userid);
    q.setParameter("otherUserid", fromUserid);
    try {
      
      XurmoUserPreferenceWhiteList xupwl = (XurmoUserPreferenceWhiteList)q.getSingleResult();
      return true;
    } catch(javax.persistence.NoResultException nre) {
      
      return false;
    } catch (Exception ex) {
      
      throw new XurmoUserPreferenceRetrievalException(ex);
    }
  }
  private static boolean isInBlackList(int userid, int fromUserid, int linkId, javax.persistence.EntityManager em) throws XurmoUserPreferenceRetrievalException{
    
    javax.persistence.Query lq = em.createNamedQuery("XurmoUserNetworkAndUserBlackList.findByUseridLinkIdAndOtherUserid");
    lq.setParameter("userid", userid);
    lq.setParameter("linkId", linkId);
    lq.setParameter("otherUserid", fromUserid);
    try {
      
      XurmoUserNetworkAndUserBlackList xunubl = (XurmoUserNetworkAndUserBlackList)lq.getSingleResult();
      return true;
    } catch(javax.persistence.NoResultException nrefl) {
      
    } catch (Exception ex) {
      
      throw new XurmoUserPreferenceRetrievalException(ex);
    }
    javax.persistence.Query q = em.createNamedQuery("XurmoUserPreferenceBlackList.findByUseridAndOtherUserid");
    q.setParameter("userid", userid);
    q.setParameter("otherUserid", fromUserid);
    try {
      
      XurmoUserPreferenceBlackList xupbl = (XurmoUserPreferenceBlackList)q.getSingleResult();
      return true;
    } catch(javax.persistence.NoResultException nre) {
      
      return false;
    } catch (Exception ex) {
      
      throw new XurmoUserPreferenceRetrievalException(ex);
    }
  }
  private static XurmoUserPreferences getUserPreferences(int userid, int linkId, javax.persistence.EntityManager em) throws XurmoUserPreferenceRetrievalException{
    
    javax.persistence.Query q = em.createNamedQuery("XurmoUserPreferences.findByUserid");
    q.setParameter("userid", userid);
    try {
      
      XurmoUserPreferences xup = (XurmoUserPreferences)q.getSingleResult();
      return xup;
    } catch(javax.persistence.NoResultException nrefl) {
      return null;
    } catch (Exception ex) {
      
      throw new XurmoUserPreferenceRetrievalException(ex);
    }
  }
  private static XurmoUserNetworkSpecificPreferences getNetworkSpecificPreferences(int userid, int linkId, javax.persistence.EntityManager em) throws XurmoUserPreferenceRetrievalException{
    
    javax.persistence.Query q = em.createNamedQuery("XurmoUserNetworkSpecificPreferences.findByUseridAndLinkId");
    q.setParameter("userid", userid);
    q.setParameter("linkId", linkId);
    try {
      
      XurmoUserNetworkSpecificPreferences xup = (XurmoUserNetworkSpecificPreferences)q.getSingleResult();
      return xup;
    } catch(javax.persistence.NoResultException nrefl) {
      return null;
    } catch (Exception ex) {
      
      throw new XurmoUserPreferenceRetrievalException(ex);
    }
  }
  private static boolean isConnected(int user1, int user2, javax.persistence.EntityManager em) {
    javax.persistence.Query q = em.createNamedQuery("XurmoNetworkLink.findByUserid1AndUserid2");
    q.setParameter("userid1", user1);
    q.setParameter("userid2", user2);
    java.util.List l = q.getResultList();
    return l.size() > 0;
  }
  
  private static java.util.Vector<Integer> getConnectedUsers(int user, javax.persistence.EntityManager em) {
    java.util.Vector<Integer> listOfConnectedUserIds = new java.util.Vector<Integer>();
    javax.persistence.Query q = em.createNamedQuery("XurmoNetworkLink.findByUserid");
    q.setParameter("userid", user);
    java.util.List l = q.getResultList();
    java.util.Iterator i = l.iterator();
    while (i.hasNext()) {
      XurmoNetworkLink xnl = (XurmoNetworkLink) (i.next());
      if (xnl.xurmoNetworkLinkPK.getUserid1() == user) {
        
        listOfConnectedUserIds.add(new Integer(xnl.xurmoNetworkLinkPK.getUserid2()));
        System.out.println("User connected to " + user + " is " + xnl.xurmoNetworkLinkPK.getUserid2() + " network type " + xnl.xurmoNetworkLinkPK.getLinkId());
      } else {
        
        listOfConnectedUserIds.add(new Integer(xnl.xurmoNetworkLinkPK.getUserid1()));
        System.out.println("User connected to " + user + " is " + xnl.xurmoNetworkLinkPK.getUserid1() + " network type " + xnl.xurmoNetworkLinkPK.getLinkId());
      }
    }
    return listOfConnectedUserIds;
  }
  
  private static boolean isWithInDegrees(int user1, int user2, int incomingDegrees, int maxDegrees, javax.persistence.EntityManager em) {
    if (incomingDegrees + 1 > maxDegrees) {
      return false;
    }
    boolean dc = isConnected(user1, user2, em);
    if (dc) {
      return true;
    }
    java.util.Vector<Integer> listOfConnectedUserIds = getConnectedUsers(user1, em);
    for (int i = 0; i < listOfConnectedUserIds.size(); ++i) {
      boolean res = isWithInDegrees(listOfConnectedUserIds.elementAt(i).intValue(), user2, incomingDegrees + 1, maxDegrees, em);
      if (res) {
        return res;
      }
    }
    return false;
  }
  public static boolean shouldReceiveMessage(int userid, int fromUserid, int linkId, javax.persistence.EntityManager em) {
    try {
      
      // Check black list
      if (isInBlackList(userid, fromUserid, linkId, em)) {
        return false;
      }
      // Check white list
      if (isInWhiteList(userid, fromUserid, linkId, em)) {
        return true;
      }
      // Check network specific preferences
      int degrees = 0;
      XurmoUserNetworkSpecificPreferences xunsp = getNetworkSpecificPreferences(userid, linkId, em);
      if (xunsp != null) {
        degrees = xunsp.getReceiveDefaultMessagesDegrees();
      } else {
        
        XurmoUserPreferences xup = getUserPreferences(userid, linkId, em);
        if (xup != null) {
          degrees = xup.getReceiveDefaultMessagesDegrees();
        } else {
          return false;
        }
        if (isWithInDegrees(userid, fromUserid, 0, degrees, em)) {
          return true;
        } else {
          return false;
        }
      }
      // Check global preferences
    } catch(XurmoUserPreferenceRetrievalException xupre ) {
      return false;
    }
    return false;
  }
  public static boolean shouldAllowSearchIntoNetwork(int userid, int fromUserid, int linkId, javax.persistence.EntityManager em) {
    
    try {
      
      // Check black list
      if (isInBlackList(userid, fromUserid, linkId, em)) {
        return false;
      }
      // Check white list
      if (isInWhiteList(userid, fromUserid, linkId, em)) {
        return true;
      }
      // Check network specific preferences
      XurmoUserNetworkSpecificPreferences xunsp = getNetworkSpecificPreferences(userid, linkId, em);
      if (xunsp != null) {
        return xunsp.getAllowSearchIntoYourNetwork();
      } else {
        
        XurmoUserPreferences xup = getUserPreferences(userid, linkId, em);
        if (xup != null) {
          return xup.getAllowSearchIntoYourNetwork();
        }
      }
      // Check global preferences
    } catch(XurmoUserPreferenceRetrievalException xupre ) {
    }
    return false;
  }
  public static boolean shouldForwardMessagesOnDestinationPreferences(int userid, int fromUserid, int linkId, javax.persistence.EntityManager em) {
    
    try {
      
      // Check black list
      if (isInBlackList(userid, fromUserid, linkId, em)) {
        return false;
      }
      // Check white list
      if (isInWhiteList(userid, fromUserid, linkId, em)) {
        return true;
      }
      // Check network specific preferences
      XurmoUserNetworkSpecificPreferences xunsp = getNetworkSpecificPreferences(userid, linkId, em);
      if (xunsp != null) {
        return xunsp.getForwardMessagesOnDestinationPreferences();
      } else {
        
        XurmoUserPreferences xup = getUserPreferences(userid, linkId, em);
        if (xup != null) {
          return xup.getForwardMessagesOnDestinationPreferences();
        }
      }
      // Check global preferences
    } catch(XurmoUserPreferenceRetrievalException xupre ) {
    }
    return false;
  }
  public static boolean shouldForwardMessagesToExternalNetworks(int userid, int fromUserid, int linkId, javax.persistence.EntityManager em) {
    
    try {
      
      // Check black list
      if (isInBlackList(userid, fromUserid, linkId, em)) {
        return false;
      }
      // Check white list
      if (isInWhiteList(userid, fromUserid, linkId, em)) {
        return true;
      }
      // Check network specific preferences
      XurmoUserNetworkSpecificPreferences xunsp = getNetworkSpecificPreferences(userid, linkId, em);
      if (xunsp != null) {
        return xunsp.getForwardMessagesToExternalNetworks();
      } else {
        
        XurmoUserPreferences xup = getUserPreferences(userid, linkId, em);
        if (xup != null) {
          return xup.getForwardMessagesToExternalNetworks();
        }
      }
      // Check global preferences
    } catch(XurmoUserPreferenceRetrievalException xupre ) {
    }
    return false;
  }
  public static boolean shouldReceivePersonalEvenReminders(int userid, int fromUserid, int linkId, javax.persistence.EntityManager em) {
    try {
      
      // Check black list
      if (isInBlackList(userid, fromUserid, linkId, em)) {
        return false;
      }
      // Check white list
      if (isInWhiteList(userid, fromUserid, linkId, em)) {
        return true;
      }
      // Check network specific preferences
      XurmoUserNetworkSpecificPreferences xunsp = getNetworkSpecificPreferences(userid, linkId, em);
      if (xunsp != null) {
        return xunsp.getReceivePersonalEventReminders();
      } else {
        
        XurmoUserPreferences xup = getUserPreferences(userid, linkId, em);
        if (xup != null) {
          return xup.getReceivePersonalEventReminders();
        }
      }
      // Check global preferences
    } catch(XurmoUserPreferenceRetrievalException xupre ) {
    }
    return false;
  }
  public static XurmoUserPreferenceDetails getUserPreferences(int userid, javax.persistence.EntityManager em) {
    
    XurmoUserPreferences xup = null;
    try {
      
      javax.persistence.Query q = em.createNamedQuery("XurmoUserPreferences.findByUserid");
      q.setParameter("userid", userid);
      xup = (XurmoUserPreferences)(q.getSingleResult());
    } catch(javax.persistence.NoResultException nre) {
      return new XurmoUserPreferenceDetails(userid);
    }
    
    
    javax.persistence.Query q = em.createNamedQuery("XurmoUserPreferenceWhiteList.findByUserid");
    q.setParameter("userid", userid);
    java.util.List l = q.getResultList();
    int[] white = new int[l.size()];
    java.util.Iterator itr = l.iterator();
    int k = 0;
    while (itr.hasNext()) {
      
      white[k] = ((XurmoUserPreferenceWhiteList)(itr.next())).xurmoUserPreferenceWhiteListPK.getOtherUserid();
      ++k;
    }
    
    q = em.createNamedQuery("XurmoUserPreferenceBlackList.findByUserid");
    q.setParameter("userid", userid);
    l = q.getResultList();
    int[] black = new int[l.size()];
    itr = l.iterator();
    k = 0;
    while (itr.hasNext()) {
      black[k] = ((XurmoUserPreferenceBlackList)(itr.next())).xurmoUserPreferenceBlackListPK.getOtherUserid();
      ++k;
    }
    
    q = em.createNamedQuery("XurmoUserNetworkSpecificPreferences.findByUserid");
    q.setParameter("userid", userid);
    l = q.getResultList();
    XurmoUserNetworkSpecificPreferenceDetails[] xunspd = new XurmoUserNetworkSpecificPreferenceDetails[l.size()];
    itr = l.iterator();
    k = 0;
    while (itr.hasNext()) {
      XurmoUserNetworkSpecificPreferences xunsp = (XurmoUserNetworkSpecificPreferences)(itr.next());
      javax.persistence.Query nltq = em.createNamedQuery("XurmoNetworkLinkType.findByLinkId");
      nltq.setParameter("linkId", xunsp.xurmoUserNetworkSpecificPreferencesPK.getLinkId());
      XurmoNetworkLinkType xnlt = (XurmoNetworkLinkType)(nltq.getSingleResult());
      xunspd[k]
          = new XurmoUserNetworkSpecificPreferenceDetails(xunsp.xurmoUserNetworkSpecificPreferencesPK.getLinkId(),
          xnlt.getLinkName(),
          xunsp.getReceiveDefaultMessagesDegrees(),
          xunsp.getAllowSearchIntoYourNetwork(),
          xunsp.getForwardMessagesOnDestinationPreferences(),
          xunsp.getForwardMessagesToExternalNetworks(),
          xunsp.getReceivePersonalEventReminders(),
          xunsp.getReceiveInviteFromEverybody());
      ++k;
    }
    
    java.util.HashMap<Integer, java.util.Vector<Integer> > blackListMap;
    blackListMap = new java.util.HashMap<Integer, java.util.Vector<Integer> >();
    q = em.createNamedQuery("XurmoUserNetworkAndUserBlackList.findByUserid");
    q.setParameter("userid", userid);
    itr = q.getResultList().iterator();
    while (itr.hasNext()) {
      XurmoUserNetworkAndUserBlackList xunbl = (XurmoUserNetworkAndUserBlackList)(itr.next());
      Integer ik = new Integer(xunbl.xurmoUserNetworkAndUserBlackListPK.getLinkId());
      java.util.Vector<Integer> v = blackListMap.get(ik);
      if (v == null) {
        
        v = new java.util.Vector<Integer>();
        blackListMap.put(ik, v);
      }
      v.add(new Integer(xunbl.xurmoUserNetworkAndUserBlackListPK.getOtherUserid()));
    }
    
    java.util.HashMap<Integer, java.util.Vector<Integer> > whiteListMap;
    whiteListMap = new java.util.HashMap<Integer, java.util.Vector<Integer> >();
    q = em.createNamedQuery("XurmoUserNetworkAndUserWhiteList.findByUserid");
    q.setParameter("userid", userid);
    itr = q.getResultList().iterator();
    while (itr.hasNext()) {
      XurmoUserNetworkAndUserWhiteList xunbl = (XurmoUserNetworkAndUserWhiteList)(itr.next());
      Integer ik = new Integer(xunbl.xurmoUserNetworkAndUserWhiteListPK.getLinkId());
      java.util.Vector<Integer> v = whiteListMap.get(ik);
      if (v == null) {
        
        v = new java.util.Vector<Integer>();
        whiteListMap.put(ik, v);
      }
      v.add(new Integer(xunbl.xurmoUserNetworkAndUserWhiteListPK.getOtherUserid()));
    }
    
    java.util.Set<Integer> ks1 = blackListMap.keySet();
    java.util.Set<Integer> ks2 = whiteListMap.keySet();
    ks1.addAll(ks2);
    
    java.util.Iterator<Integer> sitr = ks1.iterator();
    XurmoUserNetworkSpecificUserLists[] networkSpecificUserLists
        = new XurmoUserNetworkSpecificUserLists[ks1.size()];
    int j = 0;
    while (sitr.hasNext()) {
      k = sitr.next();
      java.util.Vector<Integer> b = blackListMap.get(k);
      java.util.Vector<Integer> w = blackListMap.get(k);
      int[] blackArray = null;
      int[] whiteArray = null;
      if (b != null) {
        blackArray = new int[b.size()];
        for (int i = 0; i < b.size(); ++i) {
          blackArray[i] = b.elementAt(i).intValue();
        }
      }
      if (w != null) {
        whiteArray = new int[w.size()];
        for (int i = 0; i < b.size(); ++i) {
          whiteArray[i] = w.elementAt(i).intValue();
        }
      }
      javax.persistence.Query nltq = em.createNamedQuery("XurmoNetworkLinkType.findByLinkId");
      nltq.setParameter("linkId", k);
      XurmoNetworkLinkType xnlt = (XurmoNetworkLinkType)(nltq.getSingleResult());
      networkSpecificUserLists[j] = new XurmoUserNetworkSpecificUserLists(k, xnlt.getLinkName(), blackArray, whiteArray);
    }
    
    return new XurmoUserPreferenceDetails(xup.getUserid(),
        xup.getReceiveDefaultMessagesDegrees(),
        xup.getAllowSearchIntoYourNetwork(),
        xup.getForwardMessagesOnDestinationPreferences(),
        xup.getForwardMessagesToExternalNetworks(),
        xup.getReceivePersonalEventReminders(),
        xup.getReceiveReceiveInviteFromEverybody(),
        black,
        white,
        xunspd,
        networkSpecificUserLists);
  }
  public static void setUserPreferences(int userid, XurmoUserPreferenceDetails xupd, javax.persistence.EntityManager em) {
    XurmoUserPreferences xup = null;
    try {
      
      javax.persistence.Query q = em.createNamedQuery("XurmoUserPreferences.findByUserid");
      q.setParameter("userid", userid);
      xup = (XurmoUserPreferences)(q.getSingleResult());
    } catch(javax.persistence.NoResultException nre) {
      xup = new XurmoUserPreferences(userid, xupd.receiveDefaultMessagesDegrees, xupd.allowSearchIntoYourNetwork, xupd.forwardMessagesOnDestinationPreferences, xupd.forwardMessagesToExternalNetworks, xupd.receivePersonalEvenReminders, xupd.receiveInviteFromEverybody);
    }
    em.persist(xup);
    
    javax.persistence.Query q = em.createNamedQuery("XurmoUserPreferenceWhiteList.findByUserid");
    q.setParameter("userid", userid);
    java.util.Iterator itr = q.getResultList().iterator();
    while (itr.hasNext()) {
      em.remove((XurmoUserPreferenceWhiteList)(itr.next()));
    }
    for(int i = 0; i < xupd.white.length; ++i) {
      em.persist(new XurmoUserPreferenceWhiteList(userid, xupd.white[i]));
    }
    
    q = em.createNamedQuery("XurmoUserPreferenceBlackList.findByUserid");
    q.setParameter("userid", userid);
    itr = q.getResultList().iterator();
    while (itr.hasNext()) {
      em.remove((XurmoUserPreferenceBlackList)(itr.next()));
    }
    for(int i = 0; i < xupd.black.length; ++i) {
      em.persist(new XurmoUserPreferenceBlackList(userid, xupd.black[i]));
    }
    
    q = em.createNamedQuery("XurmoUserNetworkSpecificPreferences.findByUserid");
    q.setParameter("userid", userid);
    itr = q.getResultList().iterator();
    while (itr.hasNext()) {
      em.remove((XurmoUserNetworkSpecificPreferences)(itr.next()));
    }
    for(int i = 0; i < xupd.black.length; ++i) {
      XurmoUserNetworkSpecificPreferencesPK xunspPK
          = new XurmoUserNetworkSpecificPreferencesPK(xupd.networkSpecificPreference[i].linkId, userid);
      XurmoUserNetworkSpecificPreferences xunsp = new XurmoUserNetworkSpecificPreferences(xunspPK,
          xupd.networkSpecificPreference[i].receiveDefaultMessagesDegrees,
          xupd.networkSpecificPreference[i].allowSearchIntoYourNetwork,
          xupd.networkSpecificPreference[i].forwardMessagesOnDestinationPreferences,
          xupd.networkSpecificPreference[i].forwardMessagesToExternalNetworks,
          xupd.networkSpecificPreference[i].receivePersonalEventReminders,
          xupd.networkSpecificPreference[i].receiveInviteFromEverybody);
      em.persist(xunsp);
    }
    
    q = em.createNamedQuery("XurmoUserNetworkAndUserBlackList.findByUserid");
    q.setParameter("userid", userid);
    itr = q.getResultList().iterator();
    while (itr.hasNext()) {
      em.remove((XurmoUserNetworkAndUserBlackList)(itr.next()));
    }
    for (int i = 0; i < xupd.networkSpecificUserLists.length; ++i) {
      
      for(int j = 0; j < xupd.networkSpecificUserLists[i].black.length; ++i) {
        XurmoUserNetworkAndUserBlackList xunbl
            = new XurmoUserNetworkAndUserBlackList(xupd.networkSpecificUserLists[i].black[j],
            xupd.networkSpecificUserLists[i].linkId,
            userid);
        em.persist(xunbl);
      }
    }
    
    q = em.createNamedQuery("XurmoUserNetworkAndUserWhiteList.findByUserid");
    q.setParameter("userid", userid);
    itr = q.getResultList().iterator();
    while (itr.hasNext()) {
      em.remove((XurmoUserNetworkAndUserWhiteList)(itr.next()));
    }
    for (int i = 0; i < xupd.networkSpecificUserLists.length; ++i) {
      
      for(int j = 0; j < xupd.networkSpecificUserLists[i].white.length; ++i) {
        XurmoUserNetworkAndUserWhiteList xunwl
            = new XurmoUserNetworkAndUserWhiteList(xupd.networkSpecificUserLists[i].white[j],
            xupd.networkSpecificUserLists[i].linkId,
            userid);
        em.persist(xunwl);
      }
    }
  }
  public static boolean willReceiveMessages(int sourceUserId, int destinationUserId, int dos, int linkId, javax.persistence.EntityManager em) {
    boolean ret = false;
    try {
      
      // Check black list
      if (isInBlackList(destinationUserId, sourceUserId, linkId, em)) {
        return false;
      }
      // Check white list
      if (isInWhiteList(destinationUserId, sourceUserId, linkId, em)) {
        return true;
      }
      // Check network specific preferences
      XurmoUserNetworkSpecificPreferences xunsp = getNetworkSpecificPreferences(destinationUserId, linkId, em);
      int destinationReceiveDegrees = 0;
      if (xunsp != null) {
        return xunsp.getReceiveDefaultMessagesDegrees() >= dos;
      } else {
        
        XurmoUserPreferences xup = getUserPreferences(destinationUserId, linkId, em);
        if (xup != null) {
          return xup.getReceiveDefaultMessagesDegrees() >= dos;
        }
        else {
          return true;
        }
      }
      // Check global preferences
    } catch(XurmoUserPreferenceRetrievalException xupre ) {
    }
    return false;
  }
}
