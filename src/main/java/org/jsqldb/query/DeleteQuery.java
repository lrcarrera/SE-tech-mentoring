package org.jsqldb.query;

import org.jsqldb.meta.DataBase;
import org.jsqldb.meta.Table;

/**```sql
DELETE FROM '<table_name>' WHERE '<field_name>' = '<value>';
``` */
public class DeleteQuery implements Query {
    private final DataBase db;
    private Table table;

    public DeleteQuery(final DataBase db)
    {
        this.db = db;
    }

    @Override
    public Table execute() {
        final Table result = db.getTable(this.table.getName());
        return result;
    }
}