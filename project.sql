create table Login(
Username varchar(30) not NULL,
login_Password varchar(30) not NULL,
login_role varchar(15) not null,
CONSTRAINT fk_login_participant FOREIGN KEY (Username)
		REFERENCES Participant(Username),
CONSTRAINT fk_login_host FOREIGN KEY (Username)
		REFERENCES HostTable(Username)
);

create table Host(
Username varchar(30) not null primary key,
Email varchar(30) not null,
Fname varchar(30) not null,
Mname varchar(30),
Lname varchar(30) not null,
isPremium boolean  
);

create table Participent(
Username varchar(30) not null primary key,
MeetingId varchar(30),
Email varchar(30) not null,
Fname varchar(30) not null,
Mname varchar(30),
Lname varchar(30) not null 
);

create table Meeting(
MeetingId varchar(30) not null primary key,
ParticpantsCount int not null,
MaxTime time,
HostUserName varchar(30) not null,
		CONSTRAINT m_HostUsername FOREIGN KEY (HostUserName)
		REFERENCES Host(Username)
);

create table MeetingSettings(
MeetingId varchar(30) not null,
EnableRecord boolean not null,
EnableCamera boolean not null,
EnableMic boolean not null,
EnableShareScreen boolean not null,
EnableAnnotate boolean not null,
		CONSTRAINT fk_ms_meetingId FOREIGN KEY (MeetingId)
		REFERENCES Meeting(MeetingId)
);



create table Participents( 
Username varchar(30) not null,
MeetingId varchar(30) not null,
CONSTRAINT p_userN FOREIGN KEY (Username)
            REFERENCES Participent(Username)
);

/*
CONSTRAINT mp_id FOREIGN KEY (MeetingId)
            REFERENCES Meeting(MeetingId)
            
            CONSTRAINT mh_id FOREIGN KEY (MeetingId)
            REFERENCES Meeting(MeetingId)
);
*/
create table Hosts(
Username varchar(30) not null,
MeetingId varchar(30) not null,
CONSTRAINT h_userN FOREIGN KEY (Username)
            REFERENCES Host(Username)
);

create table Messeges(
MeetingId varchar(30) not null primary key,
MessegeTime datetime,
ChatText varchar(255),
ChatFrom varchar(30),
ChatTo varchar(30)
);

-- find all the meeting with number participant gratter or equal to 30
select MeetingId, HostUsername 
from Meeting
where ParticpantsCount >=30;

-- find all the participants with first name "Tal"
select Username,Fname,Lname 
from ParticipantTable
where Fname Like 'Tal';

-- find all messeges between given time in specific meeting 
select MessegeTime,ChatText,ChatFrom,ChatTo, MeetingId
from Messeges
where MessegeTime between '22/04/2020 08:00:03 AM'  AND '22/04/2020 10:30:00 AM';


-- find all participants that can turn their camera on 
select Fname,Lname,Username
from ParticipantTable 
inner join MeetingSettings on ParticipantTable.MeetingId = MeetingSettings.MeetingId
where EnableCamera = true;

-- find all messeges from specific meeting sent to everyone
select ChatText,ChatFrom
from Messeges
where ChatTo = 'everyone' and MeetingId = 1;
 
 
-- find all Users with Gmail account 
select Email,Username,Fname,Lname
from ParticipantTable join HostTable
where Email like '%@Gmail%';



insert into HostTable(Username,Fname,Mname,Lname,Email,isPremium)
values
('Yomyom','Yoram','hachman'	,'lis',	'glasses@walla.com',FALSE),
('SIMS','Liat','Simpson','Lili','theSimpsons@gmail.com',TRUE),
('Epsilon','Rivi','Leshem','Any','Rivriv5@gmail.com',TRUE);



insert into Login(Username,Login_Password,Login_role)
values
((select Username from ParticipantTable where Username = 'Tommy'),'Cs13ees',	'participant'),
((select Username from ParticipantTable where Username = 'mantos'),'123456','participant'),
((select Username from ParticipantTable where Username = 'Tallll'),'ohNo!','participant'),
-- ('theBoss','1212DsW','host'),
('noamam','Balagan5','participant'),
('twoTal','MyPassword','participant'),
('nadavvv','q1w2e3','participant'),
('hiGuy','abcdEFG','participant'),
('noT','123456789','participant'),
('yesT','1122334455','participant'),
('shanini','ddd444r','participant'),
('dordor18','fdfdfd12','participant'),
('mayaya31','azsxdc','participant'),
('fisu','CdeFr','participant'),
('theQueen','cDFEw1','participant'),
-- ('Ruller','#$fdC!','host'),
('chenchen','bbbnnF3','participant'),
('michi','123123123','participant'),
('theAngel','1212cv','participant'),
('adidas','klokju','participant'),
('stui','trtrtr65','participant');



insert into ParticipantTable(Username,Fname,Lname,Mname,Email,meetingId)
values
('Tommy','Tom','Lewis','Aharon','Tom15@gmail.com',null),
('sara12','Sara','Benita','Elisha','SaritaUnicorn@gmail.com',null),
('mantos','Matan','Cohen','Moshe','HaMelechMatan@gmail.com',null),
('Tallll','Tali','Levine','Itzhak','Sweet16@walla.co.il',null),
('noamam','Noam','Hertzel','Yaacov','No-AmOk@gmail.com',null),
('twoTal','Tal','Bank','Hana','TaltulyMatoki@walla.com',null),
('nadavvv','Nadav','Hutuveli','Rebbeca','DragonS1993@gmail.com',null),
('hiGuy','Guy','Harmon','Yael','KidPlayer@yahoo.com',null),
('noT','Omer','Etinger','Iyov','FireBall6@gmail.com',null),
('yesT','Tomer','Maimon','Narkis','TomerRico7@gmail.com',null),
('shanini',	'Shani'	,'Bosni','Shlomo','ShuvNoldaYalda@gmail.com',null),
('dordor18','Dor','Blich','Shlomi','DorTheFuture@walla.com',null),
('mayaya31','Maya','Apshtein','Aron','MayushAni@yahoo.com',null),
('fisu','Sofi','Levy','Rut','Sofa53@gmail.com',null),
('theQueen','Lee','Yaacoby','Simcha','Lihi40@gmail.com',null),
('chenchen','Chen','Hatan','Melleny','ChenTal@walla.com',null),
('michi','Michal','Shamir','Miriam','MichalTheSleepyQueen@gmail.com',null),
('theAngel','Michael','Hanan','Moshe','ShineOn@walla.com',null),
('adidas','Adi','Meller','Miri','TachshitShely@gmail.com',null),
('stui','Stav','Azar','Michael','AutumnOf1897@gmail.com)',null);

insert into Meeting(MeetingId,ParticpantsCount,MaxTime,HostUserName)
value
('1',8,'2','theBoss'),
('2',2,'2','Ruller'),
('3',11,'4','Yomyom'),
('4',4,'2','SIMS'),
('5',15,'3','Epsilon');

insert into MeetingSettings(MeetingId,EnableRecord,EnableCamera,EnableMic,EnableShareScreen,EnableAnnotate)
value
('1',TRUE,TRUE,TRUE,FALSE,FALSE),
('2',FALSE,TRUE,TRUE,FALSE,TRUE),
('3',TRUE,TRUE,TRUE,FALSE,FALSE),
('4',TRUE,TRUE,TRUE,FALSE,TRUE),
('5',TRUE,TRUE,TRUE,FALSE,TRUE);


