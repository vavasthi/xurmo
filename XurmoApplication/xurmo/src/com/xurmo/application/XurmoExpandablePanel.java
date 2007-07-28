// =====================================================================
//                   Motorola Confidential Proprietary
//           (c) Copyright 2006, Motorola Inc. All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          March 30, 2007
// =====================================================================

/**
 *
 * @file   XurmoExpandablePanel.java
 * @author
 * @date   March 30, 2007
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


public class XurmoExpandablePanel {
    
    /** Creates a new instance of XurmoExpandablePanel */
    public XurmoExpandablePanel(int maxHeight, String title, String[] items, int borderColor, int titleColor, int expandedColor, int textColor, int w) {
        w_ = w;
        maxHeight_ = maxHeight;
        title_ = title;
        items_ = items;
        expanded_ = false;
        borderColor_ = borderColor;
        titleColor_ = titleColor;
        expandedColor_ = expandedColor;
        textColor_ = textColor;
    }
    public int getHeight(Graphics g) {
        
        int minHeight = g.getFont().getHeight() + 4;
        if (!expanded_ ) {
            return minHeight;
        } else {
            Font nf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);        
            int additionalHeight = nf.getHeight() * items_.length;
            int neededHeight = minHeight + additionalHeight;
            if ( additionalHeight > maxHeight_) {
                return maxHeight_;
            } else {
                return neededHeight;
            }
        }
    }
    public int paint(Graphics g, int x, int y) {
        
        int height = 0;
        int starty = y;
        if (expanded_) {
            
            int minHeight = g.getFont().getHeight() + 4;
            int h = this.getHeight(g);
            g.setColor(expandedColor_);
            g.fillRect(x, y, w_, h);
            g.setColor(borderColor_);
            g.drawRect(x, y, w_, h);
            g.setColor(titleColor_);
            g.fillRect(x, y, w_, minHeight + 4);
            g.setColor(borderColor_);
            g.drawRect(x, y, w_, minHeight + 4);
            g.drawRect(x + 1, y + 1, w_ - 1, minHeight + 3);
            g.setColor(textColor_);
            g.drawString(title_, x + 2, y + 2, Graphics.LEFT | Graphics.TOP);
            int curY = y + minHeight;
            Font nf = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);        
            Font of = g.getFont();
            g.setFont(nf);
            for (int i = 0; i < items_.length; ++i) {
                if (curY + g.getFont().getHeight() > maxHeight_ + starty) {
                    height = curY + g.getFont().getHeight();
                    return height;
                }
                g.drawString(items_[i], x + 2, curY, Graphics.LEFT | Graphics.TOP);
                curY += g.getFont().getHeight();
            }
            g.setFont(of);
            height = curY;
        } else {
            
            int minHeight = g.getFont().getHeight() + 4;
            g.setColor(titleColor_);
            g.fillRect(x, y, w_, minHeight + 4);
            g.setColor(borderColor_);
            g.drawRect(x, y, w_, minHeight + 4);
            g.drawRect(x + 1, y + 1, w_ - 1, minHeight + 3);
            g.setColor(textColor_);
            g.drawString(title_, x + 2, y + 2, Graphics.LEFT + Graphics.TOP);
            height = minHeight + y;
        }
        return height;
    }
    public void setExpanded(boolean expanded) {
        expanded_ = expanded;
    }
    private int w_;
    private int maxHeight_;
    private String title_;
    private String[] items_;
    private boolean expanded_;
    private int borderColor_;
    private int titleColor_;
    private int expandedColor_;
    private int textColor_;
}