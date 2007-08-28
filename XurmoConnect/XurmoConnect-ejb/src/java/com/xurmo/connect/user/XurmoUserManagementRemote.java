
package com.xurmo.connect.user;

import java.util.Date;
import javax.ejb.Remote;


/**
 * This is the business interface for XurmoUserAuthentication enterprise bean.
 */
@Remote
public interface XurmoUserManagementRemote {
    int registerUser(String username, 
            String password,
            String salutation,
            String fname, 
            String lname, 
            String mobile,
            boolean mobileValidated,
            String email,
            boolean emailValidated,
            String gender,
            Date dob,
            String imei,
            String btAddress,
            String countryId,
            String networkId,
            String siteId,
            String cellId,
            String cellName);

    XurmoUserManagementStatus doLogin(String username, String password, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString);
    XurmoUserManagementStatus doLogout(String username, String cookie, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString);
    XurmoUserManagementStatus updateLocation(String username, String cookie, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString);    

    XurmoUploadAddressBookReturnStatus uploadPersonalAddressBook(String username, String cookie, String fullName, XurmoElectronicAddress[] addresses, String email, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString);
}
