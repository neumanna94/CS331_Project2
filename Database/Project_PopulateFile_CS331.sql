
--
-- Inserting data into table Customer
--
INSERT INTO Customer(CustomerID, FirstName, LastName, Address, Email, PhoneNumber, Balance, CreationDate) VALUES
(1, 'Norris', 'Mclaurin', '3170 Chapel Hill Ave', 'NorrisCalderon@example.com', 42532146754,0,'2020-5-12'),
(2, 'Lanny', 'Kirk', '28 W Sharp Hill Parkway', 'TaggartY@example.com', 4253242526,0,'2020-5-12'),
(3, 'Darron', 'Pepper', '3853 W Monument Ln', 'JoeannPHuang@example.com', 4257654321,0,'2020-5-12'),
(4, 'Adan', 'Mclean', '1514 Rose Hill Drive', 'Ada_Anglin6@nowhere.com', 4251234567,0,'2020-5-12'),
(5, 'Trish', 'Mcclelland', '2270 NW Mountain Circle', 'LoydBranham258@example.com',42575454344,0,'2020-5-12'),
(6, 'Reyna', 'Perales', '32 Church Parkway', 'oytxgpgm.ebekzhq@example.com', 4253213567,0,'2020-5-12'),
(7, 'Lorene', 'Mclemore', '3097 N Fox Hill Lane', 'SamuelGunn@example.com', 4256431234,0,'2020-5-12');

--
-- Inserting data into table EquipmentMaintenanceSchedule
--
INSERT INTO EquipmentMaintenanceSchedule(EquipmentMaintenanceScheduleID, `Name`, NextMaintenanceDate, MaintenancePeriod, LastMaintenance, Cost) VALUES
(1, 'Washer Maintenance', '2020-11-22',60,'2020-8-22',100),
(2, 'Dryer Maintenance', '2020-11-22',60,'2020-8-22',75);
--
-- Inserting data into table ExpenseType
--
INSERT INTO ExpenseType(ExpenseTypeID, `Name`) VALUES
(1, 'Supply'),
(2, 'Rent'),
(3, 'Employee'),
(4, 'Insurance'),
(5, 'Misc');

--
-- Inserting data into table Inventory
--
INSERT INTO Inventory(InventoryID, InventoryCategory) VALUES
(1, 'CS'),
(2, 'CS'),
(3, 'CS'),
(4, 'CS'),
(5, 'CS'),
(6, 'CS'),
(7, 'CS'),
(8, 'E'),
(9, 'E'),
(10, 'E'),
(11, 'E'),
(12, 'E'),
(13, 'E'),
(14, 'E');
--
-- Inserting data into table Position
--
INSERT INTO `Position`(PositionID, `Name`, Description, HourlyPayRate) VALUES
(1, 'Manager', 'Facilitate washer/dryer maintenance.', 17),
(2, 'Janitor', 'Clean entire store.', 13.65),
(3, 'Sales', 'Help find new markets.', 50),
(4, 'Owner', 'Owner', .01),
(5, 'Co-owner', 'Co-owner', .01),
(6, 'Front desk', 'Greet guests and help customers.', 12),
(7, 'Investor', 'Investor.', .01);

--
-- Inserting data into table Schedule
--
INSERT INTO Schedule(ScheduleID, StartTime, Duration, `Day`) VALUES
(1, '2020-11-22 00:08:00', '00:08:00', 0),
(2, '2020-11-22 00:04:00', '00:08:00', 6),
(3, '2020-11-23 00:08:00', '00:08:00', 0),
(4, '2020-11-23 00:08:00', '00:08:00', 0),
(5, '2020-11-24 00:08:00', '00:08:00', 1),
(6, '2020-11-24 00:08:00', '00:08:00', 1),
(7, '2020-11-25 00:08:00', '00:12:00', 2);

--
-- Inserting data into table Service
--
INSERT INTO Service(ServiceID, ServiceName, `Description`, RateCharge, Duration) VALUES
(1, 'Laundry', 'Use our wonderful laundry machines.', 1.00 , '00:30:00'),
(2, 'Dryer', 'Use our wonderful dryer machines.', 1.00 , '00:30:00'),
(3, 'Dry Cleaning', 'We will clean your clothes.', 10.00 , '02:00:00');


