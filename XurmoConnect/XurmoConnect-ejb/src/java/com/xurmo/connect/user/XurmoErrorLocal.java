
package com.xurmo.connect.user;

import javax.ejb.Local;


/**
 * This is the business interface for XurmoError enterprise bean.
 */
@Local
public interface XurmoErrorLocal {
    XurmoError[] getErrorMessages();
    
}
