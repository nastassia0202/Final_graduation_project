package pages;



import com.codeborne.selenide.SelenideElement;
import model.User;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {


    private final SelenideElement emailField = $(By.id("login"));
    private final SelenideElement passwordField = $(By.id("password"));
    private final SelenideElement loginButton = $x("//*[@value='Войти']");
    private final SelenideElement reCaptchaCheckbox = $(By.className("rc-anchor-center-item rc-anchor-checkbox-holder"));
    private final SelenideElement demoLoginLink = $x("//a[.='Демо вход']");;



    public User getUser(){
        return User.builder()
                .login("demo")
                .password("demo")
                .build();
    }

    public void loginWithUser(User user) {
        emailField.should(visible).setValue(user.getLogin());
        passwordField.should(visible).setValue(user.getPassword());
        actions().moveByOffset(662,636).click();
        loginButton.should(visible).click();

    }

    public void login() {
        demoLoginLink.click();
        reCaptchaCheckbox.click();
        loginButton.click();
    }


}
