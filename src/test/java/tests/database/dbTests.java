package tests.database;

import baseEntities.BaseDBTest;
import dbEntries.UsersTable;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class dbTests extends BaseDBTest {
    public static Logger logger = Logger.getLogger(dbTests.class);

    @Test
    public void firstTest() {
        UsersTable usersTable = new UsersTable(dataBaseService);

        ResultSet resultSet = usersTable.getAllUsers();

        try {
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");


                logger.info("userid: " + id);
                logger.info("login: " + login);
                logger.info("password: " + password);

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Test
    public void secondTest() {
        UsersTable usersTable = new UsersTable(dataBaseService);

        usersTable.dropTable();
        usersTable.createTable();

        usersTable.addUser("Иван", "Иванов");
        usersTable.addUser("Петр", "Петров");
        usersTable.addUser("Марина", "Стасевич");

        ResultSet resultSet = usersTable.getAllUsers();
        try {
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");


                logger.info("userid: " + id);
                logger.info("login: " + login);
                logger.info("password: " + password);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }
}
