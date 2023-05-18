package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectModel.LogInPage;
import pageObjectModel.TransferBetweenUsersPage;
import utility.Hooks;
import utility.ScenarioData;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class TransferBetweenUsers {

    WebDriver driver= Hooks.getDriver();
    LogInPage logIn = new LogInPage(driver);
    TransferBetweenUsersPage transfer = new TransferBetweenUsersPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("User transfers money")
    public void user_transfers_money() throws InterruptedException {
        logIn.openHomePage();
        Thread.sleep(2000);
        logIn.with(ScenarioData.get("username"), ScenarioData.get("password"));
        Thread.sleep(5000);
        transfer.TransferBetweenUsers();

    }
    @Then("Customer should be successfully transfers money")

    public void customer_should_be_successfully_transfers_money() throws InterruptedException {
        String expected = "Back to transfers";
        WebElement message = driver.findElement(By.cssSelector(".text_color-main_color"));
        wait.until(ExpectedConditions.textToBePresentInElement(message, expected));
        String actual = message.getText();
        assertEquals(expected, actual);
    }
}
