/*
 * XurmoOtherSocialNetworkDetails.java
 *
 * Created on September 11, 2007, 9:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;
import java.util.Vector;
import java.io.DataOutputStream;
import java.io.DataInputStream;


/**
 *
 * @author Vinay
 */
public class XurmoOtherSocialNetworkDetails {
  
  /** Creates a new instance of XurmoOtherSocialNetworkDetails */
  public XurmoOtherSocialNetworkDetails(String socialNetwork) {
    socialNetwork_ = socialNetwork;
    attributeValueList_ = new Vector(); 
  }
  /** Creates a new instance of XurmoOtherSocialNetworkDetails */
  public XurmoOtherSocialNetworkDetails() {
    socialNetwork_ = null;
    attributeValueList_ = new Vector(); 
  }
  public void add(String attribute, String value) {
    attributeValueList_.addElement(new XurmoAttributeValuePair(attribute, value));
  }
  public void storeTo(DataOutputStream dout) throws java.io.IOException {
    dout.writeUTF(socialNetwork_);
    int attrCount = attributeValueList_.size();
    dout.writeInt(attrCount);
    for (int i = 0; i < attrCount; ++i) {
      ((XurmoAttributeValuePair)(attributeValueList_.elementAt(i))).storeTo(dout);
    }
  }
  public void restoreFrom(DataInputStream din) throws java.io.IOException {
    socialNetwork_ = din.readUTF();
    int attrCount = din.readInt();
    for (int i = 0; i < attrCount; ++i) {
      XurmoAttributeValuePair xavp = new XurmoAttributeValuePair();
      xavp.restoreFrom(din);
      attributeValueList_.addElement(xavp);
    }
  }
  public void clearAttributes() {
    attributeValueList_.removeAllElements();
  }
  public String getAttribute(String attribute) {
    int k = attributeValueList_.size();
    for (int i = 0; i < k; ++i) {
      XurmoAttributeValuePair xavp = (XurmoAttributeValuePair) (attributeValueList_.elementAt(i));
      if (xavp.attribute_.equals(attribute)) {
        return xavp.value_;
      }
    }
    return null;
  }
  String socialNetwork_;
  Vector attributeValueList_;
}
