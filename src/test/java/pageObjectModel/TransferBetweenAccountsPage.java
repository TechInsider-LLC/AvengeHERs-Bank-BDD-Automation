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

  @FindBy(css = "[ng-reflect-router-link=\"transfer-between-accounts\"]")
    WebElement TransferBetweenAccounts;

  @FindBy(css=".ng-value-container")
    WebElement DebitFrom;
  @FindBy(css = ".ng-option-marked")
  WebElement Checking;

  @FindBy(css = ".ng-value-container")
  WebElement CreditTo;

  @FindBy(css = ".ng-option")
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
    wait.until(ExpectedConditions.visibilityOf(Checking));
    Checking.click();
    wait.until(ExpectedConditions.elementToBeClickable(CreditTo));
    CreditTo.click();
    wait.until(ExpectedConditions.visibilityOf(Savings));
    Savings.click();
    wait.until(ExpectedConditions.visibilityOf(AmountToTransfer));
    AmountToTransfer.sendKeys(ScenarioData.get("amount"));
    wait.until(ExpectedConditions.elementToBeClickable(Continue));
    Continue.click();
    wait.until(ExpectedConditions.visibilityOf(Confirm));
    Confirm.click();
    wait.until(ExpectedConditions.visibilityOf(popup));
    popup.click();
  }
}