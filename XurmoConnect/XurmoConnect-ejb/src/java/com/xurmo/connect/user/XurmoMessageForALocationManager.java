/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoMessageForALocationManager.java
 * Created on               : March 31, 2007, 8:13 PM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;
import javax.persistence.EntityManager;

/**
 *
 * @author xurmo
 */
public class XurmoMessageForALocationManager {
    
    public static XurmoMessageForALocationManager instance() {
        if (self_ == null) {
            self_ = new XurmoMessageForALocationManager();
        }
        return self_;
    }
    public XurmoMessageForALocationReturnStatus enqueueMessage(String sourceId, String destinationId, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String msg, String cookie, EntityManager em) {
        
        javax.persistence.Query q = em.createNamedQuery("XurmoCellLocationMap.findByAllIds");
        q.setParameter("mobileCountryCode",mobileCountryCode);
        q.setParameter("mobileNetwokCode", mobileNetworkCode);
        q.setParameter("siteId", siteId);
        q.setParameter("cellId", cellId);
        try {
        
            XurmoCellLocationMap xclm = (XurmoCellLocationMap)(q.getSingleResult());
            int locationId = xclm.getLocationId();
            javax.persistence.Query sdpq = em.createNamedQuery("XurmoMessagesForALocationSourceDestinationPair.findByAllIds");
            sdpq.setParameter("locationId", locationId);
            sdpq.setParameter("sourceId", sourceId);
            sdpq.setParameter("destinationId", destinationId);
            int sourceDestinationId = 0;
            XurmoMessagesForALocationSourceDestinationPair xmalsdp = null;
            try {

                xmalsdp = (XurmoMessagesForALocationSourceDestinationPair)sdpq.getSingleResult();
                sourceDestinationId = xmalsdp.getSourceDestinationId();
            }
            catch(javax.persistence.NoResultException nre) {
                xmalsdp = new XurmoMessagesForALocationSourceDestinationPair(locationId, sourceId, destinationId);
                em.persist(xmalsdp);
                xmalsdp = (XurmoMessagesForALocationSourceDestinationPair)sdpq.getSingleResult();
                sourceDestinationId = xmalsdp.getSourceDestinationId();
            }
            XurmoMessageForALocation xmfal = new XurmoMessageForALocation(sourceDestinationId, msg);
            em.persist(xmfal);
        }
        catch (Exception ex) {
            return new XurmoMessageForALocationReturnStatus(XurmoUserInteractionStatus.INTERACTIONFAILED_COULD_NOT_SEND_MESSAGE_FOR_A_LOCATION, cookie);
        }
        return new XurmoMessageForALocationReturnStatus(XurmoUserInteractionStatus.INTERACTIONSTATUS_NO_ERROR, cookie);
    }
    /** Creates a new instance of XurmoMessageForALocationManager */
    private XurmoMessageForALocationManager() {
    }
    private static XurmoMessageForALocationManager self_ = null;
}
