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
import javax.microedition.media.Player;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.control.VideoControl;
import java.io.IOException;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import com.motorola.extensions.ScalableImage;
import javax.microedition.lcdui.Item;

public class XurmoMessageImage extends javax.microedition.lcdui.Form implements javax.microedition.lcdui.CommandListener {
  
  private XurmoMessageComposeScreen screen_;
  XurmoImageItem item_;
  private Command done;
  private Command start;
  private Command cancel;
  private Player p_;
  private VideoControl vc_;
  private byte[] raw_;
  /**
   * Creates a new instance of XurmoPresenceEdit
   */
  public XurmoMessageImage(XurmoMessageComposeScreen screen, XurmoImageItem item, String title) {
    super(title);
    screen_ = screen;
    item_ = item;
    done = new Command("Done", Command.ITEM, 1);
    start = new Command("Start", Command.ITEM, 1);
    cancel = new Command("Cancel", Command.ITEM, 2);
    addCommand(start);
    addCommand(cancel);
    setCommandListener(this);
    try {
      
      p_ = Manager.createPlayer("capture://camera");
      p_.realize();
      vc_ = (VideoControl)(p_.getControl("VideoControl"));
      if (vc_ != null) {
        this.append((Item)(vc_.initDisplayMode(VideoControl.USE_GUI_PRIMITIVE, null)));
        vc_.setDisplayFullScreen(true);
      }
    } catch(IOException ioex) {
      System.out.println(ioex);
    } catch(MediaException mex) {
      
      System.out.println(mex);
    }
  }
  public void commandAction(Command c, Displayable d) {
    if (c == start) {
      this.removeCommand(start);
      this.addCommand(done);
      try {
        
        p_.start();
      } catch(MediaException mex) {
        
      }
    } else if (c == done) {
      try {
        
        raw_ = vc_.getSnapshot("encoding=jpeg&width=480&height=640");
        item_.setRawImage(raw_);
        screen_.imageCaptureDone();
      } catch(MediaException mex) {
        System.out.println("Image capture failed..");
      }
    } else if (c == cancel) {
      
      screen_.cancelImageCapture();
    }
  }
}
