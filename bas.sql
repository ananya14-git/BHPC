 create table employee
  (eId varchar2(10) primary key,
  eName varchar2(50) not null,
  eDesg varchar2(20),
  eDid varchar2(5),
  eDob date,
  eFatherName varchar2(50),
  ePhoneNo varchar2(10) unique,
  email varchar2(20) unique,
  eAppntmt varchar2(15),
  eCtgry varchar2(15),
  eGen varchar2(15),
  eMstatus varchar2(15),
  eBgrp varchar2(3),
  eDoj date,
  ePan varchar2(10) unique,
  eAdd varchar2(50) , 
  srNo number (6),
   image varchar2(200)
);
create sequence  empSeq start with 1001 increment by 1;
	
	
	 insert into employee(eId,eName,srNo) values('EMP-1001','admin',empSeq.nextval);

 create table department
  (dId varchar2(5) primary key,
  dName varchar2(30) not null,
  dManager varchar2(50),
  drNo number (6)
  );


 create table leave
  ( eId varchar2(10) ,
  leaveId varchar2(5),
  fromDate date,
  toDate date,
  lvName varchar2(30),
  noDays number(2),
 remDays number(2),
lMon varchar2(10),
lYr varchar2(10)
);


 create table attendence
  (eId varchar2(10),
  attenDate varchar2(20) ,
  inTime varchar2(20),
  outTime varchar2(20),
  status char(1) );


   create table login
    (userId varchar2(30) unique,
    psswd varchar2(20) not null,
    userType varchar2(10) not null,
    eId varchar2(10),
    uDob date,
    secQue varchar2(155),
    ans varchar2(55)
    );


 insert into login(userId,psswd,userType,eId) values('admin','123','Admin','EMP-1001');


 create table salary
  (eId varchar2(10),
  sMonth varchar2(10),
  sYear varchar2(10),
  basic number(10,2),
  da number(10,2),
  allowance number(10,2),
  hra number(10,2),
  total number(10,2),
  gpf number(10,2),
  gip number(10,2),
  lvDed number(10,2),
  loan number(10,2),
  totDed number(10,2),
  netPay number(10,2)
  );
  
  
  
  create  table generation 
  ( stnId varchar2(5) ,
    stnNm varchar2(30) not null,
	capacity number(7,2) not null,
	monthlyGen number(8,2),
	genMonth  varchar2(10),
	genYear  varchar2(10)
	);
	
	create  table distComp
	( stnId varchar2(5) primary key,
	 stnNm varchar2(30) not null,
	 compNm varchar2(10) not null
	 );
	 
	 create table distribution
	( stnId varchar2(5) ,
	 stnNm varchar2(30) not null,
	 compNm varchar2(30) not null,
	 qty number(8),
	 dMonth varchar2(10),
	 dYear varchar2(10)
	 );

	create table scale
	(eAppntmt varchar2(15),
	da number(8,2),
	hra number(8,2),
	gpf number(8,2),
	gip number(8,2),
	transAllow number(8),
	drivAllow number(8),
	washAllow number(8),
	medAllow number(8),
	lstUpdate  date,
    desg varchar2(30),
     basic number(10)
	);
	
	
	
    	create table loan
	(
	eId  varchar2(10),
	advType  varchar2(20),
	advAmt number(7),
	loanType varchar2(20),
	loanAmt number(10,2),
	interest number(4,2),
	install number(2),
	strtDate date,
	emi number(11,2)
	);

	create sequence depSeq start with 001 increment by 1;
	insert into department (dId,dName,dManager,drNo) values ('D000','sample','sample',depSeq.nextval);
                commit;

	create table lvMaster
	(
	 leaveId varchar2(10) primary key,
	lvName varchar2(30),
	lvDesc varchar2(80),
	lvDays varchar2(3),
	lvPeriod varchar2(20),
	lvStatus varchar2(15),
	lrNo number(6)
                );

               create sequence lvSeq start with 11 increment by 1;
           	insert into lvMaster(leaveId,lvName,lvDesc,lvStatus,lrNo)  values('L/00','---','---','sample',lvSeq.nextval);
	commit;