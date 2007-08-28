
package com.xurmo.connect.user;

import javax.ejb.Remote;


/**
 * This is the business interface for XurmoNetworkManagement enterprise bean.
 */
@Remote
public interface XurmoNetworkManagementRemote {
    XurmoInvitationSendStatus sendInvitations(String username, String cookie, XurmoInvitationForLink[] invitations, String msg, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString);
    XurmoNetworkLinkType[] getNetworkTypes(String username, String cookie, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString) throws XurmoCouldNotRetrieveNetworkLinkTypeException;
    XurmoRequestToConnectResponseType[] getRequestToConnectResponseTypes(String username, String cookie, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString) throws XurmoCouldNotRetrieveRequestToConnectResponseTypesException;
    XurmoInvitationDispositionStatus disposeInvitations(String username, String cookie, XurmoInvitationDisposition[] invitationDisposition, String msg);     
}
