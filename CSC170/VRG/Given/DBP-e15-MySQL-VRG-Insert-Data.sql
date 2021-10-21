/********************************************************************************/
/*																				*/
/*	Kroenke, Auer, Vandenberg, and Yoder - Database Processing (15th Edition)	*/
/*  Chapters 7, 10C																*/
/*	The View Ridge Gallery (VRG) Database - Insert Data							*/
/*																				*/
/*	These are the MySQL 5.7 SQL code solutions									*/
/*																				*/
/********************************************************************************/
/*																				*/
/*	This file contains the initial data for each table.							*/
/*																				*/
/*	NOTE:  For MySQL, We use NULL when inserting the next auto_increment	    */
/*	value into the table. This is specific to MySQL.							*/
/*																				*/
/*																				*/
/********************************************************************************/

USE vrg09;

/********************************************************************************/			

/*	INSERT data for CUSTOMER													*/



INSERT INTO CUSTOMER
	(CustomerID, LastName,  FirstName, EmailAddress, EncryptedPassword,
	 Street, City, State, ZIPorPostalCode, Country,
	 AreaCode, PhoneNumber)
	VALUES (
	1000, 'Janes', 'Jeffrey', 'Jeffrey.Janes@somewhere.com', 'ng76tG9E','123 W. Elm St', 'Renton', 'WA', '98055', 'USA',
	'425', '543-2345');

INSERT INTO CUSTOMER
	(CustomerID, LastName,  FirstName, EmailAddress, EncryptedPassword,
	 Street, City, State, ZIPorPostalCode, Country,
	 AreaCode, PhoneNumber)
	VALUES (
 	1001, 'Smith', 'David', 'David.Smith@somewhere.com', 'ttr67i23', '813 Tumbleweed Lane', 'Loveland', 'CO', '81201', 'USA',
 	'970', '654-9876');

INSERT INTO CUSTOMER
	(CustomerID, LastName,  FirstName, EmailAddress, EncryptedPassword,
	 Street, City, State, ZIPorPostalCode, Country,
	 AreaCode, PhoneNumber)
	VALUES (
	1015, 'Twilight', 'Tiffany', 'Tiffany.Twilight@somewhere.com', 'gr44t5uz', '88 1st Avenue', 'Langley', 'WA', '98260', 'USA',
	 '360', '765-5566');

INSERT INTO CUSTOMER
	(CustomerID, LastName,  FirstName, EmailAddress, EncryptedPassword,
	 Street, City, State, ZIPorPostalCode, Country,
	 AreaCode, PhoneNumber)
	VALUES (
	1033, 'Smathers', 'Fred', 'Fred.Smathers@somewhere.com', 'mnF3D00Q', '10899 88th Ave', 'Bainbridge Island', 'WA', '98110', 'USA',
	 '206', '876-9911');

INSERT INTO CUSTOMER
	(CustomerID, LastName,  FirstName, EmailAddress, EncryptedPassword,
	 Street, City, State, ZIPorPostalCode, Country,
	 AreaCode, PhoneNumber)
	VALUES (
	1034, 'Frederickson', 'Mary Beth', 'MaryBeth.Frederickson@somewhere.com', 'Nd5qr4Tv', '25 South Lafayette', 'Denver', 'CO', '80201', 'USA',
	'303', '513-8822');

INSERT INTO CUSTOMER
	(CustomerID, LastName,  FirstName, EmailAddress, EncryptedPassword,
	 Street, City, State, ZIPorPostalCode, Country,
	 AreaCode, PhoneNumber)
	VALUES (
	1036, 'Warning', 'Selma', 'Selma.Warning@somewhere.com', 'CAe3Gh98', '205 Burnaby', 'Vancouver', 'BC', 'V6Z 1W2', 'Canada',
	'604', '988-0512');

INSERT INTO CUSTOMER
	(CustomerID, LastName,  FirstName, EmailAddress, EncryptedPassword,
	 Street, City, State, ZIPorPostalCode, Country,
	 AreaCode, PhoneNumber)
	VALUES (
	1037, 'Wu', 'Susan', 'Susan.Wu@somewhere.com', 'Ues3thQ2','105 Locust Ave', 'Atlanta', 'GA', '30322', 'USA',
	'404', '653-3465');

