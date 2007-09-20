/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPersonalAddressBookManager.java
 * Created on               : September 3, 2007, 1:13 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoPersonalAddressBookManager {
  
  /**
   * Creates a new instance of XurmoPersonalAddressBookManager
   */
  public XurmoPersonalAddressBookManager() {
  }
  static boolean valid(XurmoPersonalAddressBook pab) {
    return pab != null && pab.xurmoPersonalAddressBookPK != null && pab.getContactName() != null;
  }
  static boolean valid(XurmoPersonalAddressBookAddress paba) {
    return paba != null && paba.xurmoPersonalAddressBookAddressPK != null && paba.getAddress() != null;
  }
  static boolean valid(XurmoPersonalAddressBookEmailAddress pabea) {
    return pabea != null && pabea.xurmoPersonalAddressBookEmailAddressPK != null && pabea.getEmailAddress() != null;
  }
  static boolean valid(XurmoPersonalAddressBookPhoneNumbers pabpn) {
    return pabpn != null && pabpn.xurmoPersonalAddressBookPhoneNumbersPK != null && pabpn.getPhoneNumber() != null;
  }
  private static void identifyAndUpdateAlreadyExistingMembers(int userid, javax.persistence.EntityManager em) {
    
    javax.persistence.Query pabq = em.createNamedQuery("XurmoPersonalAddressBook.findByUserid");
    pabq.setParameter("userid", userid);
    java.util.Iterator pabi = pabq.getResultList().iterator();
    while (pabi.hasNext()) {
      XurmoPersonalAddressBook pab = (XurmoPersonalAddressBook)(pabi.next());
      javax.persistence.Query pabpnq = em.createNamedQuery("XurmoUser.findByUseridAndUniqueIdForPersonalAddressBook");
      pabpnq.setParameter("userid", userid);
      pabpnq.setParameter("uniqueId", pab.xurmoPersonalAddressBookPK.getUniqueId());
      try {
        
        XurmoUser xu = (XurmoUser)(pabpnq.getSingleResult());
        pab.setXurmoMember(true);
        pab.setXurmoMemberUserId(xu.getUserid());
        pab.setXurmoInvitationSent(true);
      } catch(javax.persistence.NoResultException nre) {
        
      }
    }
  }
  public static void identifyAndUpdateExistingPhoneBookEntries(XurmoUser xu, javax.persistence.EntityManager em) {
    
    javax.persistence.Query pabq = em.createNamedQuery("XurmoPersonalAddressBook.findByPhoneNumber");
    pabq.setParameter("phoneNumber", xu.getPrimaryMobile());
    java.util.Iterator pabi = pabq.getResultList().iterator();
    while (pabi.hasNext()) {
      XurmoPersonalAddressBook xpab = (XurmoPersonalAddressBook)pabi.next();
      xpab.setXurmoMember(true);
      xpab.setXurmoMemberUserId(xu.getUserid());
      em.persist(xpab);
    }
  }
  public static XurmoUserHomeScreenData uploadPhoneBook(XurmoUser xus, String cookie, XurmoPhoneAddressBookSync addressBook, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String cellName, javax.persistence.EntityManager em) {
    
    boolean alreadyPopulated = false;
    try {
      
      javax.persistence.Query pabq = em.createNamedQuery("XurmoPersonalAddressBook.findByUserid");
      pabq.setParameter("userid", xus.getUserid());
      alreadyPopulated = !(pabq.getResultList().isEmpty());
    } catch(Exception ex) {
      ex.printStackTrace();
    }
    if (alreadyPopulated) {
      
      System.out.println("Uploadin address book: Total number of contacts are " + addressBook.numberOfContacts());
    } else {
      for (int j = 0; j < addressBook.numberOfContacts(); ++j) {
        
        XurmoPersonalAddressBook pab = addressBook.contactAt(j).getPersonalAddressBookBean(xus.getUserid());
        XurmoPersonalAddressBookAddress[] paba = addressBook.contactAt(j).getPersonalAddressBookAddresses(xus.getUserid());
        XurmoPersonalAddressBookEmailAddress[] pabea = addressBook.contactAt(j).getPersonalAddressBookEmailAddresses(xus.getUserid());
        XurmoPersonalAddressBookPhoneNumbers[] pabpn = addressBook.contactAt(j).getPersonalAddressBookPhoneNumbers(xus.getUserid());
        System.out.println("Uploadin address book: contact No " + j + " " + pab.getContactName() + " phone numbers "+ pabpn + " email addresses " + pabea + " addresses "+ paba);
        if (valid(pab)) {
          
          if (pabpn != null) {
            
            for (int i = 0; i < pabpn.length; ++i) {
              System.out.println("Persistent phone numbers " + i );
              try {
                if (valid(pabpn[i])) {
                  
                  System.out.print(" uid " + pabpn[i].xurmoPersonalAddressBookPhoneNumbersPK.getUniqueId() + " attr id "+ pabpn[i].xurmoPersonalAddressBookPhoneNumbersPK.getAttributeId() + " "+ pabpn[i].xurmoPersonalAddressBookPhoneNumbersPK.getUserid());
                  em.persist(pabpn[i]);
                }
              } catch(Exception ex) {
                System.out.println("Could not persist "+ xus.getUsername() + " phone number " + pabpn[i] + " " +i);
                ex.printStackTrace();
              }
            }
          } else {
            System.out.println("Phone Numbers are null for " + pab.getContactName());
          }
          if (pabea != null) {
            
            for (int i = 0; i < pabea.length; ++i) {
              System.out.println("Persistent email address " + i);
              try {
                
                if (valid(pabea[i])) {
                  
                  System.out.print(" uid " + pabea[i].xurmoPersonalAddressBookEmailAddressPK.getUniqueId() + " attr id "+ pabea[i].xurmoPersonalAddressBookEmailAddressPK.getAttributeId() + " "+ pabea[i].xurmoPersonalAddressBookEmailAddressPK.getUserid());
                  em.persist(pabea[i]);
                }
              } catch(Exception ex) {
                System.out.println("Could not persist "+ xus.getUsername() + " phone number " + pabea[i] + " " +i);
                ex.printStackTrace();
              }
            }
          } else {
            System.out.println("Email addresses are null for " + pab.getContactName());
          }
          if (paba != null) {
            
            for (int i = 0; i < paba.length; ++i) {
              System.out.println("Persistent address " + i);
              try {
                
                if (valid(paba[i])) {
                  
                  System.out.println(" uid" + paba[i].xurmoPersonalAddressBookAddressPK.getUniqueId() + " attr id "+ paba[i].xurmoPersonalAddressBookAddressPK.getAttributeId() + " "+ paba[i].xurmoPersonalAddressBookAddressPK.getUserid());
                  em.persist(paba[i]);
                }
              } catch(Exception ex) {
                System.out.println("Could not persist "+ xus.getUsername() + " phone number " + paba[i] + " " +i);
                ex.printStackTrace();
              }
            }
          } else {
            System.out.println("Email addresses are null for " + pab.getContactName());
          }
          System.out.println("Persistent addressbook ");
          em.persist(pab);
        } else {
          
          System.out.println("Address book entry is invalid for j = " + j);
        }
      }
    }
    identifyAndUpdateAlreadyExistingMembers(xus.getUserid(), em);
    return XurmoUserManager.getHomeScreenData(xus.getUsername(), cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em);
  }
  public static void setInvitationSent(int userid, int uniqueId, javax.persistence.EntityManager em) {
    javax.persistence.Query q = em.createNamedQuery("XurmoPersonalAddressBook.findByUseridAndUniqueId");
    q.setParameter("userid", userid);
    q.setParameter("uniqueId", uniqueId);
    try {
      XurmoPersonalAddressBook pab = (XurmoPersonalAddressBook)q.getSingleResult();
      pab.setXurmoInvitationSent(true);
    }
    catch (javax.persistence.NoResultException nre) {
      
    }
  }
  public static XurmoInvitePhoneBookEntry[] getConnectablePhoneBookEntries(String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName, javax.persistence.EntityManager em) {

    return getPhoneBookEntries("XurmoPersonalAddressBook.findByInviteToConnectEntries", username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em);
  }  
  public static XurmoInvitePhoneBookEntry[] getJoinablePhoneBookEntries(String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName, javax.persistence.EntityManager em) {

    return getPhoneBookEntries("XurmoPersonalAddressBook.findByInviteToJoinEntries", username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em);
  }  
  public static XurmoInvitePhoneBookEntry[] getPhoneBookEntries(String queryName, String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName, javax.persistence.EntityManager em) {
    //TODO implement getInvitablePhoneBookEntries
    XurmoUserSession xus = XurmoUserSessionManager.instance().getSession(username, em);
    if (xus != null && cookie.equals(xus.getCookie())) {
      javax.persistence.Query uq = em.createNamedQuery("XurmoUser.findByUsername");
      uq.setParameter("username", username);
      XurmoUser xu = (XurmoUser)uq.getSingleResult();
      XurmoCellLocationMap xclm
          = XurmoLocationManager.updateLocationMap(mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, em);
      javax.persistence.Query pbq = em.createNamedQuery(queryName);
      pbq.setParameter("userid", xu.getUserid());
      java.util.List l = pbq.getResultList();
      java.util.Vector<XurmoInvitePhoneBookEntry> retValue = new java.util.Vector<XurmoInvitePhoneBookEntry>();
      java.util.Iterator i = l.iterator();
      while (i.hasNext()) {
        XurmoPersonalAddressBook pab = (XurmoPersonalAddressBook)(i.next());
        javax.persistence.Query pabpnq = em.createNamedQuery("XurmoPersonalAddressBookPhoneNumbers.findByUseridAndAttributeId");
        pabpnq.setParameter("userid", xu.getUserid());
        pabpnq.setParameter("attributeId", 16);
        try {
          
        XurmoPersonalAddressBookPhoneNumbers pabpn = (XurmoPersonalAddressBookPhoneNumbers)pabpnq.getSingleResult();
        retValue.add(new XurmoInvitePhoneBookEntry(pab.xurmoPersonalAddressBookPK.getUniqueId(),
            pab.getXurmoMember(),
            pab.getXurmoMemberUserId(),
            pab.getContactName(),
            pabpn.getPhoneNumber()));
        }
        catch(javax.persistence.NoResultException nre) {
          
        }
      }
      XurmoInvitePhoneBookEntry[] retArray = new XurmoInvitePhoneBookEntry[retValue.size()];
      return retValue.toArray(retArray);
    }
    //TODO implement getNetworkSummary
    return null;
  }  
}
