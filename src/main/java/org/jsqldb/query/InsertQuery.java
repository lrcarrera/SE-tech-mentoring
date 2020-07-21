package org.jsqldb.query;

import org.jsqldb.meta.DataBase;
import org.jsqldb.meta.Table;

/**```sql
INSERT INTO '<table_name>' 
    ('<field_name_1>', ..., '<field_name_n>') 
    VALUES 
    ('<value_1>' ..., '<value_n>');
```*/
public class InsertQuery implements Query {
    private final DataBase db;
    private Table table;

    public InsertQuery(final DataBase db)
    {
        this.db = db;
    }

    @Override
    public Table execute() {
        final Table result = db.getTable(this.table.getName());
        return result;
    }
}