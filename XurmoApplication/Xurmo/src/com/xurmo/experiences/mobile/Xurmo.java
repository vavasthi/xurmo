/*
 * Xurmo.java
 *
 * Created on August 14, 2007, 7:43 AM
 */

package com.xurmo.experiences.mobile;

import javax.microedition.midlet.MIDlet;


import java.util.Calendar;
import java.util.Hashtable;
import java.io.*;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
import javax.microedition.rms.*;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Image;
import java.util.Timer;
import java.util.Vector;

public class Xurmo extends MIDlet {
  /* These vars are used in the examples below */
  
  XurmoCurrentUser currentUser_;
  XurmoCanvas home_;
  XurmoUserHomeScreenData homeData_;
  Vector otherSocialNetworks_;
  
  private final String userAuthenticationRecordName_ = new String("XurmoUserAuthenticationRecords");;
  private final String otherSocialNetworksRecordName_ = new String("XurmoMyOtherSocialNetworkRecords");;
  private XurmoBluetoothServiceListener localBtListener_;
  private Timer timer_;
  
  public Xurmo() {
    initialize();
  }
  /* ****************************************** */
  
  /**
   * A midlet that will demostrate the capabilities of the Fire Components and
   * how to use them.
   *
   */
  private void initialize() {
    currentUser_ = new XurmoCurrentUser();
    XurmoThemeManager.init(this);
    homeData_ = null;
    otherSocialNetworks_ = new Vector();
    try {
      
      localBtListener_ = new XurmoBluetoothServiceListener();
    } catch(javax.bluetooth.BluetoothStateException bsex) {
      
    }
/*      javax.microedition.lcdui.List l = new javax.microedition.lcdui.List("Phonebook", javax.microedition.lcdui.List.IMPLICIT);
      String[] s = XurmoPhoneBookInterface.getContacts();
      for (int i = 0; i < s.length; ++i) {
        l.append(s[i], null);
      }
      this.getDisplay().setCurrent(l);*/
    loadOtherSocialNetworkDetails();
    if (this.loadUsernameAndPasswordIfExist()) {
      XurmoUserAuthenticationReturnStatus status = performLogin();
      if (XurmoUserAuthenticationAndSessionWSInterface.isAuthenticationStatusSuccessful(status.errorCode_)) {
        // Show the home screen.
      } else {
        doLogin();
      }
    } else {
      doRegister();
    }
    
  }
/*    public void createApplicationMenu() {
 
        MenuBar mb = new MenuBar();
        {
 
            Menu m = new Menu("User");
            mb.addChildItem(m);
            exit_ = new MenuItem("Exit", Command.EXIT, 1);
            m.addChildItem(exit_);
            if (currentUser_.loggedIn_) {
                logout_ = new MenuItem("LogOut", Command.ITEM, 1);
                m.addChildItem(logout_);
            } else {
 
                register_ = new MenuItem("Register", Command.ITEM, 1);
                m.addChildItem(register_);
                login_ = new MenuItem("Login", Command.ITEM, 1);
                m.addChildItem(login_);
            }
        }
        {
 
            if (currentUser_.loggedIn_) {
                Menu m = new Menu("Friends");
                mb.addChildItem(m);
                this.inviteFriends_ = new MenuItem("Invite", Command.ITEM, 1);
                this.connectToUsers_= new MenuItem("Connect", Command.ITEM, 1);
                m.addChildItem(inviteFriends_);
                m.addChildItem(connectToUsers_);
            }
        }
        mb.setActionListener(new XurmoMenuBarEventHandler(this));
        return mb;
    }
 */
  
  
  public void startApp() {
  }
  
  public void pauseApp() {
  }
  
