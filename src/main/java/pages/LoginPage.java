package pages;



import com.codeborne.selenide.SelenideElement;
import model.UserBuilder;
import org.openqa.selenium.support.FindBy;

public class LoginPage{

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

    public UserBuilder getUser(){
        return UserBuilder.builder()
                .login("database")
                .password("database")
                .build();
    }

    public void loginWithUser(UserBuilder userBuilder) {
        emailField.sendKeys(userBuilder.getLogin());
        passwordField.sendKeys(userBuilder.getPassword());
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
