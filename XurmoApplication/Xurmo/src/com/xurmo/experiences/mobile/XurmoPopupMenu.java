/*
 * XurmoPopupMenu.java
 *
 * Created on September 9, 2007, 9:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author Vinay
 */
public class XurmoPopupMenu {
  Xurmo midlet_;
  XurmoCanvas screen_;
  int w_;
  int maxH_;
  String[] menuItems_;
  /** Creates a new instance of XurmoPopupMenu */
  public XurmoPopupMenu(Xurmo midlet, XurmoCanvas screen, String[] menuItems) {
    
    midlet_ = midlet;
    screen_ = screen;
    w_ = screen_.getWidth() / 2;
    maxH_ = (2 * screen_.getHeight() / 3);
    menuItems_ = menuItems;
    
  }
  void draw(javax.microedition.lcdui.Graphics g, int x, int y) {
    
  }
}