--
-- Inserting data into table Supplier
--
INSERT INTO Supplier(SupplierID, `Name`, Address, Phone, Balance) VALUES
(1, 'Costco', '4401 4th Ave S, Seattle, WA 98134', '(206) 622-3136', 0),
(2, 'Amazon', 'Online', 'Online', 0),
(3, 'Webrestrauntstore.com', 'Online', 'Online', 0),
(4, 'Juan Felipe', '2414 1st Ave Apt 303 Seattle, WA 98121', '(959) 531-2195', 0),
(5, 'The Home Depot', '6810 S 180th St Tukwila, WA 98188', '(206)575-9200', 0),
(6, 'Lowes', '24050 Pacific Highway South Kent, WA', '(206) 651-9036', 0),
(7, 'Ace Hardware', '14100 SE Petrovitsky Rd Renton, WA 98058-8932', '(425) 793-0123', 0);

--
-- Inserting data into table User
--
INSERT INTO User(UserID, Username, `Password`, Salt) VALUES
(1, 'alexander94', 'password', 'N7'),
(2, 'mac', 'password', 'LF2HW8D63B414X2H2'),
(3, 'wayne', 'password', 'RTL'),
(4, 'sara', 'password', '1'),
(5, 'johnny', 'password', 'ASLH5396AL0ZDA2'),
(6, 'jango', 'password', '0T04D3K0VG2'),
(7, 'lara99', 'password', 'M3RZX32768PQ8');


--
-- Inserting data into table CustomerTransaction
--
INSERT INTO CustomerTransaction(CustomerTransactionID, CustomerID, ServiceID, `Date`, AmountCharge, `Description`, Satisfaction) VALUES
(1, 1, 1, '2020-11-22', 10, 'Used Dryer.', 5),
(2, 1, 2, '2020-11-22', 10, 'Used Cleaner', 5),
(3, 2, 1, '2020-11-22', 20, 'Used Dryer', 4),
(4, 3, 2, '2020-11-22', 20, 'Used Washer. Had problem.', 0),
(5, 4, 2, '2020-11-22', 30, 'Used Washer', 5),
(6, 5, 3, '2020-11-22', 30, 'Used dry cleaning services.', 10),
(7, 6, 3, '2020-11-22', 30, 'Used dry cleaning services',10);

--
-- Inserting data into table Employee
--
INSERT INTO Employee(EmployeeID, FirstName, LastName, Address, Gender, DateHired, PositionID) VALUES
(1, 'Tran', 'Harmon', "3000 Landerholm Cir SE, Bellevue, WA 98007-6406, United States", 'F', '2019-10-10', 1),
(2, 'Abel', 'Pereira', "3000 Landerholm Cir SE, Bellevue, WA 98007-6406, United States", 'F', '2018-12-30', 2),
(3, 'Elbert', 'Talbot', "3000 Landerholm Cir SE, Bellevue, WA 98007-6406, United States", 'M', '2017-04-12', 3),
(4, 'Hubert', 'Dougherty', "3000 Landerholm Cir SE, Bellevue, WA 98007-6406, United States", 'F', '2011-05-27', 4),
(5, 'Aldo', 'Zamora', "3000 Landerholm Cir SE, Bellevue, WA 98007-6406, United States", 'M','2020-05-22', 5),
(6, 'Yoshiko', 'Knowles', "3000 Landerholm Cir SE, Bellevue, WA 98007-6406, United States",'M', '2010-01-03', 6),
(7, 'Agripina', 'Collins', "3000 Landerholm Cir SE, Bellevue, WA 98007-6406, United States", 'F', '2012-11-16', 7);

--
-- Inserting data into table Account
--
INSERT INTO Account(AccountID, UserID, EmployeeID, CustomerID) VALUES
(1, 1, 1, NULL),
(2, 2, NULL, 1),
(3, 3, 2, NULL),
(4, 4, NULL, NULL),
(5, 5, 6, NULL),
(6, 6, NULL,2),
(7, 7, NULL, NULL);



