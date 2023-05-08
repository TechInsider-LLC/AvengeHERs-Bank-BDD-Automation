package pageObjectModel;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ScenarioData;

import java.time.Duration;


public class OutgoingWireTransferPage {

    WebDriver driver;
    WebDriverWait wait;


    @FindBy(css ="[routerlink=\"/transfer\"]")
    WebElement Transfers;

    @FindBy(xpath = "//*[@ng-reflect-router-link='outgoing-wire-transfer']")
    WebElement OutgoingWireTransferPage;

    @FindBy(xpath = "//*[@ng-reflect-placeholder-text='Select account']")
    WebElement DebitForm;

    @FindBy(css = ".ng-option-marked")
    WebElement Card;

    @FindBy(css = "#beneficiary-bankSwiftBic")
    WebElement SWIFTBIC;

    @FindBy(css = "#customer-name")
    WebElement CustomerName;

    @FindBy (css = "#customer-address")
    WebElement  AddressLine1;

    @FindBy (css ="#customer-city")
    WebElement City;

    @FindBy (css = "#customer-state-prov-region")
    WebElement StateProvinceRegion;

    @FindBy (xpath="//*[@ng-reflect-name='customerCountry']")
    WebElement CustomerCountryBox;

    @FindBy (xpath = "//*[contains(text(), 'United States of America')]")
    WebElement CustomerCountry;

    @FindBy (css = "#acc-iban")
    WebElement AccNumIBAN;

    @FindBy(css = "#ref-message")
    WebElement RefMessage;

    @FindBy (css = "#outgoingAmountOptionsPipe")
    WebElement Amount;

    @FindBy (xpath = "//*[@ng-reflect-placeholder='Select currency']")
    WebElement CurrencyBox;

    @FindBy (xpath = "//*[contains(text(), \"Currency\")]/..//input")
    WebElement Currency;

    @FindBy(xpath="//*[contains(text(), \"Continue\")]")
    WebElement Continue;


    @FindBy(xpath = "//button[contains(text(), \"Confirm\")]")
    WebElement Confirm;

    @FindBy(css = ".popup-message")
    WebElement popup;



    public OutgoingWireTransferPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void OutgoingWireTransfer() {
        wait.until(ExpectedConditions.elementToBeClickable(Transfers));
        By overlayLocator = By.cssSelector("div.overlay");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
        Transfers.click();
        wait.until(ExpectedConditions.visibilityOf(OutgoingWireTransferPage));
        OutgoingWireTransferPage.click();
        wait.until(ExpectedConditions.visibilityOf(DebitForm));
        DebitForm.click();
        wait.until(ExpectedConditions.visibilityOf(Card));
        Card.click();
        wait.until(ExpectedConditions.visibilityOf(SWIFTBIC));
        SWIFTBIC.sendKeys(ScenarioData.get("SWIFTBIC"));
        wait.until(ExpectedConditions.visibilityOf(CustomerName));
        CustomerName.sendKeys(ScenarioData.get("nickname"));
        wait.until(ExpectedConditions.visibilityOf(AddressLine1));
        AddressLine1.sendKeys(ScenarioData.get("address"));
        wait.until(ExpectedConditions.visibilityOf(City));
        City.sendKeys(ScenarioData.get("city"));
        StateProvinceRegion.sendKeys(ScenarioData.get("state"));
        wait.until(ExpectedConditions.visibilityOf(CustomerCountryBox));
        CustomerCountryBox.click();
        wait.until(ExpectedConditions.visibilityOf(CustomerCountry));
        CustomerCountry.click();
        AccNumIBAN.sendKeys(ScenarioData.get("accountNumber"));
        RefMessage.sendKeys(ScenarioData.get("message"));
        Amount.sendKeys(ScenarioData.get("amount"));
        wait.until(ExpectedConditions.visibilityOf(CurrencyBox));
        CurrencyBox.click();
        wait.until(ExpectedConditions.visibilityOf(Currency));
        Currency.sendKeys("USD", Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(Continue));
        Continue.click();
        wait.until(ExpectedConditions.elementToBeClickable(Confirm));
        Confirm.click();
        wait.until(ExpectedConditions.visibilityOf(popup));

    }

}
