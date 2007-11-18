package com.xurmo.connect.user;

import javax.ejb.*;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.annotation.Resource;


/**
 * This is the bean class for the XurmoMessageManagementService enterprise bean.
 * Created May 4, 2007 7:19:38 PM
 * @author xurmo
 */

@Stateless
@WebService
public class XurmoMessageManagementServiceBean implements javax.ejb.TimedObject {
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
    @EJB
    private XurmoMessageManagementRemote xurmoMessageManagementBean;
    
    private @Resource TimerService ts_;
    static private final Integer messageFlusher_ = 0x01;
    
    /**
     * Web service operation
     */
    @WebMethod
    public XurmoMessageStatus enqueueMessage(@WebParam(name = "sourceId") String sourceId, @WebParam(name = "destinationId") String destinationId, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode, @WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "cellName") String cellName, @WebParam(name = "msg") String msg, @WebParam(name = "cookie") String cookie) {
      return xurmoMessageManagementBean.enqueueMessage(sourceId, destinationId, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, msg, cookie);
    }

    @WebMethod
    public XurmoMessageStatus sendMessageToNetwork(@WebParam(name = "username") String username, @WebParam(name = "cookie") String cookie, @WebParam(name = "linkId") int linkId[], @WebParam(name = "degreesOfSeparation") int degreesOfSeparation, @WebParam(name = "content") String content, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode, @WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "cellName") String cellName) {
      XurmoMessageStatus status = xurmoMessageManagementBean.sendMessageToNetwork(username, cookie, linkId, degreesOfSeparation, content, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName);
      ts_.createTimer(100, messageFlusher_);
      return status;
    }
    @WebMethod
    public XurmoMessages getUserMessages(@WebParam(name = "username") String username, @WebParam(name = "cookie") String cookie, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode, @WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "cellName") String cellName) {
      return xurmoMessageManagementBean.getUserMessages(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName);
    }
    public void ejbTimeout(Timer t) {
    
     int tid = (Integer)(t.getInfo());
     if (tid == messageFlusher_.intValue()) {
      xurmoMessageManagementBean.flushNetworkMessages();
     }
  }
}
