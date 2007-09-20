
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

    XurmoUserHomeScreenData doLogin(String username, String password, String imei, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString);
    XurmoUserManagementStatus doLogout(String username, String cookie, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString);
    XurmoUserManagementStatus updateLocation(String username, String cookie, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String locationString);    

    XurmoUserHomeScreenData getHomeScreenData(String username, String cookie, String imei, String presence, String twitterUsername, String twitterPassword, String jaikuUsername, String jaikuPersonalKey, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName);

    XurmoUserHomeScreenData uploadPhoneBook(String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName,XurmoPhoneAddressBookSync addressBook);

    XurmoPhoneAddressBookSync downloadPhoneBook(String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName);

  XurmoUserPreferenceDetails getUserPreferences(String username, String cookie, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName);
    XurmoUserManagementStatus setUserPreferences(String username, String cookie, XurmoUserPreferenceDetails xupd, String mobileCountryCode, String mobileNetworkCode,  String siteId, String cellId, String cellName);
}
