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
        panels_ = new XurmoExpandablePanel[5];
        String[] m = new String[4];
        m[0] = new String("sam: Help, I am stuck on outer ring road");
        m[1] = new String("Siva: I am looking for a plumber, Any recommendations");
        m[2] = new String("Madhuri: I need to borrow your car for a day");
        m[3] = new String("John: Anyone for a game of golf this sunday");
        panels_[0] = new XurmoExpandablePanel(100, "You have 4 messages",  m, XurmoColors.blueBorder_, XurmoColors.blueTitle_, XurmoColors.blueExpanded_, XurmoColors.blueText_, this.getWidth());
        m = new String[0];
        panels_[1] = new XurmoExpandablePanel(100, "No Changes in your network", m, XurmoColors.greenBorder_, XurmoColors.greenTitle_, XurmoColors.greenExpanded_, XurmoColors.greenText_, this.getWidth());
        m = new String[3];
        m[0] = new String("dirtyharry is in your network");
        m[1] = new String("selfmademan is in your network");
        m[2] = new String("hellotome is in your network");
        panels_[2] = new XurmoExpandablePanel(100, "3 New Connections", m, XurmoColors.blueBorder_, XurmoColors.blueTitle_, XurmoColors.blueExpanded_, XurmoColors.blueText_, this.getWidth());
        m = new String[4];
        m[0] = new String("sam invites you to his social network");
        m[1] = new String("ramsey invites you to his professional network");
        m[2] = new String("ramesh invites you to his buddy network");
        m[3] = new String("mohan invites you to his sports network");
        panels_[3] = new XurmoExpandablePanel(100, "You have 4 new invitations", m, XurmoColors.greenBorder_, XurmoColors.greenTitle_, XurmoColors.greenExpanded_, XurmoColors.greenText_, this.getWidth());
        m = new String[0];
        panels_[4] = new XurmoExpandablePanel(100, "No new activity in marketplace", m, XurmoColors.blueBorder_, XurmoColors.blueTitle_, XurmoColors.blueExpanded_, XurmoColors.blueText_, this.getWidth());
        infocus_ = 0;
        panels_[infocus_].setExpanded(true);
    }
    public void paint(Graphics g) {
        
        int x = 0;
        int y = 0;
        int ob = g.getColor();
        g.setColor(XurmoColors.appBackground_);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        y = drawUserProfile(g, x, y);
        for (int i = 0; i < panels_.length; ++i) {
          
          y = panels_[i].paint(g, x, y);
        }
        g.setColor(ob);
    }
    private int drawUserProfile(Graphics g, int x, int y) {
        Image img = null;
        try {
            
            img = Image.createImage(this.getClass().getResourceAsStream("/resources/user.jpg"));
        }
        catch(IOException ex) {
            img = Image.createImage(x + 48, y + 48);
        }
        g.drawImage(img, x + 1, y + 1, Graphics.LEFT | Graphics.TOP);
        int oldColor = g.getColor();
        g.setColor(0, 0, 255);
        g.drawRect(0, 0, 50, 50);
        Font of = g.getFont();
        Font nf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);        
        g.setFont(nf);
        g.drawString(username_.substring(0, 1),x + 51, y + 0, Graphics.LEFT | Graphics.TOP);
        int h = nf.getHeight();
        int w = nf.charWidth(username_.charAt(0));
        nf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
        g.setFont(nf);
        g.drawString(username_.substring(1), x + 51 + w, y + h, Graphics.LEFT | Graphics.BOTTOM);
        int nw = x + 51 + w + nf.stringWidth(username_.substring(1));
        w = nf.stringWidth(directFriends_);
        g.setColor(0xff0000);
        g.drawArc(nw, y, w + 6, w + 6, 0, 360);
        g.drawString(directFriends_, nw + 3, y + 3, Graphics.LEFT | Graphics.TOP);
        return 50; // This block's height is 50 px
    }
   public void keyPressed(int keyCode) {
        switch(getGameAction(keyCode)) {
            case DOWN:
                downArrow();
                break;
            case UP:
                upArrow();
                break;
        }
        repaint();
    }
    void downArrow() {

        panels_[infocus_].setExpanded(false);
        ++infocus_;
        if (infocus_ >= panels_.length) {
            infocus_ =  0;
        }
        panels_[infocus_].setExpanded(true);
    }
    void upArrow() {
        panels_[infocus_].setExpanded(false);
        --infocus_;
        if (infocus_ < 0) {
            infocus_ = panels_.length - 1;
        }
        panels_[infocus_].setExpanded(true);
    }
    private String username_ = new String("John Doe");
    private String directFriends_ = new String("204");
    private int infocus_;
    private XurmoExpandablePanel[] panels_;
}
