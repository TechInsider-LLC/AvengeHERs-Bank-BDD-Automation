package pageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ScenarioData;

import java.time.Duration;

public class SEPATransferPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = ".transfer")
    WebElement Transfers;

    @FindBy(xpath = "//*[@ng-reflect-router-link='outgoing-sepa-transfer']")
    WebElement SEPATransfer;

    @FindBy(xpath = "//*[@ng-reflect-placeholder-text='Select account']")
    WebElement DebitFrom;

    @FindBy(css = ".ng-option-marked")
    WebElement Checking;

//   @FindBy(xpath = "//*[contains(text(), 'Andorra')]")
//    WebElement Country;

    @FindBy(css = "#beneficiarybank-acc-iban")
    WebElement IBAN;

    @FindBy(css = "#beneficiary-bankSwiftBic")
    WebElement BIC;

    @FindBy(css = "#customer-name")
    WebElement BeneficiaryCustomerName;

    @FindBy(css = "#ref-message")
    WebElement RefMessage;

    @FindBy(css = "#outgoingAmountOptionsPipe")
    WebElement AmountToTransfer;

    @FindBy(xpath = "//*[contains(text(), \"Continue\")]")
    WebElement Continue;

    @FindBy(xpath = "//button[contains(text(), \"Confirm\")]")
    WebElement Confirm;

    @FindBy(css = ".popup-message")
    WebElement popup;








    public SEPATransferPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }

    public void SEPATransfer() throws InterruptedException {


        Transfers.click();
        wait.until(ExpectedConditions.visibilityOf(SEPATransfer));
        SEPATransfer.click();
        wait.until(ExpectedConditions.visibilityOf(DebitFrom));
        DebitFrom.click();
        wait.until(ExpectedConditions.visibilityOf(Checking));
        Checking.click();
//        wait.until(ExpectedConditions.visibilityOf(Country));
//        Country.click();
        wait.until(ExpectedConditions.visibilityOf(IBAN));
        IBAN.sendKeys(ScenarioData.get("IBAN"));
        wait.until(ExpectedConditions.visibilityOf(BIC));
        BIC.sendKeys(ScenarioData.get("BIC"));
        wait.until(ExpectedConditions.visibilityOf(BeneficiaryCustomerName));
        BeneficiaryCustomerName.sendKeys(ScenarioData.get("BeneficiaryCustomerName"));
        RefMessage.sendKeys(ScenarioData.get("RefMessage"));
        AmountToTransfer.sendKeys(ScenarioData.get("AmountToTransfer"));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(Continue));
        Continue.click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(Confirm));
        Confirm.click();
        wait.until(ExpectedConditions.visibilityOf(popup));





    }
}
