drop database if exists BoltonAuction;

Create database if not exists BoltonAuction;
Use BoltonAuction;

CREATE TABLE IF NOT EXISTS Staff	
(
	StaffID varchar(10) PRIMARY KEY,
    StaffName varchar(20),
    StaffAddress varchar(50),
    Staffphone varchar(25),
    JobTitle varchar(15)    
    
);

CREATE TABLE IF NOT EXISTS Auction
(
	AuctionID INT PRIMARY KEY, 
    AuctionDate Date,
    AuctioneerID varchar(10),
    AssistantID varchar(10),
    Location varchar(50),
    FOREIGN KEY (AuctioneerID) REFERENCES Staff(StaffID),
    FOREIGN KEY (AssistantID) REFERENCES Staff(StaffID)
    
);

CREATE TABLE IF NOT EXISTS Seller 
(
	SellerID INT PRIMARY KEY,
    SellerName varchar(20),
    SellerAddress varchar(50),
    SellerTelephone varchar(25)    
    
);


Create table if not exists Lot (

    LotNumber INT,
    LotDescription VARCHAR(255),
    ReservePrice INTEGER,
    SellerID INT,
    AuctionID INT, CONSTRAINT
    primary key (LotNumber, AuctionID),
    FOREIGN KEY (SellerID) REFERENCES Seller(SellerID)
    	
);

CREATE TABLE IF NOT EXISTS Item (
	
    ItemID INT PRIMARY KEY,
    LotNumber Integer,
    ItemDescription varchar(225),
    FOREIGN KEY (LotNumber) REFERENCES Lot(LotNumber)
    
); 

CREATE TABLE IF NOT EXISTS Bidder (
	
    BidderID varchar(10),
    Name Varchar(25),
    Address Varchar(50),
    Telephone Varchar(25),
    PRIMARY KEY (BidderID)
);

CREATE TABLE IF NOT EXISTS LotSale (
	
    SaleID varchar(5) PRIMARY KEY,
    BidderID varchar(10),
    LotNumber INT,
    WinningPrice INT,
    FOREIGN KEY (BidderID) REFERENCES Bidder(BidderID),
    FOREIGN KEY (LotNumber) REFERENCES Lot(LotNumber)
	
);

SET FOREIGN_KEY_CHECKS=0;





--

INSERT INTO LotSale (`SaleID`, `BidderID`, `LotNumber`, `WinningPrice`)
VALUES
  ("S001", "NOR0001", 1, 150),
  ("S002", "NOR0001", 6, 120),
  ("S003", "NOR0001", 5, 40),
  ("S004", "COF0007", 3, 175),
  ("S005", "HOP0008", 4, 210),
  ("S006", "HOP0008", 7, 95),
  ("S007", "HEN0005", 8, 95);
  
--
  
INSERT INTO Item (`ItemID`,`LotNumber`,`ItemDescription`)
VALUES
  (100,1,"17th century ruby ring"),
  (101,1,"15th century gold earing"),
  (102,1,"Edwardian Bird Broch"),
  (103,6,"16th century 9ct gold cuff links"),
  (104,4,"push along dog toy"),
  (105,4,"Victorian Doll"),
  (115,4,"Victorian Dolls House"),
  (106,5,"Floral Vase"),
  (107,3,"Blue Pattern China TeaPot, 17th Century"),
  (108,3,"Blue Pattern China Cup and Saucer, 17th Century"),
  (109,3,"Blue Pattern China Milk Jug, 17th Century"),
  (110,3,"Blue Pattern China Sugar Bowl, 17th Century"),
  (111,7,"12th century white gold earings"),
  (112,7,"Victoria Emerald Broch"),
  (113,8,"Jack in the Box, 1960"),
  (114,8,"spinning top, 1960");
  
--
  
INSERT INTO Lot (`AuctionID`, `LotNumber`,`LotDescription`,`ReservePrice`,`SellerID`)
VALUES
  (1, 1, "17th & 15th Gold Jewellery",100,104),
  (2, 6, "9ct gold cuff links",80, 106),
  (3, 4, "15th Century Toy Selection",150, 108),
  (4, 5, "Flower Vase",20, 102),
  (5, 3, "17th Century Blue China Tea Set",100, 104),
  (6, 7, "Earing and Broch Set",80, 104),
  (6, 8, "1960s toys",30, 108);
  
