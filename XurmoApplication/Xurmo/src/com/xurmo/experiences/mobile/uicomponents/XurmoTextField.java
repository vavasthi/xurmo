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
import javax.microedition.lcdui.TextField;
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
  String[] label_;
  int maxSize_;
  int minHeight_;
  int constraints_;
  float percLabelWidth_;
  boolean traverseIn_;
  MIDlet midlet_;
  int sfgColor_;
  int sbgColor_;
  int usfgColor_;
  int usbgColor_;
  private final static Command defaultEditCommand = new Command("Edit", Command.ITEM, 1);
  
  public XurmoTextField(String label, String text, int maxSize, int constraints, float percLabelWidth, MIDlet midlet) {
    super(null);
    label_ = new String[1];
    label_[0] = label;
    minHeight_ = Font.getDefaultFont().getHeight() + 2;
    text_ = text;
    maxSize_ = maxSize;
    constraints_ = constraints;
    percLabelWidth_ = percLabelWidth;
    midlet_ = midlet;
    initialize();
  }
  public XurmoTextField(String label[], String text, int maxSize, int constraints, float percLabelWidth, MIDlet midlet) {
    super(null);
    label_ = label;
    text_ = text;
    maxSize_ = maxSize;
    minHeight_ = (label_.length * Font.getDefaultFont().getHeight()) + 2;
    constraints_ = constraints;
    percLabelWidth_ = percLabelWidth;
    midlet_ = midlet;
    initialize();
  }
  private void initialize() {
    
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
    
    return minHeight_;
  }
  public int getMinContentWidth() {
    
    return Display.getDisplay(midlet_).getCurrent().getWidth();
  }
  public int getPrefContentHeight(int width) {
    
    return minHeight_;
  }
  public int getPrefContentWidth(int height) {
    
    return Display.getDisplay(midlet_).getCurrent().getWidth();
  }
  public void paint(Graphics g, int w, int h) {
    int x = 0;
    int y = 0;
    String ps = text_;
    if (constraints_ == TextField.PASSWORD && ps != null) {
      ps = "";
      for (int k = 0; k < text_.length(); ++k) {
        ps += "*";
      }
    }
    for (int i = 0; i < label_.length; ++i) {
      
      g.drawString(label_[i], x, y, Graphics.LEFT | Graphics.TOP);
      y += g.getFont().getHeight();
    }
    x += Display.getDisplay(midlet_).getCurrent().getWidth() * percLabelWidth_;
    y = g.getFont().getHeight() * (label_.length - 1) / 2;
    int oc = g.getColor();
    if (traverseIn_) {
      g.setColor(sbgColor_);
      g.fillRoundRect(x + 2, y, w - x - 4, (h / label_.length)- 2, 10, 10);
      g.setColor(sfgColor_);
      if (ps != null) {
        
        g.drawString(ps, x + 5, y, Graphics.LEFT | Graphics.TOP);
      }
    } else {
      
      g.setColor(sbgColor_);
      g.drawRoundRect(x + 2, y, w - x - 4, (h / label_.length) - 2, 10, 10);
      g.setColor(sfgColor_);
      if (ps != null) {
        
        g.drawString(ps , x + 5, y, Graphics.LEFT | Graphics.TOP);
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
  public void commandAction(Command c, Item itm) {
    if (c == defaultEditCommand) {
      String l = new String("");
      for (int i = 0; i < label_.length; ++i) {
        l = l + " ";
        l = l + label_[i];
      }
      XurmoTextEdit te  = new XurmoTextEdit("Editing" + l, text_, maxSize_, constraints_, Display.getDisplay(midlet_), this);      
      te.edit();
    }
  }
  public void saveValueFromEditScreen(String value) {
    text_ = value;
    this.notifyStateChanged();
  }
}
