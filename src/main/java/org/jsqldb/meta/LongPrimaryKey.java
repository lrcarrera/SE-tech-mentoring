package org.jsqldb.meta;

public class LongPrimaryKey implements PrimaryKey<Long> {

    private final long value;

    public LongPrimaryKey(long value) {
        this.value = value;
    }

    @Override
    public int compareTo(Long rhs) {
        return Long.compare(value, rhs);
    }

}