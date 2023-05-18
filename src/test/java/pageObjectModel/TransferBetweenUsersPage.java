package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ScenarioData;

import java.time.Duration;

public class TransferBetweenUsersPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".transfer")
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

    @FindBy(xpath="//*[contains(text(), \"Continue\")]")
    WebElement Continue;

    @FindBy(xpath ="//button[contains(text(), \"Confirm\")]")
    WebElement Confirm;

    @FindBy(css = ".popup-message")
    WebElement popup;

    public TransferBetweenUsersPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    public void TransferBetweenUsers() throws InterruptedException {
        Transfers.click();
        wait.until(ExpectedConditions.visibilityOf(TransferBetweenUsers));
        TransferBetweenUsers.click();
        wait.until(ExpectedConditions.visibilityOf(DebitForm));
        DebitForm.click();
        wait.until(ExpectedConditions.visibilityOf(Card));
        Card.click();
        UserName.sendKeys(ScenarioData.get("nickname"));
        Account.sendKeys(ScenarioData.get("account"));
        wait.until(ExpectedConditions.visibilityOf(Amount));
        Amount.sendKeys(ScenarioData.get("amount"));
        wait.until(ExpectedConditions.elementToBeClickable(Continue));
        Continue.click();
        wait.until(ExpectedConditions.visibilityOf(Confirm));
        Confirm.click();
        wait.until(ExpectedConditions.visibilityOf(popup));
    }
}

