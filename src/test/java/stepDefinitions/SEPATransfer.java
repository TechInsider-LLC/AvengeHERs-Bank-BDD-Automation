package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectModel.LogInPage;
import pageObjectModel.SEPATransferPage;
import utility.WebDriverHelper;
import utility.ScenarioData;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class SEPATransfer {
    WebDriver driver = WebDriverHelper.getDriver();
    LogInPage login = new LogInPage(driver);
    SEPATransferPage transfer = new SEPATransferPage(driver);
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));



    @When("Customer transfers SEPA money")
    public void customer_transfers_sepa_money()  throws InterruptedException {
        login.openHomePage();
        login.with(ScenarioData.get("username"), ScenarioData.get("password"));
        Thread.sleep(3000);
        transfer.SEPATransfer();
    }

    @Then("SEPA transfer should successfully")
    public void sepa_transfer_should_successfully() {
        String expected = "Back to transfers";
        WebElement message = driver.findElement(By.cssSelector(".text_color-main_color"));
        wait.until(ExpectedConditions.textToBePresentInElement(message, expected));
        String actual = message.getText();
        assertEquals(expected, actual);


    }
}