  public void destroyApp(boolean unconditional) {
  }
  
  
  private void storeUsernameAndPassword() {
    boolean rsOpened = false;
    RecordStore rs = null;
    try {
      deleteUsernameAndPassword();
      rs = RecordStore.openRecordStore(userAuthenticationRecordName_, true);
      rsOpened = true;
      ByteArrayOutputStream bout = new ByteArrayOutputStream();
      DataOutputStream dout = new DataOutputStream( bout );
      
      dout.writeUTF(currentUser_.username_);
      dout.writeUTF(currentUser_.password_);
      dout.flush();
      byte[] data = bout.toByteArray();
      rs.addRecord(data, 0, data.length);
      rs.closeRecordStore();
      System.out.println("Record store " + this.userAuthenticationRecordName_+ " successfully stored and closed");
    } catch (RecordStoreFullException e) {
      System.err.println(e.toString() + "Username and password record store could not be stored");
      e.printStackTrace();
    } catch (RecordStoreNotFoundException e) {
      System.err.println(e.toString() + "Username and password record store could not be stored");
      e.printStackTrace();
    } catch (RecordStoreException e) {
      System.err.println(e.toString() + "Username and password record store could not be stored");
      e.printStackTrace();
    } catch (IOException e) {
      System.err.println(e.toString() + "Username and password record store could not be stored");
      e.printStackTrace();
    }
    if (rsOpened) {
      try {
        
        rs.closeRecordStore();
      } catch(RecordStoreException rse) {
        System.err.println("While closing an exception encountered");
      }
    }
  }
  void storeOtherSocialNetworkDetails() {
    boolean rsOpened = false;
    RecordStore rs = null;
    try {
      deleteOtherSocialNetworkDetails();
      rs = RecordStore.openRecordStore(this.otherSocialNetworksRecordName_, true);
      rsOpened = true;
      
      ByteArrayOutputStream bout = new ByteArrayOutputStream();
      DataOutputStream dout = new DataOutputStream( bout );
      
      int kount = otherSocialNetworks_.size();
      dout.writeInt(kount);
      for (int i = 0; i < kount; ++i) {
        ((XurmoOtherSocialNetworkDetails) otherSocialNetworks_.elementAt(i)).storeTo(dout);
      }
      dout.flush();
      byte[] data = bout.toByteArray();
      rs.addRecord(data, 0, data.length);
      rs.closeRecordStore();
      System.out.println("Record store " + this.otherSocialNetworksRecordName_ + " successfully stored and closed");
    } catch (RecordStoreFullException e) {
      System.err.println(e.toString() + "Other social networks record store could not be stored");
      e.printStackTrace();
    } catch (RecordStoreNotFoundException e) {
      System.err.println(e.toString() + "Other social networks record store could not be stored");
      e.printStackTrace();
    } catch (RecordStoreException e) {
      System.err.println(e.toString() + "Other social networks record store could not be stored");
      e.printStackTrace();
    } catch (IOException e) {
      System.err.println(e.toString() + "Other social networks record store could not be stored");
      e.printStackTrace();
    }
    if (rsOpened) {
      try {
        
        rs.closeRecordStore();
      } catch(RecordStoreException rse) {
        System.err.println("While closing an exception encountered");
      }
    }
  }
  private boolean loadUsernameAndPasswordIfExist() {
    
    boolean rsOpened = false;
    RecordStore rs = null;
    try {
      rs = RecordStore.openRecordStore(userAuthenticationRecordName_, false);
      
      byte[] data = rs.getRecord(1);
      System.out.println("Loading username and password");
      
      ByteArrayInputStream bin = new ByteArrayInputStream(data);
      DataInputStream din = new DataInputStream( bin );
      
      currentUser_.username_  = din.readUTF();
      currentUser_.password_ = din.readUTF();
      currentUser_.presence_ = new String("Unknown");
      rs.closeRecordStore();
      System.out.println("Successfully loaded and closed record store " + this.userAuthenticationRecordName_);
      return true;
    } catch (RecordStoreFullException e) {
      System.err.println(e.toString() + "Username and password record store could not be loaded");
      e.printStackTrace();
    } catch (RecordStoreNotFoundException e) {
      System.err.println(e.toString() + "Username and password record store could not be loaded");
      e.printStackTrace();
    } catch (RecordStoreException e) {
      System.err.println(e.toString() + "Username and password record store could not be loaded");
      e.printStackTrace();
    } catch (IOException e) {
      System.err.println(e.toString() + "Username and password record store could not be loaded");
      System.err.println("IO Exception");
      e.printStackTrace();
    }
    if (rsOpened) {
      try {
        
        rs.closeRecordStore();
      } catch(RecordStoreException rse) {
        System.err.println("While closing an exception encountered");
      }
    }
    return false;
  }
  private boolean loadOtherSocialNetworkDetails() {
    
    boolean rsOpened = false;
    RecordStore rs = null;
    try {
      rs = RecordStore.openRecordStore(otherSocialNetworksRecordName_, false);
      
      byte[] data = rs.getRecord(1);
      System.out.println("Loading Other social network details.");
      
      ByteArrayInputStream bin = new ByteArrayInputStream(data);
      DataInputStream din = new DataInputStream( bin );
      
      int kount = din.readInt();
      for (int i = 0; i < kount; ++i) {
        XurmoOtherSocialNetworkDetails xosnd = new XurmoOtherSocialNetworkDetails();
        xosnd.restoreFrom(din);
        otherSocialNetworks_.addElement(xosnd);
      }
      System.out.println("Successfully loaded and closed record store " + this.otherSocialNetworksRecordName_);
      return true;
    } catch (RecordStoreFullException e) {
      System.err.println(e.toString() + "Other social networks record store could not be loaded");
      e.printStackTrace();
    } catch (RecordStoreNotFoundException e) {
      System.err.println(e.toString() + "Other social networks record store could not be loaded");
      e.printStackTrace();
    } catch (RecordStoreException e) {
      System.err.println(e.toString() + "Other social networks record store could not be loaded");
      e.printStackTrace();
    } catch (IOException e) {
      System.err.println(e.toString() + "Other social networks record store could not be loaded");
      System.err.println("IO Exception");
      e.printStackTrace();
    }
    if (rsOpened) {
      try {
        
        rs.closeRecordStore();
      } catch(RecordStoreException rse) {
        System.err.println("While closing an exception encountered");
      }
    }
    return false;
  }
  private void deleteUsernameAndPassword() {
    try {
      RecordStore.deleteRecordStore(userAuthenticationRecordName_);
      System.out.println("Record store " + this.userAuthenticationRecordName_ + " deleted.");
    } catch (RecordStoreFullException e) {
      System.err.println(e.toString() + "Username and password record store could not be deleted");
    } catch (RecordStoreNotFoundException e) {
      System.err.println(e.toString() + "Username and password record store could not be deleted");
    } catch (RecordStoreException e) {
      System.err.println(e.toString() + "Username and password record store could not be deleted");
    }
  }
  private void deleteOtherSocialNetworkDetails() {
    try {
      RecordStore.deleteRecordStore(otherSocialNetworksRecordName_);
      System.out.println("Record store " + this.otherSocialNetworksRecordName_ + " deleted.");
    } catch (RecordStoreFullException e) {
      System.err.println(e.toString() + "Other social networks record store could not be deleted");
    } catch (RecordStoreNotFoundException e) {
      System.err.println(e.toString() + "Other social networks record store could not be deleted");
    } catch (RecordStoreException e) {
      System.err.println(e.toString() + "Other social networks record store could not be deleted");
    }
  }
  public XurmoUserAuthenticationReturnStatus performLogin() {
    homeData_
        = XurmoUserAuthenticationAndSessionWSInterface.loginUser(currentUser_.username_, currentUser_.password_);
    XurmoUserAuthenticationReturnStatus status = homeData_.status;
    if (status != null &&
        XurmoUserAuthenticationAndSessionWSInterface.isAuthenticationStatusSuccessful(status.errorCode_)) {
      currentUser_.loggedIn(currentUser_.username_, currentUser_.password_, status.cookie_, status.cellName_, homeData_.presence);
      XurmoInfoServicesListener listener = new XurmoInfoServicesListener(this, currentUser_.username_, currentUser_.cookie_);
      storeUsernameAndPassword();
      home_  = new XurmoHomeScreen(this);
      this.getDisplay().setCurrent(home_);
      home_.setFullScreenMode(true);
    }
    return status;
  }
  public XurmoUserHomeScreenData getHomeScreenData() {
    if (homeData_ == null) {
      updateHomeScreenData();
    }
    return homeData_;
  }
  public void updateHomeScreenData() {
    int k = this.otherSocialNetworks_.size();
    String twitterUsername = new String("");
    String twitterPassword = new String("");
    String jaikuUsername = new String("");
    String jaikuPersonalKey = new String("");
    String tmp;
    for (int i = 0; i < k; ++i) {
      XurmoOtherSocialNetworkDetails xosnd
          = (XurmoOtherSocialNetworkDetails)(otherSocialNetworks_.elementAt(i));
      if (xosnd.socialNetwork_.equals("Twitter")) {
        tmp = xosnd.getAttribute("username");
        if (tmp != null) {
          twitterUsername = tmp;
        }
        tmp = xosnd.getAttribute("password");
        if (tmp != null) {
          twitterPassword = tmp;
        }
      } else if (xosnd.socialNetwork_.equals("Jaiku")) {
        tmp = xosnd.getAttribute("username");
        if (tmp != null) {
          jaikuUsername = tmp;
        }
        tmp = xosnd.getAttribute("personalKey");
        if (tmp != null) {
          jaikuPersonalKey = tmp;
        }
      }
    }
    homeData_
        = XurmoUserAuthenticationAndSessionWSInterface.homeScreenData(currentUser_.username_, currentUser_.cookie_, currentUser_.presence_, twitterUsername, twitterPassword, jaikuUsername, jaikuPersonalKey);
  }
  public String getPropertyValue(String name) {
    
    String propertyName = name;
    String property = System.getProperty(name);
    if (property == null) {
      property = new String("Unknown");
    }
    return property;
  }
  
