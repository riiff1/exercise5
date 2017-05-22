package wdsr.exercise5.utils;

/**
 * Created by Rafal on 5/19/2017.
 */
public enum EStringSqlTables {
    CREATE_TABLE_STUDENT("CREATE TABLE Student (" +
            "pkey INTEGER NOT NULL, " +
            "name VARCHAR(50), " +
            "sex VARCHAR(6), " +
            "age INTEGER, " +
            "level INTEGER, " +
            "PRIMARY KEY (pkey) " +
            ");"),
    CREATE_TABLE_FACULTY("CREATE TABLE Faculty (" +
            "pkey INTEGER NOT NULL, " +
            "name VARCHAR(50), " +
            "PRIMARY KEY (pkey) " +
            ");"),
    CREATE_TABLE_ENROLLMENT("CREATE TABLE Enrollment (" +
            "fkey_student INTEGER, " +
            "fkey_clazz INTEGER, " +
            ");"),
    CREATE_TABLE_CLAZZ("CREATE TABLE Clazz (" +
            "pkey INTEGER NOT NULL, " +
            "name VARCHAR(50), " +
            "fkey_faculty INTEGER, " +
            "PRIMARY KEY (pkey) " +
            ");");

    String sql;
    private EStringSqlTables(String s) {
        sql = s;
    }

    public String getSql() {
        return sql;
    }
}
