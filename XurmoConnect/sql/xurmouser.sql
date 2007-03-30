drop table XurmoUser;
create table XurmoUser 
(
  username char(32) primary key,
  password blob not null, 
  salutation char(5) not null default "Mr.",
  fname char(127) not null,
  lname char(127) not null,
  primaryMobile char(32) not null unique key,
  primaryEmail char(127) not null unique key,
  gender char(1),
  dob datetime not null
) default character set utf8;

drop table XurmoUserSession;
create table XurmoUserSession
(
  username char(32) primary key,
  cookie char(127) not null,
  location char(127) not null,
  lastUpdateTime datetime
) default character set utf8;

drop table XurmoPersonalAddressBook;
create table XurmoPersonalAddressBook
(
  username char(32) not null primary key,
  fullName varchar(256) not null,
  unique key(username)
) default character set utf8;

drop table XurmoPersonalPhoneNumberEntry;
create table XurmoPersonalPhoneNumberEntry
(
  username char(32) not null,
  addressType char(32),
  address char(32),
  primary key(username, addressType)
) default character set utf8;

drop table XurmoPersonalEmailEntry;
create table XurmoPersonalEmailEntry
(
  username char(32) not null primary key,
  email char(127)
) default character set utf8;


drop table XurmoCellLocationMap;
create table XurmoCellLocationMap
(
  mobileCountryCode char(3) not null,
  mobileNetworkCode char(3) not null,
  siteId char(10) not null,
  cellId char(10) not null,
  location char(127) not null,
  primary key (mobileCountryCode, mobileNetworkCode, siteId, cellId)
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
  msg varchar(1024) not null,
  primary key(username, source)
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
