package org.jsqldb.query;

public class Query implements Script 
{
    String content;
    String result;

    public String executeJSQLDB()
    {
        //TODO: implement query execution
        return null;
    }

    public Query(String content) {
        this.content = content;
    }
}