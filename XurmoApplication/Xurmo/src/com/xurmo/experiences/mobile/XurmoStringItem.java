/*
 * XurmoStringItem.java
 *
 * Created on September 30, 2007, 1:53 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author Vinay
 */
public class XurmoStringItem extends XurmoContentItem {
  /** Creates a new instance of XurmoStringItem */
  public XurmoStringItem(XurmoMessageComposeScreen screen) {
    super(XurmoContentItem.STRING);
    screen_ = screen;
    content_ = new String("");
    state_ = INITIALIZED;
  }
  public void fireKey() {
    XurmoMessageEdit me = new XurmoMessageEdit(screen_, this, "Enter message text", content_);
    screen_.midlet_.getDisplay().setCurrent(me);
  }
  public void draw(Graphics g, int x, int y) {
    g.drawRoundRect(x, y, screen_.getWidth() / 3, screen_.getHeight() / 3, 20, 20);
    g.drawString(content_, x, y, g.LEFT|g.TOP);
  }
  public void setValue(String msg) {
    content_ = msg;
    state_ = DONE;
  }
  public void streamOut(java.io.DataOutputStream dos) throws java.io.IOException {
    dos.writeInt(XurmoContentItem.STRING);
    byte[] b = content_.getBytes();
    dos.writeInt(b.length);
    dos.write(b, 0, b.length);
  }
  private XurmoMessageComposeScreen screen_;
  private String content_;
}
