package core;

public enum Queries {

    SELECT_ALL_FROM_ALL("SELECT * From *"),
    EXAMPLE_QUERY("aaa");

    private final String query;

    Queries(String query) { this.query = query; }

    public String getString() {
        return this.query;
    }
}