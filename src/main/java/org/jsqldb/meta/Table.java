package org.jsqldb.meta;

import java.util.HashMap;
import java.util.Map;

public class Table {

    private final String name;
    private final Map<PrimaryKey<?>, Row> table;

    public Table(String name) {
        this.name = name;
        this.table = new HashMap<>(); // Bad chose...
    }

    public String getName() {
        return name;
    }

    public void insertRow(PrimaryKey<?> key, Row row) {
        // todo: some checks
        table.put(key, row);
    }

    public Row getRow(PrimaryKey<?> key) {
        return table.get(key);
    }

}