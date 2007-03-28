/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoElectronicAddress.java
 * Created on               : March 28, 2007, 10:59 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;
import java.io.Serializable;

/**
 *
 * @author xurmo
 */
public class XurmoElectronicAddress implements Serializable {
    
    /** Creates a new instance of XurmoElectronicAddress */
    public XurmoElectronicAddress(String addressType, String address) {
        
        addressType_ = addressType;
        address_ = address;
    }
    public String getAddressType() {
        return addressType_;
    }
    public String getAddress() {
        return address_;
    }
    private String addressType_;
    private String address_;
}
