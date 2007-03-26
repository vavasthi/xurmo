package com.xurmo.connect.user.webservice;

import com.xurmo.connect.user.XurmoUserAuthenticationRemote;
import javax.ejb.*;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * This is the bean class for the RegisterUser enterprise bean.
 * Created Mar 26, 2007 9:00:56 PM
 * @author xurmo
 */

@Stateless
@WebService
public class RegisterUserBean {
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
    @EJB
    private XurmoUserAuthenticationRemote xurmoUserAuthenticationBean;

    /**
     * Web service operation
     */
    @WebMethod
    public int registerUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "fname") String fname, @WebParam(name = "lname") String lname, @WebParam(name = "primaryMobile") String primaryMobile, @WebParam(name = "primaryEmail") String primaryEmail) {
        // TODO implement operation 
        return xurmoUserAuthenticationBean.registerUser(username, password, fname, lname, primaryMobile, primaryEmail);
    }
}
