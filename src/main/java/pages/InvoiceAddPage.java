package pages;

import bars.NavigationBar;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class InvoiceAddPage extends NavigationBar {

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

}
