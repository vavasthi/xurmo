/*
 * XurmoInviteEntryPanel.java
 *
 * Created on September 21, 2007, 6:09 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author Vinay
 */
public class XurmoNetworkMessageEntryPanel extends XurmoSelectablePanel {
  
  /** Creates a new instance of XurmoInviteEntryPanel */
  public XurmoNetworkMessageEntryPanel(Xurmo midlet, int screenWidth, int screenHeight, String usernameFrom, String linkName, String msg, XurmoNetworkMessageResponseType[] responseTypes) {
    super(midlet, screenWidth, screenHeight, "Request to connect from " + usernameFrom, "Network type " + linkName);
    createMenu(responseTypes);
  }
  private void createMenu(XurmoNetworkMessageResponseType[] responseTypes) {
    XurmoNetworkMessagesPopupMenuListener listener 
        = new XurmoNetworkMessagesPopupMenuListener(this, responseTypes);
    XurmoPopupMenu xpm = new XurmoPopupMenu(this.midlet_,
        this.screenWidth_,
        this.screenHeight_,
        listener.items(),
        listener);
    this.setMenu(xpm);
  }
  public String additionalText() {
    return responseString_;
  }
  public void clear() {
    responseString_ = null;
    responseId_ = 0;
  }
  int responseId_;
  String responseString_;
}
