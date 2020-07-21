package org.jsqldb.query;

import org.jsqldb.meta.DataBase;
import org.jsqldb.meta.Table;

/**```sql
UPDATE '<table_name>'
    SET '<field_name_1>'='<value_1>', ..., '<field_name_n>'='<value_n>'
    WHERE '<field_name>' = '<value>';
``` */
public class UpdateQuery implements Query {
    private final DataBase db;
    private Table table;

    public UpdateQuery(final DataBase db)
    {
        this.db = db;
    }

    @Override
    public Table execute() {
        final Table result = db.getTable(this.table.getName());
        return result;
    }
}