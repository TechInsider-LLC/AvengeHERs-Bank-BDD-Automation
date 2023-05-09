package pageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ScenarioData;

import java.time.Duration;

public class TransferBetweenAccountsPage {

    WebDriver driver;
    WebDriverWait wait;

  @FindBy(css = ".transfer")
  WebElement Transfers;

  @FindBy(css = ".section__heading")
    WebElement TransferBetweenAccounts;

  @FindBy(css = ".ng-value-container")
    WebElement DebitFrom;
  @FindBy(css = ".select-value")
  WebElement selectvalue;

  @FindBy(css = ".EBQ11113487654")
  WebElement Checking;

  @FindBy(css = ".ng-value-container")
  WebElement CreditTo;

  @FindBy(css = ".EBQ11223487456")
  WebElement Savings;

  @FindBy(css = ".native-input amount ng-pristine ng-invalid with-currency ng-touched")
  WebElement AmountToTransfer;

  @FindBy(xpath = "//*[@type='submit']")
  WebElement Continue;

  @FindBy(xpath = "//button[contains(text(), \"Confirm\")]")
  WebElement Confirm;

  @FindBy(css = ".popup-message")
  WebElement popup;

 public TransferBetweenAccountsPage(WebDriver driver){
   this.driver = driver;
   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   PageFactory.initElements(driver,this);
 }


  public void TransferBetweenAccounts() throws InterruptedException {


    Transfers.click();
    Thread.sleep(2000);
    wait.until(ExpectedConditions.visibilityOf(TransferBetweenAccounts));
    TransferBetweenAccounts.click();
    wait.until(ExpectedConditions.visibilityOf(DebitFrom));
    DebitFrom.click();



    Checking.sendKeys(ScenarioData.get("Checking"));
    CreditTo.click();
    Savings.sendKeys(ScenarioData.get("Savings"));
    AmountToTransfer.sendKeys(ScenarioData.get("amount"));
    Continue.click();
    Confirm.click();
  }
}
