package wdsr.exercise5.databaseProgram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wdsr.exercise5.DatabaseConnection;
import wdsr.exercise5.utils.*;

import java.sql.Connection;

/**
 * Created by Rafal on 5/18/2017.
 */
public class Mainek {
    private static final Logger log = LoggerFactory.getLogger(Mainek.class);
    public static void main(String[] args) {
        DatabaseConnection dbConn = DatabaseConnection.getInstance();
        Connection connection = dbConn.createConnection("SA", "");
        MakeTables makeTables = new MakeTables(connection);
        makeTables.createAllTablesFromEStringSqlTables();
        InsertToTables insertToTables = new InsertToTables(connection);
        insertToTables.insertAllDataFromEStringSqlInserts();
        SelectFromDatabase selectFromDatabase = new SelectFromDatabase(connection);
        selectFromDatabase.takeTasksFrom1To3();
        selectFromDatabase.takeTasksFrom1To4();
        selectFromDatabase.takeTasksFrom1To5();
        selectFromDatabase.takeTasksFrom1To6();
        selectFromDatabase.takeTasksFrom1To7();
    }
}
