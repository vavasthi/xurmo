drop table XurmoUser;
create table XurmoUser 
(
  userid  integer not null unique key auto_increment,
  username char(32) primary key,
  password blob not null, 
  salutation char(5) not null default "Mr.",
  fname char(127) not null,
  lname char(127) not null,
  primaryMobile char(32) not null unique key,
  primaryMobileValidated boolean not null,
  primaryEmail char(127) not null unique key,
  primaryEmailValidated boolean not null,
  gender char(1),
  dob datetime not null,
  imei char(16) not null unique key,
  btAddress char(24) not null unique key
) default character set utf8;

drop table XurmoUserSession;
create table XurmoUserSession
(
  username char(32) primary key,
  cookie char(127) not null,
  locationId int not null,
  lastUpdateTime datetime
) default character set utf8;

drop table XurmoPersonalAddressBook;
create table XurmoPersonalAddressBook
(
  userid integer not null,
  uniqueId integer not null,
  contactName varchar(128) not null,
  nickname varchar(128),
  birthday datetime,
  primary key(userid, uniqueId)
) default character set utf8;

drop table XurmoPersonalAddressBookPhoneNumbers;
create table XurmoPersonalAddressBookPhoneNumbers
(
  userid integer,
  uniqueId integer,
  attributeId integer,
  entry integer,
  phoneNumber char(128),
  primary key(userid, uniqueId, attributeId, entry)
) default character set utf8;

drop table XurmoPersonalAddressBookEmailAddress;
create table XurmoPersonalAddressBookEmailAddress
(
  userid integer,
  uniqueId integer,
  attributeId integer,
  entry integer,
  emailAddress char(128),
  primary key(userid, uniqueId, attributeId, entry)
) default character set utf8;

drop table XurmoPersonalAddressBookAddress;
create table XurmoPersonalAddressBookAddress
(
  userid integer,
  uniqueId integer,
  attributeId integer,
  entry integer,
  address char(255),
  primary key(userid, uniqueId, attributeId, entry)
) default character set utf8;

drop table XurmoCellLocationMap;
create table XurmoCellLocationMap
(
  mobileCountryCode char(3) not null,
  mobileNetworkCode char(3) not null,
  siteId char(10) not null,
  cellId char(10) not null,
  locationId int not null primary key auto_increment,
  location char(127) not null,
  unique key (mobileCountryCode, mobileNetworkCode, siteId, cellId)
) default character set utf8;

drop table XurmoMessageInbox;
create table XurmoMessageInbox
(
  messageId int primary key auto_increment,
  fromLocationId int not null,
  sourceId char(32) not null,
  toLocationId int not null,
  destinationId char(32) not null,
  msgStatus char(1) not null default "N",
  msg varchar(1024) not null
) default character set utf8;

drop table XurmoRequestToConnectInbox;
create table XurmoRequestToConnectInbox
(
  
  username char(32) not null,
  source char(32) not null,
  linkId int not null,
  msg varchar(1024) not null,
  primary key(username, source, linkId)
) default character set utf8;

drop table XurmoResponseToRequestToConnectInbox;
create table XurmoResponseToRequestToConnectInbox
(
  username char(32) not null,
  source char(32) not null,
  linkId int not null,
  msg varchar(1024) not null,
  primary key(username, source, linkId)
) default character set utf8;

drop table XurmoNetworkLinkType;
create table XurmoNetworkLinkType 
(
  linkId int primary key,
  linkName char(64) not null
) default character set utf8;

insert into XurmoNetworkLinkType values(1, "Family");
insert into XurmoNetworkLinkType values(2, "Friends");
insert into XurmoNetworkLinkType values(3, "Professional");
insert into XurmoNetworkLinkType values(4, "Alumni");
insert into XurmoNetworkLinkType values(5, "Casual");

drop table XurmoRequestToConnectResponseType;
create table XurmoRequestToConnectResponseType
(
  responseId int primary key,
  responseLabel char(64) not null
) default character set utf8;

insert into XurmoRequestToConnectResponseType values(1, "Accept");
insert into XurmoRequestToConnectResponseType values(2, "Decline");
insert into XurmoRequestToConnectResponseType values(3, "Decline Silently");
insert into XurmoRequestToConnectResponseType values(4, "Postpone");

drop table XurmoNetworkLink;
create table XurmoNetworkLink
(
  username1 char(32),
  username2 char(32),
  linkId      int,
  creationDate datetime not null,
  primary key (username1, username2, linkId)
) default character set utf8;

drop table XurmoMessagesForALocationSourceDestinationPair;
create table XurmoMessagesForALocationSourceDestinationPair
(
  locationId int not null,
  sourceId char(32) not null,
  destinationId char(32) not null,
  sourceDestinationId int not null primary key auto_increment,
  unique key (locationId, sourceId, destinationId)
) default character set utf8;

drop table XurmoMessageForALocation;
create table XurmoMessageForALocation
(
  sourceDestinationId int primary key,
  msg varchar(1024)
) default character set utf8;

drop table XurmoErrors;
create table XurmoErrors
(
  error int primary key auto_increment,
  errorStr varchar(255),
  errorMsg varchar(1024)
) default character set utf8;

