
CREATE SCHEMA IF NOT EXISTS `CleanAndGo`;
USE `CleanAndGo` ;

CREATE TABLE IF NOT EXISTS `Inventory` (
  `InventoryID` INT NOT NULL,
  `InventoryCategory` VARCHAR(10) NULL,
  PRIMARY KEY (`InventoryID`))
;


CREATE TABLE IF NOT EXISTS `CleaningSupply` (
  `InventoryID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Description` TEXT NOT NULL,
  `CurrentInventory` INT NOT NULL,
  `SafetyStockLevel` INT NOT NULL,
  PRIMARY KEY (`InventoryID`),
  INDEX `fk_Cleaning_Supplies_Inventory1_idx` (`InventoryID` ASC) VISIBLE,
  CONSTRAINT `fk_Cleaning_Supplies_Inventory1`
    FOREIGN KEY (`InventoryID`)
    REFERENCES `Inventory` (`InventoryID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;


CREATE TABLE IF NOT EXISTS `Customer` (
  `CustomerID` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `PhoneNumber` INT NOT NULL,
  `Balance` INT NOT NULL,
  `Customercol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CustomerID`))
;


CREATE TABLE IF NOT EXISTS `Position` (
  `PositionID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(45) NOT NULL,
  `HourlyPayRate` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`PositionID`))
;


CREATE TABLE IF NOT EXISTS `Employee` (
  `EmployeeID` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `AddressID` INT NOT NULL,
  `Gender` TINYINT NULL,
  `DateHired` DATE NOT NULL,
  `PositionID` INT NOT NULL,
  PRIMARY KEY (`EmployeeID`),
  INDEX `PositionID_idx` (`PositionID` ASC) VISIBLE,
  CONSTRAINT `fk_Employee_Position1`
    FOREIGN KEY (`PositionID`)
    REFERENCES `Position` (`PositionID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;



CREATE TABLE IF NOT EXISTS `Schedule` (
  `ScheduleID` INT NOT NULL,
  `StartTime` DATETIME NOT NULL,
  `Duration` TIME NOT NULL,
  `Day` TINYINT NOT NULL,
  PRIMARY KEY (`ScheduleID`))
;



CREATE TABLE IF NOT EXISTS `Service` (
  `ServideID` INT NOT NULL,
  `ServiceName` VARCHAR(45) NOT NULL,
  `Description` TEXT NOT NULL,
  `RateCharge` FLOAT NOT NULL,
  `Duration` TIME NOT NULL,
  PRIMARY KEY (`ServideID`))
;


--------
CREATE TABLE IF NOT EXISTS `EquipmentMaintenanceSchedule` (
  `EquipmentMaintenanceScheduleID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `NextMaintenanceDate` DATE NOT NULL,
  `MaintenancePeriod` DATE NOT NULL,
  `LastMaintenance` DATE NOT NULL,
  `Cost` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`EquipmentMaintenanceScheduleID`))
;



