package tests.gui;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.InvoiceAddPage;

import java.sql.SQLException;

import static constant.endpoints.EndPointsUrl.ADD_INVOICE_PAGE;
import static core.DriverService.open;


public class SmokeTest extends BaseTest {

    @Test
    public void test1() throws SQLException, InterruptedException {
        open(ADD_INVOICE_PAGE);
        InvoiceAddPage invoiceAddPage = new InvoiceAddPage();
        invoiceAddPage.addInvoice(invoiceAddPage.getInvoice());
        Thread.sleep(8000);

    }




}
