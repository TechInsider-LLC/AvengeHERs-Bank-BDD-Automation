package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){//parent constructor
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
}
