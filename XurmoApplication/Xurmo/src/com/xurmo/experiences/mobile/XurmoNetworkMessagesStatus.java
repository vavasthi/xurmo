/*
 * XurmoNetworkSummaryStatus.java
 *
 * Created on September 9, 2007, 11:06 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author Vinay
 */
public class XurmoNetworkMessagesStatus {
  XurmoNetworkInteractionStatus status_;
  XurmoRequestToConnectMessage[] messages_;
  XurmoNetworkMessageResponseType[] responseTypes_;
  /** Creates a new instance of XurmoNetworkSummaryStatus */
  public XurmoNetworkMessagesStatus(int errorCode, 
      String cookie, 
      String cellName, 
      java.util.Vector messages,
      java.util.Vector responseTypeList) {
    
    status_ = new XurmoNetworkInteractionStatus(errorCode, cookie, cellName);
    messages_ = new XurmoRequestToConnectMessage[messages.size()];
    for (int i = 0; i < messages.size(); ++i) {
      messages_[i] = (XurmoRequestToConnectMessage)(messages.elementAt(i));
    }
    responseTypes_ = new XurmoNetworkMessageResponseType[responseTypeList.size()];
    for (int i = 0; i < responseTypeList.size(); ++i) {
      responseTypes_[i] = (XurmoNetworkMessageResponseType)(responseTypeList.elementAt(i));
    }
  }
  public XurmoNetworkMessagesStatus() {
    
    status_ = new XurmoNetworkInteractionStatus(XurmoNetworkManagementWSInterface.NETWORK_INTERACTION_SERVER_NOT_AVAILABLE, null, null);
    messages_ = new XurmoRequestToConnectMessage[0];
    responseTypes_ = new XurmoNetworkMessageResponseType[0];
  }
}
