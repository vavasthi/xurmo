/*
 * XurmoAudioItem.java
 *
 * Created on September 30, 2007, 1:54 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;
import javax.microedition.media.Player;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.control.RecordControl;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
/**
 *
 * @author Vinay
 */
public class XurmoAudioItem extends XurmoContentItem {
  Player p_;
  RecordControl rc_;
  XurmoCanvas canvas_;
  /** Creates a new instance of XurmoAudioItem */
  public XurmoAudioItem(XurmoCanvas canvas) {
    super(XurmoContentItem.AUDIO);
    bos_ = new java.io.ByteArrayOutputStream();
    canvas_ = canvas;
    try {
      
      p_ = Manager.createPlayer("capture://audio?encoding=audio/mpeg");
      p_.realize();
      rc_ = (RecordControl)(p_.getControl("RecordControl"));
      rc_.setRecordStream(bos_);
    } catch(IOException ioex) {
      
    } catch(MediaException mex) {
      
    }
  }
  public void fireKey() {
    
    try {
      
      if (state_ == INITIALIZED) {
        rc_.startRecord();
        p_.start();
        state_ = IN_PROGRESS;
      } else if (state_ == IN_PROGRESS) {
        rc_.commit();
        p_.close();
        content_ = bos_.toByteArray();
        state_ = DONE;
      }
    } catch(MediaException mex) {
      
    } catch(IOException ioex) {
      
    }
  }
  public void draw(Graphics g, int x, int y) {
    
    switch(state_) {
      case INITIALIZED:
        g.drawString("Initialized..", x, y, g.LEFT | g.TOP);
        break;
      case IN_PROGRESS:
        g.drawString("Recording...", x, y, g.LEFT | g.TOP);
        break;
      case DONE:
        g.drawString("Done... Size = " + content_.length, x, y, g.LEFT | g.TOP);
        break;
    }
  }
  public void streamOut(java.io.DataOutputStream dos) throws java.io.IOException {
    dos.writeInt(XurmoContentItem.AUDIO);
    dos.writeInt(content_.length);
    dos.write(content_, 0, content_.length);
  }
  byte[] content_;
  String mimeType_;
  java.io.ByteArrayOutputStream bos_;
}
