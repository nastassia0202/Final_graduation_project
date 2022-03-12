package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
	private final SelenideElement emailField = $(By.id("email"));
	private final SelenideElement passwordField = $(By.id("passwd"));
	private final SelenideElement signInButton = $(By.id("SubmitLogin"));
	private final SelenideElement alertBarDanger = $(By.className("alert-danger"));
	private final SelenideElement alertBarSuccess = $(By.className("alert-success"));




	public void signInWithCredentials(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		signInButton.click();
	}


	public boolean isAlertBarDangerDisplayed() {
		return alertBarDanger.isDisplayed();
	}

	public boolean isAlertBarSuccessDisplayed() {
		return alertBarSuccess.isDisplayed();
	}

}
