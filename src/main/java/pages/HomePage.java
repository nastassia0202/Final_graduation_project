package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class HomePage{


    private final SelenideElement PAGE_OPENED_IDENTIFIER = $(By.className("page-content-wrapper container"));
    private final SelenideElement invoicesSection = $x("//*[.='Счета']");
    private final SelenideElement paymentsSection = $x("//div[.='Платежи']");
    private final SelenideElement servicesSection = $x("//div[.='Услуги']");
    private final SelenideElement settingsPersonalSection = $x("//*[.='Личные']");
    private final SelenideElement invoicesAddSection = $x("//*[.='Выставить']");
    private final SelenideElement payersSection = $x("//div[.='Плательщики']");
    private final SelenideElement invoiceActSection = $x("//*[.='Оплата']");
    private final SelenideElement settingsEmployeesSection = $x("//div[.='Сотрудники']");


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
