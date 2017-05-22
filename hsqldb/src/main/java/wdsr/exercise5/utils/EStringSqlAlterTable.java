package wdsr.exercise5.utils;

/**
 * Created by Rafal on 5/22/2017.
 */
public enum EStringSqlAlterTable {
    ALTER_TABLE_ENROLLMENT1("ALTER TABLE Enrollment ADD FOREIGN KEY (fkey_student) REFERENCES Student(pkey);"),
    ALTER_TABLE_ENROLLMENT2("ALTER TABLE Enrollment ADD FOREIGN KEY (fkey_clazz) REFERENCES Clazz(pkey);"),
    ALTER_TABLE_CLAZZ1("ALTER TABLE Clazz ADD FOREIGN KEY (fkey_faculty) REFERENCES Faculty(pkey);");

    String sql;
    private EStringSqlAlterTable(String s) {
        sql = s;
    }

    public String getSql() {
        return sql;
    }
}
