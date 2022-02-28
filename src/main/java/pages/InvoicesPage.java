package pages;

import bars.NavigationBar;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class InvoicesPage extends NavigationBar {

    @FindBy(xpath = "//h1[.='Счета']")
    private SelenideElement PAGE_OPENED_IDENTIFIER;
    @FindBy(xpath = "//*[.='Счет успешно создан!']")
    private SelenideElement successMessage;
    @FindBy(xpath = "//a[.='"+"database"+"']")
    private SelenideElement numberInvoice;
    @FindBy(xpath = "//td[.='"+"database"+",00 BYN ']")
    private SelenideElement totalPayment;

}
