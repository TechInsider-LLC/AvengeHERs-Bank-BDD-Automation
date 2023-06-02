package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ScenarioData;

import java.time.Duration;

public class CardFundingTransferPage extends BasePage{

    @FindBy(css ="[routerlink=\"/transfer\"]")
    WebElement Transfers;

    @FindBy(xpath = "//*[@ng-reflect-router-link=\"card-funding-transfer\"]")
    WebElement cft;

    @FindBy (css=".ng-value-container")
    WebElement debit;

    @FindBy(css = ".ng-option-marked")
    WebElement Card;

    @FindBy(xpath = "//*[contains(text(),\"Credit to\")]")
    WebElement credit;

    @FindBy(xpath = "//*[contains(text(), \"**** **** **** 9089\")]")
    WebElement CreditCard;

    @FindBy (xpath = "//*[@ng-reflect-name=\"outgoingAmount\"]")
    WebElement amount;

    @FindBy(xpath="//*[contains(text(), \"Continue\")]")
    WebElement Continue;

    @FindBy(xpath = "//button[contains(text(), \"Confirm\")]")
    WebElement Confirm;

    @FindBy(css = ".success-popup")
    WebElement popup;



    public CardFundingTransferPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void CardFundingTransferPage() throws InterruptedException {

        Transfers.click();
        cft.click();
        debit.click();
        Card.click();
        credit.click();
        Thread.sleep(4000);
        CreditCard.click();
        Thread.sleep(3000);
        amount.clear();
        amount.sendKeys("150");
        wait.until(ExpectedConditions.elementToBeClickable(Continue));
        Continue.click();
        wait.until(ExpectedConditions.elementToBeClickable(Confirm));
        Confirm.click();

    }

}
