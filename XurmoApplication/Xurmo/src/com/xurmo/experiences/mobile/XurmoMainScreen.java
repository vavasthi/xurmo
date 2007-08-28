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
 * @file   XurmoMainScreen.java
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



public class XurmoMainScreen extends XurmoTransitionableScreen {
  
    Xurmo midlet_;
  /** Creates a new instance of XurmoMainScreen */
  public XurmoMainScreen(Xurmo midlet) {
      midlet_ = midlet;
  }
  public void draw(javax.microedition.lcdui.Graphics g, int x, int y) {
    g.drawString("Main Screen", x, y, g.LEFT | g.TOP);
  }
}
