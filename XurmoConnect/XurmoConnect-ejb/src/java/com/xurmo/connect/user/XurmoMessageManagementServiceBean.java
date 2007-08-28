package com.xurmo.connect.user;

import javax.ejb.*;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * This is the bean class for the XurmoMessageManagementService enterprise bean.
 * Created May 4, 2007 7:19:38 PM
 * @author xurmo
 */

@Stateless
@WebService
public class XurmoMessageManagementServiceBean {
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
    @EJB
    private XurmoMessageManagementRemote xurmoMessageManagementBean;
    /**
     * Web service operation
     */
    @WebMethod
    public XurmoMessageStatus enqueueMessage(@WebParam(name = "sourceId") String sourceId, @WebParam(name = "destinationId") String destinationId, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode, @WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "locationString") String locationString, @WebParam(name = "msg") String msg, @WebParam(name = "cookie") String cookie) {
      return xurmoMessageManagementBean.enqueueMessage(sourceId, destinationId, mobileCountryCode, mobileNetworkCode, siteId, cellId, locationString, msg, cookie);
    }

}
