package com.xurmo.connect.user;

import javax.ejb.*;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * This is the bean class for the XurmoNetworkManagementService enterprise bean.
 * Created May 4, 2007 7:32:29 PM
 * @author xurmo
 */

@Stateless
@WebService
public class XurmoNetworkManagementServiceBean {
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
    @EJB
    private XurmoNetworkManagementRemote xurmoNetworkManagementBean;
    /**
     * Web service operation
     */
    @WebMethod
    public XurmoInvitationSendStatus sendInvitation(@WebParam(name = "username") String username, @WebParam(name = "cookie") String cookie, @WebParam(name = "invitationsForLink") XurmoInvitationForLink[] invitationsForLink, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode, @WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "locationString") String locationString) {
        // TODO implement operation 
        return xurmoNetworkManagementBean.sendInvitations(username, cookie, invitationsForLink, mobileCountryCode, mobileNetworkCode, siteId, cellId, locationString);
    }

    /**
     * Web service operation
     */
    @WebMethod
    public XurmoNetworkLinkType[] getNetworkLinkTypes(@WebParam(name = "username") String username, @WebParam(name = "cookie") String cookie, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode, @WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "locationString") String locationString) throws XurmoCouldNotRetrieveNetworkLinkTypeException {
        // TODO implement operation 
        return xurmoNetworkManagementBean.getNetworkTypes(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, locationString);
    }

     /**
     * Web service operation
     */
    @WebMethod
    public XurmoRequestToConnectResponseType[] getRequestToConnectResponseTypes(@WebParam(name = "username") String username, @WebParam(name = "cookie") String cookie, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode, @WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "locationString") String locationString) throws XurmoCouldNotRetrieveRequestToConnectResponseTypesException {
        
        return xurmoNetworkManagementBean.getRequestToConnectResponseTypes(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, locationString);
    }

    /**
     * Web service operation
     */
    @WebMethod
    public XurmoInvitationDispositionStatus disposeInvitations(@WebParam(name = "username") String username, @WebParam(name = "cookie") String cookie, @WebParam(name = "invitationDisposition") XurmoInvitationDisposition[] invitationDisposition, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode,@WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "cellName") String cellName) {
        // TODO implement operation 
        return xurmoNetworkManagementBean.disposeInvitations(username, cookie, invitationDisposition, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName);
    }

    /**
     * Web service operation
     */
    @WebMethod
    public XurmoNetworkSummaryStatus getNetworkSummary(@WebParam(name = "username") String username, @WebParam(name = "cookie") String cookie, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode,@WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "cellName") String cellName) {
        // TODO implement operation 
        return xurmoNetworkManagementBean.getNetworkSummary(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName);
    }

    /**
     * Web service operation
     */
    @WebMethod
    public XurmoInvitationForLink[] getPendingInvitations(@WebParam(name = "username") String username, @WebParam(name = "cookie") String cookie, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode,@WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "cellName") String cellName) {
      return xurmoNetworkManagementBean.getPendingInvitations(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName);
    }
}
