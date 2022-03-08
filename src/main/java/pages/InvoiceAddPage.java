package pages;



import com.codeborne.selenide.SelenideElement;
import core.DataBaseService;
import dbEntries.InvoicesTable;
import model.Invoice;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;


import java.sql.ResultSet;
import java.sql.SQLException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class InvoiceAddPage{
    protected DataBaseService dataBaseService;
    public static Logger logger = Logger.getLogger(InvoiceAddPage.class);
    private final SelenideElement PAGE_OPENED_IDENTIFIER = $x("//h1[.='Выставить новый счет']");
    private final SelenideElement servicesDropDown = $x("//div[@class='col-md-5']//span[@class='k-input']");
    private final SelenideElement otherServicesChoice = $x("//*[.='Прочие услуги']");
    private final SelenideElement accountNumberInput = $(By.id("AccountNumber"));
    private final SelenideElement totalPaymentInput1 = $x("//*[@class='k-formatted-value k-input']");
    private final SelenideElement totalPaymentInput2 = $(By.id("Amount"));
    private final SelenideElement paymentPurposeInput = $(By.id("PaymentPurpose"));
    private final SelenideElement invoicesAddButton = $x("//*[@onclick='OnSave();']");



    public Invoice getInvoice() {

        dataBaseService = new DataBaseService();
        InvoicesTable invoicesTable = new InvoicesTable(dataBaseService);
        ResultSet resultSet = invoicesTable.getInvoicesByID(1);

        try {
            while (resultSet.next()) {
                return Invoice.builder()
                        .service_option(resultSet.getString("service_option"))
                        .account_number(resultSet.getString("account_number"))
                        .amount(resultSet.getInt("amount"))
                        .payment_purpose(resultSet.getString("payment_purpose"))
                        .isActive(true)
                        .build();

            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        dataBaseService.closeConnection();
        return null;
    }

    public void addInvoice(Invoice invoice){
        servicesDropDown.click();
        otherServicesChoice.click();
        accountNumberInput.sendKeys(invoice.getAccount_number());
        totalPaymentInput1.click();
        totalPaymentInput2.sendKeys(String.valueOf(invoice.getAmount()));
        paymentPurposeInput.sendKeys(invoice.getPayment_purpose());
        invoicesAddButton.scrollTo().click();
    }

}
