package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class InvoicesPage {

    @FindBy(xpath = "//h1[.='Счета']")
    private SelenideElement PAGE_OPENED_IDENTIFIER;
    @FindBy(xpath = "//*[.='Счет успешно создан!']")
    private SelenideElement successMessage;
    @FindBy(xpath = "//a[.='"+"database"+"']")
    private SelenideElement numberInvoice;
    @FindBy(xpath = "//td[.='"+"database"+",00 BYN ']")
    private SelenideElement totalPayment;



    public void checkSuccessInvoice(){
        successMessage.shouldBe(Condition.visible);
        Assert.assertEquals(numberInvoice.getText(),"database");
        Assert.assertEquals(totalPayment.getText(),"database");
    }

}
