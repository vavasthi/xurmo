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
import java.util.List;
import java.util.Iterator;

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
    public XurmoMessageStatus enqueueMessage(String sourceId, String destinationId, String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String msg, String cookie, EntityManager em) {
        
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
            return new XurmoMessageStatus(XurmoMessageStatus.MessageStatus.COULD_NOT_SEND_MESSAGE_FOR_A_LOCATION, cookie);
        }
        return new XurmoMessageStatus(XurmoMessageStatus.MessageStatus.SUCCESS, cookie);
    }
    private XurmoCellLocationMap[] findCellsInLocation(String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, EntityManager em) {
     
        javax.persistence.Query q = em.createNamedQuery("XurmoCellLocationMap.findByAllIds");
        q.setParameter("mobileCountryCode", mobileCountryCode);
        q.setParameter("mobileNetworkCode", mobileNetworkCode);
        q.setParameter("siteId", siteId);
        q.setParameter("cellId", cellId);
        List res = q.getResultList();
        XurmoCellLocationMap[] out = new XurmoCellLocationMap[res.size()];
        Iterator itr = res.iterator();
        int i = 0;
        while (itr.hasNext()) {
            out[i] = (XurmoCellLocationMap)itr.next();
            ++i;
        }
        return out;
    }
    public void processMessagesInALocation(String mobileCountryCode, String mobileNetworkCode, String siteId, String cellId, String destinationId, EntityManager em) {

        XurmoCellLocationMap[] locations = findCellsInLocation(mobileCountryCode, mobileNetworkCode, siteId, cellId, em);
        XurmoMessagesForALocationSourceDestinationPair[] sdp = null;
        for (int i = 0; i < locations.length; ++i) {
            
            javax.persistence.Query q = em.createNamedQuery("XurmoMessagesForALocationSourceDestinationPair.findByLocationIdAndDestinationId");
            q.setParameter("locationId", locations[i].getLocationId());
            q.setParameter("destinationId", destinationId);
            List sdpList = q.getResultList();
            sdp = new XurmoMessagesForALocationSourceDestinationPair[sdpList.size()];
            Iterator sdpi = sdpList.iterator();
            int j =0;
            while (sdpi.hasNext()) {
                
                sdp[j] = (XurmoMessagesForALocationSourceDestinationPair) sdpi.next();
                javax.persistence.Query mq = em.createNamedQuery("XurmoMessageForALocation.findBySourceDestinationId");
                mq.setParameter("sourceDestinationId",sdp[j].getSourceDestinationId());
                List msgList = mq.getResultList();
                Iterator msgItr = msgList.iterator();
                int k = 0;
                XurmoMessageForALocation[] messages = new XurmoMessageForALocation[msgList.size()];
                while(msgItr.hasNext()) {
                    messages[k] = (XurmoMessageForALocation)msgItr.next();
                    XurmoMessageInbox mi = new XurmoMessageInbox(locations[i].getLocationId(), sdp[j].getSourceId(), locations[i].getLocationId(), sdp[j].getDestinationId(), messages[k].getMsg());
                    em.persist(mi);
                    ++k;
                }
                for(k = 0; k < messages.length; ++k) {
                    em.remove(messages[k]);
                }
                ++j;
            }
            for(j = 0; j < sdp.length; ++j) {
                em.remove(sdp[j]);
            }
        }
    }
    /** Creates a new instance of XurmoMessageForALocationManager */
    private XurmoMessageForALocationManager() {
    }
    private static XurmoMessageForALocationManager self_ = null;
}
