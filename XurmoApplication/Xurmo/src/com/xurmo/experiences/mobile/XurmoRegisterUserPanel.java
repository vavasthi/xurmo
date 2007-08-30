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
import com.xurmo.experiences.mobile.uicomponents.XurmoTextField;
import com.xurmo.experiences.mobile.uicomponents.XurmoFormSubmitAndCancel;
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Form;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Font;

public class XurmoRegisterUserPanel extends Form {
    
    private XurmoTextField username_;
    private XurmoTextField password_;
    private XurmoTextField reenterPassword_;
    private XurmoTextField salutation_;
    private XurmoTextField firstName_;
    private XurmoTextField lastName_;
    private XurmoTextField mobileNumber_;
    private XurmoTextField email_;
    private XurmoTextField gender_;
    private XurmoTextField dob_;
    
    Command login_;
    Command exit_;
    Command register_;
    
    Xurmo midlet_;
    /**
   * Creates a new instance of XurmoRegisterUserPanel
   */
    public XurmoRegisterUserPanel(Xurmo midlet) {
        super("Sign Up");
        midlet_ = midlet;
        final float labelPerc = (float)0.25;
        username_ = new XurmoTextField("Username",null, 32, TextField.ANY, labelPerc, midlet_);
        append(username_);
        password_ = new XurmoTextField("Password",null, 32, TextField.PASSWORD, labelPerc, midlet_);
        append(password_);
        String[] rep = new String[2];
        rep[0] = new String("Reenter");
        rep[1] = new String("Password");
        reenterPassword_ = new XurmoTextField(rep,null, 32, TextField.PASSWORD, labelPerc, midlet_);
        append(reenterPassword_);
        salutation_ = new XurmoTextField("Salutation",null, 64, TextField.ANY, labelPerc, midlet_);
        append(salutation_);
        firstName_ = new XurmoTextField("First Name",null, 64, TextField.ANY, labelPerc, midlet_);
        append(firstName_);
        lastName_ = new XurmoTextField("Last Name",null, 64, TextField.ANY, labelPerc, midlet_);
        append(lastName_);
        String[] mn = new String[2];
        mn[0] = new String("Mobile");
        mn[1] = new String("Number");
        mobileNumber_ = new XurmoTextField(mn,null, 64, TextField.PHONENUMBER, labelPerc, midlet_);
        append(mobileNumber_);
        email_ = new XurmoTextField("Email",null, 64, TextField.EMAILADDR, labelPerc, midlet_);
        append(email_);
        gender_ = new XurmoTextField("Gender",null, 64, TextField.ANY, labelPerc, midlet_);
        append(gender_);
        dob_ = new XurmoTextField("DoB",null, 64, TextField.ANY, labelPerc, midlet_);
        append(dob_);
//        append(new XurmoFormSubmitAndCancel(midlet_));
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
