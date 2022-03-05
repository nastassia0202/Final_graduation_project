package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class InvoicesPage {


    private final SelenideElement PAGE_OPENED_IDENTIFIER = $x("//h1[.='Счета']");
    private final SelenideElement successMessage = $x("//*[.='Счет успешно создан!']");
    private final SelenideElement numberInvoice = $x("//a[.='"+"database"+"']");
    private final SelenideElement totalPayment = $x("//td[.='"+"database"+",00 BYN ']");



    public void checkSuccessInvoice(){
        successMessage.shouldBe(Condition.visible);
        Assert.assertEquals(numberInvoice.getText(),"database");
        Assert.assertEquals(totalPayment.getText(),"database");
    }

}
