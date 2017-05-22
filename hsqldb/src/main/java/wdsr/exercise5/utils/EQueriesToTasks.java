package wdsr.exercise5.utils;

/**
 * Created by Rafal on 5/22/2017.
 */
public enum EQueriesToTasks {
    TASK1("SELECT PKEY, NAME " +
            "FROM STUDENT;"),
    TASK2("SELECT PKEY, NAME " +
            "FROM STUDENT " +
            "where PKEY not in (SELECT DISTINCT s.PKEY " +
            "                   FROM STUDENT s " +
            "                     JOIN ENROLLMENT e ON s.PKEY = e.FKEY_STUDENT);"),
    TASK3("SELECT PKEY, NAME " +
            "FROM STUDENT s " +
            "JOIN ENROLLMENT e ON s.PKEY = e.FKEY_STUDENT " +
            "JOIN CLAZZ c ON e.FKEY_CLAZZ = c.PKEY " +
            "where s.SEX = 'female' and c.PKEY = 1002;"),
    TASK4("SELECT f.NAME " +
            "FROM CLAZZ c " +
            "  JOIN FACULTY f ON c.FKEY_FACULTY = f.PKEY " +
            "where c.PKEY not in (SELECT FKEY_CLAZZ " +
            "                   FROM ENROLLMENT);"),
    TASK5("SELECT s.NAME, s.AGE " +
            "FROM STUDENT s " +
            "JOIN ENROLLMENT e ON s.PKEY = e.FKEY_STUDENT " +
            "JOIN CLAZZ c ON e.FKEY_CLAZZ = c.PKEY " +
            "where c.PKEY = 1000 " +
            "ORDER BY  s.AGE DESC " +
            "LIMIT 1;"),
    TASK6("SELECT NAME " +
            "FROM CLAZZ " +
            "WHERE PKEY in (SELECT FKEY_CLAZZ " +
            "               FROM ENROLLMENT " +
            "               GROUP BY FKEY_CLAZZ " +
            "               HAVING count(FKEY_CLAZZ) > 1);"),
    TASK7("SELECT LEVEL, avg(AGE) as ag " +
            "FROM STUDENT " +
            "where LEVEL in (SELECT DISTINCT LEVEL " +
            "               FROM STUDENT) " +
            "GROUP BY LEVEL;");

    String sql;
    private EQueriesToTasks(String s) {
        sql = s;
    }

    public String getSql() {
        return sql;
    }
}
