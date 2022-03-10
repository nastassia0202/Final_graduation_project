package core;

import org.apache.log4j.Logger;

import java.sql.*;

public class DataBaseService {
    public static Logger logger = Logger.getLogger(DataBaseService.class);

    private static final String DB_URL = "jdbc:postgresql://SG-expresspay-3053-pgsql-master.servers.mongodirector.com:5432/postgres";
    private static final String USER = "sgpostgres";
    private static final String PASSWORD = "8.CB22H9K7tjO2it";

    private Connection connection = null;
    private Statement statement = null;

    public DataBaseService() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.fatal(e.toString());
            return;
        }

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            logger.error(e.toString());
            return;
        }

        if (connection != null) {
            logger.info("Мы подключились к БД...");
        }
    }

    public Statement getStatement() {
        try {
            if (statement == null) {
                statement = connection.createStatement();
            }
        } catch (SQLException e) {
            logger.info(e.toString());
        }

        return statement;
    }

    public void executeSQL(String sql) {
        try {
            logger.info("Результат выполнения запроса: " + getStatement().execute(sql));
        } catch (SQLException e) {
            logger.info(e.toString());
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            return getStatement().executeQuery(sql);
        } catch (SQLException e) {
            logger.info(e.toString());
        }

        return null;
    }

    public void closeStatement() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.info(e.toString());
        }
    }


    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.info(e.toString());
        }
    }
}
