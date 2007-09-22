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
public class XurmoInviteEntryPanel extends XurmoSelectablePanel {
  
  /** Creates a new instance of XurmoInviteEntryPanel */
  public XurmoInviteEntryPanel(Xurmo midlet, int screenWidth, int screenHeight, String line1, String line2, java.util.Vector linkTypes) {
    super(midlet, screenWidth, screenHeight, line1, line2);
    createMenu(linkTypes);
  }
  private void createMenu(java.util.Vector linkTypes) {
    XurmoInviteScreenPopupMenuListener listener 
        = new XurmoInviteScreenPopupMenuListener(this, linkTypes);
    XurmoPopupMenu xpm = new XurmoPopupMenu(this.midlet_,
        this.screenWidth_,
        this.screenHeight_,
        listener.items(),
        listener);
    this.setMenu(xpm);
  }
  public String additionalText() {
    return linkName_;
  }
  public void clear() {
    linkName_ = null;
    linkId_ = 0;
  }
  int linkId_;
  String linkName_;
}
