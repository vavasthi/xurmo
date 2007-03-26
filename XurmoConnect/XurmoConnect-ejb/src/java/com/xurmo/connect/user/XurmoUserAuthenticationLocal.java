
package com.xurmo.connect.user;

import javax.ejb.Local;


/**
 * This is the business interface for XurmoUserAuthentication enterprise bean.
 */
@Local
public interface XurmoUserAuthenticationLocal {
    int registerUser(String username, 
            String password, 
            String fname, 
            String lname, 
            String mobile, 
            String email);
    
}
