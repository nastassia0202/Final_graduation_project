package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ContactPage {

    private final SelenideElement subjectHeadingDropDown = $(By.id("id_contact"));
    private final SelenideElement orderReferenceDropDown = $(By.name("id_order"));
    private final SelenideElement messageField = $(By.id("message"));
    private final SelenideElement ProductDropDown = $(By.name("id_product"));
    private final SelenideElement inputForLoadFile = $(By.id("fileUpload"));
    private final SelenideElement sendButton = $(By.id("submitMessage"));
}
