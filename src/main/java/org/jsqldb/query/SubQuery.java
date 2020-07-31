package org.jsqldb.query;

import org.jsqldb.from.FromSelectable;

public class SubQuery implements FromSelectable
{
    String subQuery;

    public SubQuery(String subQuery)
    {
        this.subQuery = subQuery;
    }

    public String getSubQuery(){
        return this.subQuery;
    }
}