/*
 * XurmoGraffitiSummary.java
 *
 * Created on August 24, 2007, 9:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

import java.util.Vector;

/**
 *
 * @author Vinay
 */
public class XurmoDoodleSummary {
  Vector doodles_;
  /** Creates a new instance of XurmoGraffitiSummary */
  public XurmoDoodleSummary() {
    doodles_ = new Vector();
  }
  void addDoodleSummaryForALocation(int locationId, String locationName, int messageCount) {
    doodles_.addElement(new XurmoDoodlesPerLocation(locationId, locationName, messageCount));
  }
  String getSummaryTitleString() {
    if (doodles_.size() == 0) {
      return new String("You have no doodles");
    } else {
      int tm = 0;
      for (int i = 0; i < doodles_.size(); ++i) {
        XurmoDoodlesPerLocation dpl = (XurmoDoodlesPerLocation)(doodles_.elementAt(i));
        tm += dpl.messageCount_;
      }
      if (tm == 1) {
        
        return new String("You have " + tm + " doodle in " + doodles_.size() + " locations.");
      } else {
        
        return new String("You have " + tm + " doodles in " + doodles_.size() + " locations.");
      }
    }
  }
  String[] getSummaryStrings() {
    String[] ret = new String[doodles_.size()];
    for (int i = 0; i < doodles_.size(); ++i) {
      XurmoDoodlesPerLocation dpl = (XurmoDoodlesPerLocation)(doodles_.elementAt(i));
      if (dpl.messageCount_ == 1) {
        
        ret[i] = new String("You have " + dpl.messageCount_ + " doodle in " + dpl.locationName_ + ".");
      } else {
        
        ret[i] = new String("You have " + dpl.messageCount_ + " doodles in " + dpl.locationName_ + ".");
      }
    }
    return ret;
  }
}
