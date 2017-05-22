package wdsr.exercise5.databaseProgram;

import wdsr.exercise5.utils.EStringSqlAlterTable;
import wdsr.exercise5.utils.EStringSqlTables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Rafal on 5/22/2017.
 */
public class MakeTables {
    Connection connection;
    PreparedStatement preparedStmt;

    public MakeTables(Connection connection) {
        this.connection = connection;
    }

    public void createTable(String createTableString) {
        try {
            preparedStmt = connection.prepareStatement(createTableString);
            preparedStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createAllTablesFromEStringSqlTables() {
        for(EStringSqlTables eFaculty : EStringSqlTables.values()) {
            createTable(eFaculty.getSql());
        }
        for(EStringSqlAlterTable eAlter : EStringSqlAlterTable.values()) {
            createTable(eAlter.getSql());
        }
    }
}
