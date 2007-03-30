/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoUserInvitationManager.java
 * Created on               : March 29, 2007, 9:54 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;
import javax.persistence.EntityManager;

/**
 *
 * @author xurmo
 */
public class XurmoUserInvitationManager {
    
    public static XurmoUserInvitationManager instance() {
        if (self_ == null) {
            self_ = new XurmoUserInvitationManager();
        }
        return self_;
    }
    public int sendInvitation(String user, String[] destinations, String msg, EntityManager em) {
        
        try {
            
            for (int i = 0; i < destinations.length; ++i) {
                XurmoRequestToConnectInbox rtc = new XurmoRequestToConnectInbox(destinations[i], user, msg);
                em.persist(rtc);
            }
            return XurmoUserInteractionStatus.INTERACTIONSTATUS_NO_ERROR;
        }
        catch(Exception ex) {
            return XurmoUserInteractionStatus.INTERACTIONFAILED_COULD_NOT_SEND_INVITATION;
        }
    }
    /** Creates a new instance of XurmoUserInvitationManager */
    private XurmoUserInvitationManager() {
    }
    private static XurmoUserInvitationManager self_ = null;
}
