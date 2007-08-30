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

public class Xurmo extends MIDlet {
  /* These vars are used in the examples below */
  
  XurmoCurrentUser currentUser_;
  XurmoCanvas home_;
  XurmoUserHomeScreenData homeData_;
  
  private final String userAuthenticationRecordName_ = new String("UserAuthenticationRecords");;
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
    try {
      
      localBtListener_ = new XurmoBluetoothServiceListener();
    } catch(javax.bluetooth.BluetoothStateException bsex) {
      
    }
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
    try {
      deleteUsernameAndPassword();
      RecordStore rs = RecordStore.openRecordStore(userAuthenticationRecordName_, true);
      
      ByteArrayOutputStream bout = new ByteArrayOutputStream();
      DataOutputStream dout = new DataOutputStream( bout );
      
      dout.writeUTF(currentUser_.username_);
      dout.writeUTF(currentUser_.password_);
      dout.flush();
      byte[] data = bout.toByteArray();
      rs.addRecord(data, 0, data.length);
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
  }
  private boolean loadUsernameAndPasswordIfExist() {
    try {
      RecordStore rs = RecordStore.openRecordStore(userAuthenticationRecordName_, true);
      
      byte[] data = rs.getRecord(1);
      System.out.println("Loading username and password");
      
      ByteArrayInputStream bin = new ByteArrayInputStream(data);
      DataInputStream din = new DataInputStream( bin );
      
      currentUser_.username_  = din.readUTF();
      currentUser_.password_ = din.readUTF();
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
    return false;
  }
  private void deleteUsernameAndPassword() {
    try {
      RecordStore.deleteRecordStore(userAuthenticationRecordName_);
    } catch (RecordStoreFullException e) {
      System.err.println(e.toString() + "Username and password record store could not be deleted");
    } catch (RecordStoreNotFoundException e) {
      System.err.println(e.toString() + "Username and password record store could not be deleted");
    } catch (RecordStoreException e) {
      System.err.println(e.toString() + "Username and password record store could not be deleted");
    }
  }
  public XurmoUserAuthenticationReturnStatus performLogin() {
    homeData_
        = XurmoUserAuthenticationAndSessionWSInterface.loginUser(currentUser_.username_, currentUser_.password_);
    XurmoUserAuthenticationReturnStatus status = homeData_.status;
    if (status != null &&
        XurmoUserAuthenticationAndSessionWSInterface.isAuthenticationStatusSuccessful(status.errorCode_)) {
      currentUser_.loggedIn(currentUser_.username_, currentUser_.password_, status.cookie_, status.cellName_);
      XurmoInfoServicesListener listener = new XurmoInfoServicesListener(this, currentUser_.username_, currentUser_.cookie_);
      storeUsernameAndPassword();
      home_  = new XurmoCanvas(this);
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
    homeData_
        = XurmoUserAuthenticationAndSessionWSInterface.homeScreenData(currentUser_.username_, currentUser_.cookie_);
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
      home_  = new XurmoCanvas(this);
      this.getDisplay().setCurrent(home_);
      home_.setFullScreenMode(true);
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