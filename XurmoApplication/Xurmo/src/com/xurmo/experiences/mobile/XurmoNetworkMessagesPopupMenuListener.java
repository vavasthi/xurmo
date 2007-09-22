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
public class XurmoNetworkMessagesPopupMenuListener implements XurmoPopupMenuListener {

  private XurmoPopupMenuItem[] items_;
  XurmoNetworkMessageResponseType[] responseTypes_;
  XurmoNetworkMessageEntryPanel panel_;
  /** Creates a new instance of XurmoMePanelPopupMenuListener */
  public XurmoNetworkMessagesPopupMenuListener(XurmoNetworkMessageEntryPanel panel, XurmoNetworkMessageResponseType[] responseTypes) {
    responseTypes_ = responseTypes;
    panel_ = panel;
    items_ = new XurmoPopupMenuItem[responseTypes_.length];
    for (int i = 0; i < items_.length; ++i) {
      
      XurmoNetworkMessageResponseType xnlt = responseTypes[i];
      items_[i] = new XurmoPopupMenuItem(xnlt.responseString);
    }
  }
  public void menuAction(int index, XurmoPopupMenuItem item) {
    
    if (item.item_.equals(items_[index].item_)) {
      XurmoNetworkMessageResponseType xnlt = responseTypes_[index];
      panel_.responseId_ = xnlt.responseId;
      panel_.responseString_= xnlt.responseString;
    }
  }
  public XurmoPopupMenuItem[] items() {
    return items_;
  }
}
