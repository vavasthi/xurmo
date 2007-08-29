// =====================================================================
//                           Xurmo Proprietary
//               (c) Copyright 2007, Xurmo, All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          April 24, 2007
// =====================================================================

/**
 *
 * @file   XurmoThemeManager.java
 * @author
 * @date   April 24, 2007
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
import java.io.*;
import org.kxml2.io.*;
import org.xmlpull.v1.*;
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.Font;

public class XurmoThemeManager {
  
  /** Creates a new instance of XurmoThemeManager */
  private XurmoThemeManager(int screenWidth, int screenHeight, int titleHeight, int middleHeight) {
    screenWidth_ = screenWidth;
    screenHeight_ = screenHeight;
    titleHeight_ = titleHeight;
    middleHeight_ = middleHeight;
    initialize();
  }
  public static void init(Xurmo midlet) {
    if (self_ == null) {
      XurmoSplashScreen ss = new XurmoSplashScreen();
      midlet.getDisplay().setCurrent(ss);
      int titleHeight = 0;
      Font f = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
      titleHeight += f.getHeight();
      self_ = new XurmoThemeManager(ss.getWidth(), ss.getHeight(), titleHeight, ss.getHeight() - titleHeight);
    }
  }
  
  public static XurmoThemeManager instance() {
    return self_;
  }
  public XurmoTheme getCurrentTheme() {
    return currentTheme_;
  }
  private int getCurrentContext() {
    if (currentContext_.empty()) {
      return noTag_.context();
    } else {
      Integer i = (Integer)(currentContext_.peek());
      return i.intValue();
    }
  }
  private int popContext() {
    if (currentContext_.empty()) {
      return noTag_.context();
    } else {
      Integer i = (Integer)(currentContext_.pop());
      return i.intValue();
    }
  }
  private int pushContext(String tagName) {
    
    for (int i = 0; i < tags_.length;++i) {
      
      if (tagName.equalsIgnoreCase(tags_[i].tag())) {
        int c = tags_[i].context();
        currentContext_.push(new Integer(c));
        return c;
      }
    }
    int c = noTag_.context();
    currentContext_.push(new Integer(c));
    return c;
  }
  
  private void initialize() {
    currentContext_ = new java.util.Stack();
    themeList_ = new java.util.Vector();
    try {
      String nameValue= null;
      String descriptionValue= null;
      String iconDirValue= null;
      String arrowLeftValue= null;
      String arrowRightValue= null;
      String backgroundMiddleValue= null;
      String backgroundTopValue= null;
      String clockIconValue= null;
      String communityBigValue= null;
      String communitySmallValue= null;
      String friendsBigValue= null;
      String friendsSmallValue= null;
      String incomingCallValue= null;
      String interactionValue= null;
      String interactionIconValue= null;
      String meIconValue= null;
      String missedCallValue= null;
      String myplaceIconValue= null;
      String outgoingCallValue= null;
      String photoMsgValue= null;
      String radioIconValue= null;
      String readMsgValue= null;
      String ringtoneIconValue= null;
      String unreadMsgValue= null;
      String writeNewInteractionValue = null;
      int titleForegroundColorValue = 0;
      int collapsablePanelSelectedTitleBackgroundValue = 0;
      int collapsablePanelSelectedContentBackgroundColorValue = 0;
      int collapsablePanelSelectedForegroundColorValue = 0;
      int collapsablePanelUnselectedForegroundColorValue = 0;
      int collapsablePanelUnselectedBackgroundColorValue = 0;

  InputStreamReader themeReader = new InputStreamReader( getClass().getResourceAsStream("/resources/themes.xml"));
      KXmlParser themes = new KXmlParser();
      themes.setInput(themeReader);
      
      int nextTag = themes.nextTag();
      do {
        switch(nextTag){
          case XmlPullParser.START_TAG:
          {
            String tag = themes.getName();
            pushContext(tag);
            
          }
          break;
          case XmlPullParser.TEXT:
          {
            
            String tag = themes.getName();
            int cc = getCurrentContext();
            if(cc == themesTag_.context() || cc == themeTag_.context()) {
              // Do nothing
            } else if(cc == nameTag_.context()) {
              nameValue = themes.getText();
            } else if(cc == descriptionTag_.context()) {
              descriptionValue = themes.getText();
            } else if(cc == iconDirTag_.context()) {
              iconDirValue = themes.getText();
            } else if(cc == arrowLeftTag_.context()) {
              arrowLeftValue = themes.getText();
            } else if(cc == arrowRightTag_.context()) {
              arrowRightValue = themes.getText();
            } else if(cc == backgroundMiddleTag_.context()) {
              backgroundMiddleValue = themes.getText();
            } else if(cc == backgroundTopTag_.context()) {
              backgroundTopValue = themes.getText();
            } else if(cc == clockIconTag_.context()) {
              clockIconValue = themes.getText();
            } else if(cc == communityBigTag_.context()) {
              communityBigValue = themes.getText();
            } else if(cc == communitySmallTag_.context()) {
              communitySmallValue = themes.getText();
            } else if(cc == friendsBigTag_.context()) {
              friendsBigValue = themes.getText();
            } else if(cc == friendsSmallTag_.context()) {
              friendsSmallValue = themes.getText();
            } else if(cc == incomingCallTag_.context()) {
              incomingCallValue = themes.getText();
            } else if(cc == interactionTag_.context()) {
              interactionValue = themes.getText();
            } else if(cc == interactionIconTag_.context()) {
              interactionIconValue = themes.getText();
            } else if(cc == meIconTag_.context()) {
              meIconValue = themes.getText();
            } else if(cc == missedCallTag_.context()) {
              missedCallValue = themes.getText();
            } else if(cc == myplaceIconTag_.context()) {
              myplaceIconValue = themes.getText();
            } else if(cc == outgoingCallTag_.context()) {
              outgoingCallValue = themes.getText();
            } else if(cc == photoMsgTag_.context()) {
              photoMsgValue = themes.getText();
            } else if(cc == radioIconTag_.context()) {
              radioIconValue = themes.getText();
            } else if(cc == readMsgTag_.context()) {
              readMsgValue = themes.getText();
            } else if(cc == ringtoneIconTag_.context()) {
              ringtoneIconValue = themes.getText();
            } else if(cc == unreadMsgTag_.context()) {
              unreadMsgValue = themes.getText();
            } else if(cc == writeNewInteractionTag_.context()) {
              writeNewInteractionValue = themes.getText();
            } else if(cc == titleForegroundColorTag_.context()) {
              String sv = themes.getText().toUpperCase();
              if (sv.startsWith("0X")) {
                sv = sv.substring(2);
                titleForegroundColorValue = Integer.parseInt(sv, 16);
              }
              else {
                
                titleForegroundColorValue = Integer.parseInt(sv);
              }
            } else if(cc == collapsablePanelSelectedTitleBackgroundColorTag_.context()) {
              String sv = themes.getText().toUpperCase();
              if (sv.startsWith("0X")) {
                sv = sv.substring(2);
                collapsablePanelSelectedTitleBackgroundValue = Integer.parseInt(sv, 16);
              }
              else {
                
                collapsablePanelSelectedTitleBackgroundValue = Integer.parseInt(sv);
              }
            } else if(cc == collapsablePanelSelectedContentBackgroundColorTag_.context()) {
              String sv = themes.getText().toUpperCase();
              if (sv.startsWith("0X")) {
                sv = sv.substring(2);
                collapsablePanelSelectedContentBackgroundColorValue = Integer.parseInt(sv, 16);
              }
              else {
                
                collapsablePanelSelectedContentBackgroundColorValue = Integer.parseInt(sv);
              }
            } else if(cc == collapsablePanelSelectedForegroundColorTag_.context()) {
              String sv = themes.getText().toUpperCase();
              if (sv.startsWith("0X")) {
                sv = sv.substring(2);
                collapsablePanelSelectedForegroundColorValue = Integer.parseInt(sv, 16);
              }
              else {
                
                collapsablePanelSelectedForegroundColorValue = Integer.parseInt(sv);
              }
            } else if(cc == collapsablePanelUnselectedForegroundColorTag_.context()) {
              String sv = themes.getText().toUpperCase();
              if (sv.startsWith("0X")) {
                sv = sv.substring(2);
                collapsablePanelUnselectedForegroundColorValue = Integer.parseInt(sv, 16);
              }
              else {
                
                collapsablePanelUnselectedForegroundColorValue = Integer.parseInt(sv);
              }
            } else if(cc == collapsablePanelUnselectedBackgroundColorTag_.context()) {
              String sv = themes.getText().toUpperCase();
              if (sv.startsWith("0X")) {
                sv = sv.substring(2);
                collapsablePanelUnselectedBackgroundColorValue = Integer.parseInt(sv, 16);
              }
              else {
                
                collapsablePanelUnselectedBackgroundColorValue = Integer.parseInt(sv);
              }
            }
          }
          break;
          case XmlPullParser.END_TAG:
          {
            int c = popContext();
            String tag = themes.getName();
            if (c == themeTag_.context() && 
                nameValue != null &&
                descriptionValue != null &&
                iconDirValue != null &&
                arrowLeftValue != null &&
                arrowRightValue != null &&
                backgroundMiddleValue != null &&
                backgroundTopValue != null &&
                clockIconValue != null &&
                communityBigValue != null &&
                communitySmallValue != null &&
                friendsBigValue != null &&
                friendsSmallValue != null &&
                incomingCallValue != null &&
                interactionValue != null &&
                interactionIconValue != null &&
                meIconValue != null &&
                missedCallValue != null &&
                myplaceIconValue != null &&
                outgoingCallValue != null &&
                photoMsgValue != null &&
                radioIconValue != null &&
                readMsgValue != null &&
                ringtoneIconValue != null &&
                unreadMsgValue != null &&
                writeNewInteractionValue  != null) {
              XurmoTheme t = new XurmoTheme(screenWidth_, 
                  screenHeight_,
                  titleHeight_,
                  middleHeight_,
                  nameValue,
                  descriptionValue,
                  iconDirValue,
                  arrowLeftValue,
                  arrowRightValue,
                  backgroundMiddleValue,
                  backgroundTopValue,
                  clockIconValue,
                  communityBigValue,
                  communitySmallValue,
                  friendsBigValue,
                  friendsSmallValue,
                  incomingCallValue,
                  interactionValue,
                  interactionIconValue,
                  meIconValue,
                  missedCallValue,
                  myplaceIconValue,
                  outgoingCallValue,
                  photoMsgValue,
                  radioIconValue,
                  readMsgValue,
                  ringtoneIconValue,
                  unreadMsgValue,
                  writeNewInteractionValue,
                  titleForegroundColorValue,
                  collapsablePanelSelectedTitleBackgroundValue,
                  collapsablePanelSelectedContentBackgroundColorValue,
                  collapsablePanelSelectedForegroundColorValue,
                  collapsablePanelUnselectedForegroundColorValue,
                  collapsablePanelUnselectedBackgroundColorValue);
              themeList_.addElement(t);
            }
          }
          break;
        }
        nextTag = themes.nextToken();
      }
      while(nextTag != XmlPullParser.END_DOCUMENT);
    } catch(IOException e){
      return;
    } catch(XmlPullParserException xppe){
      xppe.printStackTrace();
      return;
    }
    currentTheme_ = (XurmoTheme)themeList_.firstElement();
  }
  private static XurmoThemeManager self_ = null;
  
  private java.util.Vector themeList_;
  private XurmoTheme currentTheme_;
  private java.util.Stack currentContext_;
  
  private final XurmoThemeXmlTag noTag_                 = new XurmoThemeXmlTag("no");
  private final XurmoThemeXmlTag themesTag_             = new XurmoThemeXmlTag("themes");
  private final XurmoThemeXmlTag themeTag_              = new XurmoThemeXmlTag("theme");
  private final XurmoThemeXmlTag nameTag_               = new XurmoThemeXmlTag("name");
  private final XurmoThemeXmlTag descriptionTag_        = new XurmoThemeXmlTag("description");
  private final XurmoThemeXmlTag iconDirTag_            = new XurmoThemeXmlTag("icon-dir");
  private final XurmoThemeXmlTag arrowLeftTag_          = new XurmoThemeXmlTag("arrow-left");
  private final XurmoThemeXmlTag arrowRightTag_         = new XurmoThemeXmlTag("arrow-right");
  private final XurmoThemeXmlTag backgroundMiddleTag_   = new XurmoThemeXmlTag("background-middle");
  private final XurmoThemeXmlTag backgroundTopTag_      = new XurmoThemeXmlTag("background-top");
  private final XurmoThemeXmlTag clockIconTag_          = new XurmoThemeXmlTag("clock-icon");
  private final XurmoThemeXmlTag communityBigTag_       = new XurmoThemeXmlTag("community-big");
  private final XurmoThemeXmlTag communitySmallTag_     = new XurmoThemeXmlTag("community-small");
  private final XurmoThemeXmlTag friendsBigTag_         = new XurmoThemeXmlTag("friends-big");
  private final XurmoThemeXmlTag friendsSmallTag_       = new XurmoThemeXmlTag("friends-small");
  private final XurmoThemeXmlTag incomingCallTag_       = new XurmoThemeXmlTag("incoming-call");
  private final XurmoThemeXmlTag interactionTag_        = new XurmoThemeXmlTag("interaction");
  private final XurmoThemeXmlTag interactionIconTag_    = new XurmoThemeXmlTag("interaction-icon");
  private final XurmoThemeXmlTag meIconTag_             = new XurmoThemeXmlTag("me-icon");
  private final XurmoThemeXmlTag missedCallTag_         = new XurmoThemeXmlTag("missed-call");
  private final XurmoThemeXmlTag myplaceIconTag_        = new XurmoThemeXmlTag("myplace-icon");
  private final XurmoThemeXmlTag outgoingCallTag_       = new XurmoThemeXmlTag("outgoing-call");
  private final XurmoThemeXmlTag photoMsgTag_           = new XurmoThemeXmlTag("photo-msg");
  private final XurmoThemeXmlTag radioIconTag_          = new XurmoThemeXmlTag("radio-icon");
  private final XurmoThemeXmlTag readMsgTag_            = new XurmoThemeXmlTag("read-msg");
  private final XurmoThemeXmlTag ringtoneIconTag_       = new XurmoThemeXmlTag("ringtone-icon");
  private final XurmoThemeXmlTag unreadMsgTag_          = new XurmoThemeXmlTag("unread-msg");
  private final XurmoThemeXmlTag writeNewInteractionTag_= new XurmoThemeXmlTag("write-new-interaction");
  private final XurmoThemeXmlTag titleForegroundColorTag_ = new XurmoThemeXmlTag("title-fgcolor");
  private final XurmoThemeXmlTag collapsablePanelSelectedTitleBackgroundColorTag_ = new XurmoThemeXmlTag("collapsable-panel-selected-title-bgcolor");
  private final XurmoThemeXmlTag collapsablePanelSelectedContentBackgroundColorTag_ = new XurmoThemeXmlTag("collapsable-panel-selected-content-bgcolor");
  private final XurmoThemeXmlTag collapsablePanelSelectedForegroundColorTag_ = new XurmoThemeXmlTag("collapsable-panel-selected-fgcolor");
  private final XurmoThemeXmlTag collapsablePanelUnselectedForegroundColorTag_ = new XurmoThemeXmlTag("collapsable-panel-unselected-fgcolor");
  private final XurmoThemeXmlTag collapsablePanelUnselectedBackgroundColorTag_ = new XurmoThemeXmlTag("collapsable-panel-unselected-bgcolor");
  
  private final XurmoThemeXmlTag[] tags_ = new XurmoThemeXmlTag[] {
    noTag_,
    themesTag_,
    themeTag_,
    nameTag_,
    descriptionTag_,
    iconDirTag_,
    arrowLeftTag_,
    arrowRightTag_,
    backgroundMiddleTag_,
    backgroundTopTag_,
    clockIconTag_,
    communityBigTag_,
    communitySmallTag_,
    friendsBigTag_,
    friendsSmallTag_,
    incomingCallTag_,
    interactionTag_,
    interactionIconTag_,
    meIconTag_,
    missedCallTag_,
    myplaceIconTag_,
    outgoingCallTag_,
    photoMsgTag_,
    radioIconTag_,
    readMsgTag_,
    ringtoneIconTag_,
    unreadMsgTag_,
    writeNewInteractionTag_,
    titleForegroundColorTag_,
    collapsablePanelSelectedTitleBackgroundColorTag_,
    collapsablePanelSelectedContentBackgroundColorTag_,
    collapsablePanelSelectedForegroundColorTag_,
    collapsablePanelUnselectedForegroundColorTag_,
    collapsablePanelUnselectedBackgroundColorTag_
  };
  private int screenWidth_;
  private int screenHeight_;
  private int titleHeight_;
  private int middleHeight_;
}