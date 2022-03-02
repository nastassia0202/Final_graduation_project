package baseEntities;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.codeborne.selenide.Selenide.switchTo;


public abstract class BasePage {
    public BasePage(){
        Configuration.timeout = Duration.of(1, ChronoUnit.MINUTES).toMillis();
    }

    protected void waitEnabledAndClick(SelenideElement element){
        element.shouldBe(Condition.enabled).click();
   }

   protected SelenideElement waitVisibility(SelenideElement element){
        return element.shouldBe(Condition.visible);
   }


}