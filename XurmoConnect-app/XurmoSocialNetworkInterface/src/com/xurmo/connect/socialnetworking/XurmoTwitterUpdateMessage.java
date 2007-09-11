/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : JaikuUpdateMessage.java
 * Created on               : September 11, 2007, 4:35 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.socialnetworking;

/**
 *
 * @author xurmo
 */
public class XurmoTwitterUpdateMessage {
  
  String username_;
  String password_;
  String country_;
  String city_;
  String location_;
  String presence_;
  
  /** Creates a new instance of JaikuUpdateMessage */
  public XurmoTwitterUpdateMessage(String username, String password, String country, String city, String location, String presence) {
    username_ = username;
    password_ = password;
    country_ = country;
    city_ = city;
    location_ = location;
    presence_ = presence;
  }
  
}
