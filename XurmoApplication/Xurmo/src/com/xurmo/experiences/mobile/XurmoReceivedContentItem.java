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
public class XurmoReceivedContentItem {
  
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
  /** Creates a new instance of XurmoContentItem */
  public XurmoReceivedContentItem(int contentType) {
    contentType_ = contentType;
  }
  public void fireKey() {
  }
  public void draw(Graphics g, int x, int y) {
    
  }
  public static XurmoReceivedContentItem streamIn(java.io.DataInputStream dis) {
    
    try{
      
      int msgType = dis.readInt();
      switch(msgType) {
        case AUDIO:
        {
          int cs = dis.readInt();
          byte[] buf = new byte[cs];
          dis.read(buf, 0, cs);
          return new XurmoReceivedAudioItem(buf);
        }
        case IMAGE:
        {
          int cs = dis.readInt();
          byte[] buf = new byte[cs];
          dis.read(buf, 0 , cs);
          return new XurmoReceivedImageItem(buf);
        }
        case STRING:
        {
          int cs = dis.readInt();
          byte[] buf = new byte[cs];
          dis.read(buf, 0 , cs);
          return new XurmoReceivedStringItem(new String(buf));
        }
      }
    } catch(java.io.IOException ioex) {
      System.out.println("Error in parsing message..");
    }
    return null;
  }
  int contentType_;
  int state_;
}
