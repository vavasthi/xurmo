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
public class XurmoNetworkPanelPopupMenuListener implements XurmoPopupMenuListener {

  private XurmoPopupMenuItem[] items_;
  private Xurmo midlet_;
  private XurmoHomeScreen screen_;
  /** Creates a new instance of XurmoMePanelPopupMenuListener */
  public XurmoNetworkPanelPopupMenuListener(Xurmo midlet, XurmoHomeScreen screen) {
    midlet_ = midlet;
    screen_ = screen;
    items_ = new XurmoPopupMenuItem[] {
      new XurmoPopupMenuItem("Message my Network"),
      new XurmoPopupMenuItem("Do some other thing"),
      new XurmoPopupMenuItem("Do some more things")
    };
  }
  public void menuAction(int index, XurmoPopupMenuItem item) {
   switch(index) {
     case 0:
       midlet_.getDisplay().setCurrent(new XurmoSliderCanvas(midlet_, screen_, new XurmoMessageComposeScreen(midlet_), XurmoSliderCanvas.RIGHT));
       break;
     case 1:
     case 2:
     default:
   } 
  }
  public XurmoPopupMenuItem[] items() {
    return items_;
  }
}
