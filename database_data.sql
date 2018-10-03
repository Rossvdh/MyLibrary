-- back up of all tables, data, and stored procs and functions in Library database
-- done on 31 December 2017
-- Ross van der Heyde

-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	5.7.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `allbooks`
--

DROP TABLE IF EXISTS `allbooks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `allbooks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `price` double DEFAULT NULL,
  `placebought` int(11) DEFAULT NULL,
  `mnth` int(11) DEFAULT NULL,
  `yr` int(11) DEFAULT NULL,
  `firstpub` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allbooks`
--

LOCK TABLES `allbooks` WRITE;
/*!40000 ALTER TABLE `allbooks` DISABLE KEYS */;
INSERT INTO `allbooks` VALUES (1,'The Dragon Reborn',12,4,8,2013,1991),(2,'The Golem\'s Eye',50,1,6,2013,2004),(3,'Thieves\' World',0,2,7,2013,1979),(4,'The Eye of the World',44,2,7,2013,1990),(5,'Gardens of the Moon',59.5,3,6,2013,1999),(6,'12.21',0,5,0,0,2012),(7,'Fool Moon',98,11,9,2012,2001),(8,'Summer Knight',135,6,4,2013,2002),(9,'The Adventures of Sherlock Holmes',12,4,8,2013,1892),(10,'Grave Peril',135,6,9,2012,2001),(11,'Polgara the Sorceress',12,4,8,2013,1997),(12,'Inheritance',241,6,11,2011,2011),(13,'Eragon',12,4,8,2013,2002),(14,'Eldest',12,4,8,2013,2005),(15,'Brisingr',0,13,0,2008,2008),(17,'Warbreaker',113,11,9,2012,2009),(18,'Elantris',0,5,8,2012,2005),(19,'A Dance With Dragons',305,5,8,2012,2011),(20,'The Tales of Beedle the Bard',99,13,0,2008,2008),(21,'Harry Potter and the Order of the Phoenix',30,13,0,0,2003),(22,'Harry Potter and the Goblet of Fire',50,1,0,2007,2000),(23,'Harry Potter and the Prisoner of Azkaban',0,14,0,2008,1999),(24,'Charlie Bone and the Hidden King',77,7,0,2006,2006),(25,'Airman',0,8,0,2008,2007),(26,'The Time Paradox',0,13,0,2008,2008),(27,'The Lost Colony',0,13,0,2007,2006),(28,'The Eternity Code',67,7,0,2006,2003),(29,'Artemis Fowl',0,13,0,2007,2001),(30,'The Warlock',0,6,10,2011,2011),(31,'The Necromancer',0,7,12,2010,2009),(32,'The Sorceress',0,7,0,2010,2009),(33,'The Son of Neptune',0,6,11,2011,2011),(34,'The Mark of Athena',144,6,11,2012,2012),(35,'The Lost Hero',0,6,4,2011,2010),(36,'The Titan\'s Curse',0,13,0,0,2007),(37,'The Last Olympian',0,13,0,0,2009),(38,'The Hobbit',0,13,1,2009,1937),(39,'Digital Fortress',0,1,1,2011,1995),(40,'The Lost Symbol',0,6,4,2011,2009),(41,'Morningstar',0,6,1,2012,1992),(42,'Midnight Falcon',60,1,12,2012,1999),(43,'The Legend of Deathwalker',12,4,8,2013,1996),(44,'Waylander II: In the Realm of the Wolf',0,5,12,2011,1992),(45,'Sword in the Storm',49.5,3,12,2012,1998),(46,'The First Chronicles of Druss the Legend',0,6,3,2012,1993),(47,'Legend',0,1,7,2011,1984),(48,'Oblivion',0,8,1,2013,2012),(49,'Nightrise',0,15,0,2007,2007),(50,'Raven\'s Gate',50,1,0,0,2005),(51,'Crocodile Tears',0,6,3,2011,2009),(52,'Snakehead',0,6,12,2007,2007),(53,'Eagle Strike',0,8,0,2006,2003),(54,'The Ring of Solomon',0,5,12,2010,2010),(55,'The Amulet of Samarkand',50,1,6,2013,2003),(56,'The Hero of Ages',78,11,7,2012,2008),(57,'The Well of Ascension',144,7,4,2012,2007),(58,'The Fellowship of the Ring',12,4,8,2013,1954),(59,'Dragon Rider',0,7,8,2005,2004),(60,'The Wonderful Story of Henry Sugar and Six More',0,7,8,2005,1977),(61,'Spud- the Madness Continues',0,6,0,2007,2007),(62,'The Infinity Code',75,13,1,2007,2007),(63,'The Ghostmaster',80,13,9,2007,2007),(64,'The Time Machine (adaptation)',0,5,0,0,2003),(66,'Dracula: the Undead',60,2,7,2011,2009),(69,'Grimpow: the Invisible Road',0,7,0,2008,2007),(70,'The Adventures of Pip',0,5,0,2004,1948),(71,'A Taste of the Unexpected',0,5,0,0,2005),(72,'The Atlantis Complex',0,7,12,2010,2010),(73,'The Opal Decpetion',67,7,0,2006,2005),(74,'The Tower Treasure',0,13,0,2006,1927),(75,'The Skyfire Puzzle',0,13,0,2006,1985),(76,'The Submarine Caper',0,13,0,2006,1981),(77,'Revenge of the Desert Phantom',0,13,0,2006,1985),(78,'The Clue of the Broken Blade',0,13,0,2006,1942),(79,'The Twisted Claw',0,13,0,2006,1939),(80,'The Outlaw\'s Silver',0,13,0,2006,1981),(81,'The Secret of Skull Mountain',0,13,0,2006,1948),(82,'The Flickering Torch Mystery',0,13,0,2006,1942),(83,'The Rivan Codex',12,4,8,2013,1998),(84,'The Belgariad: Volume One',50,1,12,2012,1995),(85,'Asterix the Champion',0,13,0,0,1984),(86,'The Inventors',0,13,0,2008,2007),(89,'Alex Rider: the Gadgets',0,8,0,2006,2005),(90,'Ms. Raboto',0,13,0,0,2010),(91,'Lost Souls',0,6,3,2012,2010),(92,'The Wilderness Wolf',0,13,0,2007,2007),(93,'The Castle of Mirrors',77,5,0,2006,2005),(97,'Three of Diamonds',35,13,0,2007,2005),(98,'Framed!',0,12,0,0,2005),(99,'Lost Bullet',0,12,0,0,2005),(100,'Harry Potter and the Deathly Hallows',249,10,8,2007,2007),(101,'Queste',0,5,8,2008,2008),(102,'The Alchemyst',0,7,12,2007,2007),(103,'The Enchantress',142,11,7,2012,2012),(104,'The Return of the King',12,4,8,2013,1955),(105,'The Wake',80,1,6,2013,1997),(106,'The Castafiore Emerald',0,5,12,2004,1963),(107,'Asterix and the Black Gold',0,13,0,0,1982),(108,'Obelix & Co.',0,13,0,0,1978),(109,'Asterix and the Normans',0,13,0,0,1978),(110,'Asterix and the Chieftain\'s Shield',0,13,0,0,1977),(111,'Asterix and the Roman Agent',0,13,0,0,1972),(112,'Asterix in Spain',0,13,0,0,1971),(113,'Asterix the Gaul',0,13,0,0,1969),(114,'Ptolemys Gate',0,9,0,2008,2005),(115,'Tales From the Perilous Realm',149,6,9,2013,1997),(116,'The Dragon Book of Verse',0,13,1,2009,1977),(117,'The Tolkien Quiz Book',44,2,11,2013,2003),(118,'Belgarath the Sorcerer',44,2,11,2013,1995),(119,'Death Masks',110,11,11,2013,2003),(120,'The House of Hades',94,11,11,2013,2013),(121,'Royal Assassin',48,2,11,2013,1996),(122,'The Path of Daggers',79,3,11,2013,1998),(123,'Winter\'s Heart',12,4,8,2013,2000),(124,'Fantastic Beasts and where to Find Them',30,1,12,2013,2001),(125,'Assassin\'s Quest',60,1,12,2013,1997),(126,'The Screaming Staircase',0,5,12,2013,2013),(127,'Russian Roulette',185,5,12,2013,2013),(128,'Words of Radiance',398,6,6,2014,2014),(129,'The Silmarillion',44,2,6,2014,1977),(130,'Harry Potter and the Half-Blood Prince',50,1,6,2014,2005),(131,'The Two Towers',30,15,6,2014,1954),(132,'The Lies of Locke Lamora',74,1,6,2014,2006),(133,'Dangerous Women',0,5,8,2014,2013),(134,'Wizard and Glass',52,2,12,2014,1997),(135,'The Dark Tower',0,5,1,2015,2004),(136,'The Way of Shadows',46,2,1,2015,2008),(137,'The Mammoth Book of Socerers Tales',60,1,1,2015,2004),(138,'The Return of Sherlock Holmes',40,1,1,2015,1905),(139,'The Rithmatist',165,17,6,2015,2013),(140,'Steelheart',200,17,6,2015,2013),(141,'The Golem and the Djinni',80,1,6,2015,2013),(142,'Harry Potter and the Chamber of Secrets',50,1,6,2015,1998),(143,'Deadhouse Gates',216,17,12,2015,2000),(144,'His Last Bow',20,15,10,2015,1917),(145,'the Hound of the Baskervilles',20,15,9,2015,1902),(146,'A Study in Scarlet',20,15,9,2015,1887),(148,'Renaissance',0,5,8,2015,2009),(149,'Blood Rites',200,17,11,2015,2004),(150,'Fantastic Voyage',0,13,0,0,1966),(151,'The Drawing of the Three',34,1,12,2015,1987),(152,'The Gunslinger',25,15,8,2015,1982),(153,'Trigger Warning',308,6,8,2015,2015),(154,'Song of Susannah',52,2,12,2015,2004),(155,'The Wind throught the Keyhole',60,15,11,2015,2012),(156,'Animal Farm',0,13,1,2013,1945),(157,'The Blood of Olympus',0,6,11,2014,2014),(158,'Death',0,5,12,2015,2014),(159,'The Eyes of The Dragon',36,2,12,2015,1988),(161,'Harry Potter and the Philosopher Stone Illustrated Edition',640,5,8,2016,2015),(162,'Harry Potter and the Cursed Child',299,7,8,2016,2016),(163,'Memories of Ice',74,1,12,2015,2001),(165,'Harry Potter and the Chamber of Secrets Illustrated Edition',559,5,12,2016,2016),(166,'The Blade Itself',120,1,2,2017,2006),(181,'Dancer\'s Lament',236,6,2,2017,2016),(182,'The Final Empire',78,6,3,2012,2006),(183,'Night of Knives',60,3,2,2017,2005),(184,'Ship of Magic',60,1,2,2017,1998),(185,'The Best of Cricket',20,1,2,2017,1982),(188,'The Ultimate History of Porsche',199,15,0,2008,2004),(190,'Arcanum Unbounded',302,8,4,2017,2016),(191,'Never Say Die',200,6,7,2017,2017),(192,'The Last Wish',200,5,8,2017,2007),(193,'Dragons and Fabulous Beasts',15,18,11,2017,1995),(194,'Harry Potter and the Philosopher\'s Stone',30,18,11,2017,1997),(195,'Toll the Hounds',70,1,11,2017,2008),(196,'Jonathan Strange and Mr Norrel',30,18,11,2017,2004),(197,'The Extraornidary Book of South African Cricket',25,18,11,2017,2010),(198,'Lord of the Silver Bow',80,1,12,2017,2005),(199,'Harry Potter and the Prisner of Azkaban Illustrated Edition',0,4,12,2017,2017);
/*!40000 ALTER TABLE `allbooks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Robert Jordan'),(2,'Jonathan Stroud'),(3,'Robert Lynn Asprin'),(4,'Steven Erikson'),(5,'Dustin Thomason'),(6,'Jim Butcher'),(7,'Arthur Conan Doyle'),(8,'David Eddings'),(9,'Christopher Paolini'),(10,'Brandon Sanderson'),(11,'George R.R. Martin'),(12,'J.K. Rowling'),(13,'Jenny Nimmo'),(14,'Eoin Colfer'),(15,'Michael Scott'),(16,'Rick Riordan'),(17,'J.R.R. Tolkien'),(18,'Dan Brown'),(19,'David Gemmell'),(20,'Anthony Horowitz'),(21,'Cornelia Funke'),(22,'Roald Dahl'),(23,'John van de Ruit'),(24,'E.L. Young'),(25,'H.G. Wells'),(27,'Dacre Stoker'),(28,'Rafael Abalos'),(29,'Enid Blyton'),(30,'Franklin W. Dixon'),(31,'R. Goscinny'),(32,'A. Uderzo'),(33,'Alexander Gordon Smith'),(34,'Jamie Webb'),(36,'Kyle Khan'),(37,'Dean Koontz'),(40,'Malcolm Rose'),(42,'Angie Sage'),(43,'Neil Gaiman'),(44,'Herge'),(45,'Various'),(46,'Andrew Murray'),(47,'Robin Hobb'),(48,'Scott Lynch'),(49,'Gardner Dozios'),(50,'Stephen King'),(51,'Brent Weeks'),(52,'Mike Ashley'),(53,'Helene Wecker'),(54,'Oliver Bowden'),(55,'Isaac Asimov'),(56,'George Orwell'),(57,'Jim Kay'),(58,'Carrie Vaughn'),(59,'Joe R. Lansdale'),(60,'Megan Lindholm'),(61,'Lawrence Block'),(62,'Sharon Kay Penman'),(63,'Lev Grossman'),(64,'Nancy Kress'),(65,'Diana Rowland'),(66,'Diana Gabaldon'),(67,'S.M. Stirling'),(68,'Sam Sykes'),(69,'Pat Cadigan'),(70,'Caroline Spector'),(71,'Joe Abercrombie'),(72,'Megan Abbott'),(73,'Cecelia Holland'),(74,'Sherrilyn Kenyon'),(75,'Melinda M. Snodgrass'),(77,'Steve Rasnic Tem'),(78,'Michael Moorcock'),(79,'Robert E. Weinberg'),(80,'Darrell Schweitzer'),(81,'Ralph Adams Cram'),(82,'Ursula K. Le Guin'),(83,'Arthur Christopher Benson '),(84,'Mike Resnick'),(85,'Esther M. Friesner'),(86,'Tim Lebbon'),(87,'David Sandner'),(88,'Richard A. Lupoff'),(89,'Marion Zimmer Bradley'),(90,'James Bibby'),(91,'Louise Cooper'),(92,'Peter Crowther'),(93,'Doug Hornig'),(94,'Tom Holt'),(95,'Timm Pratt'),(96,'Diana Wynne Jones'),(97,'John Morressy'),(98,'Clark Ashton Smith'),(99,'Michael Kurland'),(100,'ross'),(101,'Charles Vess'),(102,'Michael Harrison'),(103,'Christopher Stuart-Clark'),(104,'Alan Lee'),(105,'Noel Baca Castex'),(106,'Anthea Bell'),(107,'Todd Klein'),(108,'Steve Oliff'),(109,'Matt Hollingsworth'),(110,'Daniel Vozzo'),(111,'Lovern Kindzierski'),(112,'Jon J Muth'),(113,'Alex Bleyaert'),(114,'Rob Ro'),(115,'Chris Bachalo'),(116,'Mark Buckingham'),(117,'Michael Dringenberg'),(118,'P. Craig Russell'),(119,'Malcolm Jones III'),(120,'Colleen Doran'),(121,'Dave McKean'),(122,'Mark Pennington'),(123,'Jeffery Jones'),(124,'Michael Zulli'),(125,'Leigh Eddings'),(126,'John Brunner'),(127,'Lynn Abbey'),(128,'Poul Anderson'),(129,'Andrew Offutt'),(130,'Joe Haldeman'),(131,'Christine DeWees'),(133,'John Lawson'),(134,'Emil Fortune'),(135,'John Tiffany'),(136,'Jack Thorne'),(137,'Joe Abercrombie'),(155,'Ian C. Esslemont'),(156,'Roy Peskett'),(157,'Stuart Gallagher'),(158,'Helen Smith'),(159,'Ross'),(160,'Jody'),(161,'Andrzej Sapkowski'),(162,'Danusia Stok'),(163,'Duncan Baird Publishers'),(164,'Susanna Clarke'),(165,'Portia Rosenberg'),(166,'Kevin McCallum'),(167,'David O\'Sullivan');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrowers`
--

DROP TABLE IF EXISTS `borrowers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrowers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(100) DEFAULT NULL,
  `contactNumber` varchar(12) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrowers`
--

LOCK TABLES `borrowers` WRITE;
/*!40000 ALTER TABLE `borrowers` DISABLE KEYS */;
INSERT INTO `borrowers` VALUES (1,'Curtley Daries','0871013686',NULL),(2,'Jody van der Heyde','0219499006','VHYJOD002@myuct.ac.za');
/*!40000 ALTER TABLE `borrowers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deweyone`
--

DROP TABLE IF EXISTS `deweyone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deweyone` (
  `id` int(11) NOT NULL,
  `topicOne` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deweyone`
