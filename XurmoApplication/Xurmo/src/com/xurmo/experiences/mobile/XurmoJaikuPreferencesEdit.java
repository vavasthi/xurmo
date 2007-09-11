package com.xurmo.experiences.mobile;
/*
 * XurmoPresenceEdit.java
 *
 * Created on September 10, 2007, 8:39 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Vinay
 */

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextField;

public class XurmoJaikuPreferencesEdit extends javax.microedition.lcdui.Form implements javax.microedition.lcdui.CommandListener {
  
  private XurmoMySocialNetworksScreen screen_;
  private TextField username_;
  private TextField personalKey_;
  private Command done;
  private Command cancel;
  /**
   * Creates a new instance of XurmoPresenceEdit
   */
  public XurmoJaikuPreferencesEdit(XurmoMySocialNetworksScreen screen, String username) {
    super("Jaiku Preferences");
    screen_ = screen;
    username_ = new TextField("Username", username, 120, TextField.ANY);
    personalKey_ = new TextField("Personal Key", "", 120, TextField.PASSWORD);
    this.append(username_);
    this.append(personalKey_);
    done = new Command("Done", Command.ITEM, 1);
    cancel = new Command("Cancel", Command.ITEM, 1);
    addCommand(done);
    addCommand(cancel);
    setCommandListener(this);
  }
  public void commandAction(Command c, Displayable d) {
    if (c == done) {
      
      screen_.updateJaikuPreference(username_.getString(), personalKey_.getString());
    }
    if (c == cancel) {
      
      screen_.cancelSocialNetworkPreferenceEdit();
    }
  }
}
