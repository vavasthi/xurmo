/*
 * XurmoCanvasSliderTimerTask.java
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
public class XurmoCanvasSliderTimerTask extends java.util.TimerTask {
  
  XurmoSliderCanvas sliderCanvas_;
  /** Creates a new instance of XurmoCanvasSliderTimerTask */
  public XurmoCanvasSliderTimerTask(XurmoSliderCanvas sliderCanvas) {
    sliderCanvas_ = sliderCanvas;
  }
  public void run() {
    sliderCanvas_.slide();
  }
}
