package org.jsqldb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Predicate;

import org.jsqldb.meta.DataBase;
import org.jsqldb.meta.LongPrimaryKey;
import org.jsqldb.meta.Row;
import org.jsqldb.meta.Table;
import org.jsqldb.query.CompositeQuery;
import org.jsqldb.query.Query;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    static interface SQLCondition extends Predicate<Row> {
    }

    static interface Query {
        Table execute();
    }

    static class SelectQuery implements Query {

        public SelectQuery setWhat(Set<String> fields) {
            return this;
        }

        public SelectQuery setFrom(Table table) {
            return this;
        }

        public SelectQuery setFrom(Query subQuery) {
            return this;
        }

        public SelectQuery setCondition(SQLCondition condition) { // AST - `Abstract syntax tree`
            return this;
        }

        @Override
        public Table execute() {
            Table result;
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        /*
         * String script = "CREATE TABLE 'USERS' (" + "id INT NOT NULL AUTO_INCREMENT,"
         * + "name TEXT" + ");" +
         * 
         * "INSERT INTO 'USERS' (name) VALUES ('Oleg', 'Ivan');" +
         * 
         * "SELECT * FROM 'USERS';";
         */

        // StringBuilder contentBuilder = new StringBuilder();
        // try (BufferedReader br = new BufferedReader(new
        // InputStreamReader(System.in)))
        // {

        // String sCurrentLine;
        // while ((sCurrentLine = br.readLine()) != null)
        // {
        // contentBuilder.append(sCurrentLine);
        // }
        // }
        // catch (IOException e)
        // {
        // e.printStackTrace();
        // }

        // List<Query> queries = new ArrayList<>();
        // StringTokenizer tokens = new StringTokenizer(contentBuilder.toString(),";");
        // while (tokens.hasMoreTokens())
        // {
        // String strQuery = tokens.nextToken();
        // queries.add(new Query(strQuery));
        // }

        // CompositeQuery compositeQuery = new CompositeQuery(queries);
        // compositeQuery.executeJSQLDB();

        DataBase db = new DataBase();

        Table table = new Table("USERS");
        {
            Row row = new Row();
            row.set("name", "Oleg");
            row.set("age", 36);
            table.insertRow(new LongPrimaryKey(1), row);
        }

        {
            Row row = new Row();
            row.set("name", "Ivan");
            row.set("age", 26);
            table.insertRow(new LongPrimaryKey(2), row);
        }

        db.addTable(table);

        SelectQuery query = new SelectQuery()
            .setWhat({"*"})
            .setFrom(db.getTable("USERS"))
            .setCondition(equals("name", "Ivan"));

        Table result = query.execute();
    }
}
