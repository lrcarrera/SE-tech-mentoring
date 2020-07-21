package org.jsqldb.query;

import org.jsqldb.meta.DataBase;
import org.jsqldb.meta.Table;

/**```sql
CREATE TABLE '<table_name>' (
    '<field_name_1>' '<data_type>',
    ...
    '<field_name_n>' '<data_type>'
);
```*/
public class CreateQuery implements Query {
    private final DataBase db;
    private Table table;

    public CreateQuery(final DataBase db)
    {
        this.db = db;
    }

    @Override
    public Table execute() {
        final Table result = db.getTable(this.table.getName());
        return result;
    }
}