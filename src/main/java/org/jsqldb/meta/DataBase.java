package org.jsqldb.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DataBase {
    private final Map<String, Table> database;

    public DataBase() {
        database = new HashMap<>(); // Bad chose...
    }

    public void addTable(Table table) {
        Objects.requireNonNull(table);
        database.put(table.getName(), table);
    }

    public Table getTable(String name) {
        return database.get(name);
    }
}