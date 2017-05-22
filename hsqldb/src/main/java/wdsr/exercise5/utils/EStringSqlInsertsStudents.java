package wdsr.exercise5.utils;

/**
 * Created by Rafal on 5/19/2017.
 */
public enum EStringSqlInsertsStudents {

    INSERT_TO_STUDENT1("INSERT INTO Student " +
            "VALUES (1, 'John Smith', 'male', 23, 2); "),
    INSERT_TO_STUDENT2("INSERT INTO Student " +
            "VALUES (2, 'Rebecca Milson', 'female', 27, 3); "),
    INSERT_TO_STUDENT3("INSERT INTO Student " +
            "VALUES (3, 'George Heartbreaker', 'male', 19, 1); "),
    INSERT_TO_STUDENT4("INSERT INTO Student " +
            "VALUES (4, 'Deepika Chopra', 'female', 25, 3); ");
    String sql;
    private EStringSqlInsertsStudents(String s) {
        sql = s;
    }

    public String getSql() {
        return sql;
    }
}
