package pages;


import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import static constant.endpoints.EndPointsUrl.PERSONAL_DATA_PAGE;

public class PersonalDataPage extends BasePage {

    @FindBy(xpath = "//h1[.='Редактировать личные данные']")
    private SelenideElement PAGE_OPENED_IDENTIFIER;
    @FindBy(id = "LastName")
    private SelenideElement lastNameInput;
    @FindBy(id = "FirstName")
    private SelenideElement firstNameInput;
    @FindBy(xpath = "//*[@value='Сохранить']")
    private SelenideElement saveButton;

    public PersonalDataPage() {
        open(PERSONAL_DATA_PAGE);
        waitVisibility(PAGE_OPENED_IDENTIFIER);
    }

    public void changePersonalData(String lastname,String firstname){
        lastNameInput.sendKeys(lastname);
        firstNameInput.sendKeys(firstname);
        saveButton.click();
    }
}