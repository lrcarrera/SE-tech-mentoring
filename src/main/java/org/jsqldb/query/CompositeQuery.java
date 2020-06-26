package org.jsqldb.query;

import java.util.ArrayList;
import java.util.List;

public class CompositeQuery implements Script 
{
    private List<Query> queries;
    private String result;
    
    public String executeJSQLDB()
    {
        for (Query query : queries)
        {
            result += query.executeJSQLDB();
        }
        return result;
    }

    public CompositeQuery(List<Query> queries) {
        this.queries = queries;
    }

    public List<Query> getQueries()
    {
        return new ArrayList<>(queries);
    }
}