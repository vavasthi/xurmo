// =====================================================================
//                   Motorola Confidential Proprietary
//           (c) Copyright 2006, Motorola Inc. All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          March 30, 2007
// =====================================================================

/**
 *
 * @file   Xurmo.java
 * @author
 * @date   March 30, 2007
 *
 * @brief
 *
 *
 */
// *********************************************************************
// Package
// *********************************************************************
package com.xurmo.application;
// *********************************************************************
// Imports
// *********************************************************************

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 *
 * @author a12733
 */
public class Xurmo extends MIDlet implements CommandListener {
    
    /** Creates a new instance of Xurmo */
    public Xurmo() {
        initialize();
    }
    
    private com.xurmo.application.XurmoHomeCanvas xurmoHomeCanvas;//GEN-BEGIN:MVDFields
    private Command exitHome_;
    private Form userRegistration;
    private TextField username_;
    private TextField password_;
    private ChoiceGroup salutation_;
    private TextField fname_;
    private TextField lname_;
    private TextField mobile_;
    private TextField email_;
    private ChoiceGroup gender_;
    private TextField dob_;//GEN-END:MVDFields
    
//GEN-LINE:MVDMethods

    /** Called by the system to indicate that a command has been invoked on a particular displayable.//GEN-BEGIN:MVDCABegin
     * @param command the Command that ws invoked
     * @param displayable the Displayable on which the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:MVDCABegin
    // Insert global pre-action code here
      if (displayable == xurmoHomeCanvas) {//GEN-BEGIN:MVDCABody
        if (command == exitHome_) {//GEN-END:MVDCABody
                // Insert pre-action code here
          exitMIDlet();//GEN-LINE:MVDCAAction8
                // Insert post-action code here
        }//GEN-BEGIN:MVDCACase8
      }//GEN-END:MVDCACase8
    // Insert global post-action code here
}//GEN-LINE:MVDCAEnd

    /** This method initializes UI of the application.//GEN-BEGIN:MVDInitBegin
     */
    private void initialize() {//GEN-END:MVDInitBegin
        // Insert pre-init code here
      if (!XurmoAuthenticationDataStore.instance().dataExists()) {
        getDisplay().setCurrent(this.get_userRegistration());
      }
//GEN-LINE:MVDInitInit
        // Insert post-init code here
    }//GEN-LINE:MVDInitEnd
    
    /**
     * This method should return an instance of the display.
     */
    public Display getDisplay() {//GEN-FIRST:MVDGetDisplay
        return Display.getDisplay(this);
    }//GEN-LAST:MVDGetDisplay
    
    /**
     * This method should exit the midlet.
     */
    public void exitMIDlet() {//GEN-FIRST:MVDExitMidlet
        getDisplay().setCurrent(null);
        destroyApp(true);
        notifyDestroyed();
    }//GEN-LAST:MVDExitMidlet

    /** This method returns instance for xurmoHomeCanvas component and should be called instead of accessing xurmoHomeCanvas field directly.//GEN-BEGIN:MVDGetBegin2
     * @return Instance for xurmoHomeCanvas component
     */
    public com.xurmo.application.XurmoHomeCanvas get_xurmoHomeCanvas() {
      if (xurmoHomeCanvas == null) {//GEN-END:MVDGetBegin2
            // Insert pre-init code here
        xurmoHomeCanvas = new com.xurmo.application.XurmoHomeCanvas(false);//GEN-BEGIN:MVDGetInit2
        xurmoHomeCanvas.addCommand(get_exitHome_());
        xurmoHomeCanvas.setCommandListener(this);//GEN-END:MVDGetInit2
            // Insert post-init code here
      }//GEN-BEGIN:MVDGetEnd2
      return xurmoHomeCanvas;
    }//GEN-END:MVDGetEnd2

    /** This method returns instance for exitHome_ component and should be called instead of accessing exitHome_ field directly.//GEN-BEGIN:MVDGetBegin7
     * @return Instance for exitHome_ component
     */
    public Command get_exitHome_() {
      if (exitHome_ == null) {//GEN-END:MVDGetBegin7
            // Insert pre-init code here
        exitHome_ = new Command("Exit", Command.EXIT, 1);//GEN-LINE:MVDGetInit7
            // Insert post-init code here
      }//GEN-BEGIN:MVDGetEnd7
      return exitHome_;
    }//GEN-END:MVDGetEnd7

    /** This method returns instance for userRegistration component and should be called instead of accessing userRegistration field directly.//GEN-BEGIN:MVDGetBegin9
     * @return Instance for userRegistration component
     */
    public Form get_userRegistration() {
      if (userRegistration == null) {//GEN-END:MVDGetBegin9
        // Insert pre-init code here
        userRegistration = new Form("User Registration", new Item[] {//GEN-BEGIN:MVDGetInit9
          get_username_(),
          get_password_(),
          get_salutation_(),
          get_fname_(),
          get_lname_(),
          get_mobile_(),
          get_email_(),
          get_gender_(),
          get_dob_()
        });//GEN-END:MVDGetInit9
        // Insert post-init code here
      }//GEN-BEGIN:MVDGetEnd9
      return userRegistration;
    }//GEN-END:MVDGetEnd9

    /** This method returns instance for username_ component and should be called instead of accessing username_ field directly.//GEN-BEGIN:MVDGetBegin10
     * @return Instance for username_ component
     */
    public TextField get_username_() {
      if (username_ == null) {//GEN-END:MVDGetBegin10
        // Insert pre-init code here
        username_ = new TextField("Username", null, 120, TextField.ANY | TextField.NON_PREDICTIVE);//GEN-LINE:MVDGetInit10
        // Insert post-init code here
      }//GEN-BEGIN:MVDGetEnd10
      return username_;
    }//GEN-END:MVDGetEnd10

