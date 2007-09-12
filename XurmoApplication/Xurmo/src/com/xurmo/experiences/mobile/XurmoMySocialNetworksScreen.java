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
 * @file   XurmoMyNetworksScreen.java
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

import javax.microedition.io.*;

public class XurmoMySocialNetworksScreen extends XurmoCanvas {
  /**
   * Creates a new instance of XurmoHomeScreen
   */
  public XurmoMySocialNetworksScreen(Xurmo midlet) {
    super(midlet, false);
    XurmoTheme ct = XurmoThemeManager.instance().getCurrentTheme();
    
    summary_ = new XurmoCollapsablePanel(getWidth(), getHeight(), ct.meIconImage_, "Social Networks Summary");
    int kount = midlet_.otherSocialNetworks_.size();
    summary_.addContent("" + kount + " other social networks known.");
    summary_.selected(true);
    currentPanel_ = 0;

    int k = midlet_.otherSocialNetworks_.size();
    String twitterUsername = null;
    String twitterPassword = null;
    String jaikuUsername = null;
    String jaikuPersonalKey = null;
    String tmp;
    for (int i = 0; i < k; ++i) {
      XurmoOtherSocialNetworkDetails xosnd 
          = (XurmoOtherSocialNetworkDetails)(midlet_.otherSocialNetworks_.elementAt(i));
      if (xosnd.socialNetwork_.equals("Twitter")) {
        tmp = xosnd.getAttribute("username");
        if (tmp != null) {
          twitterUsername = tmp;
        }
        tmp = xosnd.getAttribute("password");
        if (tmp != null) {
          twitterPassword = tmp;
        }
      }
      else if (xosnd.socialNetwork_.equals("Jaiku")) {
        tmp = xosnd.getAttribute("username");
        if (tmp != null) {
          jaikuUsername = tmp;
        }
        tmp = xosnd.getAttribute("personalKey");
        if (tmp != null) {
          jaikuPersonalKey = tmp;
        }
      }
    }
  
    twitter_ = new XurmoCollapsablePanel(getWidth(), getHeight(), ct.meIconImage_, "Twitter");
    if (twitterUsername != null) {
      
      twitter_.addContent("Username :" + twitterUsername);
    }
    jaiku_ = new XurmoCollapsablePanel(getWidth(), getHeight(), ct.meIconImage_, "Jaiku");
    if (jaikuUsername != null) {
      
      jaiku_.addContent("Username :" + jaikuUsername);
    }

    home_ = new XurmoCollapsablePanel(getWidth(), getHeight(), ct.friendsSmallImage_, "Home");
    
    panels_ = new XurmoCollapsablePanel[]{
      summary_,
      twitter_,
      jaiku_,
      home_
    };
  }
  
  public void paint(javax.microedition.lcdui.Graphics g) {
    drawBackgroundGradient(g);
    drawTitle(g);
    int x = 0;
    int y = tbHeight_;    
    for (int i = 0; i < panels_.length; ++i) {
      panels_[i].draw(g, x, y);
      y += panels_[i].h();
    }
/*    me_.draw(g, x, y);
    y += me_.h();
    mydoodles_.draw(g, x, y);
    y += mydoodles_.h();
    interactions_.draw(g, x, y);
    y += interactions_.h();
    friendsAndCommunity_.draw(g, x, y);
    y += friendsAndCommunity_.h();*/
  }
  public void downKey() {
    panels_[currentPanel_].selected(false);
    ++currentPanel_;
    if (currentPanel_ >= panels_.length) {
      currentPanel_ = 0;
    }
    panels_[currentPanel_].selected(true);
  }
  public void upKey() {
    
    panels_[currentPanel_].selected(false);
    --currentPanel_;
    if (currentPanel_ < 0) {
      currentPanel_ = panels_.length - 1;
    }
    panels_[currentPanel_].selected(true);
  }
  public void fireKey() {
    if (panels_[currentPanel_] == home_) {
      midlet_.transitionToHomeScreen();
    }
    else if (panels_[currentPanel_] == twitter_) {
      String username = new String("");
      XurmoOtherSocialNetworkDetails xosnd 
          = getSocialNetworkDetails("Twitter");
      if (xosnd != null) {
        String tmp = xosnd.getAttribute("username");
        if (tmp != null) {
          username = tmp;
        }
      }
      XurmoTwitterPreferencesEdit xtpe = new XurmoTwitterPreferencesEdit(this, username);
      midlet_.getDisplay().setCurrent(xtpe);
    }
    if (panels_[currentPanel_] == jaiku_) {
      String username = new String("");
      XurmoOtherSocialNetworkDetails xosnd 
          = getSocialNetworkDetails("Jaiku");
      if (xosnd != null) {
        String tmp = xosnd.getAttribute("username");
        if (tmp != null) {
          username = tmp;
        }
      }
      XurmoJaikuPreferencesEdit xtpe = new XurmoJaikuPreferencesEdit(this, username);
      midlet_.getDisplay().setCurrent(xtpe);
    }
  }
  public XurmoOtherSocialNetworkDetails getSocialNetworkDetails(String snName) {
    
    int snKount = midlet_.otherSocialNetworks_.size();
    for (int i = 0; i < snKount; ++i) {
      XurmoOtherSocialNetworkDetails tmp 
          = (XurmoOtherSocialNetworkDetails)(midlet_.otherSocialNetworks_.elementAt(i));
      if (tmp.socialNetwork_.equals(snName)) {
        return tmp;
      }
    }
    return null;
  }
  public void updateTwitterPreference(String username, String password) {
    XurmoOtherSocialNetworkDetails xosnd = getSocialNetworkDetails("Twitter");
    
    if (xosnd == null) {
      xosnd = new XurmoOtherSocialNetworkDetails("Twitter");
      midlet_.otherSocialNetworks_.addElement(xosnd);
    }
    xosnd.clearAttributes();
    xosnd.add("username", username);
    xosnd.add("password", password);
    midlet_.storeOtherSocialNetworkDetails();
    midlet_.getDisplay().setCurrent(this);
  }
  public void updateJaikuPreference(String username, String personalKey) {
    XurmoOtherSocialNetworkDetails xosnd = getSocialNetworkDetails("Jaiku");
    if (xosnd == null) {
      xosnd = new XurmoOtherSocialNetworkDetails("Jaiku");
      midlet_.otherSocialNetworks_.addElement(xosnd);
    }
    xosnd.clearAttributes();
    xosnd.add("username", username);
    xosnd.add("personalKey", personalKey);
    midlet_.storeOtherSocialNetworkDetails();
    midlet_.getDisplay().setCurrent(this);
  }
  public void cancelSocialNetworkPreferenceEdit() {
    
    midlet_.getDisplay().setCurrent(this);
  }

  public void rightKey() {
  }
  public void leftKey() {
    midlet_.transitionToHomeScreen();
  }
  int ypos_;
  private int currentPanel_;
  XurmoCollapsablePanel summary_;
  XurmoCollapsablePanel twitter_;
  XurmoCollapsablePanel jaiku_;
  XurmoCollapsablePanel home_;
  XurmoCollapsablePanel[] panels_;
}
