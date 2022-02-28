package pages;

import bars.NavigationBar;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class InvoiceAddPage extends NavigationBar {

    @FindBy(xpath = "//h1[.='Выставить новый счет']")
    private SelenideElement PAGE_OPENED_IDENTIFIER;
    @FindBy(xpath = "//div[@class='col-md-5']//span[@class='k-input']")
    public SelenideElement servicesDropDown;
    @FindBy(xpath = "//*[.='ЕРИП: Прочие услуги']")
    public SelenideElement otherServicesChoice;
    @FindBy(id = "AccountNumber")
    public SelenideElement accountNumberInput;
    @FindBy(className = "k-formatted-value k-input")
    public SelenideElement totalPaymentInput;
    @FindBy(id = "PaymentPurpose")
    public SelenideElement paymentPurposeInput;
    @FindBy(className = "button-orange")
    public SelenideElement invoicesAddButton;

}
