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
public class XurmoInviteScreenPopupMenuListener implements XurmoPopupMenuListener {

  private XurmoPopupMenuItem[] items_;
  java.util.Vector linkTypes_;
  XurmoInviteEntryPanel panel_;
  /** Creates a new instance of XurmoMePanelPopupMenuListener */
  public XurmoInviteScreenPopupMenuListener(XurmoInviteEntryPanel panel, java.util.Vector linkTypes) {
    linkTypes_ = linkTypes;
    panel_ = panel;
    items_ = new XurmoPopupMenuItem[linkTypes.size()];
    for (int i = 0; i < items_.length; ++i) {
      
      XurmoNetworkLinkType xnlt = (XurmoNetworkLinkType)(linkTypes.elementAt(i));
      items_[i] = new XurmoPopupMenuItem(xnlt.linkName_);
    }
  }
  public void menuAction(int index, XurmoPopupMenuItem item) {
    
    if (item.item_.equals(items_[index].item_)) {
      XurmoNetworkLinkType xnlt = (XurmoNetworkLinkType)(linkTypes_.elementAt(index));
      panel_.linkId_ = xnlt.linkId_;
      panel_.linkName_ = xnlt.linkName_;
    }
  }
  public XurmoPopupMenuItem[] items() {
    return items_;
  }
}
