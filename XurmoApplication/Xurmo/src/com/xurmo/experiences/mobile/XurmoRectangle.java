/*
 * XurmoRectangle.java
 *
 * Created on September 2, 2007, 10:02 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author Vinay
 */
public class XurmoRectangle {
  private int x_;
  private int y_;
  private int w_;
  private int h_;
  /** Creates a new instance of XurmoRectangle */
  public XurmoRectangle(int x, int y, int w, int h) {
    
    x_ = x;
    y_ = y;
    w_ = w;
    h_ = h;
  }
  XurmoRectangle clipWidthFromRight(int w1) {
    int x = x_;
    int y = y_;
    int w = w_ - w1;
    int h = h_;
    return new XurmoRectangle(x, y, w, h);
  }
  XurmoRectangle clipWidthFromLeft(int w1) {
    int x = x_ + w1;
    int y = y_;
    int w = w_ - w1;
    int h = h_;
    return new XurmoRectangle(x, y, w, h);
  }
  public int x() {
    return x_;
  }
  public int y() {
    return y_;
  }
  public int w() {
    return w_;
  }
  public int h() {
    return h_;
  }
}