  private XurmoUserAuthenticationReturnStatus logoutUser() {
    
    XurmoUserAuthenticationReturnStatus status
        = XurmoUserAuthenticationAndSessionWSInterface.logoutUser(currentUser_.username_,currentUser_.cookie_);
    currentUser_.invalidate();
    deleteUsernameAndPassword();
    return status;
  }
  public void transitionToHomeScreen() {
    
    if (home_ == null) {
      
      home_  = new XurmoHomeScreen(this);
    }
    Displayable d = getDisplay().getCurrent();
    if (!(d instanceof XurmoCanvas) ) {
      
      getDisplay().setCurrent(home_);
    } else {
      getDisplay().setCurrent(new XurmoSliderCanvas(this, (XurmoCanvas)d, home_, XurmoSliderCanvas.LEFT));
    }
  }
  public void transitionToRegisterScreen() {
    doRegister();
  }
  public void transitionToLoginScreen() {
    doLogin();
  }
  public void showAlert(String title, String msg, Image img) {
    Alert a = new Alert(title, msg, img, AlertType.ERROR);
    this.getDisplay().setCurrent(a);
  }
  public Display getDisplay() {
    return Display.getDisplay(this);
  }
  
  public void doLogin() {
    
    XurmoLoginUserPanel loginForm = new XurmoLoginUserPanel();
    XurmoLoginUserListener ca = new XurmoLoginUserListener(this, loginForm);
    loginForm.setCommandListener(ca);
    this.getDisplay().setCurrent(loginForm);
  }
  public void doRegister() {
    
    XurmoRegisterUserPanel registerForm = new XurmoRegisterUserPanel(this);
    XurmoRegisterUserListener ca = new XurmoRegisterUserListener(this, registerForm);
    registerForm.setCommandListener(ca);
    this.getDisplay().setCurrent(registerForm);
  }
  public void uploadPhonebook() {
    
    homeData_ = XurmoUserAuthenticationAndSessionWSInterface.uploadPhoneBook(currentUser_.username_, currentUser_.cookie_);
  }
  public void doLogout() {
    this.logoutUser();
  }
  public void refresh() {
    home_.repaint();
  }
  /**
   * This method should exit the midlet.
   */
  public void exitMIDlet() {
    getDisplay().setCurrent(null);
    destroyApp(true);
    notifyDestroyed();
  }
}