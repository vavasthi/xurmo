/*
 * XurmoMePanelPopupMenuListener.java
 *
 * Created on September 14, 2007, 8:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author Vinay
 */
public class XurmoMePanelPopupMenuListener implements XurmoPopupMenuListener {

  private XurmoPopupMenuItem[] items_;
  /** Creates a new instance of XurmoMePanelPopupMenuListener */
  public XurmoMePanelPopupMenuListener() {
    items_ = new XurmoPopupMenuItem[] {
      new XurmoPopupMenuItem("Set Presence"),
      new XurmoPopupMenuItem("Change Password"),
      new XurmoPopupMenuItem("Profile Details")
    };
  }
  public void menuAction(XurmoPopupMenuItem item) {
    
  }
  public XurmoPopupMenuItem[] items() {
    return items_;
  }
}
