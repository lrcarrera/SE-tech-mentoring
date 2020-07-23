package org.jsqldb.condition;

import java.util.function.Predicate;

import org.jsqldb.meta.Row;

public interface SQLCondition extends Predicate<Row> 
{
}   