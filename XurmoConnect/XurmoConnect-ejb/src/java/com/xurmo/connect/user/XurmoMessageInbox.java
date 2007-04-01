/*
 * Copyright (c) 2007, Xurmo.com. All rights reserved.
 *
 * File name                : XurmoMessageInbox.java
 * Created on               : April 1, 2007, 11:39 AM
 * Created by               : xurmo
 *
 */

package com.xurmo.connect.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class XurmoMessageInbox
 * 
 * @author xurmo
 */
@Entity
@Table(name = "XurmoMessageInbox")
@NamedQueries( {
        @NamedQuery(name = "XurmoMessageInbox.findByMessageId", query = "SELECT x FROM XurmoMessageInbox x WHERE x.messageId = :messageId"),
        @NamedQuery(name = "XurmoMessageInbox.findByFromLocationId", query = "SELECT x FROM XurmoMessageInbox x WHERE x.fromLocationId = :fromLocationId"),
        @NamedQuery(name = "XurmoMessageInbox.findBySourceId", query = "SELECT x FROM XurmoMessageInbox x WHERE x.sourceId = :sourceId"),
        @NamedQuery(name = "XurmoMessageInbox.findByToLocationId", query = "SELECT x FROM XurmoMessageInbox x WHERE x.toLocationId = :toLocationId"),
        @NamedQuery(name = "XurmoMessageInbox.findByDestinationId", query = "SELECT x FROM XurmoMessageInbox x WHERE x.destinationId = :destinationId"),
        @NamedQuery(name = "XurmoMessageInbox.findByMsgStatus", query = "SELECT x FROM XurmoMessageInbox x WHERE x.msgStatus = :msgStatus"),
        @NamedQuery(name = "XurmoMessageInbox.findByMsg", query = "SELECT x FROM XurmoMessageInbox x WHERE x.msg = :msg")
    })
public class XurmoMessageInbox implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "messageId", nullable = false)
    private int messageId;

    @Column(name = "fromLocationId", nullable = false)
    private int fromLocationId;

    @Column(name = "sourceId", nullable = false)
    private String sourceId;

    @Column(name = "toLocationId", nullable = false)
    private int toLocationId;

    @Column(name = "destinationId", nullable = false)
    private String destinationId;

    @Column(name = "msgStatus", nullable = false)
    private char msgStatus;

    @Column(name = "msg", nullable = false)
    private String msg;
    
    /** Creates a new instance of XurmoMessageInbox */
    public XurmoMessageInbox() {
    }

    /**
     * Creates a new instance of XurmoMessageInbox with the specified values.
     * @param messageId the messageId of the XurmoMessageInbox
     * @param fromLocationId the fromLocationId of the XurmoMessageInbox
     * @param sourceId the sourceId of the XurmoMessageInbox
     * @param toLocationId the toLocationId of the XurmoMessageInbox
     * @param destinationId the destinationId of the XurmoMessageInbox
     * @param msgStatus the msgStatus of the XurmoMessageInbox
     * @param msg the msg of the XurmoMessageInbox
     */
    public XurmoMessageInbox(int fromLocationId, String sourceId, int toLocationId, String destinationId, String msg) {
        this.fromLocationId = fromLocationId;
        this.sourceId = sourceId;
        this.toLocationId = toLocationId;
        this.destinationId = destinationId;
        this.msgStatus = 'N';
        this.msg = msg;
    }

    /**
     * Gets the messageId of this XurmoMessageInbox.
     * @return the messageId
     */
    public int getMessageId() {
        return this.messageId;
    }

    /**
     * Sets the messageId of this XurmoMessageInbox to the specified value.
     * @param messageId the new messageId
     */
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    /**
     * Gets the fromLocationId of this XurmoMessageInbox.
     * @return the fromLocationId
     */
    public int getFromLocationId() {
        return this.fromLocationId;
    }

    /**
     * Sets the fromLocationId of this XurmoMessageInbox to the specified value.
     * @param fromLocationId the new fromLocationId
     */
    public void setFromLocationId(int fromLocationId) {
        this.fromLocationId = fromLocationId;
    }

    /**
     * Gets the sourceId of this XurmoMessageInbox.
     * @return the sourceId
     */
    public String getSourceId() {
        return this.sourceId;
    }

    /**
     * Sets the sourceId of this XurmoMessageInbox to the specified value.
     * @param sourceId the new sourceId
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * Gets the toLocationId of this XurmoMessageInbox.
     * @return the toLocationId
     */
    public int getToLocationId() {
        return this.toLocationId;
    }

    /**
     * Sets the toLocationId of this XurmoMessageInbox to the specified value.
     * @param toLocationId the new toLocationId
     */
    public void setToLocationId(int toLocationId) {
        this.toLocationId = toLocationId;
    }

    /**
     * Gets the destinationId of this XurmoMessageInbox.
     * @return the destinationId
     */
    public String getDestinationId() {
        return this.destinationId;
    }

    /**
     * Sets the destinationId of this XurmoMessageInbox to the specified value.
     * @param destinationId the new destinationId
     */
    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    /**
     * Gets the msgStatus of this XurmoMessageInbox.
     * @return the msgStatus
     */
    public char getMsgStatus() {
        return this.msgStatus;
    }

    /**
     * Sets the msgStatus of this XurmoMessageInbox to the specified value.
     * @param msgStatus the new msgStatus
     */
    public void setMsgStatus(char msgStatus) {
        this.msgStatus = msgStatus;
    }

    /**
     * Gets the msg of this XurmoMessageInbox.
     * @return the msg
     */
    public String getMsg() {
        return this.msg;
    }

    /**
     * Sets the msg of this XurmoMessageInbox to the specified value.
     * @param msg the new msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += this.messageId;
        return hash;
    }

    /**
     * Determines whether another object is equal to this XurmoMessageInbox.  The result is 
     * <code>true</code> if and only if the argument is not null and is a XurmoMessageInbox object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XurmoMessageInbox)) {
            return false;
        }
        XurmoMessageInbox other = (XurmoMessageInbox)object;
        if (this.messageId != other.messageId ) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.xurmo.connect.user.XurmoMessageInbox[messageId=" + messageId + "]";
    }
    
}
