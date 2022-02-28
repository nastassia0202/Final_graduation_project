package pages;

import bars.NavigationBar;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDataPage extends NavigationBar {

    @FindBy(xpath = "//h1[.='Редактировать личные данные']")
    private SelenideElement PAGE_OPENED_IDENTIFIER;
    @FindBy(id = "LastName")
    private SelenideElement lastNameInput;
    @FindBy(id = "FirstName")
    private SelenideElement firstNameInput;
    @FindBy(xpath = "//*[@value='Сохранить']")
    private SelenideElement saveButton;

}
