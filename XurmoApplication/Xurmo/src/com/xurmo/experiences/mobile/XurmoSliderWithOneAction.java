/*
 * XurmoSliderCanvas.java
 *
 * Created on September 2, 2007, 9:34 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

import java.util.Timer;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.Font;

/**
 *
 * @author Vinay
 */
public class XurmoSliderWithOneAction extends XurmoCanvas implements XurmoAnimatedCanvas {
  XurmoCanvas destinationCanvas_;
  private Image src_;
  private Image dst_;
  private int dir_;
  private String line1_;
  private String line2_;
  private int xDelta_;
  public final static int LEFT = 1;
  public final static int RIGHT = 2;
  private XurmoRectangle srcRect_;
  private XurmoRectangle dstRect_;
  private Timer t_;
  private static final int pixelsPerStep_ = 5;
  private boolean confirmed_;
  /**
   * Creates a new instance of XurmoSliderCanvas
   */
  public XurmoSliderWithOneAction(Xurmo midlet, XurmoCanvas src, XurmoCanvas dst, String line1, String line2, int dir) {
    
    super(midlet, false);
    if (src instanceof XurmoScrollableScreen) {
      ((XurmoScrollableScreen)src).deactivateMenu();
    }
    destinationCanvas_ = dst;
    src_ = Image.createImage(getWidth(), getHeight());
    dst_ = Image.createImage(getWidth(), getHeight());
    src.paint(src_.getGraphics());
    dst.paint(dst_.getGraphics());
    srcRect_ = new XurmoRectangle(0, tbHeight_, getWidth(), getHeight() - tbHeight_);
    dstRect_ = new XurmoRectangle(0, tbHeight_, getWidth(), getHeight() - tbHeight_);
    dir_ = dir;
    xDelta_ = 0;
    line1_ = line1;
    line2_ = line2;
    this.setFullScreenMode(true);
    confirmed_ = false;
  }
  private void initializeTimer() {
    t_ = new Timer();
    t_.schedule(new XurmoCanvasAnimationTimerTask(this), 10, 10);
  }
  public void animateStep() {
    
    if (xDelta_ + pixelsPerStep_ > getWidth()) {
      t_.cancel();
      midlet_.getDisplay().setCurrent(destinationCanvas_);
    }
    xDelta_ += pixelsPerStep_;
    repaint();
  }
  private void drawConfirmationDialog(Graphics g) {
    
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    Font f = g.getFont();
    int dialogHeight = f.getHeight() * 5;
    int dialogWidth = Math.max(f.stringWidth(line1_), f.stringWidth(line2_));
    if (dialogWidth > this.getWidth()) {
      dialogWidth = this.getWidth() * 3 / 4;
    }
    int sx = (getWidth() - dialogWidth) / 2;
    int sy = (getHeight() - dialogHeight) / 2;
    g.setColor(ct.collapsablePanelUnselectedBackgroundColorValue_);
    g.fillRoundRect(sx - 2, sy - 2, dialogWidth + 4, dialogHeight + 4, 20, 20);
    g.setColor(ct.collapsablePanelSelectedTitleBackgroundValue_);
    g.fillRoundRect(sx - 2, sy - 2, dialogWidth + 4, dialogHeight + 4, 20, 20);
    g.setColor(ct.collapsablePanelUnselectedForegroundColorValue_);
    g.drawString(line1_, sx + 1, sy + 1, g.LEFT | g.TOP);
    g.drawString(line2_, sx + 1, sy + 1 + f.getHeight(), g.LEFT | g.TOP);
  }
  public void paint(Graphics g) {
    drawTitle(g);
    drawBackgroundGradient(g);
    XurmoRectangle s;
    XurmoRectangle d;
    if (confirmed_) {
      
      if (dir_ == LEFT) {
        s = srcRect_.clipWidthFromLeft(xDelta_);
        d = dstRect_.clipWidthFromRight(getWidth() - xDelta_);
        g.drawImage(Image.createImage(src_, s.x(), s.y(), s.w(), s.h(), Sprite.TRANS_NONE), 0, tbHeight_, Graphics.LEFT|Graphics.TOP);
        g.drawImage(Image.createImage(dst_, d.x(), d.y(), d.w(), d.h(), Sprite.TRANS_NONE), getWidth() - xDelta_, tbHeight_, Graphics.LEFT|Graphics.TOP);
      } else {
        s = srcRect_.clipWidthFromRight(xDelta_);
        d = dstRect_.clipWidthFromLeft(getWidth() - xDelta_);
        g.drawImage(Image.createImage(src_, s.x(), s.y(), s.w(), s.h(), Sprite.TRANS_NONE), xDelta_, tbHeight_, Graphics.LEFT|Graphics.TOP);
        g.drawImage(Image.createImage(dst_, d.x(), d.y(), d.w(), d.h(), Sprite.TRANS_NONE), 0, tbHeight_, Graphics.LEFT|Graphics.TOP);
      }
    }
    else {
      drawConfirmationDialog(g);
    }
    
  }
  public void downKey() {
    
  }
  public void upKey() {
    
  }
  public void fireKey() {
    if (!confirmed_) {
      
      confirmed_ = true;
      initializeTimer();
    }
  }
  public void leftKey() {
    
  }
  public void rightKey() {
    
  }
}
