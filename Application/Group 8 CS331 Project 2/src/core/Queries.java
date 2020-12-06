package core;

public enum Queries {

    SELECT_ALL_FROM_ALL("SELECT * From *"),
    ANNUAL_EXPENSE_CleaningSupply("SELECT SUM(QuantityPurchased*AmountDue) as 'Annual Expense from Cleaning Supplies' FROM SupplierTransaction as ST INNER JOIN Inventory as I ON ST.InventoryID = I.InventoryID WHERE I.InventoryCategory = 'CS' AND YEAR(TransactionDate) = YEAR(CURRENT_DATE);"),
    USER_PASS("SELECT * FROM User WHERE Username = ? AND Password = ?"),
    EXAMPLE_QUERY("aaa");

    private final String query;

    Queries(String query) { this.query = query; }

    public String getString() {
        return this.query;
    }
}