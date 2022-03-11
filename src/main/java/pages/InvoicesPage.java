package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class InvoicesPage {


    private final SelenideElement PAGE_OPENED_IDENTIFIER = $x("//h1[.='Счета']");
    private final SelenideElement successMessage = $x("//*[.='Счет успешно создан!']");
    private final SelenideElement numberInvoice = $x("//a[.='"+"database"+"']");
    private final SelenideElement totalPayment = $x("//td[.='"+"database"+",00 BYN ']");
    private final SelenideElement cancelInvoice = $x("//div[@class='icon_grid cd-popup-trigger']");



    public void checkSuccessInvoiceAndCancel(){
        successMessage.shouldBe(Condition.visible);
        Assert.assertEquals(numberInvoice.getText(),"database");
        Assert.assertEquals(totalPayment.getText(),"database");
        cancelInvoice.click();
    }



    public SelenideElement getPAGE_OPENED_IDENTIFIER() {
        return PAGE_OPENED_IDENTIFIER;
    }

    public SelenideElement getSuccessMessage() {
        return successMessage;
    }
}
