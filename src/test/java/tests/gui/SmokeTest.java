package tests.gui;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import pages.InvoiceAddPage;
import pages.PayersImportPage;

import static constant.EndPointsUrl.*;
import static core.DriverService.open;


public class SmokeTest extends BaseTest {

    @Test
    public void addInvoiceTest() throws InterruptedException {
        open(ADD_INVOICE_PAGE);
        InvoiceAddPage invoiceAddPage = new InvoiceAddPage();
        invoiceAddPage.addInvoice(invoiceAddPage.getInvoice());
        Thread.sleep(8000);

    }


    @Test
    public void cancerInvoiceTest(){

    }

    @Test
    public void callPopUpTest(){
        open(PAYERS_IMPORT_PAGE);
        PayersImportPage payersImportPage = new PayersImportPage();
        payersImportPage.callPopup();
        payersImportPage.getErrorPopup().should(Condition.visible);
    }




}
