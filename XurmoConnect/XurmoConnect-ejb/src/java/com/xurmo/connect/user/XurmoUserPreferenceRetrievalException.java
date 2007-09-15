/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserPreferenceRetrievalException.java
 * Created on               : September 15, 2007, 11:26 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

/**
 *
 * @author xurmo
 */
public class XurmoUserPreferenceRetrievalException extends java.lang.Exception {
  
  /** Creates a new instance of XurmoUserPreferenceRetrievalException */
  public XurmoUserPreferenceRetrievalException(Exception original) {
    original_ = original;
  }
  Exception original_;
}
