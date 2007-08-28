// =====================================================================
//                           Xurmo Proprietary
//               (c) Copyright 2007, Xurmo, All Rights Reserved
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
 * @file   IncomingSMSListener.java
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
package com.xurmo.experiences.mobile;
// *********************************************************************
// Imports
// *********************************************************************
import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.io.*;
import javax.wireless.messaging.*;
public class XurmoInfoServicesListener implements MessageListener {
    boolean done_;
    MessageConnection cbsConn_;
    XurmoInfoServicesReader cbsReader_;
    // Initial tests setup and execution.
    private final String cbsUrl_ = "cbs://:50";
    public XurmoInfoServicesListener(Xurmo midlet, String username, String cookie) {
        // Get our receiving port connection.
        try {
            
            cbsConn_ = (MessageConnection)Connector.open(cbsUrl_);
            // Register a listener for inbound messages.
            cbsConn_.setMessageListener(this);
            // Start a message-reading thread.
            done_ = false;
            cbsReader_ = new XurmoInfoServicesReader(midlet, cbsConn_, username, cookie);
            new Thread(cbsReader_).start();
            
            try {
                String[] conns = PushRegistry.listConnections(true);
                if (conns != null && conns.length != 0) {
                    for (int i = 0;i < conns.length; ++i) {
                        
                        PushRegistry.unregisterConnection(conns[i]);
                    }
                }
                PushRegistry.registerConnection(cbsUrl_, Xurmo.class.getName(), "*");
            } catch(ClassNotFoundException ex) {
                
            }
        } catch(IOException ioex) {
            
        }
        
    }
    // Asynchronous callback for inbound message.
    public void notifyIncomingMessage(MessageConnection conn) {
        cbsReader_.handleMessage();
    }
    
    // Required MIDlet method - release the connection and
    // signal the reader thread to terminate.
    protected void finalize() {
        done_ = true;
        try {
            cbsConn_.setMessageListener(null);
            cbsConn_.close();
        } catch (IOException e) {
            // Handle errors
        }
    }
}
