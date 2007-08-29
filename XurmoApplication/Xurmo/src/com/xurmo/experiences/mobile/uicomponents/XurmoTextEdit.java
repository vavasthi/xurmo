/*
 * XurmoTextEdit.java
 *
 * Created on August 29, 2007, 9:06 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile.uicomponents;

import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Item;

/**
 *
 * @author Vinay
 */
public class XurmoTextEdit extends TextBox implements CommandListener {
  
  Display display_;
  XurmoEditableCustomItem caller_;
  private final static Command doneCommand = new Command("Done", Command.ITEM, 1);
  private final static Command cancelCommand = new Command("Cancel", Command.ITEM, 1);
  
  public XurmoTextEdit(String title, String text, int maxSize, int constraints, Display display, XurmoEditableCustomItem caller) {
    
    super(title, text, maxSize, constraints);
    display_ = display;
    caller_ = caller;
    this.addCommand(doneCommand);
    this.addCommand(cancelCommand);
  }
  public void edit() {
    display_.setCurrent(this);
  }
  public void commandAction(Command c, Displayable d) {
    if (c == doneCommand) {
      
      caller_.saveValueFromEditScreen(this.getString());
    }
    if (c == doneCommand || c == cancelCommand) {
      
      display_.setCurrentItem((Item)(caller_));
    }
  }
}
