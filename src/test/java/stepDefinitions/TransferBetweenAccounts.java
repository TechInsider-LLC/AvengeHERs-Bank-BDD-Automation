package stepDefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectModel.LogInPage;
import pageObjectModel.TransferBetweenAccountsPage;
import utility.TestRunner;
import utility.ScenarioData;


import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class TransferBetweenAccounts {

    WebDriver driver = TestRunner.getDriver();
    LogInPage logIn = new LogInPage(driver);
    TransferBetweenAccountsPage transfer = new TransferBetweenAccountsPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));



    @When("User transfers between accounts")
    public void user_transfers_money() throws InterruptedException {

        logIn.openHomePage();
        Thread.sleep(2000);
         logIn.with(ScenarioData.get("username"), ScenarioData.get("password"));
        Thread.sleep(5000);
        transfer.TransferBetweenAccounts();

    }



    @Then("User have to transfer successfully")
    public void user_have_to_transfer_successfully() throws InterruptedException {
        String expected = "Back to transfers";
        WebElement message = driver.findElement(By.xpath("//*[@href=\"/transfer\"]"));
        String actual = message.getText();
        assertEquals(expected, actual);

    }
}




