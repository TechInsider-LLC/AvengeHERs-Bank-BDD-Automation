package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjectModel.LogInPage;
import pageObjectModel.OutgoingWireTransferPage;
import utility.Hooks;

import static org.junit.Assert.assertEquals;

public class OutgoingWireTransfer {

    WebDriver driver= Hooks.getDriver();
    LogInPage logIn = new LogInPage(driver);
    OutgoingWireTransferPage transfer = new OutgoingWireTransferPage(driver);


    @When("User initiates an outgoing wire transfer")
    public void user_initiates_an_outgoing_wire_transfer() throws InterruptedException {
        logIn.openHomePage();
        Thread.sleep(2000);
        logIn.with("demo-user","Demo-Access1");
        transfer.OutgoingWireTransfer();

    }
    @Then("Customer should be successfully outgoing wire transfer")
    public void customer_should_be_successfully_outgoing_wire_transfer() throws InterruptedException {
        String expected = "Back to transfers";
        Thread.sleep(2000);
        String actual = driver.findElement(By.cssSelector(".text_color-main_color")).getText();
        assertEquals(expected, actual);

    }

}
