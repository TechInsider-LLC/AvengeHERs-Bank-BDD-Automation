package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath="//*[@type='email']")
    WebElement UsernameEmail;

    @FindBy(xpath="//*[@type='password']")
    WebElement Password;

    @FindBy(css=".controls__submit")
    WebElement SignIn;


    public LogInPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        PageFactory.initElements(driver, this);
    }

    public void openHomePage(){driver.get("https://demo.ebanq.com/");}

    public void with(String userName,String password) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(UsernameEmail));
        UsernameEmail.sendKeys(userName);
        Password.sendKeys(password);
        SignIn.click();
    }
}