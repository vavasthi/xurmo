
package com.xurmo.connect.user;

import java.util.Date;
import javax.ejb.Local;


/**
 * This is the business interface for XurmoUserAuthentication enterprise bean.
 */
@Local
public interface XurmoUserAuthenticationLocal {
    int registerUser(String username, 
            String password, 
            String salutation,
            String fname, 
            String lname, 
            String mobile, 
            String email,
            String gender,
            Date dob);

    int doLogin(String username, String password, String imsi, String siteId, String cellId, String locationString);
    int doLogout(String username);
    int updateLocation(String username, String cookie, String imsi, String siteId, String cellId, String locationString);
    
}
