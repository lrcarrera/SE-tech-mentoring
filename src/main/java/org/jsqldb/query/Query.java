package org.jsqldb.query;

import org.jsqldb.meta.Table;

public interface Query {
    Table execute();
}