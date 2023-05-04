package pageObjectModel;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OutgoingWireTransferPage {

    WebDriver driver;

    @FindBy(css =".transfer")
    WebElement Transfers;

    @FindBy(css="[ng-reflect-router-link=\"outgoing-wire-transfer\"]")
    WebElement OutgoingWireTransferPage;

    @FindBy(css = ".ng-select-opened")
    WebElement DebitForm;

    @FindBy(css = "#a013f4f84337")
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

    @FindBy (xpath = "//*[@autocomplete=\"aedfbc1ee837\"]")
    WebElement CustomerCountryBox;

    @FindBy (css = "#a304b8ce3122")
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
    


    public OutgoingWireTransferPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void OutgoingWireTransfer(){
        Transfers.click();
        OutgoingWireTransferPage.click();
        DebitForm.click();
        Card.click();
        SWIFTBIC.sendKeys("SMCOGB2L");
        CustomerName.sendKeys("Jane");
        AddressLine1.sendKeys("2009 85th Str. Apt.2");
        City.sendKeys("Brooklyn");
        StateProvinceRegion.sendKeys("New York");
        CustomerCountryBox.click();
        CustomerCountry.click();
        AccNumIBAN.sendKeys("AL35202111090000000001234567");
        RefMessage.sendKeys("Invoice Payment #1234");
        Amount.sendKeys("1000");
        CurrencyBox.click();
        Currency.click();
        Continue.click();

    }

}
