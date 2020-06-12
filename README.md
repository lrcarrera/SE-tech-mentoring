# JSQLDB Engine
SE-tech-mentoring

Write in memory Database.
Database must support the next query types: CREATE TABLE, INSERT, UPDATE, DELETE, SELECT;

Database must support the next datatypes: INT, STRING

```sql
SELECT * FROM '<table_name>' WHERE '<field_name>' = '<value>';
```

```sql
CREATE TABLE '<table_name>' (
    '<field_name_1>' '<data_type>',
    ...
    '<field_name_n>' '<data_type>'
);
```

```sql
INSERT INTO '<table_name>' 
    ('<field_name_1>', ..., '<field_name_n>') 
    VALUES 
    ('<value_1>' ..., '<value_n>');
```

```sql
UPDATE '<table_name>'
    SET '<field_name_1>'='<value_1>', ..., '<field_name_n>'='<value_n>'
    WHERE '<field_name>' = '<value>';
```

```sql
DELETE FROM '<table_name>' WHERE '<field_name>' = '<value>';
```
