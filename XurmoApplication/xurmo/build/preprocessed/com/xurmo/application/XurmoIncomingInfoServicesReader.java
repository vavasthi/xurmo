// =====================================================================
//                   Motorola Confidential Proprietary
//           (c) Copyright 2006, Motorola Inc. All Rights Reserved
//
// Revision History:
//
//                   Modification  Tracking
// Author            Date          Number       Description of Changes
// --------------    -----------   ------------ ------------------------
// a12733          December 5, 2006
// =====================================================================

/**
 *
 * @file   IncomingMessageReader.java
 * @author
 * @date   December 5, 2006
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
import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.io.*;
import javax.wireless.messaging.*;

// Isolate blocking I/O on a separate thread, so callback
// can return immediately.
class XurmoIncomingInfoServicesReader implements Runnable {
  private int pendingMessages_ = 0;
  private boolean done_ = false;
  private MessageConnection conn_;
  public XurmoIncomingInfoServicesReader(MessageConnection conn) {
    conn_ = conn;
  }
  // The run method performs the actual message reading.
  public void run() {
    while (!done_) {
      synchronized(this) {
        if (pendingMessages_ == 0) {
          try {
            wait();
          } catch (Exception e) {
            // Handle interruption
          }
        }
        --pendingMessages_;
      }
      
      try {
        Message msg = conn_.receive();
        String cellName = null;
        if (msg instanceof BinaryMessage) {
          BinaryMessage bm = (BinaryMessage) msg;
          String newMsg = bm.toString();
          if (newMsg.startsWith("CALL GULF")) {
            return;
          }
          cellName = bm.toString();
        } else if (msg instanceof TextMessage) {
          TextMessage tm = (TextMessage) msg;
          String newMsg = tm.getPayloadText();
          if (newMsg.startsWith("CALL GULF")) {
            return;
          }
          cellName = newMsg;
        }
        if (cellName != null) {
          
          XurmoProperties.instance().setCellName(cellName);
        }
      } catch (IOException ioe) {
        // Handle reading errors
      }
    }
  }
  
  public synchronized void handleMessage() {
    ++pendingMessages_;
    notify();
  }
  public void done() {
    done_ = true;
  }
}