--
  
INSERT INTO Auction (`AuctionID`, `AuctionDate`, `AuctioneerID`, `AssistantID`, `Location`)
VALUES
  (1,'2023-07-11', "POL008", "FIS010", "Manchester"),
  (2, '2023-07-08', "POL008", "FIS010", "Bury"),
  (3, '2023-06-11', "POL008", "FIS010", "Burnley"),
  (4, '2023-07-11', "MCK050", "GAR002", "Bolton"),
  (5, '2023-06-13', "MCK050", "FIS010", "Preston"),
  (6, '2023-04-13', "HUF001", "RUS006", "Preston");
  
--
  
INSERT INTO Bidder (`BidderID`, `Name`,`Address`,`Telephone`)
VALUES
  ("NOR0001", "Fredericka Norton","P.O. Box 253, 9650 Morbi Ave","056 4669 6460"),
  ("HES0001", "Bree Hester","Ap #658-6893 Fusce Av.","(0112) 425 5551"),
  ("HEN0005", "Upton Henson","4501 Nunc, Rd.","0800 986476"),
  ("PEN0010", "Fleur Pennington","Ap #936-2164 Et Ave","0800 276163"),
  ("COF0007", "Quemby Coffey","Ap #399-949 Fusce Rd.","0867 874 2177"),
  ("GAL0003", "Latifah Galloway","Ap #166-6167 Sed Rd.","07624 896264"),
  ("POT0002", "Beau Potter","Ap #620-6061 Sed St.","0845 46 46"),
  ("BUR0001", "Jason Burgess","Ap #277-7574 Ante. Rd.","(016977) 1882"),
  ("KAU0003", "Hunter Kaufman","703-9663 Ut, Av.","076 0886 1515"),
  ("HOP0008", "Gavin Hopkins","260-1548 Auctor St.","0800 426439");
  
--
  
INSERT INTO Seller (`SellerID`,`SellerName`,`SellerAddress`,`SellerTelephone`)
VALUES
  (100,"Zorita Henry","Ap #583-2929 Lorem Street","0882 811 3112"),
  (101, "Xander Doyle","410-132 Quisque Av.","0845 46 44"),
  (102, "Maia Ayala","Ap #709-6934 Magna. St.","0382 621 5402"),
  (103, "Rigel Newton","525-919 Scelerisque Ave","07624 007584"),
  (104, "Barry Guerrero","306-3955 Vehicula Ave","0500 453538"),
  (105, "Norman Wyatt","9496 Dolor Avenue","(0114) 109 8208"),
  (106, "Alexander Bryan","Ap #211-2548 A Road","0348 366 0677"),
  (107, "Cody Maynard","Ap #688-7847 Phasellus Ave","070 0525 3475"),
  (108, "Maryam Rivers","9870 Malesuada. Ave","0800 141187"),
  (109, "Ferris Gardner","Ap #762-2785 Elit, Avenue","(013421) 29634");
  
--
  
INSERT INTO Staff (`StaffID`,`Staffname`,`Staffaddress`,`Staffphone`,`JobTitle`)
VALUES
  ("MAR001", "Moses Marsh","2738 Dui. St.","07624 433836","Assistant."),
  ("LAR007", "Kimberly Larson","808-6219 Ultricies Rd.","0905 761 7373","Assistant"),
  ("POL008", "Kane Pollard","559-9243 Accumsan St.","07812 584527","Auctioneer"),
  ("CON003","Lareina Conway","941-6642 Donec Street","070 2687 0247","Assistant"),
  ("MCK050", "Imani Mckay","218-4087 Turpis St.","0800 224786","Auctioneer."),
  ("GAR002","Paul Garner","914-2990 Ultrices. Street","07624 412036","Assistant"),
  ("FIS010", "Ulric Fisher","536-2804 Tempus Rd.","0800 272847","Auctioneer"),
  ("HUF001", "Peter Huff","6227 Sem. Road","(0111) 811 6234","Auctioneer"),
  ("RUS006", "Isabella Rush","883-1373 Elit Rd.","0831 059 4915","Assistant"),
  ("POT003", "Armand Potts","Ap #555-697 Arcu. St.","0500 516540","Auctioneer");
  

