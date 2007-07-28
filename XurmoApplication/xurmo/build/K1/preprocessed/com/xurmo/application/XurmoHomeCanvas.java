// =====================================================================
//                   Motorola Confidential Proprietary
//           (c) Copyright 2006, Motorola Inc. All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          December 20, 2006
// =====================================================================

/**
 *
 * @file   CricketCenterCanvas.java
 * @author
 * @date   December 20, 2006
 *
 * @brief
 *
 *
 */
// *********************************************************************
// Package
// *********************************************************************
package com.xurmo.application;
// *********************************************************************
// Imports
// *********************************************************************

import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import java.io.*;


public class XurmoHomeCanvas extends GameCanvas{
    
    /**
     * Creates a new instance of XurmoHomeCanvas
     */
    public XurmoHomeCanvas(boolean flag) {
        super(flag);
    }
    public void paint(Graphics g) {
        drawUserProfile(g);
    }
    private void drawUserProfile(Graphics g) {
        Image img = null;
        try {
            
            img = Image.createImage(this.getClass().getResourceAsStream("/resources/user.jpg"));
        }
        catch(IOException ex) {
            img = Image.createImage(48, 48);
        }
        g.drawImage(img, 1, 1, Graphics.LEFT | Graphics.TOP);
        int oldColor = g.getColor();
        g.setColor(0, 0, 255);
        g.drawRect(0, 0, 50, 50);
        Font of = g.getFont();
        Font nf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);        
        g.setFont(nf);
        g.drawString(username_.substring(0, 1),51, 0, Graphics.LEFT | Graphics.TOP);
        int h = nf.getHeight();
        int w = nf.charWidth(username_.charAt(0));
        nf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
        g.setFont(nf);
        g.drawString(username_.substring(1), 51 + w, 0 + h - nf.getHeight(), Graphics.LEFT | Graphics.TOP);
    }
    private String username_ = new String("John Doe");
}
