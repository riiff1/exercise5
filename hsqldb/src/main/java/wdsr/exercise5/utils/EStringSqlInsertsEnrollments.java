package wdsr.exercise5.utils;

/**
 * Created by Rafal on 5/22/2017.
 */
public enum EStringSqlInsertsEnrollments {
    INSERT_TO_ENROLLMENT1("INSERT INTO Enrollment " +
            "VALUES (1, 1000); "),
    INSERT_TO_ENROLLMENT2("INSERT INTO Enrollment " +
            "VALUES (1, 1002); "),
    INSERT_TO_ENROLLMENT3("INSERT INTO Enrollment " +
            "VALUES (1, 1003); "),
    INSERT_TO_ENROLLMENT4("INSERT INTO Enrollment " +
            "VALUES (1, 1004); "),
    INSERT_TO_ENROLLMENT5("INSERT INTO Enrollment " +
            "VALUES (2, 1002); "),
    INSERT_TO_ENROLLMENT6("INSERT INTO Enrollment " +
            "VALUES (2, 1003); "),
    INSERT_TO_ENROLLMENT7("INSERT INTO Enrollment " +
            "VALUES (4, 1000); "),
    INSERT_TO_ENROLLMENT8("INSERT INTO Enrollment " +
            "VALUES (4, 1002); "),
    INSERT_TO_ENROLLMENT9("INSERT INTO Enrollment " +
            "VALUES (4, 1003); ");
    String sql;
    private EStringSqlInsertsEnrollments(String s) {
        sql = s;
    }

    public String getSql() {
        return sql;
    }
}
