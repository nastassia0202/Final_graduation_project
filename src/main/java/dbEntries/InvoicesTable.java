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
        logger.info("Создаем таблицу Invoices");

        String createTableSQL = "CREATE TABLE invoices (" +
                "id SERIAL PRIMARY KEY, " +
                "service_option CHARACTER VARYING(30), " +
                "account_number BIGINT, " +
                "amount INTEGER, " +
                "payment_purpose CHARACTER VARYING(100), " +
                ");";
        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем таблицу invoices");

        String dropTableInvoicesSQL = "DROP TABLE invoices;";

        dataBaseService.executeSQL(dropTableInvoicesSQL);
    }

    public ResultSet getAllInvoices() {
        logger.info("Получаем все записи из таблицы Invoices");

        String sql = "SELECT * FROM invoices ORDER BY id ASC;";

        return dataBaseService.executeQuery(sql);
    }

    public ResultSet getInvoicesByID(int id) {
        String sql = "SELECT * FROM invoices WHERE id = " + id + ";";

        return dataBaseService.executeQuery(sql);
    }

    public void addInvoices(String service_option, int account_number,int amount, String payment_purpose ) {
        logger.info("Добавляем запись в таблицу Invoices");

        String insertTableSQL = "INSERT INTO public.invoices(" +
                "service_option, account_number,amount,payment_purpose)" +
                "VALUES ('" + service_option + "', '"+ account_number + "', '"+ amount + "', '" + payment_purpose +");";

        dataBaseService.executeSQL(insertTableSQL);
    }
}
