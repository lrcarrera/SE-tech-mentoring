package org.jsqldb;

import org.jsqldb.meta.DataBase;
import org.jsqldb.meta.LongPrimaryKey;
import org.jsqldb.meta.Row;
import org.jsqldb.meta.Table;
import org.jsqldb.query.SelectQuery;

public class App {
    public String getGreeting() {
        return "Hello world.";
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

        SelectQuery query = new SelectQuery(db);
            /*.setWhat({"*"})
            .setFrom(db.getTable("USERS"))
            .setCondition(equals("name", "Ivan"));*/

        Table result = query.execute();
    }
}
