/*
 * XurmoImageItem.java
 *
 * Created on September 30, 2007, 1:55 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

import javax.microedition.media.Player;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.control.VideoControl;
import java.io.IOException;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import com.motorola.extensions.ScalableImage;

/**
 *
 * @author Vinay
 */
public class XurmoImageItem extends XurmoContentItem {
  
  XurmoMessageComposeScreen screen_;
  /** Creates a new instance of XurmoImageItem */
  public XurmoImageItem(XurmoMessageComposeScreen screen) {
    super(XurmoContentItem.IMAGE);
    screen_ = screen;
  }
  public void draw(Graphics g, int x, int y) {
      
      if (state_ == DONE && raw_ != null) {
        
        Image img
            = ScalableImage.createImage(raw_, 0, raw_.length, screen_.getWidth() / 3, screen_.getHeight() / 3, ScalableImage.PROPORTIONAL_SCALING_MODE_MINIMIZE).getImage();
        g.drawImage(img, x, y, g.LEFT|g.TOP);
      }
  }
  public void fireKey() {
    XurmoMessageImage mi = new XurmoMessageImage(screen_, this, "Take picture");
    screen_.midlet_.getDisplay().setCurrent(mi);
}
  public void setRawImage(byte[] raw) {
    raw_ = raw;
    state_ = DONE;
  }
  byte[] raw_;
}
