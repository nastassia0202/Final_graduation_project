package tests.database;

import baseEntities.BaseDBTest;
import dbEntries.InvoicesTable;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class dbTests extends BaseDBTest {
    public static Logger logger = Logger.getLogger(dbTests.class);

    @Test
    public void firstTest() {
        InvoicesTable invoicesTable = new InvoicesTable(dataBaseService);

        ResultSet resultSet = invoicesTable.getInvoicesByID(1);

        try {
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String service_option = resultSet.getString("service_option");
                String account_number = resultSet.getString("account_number");
                String amount = resultSet.getString("amount");
                String payment_purpose = resultSet.getString("payment_purpose");


                System.out.println("userid: " + id);
                System.out.println("service_option: " + service_option);
                System.out.println("account_number: " + account_number);
                System.out.println("amount: " + amount);
                System.out.println("payment_purpose: " + payment_purpose);

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }



}