-- ALL QUERIES DONE
-- QUERY 1 Write a query to show any lots which contain items which are Toys, you must
-- display the lot description and the date and location of the auction.

SELECT
    Lot.LotNumber,
    Lot.LotDescription,
    Auction.AuctionDate,
    Auction.Location
FROM
    Lot
JOIN
    Auction ON Lot.AuctionID = Auction.AuctionID
JOIN
    Item ON Lot.LotNumber = Item.LotNumber
WHERE
    Item.ItemDescription LIKE '%toy%'; 
    

-- QUERY 2: Write a query to show seller name, telephone number, lot description and
-- Reserve Price, where they have a lot where the reserve price is more than £90
-- but less than £150 and only being auctioned in Manchester.

SELECT 
Seller.SellerName as "Seller Name", 
Seller.SellerTelephone as "Seller Telephone", 
Lot.LotDescription as "Lot Description",
Lot.ReservePrice as "Reserve Price"
FROM
Lot
JOIN 
Seller ON Seller.SellerID = Lot.SellerID
JOIN
Auction ON Auction.AuctionID = Lot.AuctionID
WHERE 
Auction.Location = "Manchester" AND
(Lot.ReservePrice >= 90 AND Lot.ReservePrice <= 150);



-- QUERY 3: Write a query to show which customer has paid the highest total price for all
-- successful bids, you should display the bidders name which should be labelled
-- "Bidders Name" and the total price, which should be named as "Total Price".

SELECT
    Bidder.Name AS "Bidders Name",
    SUM(LotSale.WinningPrice) AS "Total Price"
FROM
    Bidder
JOIN
    LotSale ON Bidder.BidderID = LotSale.BidderID
GROUP BY
    Bidder.BidderID
ORDER BY
    "Total Price" DESC
LIMIT 1;



-- QUERY 4: Write a query to show the total number of successful bids per customer and
-- their name, rename the total number of bids as "Total Bids".

SELECT
    Bidder.Name AS "Bidders Name",
    COUNT(LotSale.BidderID) AS "Total Bids"
FROM
    Bidder
LEFT JOIN
    LotSale ON Bidder.BidderID = LotSale.BidderID
GROUP BY
    Bidder.BidderID, Bidder.Name;
--    

    
-- QUERY 5: Write a query to show the lowest reserve price for a seller, rename this
-- column "Lowest Reserve Price" and show the sellers name, rename this
-- column as "Seller Name".

SELECT
    Seller.SellerName AS "Seller Name",
    MIN(Lot.ReservePrice) AS "Lowest Reserve Price"
FROM
    Seller
JOIN
    Lot ON Seller.SellerID = Lot.SellerID
GROUP BY
    Seller.SellerID, Seller.SellerName;
--


-- QUERY 6: Show Sellers with the Highest Reserve Price and Auction Location
SELECT
    Seller.SellerName AS "Seller Name",
    MAX(Lot.ReservePrice) AS "Highest Reserve Price",
    Auction.Location
FROM
    Seller
JOIN
    Lot ON Seller.SellerID = Lot.SellerID
JOIN
    Auction ON Lot.AuctionID = Auction.AuctionID
GROUP BY
    Seller.SellerID, Seller.SellerName, Auction.Location;
--


-- QUERY 7: Show the total number of lots auctioned per auctioneer
SELECT
    Staff.StaffName AS "Auctioneer Name",
    COUNT(DISTINCT Lot.LotNumber) AS "Total Lots Auctioned"
FROM
    Staff
JOIN
    Auction ON Staff.StaffID = Auction.AuctioneerID
JOIN
    Lot ON Auction.AuctionID = Lot.AuctionID
GROUP BY
    Staff.StaffID, Staff.StaffName;
--


