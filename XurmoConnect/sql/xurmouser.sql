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