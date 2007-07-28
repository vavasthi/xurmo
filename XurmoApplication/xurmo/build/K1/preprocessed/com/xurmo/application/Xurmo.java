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
    private Command exitHome_;//GEN-END:MVDFields
    
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
        getDisplay().setCurrent(get_xurmoHomeCanvas());//GEN-LINE:MVDInitInit
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
    
    public void startApp() {
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
}
