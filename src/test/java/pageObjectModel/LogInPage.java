package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    WebDriver driver;

    @FindBy(xpath="//*[@type='email']")
    WebElement UsernameEmail;

    @FindBy(xpath="//*[@type='password']")
    WebElement Password;

    @FindBy(css=".controls__submit")
    WebElement SignIn;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage(){driver.get("https://demo.ebanq.com/");}

    public void with(String userName,String password){
        UsernameEmail.sendKeys(userName);
        Password.sendKeys(password);
        SignIn.click();
    }
}