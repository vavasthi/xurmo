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
 * @file   XurmoLoginUserListener.java
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


public class XurmoLoginUserListener implements CommandListener {
    Xurmo midlet_;
    XurmoLoginUserPanel loginForm_;
    
    
    /**
   * Creates a new instance of XurmoLoginUserListener
   */
    public XurmoLoginUserListener(Xurmo midlet, XurmoLoginUserPanel loginForm) {
        midlet_ = midlet;
        loginForm_ = loginForm;
    }
    public void commandAction(Command c,
            Displayable d) {
        
        if (c == loginForm_.exit_) {
            midlet_.exitMIDlet();
        }
        else if (c == loginForm_.register_) {
            midlet_.transitionToRegisterScreen();
        } else if (c == loginForm_.login_) {
            midlet_.currentUser_.setUsernameAndPassword(loginForm_.getUsername(), loginForm_.getPassword());
            midlet_.performLogin();
        }
    }
}
