/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPhoneAddressBookSync.java
 * Created on               : September 3, 2007, 12:52 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author xurmo
 */
public class XurmoPhoneAddressBookSync implements java.io.Serializable {

    public int uniqueId;
    public String contactName;
    public String nickName;
    public Date birthday;
    
    private Vector<XurmoPhoneAddressBookAttributeValuePair> phoneNumbers;
    private Vector<XurmoPhoneAddressBookAttributeValuePair> emailAddresses;
    private Vector<XurmoPhoneAddressBookAttributeValuePair> addresses;
    
    public XurmoPhoneAddressBookAttributeValuePair[] get_phoneNumbers() {
        XurmoPhoneAddressBookAttributeValuePair[] t = new XurmoPhoneAddressBookAttributeValuePair[phoneNumbers.size()];
        return phoneNumbers.toArray(t);
    }
    public XurmoPhoneAddressBookAttributeValuePair[] get_emailAddresses() {
        
        XurmoPhoneAddressBookAttributeValuePair[] t = new XurmoPhoneAddressBookAttributeValuePair[emailAddresses.size()];
        return emailAddresses.toArray(t);
    }
    public XurmoPhoneAddressBookAttributeValuePair[] get_addresses() {
        
        XurmoPhoneAddressBookAttributeValuePair[] t = new XurmoPhoneAddressBookAttributeValuePair[addresses.size()];
        return addresses.toArray(t);
    }
    
    /** Creates a new instance of XurmoPhoneAddressBookSync */
    public XurmoPhoneAddressBookSync(int uniqueId, String contactName, String nickName, Date birthday) {
        this.uniqueId = uniqueId;
        this.contactName = contactName;
        this.nickName = nickName;
        this.birthday = birthday;
        phoneNumbers = new Vector<XurmoPhoneAddressBookAttributeValuePair>();
        emailAddresses = new Vector<XurmoPhoneAddressBookAttributeValuePair>();
        addresses = new Vector<XurmoPhoneAddressBookAttributeValuePair>();
    }
    void addPhoneNumber(int type, String value) {
        XurmoPhoneAddressBookAttributeValuePair t = new XurmoPhoneAddressBookAttributeValuePair(type, value);
        phoneNumbers.add(t);
    }
    void addEmailAddress(int type, String value) {
        XurmoPhoneAddressBookAttributeValuePair t = new XurmoPhoneAddressBookAttributeValuePair(type, value);
        emailAddresses.add(t);
    }
    void addAddress(int type, String value) {
        XurmoPhoneAddressBookAttributeValuePair t = new XurmoPhoneAddressBookAttributeValuePair(type, value);
        addresses.add(t);
    }
    XurmoPersonalAddressBook getPersonalAddressBookBean(int userid) {
        XurmoPersonalAddressBookPK pk = new XurmoPersonalAddressBookPK(uniqueId, userid);
        XurmoPersonalAddressBook bean = new XurmoPersonalAddressBook(pk);
        bean.setBirthday(this.birthday);
        bean.setContactName(this.contactName);
        bean.setNickname(nickName);
        return bean;
    }
    XurmoPersonalAddressBookEmailAddress[] getPersonalAddressBookEmailAddresses(int userid) {
        if (this.emailAddresses.size() == 0) {
            return new XurmoPersonalAddressBookEmailAddress[0];
        }
        else {
            XurmoPersonalAddressBookEmailAddress[] out = new XurmoPersonalAddressBookEmailAddress[emailAddresses.size()];
            for (int i = 0; i < emailAddresses.size(); ++i) {
                out[i] = new XurmoPersonalAddressBookEmailAddress(userid, this.uniqueId, emailAddresses.elementAt(i).attributeId, emailAddresses.elementAt(i).value);
            }
            return out;                
        }
    }
    XurmoPersonalAddressBookPhoneNumbers[] getPersonalAddressBookPhoneNumbers(int userid) {
        if (this.phoneNumbers.size() == 0) {
            return new XurmoPersonalAddressBookPhoneNumbers[0];
        }
        else {
            XurmoPersonalAddressBookPhoneNumbers[] out = new XurmoPersonalAddressBookPhoneNumbers[phoneNumbers.size()];
            for (int i = 0; i < emailAddresses.size(); ++i) {
                out[i] = new XurmoPersonalAddressBookPhoneNumbers(userid, this.uniqueId, phoneNumbers.elementAt(i).attributeId, phoneNumbers.elementAt(i).value);
            }
            return out;                
        }
    }
    XurmoPersonalAddressBookAddress[] getPersonalAddressBookAddresses(int userid) {
        if (this.addresses.size() == 0) {
            return new XurmoPersonalAddressBookAddress[0];
        }
        else {
            XurmoPersonalAddressBookAddress[] out = new XurmoPersonalAddressBookAddress[addresses.size()];
            for (int i = 0; i < addresses.size(); ++i) {
                out[i] = new XurmoPersonalAddressBookAddress(userid, this.uniqueId, this.addresses.elementAt(i).attributeId, addresses.elementAt(i).value);
            }
            return out;                
        }
    }
}
