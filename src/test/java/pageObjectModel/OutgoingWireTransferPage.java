package pageObjectModel;


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


    @FindBy(css = ".transfer")
    WebElement Transfers;

    @FindBy(xpath = "//*[@ng-reflect-router-link='outgoing-wire-transfer']")
    WebElement OutgoingWireTransferPage;

    @FindBy(xpath = "//*[@ng-reflect-placeholder-text='Select account']")
    WebElement DebitForm;

    @FindBy(css = ".ng-option-marked")
    WebElement Card;

    @FindBy(css = "#beneficiary-bankSwiftBic")
    WebElement SWIFTBIC;

 //   @FindBy(css = "#beneficiary-bankName")
//    WebElement BankName;

//    @FindBy(css = "#beneficiary-address")
 //   WebElement BankAddress;

//    @FindBy (css = "#beneficiary-location")
//    WebElement Location;

//    @FindBy (xpath = "autocomplete=\"a052e72291a9\"")
//    WebElement CountryBox;

 //   @FindBy (css = "#ab26e70182d9")
//    WebElement BankCountry;

//    @FindBy (css = "#beneficiary-aba-rtn")
 //   WebElement ABARTNSortCode;

    @FindBy(css = "#customer-name")
    WebElement CustomerName;

    @FindBy (css = "#customer-address")
    WebElement  AddressLine1;

 //   @FindBy (css = "#customer-second-address")
 //   WebElement AddressLine2;

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

 //   @FindBy (css = "#general-owt-transfer__specify-inter-bank")
 //   WebElement IntermediaryBank;

//    @FindBy (css ="#intermediary-bankSwiftBic")
//    WebElement SWIFTBIC1;

//    @FindBy(css = "#intermediary-bankName")
//    WebElement IntermediaryBankName;

//    @FindBy (css = "#intermediary-address")
//    WebElement IntermediaryBankAddress;

//    @FindBy (css = "#intermediary-location")
//    WebElement IntermediaryBankLocation;

 //   @FindBy (xpath= "//*[@autocomplete=\"a842edd5e680\"]")
 //   WebElement IntermediaryBankCountryBox;

 //   @FindBy (css = "#aba762842a13")
//    WebElement IntermediaryBankCountry;

//    @FindBy (css = "#intermediarybank-acc-iban")
//    WebElement IntermediaryBankAccNumIBAN;

    @FindBy (css = "#outgoingAmountOptionsPipe")
    WebElement Amount;

    @FindBy (xpath = "//*[@ng-reflect-placeholder='Select currency']")
    WebElement CurrencyBox;

    @FindBy (xpath = "//*[contains(text(), \"Currency\")]/..//input")
    WebElement Currency;

 //   @FindBy (css = "#description")
//    WebElement Description;

    @FindBy(xpath="//*[contains(text(), \"Continue\")]")
    WebElement Continue;


    @FindBy(xpath = "//button[contains(text(), \"Confirm\")]")
    WebElement Confirm;

    @FindBy(css = ".popup-message")
    WebElement popup;



    public OutgoingWireTransferPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);
    }

    public void OutgoingWireTransfer() throws InterruptedException {
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
        wait.until(ExpectedConditions.visibilityOf(Confirm));
        Confirm.click();
        wait.until(ExpectedConditions.visibilityOf(popup));

    }

}
