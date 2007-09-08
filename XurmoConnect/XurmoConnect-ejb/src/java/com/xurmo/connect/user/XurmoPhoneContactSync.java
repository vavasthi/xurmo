/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPhoneContactSync.java
 * Created on               : September 3, 2007, 12:52 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.util.Date;
import java.util.Vector;
import java.util.HashMap;

/**
 *
 * @author xurmo
 */
public class XurmoPhoneContactSync implements java.io.Serializable {
    
    public int uniqueId;
    public String contactName;
    public String nickName;
    public Date birthday;
    
    
    public XurmoPhoneContactAttributeValuePair[] phoneNumbers;
    public XurmoPhoneContactAttributeValuePair[] emailAddresses;
    public XurmoPhoneContactAttributeValuePair[] addresses;
    
    /**
     * Creates a new instance of XurmoPhoneContactSync
     */
    public XurmoPhoneContactSync() {
        this.uniqueId = 0;
        this.contactName = new String("");
        this.nickName = new String("");
        this.birthday = null;
        phoneNumbers = null;
        emailAddresses = null;
        addresses = null;
    }
    /**
     * Creates a new instance of XurmoPhoneContactSync
     */
    public XurmoPhoneContactSync(int uniqueId, String contactName, String nickName, Date birthday) {
        this.uniqueId = uniqueId;
        this.contactName = contactName;
        this.nickName = nickName;
        this.birthday = birthday;
        phoneNumbers = null;
        emailAddresses = null;
        addresses = null;
    }
    XurmoPersonalAddressBook getPersonalAddressBookBean(int userid) {
        XurmoPersonalAddressBookPK pk = new XurmoPersonalAddressBookPK(uniqueId, userid);
        XurmoPersonalAddressBook bean = new XurmoPersonalAddressBook(pk);
        bean.setBirthday(this.birthday);
        bean.setContactName(this.contactName);
        if (nickName == null) {
            bean.setNickname(new String(""));
        }
        else {
            
            bean.setNickname(nickName);
        }
        return bean;
    }
    XurmoPersonalAddressBookEmailAddress[] getPersonalAddressBookEmailAddresses(int userid) {
        if (emailAddresses == null || emailAddresses.length == 0) {
            return null;
        } else {
            XurmoPersonalAddressBookEmailAddress[] out = new XurmoPersonalAddressBookEmailAddress[emailAddresses.length];
            for (int i = 0; i < emailAddresses.length; ++i) {
                System.out.println("USER ID " + userid + "entry " + i + " unique Id " + uniqueId + " attribute Id " + emailAddresses[i].attributeId + " value " + emailAddresses[i].value);
                out[i] = new XurmoPersonalAddressBookEmailAddress(userid, i, this.uniqueId, emailAddresses[i].attributeId, emailAddresses[i].value);
            }
            return out;
        }
    }
    XurmoPersonalAddressBookPhoneNumbers[] getPersonalAddressBookPhoneNumbers(int userid) {
        System.out.print("Phone Numbers " + phoneNumbers);
        if (phoneNumbers == null || phoneNumbers.length == 0) {
            System.out.println(" zero phone numbers and null returned");
            return null;
        } else {
            XurmoPersonalAddressBookPhoneNumbers[] out = new XurmoPersonalAddressBookPhoneNumbers[phoneNumbers.length];
            System.out.println(" non zero phone numbers and array with length " + phoneNumbers.length + " returned.");
            for (int i = 0; i < phoneNumbers.length; ++i) {
                System.out.println("USER ID " + userid + "entry " + i + " unique Id " + uniqueId + " attribute Id " + phoneNumbers[i].attributeId + " value " + phoneNumbers[i].value);
                out[i] = new XurmoPersonalAddressBookPhoneNumbers(userid, i, this.uniqueId, phoneNumbers[i].attributeId, phoneNumbers[i].value);
            }
            return out;
        }
    }
    XurmoPersonalAddressBookAddress[] getPersonalAddressBookAddresses(int userid) {
        if (addresses == null || addresses.length == 0) {
            return null;
        } else {
            XurmoPersonalAddressBookAddress[] out = new XurmoPersonalAddressBookAddress[addresses.length];
            for (int i = 0; i < addresses.length; ++i) {
                System.out.println("USER ID " + userid + "entry " + i + " unique Id " + uniqueId + " attribute Id " + addresses[i].attributeId + " value " + addresses[i].value);
                out[i] = new XurmoPersonalAddressBookAddress(userid, i, this.uniqueId, this.addresses[i].attributeId, addresses[i].value);
            }
            return out;
        }
    }
}
