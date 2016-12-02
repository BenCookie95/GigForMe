INSERT INTO Venues(Venue_Name, Capacity, Latitude, Longitude)
Values('The Marquee', 10000, '51.8981718', '-8.4429219');
INSERT INTO Venues(Venue_Name, Capacity, Latitude, Longitude)
Values('Croke Park', 80000, '53.360611', '-6.2534706');
INSERT INTO Venues(Venue_Name, Capacity, Latitude, Longitude)
Values('The Aviva Stadium', 80000, '53.3342077', '-6.2297135');
INSERT INTO Venues(Venue_Name, Capacity, Latitude, Longitude)
Values('The 02 Arena', 50000, '53.3476472', '-6.2306857');
INSERT INTO GIG(VENUEID,BANDID,USERID,GIG_DESCRIPTION,DATE_CREATED,GIG_DATE,PRICE,ISCONFIRMED)
VALUES(1,1,1,'I never had a chance to see U2 play',CURRENT_TIMESTAMP,'2016-06-23',100.00,'NO');
INSERT INTO GIG(VENUEID,BANDID,USERID,GIG_DESCRIPTION,DATE_CREATED,GIG_DATE,PRICE,ISCONFIRMED)
VALUES(2,2,2,'I really want to see Coldplay back playing in Ireland',CURRENT_TIMESTAMP,'2016-06-27',120.00,'NO');
INSERT INTO GIG(VENUEID,BANDID,USERID,GIG_DESCRIPTION,DATE_CREATED,GIG_DATE,PRICE,ISCONFIRMED)
VALUES(3,3,1,'Coldplay are my favourite band, really want to see them play in the Aviva',CURRENT_TIMESTAMP,'2016-04-07',70.00,'YES');
INSERT INTO GIG(VENUEID,BANDID,USERID,GIG_DESCRIPTION,DATE_CREATED,GIG_DATE,PRICE,ISCONFIRMED)
VALUES(4,3,3,'We want  play a gig in the aviva for enveryone, tickets on sale soon!',CURRENT_TIMESTAMP,'2016-10-14',70.00,'YES');
INSERT INTO GIG(VENUEID,BANDID,USERID,GIG_DESCRIPTION,DATE_CREATED,GIG_DATE,PRICE,ISCONFIRMED)
VALUES(2,3,3,'Imagine Dragons are my fabourite band and I am yet to see them live!',CURRENT_TIMESTAMP,'2016-12-10',100.00,'NO');
INSERT INTO GIG(VENUEID,BANDID,USERID,GIG_DESCRIPTION,DATE_CREATED,GIG_DATE,PRICE,ISCONFIRMED)
VALUES(1,2,4,'Coldplay are the best',CURRENT_TIMESTAMP,'2016-05-20',100.00,'NO');
INSERT INTO GIG(VENUEID,BANDID,USERID,GIG_DESCRIPTION,DATE_CREATED,GIG_DATE,PRICE,ISCONFIRMED)
VALUES(3,3,2,'Imagine Dragons really need to play in Ireland again',CURRENT_TIMESTAMP,'2016-08-15',100.00,'NO');
INSERT INTO GIG(VENUEID,BANDID,USERID,GIG_DESCRIPTION,DATE_CREATED,GIG_DATE,PRICE,ISCONFIRMED)
VALUES(4,1,1,'U2 are my favourite',CURRENT_TIMESTAMP,'2016-7-13',150.00,'NO');
INSERT INTO VOTES(USERID, GIGID)
VALUES(2,2);
INSERT INTO VOTES(USERID, GIGID)
VALUES(1,3);
INSERT INTO VOTES(USERID, GIGID)
VALUES(3,4);
INSERT INTO VOTES(USERID, GIGID)
VALUES(1,2);
INSERT INTO VOTES(USERID, GIGID)
VALUES(4,3);
INSERT INTO VOTES(USERID, GIGID)
VALUES(2,1);
INSERT INTO VOTES(USERID, GIGID)
VALUES(4,4);
INSERT INTO VOTES(USERID, GIGID)
VALUES(1,4);
INSERT INTO VOTES(USERID, GIGID)
VALUES(3,1);
INSERT INTO VOTES(USERID, GIGID)
VALUES(4,1);
INSERT INTO VOTES(USERID, GIGID)
VALUES(3,3);
INSERT INTO VOTES(USERID, GIGID)
VALUES(2,4);
INSERT INTO COMMENT(USERID, BANDID, GIGID, USERCOMMENT)
VALUES(1,0,1,'Awesome gig maaan');
INSERT INTO COMMENT(USERID, BANDID, GIGID, USERCOMMENT)
VALUES(2,0,3,'Cannot Wait!');
INSERT INTO COMMENT(USERID, BANDID, GIGID, USERCOMMENT)
VALUES(3,0,4,'Nice Venue Choice');
INSERT INTO COMMENT(USERID, BANDID, GIGID, USERCOMMENT)
VALUES(4,0,2,'The ticket price is too high');
INSERT INTO COMMENT(USERID, BANDID, GIGID, USERCOMMENT)
VALUES(1,0,2,'Coldplay are rubbish, boooo!');
INSERT INTO COMMENT(USERID, BANDID, GIGID, USERCOMMENT)
VALUES(3,0,2,'This will be interesting');
INSERT INTO COMMENT(USERID, BANDID, GIGID, USERCOMMENT)
VALUES(3,0,3,'This is going to be great, see everyone there');
INSERT INTO COMMENT(USERID, BANDID, GIGID, USERCOMMENT)
VALUES(0,3,1,'Not too sure about the venue choice, hmmm');
INSERT INTO COMMENT(USERID, BANDID, GIGID, USERCOMMENT)
VALUES(0,1,4,'Best Of Luck Imagine Dragons');
INSERT INTO COMMENT(USERID, BANDID, GIGID, USERCOMMENT)
VALUES(2,0,1,'I hope they accept this');
INSERT INTO COMMENT(USERID, BANDID, GIGID, USERCOMMENT)
VALUES(0,2,3,'Really looking forward to this');
INSERT INTO COMMENT(USERID, BANDID, GIGID, USERCOMMENT)
VALUES(3,0,1,'Not a fan of U2, will they ever just retire!');
INSERT INTO COMMENT(USERID, BANDID, GIGID, USERCOMMENT)
VALUES(1,0,4,'I love Imagine Dragons');
INSERT INTO USERS(USERNAME,UNAME,BIO,EMAIL,PICDIR,ISADMIN,PASSWORD,ISBANNED)
VALUES('Ben_Cookie','Ben Cooke','Hi, im ben i play football for Wales and cardiff city. Im about 6 foot with brown hair and brown eyes, like to go out with my m8s and familly! I live in Caerphilly a little town by Cardiff so if ya wanna get 2 know me more add me on msn aaron_ramsey_8@hotmail.co.uk','benkcooke@gmail.com','img/profpic.jpg','YES','password','NO');
INSERT INTO USERS(USERNAME,UNAME,BIO,EMAIL,PICDIR,ISADMIN,PASSWORD,ISBANNED)
VALUES('Cian_O_Shea', 'Cian O Shea', 'Im terrible at java', 'cian@gmail.com', 'img/profile.jpg', 'NO','password','NO');
INSERT INTO USERS(USERNAME,UNAME,BIO,EMAIL,PICDIR,ISADMIN,PASSWORD,ISBANNED)
VALUES('Oin','Oin Buckley','I got U2 to Croke Park','Oin@gmail.com','img/profile.jpg','YES','password','NO');
INSERT INTO USERS(USERNAME,UNAME,BIO,EMAIL,PICDIR,ISADMIN,PASSWORD,ISBANNED)
VALUES('Andrew', 'Andrew Cooke', 'Im terrible at java', 'Andrew@gmail.com', 'img/profile.jpg', 'NO','password','No');
INSERT INTO BAND(USERNAME,BAND_NAME,BIO,EMAIL,PICDIR,PASSWORD)
VALUES('U2','U2 <i class="fa fa-check-square-o"></i>','We are U2 and are really excited to see the gigs you will create for us', 'U2@gmail.com', 'img/u2.png','password');
INSERT INTO BAND(USERNAME,BAND_NAME,BIO,EMAIL,PICDIR,PASSWORD)
VALUES('Coldplay','Coldplay <i class="fa fa-check-square-o"></i>','We are Coldplay and are really excited to see the gigs you will create for us', 'Coldplay@gmail.com', 'img/coldplay2.jpg','password');
INSERT INTO BAND(USERNAME,BAND_NAME,BIO,EMAIL,PICDIR,PASSWORD)
VALUES('ImagineDragons','Imagine Dragons <i class="fa fa-check-square-o"></i>','We are Imagine Dragons and are really excited to see the gigs you will create for us', 'ImagineDragons@gmail.com', 'img/imaginedragons.jpe','password');