--

LOCK TABLES `deweyone` WRITE;
/*!40000 ALTER TABLE `deweyone` DISABLE KEYS */;
INSERT INTO `deweyone` VALUES (0,'Generalities, Computer Science & Information'),(100,'Philosophy & psychology'),(200,'Religion'),(300,'Social sciences'),(400,'Language'),(500,'Natural sciences & mathematics'),(600,'Technology (Applied sciences)'),(700,'The arts'),(800,'Literature & rhetoric'),(900,'Geography & history');
/*!40000 ALTER TABLE `deweyone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deweythree`
--

DROP TABLE IF EXISTS `deweythree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deweythree` (
  `id` int(11) NOT NULL,
  `topicThree` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deweythree`
--

LOCK TABLES `deweythree` WRITE;
/*!40000 ALTER TABLE `deweythree` DISABLE KEYS */;
INSERT INTO `deweythree` VALUES (1,'Knowledge'),(2,'The book'),(3,'Systems'),(4,'Data processing Computer science'),(5,'Computer programming, programs, data'),(6,'Special computer methods'),(7,'Unused'),(8,'Unused'),(9,'Unused'),(11,'Bibliographies'),(12,'of individuals'),(13,'of works by specific classes of authors'),(14,'of anonymous and pseudonymous works'),(15,'of works from specific places'),(16,'of works from specific subject'),(17,'General subject catalogs'),(18,'Catalogs arranged by author & date'),(19,'Dictionary catalogs'),(21,'Library relationships'),(22,'Administration of the physical plant'),(23,'Personnel administration'),(24,'Unused'),(25,'Library operations'),(26,'Libraries for specific subjects'),(27,'General libraries'),(28,'Reading, use of other information media'),(29,'Unused'),(31,'American'),(32,'in English'),(33,'in other Germanic languages'),(34,'in French, Provencal, Catalan'),(35,'in Italian, Romanian, Rhaeto-Romanic'),(36,'in Spanish & Portuguese'),(37,'in Slavic languages'),(38,'in Scandinavian languages'),(39,'in other languages'),(41,'Unused'),(42,'Unused'),(43,'Unused'),(44,'Unused'),(45,'Unused'),(46,'Unused'),(47,'Unused'),(48,'Unused'),(49,'Unused'),(51,'American'),(52,'In English'),(53,'In other Germanic languages'),(54,'In French, Provencal, Catalan'),(55,'In Italian, Romanian, Rhaeto-Romanic'),(56,'In Spanish & Portuguese'),(57,'In Slavic languages'),(58,'In Scandinavian languages'),(59,'In other languages'),(61,'In North America'),(62,'In British Isles In England'),(63,'In central Europe In Germany'),(64,'In France & Monaco'),(65,'In Italy & adjacent territories'),(66,'In Iberian Peninsula & adjacent islands'),(67,'In eastern Europe In Soviet Union'),(68,'In other areas'),(69,'Museology (Museum science)'),(71,'In North America'),(72,'In British Isles In England'),(73,'In central Europe In Germany'),(74,'In France & Monaco'),(75,'In Italy & adjacent territories'),(76,'In Iberian Peninsula & adjacent islands'),(77,'In eastern Europe In Soviet Union'),(78,'In Scandinavia'),(79,'In other languages'),(81,'American'),(82,'In English'),(83,'In other Germanic languages'),(84,'In French, Provencal, Catalan'),(85,'In Italian, Romanian, Rhaeto-Romanic'),(86,'In Spanish & Portuguese'),(87,'In Slavic languages'),(88,'In Scandinavian languages'),(89,'In other languages'),(91,'Manuscripts'),(92,'Block books'),(93,'Incunabula'),(94,'Printed books'),(95,'Books notable for bindings'),(96,'Books notable for illustrations'),(97,'Books notable for ownership or origin'),(98,'Prohibited works, forgeries, hoaxes'),(99,'Books notable for format'),(101,'Theory of philosophy'),(102,'Miscellany of philosophy'),(103,'Dictionaries of philosophy'),(104,'Unused'),(105,'Serial publications of philosophy'),(106,'Organizations of philosophy'),(107,'Education, research in philosophy'),(108,'Kinds of persons in philosophy'),(109,'Historical treatment of philosophy'),(111,'Ontology'),(112,'Unused'),(113,'Cosmology (Philosophy of nature)'),(114,'Space'),(115,'Time'),(116,'Change'),(117,'Structure'),(118,'Force & Energy'),(119,'Number & quantity'),(121,'Epistemology (Theory of knowledge)'),(122,'Causation'),(123,'Determinism & indeterminism'),(124,'Teleology'),(125,'Unused'),(126,'The self'),(127,'The unconscious & the subconscious'),(128,'Humankind'),(129,'Origin & destiny of individual souls'),(131,'Occult methods for achieving well-being'),(132,'Unused'),(133,'Parapsychology & occultism'),(134,'Unused'),(135,'Dreams & mysteries'),(136,'Unused'),(137,'Divinatory graphology'),(138,'Physiognomy'),(139,'Phrenology'),(141,'Idealism & related systems'),(142,'Critical philosophy'),(143,'Intuitionism & Bergsonism'),(144,'Humanism & related systems'),(145,'Sensationalism'),(146,'Naturalism & related systems'),(147,'Pantheism & related systems'),(148,'Liberalism, eclecticism, traditionalism'),(149,'Other philosophical systems'),(151,'Unused'),(152,'Perception, movement, emotions, drives'),(153,'Mental processes & intelligence'),(154,'Subconscious & altered states'),(155,'Differential & developmental psychology'),(156,'Comparative psychology'),(157,'Unused'),(158,'Applied psychology'),(159,'Unused'),(161,'Induction'),(162,'Deduction'),(163,'Unused'),(164,'Unused'),(165,'Fallacies & sources of error'),(166,'Syllogisms'),(167,'Hypotheses'),(168,'Argument & persuasion'),(169,'Analogy'),(171,'Systems & doctrines'),(172,'Political ethics'),(173,'Ethics of family relationships'),(174,'Economic & professional ethics'),(175,'Ethics of recreation & leisure'),(176,'Ethics of sex & reproduction'),(177,'Ethics of social relations'),(178,'Ethics of consumption'),(179,'Other ethical norms'),(181,'Oriental philosophy'),(182,'Pre-Socratic Greek philosophies'),(183,'Sophistic & Socratic philosophies'),(184,'Platonic philosophy'),(185,'Aristotelian philosophy'),(186,'Skeptic and Neoplatonic philosophies'),(187,'Epicurean philosophy'),(188,'Stoic philosophy'),(189,'Medieval Western philosophy'),(191,'United States & Canada'),(192,'British Isles'),(193,'Germany & Austria'),(194,'France'),(195,'Italy'),(196,'Spain & Portugal'),(197,'Soviet Union'),(198,'Scandinavia'),(199,'Other geographical areas'),(201,'Philosophy of Christianity'),(202,'Miscellany of Christianity'),(203,'Dictionaries of Christianity'),(204,'Special topics'),(205,'Serial publications of Christianity'),(206,'Organizations of Christianity'),(207,'Education, research in Christianity'),(208,'Kinds of persons in Christianity'),(209,'History & geography of Christianity'),(211,'Concepts of God'),(212,'Existence, attributes of God'),(213,'Creation'),(214,'Theodicy'),(215,'Science & religion'),(216,'Good & evil'),(217,'Unused'),(218,'Humankind'),(219,'Unused'),(221,'Old Testament'),(222,'Historical books of Old Testament'),(223,'Poetic books of Old Testament'),(224,'Prophetic books of Old Testament'),(225,'New Testament'),(226,'Gospels & Acts'),(227,'Epistles'),(228,'Revelation (Apocalypse)'),(229,'Apocrypha & pseudepigrapha'),(231,'God'),(232,'Jesus Christ & his family'),(233,'Humankind'),(234,'Salvation (Soteriology) & grace'),(235,'Spiritual beings'),(236,'Eschatology'),(237,'Unused'),(238,'Creeds & catechisms'),(239,'Apologetics & polemics'),(241,'Moral theology'),(242,'Devotional literature'),(243,'Evangelistic writings for individuals'),(244,'Unused'),(245,'Texts of hymns'),(246,'Use of art in Christianity'),(247,'Church furnishings & articles'),(248,'Christian experience, practice, life'),(249,'Christian observances in family life'),(251,'Preaching (Homiletics)'),(252,'Texts of sermons'),(253,'Pastoral office (Pastoral theology)'),(254,'Parish government & administration'),(255,'Religious congregations & orders'),(256,'Unused'),(257,'Unused'),(258,'Unused'),(259,'Activities of the local church'),(261,'Social theology'),(262,'Ecclesiology'),(263,'Times, places of religious observance'),(264,'Public worship'),(265,'Sacraments, other rites & acts'),(266,'Missions'),(267,'Associations for religious work'),(268,'Religious education'),(269,'Spiritual renewal'),(271,'Religious orders in church history'),(272,'Persecutions in church history'),(273,'Heresies in church history'),(274,'Christian church in Europe'),(275,'Christian church in Asia'),(276,'Christian church in Africa'),(277,'Christian church in North America'),(278,'Christian church in South America'),(279,'Christian church in other areas'),(281,'Early church & Eastern churches'),(282,'Roman Catholic Church'),(283,'Anglican churches'),(284,'Protestants of Continental origin'),(285,'Presbyterian, Reformed, Congregational'),(286,'Baptist, Disciples of Christ, Adventist'),(287,'Methodist & related churches'),(288,'Unused'),(289,'Other denominations & sects'),(291,'Comparative religion'),(292,'Classical (Greek & Roman) religion'),(293,'Germanic religion'),(294,'Religions of Indic origin'),(295,'Zoroastrianism (Mazdaism, Parseeism)'),(296,'Judaism'),(297,'Islam & religions originating in it'),(298,'Unused'),(299,'Other religions'),(301,'Sociology & anthropology'),(302,'Social interaction'),(303,'Social processes'),(304,'Factors affecting social behavior'),(305,'Social groups'),(306,'Culture & institutions'),(307,'Communities'),(308,'Unused'),(309,'Unused'),(311,'Unused'),(312,'Unused'),(313,'Unused'),(314,'Of Europe'),(315,'Of Asia'),(316,'Of Africa'),(317,'Of North America'),(318,'Of South America'),(319,'Of other parts of the world'),(321,'Systems of governments & states'),(322,'Relation of state to organized groups'),(323,'Civil & political rights'),(324,'The political process'),(325,'International migration & colonization'),(326,'Slavery & emancipation'),(327,'International relations'),(328,'The legislative process'),(329,'Unused'),(331,'Labor economics'),(332,'Financial economics'),(333,'Land economics'),(334,'Cooperatives'),(335,'Socialism & related systems'),(336,'Public finance'),(337,'International economics'),(338,'Production'),(339,'Macroeconomics & related topics'),(341,'International law'),(342,'Constitutional & administrative law'),(343,'Military, tax, trade, industrial law'),(344,'Social, labor, welfare, & related law'),(345,'Criminal law'),(346,'Private law'),(347,'Civil procedure & courts'),(348,'Law (Statutes),\n regulations, cases'),(349,'Law of specific jurisdictions & areas'),(351,'Of central governments'),(352,'Of local governments'),(353,'of U.S. federal & state governments'),(354,'Of specific central governments'),(355,'Military science'),(356,'Foot forces & warfare'),(357,'Mounted forces & warfare'),(358,'Other specialized forces & services'),(359,'Sea (Naval) forces & warfare'),(361,'General social problems & services'),(362,'Social welfare problems & services'),(363,'Other social problems & services'),(364,'Criminology'),(365,'Penal & related institutions'),(366,'Association'),(367,'General clubs'),(368,'Insurance'),(369,'Miscellaneous kinds of associations'),(371,'School management; special education'),(372,'Elementary education'),(373,'Secondary education'),(374,'Adult education'),(375,'Curriculums'),(376,'Education of women'),(377,'Schools & religion'),(378,'Higher education'),(379,'Government regulation, control, support'),(381,'Internal commerce (Domestic trade)'),(382,'International commerce (Foreign trade)'),(383,'Postal communication'),(384,'Communications Telecommunication'),(385,'Railroad transportation'),(386,'Inland waterway & ferry transportation'),(387,'Water, air, space transportation'),(388,'Transportation Ground transportation'),(389,'Metrology & standardization'),(391,'Costume & personal appearance'),(392,'Customs of life cycle & domestic life'),(393,'Death customs'),(394,'General customs'),(395,'Etiquette (Manners)'),(396,'Unused'),(397,'Unused'),(398,'Folklore'),(399,'Customs of war & diplomacy'),(401,'Philosophy & theory'),(402,'Miscellany'),(403,'Dictionaries & encyclopedias'),(404,'Special topics'),(405,'Serial publications'),(406,'Organizations & management'),(407,'Education, research, related topics'),(408,'With respect to kinds of persons'),(409,'Geographical & persons treatment'),(411,'Writing systems'),(412,'Etymology'),(413,'Dictionaries'),(414,'Phonology'),(415,'Structural systems (Grammar)'),(416,'Unused'),(417,'Dialectology & historical linguistics'),(418,'Standard usage Applied linguistics'),(419,'Verbal language not spoken or written'),(421,'English writing system & phonology'),(422,'English etymology'),(423,'English dictionaries'),(424,'Unused'),(425,'English grammar'),(426,'Unused'),(427,'English language variations'),(428,'Standard English usage'),(429,'Old English (Anglo-Saxon)'),(431,'German writing system & phonology'),(432,'German etymology'),(433,'German dictionaries'),(434,'Unused'),(435,'German grammar'),(436,'Unused'),(437,'German language variations'),(438,'Standard German usage'),(439,'Other Germanic languages'),(441,'French writing system & phonology'),(442,'French etymology'),(443,'French dictionaries'),(444,'Unused'),(445,'French grammar'),(446,'Unused'),(447,'French language variations'),(448,'Standard French usage'),(449,'Provencal & Catalan'),(451,'Italian writing system & phonology'),(452,'Italian etymology'),(453,'Italian dictionaries'),(454,'Unused'),(455,'Italian grammar'),(456,'Unused'),(457,'Italian language variations'),(458,'Standard Italian usage'),(459,'Romanian & Rhaeto-Romanic'),(461,'Spanish writing system & phonology'),(462,'Spanish etymology'),(463,'Spanish dictionaries'),(464,'Unused'),(465,'Spanish grammar'),(466,'Unused'),(467,'Spanish language variations'),(468,'Standard Spanish usage'),(469,'Portugese'),(471,'Classical Latin writing & phonology'),(472,'Classical Latin etymology & phonology'),(473,'Classical Latin dictionaries'),(474,'Unused'),(475,'Classical Latin grammar'),(476,'Unused'),(477,'Old, Postclassical, Vulgar Latin'),(478,'Classical Latin usage'),(479,'Other Italic languages'),(481,'Classical Greek writing & phonology'),(482,'Classical Greek etymology'),(483,'Classical Greek dictionaries'),(484,'Unused'),(485,'Classical Greek grammar'),(486,'Unused'),(487,'Preclassical & postclassical Greek'),(488,'Classical Greek usage'),(489,'Other Hellenic languages'),(491,'East Indo-European & Celtic languages'),(492,'Afro-Asiatic languages Semitic'),(493,'Non-Semitic Afro-Asiatic languages'),(494,'Ural-Altaic, Paleosiberian, Dravidian'),(495,'Languages of East & Southeast Asia'),(496,'African languages'),(497,'North American native languages'),(498,'South American native languages'),(499,'Miscellaneous languages'),(501,'Philosophy & theory'),(502,'Miscellany'),(503,'Dictionaries & encyclopedias'),(504,'Unused'),(505,'Serial publications'),(506,'Organizations & management'),(507,'Education, research, related topics'),(508,'Natural history'),(509,'Historical, areas, persons treatment'),(511,'General principles'),(512,'Algebra & number theory'),(513,'Arithmetic'),(514,'Topology'),(515,'Analysis'),(516,'Geometry'),(517,'Unused'),(518,'Numerical Analysis'),(519,'Probabilities & applied mathematics'),(521,'Celestial mechanics'),(522,'Techniques, equipment, materials'),(523,'Specific celestial bodies & phenomena'),(524,'Unused'),(525,'Earth (Astronomical geography)'),(526,'Mathematical geography'),(527,'Celestial navigation'),(528,'Ephemerides'),(529,'Chronology'),(531,'Classical mechanics Solid mechanics'),(532,'Fluid mechanics Liquid mechanics'),(533,'Gas mechanics'),(534,'Sound & related vibrations'),(535,'Light & paraphotic phenomena'),(536,'Heat'),(537,'Electricity & electronics'),(538,'Magnetism'),(539,'Modern physics'),(541,'Physical & theoretical chemistry'),(542,'Techniques, equipment, materials'),(543,'Analytical chemistry'),(544,'Qualitative analysis'),(545,'Quantitative analysis'),(546,'Inorganic chemistry'),(547,'Organic chemistry'),(548,'Crystallography'),(549,'Mineralogy'),(551,'Geology, hydrology, meteorology'),(552,'Petrology'),(553,'Economic geology'),(554,'of Europe'),(555,'of Asia'),(556,'of Africa'),(557,'of North America'),(558,'of South America'),(559,'of other area'),(561,'Paleobotany'),(562,'Fossil invertebrates'),(563,'Fossil primitive phyla'),(564,'Fossil Mollusca & Molluscoidea'),(565,'Other fossil invertebrates'),(566,'Fossil Vertebrata (Fossil Craniata)'),(567,'Fossil cold-blooded vertebrates'),(568,'Fossil Aves (Fossil birds)'),(569,'Fossil Mammalia'),(571,'Unused'),(572,'Human races'),(573,'Physical anthropology'),(574,'Biology'),(575,'Evolution & genetics'),(576,'Microbiology'),(577,'General nature of life'),(578,'Microscopy in biology'),(579,'Collection and preservation'),(581,'Botany'),(582,'Spermatophyta (Seed-bearing plants)'),(583,'Dicotyledones'),(584,'Monocotyledones'),(585,'Gymnospermae (Pinophyta)'),(586,'Cryptogamia (Seedless plants)'),(587,'Pteridophyta (Vascular cryptograms)'),(588,'Bryophyta'),(589,'Thallobionta & Prokaryotae'),(591,'Zoology'),(592,'Invertebrates'),(593,'Protozoa, Echinodermata, related phyla'),(594,'Mollusca & Molluscoidea'),(595,'Other invertebrates'),(596,'Vertebrata (Craniata, Vertebrates)'),(597,'Cold-blooded vertebrates Fishes'),(598,'Aves (Birds)'),(599,'Mammalia (Mammals'),(601,'Philosophy & theory'),(602,'Miscellany'),(603,'Dictionaries & encyclopedias'),(604,'Special topics'),(605,'Serial publications'),(606,'Organizations'),(607,'Education, research, related topics'),(608,'Invention & patents'),(609,'Historical, areas, persons treatment'),(611,'Human anatomy, cytology, histology'),(612,'Human physiology'),(613,'Promotion of health'),(614,'Incidence & prevention of disease'),(615,'Pharmacology & theraputics'),(616,'Diseases'),(617,'Surgery & related medical specialities'),(618,'Gynecology & other medical specialities'),(619,'Experimental medicine'),(621,'Applied physics'),(622,'Mining & related operations'),(623,'Military & nautical engineering'),(624,'Civil engineering'),(625,'Engineering of railroads, roads'),(626,'Unused'),(627,'Hydraulic engineering'),(628,'Sanitary & municipal engineering'),(629,'Other branches of engineering'),(631,'Techniques, equipment, materials'),(632,'Plant injuries, diseases, pests'),(633,'Field & plantation crops'),(634,'Orchards, fruits, forestry'),(635,'Garden crops (Horticulture)'),(636,'Animal husbandry'),(637,'Processing dairy & related products'),(638,'Insect culture'),(639,'Hunting, fishing, conservation'),(641,'Food & drink'),(642,'Meals & table service'),(643,'Housing & household equipment'),(644,'Household utilities'),(645,'Household furnishings'),(646,'Sewing, clothing, personal living'),(647,'Management of public households'),(648,'Housekeeping'),(649,'Child rearing & home care of sick'),(651,'Office services'),(652,'Processes of written communication'),(653,'Shorthand'),(654,'Unused'),(655,'Unused'),(656,'Unused'),(657,'Accounting'),(658,'General management'),(659,'Advertising & public relations'),(661,'Industrial chemicals technology'),(662,'Explosives, fuels technology'),(663,'Beverage technology'),(664,'Food technology'),(665,'Industrial oils, fats, waxes, gases'),(666,'Ceramic & allied technologies'),(667,'Cleaning, color, related technologies'),(668,'Technology of other organic products'),(669,'Metallurgy'),(671,'Metalworking & metal products'),(672,'Iron, steel, other iron alloys'),(673,'Nonferrous metals'),(674,'Lumber processing, wood products, cork'),(675,'Leather & fur processing'),(676,'Pulp & paper technology'),(677,'Textiles'),(678,'Elastomers & elastomer products'),(679,'Other products of specific materials'),(681,'Precision instruments & other devices'),(682,'Small forge work (Blacksmithing)'),(683,'Hardware & household appliances'),(684,'Furnishings & home workshops'),(685,'Leather, fur, related products'),(686,'Printing & related activities'),(687,'Clothing'),(688,'Other final products & packaging'),(689,'Unused'),(691,'Building materials'),(692,'Auxiliary construction practices'),(693,'Specific materials & purposes'),(694,'Wood construction Carpentry'),(695,'Roof covering'),(696,'Utilities'),(697,'Heating, ventilating, air-conditioning'),(698,'Detail finishing'),(699,'Unused'),(701,'Philosophy & theory'),(702,'Miscellany'),(703,'Dictionaries & encyclopedias'),(704,'Special topics'),(705,'Serial publications'),(706,'Organizations & management'),(707,'Education, research, related topics'),(708,'Galleries, museums, private collections'),(709,'Historical, areas, persons treatment'),(711,'Area planning (Civic art)'),(712,'Landscape architecture'),(713,'Landscape architecture of trafficways'),(714,'Water features'),(715,'Woody plants'),(716,'Herbaceous plants'),(717,'Structures'),(718,'Landscape design of cemeteries'),(719,'Natural landscapes'),(721,'Architectural structure'),(722,'Architecture to ca. 300'),(723,'Architecture from ca. 300 to 1399'),(724,'Architecture from 1400'),(725,'Public structures'),(726,'Buildings for religious purposes'),(727,'Buildings for education & research'),(728,'Residential & related buildings'),(729,'Design & decoration'),(731,'Processes, forms, subjects of sculpture'),(732,'Sculpture to ca. 500'),(733,'Greek, Etruscan, Roman sculpture'),(734,'Sculpture from ca. 500 to 1399'),(735,'Sculpture from 1400'),(736,'Carving & carvings'),(737,'Numismatics & sigillography'),(738,'Ceramic arts'),(739,'Art metalwork'),(741,'Drawing & drawings'),(742,'Perspective'),(743,'Drawing & drawings by subject'),(744,'Unused'),(745,'Decorative arts'),(746,'Textile arts'),(747,'Interior decoration'),(748,'Glass'),(749,'Furniture & accessories'),(751,'Techniques, equipment, forms'),(752,'Color'),(753,'Symbolism, allegory, mythology, legend'),(754,'Genre paintings'),(755,'Religion & religious symbolism'),(756,'Unused'),(757,'Human figures & their parts'),(758,'Other subjects'),(759,'Historical, areas, persons treatment'),(761,'Relief processes (Block printing)'),(762,'Unused'),(763,'Lithographic (Planographic) processes'),(764,'Chromolithography & serigraphy'),(765,'Metal engraving'),(766,'Mezzotinting & related processes'),(767,'Etching & drypoint'),(768,'Unused'),(769,'Prints'),(771,'Techniques, equipment, materials'),(772,'Metallic salt processes'),(773,'Pigment processes of printing'),(774,'Holography'),(775,'Unused'),(776,'Unused'),(777,'Unused'),(778,'Fields & kinds of photography'),(779,'Photographs'),(781,'General principles & musical forms'),(782,'Vocal music'),(783,'Music for single voices The voice'),(784,'Instruments & Instrumental ensembles'),(785,'Chamber music'),(786,'Keyboard & other instruments'),(787,'Stringed instruments (Chordophones)'),(788,'Wind instruments (Aerophones)'),(789,'Unused'),(791,'Public performances'),(792,'Stage presentations'),(793,'Indoor games & amusements'),(794,'Indoor games of skill'),(795,'Games of chance'),(796,'Athletic & outdoor sports & games'),(797,'Aquatic & air sports'),(798,'Equestrian sports & animal racing'),(799,'Fishing, hunting, shooting'),(801,'Philosophy & theory'),(802,'Miscellany'),(803,'Dictionaries & encyclopedias'),(804,'Unused'),(805,'Serial publications'),(806,'Organizations'),(807,'Education, research, related topics'),(808,'Rhetoric & collections of literature'),(809,'Literary history & criticism'),(811,'Poetry'),(812,'Drama'),(813,'Fiction'),(814,'Essays'),(815,'Speeches'),(816,'Letters'),(817,'Satire & humor'),(818,'Miscellaneous writings'),(819,'Not used'),(821,'poetry'),(822,'drama'),(823,'fiction'),(824,'essays'),(825,'speeches'),(826,'letters'),(827,'satire & humor'),(828,'miscellaneous writings'),(829,'Old English (Anglo-Saxon)'),(831,'Early to 1517'),(832,'Reformation, etc.  1517-1750'),(833,'Classic period,  1750-1830'),(834,'Post classic & modern,  1830-1940'),(835,'Contemporary authors not already established in the UIUC catalog,  1940'),(836,'German dialect literature'),(837,'German-American'),(838,'German miscellaneous writings'),(839,'Other Germanic literatures'),(841,'Old and early French to 1400'),(842,'Transition & renaissance periods, 1400-1600'),(843,'Classical period, 1600-1715'),(844,'18 th Century, 1715-1789'),(845,'Revolution to present, 1789-1940'),(846,'Contemporary authors not already established in the UIUC Catalog, 1940'),(847,'French Canadian'),(848,'Provencal'),(849,'French dialect literature'),(851,'Early period to 1375'),(852,'Classical learning, 1375-1492'),(853,'1492-1585'),(854,'1585-1814'),(855,'1814-1940'),(856,'Works in and'),(857,'Sardinian'),(858,'Romanian (including Wallachian)'),(859,'Rumansh, Rhastian, Rhaeto-Romanic, Moldavian'),(861,'Early to 1400'),(862,'1400-1553'),(863,'Golden age, 1554-1700'),(864,'1700-1800'),(865,'1800-'),(866,'Works in and'),(867,'Catalan'),(868,'Portuguese'),(869,'South'),(871,'Latin Authors'),(872,'Collections of Latin prose or poetry'),(873,'Not Used'),(874,'Not Used'),(875,'Medieval and modern Latin literature, 500 A.D. - date'),(876,'Not Used'),(877,'Not Used'),(878,'Not Used'),(879,'Classical literature-History and criticism'),(881,'Greek Authors'),(882,'Collections of Greek prose or poetry'),(883,'Not Used'),(884,'Not Used'),(885,'Modern Literature in the Ancient Greek Language'),(886,'Not Used'),(887,'Not Used'),(888,'Not Used'),(889,'Literature in Medieval and Modern Greek'),(891,'Iranian, Persian, Celtic, Gaelic, Slavic, Baltic literature'),(892,'Afro-Asiatic Literature'),(893,'Afro-Asiatic Literature'),(894,'Afro-Asiatic Literature'),(895,'Literature in East Asian and African Languages'),(896,'Literature in East Asian and African Languages'),(897,'North and South American Native Languages'),(898,'North and South American Native Languages'),(899,'Other Literatures'),(901,'Philosophy & theory'),(902,'Miscellany'),(903,'Dictionaries & encyclopedias'),(904,'Collected accounts of events'),(905,'Serial publications'),(906,'Organizations & management'),(907,'Education, research, related topics'),(908,'With respect to kinds of persons'),(909,'World history'),(911,'Historical geography'),(912,'Graphic representations of earth'),(913,'Ancient world'),(914,'Europe'),(915,'Asia'),(916,'Africa'),(917,'North America'),(918,'South America'),(919,'Other areas'),(921,'Unused'),(922,'Unused'),(923,'Unused'),(924,'Unused'),(925,'Unused'),(926,'Unused'),(927,'Unused'),(928,'Unused'),(929,'Genealogy, names, insignia'),(931,'China'),(932,'Egypt'),(933,'Palestine'),(934,'India'),(935,'Mesopotamia & Iranian Plateau'),(936,'Europe north & west of Italy'),(937,'Italy & adjacent territories'),(938,'Greece'),(939,'Other parts of ancient world'),(941,'British Isles'),(942,'England & Wales'),(943,'Central Europe Germany'),(944,'France & Monaco'),(945,'Italian Peninsula & adjacent islands'),(946,'Iberian Peninsula & adjacent islands'),(947,'Eastern Europe Soviet Union'),(948,'Northern Europe Scandinavia'),(949,'Other parts of Europe'),(951,'China & adjacent areas'),(952,'Japan'),(953,'Arabian Peninsula & adjacent areas'),(954,'South Asia India'),(955,'Iran'),(956,'Middle East (Near East)'),(957,'Siberia (Asiatic Russia)'),(958,'Central Asia'),(959,'Southeast Asia'),(961,'Tunisia & Libya'),(962,'Egypt & Sudan'),(963,'Ethiopia'),(964,'Morocco & Canary Islands'),(965,'Algeria'),(966,'West Africa & offshore islands'),(967,'Central Africa & offshore islands'),(968,'Southern Africa'),(969,'South Indian Ocean islands'),(971,'Canada'),(972,'Middle America Mexico'),(973,'United States'),(974,'Northeastern United States'),(975,'Southeastern United States'),(976,'South central United States'),(977,'North central United States'),(978,'Western United States'),(979,'Great Basin & Pacific Slope'),(981,'Brazil'),(982,'Argentina'),(983,'Chile'),(984,'Bolivia'),(985,'Peru'),(986,'Colombia & Ecuador'),(987,'Venezuela'),(988,'Guiana'),(989,'Paraguay & Urugua'),(991,'Unused'),(992,'Unused'),(993,'New Zealand'),(994,'Australia'),(995,'Melanesia New Guinea'),(996,'Other parts of Pacific Polynesia'),(997,'Atlantic Ocean islands'),(998,'Arctic islands & Antarctic'),(999,'Extraterrestrial world');
/*!40000 ALTER TABLE `deweythree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deweytwo`
--

DROP TABLE IF EXISTS `deweytwo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deweytwo` (
  `id` int(11) NOT NULL,
  `topicTwo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deweytwo`
--

LOCK TABLES `deweytwo` WRITE;
/*!40000 ALTER TABLE `deweytwo` DISABLE KEYS */;
INSERT INTO `deweytwo` VALUES (10,'Bibliography'),(20,'Library & information sciences'),(30,'General encyclopedic works'),(40,'Unused'),(50,'General serials & their indexes'),(60,'General organization & museology'),(70,'News media, journalism, publishing'),(80,'General collections'),(90,'Manuscripts & rare books'),(110,'Metaphysics'),(120,'Epistemology, causation, humankind'),(130,'Paranormal phenomena'),(140,'Specific philosophical schools'),(150,'Psychology'),(160,'Logic'),(170,'Ethics (Moral philosophy)'),(180,'Ancient, medieval, Oriental philosophy'),(190,'Modern Western philosophy'),(210,'Natural theology'),(220,'Bible'),(230,'Christian theology'),(240,'Christian moral & devotional theology'),(250,'Christian orders & local church'),(260,'Christian social theology'),(270,'Christian church history'),(280,'Christian denominations & sects'),(290,'Other & comparative religions'),(310,'General statistics'),(320,'Political science'),(330,'Economics'),(340,'Law'),(350,'Public administration'),(360,'Social services; association'),(370,'Education'),(380,'Commerce, communications, transport'),(390,'Customs, etiquette, folklore'),(410,'Linguistics'),(420,'English & Old English'),(430,'Germanic languages German'),(440,'Romance languages French'),(450,'Italian, Romanian, Rhaeto-Romantic'),(460,'Spanish & Portugese languages'),(470,'Italic Latin'),(480,'Hellenic languages Classical Greek'),(490,'Other languages'),(510,'Mathematics'),(520,'Astronomy & allied sciences'),(530,'Physics'),(540,'Chemistry & allied sciences'),(550,'Earth sciences'),(560,'Paleontology Paleozoology'),(570,'Life sciences'),(580,'Botanical sciences'),(590,'Zoological sciences'),(610,'Medical sciences Medicine'),(620,'Engineering & allied operations'),(630,'Agriculture'),(640,'Home economics & family living'),(650,'Management & auxiliary services'),(660,'Chemical engineering'),(670,'Manufacturing'),(680,'Manufacture for specific uses'),(690,'Buildings'),(710,'Civic & landscape art'),(720,'Architecture'),(730,'Plastic arts Sculpture'),(740,'Drawing & decorative arts'),(750,'Painting & paintings'),(760,'Graphic arts Printmaking & prints'),(770,'Photography & photographs'),(780,'Music'),(790,'Recreational & performing arts'),(810,'American literature in English'),(820,'English & Old English literatures'),(830,'Literatures of Germanic languages'),(840,'Literatures of Romance languages'),(850,'Italian, Romanian, Rhaeto-Romanic'),(860,'Spanish & Portuguese literatures'),(870,'General works on Latin literature'),(880,'Hellenic literatures Classical Greek'),(890,'Indic literature'),(910,'Geography & travel'),(920,'Biography, genealogy, insignia'),(930,'History of ancient world'),(940,'General history of Europe'),(950,'General history of Asia Far East'),(960,'General history of Africa'),(970,'General history of North America'),(980,'General history of South America'),(990,'General history of other areas');
/*!40000 ALTER TABLE `deweytwo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fiction`
--

DROP TABLE IF EXISTS `fiction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fiction` (
  `id` int(11) NOT NULL,
  `series` int(11) DEFAULT NULL,
  `noInSeries` int(11) DEFAULT NULL,
  `typeOfBook` int(11) DEFAULT NULL,
  `genre` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fiction`
--

LOCK TABLES `fiction` WRITE;
/*!40000 ALTER TABLE `fiction` DISABLE KEYS */;
INSERT INTO `fiction` VALUES (1,2,3,1,1),(2,12,2,1,1),(3,11,1,1,1),(4,2,1,1,1),(5,10,1,1,1),(6,1,0,1,4),(7,4,2,1,1),(8,4,4,1,1),(9,13,3,2,2),(10,4,3,1,1),(11,14,7,1,1),(12,15,4,1,1),(13,15,1,1,1),(14,15,2,1,1),(15,15,3,1,1),(17,1,0,1,1),(18,1,0,1,1),(19,16,5,1,1),(20,3,9,2,1),(21,3,5,1,1),(22,3,4,1,1),(23,3,3,1,1),(24,17,5,1,1),(25,1,0,1,3),(26,18,6,1,1),(27,18,5,1,1),(28,18,3,1,1),(29,18,1,1,1),(30,19,5,1,1),(31,19,4,1,1),(32,19,3,1,1),(33,20,2,1,1),(34,20,3,1,1),(35,20,1,1,1),(36,21,3,1,1),(37,21,5,1,1),(38,46,1,1,1),(39,1,0,1,4),(40,22,3,1,4),(41,1,0,1,1),(42,7,2,1,1),(43,6,7,1,1),(44,6,5,1,1),(45,7,1,1,1),(46,6,6,1,1),(47,6,1,1,1),(48,8,5,1,1),(49,8,3,1,1),(50,8,1,1,1),(51,5,8,1,5),(52,5,7,1,5),(53,5,4,1,5),(54,12,0,1,1),(55,12,1,1,1),(56,9,3,1,1),(57,9,2,1,1),(58,46,2,1,1),(59,1,0,1,1),(60,1,0,2,7),(61,24,2,1,8),(62,23,1,1,6),(63,23,2,1,6),(64,1,0,1,6),(66,25,2,1,1),(69,1,0,1,1),(70,1,0,2,7),(71,1,0,2,7),(72,18,7,1,1),(73,18,4,1,1),(74,27,1,1,2),(75,27,85,1,2),(76,27,68,1,2),(77,27,84,1,2),(78,27,21,1,2),(79,27,18,1,2),(80,27,67,1,2),(81,27,27,1,2),(82,27,22,1,2),(83,14,8,9,1),(84,14,1,5,1),(85,28,0,5,3),(86,35,1,1,3),(89,5,10,9,5),(90,1,0,1,3),(91,34,4,1,4),(92,17,6,1,1),(93,17,4,1,1),(97,32,4,5,2),(98,31,1,1,2),(99,31,2,1,2),(100,3,7,1,1),(101,30,4,1,1),(102,19,1,1,1),(103,19,6,1,1),(104,46,4,1,1),(105,29,10,3,1),(106,37,20,3,3),(107,28,27,3,3),(108,28,22,3,3),(109,28,20,3,3),(110,28,18,3,3),(111,28,10,3,3),(112,28,2,3,3),(113,28,1,3,3),(114,12,3,1,1),(115,1,0,2,1),(116,1,0,4,7),(117,1,0,8,1),(118,14,6,1,1),(119,4,5,1,1),(120,20,4,1,1),(121,38,2,1,1),(122,2,8,1,1),(123,2,9,1,1),(124,3,10,9,1),(125,38,3,1,1),(126,39,1,1,1),(127,5,11,1,5),(128,40,2,1,1),(129,1,0,7,1),(130,3,6,1,1),(131,46,3,1,1),(132,41,1,1,1),(133,1,0,2,1),(134,42,4,1,1),(135,42,7,1,1),(136,43,1,1,1),(137,1,0,2,1),(138,13,6,2,2),(139,44,1,1,1),(140,45,1,1,1),(141,1,0,1,1),(142,3,2,1,1),(143,10,2,1,1),(144,13,7,2,2),(145,13,5,1,2),(146,13,1,1,2),(148,47,1,1,1),(149,4,6,1,1),(150,1,0,1,6),(151,42,2,1,1),(152,42,1,1,1),(153,1,0,2,7),(154,42,6,1,1),(155,42,8,1,1),(156,1,0,1,11),(157,20,5,1,1),(158,29,12,3,7),(159,1,0,1,1),(161,3,1,1,1),(162,3,8,6,1),(163,10,3,1,1),(165,3,2,1,1),(166,48,1,1,1),(181,55,1,1,1),(182,9,1,1,1),(183,56,1,1,1),(184,57,1,1,1),(190,58,1,2,1),(191,5,11,1,5),(192,59,1,2,1),(193,60,1,9,1),(194,3,1,1,1),(195,10,8,1,1),(196,1,0,1,1),(198,61,1,1,1),(199,3,3,1,1);
/*!40000 ALTER TABLE `fiction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genres`
--

DROP TABLE IF EXISTS `genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `genreName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genres`
--

LOCK TABLES `genres` WRITE;
/*!40000 ALTER TABLE `genres` DISABLE KEYS */;
INSERT INTO `genres` VALUES (1,'Fantasy'),(2,'Detective'),(3,'Adventure'),(4,'Thriller'),(5,'Spy'),(6,'Science Fiction'),(7,'Various'),(8,'Humour'),(9,'Horror'),(10,'Romance'),(11,'Serious'),(12,'Classic');
/*!40000 ALTER TABLE `genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linkbookauthor`
--

DROP TABLE IF EXISTS `linkbookauthor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linkbookauthor` (
  `authorID` int(11) NOT NULL,
  `bookID` int(11) NOT NULL,
  `roleID` int(11) NOT NULL,
  PRIMARY KEY (`authorID`,`bookID`,`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linkbookauthor`
--

LOCK TABLES `linkbookauthor` WRITE;
/*!40000 ALTER TABLE `linkbookauthor` DISABLE KEYS */;
INSERT INTO `linkbookauthor` VALUES (0,167,1),(0,168,1),(1,1,1),(1,4,1),(1,122,1),(1,123,1),(2,2,1),(2,54,1),(2,55,1),(2,114,1),(2,126,1),(3,3,2),(4,5,1),(4,143,1),(4,163,1),(4,195,1),(5,6,1),(6,7,1),(6,8,1),(6,10,1),(6,119,1),(6,133,4),(6,149,1),(7,9,1),(7,138,1),(7,144,1),(7,145,1),(7,146,1),(8,11,1),(8,83,1),(8,84,1),(8,118,1),(9,12,1),(9,13,1),(9,14,1),(9,15,1),(10,17,1),(10,18,1),(10,56,1),(10,57,1),(10,128,1),(10,133,4),(10,139,1),(10,140,1),(10,182,1),(10,190,1),(11,19,1),(11,133,2),(12,20,1),(12,21,1),(12,22,1),(12,23,1),(12,100,1),(12,124,1),(12,130,1),(12,142,1),(12,161,1),(12,162,1),(12,165,1),(12,194,1),(12,199,1),(13,24,1),(13,92,1),(13,93,1),(14,25,1),(14,26,1),(14,27,1),(14,28,1),(14,29,1),(14,72,1),(14,73,1),(15,30,1),(15,31,1),(15,32,1),(15,102,1),(15,103,1),(16,33,1),(16,34,1),(16,35,1),(16,36,1),(16,37,1),(16,120,1),(16,157,1),(17,38,1),(17,58,1),(17,104,1),(17,115,1),(17,129,1),(17,131,1),(18,39,1),(18,40,1),(19,41,1),(19,42,1),(19,43,1),(19,44,1),(19,45,1),(19,46,1),(19,47,1),(19,198,1),(20,48,1),(20,49,1),(20,50,1),(20,51,1),(20,52,1),(20,53,1),(20,89,1),(20,97,1),(20,127,1),(20,191,1),(21,59,1),(22,60,1),(22,71,1),(23,61,1),(24,62,1),(24,63,1),(25,64,1),(27,66,1),(28,69,1),(29,70,1),(30,74,1),(30,75,1),(30,76,1),(30,77,1),(30,78,1),(30,79,1),(30,80,1),(30,81,1),(30,82,1),(31,85,1),(31,107,1),(31,108,1),(31,109,1),(31,110,1),(31,111,1),(31,112,1),(31,113,1),(32,85,3),(32,107,3),(32,108,3),(32,109,3),(32,110,3),(32,111,3),(32,112,3),(32,113,3),(33,86,1),(34,86,1),(36,90,1),(37,91,1),(40,98,1),(40,99,1),(42,101,1),(43,105,1),(43,153,1),(43,158,1),(44,106,1),(46,117,1),(47,121,1),(47,125,1),(47,184,1),(48,132,1),(49,133,2),(50,134,1),(50,135,1),(50,151,1),(50,152,1),(50,154,1),(50,155,1),(50,159,1),(51,136,1),(52,137,2),(53,141,1),(54,148,1),(55,150,1),(56,156,1),(57,161,3),(57,165,3),(57,199,3),(58,133,4),(59,133,4),(60,133,4),(61,133,4),(62,133,4),(63,133,4),(64,133,4),(65,133,4),(66,133,4),(67,133,4),(68,133,4),(69,133,4),(70,133,4),(71,133,4),(72,133,4),(73,133,4),(74,133,4),(75,133,4),(77,137,4),(78,137,4),(79,137,4),(80,137,4),(81,137,4),(82,137,4),(83,137,4),(84,137,4),(85,137,4),(86,137,4),(87,137,4),(88,137,4),(89,3,4),(89,137,4),(90,137,4),(91,137,4),(92,137,4),(93,137,4),(94,137,4),(95,137,4),(96,137,4),(97,137,4),(98,137,4),(99,137,4),(101,105,3),(102,116,2),(103,116,2),(104,115,3),(105,69,9),(106,59,9),(107,105,5),(107,158,5),(108,158,7),(109,158,7),(110,105,7),(110,158,7),(111,158,7),(112,105,3),(112,105,7),(112,158,7),(113,158,7),(114,158,7),(115,158,3),(116,158,3),(117,158,3),(118,158,3),(119,158,3),(120,158,3),(121,158,3),(122,158,3),(123,158,3),(123,158,5),(124,105,3),(125,11,1),(125,83,1),(125,118,1),(126,3,4),(127,3,4),(128,3,4),(129,3,4),(130,3,4),(131,3,4),(133,89,3),(134,89,10),(135,162,1),(136,162,1),(137,166,1),(155,181,1),(155,183,1),(156,185,1),(157,188,1),(158,188,1),(161,192,1),(162,192,9),(163,193,1),(164,196,1),(165,196,3),(166,197,1),(167,197,1);
/*!40000 ALTER TABLE `linkbookauthor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loans`
--

DROP TABLE IF EXISTS `loans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loans` (
  `bookID` int(11) NOT NULL,
  `borrowerID` int(11) NOT NULL,
  `dateIn` varchar(10) DEFAULT NULL,
  `dateOut` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`bookID`,`borrowerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loans`
--

LOCK TABLES `loans` WRITE;
/*!40000 ALTER TABLE `loans` DISABLE KEYS */;
INSERT INTO `loans` VALUES (1,1,'14/01/2016','13/01/2016'),(150,2,'24/12/2015','21/12/2015');
/*!40000 ALTER TABLE `loans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nonfiction`
--

DROP TABLE IF EXISTS `nonfiction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nonfiction` (
  `id` int(11) NOT NULL,
  `deweyNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nonfiction`
--

LOCK TABLES `nonfiction` WRITE;
/*!40000 ALTER TABLE `nonfiction` DISABLE KEYS */;
INSERT INTO `nonfiction` VALUES (185,796),(188,629),(197,796);
/*!40000 ALTER TABLE `nonfiction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Author'),(2,'Editor'),(3,'Illustrator'),(4,'Contributor'),(5,'Letterer'),(6,'Inker'),(7,'Colourist'),(8,'Artist'),(9,'Translator'),(10,'Researcher');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `series`
--

DROP TABLE IF EXISTS `series`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `series` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `numberOfBooks` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `series`
--

LOCK TABLES `series` WRITE;
/*!40000 ALTER TABLE `series` DISABLE KEYS */;
INSERT INTO `series` VALUES (1,'None',0),(2,'The Wheel of Time',15),(3,'Harry Potter',11),(4,'The Dresden Files',16),(5,'Alex Rider',13),(6,'The Drenai Saga',11),(7,'The Rigante',4),(8,'The Power of Five',5),(9,'The Mistborn Trilogy',3),(10,'Malazan Book of the Fallen',10),(11,'Thieves World',12),(12,'Bartimaeus Trilogy',4),(13,'Sherlock Holmes',9),(14,'The Belgariad and Mallorean',13),(15,'Inheritance Cycle',4),(16,'A Song of Ice and Fire',7),(17,'Children of the Red King',8),(18,'Artemis Fowl',8),(19,'Secrets of the Immortal Nicholas Flamel',6),(20,'Heroes of Olympus',5),(21,'Percy Jackson and the Olympians',5),(22,'Robert Langdon',4),(23,'STORM',5),(24,'Spud',4),(25,'Dracula',2),(27,'The Hardy Boys',190),(28,'Asterix and Obelix',36),(29,'The Sandman',12),(30,'Septimus Heap',7),(31,'Traces',7),(32,'Diamond Brothers',6),(34,'Dean Koontz Frankenstein',4),(35,'The Inventors',2),(37,'The Adventures of Tintin',24),(38,'Farseer trilogy',3),(39,'Lockwood & Co',3),(40,'Stormlight Archive',10),(41,'The Gentlemen Bastard Sequence',7),(42,'The Dark Tower',8),(43,'The Night Angel Trilogy',3),(44,'Rithmatics',2),(45,'Reckoners',4),(46,'Middle-Earth',19),(47,'Assassins Creed',8),(48,'The First Law',3),(55,'Path to Ascendancy',3),(56,'Tales of the Malazan Empire',6),(57,'Liveship Traders',3),(58,'Cosmere',10),(59,'The Witcher Stories',2),(60,'Prospero\'s library',4),(61,'Troy',3);
/*!40000 ALTER TABLE `series` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shops`
--

DROP TABLE IF EXISTS `shops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shops` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopName` varchar(50) DEFAULT NULL,
  `area` varchar(50) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shops`
--

LOCK TABLES `shops` WRITE;
/*!40000 ALTER TABLE `shops` DISABLE KEYS */;
INSERT INTO `shops` VALUES (1,'Bookwise book exchange','Bellville',NULL,NULL),(2,'Dreams come true book exchange','Bellville',NULL,'dctbooks@mweb.co.za'),(3,'Books Galore Plattekloof','Plattekloof',NULL,NULL),(4,'Lady in 3rd Avenue','Boston',NULL,NULL),(5,'Gift',NULL,NULL,NULL),(6,'Exclusive Books Tyger Valley','Bellville',NULL,NULL),(7,'Exclusive Books Canal Walk','Cape Town',NULL,NULL),(8,'Exclusive Books WaterFront','Cape Town',NULL,NULL),(9,'Bargain Books Tyger Valley','Bellville',NULL,NULL),(10,'CNA Tyger Valley','Bellville',NULL,NULL),(11,'Kalahari.com','Everywhere',NULL,NULL),(12,'The Travelling Bookshop','Everywhere',NULL,NULL),(13,'Unknown',NULL,NULL,NULL),(14,'CNA Canal Walk','Cape Town',NULL,NULL),(15,'Other/random book sale',NULL,NULL,NULL),(16,'Pimp my book','rondebosch','02123549848',NULL),(17,'Exclusive Books Cavendish','Claremmont','',''),(18,'Help the Rural Child','Mowbray','','');
/*!40000 ALTER TABLE `shops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typeofbook`
--

DROP TABLE IF EXISTS `typeofbook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `typeofbook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typeofbook`
--

LOCK TABLES `typeofbook` WRITE;
/*!40000 ALTER TABLE `typeofbook` DISABLE KEYS */;
INSERT INTO `typeofbook` VALUES (1,'Novel'),(2,'Short Stories'),(3,'Graphic novel'),(4,'Poems'),(5,'Omnibus'),(6,'Play'),(7,'Other anthology'),(8,'Quiz book'),(9,'Fictious non-fiction'),(10,'Picture book'),(11,'Joke');
/*!40000 ALTER TABLE `typeofbook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'library'
--
/*!50003 DROP FUNCTION IF EXISTS `GetSeriesID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` FUNCTION `GetSeriesID`(bookID INT) RETURNS int(11)
BEGIN
DECLARE sId INT;
SELECT (SELECT series FROM Fiction WHERE id = bookID) INTO sId;
RETURN sId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `IsFiction` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` FUNCTION `IsFiction`(idNum INT) RETURNS int(11)
BEGIN
DECLARE yes INT;
SELECT EXISTS(SELECT * FROM Fiction WHERE id = idNum) INTO yes;
RETURN yes;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addAuthor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `addAuthor`(nam VARCHAR(100))
BEGIN
INSERT INTO Authors (name) VALUES (nam);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addBook` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `addBook`(tit VARCHAR(100), cost INT, shop INT, month INT, year INT, pub INT)
begin
INSERT INTO AllBooks (title, price, placeBought, mnth, yr, firstpub) VALUES (tit, cost, shop, month, year, pub);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addBorrower` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `addBorrower`(name VARCHAR(100), number VARCHAR(12), address VARCHAR(100))
begin
INSERT INTO Borrowers (fullName, contactNumber, email) VALUES (name, number, address);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addFiction` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `addFiction`(idNum INT, ser INT, num INT, type INT, gen INT)
begin 
INSERT INTO Fiction (id, series, noInSeries, typeOfBook, genre) VALUES (idNum, ser, num, type, gen);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addGenre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `addGenre`(gName VARCHAR(50))
begin INSERT INTO Genres (genreName) VALUES(gName); end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addLinkEntry` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `addLinkEntry`(author INT, book INT, role INT)
BEGIN
INSERT INTO LinkBookAuthor (authorID, bookID, roleID) VALUES (author, book, role);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addNonFiction` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `addNonFiction`(idNum INT, dewey INT)
begin
INSERT INTO NonFiction (id, deweyNumber) VALUES (idNum, dewey);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addRole` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `addRole`(rol VARCHAR(100))
BEGIN
INSERT INTO Roles (role) VALUES (rol);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addSeries` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `addSeries`(seriesName VARCHAR(100), numBooks INT)
begin
INSERT INTO Series (name, numberOfBooks) VALUES (seriesName, numBooks);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addShop` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `addShop`(name VARCHAR(50), ar VARCHAR(50), ph VARCHAR(12), address VARCHAR(100))
begin INSERT INTO Shops (shopName, area, phone, email) VALUES(name, ar, ph, address); end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addType` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `addType`(ty VARCHAR(50))
begin
INSERT INTO TypeOfBook (type) VALUES(ty);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `cleanAuthors` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `cleanAuthors`(idNum INT)
BEGIN
CREATE TEMPORARY TABLE authorIDs
SELECT authorID FROM LinkBookAuthor WHERE bookID = idNum;
CREATE TEMPORARY TABLE authorCounts
SELECT authorID, count(*) AS numberOfBooks FROM LinkBookAuthor WHERE authorID IN (SELECT authorID from authorIDs) GROUP BY authorID;
CREATE TEMPORARY TABLE noBookAuthors
SELECT authorID FROM (authorCounts) WHERE numberOfBooks = 0;
DELETE FROM Authors WHERE id IN (SELECT authorID FROM noBookAuthors);
DROP TEMPORARY TABLE authorIDs;
DROP TEMPORARY TABLE authorCounts;
DROP TEMPORARY TABLE noBookAuthors;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `countAuthors` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `countAuthors`(book INT)
BEGIN
SELECT bookID, count(*) as NumberOfAuthors FROM LinkBookAuthor WHERE bookID = book;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteAuthor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `deleteAuthor`(idNum INT)
begin
DELETE FROM Authors WHERE id = idNum;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteBook` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `deleteBook`(idNum INT)
BEGIN
DECLARE sId INT;
DECLARE seriesCount INT;
IF IsFiction(idNum) = 1 THEN
SELECT series INTO sId FROM Fiction WHERE id = idNum;
DELETE FROM Fiction WHERE id = idNum;
SELECT (SELECT count(*)  FROM Fiction WHERE series = sId) INTO seriesCount;
IF seriesCount = 0 THEN
DELETE FROM Series WHERE id = sId;
END IF;
ELSE
DELETE FROM NonFiction WHERE id = idNum; 
END IF;
DELETE FROM LinkBookAuthor WHERE bookID = idNum;
CALL cleanAuthors(idNum);
DELETE FROM AllBooks WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteBorrower` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `deleteBorrower`(num INT)
begin
DELETE FROM Borrowers WHERE id = num;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteGenre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `deleteGenre`(num INT)
begin
DELETE FROM Genres WHERE id = num;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteRole` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `deleteRole`(idNum INT)
begin
DELETE FROM Roles WHERE id = idNum;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteSeries` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `deleteSeries`(idNum INT)
begin
DELETE FROM Series WHERE id = idNum;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteShop` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `deleteShop`(num INT)
begin
DELETE FROM Shops WHERE id = num;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteType` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `deleteType`(num INT)
begin
DELETE FROM TypeOfBook WHERE id = num;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllAuthors` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `getAllAuthors`()
BEGIN
SELECT name FROM Authors ORDER BY name ASC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAllTopicOne` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `getAllTopicOne`()
begin
SELECT topicOne FROM DeweyOne;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getAuthorID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `getAuthorID`(nam VARCHAR(50))
BEGIN
SELECT id FROM Authors WHERE name LIKE nam;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getBookAuthors` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `getBookAuthors`(bId INT)
BEGIN
SELECT authors.id, name, role
FROM Authors INNER JOIN LinkBookAuthor ON id = authorID INNER JOIN Roles on roleID = roles.id
WHERE bookID = bId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getBookTitle` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `getBookTitle`(bID INT)
BEGIN
SELECT title FROM AllBooks WHERE id = bID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getBorrowerName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `getBorrowerName`(num INT)
begin
SELECT fullName FROM Borrowers WHERE id = num;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getDeweyThree` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `getDeweyThree`(num INT)
begin
SELECT topicThree FROM DeweyThree WHERE id = num;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getDeweyThreeRange` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `getDeweyThreeRange`(start INT, end INT)
begin
SELECT topicThree FROM DeweyThree WHERE id BETWEEN start AND end;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getDeweyTwo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `getDeweyTwo`(num INT)
begin
SELECT topicTwo FROM DeweyTwo WHERE id = num;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getDeweyTwoRange` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `getDeweyTwoRange`(start INT, end INT)
begin SELECT topicTwo FROM DeweyTwo WHERE id BETWEEN start AND end; end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getGenreID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `getGenreID`(gen VARCHAR(50))
begin
SELECT id FROM Genres WHERE genreName = gen;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getGenres` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `getGenres`()
begin
SELECT genreName FROM Genres;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getMaxBookID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `getMaxBookID`()
BEGIN
SELECT max(id) FROM AllBooks;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getRoleID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `getRoleID`(rol VARCHAR(50))
BEGIN
SELECT id FROM Roles WHERE role LIKE rol;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getRoles` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `getRoles`()
begin
SELECT role FROM Roles ORDER BY role;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSeries` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `getSeries`()
BEGIN
SELECT name FROM Series ORDER BY name ASC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSeriesID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `getSeriesID`(sName VARCHAR(50))
BEGIN
SELECT id FROM Series WHERE name LIKE sName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getSeriesName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `getSeriesName`(idNum INT)
BEGIN
SELECT name FROM Series WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getShopID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `getShopID`(sh VARCHAR(50))
begin
SELECT id FROM Shops WHERE shopName LIKE sh;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getShops` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `getShops`()
begin
SELECT shopName FROM Shops;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getTopicOne` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `getTopicOne`(num INT)
begin
SELECT topicOne FROM DeweyOne WHERE id = num;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getTypeID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `getTypeID`(ty VARCHAR(50))
begin
SELECT id FROM TypeOfBook WHERE type LIKE ty;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getTypes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `getTypes`()
begin
SELECT type FROM TypeOfBook;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchAuthorID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `searchAuthorID`(author INT)
BEGIN
SELECT B.id as bookID, title, A.id as authorID, name, role FROM AllBooks B, Roles R, Authors A, LinkBookAuthor L
WHERE B.id = bookID AND roleID = R.id AND A.id = author AND authorID = author;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchAuthorName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `searchAuthorName`(author VARCHAR(100))
BEGIN
SELECT B.id as bookID, title, A.id as authorID, name, role FROM AllBooks B, Roles R, Authors A, LinkBookAuthor L
WHERE B.id = bookID AND roleID = R.id AND authorID = A.id AND A.name LIKE CONCAT('%',author,'%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchBooksPlaceBought` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `searchBooksPlaceBought`(sNum INT)
BEGIN
SELECT title, price, mnth, yr FROM AllBooks WHERE placebought = sNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchDateEqual` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchDateEqual`(m INT, y INT)
begin
SELECT id, title, author, placeBought, price, mnth, yr FROM AllBooks WHERE mnth = m AND yr = y;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchDateGreater` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchDateGreater`(m INT, y INT)
begin
SELECT title, author, price, mnth, yr FROM AllBooks WHERE (mnth > m AND yr >= y) OR yr > y;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchDateLess` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchDateLess`(m INT, y INT)
begin
SELECT title, author, price, mnth, yr FROM AllBooks WHERE (mnth < m AND yr <= y) OR yr < y;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchGenre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchGenre`(gNum INT)
begin
SELECT title, author, price, mnth, yr FROM AllBooks, Fiction WHERE AllBooks.id = Fiction.id AND genre = gNum;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchID`(num INT)
begin
SELECT * from AllBooks WHERE id = num;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchPriceEqual` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchPriceEqual`(cost DOUBLE)
begin
SELECT id, title, author, placeBought, price, mnth, yr FROM AllBooks WHERE price = cost;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchPriceGreater` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchPriceGreater`(cost DOUBLE)
begin
SELECT id, title, author, placeBought, price, mnth, yr FROM AllBooks WHERE price > cost;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchPriceLess` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchPriceLess`(cost DOUBLE)
begin
SELECT id, title, author, placeBought, price, mnth, yr FROM AllBooks WHERE price < cost AND price != 0;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchPubEqual` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchPubEqual`(y INT)
begin
SELECT id, title, author, firstpub, price FROM AllBooks WHERE firstpub = y;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchPubGreater` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchPubGreater`(y INT)
begin
SELECT id, title, author, firstpub, price FROM AllBooks WHERE firstpub > y;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchPubLess` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchPubLess`(y INT)
begin
SELECT id, title, author, firstpub, price FROM AllBooks WHERE firstpub < y;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchSeries` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchSeries`(ser VARCHAR(100))
begin
SELECT title, author, noInSeries FROM AllBooks A, Fiction F WHERE series = ser AND A.id = F.id;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchShopArea` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchShopArea`(ar VARCHAR(100))
begin
SELECT * FROM Shops WHERE area LIKE CONCAT('%', ar, '%');
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchShopID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchShopID`(sNum INT)
begin
SELECT * FROM Shops WHERE id = sNum;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchShopName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchShopName`(sName VARCHAR(100))
begin SELECT * FROM Shops WHERE shopName LIKE CONCAT('%', sName, '%'); end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchTitle` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchTitle`(t VARCHAR(100))
begin
SELECT * FROM AllBooks WHERE title LIKE CONCAT('%',t,'%');
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchType` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchType`(tNum INT)
begin
SELECT title, author, price, mnth, yr FROM AllBooks, Fiction WHERE typeOfBook = tNUm AND AllBooks.id = Fiction.id;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchYearEqual` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchYearEqual`(y INT)
begin
SELECT id, title, author, placeBought, price, mnth, yr FROM AllBooks WHERE yr = y;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchYearGreater` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchYearGreater`(y INT)
begin
SELECT id, title, author, placeBought, price, mnth, yr FROM AllBooks WHERE yr > y;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `searchYearLess` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `searchYearLess`(y INT)
begin
SELECT id, title, author, placeBought, price, mnth, yr FROM AllBooks WHERE yr < y AND yr != 0;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateAuthorName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateAuthorName`(idNum INT, newName VARCHAR(100))
BEGIN
UPDATE Authors SET name = newName WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateBooksFirstPub` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateBooksFirstPub`(idNum INT, first INT)
BEGIN
UPDATE AllBooks SET firstPub = first WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateBooksMonth` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateBooksMonth`(idNum INT, m INT)
BEGIN
UPDATE AllBooks SET mnth = m WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateBooksPrice` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateBooksPrice`(idNum INT, pri REAL)
BEGIN
UPDATE AllBooks SET  price = pri WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateBooksShop` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateBooksShop`(idNum INT, sh INT)
BEGIN
UPDATE AllBooks SET placeBought = sh WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateBooksTitle` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateBooksTitle`(idNum INT, tit VARCHAR(100))
BEGIN
UPDATE AllBooks SET title = tit WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateBooksYear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateBooksYear`(idNum INT, y INT)
BEGIN
UPDATE AllBooks SET yr = y WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateFictionGenre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateFictionGenre`(idNum INT, newGenre INT)
BEGIN
UPDATE Fiction SET genre = newGenre WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateFictionNoInSeries` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateFictionNoInSeries`(idNum INT, newNumber INT)
BEGIN
UPDATE Fiction SET noInSeries = newNumber WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateFictionSeries` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateFictionSeries`(idNum INT, newSeries INT)
BEGIN
UPDATE Fiction SET series = newSeries WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateFictionType` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateFictionType`(idNum INT, newType INT)
BEGIN
UPDATE Fiction SET typeOfBook = newType WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateGenreName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateGenreName`(idNum INT, newName VARCHAR(100))
BEGIN
UPDATE Genres SET genreName = newName WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateNonFictionDewey` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateNonFictionDewey`(idNum INT, dew INT)
BEGIN
UPDATE NonFiction SET deweyNumber = dew WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateSeriesName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateSeriesName`(idNum INT, newName VARCHAR(100))
BEGIN
UPDATE Series SET name = newName WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateSeriesNumBooks` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateSeriesNumBooks`(idNum INT, nBooks INT)
BEGIN
UPDATE Series SET numberOfBooks = nBooks WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateShopsArea` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateShopsArea`(idNum INT, newArea VARCHAR(100))
BEGIN
UPDATE Shops SET area = newArea WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateShopsEmail` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateShopsEmail`(idNum INT, newEMail VARCHAR(100))
BEGIN
UPDATE Shops SET email = newEMail WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateShopsName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateShopsName`(idNum INT, newName VARCHAR(100))
BEGIN
UPDATE Shops SET shopName = newName WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateShopsPhone` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateShopsPhone`(idNum INT, newPhone VARCHAR(12))
BEGIN
UPDATE Shops SET phone = newPhone WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateType` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `updateType`(idNum INT, newType VARCHAR(100))
BEGIN
UPDATE TypeOfBook SET type = newtype WHERE id = idNum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `viewAllBorrowers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `viewAllBorrowers`()
begin
SELECT * FROM Borrowers;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `viewAllLoans` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `viewAllLoans`()
begin
SELECT borrowerID, fullName, bookID, title, dateOut, dateIn FROM Loans L, AllBooks A, Borrowers B WHERE A.id = bookID AND B.id = borrowerID;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `viewAllShops` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`localhost` PROCEDURE `viewAllShops`()
begin
SELECt * from Shops;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `viewBook` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `viewBook`(idNum INT)
begin
select A.id, title, name, W.id, role FROM AllBooks A, Authors W, Roles R, LinkBookAuthor L WHERE A.id = L.Bookid AND L.authorID = W.id AND L.roleID = R.id AND A.id = idNum;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `viewFiction` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `viewFiction`()
BEGIN
SELECT A.id, title, S.name as SeriesName, noInSeries, mnth, yr, price FROM AllBooks A, Fiction F, Series S WHERE A.id = F.id AND F.series = S.id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `viewNonFiction` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `viewNonFiction`()
BEGIN
SELECT A.id, title, deweyNumber, mnth, yr, price FROM AllBooks A, NonFiction N WHERE A.id = N.id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `viewSeriesBooks` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Ross`@`%` PROCEDURE `viewSeriesBooks`(IN sID INT)
BEGIN
select AllBooks.id as BookID, title, noInSeries from (allbooks natural join fiction) inner join 
series on series.id = Fiction.series where series.id = sID order by noInSeries ASC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-31 13:11:14
