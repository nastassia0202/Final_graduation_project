package pages;


import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;


public class InvoicesImportPage extends BasePage {

    @FindBy(xpath = "//h1[.='Импорт счетов']")
    private SelenideElement PAGE_OPENED_IDENTIFIER;
    @FindBy(xpath = "//span[.='Выберите файл…']")
    private SelenideElement loadFileButton;
    @FindBy(xpath = "//div[@class='row']//button[.='Далее']")
    private SelenideElement otherServicesChoice;

    public InvoicesImportPage(String pageUrl) {
        super(pageUrl);
    }
}
