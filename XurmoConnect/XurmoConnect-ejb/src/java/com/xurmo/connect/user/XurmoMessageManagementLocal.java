
package com.xurmo.connect.user;

import javax.ejb.Local;


/**
 * This is the business interface for XurmoMessageManagement enterprise bean.
 */
@Local
public interface XurmoMessageManagementLocal {
    
    XurmoMessageStatus enqueueMessage(String sourceId, String destinationId, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString, String msg, String cookie);

  XurmoMessageStatus sendMessageToNetwork(String username, String cookie, int linkId[], int degreesOfSeparation, String content, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String cellName);
  XurmoMessages getUserMessages(String username, String cookie, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String cellName);
  void flushNetworkMessages();
}
