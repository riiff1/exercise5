package wdsr.exercise5.utils;

/**
 * Created by Rafal on 5/30/2017.
 */
public enum EInsertToDatabaseUsingPrepareStmt {
    INSERT_TO_Clazz("INSERT INTO Clazz " +
            "VALUES (?, ?, ?); "),
    INSERT_TO_STUDENT("INSERT INTO Student " +
            "VALUES (?, ?, ?, ?, ?); "),
    INSERT_TO_ENROLLMENT("INSERT INTO Enrollment " +
            "VALUES (?, ?); "),
    INSERT_TO_FACULTY("INSERT INTO Faculty " +
            "VALUES (?, ?); ");
    String sql;
    private EInsertToDatabaseUsingPrepareStmt(String s) {
        sql = s;
    }

    public String getSql() {
        return sql;
    }
}