INSERT INTO CUSTOMER
	(CustomerID, LastName,  FirstName, EmailAddress, EncryptedPassword,
	 Street, City, State, ZIPorPostalCode, Country,
	 AreaCode, PhoneNumber)
	VALUES (
	1040, 'Gray', 'Donald','Donald.Gray@somewhere.com', NULL,'55 Bodega Ave', 'Bodega Bay', 'CA', '94923', 'USA',
	'707', '568-4839');

INSERT INTO CUSTOMER
	(CustomerID, LastName,  FirstName, EmailAddress, EncryptedPassword,
	 Street, City, State, ZIPorPostalCode, Country,
	 AreaCode, PhoneNumber)
	VALUES (
	1041, 'Johnson', 'Lynda', NULL, NULL, '117 C Street', 'Washington', 'DC', '20003', 'USA',
	'202', '438-5498');

INSERT INTO CUSTOMER
	(CustomerID, LastName,  FirstName, EmailAddress, EncryptedPassword,
	 Street, City, State, ZIPorPostalCode, Country,
	 AreaCode, PhoneNumber)
	VALUES (
	1051, 'Wilkens', 'Chris', 'Chris.Wilkens@somewhere.com', '45QZjx59','87 Highland Drive', 'Olympia', 'WA', '98508', 'USA',
	'360', '876-8822'); 



/********************************************************************************/			

/*	INSERT data for ARTIST														*/


INSERT INTO ARTIST
	(ArtistID, LastName, FirstName, Nationality, DateOfBirth, DateDeceased)
	VALUES (
	1, 'Miro', 'Joan', 'Spanish', 1893, 1983);
INSERT INTO ARTIST
	(ArtistID, LastName, FirstName, Nationality, DateOfBirth, DateDeceased)
	VALUES (
	2, 'Kandinsky', 'Wassily', 'Russian', 1866, 1944);
INSERT INTO ARTIST
	(ArtistID, LastName, FirstName, Nationality, DateOfBirth, DateDeceased)
	VALUES (
	3, 'Klee', 'Paul', 'German', 1879, 1940);
INSERT INTO ARTIST
	(ArtistID, LastName, FirstName, Nationality, DateOfBirth, DateDeceased)
	VALUES (
	4, 'Matisse', 'Henri', 'French', 1869, 1954);
INSERT INTO ARTIST
	(ArtistID, LastName, FirstName, Nationality, DateOfBirth, DateDeceased)
	VALUES (
	5, 'Chagall', 'Marc', 'French', 1887, 1985);
INSERT INTO ARTIST
	(ArtistID, LastName, FirstName, Nationality, DateOfBirth, DateDeceased)
	VALUES (
	11, 'Sargent', 'John Singer', 'United States', 1856, 1925);
INSERT INTO ARTIST
	(ArtistID, LastName, FirstName, Nationality, DateOfBirth, DateDeceased)
	VALUES (
	17, 'Tobey', 'Mark', 'United States', 1890, 1976);
INSERT INTO ARTIST
	(ArtistID, LastName, FirstName, Nationality, DateOfBirth, DateDeceased)
	VALUES (
	18, 'Horiuchi', 'Paul', 'United States', 1906, 1999);
INSERT INTO ARTIST
	(ArtistID, LastName, FirstName, Nationality, DateOfBirth, DateDeceased)
	VALUES (
	19, 'Graves', 'Morris', 'United States', 1920, 2001);


/********************************************************************************/

/*	INSERT data for CUSTOMER_ARTIST_INT											*/


INSERT INTO CUSTOMER_ARTIST_INT VALUES (1, 1001);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (1, 1034);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (2, 1001);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (2, 1034);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (4, 1001);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (4, 1034);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (5, 1001);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (5, 1034);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (5, 1036);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (11, 1001);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (11, 1015);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (11, 1036);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (17,	1000);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (17,	1015);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (17,	1033);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (17,	1040);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (17,	1051);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (18,	1000);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (18,	1015);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (18,	1033);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (18,	1040);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (18,	1051);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (19,	1000);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (19,	1015);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (19,	1033);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (19,	1036);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (19,	1040);
INSERT INTO CUSTOMER_ARTIST_INT VALUES (19,	1051);

/********************************************************************************/			

/*	INSERT data for WORK														*/


INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	500, 'Memories IV', 'Unique', 'Casein rice paper collage', '31 x 24.8 in.', 18);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	511, 'Surf and Bird', '142/500', 'High Quality Limited Print', 'Northwest School Expressionist style', 19);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	521, 'The Tilled Field', '788/1000', 'High Quality Limited Print', 'Early Surrealist style', 1);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	522, 'La Lecon de Ski', '353/500', 'High Quality Limited Print', 'Surrealist style', 1);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	523, 'On White II', '435/500', 'High Quality Limited Print', 'Bauhaus style of Kandinsky', 2);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	524, 'Woman with a Hat', '596/750', 'High Quality Limited Print', 'A very colorful Impressionist piece', 4);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	537, 'The Woven World', '17/750', 'Color lithograph', 'Signed', 17);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	548, 'Night Bird', 'Unique', 'Watercolor on Paper', '50 x 72.5 cm. - Signed', 19);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	551, 'Der Blaue Reiter', '236/1000', 'High Quality Limited Print', 'The Blue Rider-Early Pointilism influence', 2);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	552, 'Angelus Novus', '659/750', 'High Quality Limited Print', 'Bauhaus style of Klee', 3);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	553, 'The Dance', '734/1000', 'High Quality Limited Print', 'An Impressionist masterpiece', 4);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	554, 'I and the Village', '834/1000', 'High Quality Limited Print', 'Shows Belarusian folk-life themes and symbology', 5);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	555, 'Claude Monet Painting', '684/1000', 'High Quality Limited Print', 'Shows French Impressionist influence of Monet', 11);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	561, 'Sunflower', 'Unique', 'Watercolor and ink', '33.3 x 16.1 cm. - Signed', 19);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	562, 'The Fiddler', '251/1000', 'High Quality Limited Print', 'Shows Belarusian folk-life themes and symbology', 5);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	563, 'Spanish Dancer', '583/750', 'High Quality Limited Print', 'American realist style - From work in Spain', 11);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	564, 'Farmer''s Market #2',	'267/500', 'High Quality Limited Print', 'Northwest School Abstract Expressionist style', 17);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	565, 'Farmer''s Market #2',	'268/500', 'High Quality Limited Print', 'Northwest School Abstract Expressionist style', 17);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	566, 'Into Time', '323/500', 'High Quality Limited Print', 'Northwest School Abstract Expressionist style', 18);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	570, 'Untitled Number 1', 'Unique', 'Monotype with tempera', '4.3 x 6.1 in. Signed', 17);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	571, 'Yellow Covers Blue', 'Unique', 'Oil and collage', '71 x 78 in. - Signed', 18);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	578, 'Mid-Century Hibernation', '362/500', 'High Quality Limited Print', 'Northwest School Expressionist style', 19);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	580, 'Forms in Progress I', 'Unique', 'Color aquatint', '19.3 x 24.4 in. - Signed', 17);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	581, 'Forms in Progress II', 'Unique', 'Color aquatint', '19.3 x 24.4 in. - Signed', 17);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	585, 'The Fiddler', '252/1000', 'High Quality Limited Print', 'Shows Belarusian folk-life themes and symbology', 5);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	586, 'Spanish Dancer', '588/750', 'High Quality Limited Print', 'American Realist style - From work in Spain', 11);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	587, 'Broadway Boggie', '433/500', 'High Quality Limited Print', 'Northwest School Abstract Expressionist style', 17);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	588, 'Universal Field', '114/500', 'High Quality Limited Print', 'Northwest School Abstract Expressionist style', 17);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	589, 'Color Floating in Time', '487/500', 'High Quality Limited Print', 'Northwest School Abstract Expressionist style', 18);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	590, 'Blue Interior', 'Unique', 'Tempera on card', '43.9 x 28 in.', 17);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	593, 'Surf and Bird', 'Unique', 'Gouache', '26.5 x 29.75 in. - Signed', 19);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	594, 'Surf and Bird', '362/500', 'High Quality Limited Print', 'Northwest School Expressionist style', 19);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	595, 'Surf and Bird', '365/500', 'High Quality Limited Print', 'Northwest School Expressionist style', 19);
INSERT INTO WORK (WorkID, Title, Copy, Medium, Description, ArtistID)
	VALUES (
	596, 'Surf and Bird', '366/500', 'High Quality Limited Print', 'Northwest School Expressionist style', 19);


/********************************************************************************/			

/*	INSERT data for TRANS														*/


INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES (
	100, '2014/11/4', 30000.00, 45000.00, '2014/12/14', 42500.00, 1000, 500);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES (
	101, '2014/11/7', 250.00, 500.00, '2014/12/19', 500.00,	1015, 511);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES (
	102, '2014/11/17', 125.00, 250.00, '2015/01/18', 200.00, 1001, 521);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES (
	103, '2014/11/17', 250.00, 500.00, '2015/12/12', 400.00, 1034, 522);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES (
	104, '2014/11/17', 250.00, 250.00, '2015/01/18', 200.00, 1001, 523);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES (
	105, '2014/11/17', 200.00, 500.00, '2015/12/12', 400.00, 1034, 524);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES (
	115, '2015/03/03', 1500.00, 3000.00, '2015/06/07', 2750.00, 1033, 537);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES (
	121, '2015/09/21', 15000.00, 30000.00, '2015/11/28', 27500.00,	1015, 548);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES (
	125, '2015/11/21', 125.00, 250.00, '2015/12/18', 200.00, 1001, 551);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, WorkID)
 	VALUES (
	126, '2015/11/21', 200.00, 400.00, 552);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES (
	127, '2015/11/21', 125.00, 500.00, '2015/12/22', 400.00, 1034, 553);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES (
	128, '2015/11/21', 125.00, 250.00, '2016/03/16', 225.00, 1036, 554);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES (
	129, '2015/11/21', 125.00, 250.00, '2016/03/16', 225.00, 1036, 555);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES (
	151, '2016/05/07', 10000.00, 20000.00, '2016/06/28', 17500.00, 1036, 561);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES (
	152, '2016/05/18', 125.00, 250.00, '2016/08/15', 225.00, 1001, 562);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES ( 	
	153, '2016/05/18', 200.00, 400.00, '2016/08/15', 350.00, 1001, 563);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES ( 	
	154, '2016/05/18', 250.00, 500.00, '2016/09/28', 400.00, 1040, 564);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, WorkID)
 	VALUES (
	155, '2016/05/18', 250.00, 500.00, 565);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES (
	156, '2016/05/18', 250.00, 500.00, '2016/09/27', 400.00, 1040, 566);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES ( 	
	161, '2016/06/28', 7500.00, 15000.00, '2016/09/29', 13750.00, 1033, 570);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES ( 	
	171, '2016/08/23', 35000.00, 60000.00, '2016/09/29', 55000.00, 1000, 571);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES ( 	
	175, '2016/09/29', 40000.00, 75000.00, '2016/12/18', 72500.00, 1036, 500);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, WorkID)
 	VALUES ( 	
	181, '2016/10/11', 250.00, 500.00, 578);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES ( 	
	201, '2017/02/28', 2000.00, 3500.00, '2017/04/26', 3250.00,	1040, 580);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES ( 	
	202, '2017/02/28', 2000.00, 3500.00, '2017/04/26', 3250.00, 1040, 581);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES ( 
	225, '2017/06/08', 125.00, 250.00, '2017/09/27', 225.00, 1051, 585);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, WorkID)
 	VALUES ( 	
	226, '2017/06/08', 200.00, 400.00, 586);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES ( 	
	227, '2017/06/08', 250.00, 500.00, '2017/09/27', 475.00, 1051, 587);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, WorkID)
 	VALUES ( 	
	228, '2017/06/08', 250.00, 500.00, 588);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, WorkID)
 	VALUES ( 	
	229, '2017/06/08', 250.00, 500.00, 589);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, DateSold, SalesPrice, CustomerID, WorkID)
 	VALUES ( 	
	241, '2017/08/29', 2500.00, 5000.00, '2017/09/27', 4750.00,	1015, 590);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, WorkID)
 	VALUES ( 	
	251, '2017/10/25', 25000.00, 50000.00, 593);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, WorkID)
 	VALUES ( 	
	252, '2017/10/27', 250.00, 500.00, 594);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, WorkID)
 	VALUES ( 	
	253, '2017/10/27', 250.00, 500.00, 595);
INSERT INTO TRANS (TransactionID, DateAcquired, AcquisitionPrice,
	AskingPrice, WorkID)
 	VALUES ( 	
	254, '2017/10/27', 250.00, 500.00, 596);


/********************************************************************************/