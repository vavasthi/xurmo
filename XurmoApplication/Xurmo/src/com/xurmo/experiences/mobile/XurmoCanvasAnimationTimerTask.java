/*
 * XurmoCanvasAnimationTimerTask.java
 *
 * Created on September 2, 2007, 9:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

/**
 *
 * @author Vinay
 */
public class XurmoCanvasAnimationTimerTask extends java.util.TimerTask {
  
  XurmoAnimatedCanvas canvas_;
  /**
   * Creates a new instance of XurmoCanvasAnimationTimerTask
   */
  public XurmoCanvasAnimationTimerTask(XurmoAnimatedCanvas canvas) {
    canvas_ = canvas;
  }
  public void run() {
    canvas_.animateStep();
  }
}
