package dbEntries;

import core.DataBaseService;
import org.apache.log4j.Logger;

import java.sql.ResultSet;

public class InvoicesTable {
    public static Logger logger = Logger.getLogger(InvoicesTable.class);

    DataBaseService dataBaseService;

    public InvoicesTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }


    public void createTable() {
        logger.info("Создаем таблицу invoices");

        String createTableSQL = "CREATE TABLE invoices (" +
                "id SERIAL PRIMARY KEY, " +
                "login CHARACTER VARYING(30), " +
                "password CHARACTER VARYING(30), " +
                ");";
        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем таблицу invoices");

        String dropTableUsersSQL = "DROP TABLE invoices;";

        dataBaseService.executeSQL(dropTableUsersSQL);
    }

    public ResultSet getAllInvoices() {
        logger.info("Получаем все записи из таблицы invoices");

        String sql = "SELECT * FROM invoices ORDER BY id ASC;";

        return dataBaseService.executeQuery(sql);
    }

    public ResultSet getInvoicesByID(int id) {
        String sql = "SELECT * FROM invoices WHERE id = " + id + ";";

        return dataBaseService.executeQuery(sql);
    }

    public void addInvoices(String login, String password) {
        logger.info("Добавляем запись в таблицу invoices");

        String insertTableSQL = "INSERT INTO public.invoices(" +
                "login, password)" +
                "VALUES ('" + login + "', '" + password +");";

        dataBaseService.executeSQL(insertTableSQL);
    }
}
