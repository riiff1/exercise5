package wdsr.exercise5.databaseProgram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wdsr.exercise5.DatabaseConnection;
import wdsr.exercise5.utils.EQueriesToTasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rafal on 5/22/2017.
 */
public class SelectFromDatabase {
    private static final Logger log = LoggerFactory.getLogger(SelectFromDatabase.class);
    private Connection connection;

    public SelectFromDatabase(Connection connection) {
        this.connection = connection;
    }

    public ResultSet runSql(String sqlSelectString) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectString);
            ResultSet rs = preparedStatement.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void runTasksFrom1To3(EQueriesToTasks eQueriesToTasks) {
        ResultSet rs = runSql(eQueriesToTasks.getSql());
        try {
            log.info(eQueriesToTasks + ": ");
            while (rs.next()) {
                String pkey = rs.getString("pkey");
                String studentName = rs.getString("name");
                log.info("pkey= " + pkey + ", name= " + studentName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void runTasksFrom4(EQueriesToTasks eQueriesToTasks) {
        ResultSet rs = runSql(eQueriesToTasks.getSql());
        try {
            log.info(eQueriesToTasks + ": ");
            while (rs.next()) {
                String facultyName = rs.getString("NAME");
                log.info("facultyName= " + facultyName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void runTasksFrom5(EQueriesToTasks eQueriesToTasks) {
        ResultSet rs = runSql(eQueriesToTasks.getSql());
        try {
            log.info(eQueriesToTasks + ": ");
            while (rs.next()) {
                String studentName = rs.getString("NAME");
                String studentAge = rs.getString("AGE");
                log.info("studentName= " + studentName + ", studentAge= " + studentAge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void runTasksFrom6(EQueriesToTasks eQueriesToTasks) {
        ResultSet rs = runSql(eQueriesToTasks.getSql());
        try {
            log.info(eQueriesToTasks + ": ");
            while (rs.next()) {
                String clazzName = rs.getString("NAME");
                log.info("clazzName= " + clazzName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void runTasksFrom7(EQueriesToTasks eQueriesToTasks) {
        ResultSet rs = runSql(eQueriesToTasks.getSql());
        try {
            log.info(eQueriesToTasks + ": ");
            while (rs.next()) {
                String studentLevel = rs.getString("LEVEL");
                String studentAvg = rs.getString("ag");
                log.info("studentLevel= " + studentLevel + ", studentAvg= " + studentAvg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void takeTasksFrom1To3() {
        runTasksFrom1To3(EQueriesToTasks.TASK1);
        runTasksFrom1To3(EQueriesToTasks.TASK2);
        runTasksFrom1To3(EQueriesToTasks.TASK3);
    }

    public void takeTasksFrom1To4() {
        runTasksFrom4(EQueriesToTasks.TASK4);
    }

    public void takeTasksFrom1To5() {
        runTasksFrom5(EQueriesToTasks.TASK5);
    }

    public void takeTasksFrom1To6() {
        runTasksFrom6(EQueriesToTasks.TASK6);
    }

    public void takeTasksFrom1To7() {
        runTasksFrom7(EQueriesToTasks.TASK7);
    }
}
