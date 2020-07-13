package org.jsqldb;

import org.jsqldb.meta.DataBase;
import org.jsqldb.meta.Table;
import org.jsqldb.query.SelectQuery;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

public class SelectQueryTest {

    @Test
    public void testSetWhat() {
        final DataBase db = new DataBase();
        final Set<String> fields = new HashSet();
        final String columnName = "column1";
        fields.add(columnName);

        final SelectQuery select = new SelectQuery(db);
        select.setWhat(fields);

        assertTrue(select.getWhat().contains(columnName));
    }

    @Test
    public void testSetFrom() {
        final String tableName = "table1";
        final String columnName = "column1";
        final DataBase db = new DataBase();
        final Table t1 = new Table(tableName);
        final Set<String> fields = new HashSet();
        db.addTable(t1);
        fields.add(columnName);

        final SelectQuery select1 = new SelectQuery(db);
        select1.setWhat(fields);
        select1.setFrom(t1);
        assertEquals(select1.getFromTable().getName(), tableName);

        final SelectQuery select2 = new SelectQuery(db);
        final SelectQuery subQuery = new SelectQuery(db);
        select2.setWhat(fields);
        select2.setFrom(subQuery);
        select2.setCondition(null); // where clause null
        assertTrue(select2.getFromSubQuery().equals(subQuery));
    }

   /* @Test
    public SelectQuery testSetCondition(SQLCondition condition) { // AST - `Abstract syntax tree`
        this.condition = condition;
        return this;
    }

    @Test
    public Table testExecute() {
        Table table = db.getTable(this.table.getName());

        SelectQuery query = new SelectQuery();
        .setWhat(fields)
        .setFrom(db.getTable("USERS"))
        .setCondition(equals("name", "Ivan"));

        Table result = query.execute();

        return result;
    }*/
}