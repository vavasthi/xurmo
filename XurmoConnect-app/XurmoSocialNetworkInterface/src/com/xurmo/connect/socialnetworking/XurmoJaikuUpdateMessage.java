/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoJaikuUpdateMessage.java
 * Created on               : September 11, 2007, 4:35 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.socialnetworking;

/**
 *
 * @author xurmo
 */
public class XurmoJaikuUpdateMessage {
  
  String username_;
  String personalKey_;
  String country_;
  String city_;
  String location_;
  String presence_;
  
  /**
   * Creates a new instance of XurmoJaikuUpdateMessage
   */
  public XurmoJaikuUpdateMessage(String username, String personalKey, String country, String city, String location, String presence) {
    username_ = username;
    personalKey_ = personalKey;
    country_ = country;
    city_ = city;
    location_ = location;
    presence_ = presence;
  }
  
}
