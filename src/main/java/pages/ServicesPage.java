package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class ServicesPage {


    private final SelenideElement PAGE_OPENED_IDENTIFIER = $x("//h1[.='Услуги']");
    private final SelenideElement requestSuccessMessage = $(By.id("sendText"));
    private final SelenideElement requestButton = $x("//input[@value='Отправить запрос']");



    public void checkPopupMessage(){
        requestButton.click();
        requestSuccessMessage.shouldBe(Condition.visible);
    }
}