CREATE TABLE IF NOT EXISTS `Equipment` (
  `InventoryID` INT NOT NULL,
  `BrandName` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(45) NOT NULL,
  `PurchaseDate` DATE NOT NULL,
  `PurchasePrice` DECIMAL(10,2) NOT NULL,
  `Type` VARCHAR(45) NOT NULL,
  `HoursUsed` DECIMAL(10,1) NOT NULL,
  `EquipmentMaintenanceScheduleID` INT NOT NULL,
  PRIMARY KEY (`InventoryID`),
  INDEX `fk_Equipment_Inventory1_idx` (`InventoryID` ASC) VISIBLE,
  INDEX `fk_Equipment_EquipmentMaintenance1_idx` (`EquipmentMaintenanceScheduleID` ASC) VISIBLE,
  CONSTRAINT `fk_Equipment_Inventory1`
    FOREIGN KEY (`InventoryID`)
    REFERENCES `Inventory` (`InventoryID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Equipment_EquipmentMaintenance1`
    FOREIGN KEY (`EquipmentMaintenanceScheduleID`)
    REFERENCES `EquipmentMaintenanceSchedule` (`EquipmentMaintenanceScheduleID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;


CREATE TABLE IF NOT EXISTS `EmployeeShift` (
  `EmployeeID` INT NOT NULL,
  `ScheduleID` INT NOT NULL,
  PRIMARY KEY (`EmployeeID`, `ScheduleID`),
  INDEX `fk_Employee_has_Schedule_Schedule1_idx` (`ScheduleID` ASC) VISIBLE,
  INDEX `fk_Employee_has_Schedule_Employee_idx` (`EmployeeID` ASC) VISIBLE,
  CONSTRAINT `fk_Employee_has_Schedule_Employee`
    FOREIGN KEY (`EmployeeID`)
    REFERENCES `Employee` (`EmployeeID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Employee_has_Schedule_Schedule1`
    FOREIGN KEY (`ScheduleID`)
    REFERENCES `Schedule` (`ScheduleID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;



CREATE TABLE IF NOT EXISTS `Supplier` (
  `SupplierID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `AddressID` INT NOT NULL,
  `Phone` VARCHAR(45) NOT NULL,
  `Balance` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`SupplierID`))
;



CREATE TABLE IF NOT EXISTS `CustomerTransaction` (
  `CustomerTransactionID` INT NOT NULL,
  `CustomerID` INT NOT NULL,
  `ServiceID` INT NOT NULL,
  `Date` DATE NOT NULL,
  `AmountCharge` INT NOT NULL,
  `Description` VARCHAR(45) NOT NULL,
  `Satisfaction` TINYINT NULL,
  PRIMARY KEY (`CustomerTransactionID`),
  INDEX `fk_Customer_has_Service_Service1_idx` (`ServiceID` ASC) VISIBLE,
  INDEX `fk_Customer_has_Service_Customer1_idx` (`CustomerID` ASC) VISIBLE,
  CONSTRAINT `fk_Customer_has_Service_Customer1`
    FOREIGN KEY (`CustomerID`)
    REFERENCES `Customer` (`CustomerID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Customer_has_Service_Service1`
    FOREIGN KEY (`ServiceID`)
    REFERENCES `Service` (`ServideID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;



CREATE TABLE IF NOT EXISTS `SupplierTransaction` (
  `TransactionID` INT NOT NULL,
  `SupplierID` INT NOT NULL,
  `InventoryID` INT NOT NULL,
  `TransactionDate` DATETIME NOT NULL,
  `QuantityPurchased` INT NOT NULL,
  `AmountDue` DECIMAL(10,2) NOT NULL,
  `DueDate` DATE NOT NULL,
  `DelivaryDate` DATETIME NULL,
  PRIMARY KEY (`TransactionID`),
  INDEX `fk_Supplier_has_Inventory_Inventory1_idx` (`InventoryID` ASC) VISIBLE,
  INDEX `fk_Supplier_has_Inventory_Supplier1_idx` (`SupplierID` ASC) VISIBLE,
  CONSTRAINT `fk_Supplier_has_Inventory_Supplier1`
    FOREIGN KEY (`SupplierID`)
    REFERENCES `Supplier` (`SupplierID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Supplier_has_Inventory_Inventory1`
    FOREIGN KEY (`InventoryID`)
    REFERENCES `Inventory` (`InventoryID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;



CREATE TABLE IF NOT EXISTS `PaymentInfo` (
  `CustomerID` INT NOT NULL,
  `CardNumber` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CustomerID`, `CardNumber`),
  CONSTRAINT `fk_PaymentInfo_CustomerID`
    FOREIGN KEY (`CustomerID`)
    REFERENCES `Customer` (`CustomerID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;



CREATE TABLE IF NOT EXISTS `User` (
  `UserID` INT NOT NULL,
  `Username` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Salt` VARCHAR(45) NOT NULL,
  `User` VARCHAR(45) NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE INDEX `Username_UNIQUE` (`Username` ASC) VISIBLE)
;


CREATE TABLE IF NOT EXISTS `Account` (
  `AccountID` INT NOT NULL,
  `UserID` INT NOT NULL,
  `EmployeeID` INT NULL,
  `CustomerID` INT NULL,
  PRIMARY KEY (`AccountID`),
  INDEX `UserID_idx` (`UserID` ASC) VISIBLE,
  INDEX `EmployeeID_idx` (`EmployeeID` ASC) VISIBLE,
  INDEX `CustomerID_idx` (`CustomerID` ASC) VISIBLE,
  CONSTRAINT `fk_Account_User1`
    FOREIGN KEY (`UserID`)
    REFERENCES `User` (`UserID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Account_Employee1`
    FOREIGN KEY (`EmployeeID`)
    REFERENCES `Employee` (`EmployeeID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Account_Customer1`
    FOREIGN KEY (`CustomerID`)
    REFERENCES `Customer` (`CustomerID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;


CREATE TABLE IF NOT EXISTS `CustomerUseInventory` (
  `CustomerTransactionID` INT NOT NULL,
  `InventoryID` INT NOT NULL,
  PRIMARY KEY (`CustomerTransactionID`),
  INDEX `InventoryID_idx` (`InventoryID` ASC) VISIBLE,
  CONSTRAINT `fk_CustomerUseInventory_CustomerTransaction`
    FOREIGN KEY (`CustomerTransactionID`)
    REFERENCES `CustomerTransaction` (`CustomerTransactionID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_CustomerUseInventory_Inventory1`
    FOREIGN KEY (`InventoryID`)
    REFERENCES `Inventory` (`InventoryID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;

CREATE TABLE IF NOT EXISTS `SupplierProduct` (
  `SupplierProductID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(45) NOT NULL,
  `Price` DECIMAL(10,2) NOT NULL,
  `SupplierID` INT NOT NULL,
  PRIMARY KEY (`SupplierProductID`),
  CONSTRAINT `fk_SupplierProduct_Supplier`
    FOREIGN KEY (`SupplierProductID`)
    REFERENCES `Supplier` (`SupplierID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;



CREATE TABLE IF NOT EXISTS `ExpenseType` (
  `ExpenseTypeID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ExpenseTypeID`))
;


CREATE TABLE IF NOT EXISTS `Expense` (
  `ExpenseID` INT NOT NULL,
  `ExpenseType` INT NOT NULL,
  `Amount` DECIMAL(10,2) NOT NULL,
  `Date` DATE NOT NULL,
  PRIMARY KEY (`ExpenseID`),
  CONSTRAINT `fk_Expense_ExpenseType1`
    FOREIGN KEY (`ExpenseID`)
    REFERENCES `ExpenseType` (`ExpenseTypeID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;
