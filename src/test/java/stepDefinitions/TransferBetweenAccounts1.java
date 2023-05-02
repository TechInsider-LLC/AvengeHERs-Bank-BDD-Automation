package stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjectModel.TransferBetweenAccounts;

import java.time.Duration;
import java.time.Instant;

public class TransferBetweenAccounts1 {

    WebDriver driver;

  @FindBy(css = ".aside__label main_color transfer")
  WebElement Transfers;

  @FindBy(css = ".section__heading")
    WebElement TransferBetweenAccounts;

  @FindBy(css = ".ng-value-container")
    WebElement DebitFrom;

  @FindBy(css = ".EBQ11113487654")
  WebElement Checking;

  @FindBy(css = ".ng-value-container")
  WebElement CreditTo;

  @FindBy(css = ".EBQ11223487456")
  WebElement Savings;

  @FindBy(css = ".native-input amount ng-pristine ng-invalid with-currency ng-touched")
  WebElement AmountToTransfer;

  @FindBy(css = ".def-btn-success main_color")
  WebElement Continue;

  @FindBy(css = ".def-btn-success main_color")
  WebElement Confirm;

  @FindBy(css = ".popup-message")
  WebElement popup;

 public TransferBetweenAccounts1(WebDriver driver){
   this.driver = driver;
   PageFactory.initElements(driver,this);
 }


  public void TransferBetweenAccounts() {

    WebDriverManager.firefoxdriver().setup();
    WebDriver driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    Transfers.click();
    TransferBetweenAccounts.click();
    DebitFrom.click();
    Checking.sendKeys("EBQ11113487654");
    CreditTo.click();
    Savings.sendKeys("EBQ11223487456");
    AmountToTransfer.sendKeys("10000");
    Continue.click();
    Confirm.click();
  }
}
