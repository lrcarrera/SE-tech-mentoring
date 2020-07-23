package org.jsqldb;

import org.jsqldb.condition.SQLConditionImpl;
import org.jsqldb.meta.DataBase;
import org.jsqldb.meta.Row;
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
        select1.setWhat(fields).setFrom(t1);
        assertEquals(select1.getFromTable().getName(), tableName);

        final SelectQuery select2 = new SelectQuery(db);
        final SelectQuery subQuery = new SelectQuery(db);
        select2.setWhat(fields).setFrom(subQuery).setCondition(null); // where clause null
        assertTrue(select2.getFromSubQuery().equals(subQuery));
    }

   @Test
    public SelectQuery testSetCondition() {
        final String tableName = "table1";
        final String columnName = "column1";
        final DataBase db = new DataBase();
        final Table t1 = new Table(tableName);
        final Set<String> fields = new HashSet();
        final Row row = new Row();
        row.set("name", "value");
        t1.insertRow(new LongPrimaryKey(123L), row);
        db.addTable(t1);
        fields.add(columnName);

       
        SQLConditionImpl condition = new SQLConditionImpl(row.get("name"));

        final SelectQuery select1 = new SelectQuery(db);
        select1.setWhat(fields).setFrom(t1).setCondition(condition);
        assertEquals(select1.getFromTable().getName(), tableName);

        
        /*Predicate<Row> predicate = row -> row.get("name");
        this.condition = condition;
        return this;*/
    }

    @Test
    public Table testExecute() {
        Table table = db.getTable(this.table.getName());
        final Row row = new Row();
        row.set("name", "value");

        SelectQuery query = new SelectQuery()
        .setWhat(fields)
        .setFrom(db.getTable("USERS"))
        .setCondition(row -> row.get("name"));

        Table result = query.execute();

        return result;
    }
}