--
-- Inserting data into table CleaningSupply
--
INSERT INTO CleaningSupply(InventoryID, `Name`, `Description`, CurrentInventory, SafetyStockLevel) VALUES
(1, 'Terra Breeze Detergent
', 'Terra Breeze Liquid dish detergent comes in convenient, 1.6 oz. flip-cap bottles. This product will leave dishes sparkling clean and is ideal for guest use in hotels. Powdered laundry detergent comes in single-use, individually wrapped packs. This high-quality eco-friendly detergent is Perfect for Hotels. Our Terra Breeze Dishwasher Detergent Powder is perfect for guest use. The convenient, single-use packs are a nice touch for guest rooms with a dishwasher. The Terra Breeze formula will leave dishes sparkling clean. All of our lines were created with the environment and well-being of consumers as a top priority. We use vegetable-based formulas enriched with natural and organic ingredients. We assure the satisfaction of you and your guests with any of our lines. We are confident that you will find a collection that suits your property. Feel free to check out our below lines: - H2O Therapy - Mountain Breeze - Desert Breeze - Terra Botanics - Eco Botanics - Aqua organics - Terra Pure Green Tea - Terra Pure Wild Citrus - Island Spa - Citrus Breeze Naturals - Terra Breeze Detergents We are committed to selling products that are leading the trend in environmentally friendly production and upscale design.', 20, 10),
(2, 'Preformed Coin Wrapper - $10, Quarters - 1000/Case', 'Keep coins organized with this preformed coin wrapper. Designed to accommodate up to 40 quarters for a total of $10, this item uses 60 lb. grade paper and is color-coded with orange denominations and candy stripes to visually identify its proper function. This convenient product also meets ABA standards to supply you with a convenient wrapper that is bound to increase the efficiency of your coin storage operation. Plus, thanks to its durable double-wrapped kraft construction, this item offers superior security during transport when compared to lighter grade paper options.', 100, 50),
(3,'2 oz. ALL Stainlifter Powder Laundry Detergent Box for Coin Vending Machine - 100/Case', 'This ALL powder laundry detergent keeps clothes looking their best. Its formula releases a fresh scent into clothing and is great for removing dirt and stains. Plus, each box is small enough to be sold in a vending machine for easy management. This detergent is ideal for use with high efficiency (HE) laundry machines', 50, 20),
(4,'2 oz. Surf Sparkling Ocean Powder Laundry Detergent Box for Coin Vending Machine - 100/Case', 'Give patrons at your hotel, laundromat, or apartment complex a convenient way to ensure clean, fresh-smelling laundry with this 2 oz. box of Surf Sparkling Ocean powder laundry detergent! This powder bleach is perfect for removing stains, brightening whites, and eliminating odors to keep you looking and smelling your best from morning to night. This unique, heavy duty detergent attacks stubborn dirt at its core and easily lifts stains in any temperature water. It comes in convenient 2 oz. packs to fit comfortably into vending machines.', 50, 20),
(5, '2 Count Snuggle Blue Sparkle Dryer Sheet Fabric Softener Box for Coin Vending Machine - 100/Case', 'Soften and freshen up your laundry with Snuggle Blue Sparkle fabric softener sheets. These fabric softener sheets are guaranteed to leave your clothes fleecy-soft while giving your clothes long lasting freshness and eliminating static cling. This convenient 2 sheet box of Snuggle fabric softener is perfect for single use applications such as laundromats and college campuses. These boxes are small enough to be sold in a vending machine for easy management. Each box is good for one load.', 50, 30),
(6, 'Premium Toilet Paper Family Value Size 360 Sheets Soft White Standard Tissue Roll 2 Ply For Home Bathroom Bath Restroom Skin Friendly (48 Pack)', 'Premium, ultra-soft tissue paper, 2-ply 360 sheets per roll.', 20, 10),
(7, 'Bounty Quick-Size Paper Towels, White, 12 Family Rolls = 30 Regular Rolls', 'This pack contains 60 more sheets per pack which means 6 extra days worth of paper vs. Bounty Select-A-Size 12 Double Plus Rolls Estimated based on manufacturer data.', 20, 1);

--
-- Inserting data into table CustomerUseInventory
--
INSERT INTO CustomerUseInventory(CustomerTransactionID, InventoryID) VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 4),
(5, 5),
(6, 4),
(7,10);

--
-- Inserting data into table EmployeeShift
--
INSERT INTO EmployeeShift(EmployeeID, ScheduleID) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(7, 5),
(6, 7),
(5, 6);

