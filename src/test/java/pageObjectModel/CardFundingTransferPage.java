package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ScenarioData;

import java.time.Duration;

public class CardFundingTransferPage {

    WebDriver driver;
    WebDriverWait wait;


    @FindBy(css ="[routerlink=\"/transfer\"]")
    WebElement Transfers;

    @FindBy(xpath = "//*[@ng-reflect-router-link=\"card-funding-transfer\"]")
    WebElement cft;

    @FindBy (css=".ng-value-container")
    WebElement debit;

    @FindBy(css = ".ng-option-marked")
    WebElement Card;

    @FindBy(xpath = "//*[@ng-reflect-placeholder-text=\"Select card\"]")
    WebElement credit;

    @FindBy(css = ".ng-option-marked")
    WebElement CreditCard;

    @FindBy (xpath = "//*[@placeholder=\"0,000.00\"]")
    WebElement amount;

    @FindBy(xpath="//*[contains(text(), \"Continue\")]")
    WebElement Continue;

    @FindBy(xpath = "//button[contains(text(), \"Confirm\")]")
    WebElement Confirm;

    @FindBy(css = ".success-popup")
    WebElement popup;



    public CardFundingTransferPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }


    public void CardFundingTransferPage() throws InterruptedException {

        Transfers.click();
        cft.click();
        debit.click();
        Card.click();
        wait.until(ExpectedConditions.visibilityOf(credit));
         CreditCard.click();
        amount.sendKeys(ScenarioData.get("amount"));
        wait.until(ExpectedConditions.elementToBeClickable(Continue));
        Continue.click();
        Confirm.click();


    }

}
