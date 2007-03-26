drop table XurmoUser;
create table XurmoUser 
(
  username char(32) primary key,
  password blob not null, 
  fname char(127) not null,
  lname char(127) not null,
  primaryMobile char(32) not null unique key,
  primaryEmail char(127) not null unique key,
  loggedIn bit default 0,
  location char(127) 
) default character set utf8;

drop table XurmoUserSession;
create table XurmoUserSession
(
  username char(32) primary key,
  cookie char(127) not null,
  lastUpdateTime datetime
) default character set utf8;