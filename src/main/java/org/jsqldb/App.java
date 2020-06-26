package org.jsqldb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.jsqldb.query.CompositeQuery;
import org.jsqldb.query.Query;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) throws Exception {
        
        /*String script = "CREATE TABLE 'USERS' (" +
            "id INT NOT NULL AUTO_INCREMENT," +
            "name TEXT" +
        ");" +
        
        "INSERT INTO 'USERS' (name) VALUES ('Oleg', 'Ivan');" +
        
        "SELECT * FROM 'USERS';";*/

        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) 
        {
 
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) 
            {
                contentBuilder.append(sCurrentLine);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

        List<Query> queries = new ArrayList<>();
        StringTokenizer tokens = new StringTokenizer(contentBuilder.toString(),";");
        while (tokens.hasMoreTokens()) 
        {
            String strQuery = tokens.nextToken();
            queries.add(new Query(strQuery));
        }

        CompositeQuery compositeQuery = new CompositeQuery(queries);
        compositeQuery.executeJSQLDB();
    }
}
