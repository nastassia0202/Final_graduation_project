package pages;


import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;


public class HomePage extends BasePage {

    @FindBy(className = "page-content-wrapper container")
    private SelenideElement PAGE_OPENED_IDENTIFIER;
    @FindBy(xpath = "//*[.='Счета']")
    private SelenideElement invoicesSection;
    @FindBy(xpath = "//div[.='Платежи']")
    private SelenideElement paymentsSection;
    @FindBy(xpath = "//div[.='Услуги']")
    private SelenideElement servicesSection;
    @FindBy(xpath = "//*[.='Личные']")
    private SelenideElement settingsPersonalSection;
    @FindBy(xpath = "//*[.='Выставить']")
    private SelenideElement invoicesAddSection;
    @FindBy(xpath = "//div[.='Плательщики']")
    private SelenideElement payersSection;
    @FindBy(xpath = "//*[.='Оплата']")
    private SelenideElement invoiceActSection;
    @FindBy(xpath = "//div[.='Сотрудники']")
    private SelenideElement settingsEmployeesSection;

    public HomePage(String pageUrl) {
        super(pageUrl);
    }

    public void clickForInvoices(){
        invoicesSection.click();
    }
    public void clickForPayments(){
        paymentsSection.click();
    }
    public void clickForServices(){
        servicesSection.click();
    }
    public void clickForSettingsPersonal(){
        settingsPersonalSection.click();
    }
    public void clickForInvoicesAdd(){
        invoicesAddSection.click();
    }
    public void clickForPayers(){
        payersSection.click();
    }
    public void clickForInvoiceAct(){
        invoiceActSection.click();
    }
    public void clickForSettingsEmployees(){
        settingsEmployeesSection.click();
    }

}
