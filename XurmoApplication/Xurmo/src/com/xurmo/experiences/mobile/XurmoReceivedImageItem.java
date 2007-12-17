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
public class XurmoReceivedImageItem extends XurmoReceivedContentItem {
  
  /** Creates a new instance of XurmoImageItem */
  public XurmoReceivedImageItem(byte[] raw) {
    super(XurmoContentItem.IMAGE);
    raw_ = raw;
  }
  public void fireKey() {
  }
  byte[] raw_;
}
