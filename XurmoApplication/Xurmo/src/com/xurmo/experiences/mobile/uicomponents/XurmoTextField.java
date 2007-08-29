/*
 * XurmoTextField.java
 *
 * Created on August 29, 2007, 7:59 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile.uicomponents;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemCommandListener;
import javax.microedition.lcdui.Displayable;

import com.xurmo.experiences.mobile.*;

/**
 *
 * @author Vinay
 */
public class XurmoTextField extends javax.microedition.lcdui.CustomItem implements XurmoEditableCustomItem, ItemCommandListener  {
  /** Creates a new instance of XurmoTextField */
  String text_;
  String label_;
  int maxSize_;
  int constraints_;
  boolean traverseIn_;
  MIDlet midlet_;
  int sfgColor_;
  int sbgColor_;
  int usfgColor_;
  int usbgColor_;
  private final static Command defaultEditCommand = new Command("Edit", Command.ITEM, 1);
  
  public XurmoTextField(String label, String text, int maxSize, int constraints, MIDlet midlet) {
    super(null);
    label_ = label;
    text_ = text;
    maxSize_ = maxSize;
    constraints_ = constraints;
    midlet_ = midlet;
    traverseIn_ = false;
    setItemCommandListener(this);
    setDefaultCommand(defaultEditCommand);
    XurmoTheme t = XurmoThemeManager.instance().getCurrentTheme();
    sfgColor_ = t.collapsablePanelSelectedForegroundColorValue_;
    sbgColor_ = t.collapsablePanelSelectedContentBackgroundColorValue_;
    usfgColor_ = t.collapsablePanelUnselectedForegroundColorValue_;
    usbgColor_ = t.collapsablePanelUnselectedBackgroundColorValue_;
  }
  public int getMinContentHeight() {
    
    return Font.getDefaultFont().getHeight() + 2;
  }
  public int getMinContentWidth() {
    
    return Display.getDisplay(midlet_).getCurrent().getWidth();
  }
  public int getPrefContentHeight(int width) {
    
    return Font.getDefaultFont().getHeight();
  }
  public int getPrefContentWidth(int height) {
    
    return Display.getDisplay(midlet_).getCurrent().getWidth();
  }
  public void paint(Graphics g, int w, int h) {
    int x = 0;
    g.drawString(label_, x, 0, Graphics.LEFT | Graphics.TOP);
    x += g.getFont().stringWidth(label_);
    int oc = g.getColor();
    if (traverseIn_) {
      g.setColor(sbgColor_);
      g.fillRoundRect(x + 2, 0, w - x - 4, h - 2, 10, 10);
      g.setColor(sfgColor_);
      if (text_ != null) {
        
        g.drawString(text_, x + 5, 0, Graphics.LEFT | Graphics.TOP);
      }
    } else {
      
      g.setColor(sbgColor_);
      g.drawRoundRect(x + 2, 0, w - x - 4, h - 2, 10, 10);
      g.setColor(sfgColor_);
      if (text_ != null) {
        
        g.drawString(text_, x + 5, 0, Graphics.LEFT | Graphics.TOP);
      }
    }
    g.setColor(oc);
  }
  public String getString() {
    return text_;
  }
  protected boolean traverse(int dir,
      int viewportWidth,
      int viewportHeight,
      int[] visRect_inout) {
    
    boolean retValue;
    if (traverseIn_ == false) {
      traverseIn_ = true;
      retValue = true;
    } else {
      retValue = false;
    }
    repaint();
    return retValue;
  }
  protected void traverseOut() {
    traverseIn_ = false;
    repaint();
  }
  public void commandAction(Command c, Item i) {
    if (c == defaultEditCommand) {
      XurmoTextEdit te  = new XurmoTextEdit("Editing " + label_, text_, maxSize_, constraints_, Display.getDisplay(midlet_), this);
      te.edit();
    }
  }
  public void saveValueFromEditScreen(String value) {
    text_ = value;
    this.notifyStateChanged();
  }
}
