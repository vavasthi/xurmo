// =====================================================================
//                           Xurmo Proprietary
//               (c) Copyright 2007, Xurmo, All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          August 14, 2007
// =====================================================================

/**
 *
 * @file   XurmoRegisterUserListener.java
 * @author
 * @date   August 14, 2007
 *
 * @brief
 *
 *
 */
// *********************************************************************
// Package
// *********************************************************************
package com.xurmo.experiences.mobile;
// *********************************************************************
// Imports
// *********************************************************************
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;


public class XurmoRegisterUserListener implements CommandListener {
    
    Xurmo midlet_;
    XurmoRegisterUserPanel registerForm_;
    
    /**
   * Creates a new instance of XurmoRegisterUserListener
   */
    public XurmoRegisterUserListener(Xurmo midlet, XurmoRegisterUserPanel registerForm) {
        registerForm_ = registerForm;
        midlet_ = midlet;
    }
    private XurmoUserAuthenticationReturnStatus registerAndLoginUser() {
        
        XurmoUserAuthenticationReturnStatus status
                = XurmoUserAuthenticationAndSessionWSInterface.registerUser(registerForm_.getUsername(),
                registerForm_.getPassword(),
                registerForm_.getSalutation(),
                registerForm_.getFirstName(),
                registerForm_.getLastName(),
                registerForm_.getMobileNumber(),
                registerForm_.getEmail(),
                registerForm_.getGender(),
                registerForm_.getDob());
        
        if (status != null && XurmoUserAuthenticationAndSessionWSInterface.isAuthenticationStatusSuccessful(status.errorCode_)) {
            midlet_.currentUser_.setUsernameAndPassword(registerForm_.getUsername(), registerForm_.getPassword());
            return midlet_.performLogin();
        }
        return status;
    }
    public void commandAction(Command cmd, Displayable c) {
        
        if (cmd == registerForm_.register_) {
            if (registerForm_.getPassword().equals(registerForm_.getReenterPassword())) {
                
                XurmoUserAuthenticationReturnStatus status = registerAndLoginUser();
                if (status != null && XurmoUserAuthenticationAndSessionWSInterface.isAuthenticationStatusSuccessful(status.errorCode_)) {
                    midlet_.transitionToHomeScreen();
                } else {
                    midlet_.showAlert("Registration Failed", XurmoUserAuthenticationAndSessionWSInterface.getAuthenticationStringMessage(status), null);
                }
            } else {
                
                midlet_.showAlert("Passwords don't match", "Two passwords do not match. Please correct and then try.", null);
            }
        }
        else if(cmd == registerForm_.login_) {
            midlet_.transitionToLoginScreen();
        }
        else if (cmd == registerForm_.exit_) {
            midlet_.exitMIDlet();
        }
    }
}
