
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
            String email,
            String gender,
            Date dob);

    XurmoUserManagementStatus doLogin(String username, String password, String imsi, String siteId, String cellId, String locationString);
    XurmoUserManagementStatus doLogout(String username, String cookie, String imsi, String siteId, String cellId, String locationString);
    XurmoUserManagementStatus updateLocation(String username, String cookie, String imsi, String siteId, String cellId, String locationString);    

    XurmoUploadAddressBookReturnStatus uploadPersonalAddressBook(String username, String cookie, String fullName, XurmoElectronicAddress[] addresses, String email, String imsi, String siteId, String cellId, String locationString);
}