    /** This method returns instance for password_ component and should be called instead of accessing password_ field directly.//GEN-BEGIN:MVDGetBegin11
     * @return Instance for password_ component
     */
    public TextField get_password_() {
      if (password_ == null) {//GEN-END:MVDGetBegin11
        // Insert pre-init code here
        password_ = new TextField("Password", null, 120, TextField.ANY | TextField.PASSWORD);//GEN-LINE:MVDGetInit11
        // Insert post-init code here
      }//GEN-BEGIN:MVDGetEnd11
      return password_;
    }//GEN-END:MVDGetEnd11

    /** This method returns instance for salutation_ component and should be called instead of accessing salutation_ field directly.//GEN-BEGIN:MVDGetBegin12
     * @return Instance for salutation_ component
     */
    public ChoiceGroup get_salutation_() {
      if (salutation_ == null) {//GEN-END:MVDGetBegin12
        // Insert pre-init code here
        salutation_ = new ChoiceGroup("Salutation", Choice.POPUP, new String[] {//GEN-BEGIN:MVDGetInit12
          "Mrs.",
          "Ms.",
          "Mr.",
          "Dr.",
          "Miss"
        }, new Image[] {
          null,
          null,
          null,
          null,
          null
        });
        salutation_.setSelectedFlags(new boolean[] {
          false,
          false,
          true,
          false,
          false
        });//GEN-END:MVDGetInit12
        // Insert post-init code here
      }//GEN-BEGIN:MVDGetEnd12
      return salutation_;
    }//GEN-END:MVDGetEnd12

    /** This method returns instance for fname_ component and should be called instead of accessing fname_ field directly.//GEN-BEGIN:MVDGetBegin18
     * @return Instance for fname_ component
     */
    public TextField get_fname_() {
      if (fname_ == null) {//GEN-END:MVDGetBegin18
        // Insert pre-init code here
        fname_ = new TextField("First Name", null, 120, TextField.ANY | TextField.INITIAL_CAPS_WORD);//GEN-LINE:MVDGetInit18
        // Insert post-init code here
      }//GEN-BEGIN:MVDGetEnd18
      return fname_;
    }//GEN-END:MVDGetEnd18

    /** This method returns instance for lname_ component and should be called instead of accessing lname_ field directly.//GEN-BEGIN:MVDGetBegin19
     * @return Instance for lname_ component
     */
    public TextField get_lname_() {
      if (lname_ == null) {//GEN-END:MVDGetBegin19
        // Insert pre-init code here
        lname_ = new TextField("Last Name", null, 120, TextField.ANY | TextField.INITIAL_CAPS_WORD);//GEN-LINE:MVDGetInit19
        // Insert post-init code here
      }//GEN-BEGIN:MVDGetEnd19
      return lname_;
    }//GEN-END:MVDGetEnd19

    /** This method returns instance for mobile_ component and should be called instead of accessing mobile_ field directly.//GEN-BEGIN:MVDGetBegin20
     * @return Instance for mobile_ component
     */
    public TextField get_mobile_() {
      if (mobile_ == null) {//GEN-END:MVDGetBegin20
        // Insert pre-init code here
        mobile_ = new TextField("Mobile", null, 120, TextField.PHONENUMBER);//GEN-LINE:MVDGetInit20
        // Insert post-init code here
      }//GEN-BEGIN:MVDGetEnd20
      return mobile_;
    }//GEN-END:MVDGetEnd20

    /** This method returns instance for email_ component and should be called instead of accessing email_ field directly.//GEN-BEGIN:MVDGetBegin21
     * @return Instance for email_ component
     */
    public TextField get_email_() {
      if (email_ == null) {//GEN-END:MVDGetBegin21
        // Insert pre-init code here
        email_ = new TextField("E-Mail", null, 120, TextField.EMAILADDR);//GEN-LINE:MVDGetInit21
        // Insert post-init code here
      }//GEN-BEGIN:MVDGetEnd21
      return email_;
    }//GEN-END:MVDGetEnd21

    /** This method returns instance for gender_ component and should be called instead of accessing gender_ field directly.//GEN-BEGIN:MVDGetBegin22
     * @return Instance for gender_ component
     */
    public ChoiceGroup get_gender_() {
      if (gender_ == null) {//GEN-END:MVDGetBegin22
        // Insert pre-init code here
        gender_ = new ChoiceGroup("Gender", Choice.POPUP, new String[] {//GEN-BEGIN:MVDGetInit22
          "Male",
          "Female"
        }, new Image[] {
          null,
          null
        });
        gender_.setSelectedFlags(new boolean[] {
          true,
          false
        });//GEN-END:MVDGetInit22
        // Insert post-init code here
      }//GEN-BEGIN:MVDGetEnd22
      return gender_;
    }//GEN-END:MVDGetEnd22

    /** This method returns instance for dob_ component and should be called instead of accessing dob_ field directly.//GEN-BEGIN:MVDGetBegin25
     * @return Instance for dob_ component
     */
    public TextField get_dob_() {
      if (dob_ == null) {//GEN-END:MVDGetBegin25
        // Insert pre-init code here
        dob_ = new TextField("Date of Birth (YYYY-MM-DD)", null, 120, TextField.ANY);//GEN-LINE:MVDGetInit25
        // Insert post-init code here
      }//GEN-BEGIN:MVDGetEnd25
      return dob_;
    }//GEN-END:MVDGetEnd25
    
    public void startApp() {
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
}
