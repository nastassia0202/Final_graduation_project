package pages;



import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import model.User;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import static constant.Urls.BASE_URL;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[.='Вход в личный кабинет']")
    private SelenideElement PAGE_OPENED_IDENTIFIER;
    @FindBy(id = "login")
    private SelenideElement emailField;
    @FindBy(id = "password")
    private SelenideElement passwordField;
    @FindBy(xpath = "//*[@value='Войти']")
    private SelenideElement loginButton;
    @FindBy(id = "recaptcha-anchor")
    private SelenideElement reCaptchaCheckbox;
    @FindBy(xpath = "//a[.='Демо вход']")
    private SelenideElement demoLoginLink;

    public LoginPage() {
        open("/");
        waitVisibility(PAGE_OPENED_IDENTIFIER);
    }

    public User getUser(){
        return User.builder()
                .login("demo")
                .password("demo")
                .build();
    }

    public void loginWithUser(User user) {
        emailField.sendKeys(user.getLogin());
        passwordField.sendKeys(user.getPassword());
        reCaptchaCheckbox.click();
        loginButton.click();
    }

    public void login() {
        demoLoginLink.click();
        reCaptchaCheckbox.click();
        loginButton.click();
    }

    public void loginWithCookie() {

    }



}
