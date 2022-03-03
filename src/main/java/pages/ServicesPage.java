package pages;


import baseEntities.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;


public class ServicesPage extends BasePage {

    @FindBy(xpath = "//h1[.='Услуги']")
    private SelenideElement PAGE_OPENED_IDENTIFIER;
    @FindBy(id = "sendText")
    private SelenideElement requestSuccessMessage;
    @FindBy (xpath = "//input[@value='Отправить запрос']")
    private SelenideElement requestButton;

    public ServicesPage(String pageUrl) {
        super(pageUrl);
    }

    public void checkPopupMessage(){
        requestButton.click();
        requestSuccessMessage.shouldBe(Condition.visible);
    }
}
