
package com.xurmo.connect.user;

import javax.ejb.Remote;


/**
 * This is the business interface for XurmoError enterprise bean.
 */
@Remote
public interface XurmoErrorRemote {
    XurmoError[] getErrorMessages();
    
}
