/*@Author Mac DeCourcy
 *@queries Alex Neumann
 */
package core;

public enum Queries {

    ANNUAL_EXPENSE_CleaningSupply("SELECT SUM(QuantityPurchased*AmountDue) as 'Annual Expense from Cleaning Supplies' FROM SupplierTransaction as ST INNER JOIN Inventory as I ON ST.InventoryID = I.InventoryID WHERE I.InventoryCategory = 'CS' AND YEAR(TransactionDate) = YEAR(CURRENT_DATE);"),
    USER_PASS("SELECT * FROM User WHERE Username = ? AND Password = ?"),
    SELECT_ANNUAL_EXPENSE_EQUIPMENTMAINTENANCE("SELECT SUM(Cost) FROM EquipmentMaintenanceSchedule WHERE YEAR(LastMaintenance) = YEAR(CURRENT_DATE);"),
    SELECT_ANNUAL_EXPENSE_CLEANINGSUPPLIES("SELECT SUM(QuantityPurchased*AmountDue) as \'Annual Expense from Cleaning Supplies\' FROM SupplierTransaction as ST INNER JOIN Inventory as I ON ST.InventoryID = I.InventoryID WHERE I.InventoryCategory = \'CS\' AND YEAR(TransactionDate) = YEAR(CURRENT_DATE);"),
    SELECT_ANNUAL_EXPENSE_NEW_EQUIPMENT("SELECT SUM(QuantityPurchased*AmountDue) as 'Annual Expense from New Equipment' FROM SupplierTransaction as ST INNER JOIN Inventory as I ON ST.InventoryID = I.InventoryID WHERE I.InventoryCategory = \'E\' AND YEAR(TransactionDate) = YEAR(CURRENT_DATE);"),
    SELECT_ANNUAL_REVENUE_SERVICE_TO_CUSTOMERS("SELECT S.ServiceID, S.ServiceName, SUM(AmountCharge) FROM CustomerTransaction as CT INNER JOIN Service as S ON CT.ServiceID = S.ServiceID GROUP BY CT.ServiceID HAVING CT.ServiceID IN (SELECT ServiceID FROM CustomerTransaction as CT WHERE YEAR(CT.Date) = YEAR(CURRENT_DATE));"),
    SELECT_ANNUAL_EARNING ("SELECT SUM(AmountCharge) FROM CustomerTransaction as CT WHERE YEAR(CT.Date) = YEAR(CURRENT_DATE);"),
    SELECT_NUMBER_CUSTOMER_TRANSACTIONS("SELECT SUM(AmountCharge) FROM CustomerTransaction as CT WHERE YEAR(CT.Date) = YEAR(CURRENT_DATE);"),
    SELECT_SERVICE_TRANSACTION_COUNT_MONTH("SELECT COUNT(*) FROM CustomerTransaction as CT WHERE MONTH(CT.Date) = MONTH(CURRENT_DATE);"),
    SELECT_AVG_CUSTOMER_SATISFACTION("SELECT S.ServiceID, S.ServiceName, AVG(CT.Satisfaction) FROM CustomerTransaction as CT INNER JOIN Service as S ON S.ServiceID = CT.ServiceID GROUP BY CT.ServiceID;"),
    SELECT_TOTAL_NUMBER_OF_EQUIPMENT_BY_TYPE("SELECT e.Type, COUNT(*) FROM Equipment as e GROUP BY e.Type;"),
    SELECT_EMPLOYEE_SCHEDULES("SELECT E.FirstName, E.LastName, S.StartTime, S.Duration, S.Day FROM Employee as E INNER JOIN EmployeeShift as ES ON E.EmployeeID = ES.EmployeeID INNER JOIN Schedule as S ON S.ScheduleID = ES.ScheduleID;"),
    SELECT_MACHINE_SCHEDULES("SELECT E.EquipmentID, E.Description, E.PurchaseDate, E.Type, EMS.Name, EMS.NextMaintenanceDate, EMS.MaintenancePeriod, EMS.LastMaintenance, EMS.Cost FROM Equipment AS E INNER JOIN EquipmentMaintenanceSchedule AS EMS ON E.EquipmentMaintenanceScheduleID = EMS.EquipmentMaintenanceScheduleID;"),
    SELECT_MACHINE_TIME_IN_MONTHS("SELECT EquipmentID, Description, Type, HoursUsed*0.001368925 as \'Months in use\' FROM Equipment;"),
    SELECT_MACHINE_PERCENT_TIME_USED("SELECT HoursUsed/(DATEDIFF(CURRENT_DATE, PurchaseDate)*24) as 'Percentage time used' FROM Equipment;"),
    SELECT_INVENTORY_BELOW_SAFETY_STOCK_LEVEL("SELECT * FROM CleaningSupply WHERE CurrentInventory < SafetyStockLevel;"),
    SELECT_MOST_USED_CLEANING_SUPPLY("SELECT * FROM Inventory as I INNER JOIN CleaningSupply as CS ON I.InventoryID = CS.InventoryID WHERE I.InventoryID = (SELECT InventoryID FROM CustomerUseInventory as CUI GROUP BY CUI.InventoryID ORDER BY COUNT(*) DESC LIMIT 1) AND I.InventoryCategory = \'CS\';"),
    SELECT_MOST_USED_SERVICE("SELECT * FROM Service AS S WHERE S.ServiceID = (SELECT CS.ServiceID FROM CustomerTransaction as CS GROUP BY CS.ServiceID ORDER BY COUNT(*) DESC LIMIT 1);"),
    FIND_SUPPLIER_PRODUCTS("SELECT SP.SupplierProductID, SP.Name, SP.Description, SP.Price, SP.SupplierID FROM Supplier as S INNER JOIN SupplierProduct as SP ON S.SupplierID = SP.SupplierID WHERE S.SupplierID = ?;");


    private final String query;

    Queries(String query) { this.query = query; }

    public String getString() {
        return this.query;
    }
}