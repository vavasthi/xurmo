/*
 * XurmoInvitePhoneBookEntry.java
 *
 * Created on September 20, 2007, 10:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author Vinay
 */
public class XurmoInvitePhoneBookEntry {
  public String contactName;
  public boolean member;
  public int memberid;
  public String mobileNumber;
  public int uniqueId;
  /** Creates a new instance of XurmoInvitePhoneBookEntry */
  public XurmoInvitePhoneBookEntry(String contactName, 
      boolean member, 
      int memberid, 
      String mobileNumber, 
      int uniqueId) {
  this.contactName = contactName;
  this.member = member;
  this.memberid = memberid;
  this.mobileNumber = mobileNumber;
  this.uniqueId = uniqueId;
  }
  public XurmoInvitePhoneBookEntry(String contactName, 
      String member, 
      String memberid, 
      String mobileNumber, 
      String uniqueId) {
  this.contactName = contactName;
  if (member.equalsIgnoreCase("true")) {
    
    this.member = true;
  }
  else {
    this.member = false;
  }
  this.memberid = Integer.parseInt(memberid);
  this.mobileNumber = mobileNumber;
  this.uniqueId = Integer.parseInt(uniqueId);
  }
}
