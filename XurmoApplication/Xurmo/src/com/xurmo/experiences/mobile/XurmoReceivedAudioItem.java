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
import javax.microedition.media.control.VolumeControl;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
/**
 *
 * @author Vinay
 */
public class XurmoReceivedAudioItem extends XurmoReceivedContentItem {
  Player p_;
  VolumeControl vc_;
  byte[] buf_;
  /** Creates a new instance of XurmoAudioItem */
  public XurmoReceivedAudioItem(byte[] buf) {
    super(XurmoContentItem.AUDIO);
    try {
      
      java.io.ByteArrayInputStream bis = new java.io.ByteArrayInputStream(buf_);
      p_ = Manager.createPlayer(bis, mimeType[AUDIO]);
      p_.realize();
      vc_ = (VolumeControl)(p_.getControl("VolumeControl"));
    } catch(IOException ioex) {
      
    } catch(MediaException mex) {
      
    }
  }
  public void fireKey() {
    
    try {
      
      p_.start();
      vc_.setLevel(100);
    } catch(MediaException mex) {
      
    }
  }
}
