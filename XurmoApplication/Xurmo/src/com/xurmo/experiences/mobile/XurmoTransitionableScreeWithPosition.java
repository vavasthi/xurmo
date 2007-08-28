// =====================================================================
//                           Xurmo Proprietary
//               (c) Copyright 2007, Xurmo, All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          April 25, 2007
// =====================================================================

/**
 *
 * @file   XurmoTransitionableScreeWithPosition.java
 * @author
 * @date   April 25, 2007
 *
 * @brief
 *
 *
 */
// *********************************************************************
// Package
// *********************************************************************
package com.xurmo.experiences.mobile;
// *********************************************************************
// Imports
// *********************************************************************



public class XurmoTransitionableScreeWithPosition {
  
  /** Creates a new instance of XurmoTransitionableScreeWithPosition */
  public XurmoTransitionableScreeWithPosition(int xpos, int ypos, XurmoTransitionableScreenInterface screen) {
    
    xpos_ = xpos;
    ypos_ = ypos;
    screen_ = screen;
  }
  public void slideLeft(javax.microedition.lcdui.Graphics g) {
    xpos_ -= step_;
    screen_.draw(g, xpos_, ypos_);
  }
  public void slideRight(javax.microedition.lcdui.Graphics g) {
    xpos_ += step_;
    screen_.draw(g, xpos_, ypos_);
  }
  public void draw(javax.microedition.lcdui.Graphics g) {
    screen_.draw(g, xpos_, ypos_);
  }
  public int xpos() {
    return xpos_;
  }
  public XurmoTransitionableScreenInterface screen() {
    return screen_;
  }
  int xpos_;
  int ypos_;
  int step_ = 10;
  XurmoTransitionableScreenInterface screen_;
}
