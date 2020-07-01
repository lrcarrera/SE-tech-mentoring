package org.jsqldb.meta;

import java.util.HashMap;
import java.util.Map;

public class Row {

    private final Map<String, Object> row;

    public Row() {
        row = new HashMap<>();
    }

    public void set(String name, Object value) {
        row.put(name, value);
    }

    public Object get(String name) {
        return row.get(name);
    }
}