package com.xurmo.connect.user;

import javax.ejb.*;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * This is the bean class for the XurmoErrorService enterprise bean.
 * Created May 4, 2007 10:08:44 PM
 * @author xurmo
 */

@Stateless
@WebService
public class XurmoErrorServiceBean {
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
    @EJB
    private XurmoErrorRemote xurmoErrorBean;

    /**
     * Web service operation
     */
    @WebMethod
    public XurmoError[] getErrorMessages() {
        // TODO implement operation 
        return xurmoErrorBean.getErrorMessages();
    }
}
