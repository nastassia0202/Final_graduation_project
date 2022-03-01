package pages;


import baseEntities.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;


import static com.codeborne.selenide.Selenide.open;
import static constant.endpoints.EndPointsUrl.SERVICES_PAGE;

public class ServicesPage extends BasePage {

    @FindBy(xpath = "//h1[.='Услуги']")
    private SelenideElement PAGE_OPENED_IDENTIFIER;
    @FindBy(id = "sendText")
    private SelenideElement requestSuccessMessage;
    @FindBy (xpath = "//input[@value='Отправить запрос']")
    private SelenideElement requestButton;

    public ServicesPage() {
        open(SERVICES_PAGE);
        waitVisibility(PAGE_OPENED_IDENTIFIER);
    }

    public void checkPopupMessage(){
        requestButton.click();
        requestSuccessMessage.shouldBe(Condition.visible);
    }
}
