package wdsr.exercise5.utils;

/**
 * Created by Rafal on 5/30/2017.
 */
public enum ETableName {
    STUDENT(5),
    ENROLLMENT(2),
    FACULTY(2),
    CLAZZ(3);

    int tableCount;
    private ETableName(int s) {
        tableCount = s;
    }

    public int getTableCount() {
        return tableCount;
    }
}
