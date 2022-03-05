package pages;


import com.codeborne.selenide.SelenideElement;
import model.Invoice;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class InvoiceAddPage{

    private final SelenideElement PAGE_OPENED_IDENTIFIER = $x("//h1[.='Выставить новый счет']");
    private final SelenideElement servicesDropDown = $x("//div[@class='col-md-5']//span[@class='k-input']");
    private final SelenideElement otherServicesChoice = $x("//*[.='ЕРИП: Прочие услуги']");
    private final SelenideElement accountNumberInput = $(By.id("AccountNumber"));
    private final SelenideElement totalPaymentInput = $(By.className("k-formatted-value k-input"));
    private final SelenideElement paymentPurposeInput = $(By.id("PaymentPurpose"));
    private final SelenideElement invoicesAddButton = $(By.className("button-orange"));



    public Invoice getInvoice(){
        return Invoice.builder()
                .serviceOption("database")
                .accountNumber("database")
                .amount("database")
                .payment_purpose("database")
                .isActive(true)
                .build();
    }

    public void addInvoice(Invoice invoice){
        servicesDropDown.click();
        otherServicesChoice.click();
        accountNumberInput.sendKeys(invoice.getAccountNumber());
        totalPaymentInput.sendKeys(invoice.getAmount());
        paymentPurposeInput.sendKeys(invoice.getPayment_purpose());
        invoicesAddButton.click();
    }

}
