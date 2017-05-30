package wdsr.exercise5.databaseProgram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wdsr.exercise5.Main;
import wdsr.exercise5.utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Rafal on 5/22/2017.
 */
public class InsertToTables {
    private Connection connection;
    private PreparedStatement preparedStmt;
    private static final Logger log = LoggerFactory.getLogger(InsertToTables.class);

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

    public void insertToDatabase(ETableName tableName, String... argsFromLeftTORight) {
        if(argsFromLeftTORight.length != tableName.getTableCount()) {
            log.info("Niepoprawna ilosc argumentow dla tabeli: " + tableName + ". Poprawna ilosc argumentow to: " + tableName.getTableCount());
        } else if(!correctArgumentsType(tableName, argsFromLeftTORight)) {
            log.info("Niepoprawny typ argumentow dla tabeli: " + tableName);
        }
        else {
            switch (tableName) {
                case STUDENT :
                    try {
                        preparedStmt = connection.prepareStatement(EInsertToDatabaseUsingPrepareStmt.INSERT_TO_STUDENT.getSql());
                        preparedStmt.setInt(1, Integer.parseInt(argsFromLeftTORight[0]));
                        preparedStmt.setString(2,argsFromLeftTORight[1]);
                        preparedStmt.setString(3,argsFromLeftTORight[2]);
                        preparedStmt.setInt(4,Integer.parseInt(argsFromLeftTORight[3]));
                        preparedStmt.setInt(5,Integer.parseInt(argsFromLeftTORight[4]));
                        preparedStmt.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case ENROLLMENT:
                    try {
                        preparedStmt = connection.prepareStatement(EInsertToDatabaseUsingPrepareStmt.INSERT_TO_STUDENT.getSql());
                        preparedStmt.setInt(1,Integer.parseInt(argsFromLeftTORight[0]));
                        preparedStmt.setInt(2,Integer.parseInt(argsFromLeftTORight[1]));
                        preparedStmt.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case FACULTY:
                    try {
                        preparedStmt = connection.prepareStatement(EInsertToDatabaseUsingPrepareStmt.INSERT_TO_STUDENT.getSql());
                        preparedStmt.setInt(1, Integer.parseInt(argsFromLeftTORight[0]));
                        preparedStmt.setString(2,argsFromLeftTORight[1]);
                        preparedStmt.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case CLAZZ:
                    try {
                        preparedStmt = connection.prepareStatement(EInsertToDatabaseUsingPrepareStmt.INSERT_TO_STUDENT.getSql());
                        preparedStmt.setInt(1, Integer.parseInt(argsFromLeftTORight[0]));
                        preparedStmt.setString(2,argsFromLeftTORight[1]);
                        preparedStmt.setInt(3,Integer.parseInt(argsFromLeftTORight[2]));
                        preparedStmt.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    private boolean correctArgumentsType(ETableName tableName, String... argsFromLeftTORight) {
        switch (tableName) {
            case STUDENT :
                try {
                    Integer.parseInt(argsFromLeftTORight[0]);
                    Integer.parseInt(argsFromLeftTORight[3]);
                    Integer.parseInt(argsFromLeftTORight[4]);
                    return true;
                } catch (NumberFormatException e) {
                    log.error("Wrong format: " + e.getMessage());
                }
                break;
            case ENROLLMENT:
                try {
                    Integer.parseInt(argsFromLeftTORight[0]);
                    Integer.parseInt(argsFromLeftTORight[1]);
                    return true;
                } catch (NumberFormatException e) {
                    log.error("Wrong format: " + e.getMessage());
                }
                break;
            case FACULTY:
                try {
                    Integer.parseInt(argsFromLeftTORight[0]);
                    return true;
                } catch (NumberFormatException e) {
                    log.error("Wrong format: " + e.getMessage());
                }
                break;
            case CLAZZ:
                try {
                    Integer.parseInt(argsFromLeftTORight[0]);
                    Integer.parseInt(argsFromLeftTORight[2]);
                    return true;
                } catch (NumberFormatException e) {
                    log.error("Wrong format: " + e.getMessage());
                }
                break;
        }
        return false;
    }
}
