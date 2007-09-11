/*
 * XurmoAttributeValuePair.java
 *
 * Created on September 11, 2007, 9:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;
import java.io.DataOutputStream;
import java.io.DataInputStream;

/**
 *
 * @author Vinay
 */
public class XurmoAttributeValuePair {
  
  /** Creates a new instance of XurmoAttributeValuePair */
  public XurmoAttributeValuePair(String attribute, String value) {
    
    attribute_ = attribute;
    value_ = value;
  }
  /** Creates a new instance of XurmoAttributeValuePair */
  public XurmoAttributeValuePair() {
    
    attribute_ = null;
    value_ = null;
  }
  public void storeTo(DataOutputStream dout) throws java.io.IOException {
    dout.writeUTF(attribute_);
    dout.writeUTF(value_);
  }
  public void restoreFrom(DataInputStream din) throws java.io.IOException {
    attribute_ = din.readUTF();
    value_ = din.readUTF();
  }
  String attribute_;
  String value_;
}
