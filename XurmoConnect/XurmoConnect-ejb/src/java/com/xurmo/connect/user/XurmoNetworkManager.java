/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoNetworkManager.java
 * Created on               : April 1, 2007, 10:26 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import org.jboss.util.platform.Java;

/**
 *
 * @author xurmo
 */
public class XurmoNetworkManager {
  
  public static String[] memberOfNetworks(int userid, javax.persistence.EntityManager em) {
    javax.persistence.Query q = em.createNamedQuery("XurmoNetworkLinkType.findUniqueByUserid");
    q.setParameter("userid", userid);
    java.util.List l = q.getResultList();
    java.util.Iterator li = l.iterator();
    String[] out = new String[l.size()];
    int i = 0;
    while (li.hasNext()) {
      XurmoNetworkLinkType xnlt = (XurmoNetworkLinkType)li.next();
      out[i] = xnlt.getLinkName();
      ++i;
    }
    return out;
  }
  public static int numberOfContacts(int userid, javax.persistence.EntityManager em) {
    javax.persistence.Query q = em.createNamedQuery("XurmoPersonalAddressBook.findByUserid");
    q.setParameter("userid", userid);
    java.util.List l = q.getResultList();
    return l.size();
  }
  public static XurmoUserGlobalData[] contactsAlreadyUser(String username, javax.persistence.EntityManager em) {
    javax.persistence.Query q = em.createNamedQuery("XurmoUser.findByPersonalAddressBookMatch");
    q.setParameter("username", username);
    java.util.List l = q.getResultList();
    java.util.Iterator itr = l.iterator();
    XurmoUserGlobalData[] out = new XurmoUserGlobalData[l.size()];
    int j = 0;
    while (itr.hasNext()) {
      XurmoUser xu = (XurmoUser)itr.next();
      out[j] = new XurmoUserGlobalData(xu.getUserid(), xu.getUsername(), xu.getFname(), xu.getLname());
      ++j;
    }
    return out;
  }
  public static void convertRequestToJoinToRequestToConnect(int userid, String phoneNumber, javax.persistence.EntityManager em) {
    
    javax.persistence.Query q = em.createNamedQuery("XurmoRequestToJoinInbox.findByPhoneNumber");
    q.setParameter("phoneNumber", phoneNumber);
    java.util.List l = q.getResultList();
    java.util.Iterator itr = l.iterator();
    while (itr.hasNext()) {
      
      XurmoRequestToJoinInbox rtj = (XurmoRequestToJoinInbox)itr.next();
      XurmoRequestToConnectInboxPK pk = new XurmoRequestToConnectInboxPK(userid, rtj.xurmoRequestToJoinInboxPK.getSource());
      XurmoRequestToConnectInbox rtc = new XurmoRequestToConnectInbox(pk);
      rtc.setLinkId(rtj.xurmoRequestToJoinInboxPK.getLinkId());
      rtc.setMsg(rtj.getMsg());
      rtc.setUniqueId(rtj.getUniqueId());
      em.persist(rtc);
      em.remove(rtj);
    }
  }
  public static XurmoNetworkLinkType[] getNetworkLinkTypes(javax.persistence.EntityManager em) {
    
    java.util.List res = em.createNamedQuery("XurmoNetworkLinkType.findAll").getResultList();
    XurmoNetworkLinkType[] out = new XurmoNetworkLinkType[res.size()];
    int i = 0;
    for(java.util.Iterator itr = res.iterator(); itr.hasNext(); ) {
      out[i] = (XurmoNetworkLinkType)(itr.next());
      ++i;
    }
    return out;
  }
  public static XurmoNetworkSummaryStatus getNetworkSummary(String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName, javax.persistence.EntityManager em) {
    
    javax.persistence.Query uq = em.createNamedQuery("XurmoUser.findByUsername");
    uq.setParameter("username", username);
    XurmoUser xu = (XurmoUser)uq.getSingleResult();
    XurmoCellLocationMap xclm
        = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em);
    String[] memberOfNetworks = XurmoNetworkManager.memberOfNetworks(xu.getUserid(), em);
    int numberOfContacts = XurmoNetworkManager.numberOfContacts(xu.getUserid(), em);
    XurmoUserGlobalData[] contactsAlreadyUser = XurmoNetworkManager.contactsAlreadyUser(username, em);
    return new XurmoNetworkSummaryStatus(cookie, xclm.getLocation(), memberOfNetworks, numberOfContacts, contactsAlreadyUser);
  }
  public static XurmoNetworkMessages getNetworkMessages(String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName, javax.persistence.EntityManager em) {
    
    javax.persistence.Query uq = em.createNamedQuery("XurmoUser.findByUsername");
    uq.setParameter("username", username);
    XurmoUser xu = (XurmoUser)uq.getSingleResult();
    XurmoCellLocationMap xclm
        = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em);
    
    javax.persistence.Query rtcq = em.createNamedQuery("XurmoRequestToConnectInbox.findByRequestTo");
    rtcq.setParameter("requestTo", xu.getUserid());
    java.util.List rtcl = rtcq.getResultList();
    XurmoNetworkRequestToConnectMessage[] rtcm = new XurmoNetworkRequestToConnectMessage[rtcl.size()];
    java.util.Iterator rtci = rtcl.iterator();
    int kount = 0;
    while (rtci.hasNext()) {
      XurmoRequestToConnectInbox rtc = (XurmoRequestToConnectInbox)(rtci.next());
      XurmoUser rfu
          = (XurmoUser)(em.createNamedQuery("XurmoUser.findByUserid").setParameter("userid",rtc.xurmoRequestToConnectInboxPK.getRequestFrom()).getSingleResult());
      XurmoNetworkLinkType xnlt = (XurmoNetworkLinkType)(em.createNamedQuery("XurmoNetworkLinkType.findByLinkId").setParameter("linkId", rtc.getLinkId()).getSingleResult());
      rtcm[kount] = new XurmoNetworkRequestToConnectMessage(rfu.getUserid(),
          rfu.getUsername(),
          xu.getUserid(),
          xu.getUsername(),
          rtc.getMessageId(),
          rtc.getLinkId(),
          xnlt.getLinkName(),
          rtc.getMsg());
      ++kount;
    }
    javax.persistence.Query rtcrtq = em.createNamedQuery("XurmoRequestToConnectResponseType.findAll");
    java.util.List rtcrtl = rtcrtq.getResultList();
    XurmoRequestToConnectResponseType rtcrt[] = new XurmoRequestToConnectResponseType[rtcrtl.size()];
    java.util.Iterator rtcrti = rtcrtl.iterator();
    kount = 0;
    while (rtcrti.hasNext()) {
      rtcrt[kount] = (XurmoRequestToConnectResponseType)(rtcrti.next());
      ++kount;
    }
    return new XurmoNetworkMessages(cookie, xclm.getLocation(), rtcm, rtcrt);
  }
}
