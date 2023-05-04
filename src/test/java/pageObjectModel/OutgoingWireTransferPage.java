package pageObjectModel;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OutgoingWireTransferPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css =".transfer")
    WebElement Transfers;

    @FindBy(css="[ng-reflect-router-link=\"outgoing-wire-transfer\"]")
    WebElement OutgoingWireTransferPage;


    @FindBy(xpath = "//*[@ng-reflect-select-label='Debit From']")
    WebElement DebitForm;

    @FindBy(css = ".ng-select-bottom #adcf4acf48a8")
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

    @FindBy (css = "#adfa5273bdc9")
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

    @FindBy (xpath = "//*[@autocomplete=\"ab3b936ea7db\"]")
    WebElement CurrencyBox;

    @FindBy (css = "#a955ce5f8303")
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
        Thread.sleep(2000);
        Transfers.click();
        Thread.sleep(2000);
        OutgoingWireTransferPage.click();
        Thread.sleep(2000);
        DebitForm.click();
        Thread.sleep(3000);
        Card.click();
        Thread.sleep(2000);
        SWIFTBIC.sendKeys("SMCOGB2L");
        Thread.sleep(2000);
        CustomerName.sendKeys("Jane");
        Thread.sleep(2000);
        AddressLine1.sendKeys("2009 85th Str. Apt.2");
        Thread.sleep(2000);
        City.sendKeys("Brooklyn");
        StateProvinceRegion.sendKeys("New York");
        Thread.sleep(2000);
        CustomerCountryBox.click();
        Thread.sleep(2000);
        CustomerCountry.click();
        AccNumIBAN.sendKeys("AL35202111090000000001234567");
        RefMessage.sendKeys("Invoice Payment #1234");
        Amount.sendKeys("1000");
        CurrencyBox.click();
        Currency.click();
        Continue.click();
        Confirm.click();
        wait.until(ExpectedConditions.visibilityOf(popup));

    }

}
