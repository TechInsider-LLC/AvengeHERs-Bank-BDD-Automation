package pageObjectModel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
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
  @FindBy(xpath = "//*[contains(text(), 'EBQ38495629375')]/..")
  WebElement Checking;

  @FindBy(xpath = "//*[contains(text(), 'Credit to')]/..")
  WebElement CreditTo;

  @FindBy(css = ".ng-option")
  WebElement Savings;

  @FindBy(css = ".native-input amount ng-pristine ng-invalid with-currency ng-touched")
  WebElement AmountToTransfer;

  @FindBy(xpath = "//*[contains(text(), \"Continue\")]")
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

    //scroll to the view
    Actions action = new Actions(driver);
    action.moveToElement(Checking).perform();

    Checking.click();
    Thread.sleep(2000);
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

  }
}