--
-- Inserting data into table Equipment
--
INSERT INTO Equipment(InventoryID, EquipmentID, BrandName, `Description`, PurchaseDate, PurchasePrice, `Type`, HoursUsed, EquipmentMaintenanceScheduleID) VALUES
(8, 1,'LG Signature', 'Top-Load Electric Dryer Machine', '2020-11-22', 509.78, 'Dryer', 10, 2),
(9, 2, 'Samsung', '7.4 cu. ft. White Gas Dryer with Sensor Dry', '2020-11-22', 411.98,'Gas Dryer', 10, 2),
(10, 3, 'Amana', '3.5 cu. ft. White Top Load Washing Machine','2020-11-22', 904.89, 'Washer', 10, 1),
(11, 4, 'Samsung', '5.0 cu. ft. Hi-Efficiency White Top Load Washing Machine with Active Water Jet.', '2020-11-22', 467.73, 'Washer', 10, 1),
(12, 5, 'GE', '4.2 cu. ft. White Top Load Washing Machine with Stainless Steel Basket.', '2020-11-22', 389.31, 'Washer', 10, 1),
(13, 6,'Electrolux', '4.4 cu. ft. Front Load Washer with SmartBoost Technology Steam in Titanium', '2020-11-22', 725.34, 'Washer', 10, 1),
(14, 7,'Whirlpool', '4.3 cu. ft. High-Efficiency White Top Load Washing Machine with Quick Wash.', '2020-11-22', 421.46, 'Washer', 10,1);

--
-- Inserting data into table Expense
--
INSERT INTO Expense(ExpenseID, ExpenseType, Amount, `Date`) VALUES
(1, 1, 54.92, '1970-01-01'),
(2, 1, 38.68, '2020-11-28'),
(3, 2, 63.69, '2020-11-28'),
(4, 2, 91.57,'2020-11-28'),
(5, 3, 76.2, '2020-11-28'),
(6, 3, 56.64, '2020-11-28'),
(7, 3, 63.78, '2020-11-28');
--
-- Inserting data into table PaymentInfo
--
INSERT INTO PaymentInfo(CustomerID, CardNumber) VALUES
(1, '6387452802225071'),
(2, '5447756623097513'),
(3, '6393026174265873'),
(4, '3532286452704303'),
(5, '6215130628246616'),
(6, '30506565173085'),
(7, '6289373588824953');

