DROP TABLE `IMPORT_ARTIST`;

CREATE TABLE `IMPORT_ARTIST` (
  `id` mediumint(8) unsigned NOT NULL auto_increment,
  `LastName` varchar(255) default NULL,
  `FirstName` varchar(255) default NULL,
  `Nationality` varchar(100) default NULL,
  `DateOfBirth` varchar(255),
  `DateDeceased` varchar(255),
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

INSERT INTO `IMPORT_ARTIST` (`LastName`,`FirstName`,`Nationality`,`DateOfBirth`,`DateDeceased`) VALUES ("Parrish","Todd","Northern Mariana Islands","Jan 28, 1977","Dec 1, 1988"),("Rivas","Tiger","Uganda","Nov 18, 1973","Mar 29, 2004"),("Bradford","Ivory","Luxembourg","Jun 17, 1969","Sep 13, 1999"),("Gould","Theodore","Thailand","Nov 28, 1942","Mar 6, 2018"),("Bowman","Claire","Egypt","Jun 22, 1943","Jun 21, 1979"),("Mcpherson","Montana","Reunion","Oct 23, 1969","Apr 28, 2007"),("Sweeney","Nomlanga","Seychelles","Jun 16, 1948","Feb 10, 2021"),("Lopez","Rina","Saint Helena, Ascension and Tristan da Cunha","Jan 10, 1935","Mar 9, 2011"),("Crane","Carly","Latvia","Apr 10, 1949","Apr 11, 2009"),("Farley","Charles","Czech Republic","Jul 26, 1978","Mar 17, 1979");
INSERT INTO `IMPORT_ARTIST` (`LastName`,`FirstName`,`Nationality`,`DateOfBirth`,`DateDeceased`) VALUES ("Dyer","Laurel","Solomon Islands","May 7, 1969","Aug 28, 1998"),("Gibson","Stephen","Australia","Mar 18, 1940","Nov 10, 2017"),("Faulkner","Travis","Austria","May 21, 1973","Aug 18, 1981"),("Avila","Nelle","Svalbard and Jan Mayen Islands","Feb 6, 1950","Feb 19, 1992"),("Ballard","Breanna","Nepal","Jan 31, 1941","Feb 20, 2010"),("Norman","Bryar","Bhutan","May 22, 1971","Feb 3, 2017"),("Maldonado","Idona","Pakistan","Mar 21, 1982","Dec 24, 1983"),("Rogers","Blythe","Paraguay","May 7, 1949","Jun 20, 2001"),("Gomez","Russell","Austria","Feb 28, 1969","May 24, 2009"),("Ashley","Ryan","Niue","Dec 15, 1985","Feb 6, 1996");
INSERT INTO `IMPORT_ARTIST` (`LastName`,`FirstName`,`Nationality`,`DateOfBirth`,`DateDeceased`) VALUES ("Chapman","Joy","Albania","Jan 5, 1962","Mar 7, 1985"),("Bishop","Darrel","Marshall Islands","Jul 18, 1962","Apr 17, 1992"),("Coleman","Britanni","New Zealand","Dec 18, 1997","Jun 28, 2006"),("Benson","Mason","Belize","Aug 7, 1988","Oct 19, 1986"),("Hurley","Irma","Guinea","Jan 11, 1988","Apr 17, 1998"),("Mckee","Clementine","Uganda","Mar 29, 1993","Jun 1, 1987"),("Watkins","Lewis","Niger","Nov 12, 1971","Dec 17, 1996"),("Lindsey","Ifeoma","Virgin Islands, United States","Feb 21, 1959","Feb 1, 2017"),("Miller","Jack","Maldives","Nov 22, 1991","May 5, 2022"),("Cervantes","Joshua","Bulgaria","Sep 29, 1994","Jan 1, 1996");
INSERT INTO `IMPORT_ARTIST` (`LastName`,`FirstName`,`Nationality`,`DateOfBirth`,`DateDeceased`) VALUES ("Miller","Alea","Cameroon","Oct 8, 1936","Dec 19, 1993"),("Erickson","Colton","Sweden","Apr 3, 1959","Jul 29, 2000"),("Dennis","Kamal","Maldives","Sep 8, 1978","Aug 21, 2000"),("Gallagher","Ignacia","United Kingdom (Great Britain)","Jul 3, 1936","May 18, 1983"),("Duran","Devin","Mexico","Oct 25, 1989","Aug 11, 2022"),("Pittman","Axel","Croatia","Aug 17, 1961","Aug 2, 1982"),("Kane","Calvin","Palestine, State of","May 13, 1984","May 19, 1993"),("Garcia","Kerry","Gambia","Apr 24, 1992","Oct 15, 2022"),("York","Rogan","Bahamas","Sep 16, 1996","Oct 26, 2011"),("Mckay","Lars","Singapore","Dec 30, 1984","Nov 20, 1989");
INSERT INTO `IMPORT_ARTIST` (`LastName`,`FirstName`,`Nationality`,`DateOfBirth`,`DateDeceased`) VALUES ("Tate","Elmo","Georgia","Jun 12, 1933","Dec 7, 1985"),("Wise","Charlotte","Guam","Jan 19, 2000","Jan 26, 1991"),("Bean","Levi","Tokelau","Apr 29, 1996","Jan 28, 2021"),("Humphrey","Hanae","Burundi","Nov 11, 1979","May 11, 2020"),("Stanley","Howard","Bosnia and Herzegovina","Dec 29, 1976","Mar 19, 2008"),("Terrell","Steel","Greenland","Jan 31, 1972","Jun 19, 2017"),("Downs","Janna","Croatia","Feb 29, 1948","Oct 4, 1982"),("Merrill","May","Papua New Guinea","Jul 17, 1945","Oct 27, 1979"),("Diaz","Timon","French Guiana","Nov 2, 1960","Jun 19, 2020"),("Ortega","Troy","South Africa","May 23, 1990","Oct 21, 2017");
INSERT INTO `IMPORT_ARTIST` (`LastName`,`FirstName`,`Nationality`,`DateOfBirth`,`DateDeceased`) VALUES ("Sweet","Gage","Eritrea","Aug 19, 1987","Dec 1, 1992"),("Lane","Hilary","Viet Nam","Aug 31, 1938","Oct 19, 2002"),("Monroe","Herman","Kazakhstan","Oct 16, 1999","Apr 22, 2015"),("Bennett","Rose","Chile","Sep 8, 1975","Dec 17, 2001"),("Pratt","Karina","Iceland","Sep 7, 1984","Jul 9, 2009"),("Love","Jillian","Russian Federation","Nov 13, 1972","Mar 23, 2021"),("Quinn","Charissa","Togo","Mar 14, 1980","Apr 1, 2016"),("Waller","Barbara","Germany","Apr 16, 1979","Sep 28, 1983"),("Kent","Fitzgerald","Mauritania","May 21, 1994","Jul 18, 2021"),("Vaughan","Portia","Turks and Caicos Islands","Jun 29, 1970","Oct 23, 2007");
INSERT INTO `IMPORT_ARTIST` (`LastName`,`FirstName`,`Nationality`,`DateOfBirth`,`DateDeceased`) VALUES ("Vance","Chiquita","Tonga","Feb 3, 1972","Sep 23, 1988"),("Oneal","Aphrodite","French Southern Territories","Jul 17, 1959","May 13, 2009"),("Murphy","Donovan","Liberia","Sep 16, 1965","Mar 26, 1983"),("Patrick","Illana","Lebanon","Jul 9, 1942","May 21, 1991"),("Gentry","Petra","Tanzania","Mar 19, 1936","Sep 14, 1994"),("Estrada","Wesley","Netherlands","Sep 12, 1944","Mar 18, 1984"),("Washington","Duncan","Guinea-Bissau","Sep 1, 1988","Jul 5, 1982"),("Molina","Asher","Belgium","Dec 3, 1959","Feb 16, 2011"),("Holder","Keiko","Jersey","May 11, 1966","Nov 2, 1989"),("Miranda","Judith","Romania","Mar 12, 1986","Jan 28, 2007");
INSERT INTO `IMPORT_ARTIST` (`LastName`,`FirstName`,`Nationality`,`DateOfBirth`,`DateDeceased`) VALUES ("Finch","Brody","American Samoa","Oct 8, 1971","Sep 12, 2006"),("Collins","Alfreda","Guatemala","Aug 25, 1994","Oct 30, 2008"),("Knight","Leslie","Cocos (Keeling) Islands","Nov 13, 1936","Oct 28, 1997"),("Pitts","Brendan","Falkland Islands","Apr 30, 1990","Mar 15, 2013"),("Church","Riley","Georgia","Oct 25, 1961","Jul 19, 2007"),("Ross","Garrison","Estonia","Dec 29, 1936","Apr 8, 1991"),("Horton","Zelenia","Hong Kong","Feb 5, 1940","Oct 7, 1998"),("Malone","Hector","British Indian Ocean Territory","Jan 29, 1954","Jan 11, 1989"),("Wilcox","Riley","Montserrat","May 6, 1984","Oct 3, 1985"),("Griffith","Regina","Saudi Arabia","Dec 22, 1936","Jul 6, 1981");
INSERT INTO `IMPORT_ARTIST` (`LastName`,`FirstName`,`Nationality`,`DateOfBirth`,`DateDeceased`) VALUES ("Knowles","Tanek","Turkey","Oct 15, 1983","Apr 6, 2017"),("Glenn","Kaden","Virgin Islands, British","Jan 18, 1985","Aug 26, 1991"),("Tran","Brielle","Sierra Leone","Mar 19, 1993","Jan 5, 2022"),("Odonnell","Gareth","Saint Vincent and The Grenadines","Mar 5, 1980","Jun 22, 2011"),("Castaneda","Chandler","Canada","Oct 29, 1959","Sep 27, 2011"),("Barrett","Linda","Kuwait","Sep 12, 1977","May 3, 2005"),("Jenkins","Sydnee","Svalbard and Jan Mayen Islands","Apr 15, 1943","Oct 15, 1983"),("Riley","Ella","Montserrat","Oct 11, 1953","Sep 28, 2007"),("Sawyer","Hector","Botswana","Jul 8, 1964","Sep 12, 2003"),("Medina","Winifred","Bouvet Island","Jan 24, 1980","May 6, 1999");
INSERT INTO `IMPORT_ARTIST` (`LastName`,`FirstName`,`Nationality`,`DateOfBirth`,`DateDeceased`) VALUES ("Lynch","Fletcher","Botswana","Jul 18, 1980","Mar 13, 1983"),("Molina","Guy","Timor-Leste","May 21, 1970","Feb 11, 1992"),("Cooke","Walker","Georgia","Jul 28, 1994","Oct 1, 1982"),("Moreno","Colt","Malawi","Jul 27, 1950","Nov 28, 2011"),("Conner","Nyssa","Ecuador","Apr 6, 1993","Apr 28, 1984"),("Hall","Stacey","Malta","Apr 15, 1986","Nov 3, 1987"),("Powers","David","Latvia","Jun 16, 1938","Oct 23, 2004"),("Mccarthy","Molly","Guinea-Bissau","Jun 28, 1980","Nov 10, 1978"),("Patel","Blaine","Madagascar","Sep 12, 1951","Apr 8, 1987"),("Peters","Deanna","United States Minor Outlying Islands","Apr 26, 1980","Mar 1, 2008");
