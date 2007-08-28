
package com.xurmo.connect.user;

import javax.ejb.Remote;


/**
 * This is the business interface for XurmoMessageManagement enterprise bean.
 */
@Remote
public interface XurmoMessageManagementRemote {
    
    XurmoMessageStatus enqueueMessage(String sourceId, String destinationId, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString, String msg, String cookie);
}
