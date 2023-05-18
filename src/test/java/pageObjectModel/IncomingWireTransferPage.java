package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IncomingWireTransferPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "[routerlink=\"/transfer\"]")
    WebElement Transfers;

    @FindBy(xpath = "//*[contains(text(),\"Incoming Wire Transfer\")]")
    WebElement IWT;

    @FindBy(css = ".ng-select-container")
    WebElement account;

    @FindBy(xpath = "//*[contains(text(),\"EBQ11223387654\")]")
    WebElement card;

    @FindBy(xpath = "//*[contains(text(), \"Continue\")]")
    WebElement Continue;

    @FindBy(xpath= "//*[contains(text(), \" GB00EBANQ1201200055 \")]")
    WebElement accountNumber;


    public IncomingWireTransferPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,    Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    public void IncomingWireTransferPage() throws InterruptedException {
        Transfers.click();
        IWT.click();
        wait.until(ExpectedConditions.visibilityOf(account));
        account.click();
        card.click();
        Thread.sleep(2000);
        Continue.click();
        wait.until(ExpectedConditions.visibilityOf(accountNumber));
    }
}