package org.jsqldb.query;

import java.util.Set;

import org.jsqldb.condition.SQLCondition;
import org.jsqldb.from.FromSelectable;
import org.jsqldb.from.SQLFrom;

import org.jsqldb.meta.DataBase;
import org.jsqldb.meta.Table;

/**```sql
SELECT * FROM '<table_name>' WHERE '<field_name>' = '<value>';
``` */
public class SelectQuery implements Query, FromSelectable{

    private final DataBase db;
    private Set<String> fields;
    private SQLFrom from;
    private SQLCondition condition;

    public SelectQuery(final DataBase db)
    {
        this.db = db;
    }

    @Override
    public Table execute() {
        //final Table result = db.getTable(this.table.getName());//TODO: how is implemented the execute method?
        return null;
    }

    public SelectQuery setWhat(final Set<String> fields) {
        if (fields != null && fields.size() > 0) {
            this.fields = fields;
            return this;
        }
        throw new IllegalArgumentException("Must contain a valid string fields");
    }

    public SelectQuery setFrom(final SQLFrom from) {
        if (from != null)
        {
            this.from = from;
            return this;
        }
        throw new IllegalArgumentException("No table has been found or select fields are not present");
    }

    public SelectQuery setCondition(final SQLCondition condition) { // AST - `Abstract syntax tree`
        this.condition = condition;
        return this;
    }

    public Set<String> getWhat() {
        return fields;
    }

    public SQLFrom getFromTable() {
        return from;
    }
    public SQLCondition getCondition() {
        return condition;
    }
}