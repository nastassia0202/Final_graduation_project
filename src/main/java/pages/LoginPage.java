package pages;



import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {


    private final SelenideElement emailField = $(By.id("login"));
    private final SelenideElement passwordField = $(By.id("password"));
    private final SelenideElement loginButton = $x("//*[@value='Войти']");
    private final SelenideElement reCaptchaCheckbox = $(By.id("recaptcha-anchor"));
    private final SelenideElement demoLoginLink = $x("//a[.='Демо вход']");;

    public LoginPage() {
        open("/");
        SelenideElement PAGE_OPENED_IDENTIFIER = $x("//title[.='Вход в личный кабинет']");
        PAGE_OPENED_IDENTIFIER.should(visible);
    }

    public User getUser(){
        return User.builder()
                .login("demo")
                .password("demo")
                .build();
    }

    public void loginWithUser(User user) {
        emailField.should(visible).setValue(user.getLogin());
        passwordField.should(visible).setValue(user.getPassword());
        reCaptchaCheckbox.should(visible).click();
        loginButton.should(visible).click();
    }

    public void login() {
        demoLoginLink.click();
        reCaptchaCheckbox.click();
        loginButton.click();
    }

    public void loginWithCookie() {

    }



}
