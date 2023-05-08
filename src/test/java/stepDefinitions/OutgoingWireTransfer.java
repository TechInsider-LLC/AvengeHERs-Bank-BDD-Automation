package stepDefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectModel.LogInPage;
import pageObjectModel.OutgoingWireTransferPage;
import utility.Hooks;
import utility.ScenarioData;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class OutgoingWireTransfer {

    WebDriver driver= Hooks.getDriver();
    LogInPage logIn = new LogInPage(driver);
    OutgoingWireTransferPage transfer = new OutgoingWireTransferPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    @When("User initiates an outgoing wire transfer")
    public void user_initiates_an_outgoing_wire_transfer() throws InterruptedException {
        logIn.openHomePage();
        logIn.with(ScenarioData.get("username"),ScenarioData.get("password"));
        transfer.OutgoingWireTransfer();

    }
    @Then("Customer should be successfully outgoing wire transfer")
    public void customer_should_be_successfully_outgoing_wire_transfer(){
        String expected = "Back to transfers";
        WebElement message = driver.findElement(By.cssSelector(".text_color-main_color"));
        wait.until(ExpectedConditions.textToBePresentInElement(message, expected));
        String actual = message.getText();
        assertEquals(expected, actual);

    }
}
