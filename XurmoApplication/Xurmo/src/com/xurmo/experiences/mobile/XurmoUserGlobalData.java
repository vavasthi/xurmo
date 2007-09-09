/*
 * XurmoUserGlobalData.java
 *
 * Created on September 9, 2007, 10:47 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;
/**
 *
 * @author Vinay
 */
public class XurmoUserGlobalData {
  
  String fname_;
  String lname_;
  int userid_;
  String username_;
  /** Creates a new instance of XurmoUserGlobalData */
  public XurmoUserGlobalData(int userid, String username, String fname, String lname) {
    
    userid_ = userid;
    username_ = username;
    fname_ = fname;
    lname_ = lname;
  }
  
}
