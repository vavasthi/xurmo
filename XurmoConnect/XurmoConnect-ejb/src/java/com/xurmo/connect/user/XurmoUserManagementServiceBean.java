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
    private XurmoUserManagementRemote xurmoUserAuthenticationBean;

    /**
     * Web service operation
     */
    @WebMethod
    public int createUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "salutation") String salutation, @WebParam(name = "fname") String fname, @WebParam(name = "lname") String lname, @WebParam(name = "mobile") String mobile, @WebParam(name = "email") String email, @WebParam(name = "gender") String gender, @WebParam(name = "dob") Date dob, @WebParam(name = "imei") String imei, @WebParam(name = "btAddress") String btAddress, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode,@WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "cellName") String cellName) {
        // TODO implement operation 
        return xurmoUserAuthenticationBean.registerUser(username, password, salutation, fname, lname, mobile, false, email, false, gender, dob, imei, btAddress, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName);
    }

    /**
     * Web service operation
     */
    @WebMethod
    public XurmoUserHomeScreenData doLogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "imei") String imei, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode,@WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "cellName") String cellName) {
        return xurmoUserAuthenticationBean.doLogin(username, password, imei, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName);
    }

    /**
     * Web service operation
     */
    @WebMethod
    public XurmoUserManagementStatus doLogout(@WebParam(name = "username") String username, @WebParam(name = "cookie") String cookie, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode,@WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "locationString") String locationString) {
        return xurmoUserAuthenticationBean.doLogout(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, locationString);
    }

    /**
     * Web service operation
     */
    @WebMethod
    public XurmoUserManagementStatus updateLocation(@WebParam(name = "username") String username, @WebParam(name = "cookie") String cookie, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode, @WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "locationString") String locationString) {
        return xurmoUserAuthenticationBean.updateLocation(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, locationString);
    }

    /**
     * Web service operation
     */
    @WebMethod
    public XurmoUserHomeScreenData getHomeScreenData(@WebParam(name = "username") String username, @WebParam(name = "cookie") String cookie, @WebParam(name = "imei") String imei,@WebParam(name = "presence") String presence, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode,  @WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "cellName") String cellName) {
        
        return xurmoUserAuthenticationBean.getHomeScreenData(username, cookie, imei, presence, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName);
    }

    /**
     * Web service operation
     */
    @WebMethod
    public XurmoUserManagementStatus uploadPhoneBook(@WebParam(name = "username") String username, @WebParam(name = "cookie") String cookie, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode,  @WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "cellName") String cellName, @WebParam(name = "addressBook") XurmoPhoneAddressBookSync addressBook) {
        
        return xurmoUserAuthenticationBean.uploadPhoneBook(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName, addressBook);
    }
    /**
     * Web service operation
     */
    @WebMethod
    public XurmoPhoneAddressBookSync downloadPhoneBook(@WebParam(name = "username") String username, @WebParam(name = "cookie") String cookie, @WebParam(name = "mobileCountryCode") String mobileCountryCode, @WebParam(name = "mobileNetworkCode") String mobileNetworkCode,  @WebParam(name = "siteId") String siteId, @WebParam(name = "cellId") String cellId, @WebParam(name = "cellName") String cellName) {
        
        return xurmoUserAuthenticationBean.downloadPhoneBook(username, cookie, mobileCountryCode, mobileNetworkCode, siteId, cellId, cellName);
    }
}
