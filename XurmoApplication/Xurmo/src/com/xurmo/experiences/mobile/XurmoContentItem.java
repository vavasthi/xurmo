/*
 * XurmoContentItem.java
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
public class XurmoContentItem {
  
  public static final int STRING = 0x00;
  public static final int IMAGE = 0x01;
  public static final int AUDIO = 0x02;
  
  
  public static final String[] mimeType = new String[] {
    new String("text/plain"),
    new String("image/jpeg"),
    new String("audio/amr")
  };
  
  public static final String[] contentType = new String[] {
    new String("Text"),
    new String("Image"),
    new String("Audio")
  };
  public static final int INITIALIZED = 0x01;
  public static final int IN_PROGRESS = 0x02;
  public static final int DONE = 0x03;
  
  /** Creates a new instance of XurmoContentItem */
  public XurmoContentItem(int contentType) {
    contentType_ = contentType;
    state_ = INITIALIZED;
  }
  public void fireKey() {
    state_ = DONE;
  }
  public void draw(Graphics g, int x, int y) {
    
  }
  int contentType_;
  int state_;
}
