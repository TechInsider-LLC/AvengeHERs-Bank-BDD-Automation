package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjectModel.IncomingWireTransferPage;
import pageObjectModel.LogInPage;
import utility.TestRunner;
import utility.ScenarioData;

import static org.testng.Assert.assertEquals;

public class IncomingWireTransfer {

    WebDriver driver = TestRunner.getDriver();
    LogInPage logIn = new LogInPage(driver);
    IncomingWireTransferPage transfer = new IncomingWireTransferPage(driver);



    @When("Customer initiates an Incoming Wire Transfer")
    public void customer_initiates_an_incoming_wire_transfer() throws InterruptedException {
        logIn.openHomePage();
        logIn.with(ScenarioData.get("username"), ScenarioData.get("password"));
        Thread.sleep(3000);
        transfer.IncomingWireTransferPage();

    }
    @Then("Customer should be successfully Incoming Wire")
    public void customer_should_be_successfully_incoming_wire() throws InterruptedException {
        String expected = "Acc#/IBAN GB00EBANQ1201200055";
        String actual = driver.findElement(By.xpath("//*[contains(text(), \" GB00EBANQ1201200055 \")]")).getText();
        assertEquals(expected, actual);

    }
}
