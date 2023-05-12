package stepDefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjectModel.LogInPage;
import pageObjectModel.TransferBetweenAccountsPage;
import utility.Hooks;
import utility.ScenarioData;



import static org.junit.Assert.assertEquals;

public class TransferBetweenAccounts {

    WebDriver driver = Hooks.getDriver();
    LogInPage logIn = new LogInPage(Hooks.getDriver());
    TransferBetweenAccountsPage transfer = new TransferBetweenAccountsPage(driver);



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
        String expected = "Back to transfers.";
        Thread.sleep(3000);
        String actual = driver.findElement(By.cssSelector(".text_color-main_color")).getText();
        assertEquals(expected, actual);

    }
}




