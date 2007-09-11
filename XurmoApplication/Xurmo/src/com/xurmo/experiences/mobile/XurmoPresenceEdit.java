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
public class XurmoPresenceEdit extends javax.microedition.lcdui.TextBox implements javax.microedition.lcdui.CommandListener {
  
  private XurmoMeScreen screen_;
  private Command done;
  private Command cancel;
  private XurmoMeScreen display;
  /**
   * Creates a new instance of XurmoPresenceEdit
   */
  public XurmoPresenceEdit(XurmoMeScreen screen, String title, String text) {
    super(title, text, 160, javax.microedition.lcdui.TextField.ANY);
    screen_ = screen;
    done = new Command("Done", Command.ITEM, 1);
    cancel = new Command("Cancel", Command.ITEM, 1);
    addCommand(done);
    addCommand(cancel);
    setCommandListener(this);
  }
  public void commandAction(Command c, Displayable d) {
    if (c == done) {
      
      screen_.updatePresence(this.getString());
    }
    if (c == cancel) {
      
      screen_.cancelPresenceEdit();
    }
  }
}
