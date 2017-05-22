package wdsr.exercise5.databaseProgram;

import wdsr.exercise5.utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Rafal on 5/22/2017.
 */
public class InsertToTables {
    Connection connection;
    PreparedStatement preparedStmt;

    public InsertToTables(Connection connection) {
        this.connection = connection;
    }

    public void insertToDatabase(String insertToDatabaseString) {
        try {
            preparedStmt = connection.prepareStatement(insertToDatabaseString);
            //preparedStmt.executeUpdate();
            preparedStmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAllDataFromEStringSqlInserts() {
        for(EStringSqlInsertsStudents eStudent : EStringSqlInsertsStudents.values()) {
            insertToDatabase(eStudent.getSql());
        }
        for(EStringSqlInsertsFaculties eFaculty : EStringSqlInsertsFaculties.values()) {
            insertToDatabase(eFaculty.getSql());
        }
        for(EStringSqlInsertsClazz eClazz : EStringSqlInsertsClazz.values()) {
            insertToDatabase(eClazz.getSql());
        }
        for(EStringSqlInsertsEnrollments eEnrollment : EStringSqlInsertsEnrollments.values()) {
            insertToDatabase(eEnrollment.getSql());
        }
    }
}
