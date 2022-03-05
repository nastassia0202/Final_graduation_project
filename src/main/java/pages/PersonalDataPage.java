package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class PersonalDataPage{


    private final SelenideElement PAGE_OPENED_IDENTIFIER = $x("//h1[.='Редактировать личные данные']");
    private final SelenideElement lastNameInput = $(By.id("LastName"));
    private final SelenideElement firstNameInput = $(By.id("FirstName"));
    private final SelenideElement saveButton = $x("//*[@value='Сохранить']");



    public void changePersonalData(String lastname,String firstname){
        lastNameInput.sendKeys(lastname);
        firstNameInput.sendKeys(firstname);
        saveButton.click();
    }
}
