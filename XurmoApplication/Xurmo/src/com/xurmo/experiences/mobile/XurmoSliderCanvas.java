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

/**
 *
 * @author Vinay
 */
public class XurmoSliderCanvas extends XurmoCanvas implements XurmoAnimatedCanvas {
  XurmoCanvas destinationCanvas_;
  private Image src_;
  private Image dst_;
  private int dir_;
  private int xDelta_;
  public final static int LEFT = 1;
  public final static int RIGHT = 2;
  private XurmoRectangle srcRect_;
  private XurmoRectangle dstRect_;
  private Timer t_;
  private static final int pixelsPerStep_ = 5;
  /**
   * Creates a new instance of XurmoSliderCanvas
   */
  public XurmoSliderCanvas(Xurmo midlet, XurmoCanvas src, XurmoCanvas dst, int dir) {

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
    this.setFullScreenMode(true);
    initializeTimer();
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
  public void paint(Graphics g) {
    drawTitle(g);
    drawBackgroundGradient(g);
    XurmoRectangle s;
    XurmoRectangle d;
    if (dir_ == LEFT) {
      s = srcRect_.clipWidthFromLeft(xDelta_);
      d = dstRect_.clipWidthFromRight(getWidth() - xDelta_);
      g.drawImage(Image.createImage(src_, s.x(), s.y(), s.w(), s.h(), Sprite.TRANS_NONE), 0, tbHeight_, Graphics.LEFT|Graphics.TOP);
      g.drawImage(Image.createImage(dst_, d.x(), d.y(), d.w(), d.h(), Sprite.TRANS_NONE), getWidth() - xDelta_, tbHeight_, Graphics.LEFT|Graphics.TOP);
    }
    else {
      s = srcRect_.clipWidthFromRight(xDelta_);
      d = dstRect_.clipWidthFromLeft(getWidth() - xDelta_);
      g.drawImage(Image.createImage(src_, s.x(), s.y(), s.w(), s.h(), Sprite.TRANS_NONE), xDelta_, tbHeight_, Graphics.LEFT|Graphics.TOP);
      g.drawImage(Image.createImage(dst_, d.x(), d.y(), d.w(), d.h(), Sprite.TRANS_NONE), 0, tbHeight_, Graphics.LEFT|Graphics.TOP);
    }
    
  }  
  public void downKey() {
    
  }
  public void upKey() {
    
  }
  public void fireKey() {
    
  }
  public void leftKey() {
    
  }
  public void rightKey() {
    
  }
}
