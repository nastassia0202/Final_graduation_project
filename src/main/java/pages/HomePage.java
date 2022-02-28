package pages;

import bars.NavigationBar;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends NavigationBar {

    @FindBy(className = "page-content-wrapper container")
    private SelenideElement PAGE_OPENED_IDENTIFIER;
    @FindBy(xpath = "//*[.='Счета']")
    public SelenideElement invoicesSection;
    @FindBy(xpath = "//div[.='Платежи']")
    public SelenideElement paymentsSection;
    @FindBy(xpath = "//div[.='Услуги']")
    public SelenideElement servicesSection;
    @FindBy(xpath = "//*[.='Личные']")
    public SelenideElement settingsPersonalSection;
    @FindBy(xpath = "//*[.='Выставить']")
    public SelenideElement invoicesAddSection;
    @FindBy(xpath = "//div[.='Плательщики']")
    public SelenideElement payersSection;
    @FindBy(xpath = "//*[.='Оплата']")
    public SelenideElement invoiceActSection;
    @FindBy(xpath = "//div[.='Сотрудники']")
    public SelenideElement settingsEmployeesSection;

}
