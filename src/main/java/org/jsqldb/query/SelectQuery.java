package org.jsqldb.query;

import java.util.Set;

import org.jsqldb.meta.DataBase;
import org.jsqldb.meta.Table;

public class SelectQuery implements Query {

    private final DataBase db;
    private Set<String> fields;
    private Table table;
    private Query subQuery;
    private SQLCondition condition;

    public SelectQuery(final DataBase db)
    {
        this.db = db;
    }

    @Override
    public Table execute() {
        final Table result = db.getTable(this.table.getName());
        return result;
    }

    public SelectQuery setWhat(final Set<String> fields) {
        if (fields != null && fields.size() > 0) {
            this.fields = fields;
            return this;
        }
        throw new IllegalArgumentException("Must contain a valid string fields");
    }

    public SelectQuery setFrom(final Table table) {
        final Table existingTable = db.getTable(table.getName());
        if (this.fields != null && existingTable != null)
        {
            this.table = existingTable;
            return this;
        }
        throw new IllegalArgumentException("No table has been found or select fields are not present");
    }

    public SelectQuery setFrom(final Query subQuery) {
        this.subQuery = subQuery;
        return this;
    }

    public SelectQuery setCondition(final SQLCondition condition) { // AST - `Abstract syntax tree`
        this.condition = condition;
        return this;
    }

    public Set<String> getWhat() {
        return fields;
    }

    public Table getFromTable() {
        return table;
    }

    public Query getFromSubQuery() {
        return subQuery;
    }

    public SQLCondition getCondition() {
        return condition;
    }
}