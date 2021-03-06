/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoPhoneContactAttributeValuePair.java
 * Created on               : September 3, 2007, 12:56 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoPhoneContactAttributeValuePair implements java.io.Serializable {
    
    public int attributeId;
    public String value;
    /**
     * Creates a new instance of XurmoPhoneContactAttributeValuePair
     */
    public XurmoPhoneContactAttributeValuePair(int attributeId, String value) {
        
        this.attributeId = attributeId;
        this.value = value;
    }
    
}
