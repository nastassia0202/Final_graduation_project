package pages;


import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import model.InvoiceBuilder;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import static constant.endpoints.EndPointsUrl.ADD_INVOICES_PAGE;

public class InvoiceAddPage extends BasePage {

    @FindBy(xpath = "//h1[.='Выставить новый счет']")
    private SelenideElement PAGE_OPENED_IDENTIFIER;
    @FindBy(xpath = "//div[@class='col-md-5']//span[@class='k-input']")
    private SelenideElement servicesDropDown;
    @FindBy(xpath = "//*[.='ЕРИП: Прочие услуги']")
    private SelenideElement otherServicesChoice;
    @FindBy(id = "AccountNumber")
    private SelenideElement accountNumberInput;
    @FindBy(className = "k-formatted-value k-input")
    private SelenideElement totalPaymentInput;
    @FindBy(id = "PaymentPurpose")
    private SelenideElement paymentPurposeInput;
    @FindBy(className = "button-orange")
    private SelenideElement invoicesAddButton;

    public InvoiceAddPage() {
        open(ADD_INVOICES_PAGE);
        waitVisibility(PAGE_OPENED_IDENTIFIER);
    }

    public InvoiceBuilder getInvoice(){
        return InvoiceBuilder.builder()
                .serviceOption("database")
                .accountNumber("database")
                .amount("database")
                .payment_purpose("database")
                .isActive(true)
                .build();
    }

    public void addInvoice(InvoiceBuilder invoiceBuilder){
        servicesDropDown.click();
        otherServicesChoice.click();
        accountNumberInput.sendKeys(invoiceBuilder.getAccountNumber());
        totalPaymentInput.sendKeys(invoiceBuilder.getAmount());
        paymentPurposeInput.sendKeys(invoiceBuilder.getPayment_purpose());
        invoicesAddButton.click();
    }

}
