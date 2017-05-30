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
        //Ponizsze zakomentowane linijki sluza do wpisywania do tabel poprzez prepareStatment. Zostaly one zakomentowane,
        //aby nie zaburzyc wynikow dla konkretnych danych z prezentacji.
        //One dzialaja. W celu srpawdzenia zaleca sie odpalic jeszcze raz Pana baze i oczywiscie odkomentowac te linijki.
/*        insertToTables.insertToDatabase(ETableName.STUDENT,"5","Rafal testt","male","99","4");
        insertToTables.insertToDatabase(ETableName.STUDENT,"6","testt testt","male","test","4");
        insertToTables.insertToDatabase(ETableName.STUDENT,"7","testt");*/
        SelectFromDatabase selectFromDatabase = new SelectFromDatabase(connection);
        selectFromDatabase.takeTasksFrom1To3();
        selectFromDatabase.takeTasksFrom1To4();
        selectFromDatabase.takeTasksFrom1To5();
        selectFromDatabase.takeTasksFrom1To6();
        selectFromDatabase.takeTasksFrom1To7();
    }
}
