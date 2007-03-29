package com.xurmo.connect.user;

import java.util.Date;
import javax.ejb.*;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * This is the bean class for the UserManagementService enterprise bean.
 * Created Mar 27, 2007 6:39:55 PM
 * @author xurmo
 */

@Stateless
@WebService
public class XurmoUserManagementServiceBean {
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
    @EJB
    private XurmoUserAuthenticationRemote xurmoUserAuthenticationBean;

    /**
     * Web service operation
     */
    @WebMethod
    public int createUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "salutation") String salutation, @WebParam(name = "fname") String fname, @WebParam(name = "lname") String lname, @WebParam(name = "mobile") String mobile, @WebParam(name = "email") String email, @WebParam(name = "gender") String gender, @WebParam(name = "dob") Date dob) {
        // TODO implement operation 
        return xurmoUserAuthenticationBean.registerUser(username, password, salutation, fname, lname, mobile, email, gender, dob);
    }

    /**
     * Web service operation
     */
    @WebMethod
    public XurmoUserAuthenticationReturnStatus doLogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "imsi") String imsi, @WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "locationString") String locationString) {
        return xurmoUserAuthenticationBean.doLogin(username, password, imsi, siteId, cellId, locationString);
    }

    /**
     * Web service operation
     */
    @WebMethod
    public int doLogout(@WebParam(name = "username") String username) {
        return xurmoUserAuthenticationBean.doLogout(username);
    }

    /**
     * Web service operation
     */
    @WebMethod
    public XurmoUserAuthenticationReturnStatus updateLocation(@WebParam(name = "username") String username, @WebParam(name = "cookie") String cookie, @WebParam(name = "imsi") String imsi, @WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "locationString") String locationString) {
        return xurmoUserAuthenticationBean.updateLocation(username, cookie, imsi, siteId, cellId, locationString);
    }

    /**
     * Web service operation
     */
    @WebMethod
    public XurmoUploadAddressBookReturnStatus uploadPersonalAddressBook(@WebParam(name = "username") String username, @WebParam(name = "cookie") String cookie, @WebParam(name = "fullName") String fullName, @WebParam(name = "addresses") XurmoElectronicAddress[] addresses, @WebParam(name = "email") String email) {
        // TODO implement operation 
        return xurmoUserAuthenticationBean.uploadPersonalAddressBook(username, cookie, fullName, addresses, email);
    }
}
