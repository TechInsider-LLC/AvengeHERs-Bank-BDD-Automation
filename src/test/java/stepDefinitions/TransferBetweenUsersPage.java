package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ScenarioData;

import java.time.Duration;
import java.util.Scanner;

public class TransferBetweenUsersPage {

    WebDriver driver;
    WebDriverWait wait;

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

    @FindBy(xpath = "//*[width=\"87\"]")
    WebElement Users;

//   @FindBy(css = ".ng-value-container")
 //  WebElement form;

    @FindBy(css = ".popup-message")
    WebElement popup;

    public TransferBetweenUsersPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);
    }


    public void TransferBetweenUsers() throws InterruptedException {
        Transfers.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(TransferBetweenUsers));
        TransferBetweenUsers.click();
        wait.until(ExpectedConditions.visibilityOf(DebitForm));
        DebitForm.click();
        Thread.sleep(2000);
        Card.click();
        UserName.sendKeys(ScenarioData.get("nickname"));
        Account.sendKeys(ScenarioData.get("account"));
        Thread.sleep(2000);
        Amount.sendKeys(ScenarioData.get("amount"));
        Thread.sleep(2000);
        Continue.click();
        Confirm.click();
        wait.until(ExpectedConditions.visibilityOf(popup));
    }
}
