/*
 * XurmoPhoneBookInterface.java
 *
 * Created on September 2, 2007, 1:46 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.xurmo.experiences.mobile;

import javax.microedition.pim.*;
import java.util.Vector;
import java.util.Date;

/**
 *
 * @author Vinay
 */
public class XurmoPhoneBookInterface {
  
  /** Creates a new instance of XurmoPhoneBookInterface */
  public XurmoPhoneBookInterface() {
  }
  public static String[] getContacts() {
    try {
      
      Vector vout = new Vector();
      ContactList contacts = null;
      try {
        contacts = (ContactList) PIM.getInstance().openPIMList(PIM.CONTACT_LIST, PIM.READ_WRITE);
        java.util.Enumeration items = contacts.items();
        
        while (items.hasMoreElements()) {
          Contact c = (Contact)items.nextElement();
          String tmp = new String();
          int[] fields = c.getFields();
          System.out.println("Number of fields = " + fields.length);
          for (int i = 0;i < fields.length; ++i) {
            String fieldName = contacts.getFieldLabel(fields[i]);
            int count = c.countValues(fields[i]);
            String fieldValue = new String();
            for (int j = 0; j < count; ++j) {
              
              System.out.println("Field name " + "i = " + i + "j = " + j);
              if (contacts.getFieldDataType(fields[i]) == Contact.STRING) {
                
                fieldValue += c.getString(fields[i], j);
              } else {
                fieldValue += "Non String Type";
              }
            }
            tmp += "[" + fieldName + ":" + fieldValue + "]";
          }
          vout.addElement(tmp);
        }
      } catch (PIMException e) {
        // An error occurred
        return null;
      }
      String[] out = new String[vout.size()];
      for (int i = 0; i < vout.size(); ++i) {
        out[i] = (String)(vout.elementAt(i));
      }
      return out;
    } catch(java.lang.IllegalArgumentException iae) {
      System.out.println("Illegal arguments");
      iae.printStackTrace();
      String[] s= new String[1];
      s[0] = new String(iae.toString() + iae.getMessage());
      return s;
    }
  }
  private static String getAddressesTag(int attr, String val) {
    
    String out = "<ns0:addresses>\n";
    out += "<ns0:attributeId>" + attr + "</ns0:attributeId>\n";
    out += "<ns0:value>" + val + "</ns0:value>\n";
    out += "</ns0:addresses>\n";
    return out;
  }
  private static String getAddressesXML(ContactList cl, Contact c, int currentField) {
    
    String out = "";
    String returnValue = "<ns0:addresses/>";
    int fdType = cl.getFieldDataType(currentField);
    
    if (fdType == Contact.STRING) {
      
      int cv = c.countValues(currentField);
      for (int i = 0; i < cv; ++i) {
        
        boolean attrFound = false;
        int attr = c.getAttributes(currentField, i);
        String val = c.getString(currentField, i);
        if (val != null && !val.equals("")) {
          
          if ((attr & Contact.ATTR_HOME) != 0) {
            out += getAddressesTag(Contact.ATTR_HOME, val);
            attrFound = true;
          }
          if ((attr & Contact.ATTR_WORK) != 0) {
            out += getAddressesTag(Contact.ATTR_WORK, val);
            attrFound = true;
          }
          if (!attrFound) {
            
            out += getAddressesTag(Contact.ATTR_NONE, val);
          }
        }
      }
    } else if (fdType == Contact.STRING_ARRAY) {
      
      int cv = c.countValues(currentField);
      for (int i = 0; i < cv; ++i) {
        
        boolean attrFound = false;
        int attr = c.getAttributes(currentField, i);
        String[] val = c.getStringArray(currentField, i);
        if (val != null && val.length > 0 ) {
          String cVal = new String("");
          for (int j = 0; j < val.length; ++j) {
            if (val[j] != null) {
              cVal += val[j] + " ";
            }
          }
          if ((attr & Contact.ATTR_HOME) != 0) {
            out += getAddressesTag(Contact.ATTR_HOME, cVal);
            attrFound = true;
          }
          if ((attr & Contact.ATTR_WORK) != 0) {
            out += getAddressesTag(Contact.ATTR_WORK, cVal);
            attrFound = true;
          }
          if (!attrFound) {
            
            out += getAddressesTag(Contact.ATTR_NONE, cVal);
          }
        }
      }
    }
    if (!out.equals("")) {
      returnValue = out;
    }
    return returnValue;
  }
  private static String getPhoneNumberTag(int attr, String value) {
    
    String out = "<ns0:phoneNumbers>\n";
    out += "<ns0:attributeId>" + attr + "</ns0:attributeId>\n";
    out += "<ns0:value>" + value + "</ns0:value>\n";
    out += "</ns0:phoneNumbers>\n";
    return out;
  }
  private static String getPhoneNumbersXML(ContactList cl, Contact c, int currentField) {
    
    String out = "";
    String returnValue = "<ns0:phoneNumbers/>";
    int fdType = cl.getFieldDataType(currentField);
    
    if (fdType == Contact.STRING) {
      
      int cv = c.countValues(currentField);
      for (int i = 0; i < cv; ++i) {
        
        int attr = c.getAttributes(currentField, i);
        String val = c.getString(currentField, i);
        System.out.println("Phone numbers attribute for value =" + i + " " + attr + " value " + val);
        boolean attrFound = false;
        if (val != null && !val.equals("")) {
          
          if ((attr & Contact.ATTR_PAGER) != 0) {
            out += getPhoneNumberTag(Contact.ATTR_PAGER, val);
            attrFound = true;
          }
          if ((attr & Contact.ATTR_MOBILE) != 0) {
            out += getPhoneNumberTag(Contact.ATTR_MOBILE, val);
            attrFound = true;
          }
          if ((attr & Contact.ATTR_OTHER) != 0) {
            out += getPhoneNumberTag(Contact.ATTR_OTHER, val);
            attrFound = true;
          }
          if ((attr & Contact.ATTR_HOME) != 0) {
            out += getPhoneNumberTag(Contact.ATTR_HOME, val);
            attrFound = true;
          }
          if ((attr & Contact.ATTR_WORK) != 0) {
            out += getPhoneNumberTag(Contact.ATTR_WORK, val);
            attrFound = true;
          }
          if ((attr & Contact.ATTR_FAX) != 0) {
            out += getPhoneNumberTag(Contact.ATTR_FAX, val);
            attrFound = true;
          }
          if (!attrFound) {
            out += getPhoneNumberTag(Contact.ATTR_NONE, val);
          }
        }
      }
    }
    if (!out.equals("")) {
      returnValue = out;
    }
    return returnValue;
  }
  private static String getEmailAddressTag(int attr, String value) {
    
    String out = "<ns0:emailAddresses>\n";
    out += "<ns0:attributeId>" + attr + "</ns0:attributeId>\n";
    out += "<ns0:value>" + value + "</ns0:value>\n";
    out += "</ns0:emailAddresses>\n";
    return out;
  }
  private static String getEmailAddressesXML(ContactList cl, Contact c, int currentField) {
    
    String out = "";
    String returnValue = new String("<ns0:emailAddresses/>");
    int fdType = cl.getFieldDataType(currentField);
    
    if (fdType == Contact.STRING) {
      
      int cv = c.countValues(currentField);
      for (int i = 0; i < cv; ++i) {
        
        int attr = c.getAttributes(currentField, i);
        String val = c.getString(currentField, i);
        boolean attrFound = false;
        if (val != null && !val.equals("")) {
          
          if ((attr & Contact.ATTR_OTHER) != 0) {
            out += getEmailAddressTag(Contact.ATTR_OTHER, val);
            attrFound = true;
          }
          if ((attr & Contact.ATTR_HOME) != 0) {
            out += getEmailAddressTag(Contact.ATTR_HOME, val);
            attrFound = true;
          }
          if ((attr & Contact.ATTR_WORK) != 0) {
            out += getEmailAddressTag(Contact.ATTR_WORK, val);
            attrFound = true;
          }
          if (!attrFound) {
            out += getEmailAddressTag(Contact.ATTR_NONE, val);
          }
        }
      }
    }
    if (!out.equals("")) {
      returnValue = out;
    }
    return returnValue;
  }
  private static String getContactXML(ContactList cl, Contact c) {
    int[] fields = c.getFields();
    String addr = new String("");
    String tel = new String("");
    String email = new String("");
    String birthday = new String("<ns0:birthday/>");
    String contactName = new String("<ns0:contactName/>");
    String nickName = new String("<ns0:nickName/>");
    String uniqueId = new String("<ns0:uniqueId/>");
    String out = new String("");
    for (int i = 0;i < fields.length; ++i) {
      int currentField = fields[i];
      switch (currentField) {
        case Contact.ADDR:
          addr = getAddressesXML(cl, c, currentField);
          break;
        case Contact.TEL:
          tel = getPhoneNumbersXML(cl, c, currentField);
          break;
        case Contact.EMAIL :
          email = getEmailAddressesXML(cl, c, currentField);
          break;
        case Contact.BIRTHDAY:
          birthday = "<ns0:birthday>" + XurmoDevice.getXMLTime(new Date(c.getDate(currentField, 0))) + "</ns0:birthday>\n";
          break;
        case Contact.FORMATTED_NAME:
          contactName = "<ns0:contactName>" + c.getString(currentField, 0) + "</ns0:contactName>\n";
          break;
        case Contact.NAME:
        {
          String[] nma = c.getStringArray(currentField, 0);
          String name = new String("");
          for (int j = 0; j < nma.length; ++j) {
            
            if (nma[j] != null && !nma[j].equalsIgnoreCase("null") && !nma[j].equals("")) {
              
              if (name.equals("")) {
                
                name += nma[j];
              }
              else {
                
                name += " " + nma[j];
              }
            }
          }
          contactName = "<ns0:contactName>" + name + "</ns0:contactName>\n";
        }
        break;
        case Contact.NICKNAME:
          nickName = "<ns0:nickName>" + c.getString(currentField, 0) + "</ns0:nickName>\n";
          break;
        case Contact.UID:
          uniqueId = "<ns0:uniqueId>" + c.getString(currentField, 0) + "</ns0:uniqueId>\n";
          break;
      }
    }
    out += addr + birthday + contactName + email + nickName + tel + uniqueId ;
    System.out.println("Phonebook XML" + out);
    return out;
  }
/*      for (int i = 0;i < fields.length; ++i) {
        String fieldName = contacts.getFieldLabel(fields[i]);
        int count = c.countValues(fields[i]);
        String fieldValue = new String();
        for (int j = 0; j < count; ++j) {
 
          System.out.println("Field name " + "i = " + i + "j = " + j);
          if (contacts.getFieldDataType(fields[i]) == Contact.STRING) {
 
            fieldValue += c.getString(fields[i], j);
          } else {
            fieldValue += "Non String Type";
          }
        }
        tmp += "[" + fieldName + ":" + fieldValue + "]";
      }
    }
  }*/
  public static String getUploadContactXML() {
    
    String out = new String("");
    try {
      
      Vector vout = new Vector();
      ContactList contacts = null;
      try {
        contacts = (ContactList) PIM.getInstance().openPIMList(PIM.CONTACT_LIST, PIM.READ_WRITE);
        java.util.Enumeration items = contacts.items();
        
        out += "<ns0:addressBook>\n";
        while (items.hasMoreElements()) {
          out += "<ns0:contact>\n";
          Contact c = (Contact)items.nextElement();
          out += getContactXML(contacts, c);
          out += "</ns0:contact>";
        }
        out += "</ns0:addressBook>";
      } catch (PIMException e) {
        // An error occurred
        return null;
      }
    } catch(java.lang.IllegalArgumentException iae) {
      System.out.println("Illegal arguments");
      iae.printStackTrace();
      String[] s= new String[1];
      s[0] = new String(iae.toString() + iae.getMessage());
    }
    return out;
  }
}