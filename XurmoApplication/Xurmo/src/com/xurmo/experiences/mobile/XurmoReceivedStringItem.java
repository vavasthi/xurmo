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
public class XurmoReceivedStringItem extends XurmoReceivedContentItem {
  /** Creates a new instance of XurmoStringItem */
  public XurmoReceivedStringItem(String content) {
    super(XurmoContentItem.STRING);
    content_ = content;
  }
  public void fireKey() {
  }
  private String content_;
}
