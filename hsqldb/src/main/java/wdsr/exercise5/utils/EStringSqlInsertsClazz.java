package wdsr.exercise5.utils;

/**
 * Created by Rafal on 5/22/2017.
 */
public enum EStringSqlInsertsClazz {
    INSERT_TO_Clazz1("INSERT INTO Clazz " +
            "VALUES (1000, 'Introduction to labour law', 102); "),
    INSERT_TO_Clazz2("INSERT INTO Clazz " +
            "VALUES (1001, 'Graph algorithms', 100); "),
    INSERT_TO_Clazz3("INSERT INTO Clazz " +
            "VALUES (1002, 'Existentialism in 20th century', 101); "),
    INSERT_TO_Clazz4("INSERT INTO Clazz " +
            "VALUES (1003, 'English grammar', 103); "),
    INSERT_TO_Clazz5("INSERT INTO Clazz " +
            "VALUES (1004, 'From Plato to Kant', 101); ");
    String sql;
    private EStringSqlInsertsClazz(String s) {
        sql = s;
    }

    public String getSql() {
        return sql;
    }

}
