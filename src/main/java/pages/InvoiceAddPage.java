package pages;


import com.codeborne.selenide.SelenideElement;
import model.Invoice;
import org.openqa.selenium.support.FindBy;


public class InvoiceAddPage{

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
