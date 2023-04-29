package pageObjectModel;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepDefinitions.TransferBetweenUsersPage;
import utility.Hooks;

import static org.junit.Assert.assertEquals;

public class TransferBetweenUsers {

    WebDriver driver= Hooks.getDriver();
    LogInPage logIn = new LogInPage(driver);
    TransferBetweenUsersPage transfer = new TransferBetweenUsersPage(driver);

    @When("User transfers money")
    public void user_transfers_money() throws InterruptedException {
        logIn.openHomePage();
        Thread.sleep(2000);
        logIn.with("demo-user","Demo-Access1");
        Thread.sleep(5000);
        transfer.TransferBetweenUsers();

    }
    @Then("Customer should be successfully transfers money")
    public void customer_should_be_successfully_transfers_money() {
        String expected = "Back to transfers.";
        String actual = driver.findElement(By.cssSelector(".text_color-main_color")).getText();
        assertEquals(expected, actual);
    }
}