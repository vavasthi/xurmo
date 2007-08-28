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
 * @file   XurmoRegisterUserPanel.java
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

import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Form;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Font;

public class XurmoRegisterUserPanel extends Form {
    
    private TextField username_;
    private TextField password_;
    private TextField reenterPassword_;
    private TextField salutation_;
    private TextField firstName_;
    private TextField lastName_;
    private TextField mobileNumber_;
    private TextField email_;
    private TextField gender_;
    private TextField dob_;
    
    Command login_;
    Command exit_;
    Command register_;
    
    /**
   * Creates a new instance of XurmoRegisterUserPanel
   */
    public XurmoRegisterUserPanel() {
        super("Sign Up");
        username_ = new TextField("Username",null, 32, TextField.ANY);
        append(username_);
        password_ = new TextField("Password",null, 32, TextField.PASSWORD);
        append(password_);
        reenterPassword_ = new TextField("Reenter Password",null, 32, TextField.PASSWORD);
        append(reenterPassword_);
        salutation_ = new TextField("Salutation",null, 64, TextField.ANY);
        append(salutation_);
        firstName_ = new TextField("First Name",null, 64, TextField.ANY);
        append(firstName_);
        lastName_ = new TextField("Last Name",null, 64, TextField.ANY);
        append(lastName_);
        mobileNumber_ = new TextField("Mobile Number",null, 64, TextField.PHONENUMBER);
        append(mobileNumber_);
        email_ = new TextField("Email",null, 64, TextField.EMAILADDR);
        append(email_);
        gender_ = new TextField("Gender",null, 64, TextField.ANY);
        append(gender_);
        dob_ = new TextField("DoB",null, 64, TextField.ANY);
        append(dob_);
        register_ = new Command("Sign Up", Command.ITEM, 1);
        addCommand(register_);
        login_ = new Command("Sign in", Command.ITEM, 2);
        addCommand(login_);
        exit_ = new Command("Exit", Command.EXIT, 2);
        addCommand(exit_);
    }
    public String getUsername() {
        return username_.getString();
    }
    public String getPassword() {
        return password_.getString();
    }
    public String getReenterPassword() {
        return reenterPassword_.getString();
    }
    public String getSalutation() {
        return salutation_.getString();
    }
    public String getFirstName() {
        return firstName_.getString();
    }
    public String getLastName() {
        return lastName_.getString();
    }
    public String getMobileNumber() {
        return mobileNumber_.getString();
    }
    public String getEmail() {
        return email_.getString();
    }
    public String getGender() {
        return gender_.getString();
    }
    public String getDob() {
        return dob_.getString();
    }
}
