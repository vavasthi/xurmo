
package com.xurmo.connect.user;

import javax.ejb.Remote;


/**
 * This is the business interface for XurmoUserAuthentication enterprise bean.
 */
@Remote
public interface XurmoUserAuthenticationRemote {
    int registerUser(String username, 
            String password, 
            String fname, 
            String lname, 
            String mobile, 
            String email);
    
}
