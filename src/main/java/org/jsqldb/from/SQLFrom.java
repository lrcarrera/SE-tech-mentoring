package org.jsqldb.from;

import org.jsqldb.meta.Table;
import org.jsqldb.query.SubQuery;
import org.jsqldb.query.SelectQuery;

import org.jsqldb.from.FromSelectable;

public class SQLFrom {

    private Table table;
    private SelectQuery selectQuery;
    private SubQuery subQuery;

    public SQLFrom(Table table)
    { 
        this.table = table;
        this.selectQuery = null;
        this.subQuery = null;
    }

    public SQLFrom(SelectQuery selectQuery)
    { 
        this.selectQuery = selectQuery;
        this.table = null;
        this.subQuery = null;
    }

    public SQLFrom(SubQuery subQuery)
    { 
        this.subQuery = subQuery;
        this.table = null;
        this.selectQuery = null;
    }

    public FromSelectable get()
    {
        if (this.table != null)
        {
            return this.table;
        }
        if (this.selectQuery != null)
        {
            return this.selectQuery;
        }
        if (this.subQuery != null)
        {
            return this.subQuery;
        }
        throw new IllegalArgumentException("No from statement has been declared yet");
    }
}