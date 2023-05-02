package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferBetweenUsersPage {

    WebDriver driver;
//  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    @FindBy(css =".transfer")
    WebElement Transfers;

    @FindBy(css = "[ng-reflect-router-link=\"transfer-between-users\"]")
    WebElement TransferBetweenUsers;

    @FindBy(css=".ng-value-container")
    WebElement DebitForm;

    @FindBy(css=".ng-option-marked")
    WebElement Card;

    @FindBy(css="#username")
    WebElement UserName;

    @FindBy(css="#account")
    WebElement Account;

    @FindBy(xpath="//*[@placeholder='0,000.00']")
    WebElement Amount;

    @FindBy(xpath="//*[@type='submit']")
    WebElement Continue;

    @FindBy(xpath="//*[@type='submit']")
    WebElement Confirm;

//    @FindBy(css = "[href=\"/transfer\"]")
    WebElement Back;

//  @FindBy(css = ".popup-message")
    WebElement popup;

    public TransferBetweenUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void TransferBetweenUsers() throws InterruptedException {
        Transfers.click();
        Thread.sleep(2000);
        TransferBetweenUsers.click();
        Thread.sleep(2000);
        DebitForm.click();
        Thread.sleep(2000);
        Card.click();
        UserName.sendKeys("jsmith");
        Account.sendKeys("EBQ24123487654");
        Thread.sleep(2000);
        Amount.sendKeys("1000");
        Thread.sleep(2000);
        Continue.click();
        Confirm.click();
        Thread.sleep(2000);
 //       Back.click();
//      wait.until(ExpectedConditions.visibilityOf(popup));
    }
}
