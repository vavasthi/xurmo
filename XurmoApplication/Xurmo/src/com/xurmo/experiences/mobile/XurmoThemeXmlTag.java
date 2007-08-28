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
 * @file   XurmoThemeXmlTag.java
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



public class XurmoThemeXmlTag {
  
  /** Creates a new instance of XurmoThemeXmlTag */
  public XurmoThemeXmlTag(String tag) {
    tag_ = tag;
    context_ = tagCount_;
    ++tagCount_;
  }
  public final int context() {
    return context_;
  }
  public  String tag() {
    return tag_;
  }
  private final int context_;
  private final String tag_;
  private static int tagCount_ = 0;
}
