package org.jsqldb.condition;

import java.util.function.Predicate;

import org.jsqldb.meta.Row;

public class SQLConditionImpl implements SQLCondition {

    private Predicate<Row> predicate;

    public SQLConditionImpl(Predicate<Row> predicate)
    {
        this.predicate = predicate;
    }

    @Override
    public boolean test(Row t) {
        return predicate.test(t);
    }
}