--
-- Inserting data into table SupplierProduct
--
INSERT INTO SupplierProduct(SupplierProductID, `Name`, `Description`, Price, SupplierID) VALUES
(1, 'Terra Breeze Detergent', 'Terra Breeze Liquid dish detergent comes in convenient, 1.6 oz. flip-cap bottles. This product will leave dishes sparkling clean and is ideal for guest use in hotels. Powdered laundry detergent comes in single-use, individually wrapped packs. This high-quality eco-friendly detergent is Perfect for Hotels. Our Terra Breeze Dishwasher Detergent Powder is perfect for guest use. The convenient, single-use packs are a nice touch for guest rooms with a dishwasher. The Terra Breeze formula will leave dishes sparkling clean. All of our lines were created with the environment and well-being of consumers as a top priority. We use vegetable-based formulas enriched with natural and organic ingredients. We assure the satisfaction of you and your guests with any of our lines.', 30, 1),
(2, 'Preformed Coin Wrapper', 'Keep coins organized with this preformed coin wrapper. Designed to accommodate up to 40 quarters for a total of $10, this item uses 60 lb. grade paper and is color-coded with orange denominations and candy stripes to visually identify its proper function. This convenient product also meets ABA standards to supply you with a convenient wrapper that is bound to increase the efficiency of your coin storage operation. Plus, thanks to its durable double-wrapped kraft construction, this item offers superior security during transport when compared to lighter grade paper options.', 30, 2),
(3, '2 oz.ALL Stainlifter Powder Laundry Detergent Box', 'This ALL powder laundry detergent keeps clothes looking their best. Its formula releases a fresh scent into clothing and is great for removing dirt and stains. Plus, each box is small enough to be sold in a vending machine for easy management. This detergent is ideal for use with high efficiency (HE) laundry machines', 30, 3),
(4, '2 oz. Surf Sparkling Ocean Powder Laundry Detergent', 'Give patrons at your hotel, laundromat, or apartment complex a convenient way to ensure clean, fresh-smelling laundry with this 2 oz. box of Surf Sparkling Ocean powder laundry detergent! This powder bleach is perfect for removing stains, brightening whites, and eliminating odors to keep you looking and smelling your best from morning to night. This unique, heavy duty detergent attacks stubborn dirt at its core and easily lifts stains in any temperature water. It comes in convenient 2 oz. packs to fit comfortably into vending machines.', 30, 2),
(5, '2 Count Snuggle Blue Sparkle Dryer Sheet Fabric Softener', 'Soften and freshen up your laundry with Snuggle Blue Sparkle fabric softener sheets. These fabric softener sheets are guaranteed to leave your clothes fleecy-soft while giving your clothes long lasting freshness and eliminating static cling. This convenient 2 sheet box of Snuggle fabric softener is perfect for single use applications such as laundromats and college campuses. These boxes are small enough to be sold in a vending machine for easy management. Each box is good for one load.', 50, 2),
(6, 'Premium Toilet Paper Family Value Size 360 Sheets', 'Premium, ultra-soft tissue paper, 2-ply 360 sheets per roll.', 20, 2),
(7, 'Bounty Quick-Size Paper Towels, White', 'This pack contains 60 more sheets per pack which means 6 extra days worth of paper vs. Bounty Select-A-Size 12 Double Plus Rolls Estimated based on manufacturer data.', 20, 2),
(8, 'LG Signature', 'Top-Load Electric Dryer Machine', 509.78, 1),
(9, 'Samsung', '7.4 cu. ft. White Gas Dryer with Sensor Dry', 411.98,2),
(10, 'Amana', '3.5 cu. ft. White Top Load Washing Machine', 904.89, 3),
(11, 'Samsung', '5.0 cu. ft. Hi-Efficiency White Top Load Washing Machine with Active Water Jet.', 467.73, 3),
(12, 'Samsung','4.2 cu. ft. White Top Load Washing Machine with Stainless Steel Basket.',389.31,5),
(13,'Electrolux', '4.4 cu. ft. Front Load Washer with SmartBoost Technology Steam in Titanium', 725.34, 3),
(14,'Whirlpool', '4.3 cu. ft. High-Efficiency White Top Load Washing Machine with Quick Wash', 421.46, 3);


--
-- Inserting data into table SupplierTransaction
--
INSERT INTO SupplierTransaction(TransactionID, SupplierID, InventoryID, TransactionDate, QuantityPurchased, AmountDue, DueDate, DelivaryDate) VALUES
(1, 1, 1, '2020-11-22 08:09:19', 23, 59.3, '2020-11-28', '2020-11-28 21:57:25'),
(2, 2, 2, '2020-11-22 08:53:53', 36, 2.23, '2020-11-28', '2020-11-28 16:53:14'),
(3, 3, 3, '2020-11-22 08:09:37', 85, 94.28, '2020-11-28', '2020-11-28 11:54:32'),
(4, 3, 4, '2020-11-22 08:04:04', 2, 58.41, '2020-11-28', '2020-11-28 00:00:59'),
(5, 3, 5, '2020-11-22 08:47:12', 19, 39.43, '2020-11-28', '2020-11-28 16:13:51'),
(6, 3, 6, '2020-11-22 08:01:40', 8, 62.88, '2020-11-28', '2020-11-28 20:56:43'),
(7, 3, 7, '2020-11-22 08:16:24', 68, 57.91, '2020-11-28', '2020-11-28 16:00:49'),
(8, 3, 1, '2020-11-22 08:09:19', 23, 59.3, '2020-11-28', '2020-11-28 21:57:25'),
(9, 3, 2, '2020-11-22 08:53:53', 36, 2.23, '2020-11-28', '2020-11-28 16:53:14'),
(10,3, 3, '2020-11-22 08:09:37', 85, 94.28, '2020-11-28', '2020-11-28 11:54:32'),
(11,3,4, '2020-11-22 08:04:04', 2, 58.41, '2020-11-28', '2020-11-28 00:00:59'),
(12,3,5, '2020-11-22 08:47:12', 19, 39.43, '2020-11-28', '2020-11-28 16:13:51'),
(13, 3, 6, '2020-11-22 08:01:40', 8, 62.88, '2020-11-28', '2020-11-28 20:56:43'),
(14, 2, 7, '2020-11-22 08:16:24', 68, 57.91, '2020-11-28', '2020-11-28 16:00:49');


