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
 * @file   XurmoTheme.java
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
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;
import java.io.*;
import java.util.Vector;

public class XurmoTheme {
  
  /**
   * Creates a new instance of XurmoTheme
   */
  public XurmoTheme(int screenWidth,
      int screenHeight,
      int titleHeight,
      int middleHeight,
      String name,
      String description,
      String iconDirectory,
      String titlebarLogo,
      String arrowLeftValue,
      String arrowRightValue,
      String backgroundMiddleValue,
      String backgroundTopValue,
      String clockIconValue,
      String communityBigValue,
      String communitySmallValue,
      String friendsBigValue,
      String friendsSmallValue,
      String incomingCallValue,
      String interactionValue,
      String interactionIconValue,
      String meIconValue,
      String missedCallValue,
      String myplaceIconValue,
      String outgoingCallValue,
      String photoMsgValue,
      String radioIconValue,
      String readMsgValue,
      String ringtoneIconValue,
      String unreadMsgValue,
      String writeNewInteractionValue,
      int titleForegroundColorValue,
      int gradientStartColorValue,
      int gradientEndColorValue,
      int collapsablePanelSelectedTitleBackgroundValue,
      int collapsablePanelSelectedContentBackgroundColorValue,
      int collapsablePanelSelectedForegroundColorValue,
      int collapsablePanelUnselectedForegroundColorValue,
      int collapsablePanelUnselectedBackgroundColorValue) {
    screenWidth_ = screenWidth;
    screenHeight_ = screenHeight;
    titleHeight_ = titleHeight;
    middleHeight_ = middleHeight;
    name_ = name;
    description_ = description;
    iconDirectory_ = "/resources/themes/" + name + "/" + iconDirectory + "/";
    titleForegroundColor_ = titleForegroundColorValue;
    gradientStartColor_ = gradientStartColorValue;
    gradientEndColor_ = gradientEndColorValue;
    collapsablePanelSelectedTitleBackgroundValue_ = collapsablePanelSelectedTitleBackgroundValue;
    collapsablePanelSelectedContentBackgroundColorValue_ = collapsablePanelSelectedContentBackgroundColorValue;
    collapsablePanelSelectedForegroundColorValue_ = collapsablePanelSelectedForegroundColorValue;
    collapsablePanelUnselectedForegroundColorValue_ = collapsablePanelUnselectedForegroundColorValue;
    collapsablePanelUnselectedBackgroundColorValue_ = collapsablePanelUnselectedBackgroundColorValue;
    try {
      
      arrowLeftImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+arrowLeftValue));
      arrowRightImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+arrowRightValue));
      titlebarLogo_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+titlebarLogo));
      backgroundMiddleImage_ = null;
      //Image.createImage(getClass().getResourceAsStream(iconDirectory_+backgroundMiddleValue));
      Image tmp = Image.createImage(getClass().getResourceAsStream(iconDirectory_+backgroundTopValue));
      backgroundTopImage_ = Image.createImage(tmp, (tmp.getWidth() - screenWidth_)/2, (tmp.getHeight() - titleHeight)/2, screenWidth, titleHeight, Sprite.TRANS_NONE);
      clockIconImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+clockIconValue));
      communityBigImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+communityBigValue));
      communitySmallImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+communitySmallValue));
      friendsBigImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+friendsBigValue));
      friendsSmallImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+friendsSmallValue));
      incomingCallImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+incomingCallValue));
      interactionImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+interactionValue));
      interactionIconImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+interactionIconValue));
      meIconImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+meIconValue));
      missedCallImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+missedCallValue));
      myplaceIconImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+myplaceIconValue));
      outgoingCallImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+outgoingCallValue));
      photoMsgImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+photoMsgValue));
      radioIconImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+radioIconValue));
      readMsgImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+readMsgValue));
      unreadMsgImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+unreadMsgValue));
      writeNewInteractionImage_ = Image.createImage(getClass().getResourceAsStream(iconDirectory_+writeNewInteractionValue));
    } catch(java.io.IOException ioex) {
    }
  }
  private String name_;
  private String description_;
  private String iconDirectory_;

  Image titlebarLogo_;
  Image arrowLeftImage_;
  Image arrowRightImage_;
  Image backgroundMiddleImage_;
  Image backgroundTopImage_;
  Image clockIconImage_;
  Image communityBigImage_;
  Image communitySmallImage_;
  Image friendsBigImage_;
  Image friendsSmallImage_;
  Image incomingCallImage_;
  Image interactionImage_;
  Image interactionIconImage_;
  Image meIconImage_;
  Image missedCallImage_;
  Image myplaceIconImage_;
  Image outgoingCallImage_;
  Image photoMsgImage_;
  Image radioIconImage_;
  Image readMsgImage_;
  Image unreadMsgImage_;
  Image writeNewInteractionImage_;
  
  int titleForegroundColor_;
  int gradientStartColor_;
  int gradientEndColor_;
  int collapsablePanelSelectedTitleBackgroundValue_;
  int collapsablePanelSelectedContentBackgroundColorValue_;
  int collapsablePanelSelectedForegroundColorValue_;
  int collapsablePanelUnselectedForegroundColorValue_;
  int collapsablePanelUnselectedBackgroundColorValue_;
  
  private int screenWidth_;
  private int screenHeight_;
  private int titleHeight_;
  private int middleHeight_;
}
