/*
 * XurmoPopupMenu.java
 *
 * Created on September 9, 2007, 9:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;
import javax.microedition.lcdui.Font;

/**
 *
 * @author Vinay
 */
public class XurmoPopupMenu {
  Xurmo midlet_;
  int screenWidth_;
  int screenHeight_;
  int w_;
  int h_;
  XurmoPopupMenuItem[] items_;
  int currentItem_;
  XurmoPopupMenuListener listener_;
  boolean visible_;
  private static final int border = 6; 
  /** Creates a new instance of XurmoPopupMenu */
  public XurmoPopupMenu(Xurmo midlet, 
      int screenWidth,
      int screenHeight,
      XurmoPopupMenuItem[] items,
      XurmoPopupMenuListener listener) {
    
    midlet_ = midlet;
    screenWidth_ = screenWidth;
    screenHeight_ = screenHeight;
    items_ = items;
    int h = 0;
    int w = 0;
    Font sf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);;
    for (int i = 0; i < items_.length; ++i) {
      
      h += sf.getHeight();
      w = Math.max(w, sf.stringWidth(items_[i].item_));
    }
    h_ = Math.min(h, (2 * screenHeight_ / 3));
    w_ = Math.min(w, screenWidth_ / 2);
    currentItem_ = 0;
    items_[currentItem_].selected_ = true;
    listener_ = listener;
  }
  private int calculateStartingItem() {

    Font sf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);;
    int itemsFitting = h_ / sf.getHeight();
    if (currentItem_ - itemsFitting < 0) {
      return 0;
    }
    else {
      return currentItem_ + 1 - itemsFitting;
    }
  }
  public void draw(javax.microedition.lcdui.Graphics g, int x, int y) {

    Font sf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
    g.setFont(sf);
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    int sy = y;
    if (sy + h_ + (border * 2) > screenHeight_) { 
      sy = screenHeight_ - (h_ + (border * 2));
    }
    int sx = ((screenWidth_ - (w_ + (border * 2)))/ 2 );
    g.setColor(ct.collapsablePanelUnselectedBackgroundColorValue_);
    g.fillRect(sx, sy, w_ + (border * 2), h_ + (border * 2));
    sx += border;
    sy += border;
    g.setColor(ct.collapsablePanelSelectedTitleBackgroundValue_);
    g.fillRoundRect(sx, sy, w_, h_, 30, 30);
    g.setColor(ct.collapsablePanelSelectedContentBackgroundColorValue_);
    g.drawRoundRect(sx + 1, sy + 1, w_ - 2, h_ - 2, 30, 30);
    int sItem = calculateStartingItem();
    g.setColor(ct.collapsablePanelUnselectedForegroundColorValue_);
    for (int i = sItem; i < items_.length && sy < sy + h_; ++i) {
      items_[i].draw(g, sx, sy, w_, sf.getHeight(), ct);
      sy += sf.getHeight();
    }
  }
  public void downKey() {
    items_[currentItem_].selected_= false;
    ++currentItem_;
    if (currentItem_ >= items_.length) {
      currentItem_ = 0;
    }
    items_[currentItem_].selected_ = true;
  }
  public void upKey() {
    
    items_[currentItem_].selected_ = false;
    --currentItem_;
    if (currentItem_ < 0) {
      currentItem_ = items_.length - 1;
    }
    items_[currentItem_].selected_ = true;
  }
  public void leftKey() {    
      hide();
  }
  public void fireKey() {
    if (listener_ != null) {
      
      listener_.menuAction(items_[currentItem_]);
      hide();
    }
  }
  public void show() {
    this.visible_ = true;
  }
  public void hide() {
    this.visible_ = false;
  }
}
