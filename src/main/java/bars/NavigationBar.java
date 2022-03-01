package bars;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class NavigationBar {

    @FindBy(className = "current")
    private SelenideElement mainButton;
    @FindBy(xpath = "//a[text()='Платежи']")
    private SelenideElement paymentsButton;
    @FindBy(xpath = "//div/a[@href='/settings/personal']")
    private SelenideElement personalSettingsLink;
    @FindBy (linkText = "/home/logout")
    private SelenideElement logoutLink;

    

}
