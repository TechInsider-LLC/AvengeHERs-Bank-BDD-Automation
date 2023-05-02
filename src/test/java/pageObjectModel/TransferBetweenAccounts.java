package pageObjectModel;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.TransferBetweenAccounts1;
import utility.Hooks;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class TransferBetweenAccounts {

    WebDriver driver= Hooks.getDriver();
    LogInPage logIn = new LogInPage(driver);
    TransferBetweenAccounts1 transfer = new TransferBetweenAccounts1(driver);


    @When("User transfers between accounts")
    public void user_transfers_between_accounts()  throws InterruptedException {

        logIn.openHomePage();
        Thread.sleep(3000);
        logIn.with("demo-user","Demo-Access1");
        Thread.sleep(3000);
        transfer.TransferBetweenAccounts();

    }

    @Then("User have to transfer successfully")
    public void user_have_to_transfer_successfully() {
        String expected = "Back to transfers.";
        String actual = driver.findElement(By.cssSelector(".text_color-main_color")).getText();
        assertEquals(expected, actual);

    }



}
