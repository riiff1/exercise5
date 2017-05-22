package wdsr.exercise5.utils;

/**
 * Created by Rafal on 5/22/2017.
 */
public enum EStringSqlInsertsFaculties {
    INSERT_TO_FACULTY1("INSERT INTO Faculty " +
            "VALUES (100, 'Engineering'); "),
    INSERT_TO_FACULTY2("INSERT INTO Faculty " +
            "VALUES (101, 'Philosophy'); "),
    INSERT_TO_FACULTY3("INSERT INTO Faculty " +
            "VALUES (102, 'Law and administration'); "),
    INSERT_TO_FACULTY4("INSERT INTO Faculty " +
            "VALUES (103, 'Languages'); ");
    String sql;
    private EStringSqlInsertsFaculties(String s) {
        sql = s;
    }

    public String getSql() {
        return sql;
    }
}
