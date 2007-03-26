package com.xurmo.connect.user.webservices.client;


/**
 * This is the implementation for the XurmoUserRegisterMessageHandlerSOAP Message Handler.
 * Created Mar 26, 2007 10:56:52 PM
 * @author xurmo
 */
//<editor-fold defaultstate="collapsed" desc="import statements. Click the + sign on the left to edit the code.">
import javax.xml.rpc.handler.MessageContext;
import javax.xml.rpc.handler.HandlerInfo;
import javax.xml.rpc.handler.soap.SOAPMessageContext;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPBody;
import java.util.Date;
//</editor-fold>
public class XurmoUserRegisterMessageHandler extends javax.xml.rpc.handler.GenericHandler {
    // TODO Change and enhance the handle methods to suit individual needs.
    
    private QName[] headers;
    
    public void init(HandlerInfo config) {
        headers = config.getHeaders();
    }
    
    public javax.xml.namespace.QName[] getHeaders() {
        return headers;
    }
    
    // Currently prints out the contents of the SOAP body plus some date information.
    public boolean handleRequest(MessageContext context) {
        try{
            SOAPMessageContext smc = (SOAPMessageContext) context;
            SOAPMessage msg = smc.getMessage();
            SOAPPart sp = msg.getSOAPPart();
            SOAPEnvelope se = sp.getEnvelope();
            SOAPHeader shd = se.getHeader();
            
            SOAPBody sb = se.getBody();
            java.util.Iterator childElems = sb.getChildElements();
            SOAPElement child;
            StringBuffer message = new StringBuffer();
            while (childElems.hasNext()) {
                child = (SOAPElement) childElems.next();
                message.append(new Date().toString() + "--");
                formLogMessage(child, message);
            }
            
            System.out.println("Log message: " + message.toString());
        } catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean handleResponse(MessageContext context) {
        return true;
    }
    
    public boolean handleFault(MessageContext context) {
        return true;
    }
    
    public void destroy() {
    }
    
    private void formLogMessage(SOAPElement child, StringBuffer message) {
        message.append(child.getElementName().getLocalName());
        message.append(child.getValue() != null ? ":" + child.getValue() + " " : " ");
        
        try{
            java.util.Iterator childElems = child.getChildElements();
            while (childElems.hasNext()) {
                Object c = childElems.next();
                if(c instanceof SOAPElement)
                    formLogMessage((SOAPElement)c, message);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
