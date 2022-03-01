package pages;


import baseEntities.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.open;
import static constant.endpoints.EndPointsUrl.INVOICES_PAGE;

public class InvoicesPage extends BasePage {

    @FindBy(xpath = "//h1[.='Счета']")
    private SelenideElement PAGE_OPENED_IDENTIFIER;
    @FindBy(xpath = "//*[.='Счет успешно создан!']")
    private SelenideElement successMessage;
    @FindBy(xpath = "//a[.='"+"database"+"']")
    private SelenideElement numberInvoice;
    @FindBy(xpath = "//td[.='"+"database"+",00 BYN ']")
    private SelenideElement totalPayment;

    public InvoicesPage() {
        open(INVOICES_PAGE);
        waitVisibility(PAGE_OPENED_IDENTIFIER);
    }

    public void checkSuccessInvoice(){
        successMessage.shouldBe(Condition.visible);
        Assert.assertEquals(numberInvoice.getText(),"database");
        Assert.assertEquals(totalPayment.getText(),"database");
    }

}
