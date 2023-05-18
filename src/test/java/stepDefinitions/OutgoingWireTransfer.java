package stepDefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
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

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class OutgoingWireTransfer {

    WebDriver driver = Hooks.getDriver();
    LogInPage logIn = new LogInPage(driver);
    OutgoingWireTransferPage transfer = new OutgoingWireTransferPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @When("User initiates an outgoing wire transfer")
    public void user_initiates_an_outgoing_wire_transfer() throws InterruptedException {
        logIn.openHomePage();
        logIn.with(ScenarioData.get("username"), ScenarioData.get("password"));
        Thread.sleep(2000);
        transfer.OutgoingWireTransfer();

    }

    @Then("Customer should be successfully outgoing wire transfer")
    public void customer_should_be_successfully_outgoing_wire_transfer() {
        String expected = "Back to transfers";
        WebElement message = driver.findElement(By.cssSelector(".text_color-main_color"));
        wait.until(ExpectedConditions.textToBePresentInElement(message, expected));
        String actual = message.getText();
        assertEquals(expected, actual);

       String id = driver.findElement(By.cssSelector(".success-popup")).getText().split("#")[1].split("\n")[0];


 //       1. Login for token
        Response response =
               given() .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"data\": {\n" +
                        "        \"email\": \"Bank-Admin\",\n" +
                        "        \"password\": \"Demo-Access1\"\n" +
                        "    }\n" +
                        "}")
        .when()
                .log().all()
                .post("https://api-demo.ebanq.com/users/public/v1/auth/signin")

        .then()
                .log().all()
                .statusCode(200).extract().response();
        String token = response.path("data.accessToken");
        Cookies cookies = response.getDetailedCookies();


//        2. Approve transaction with token
       given()
               .contentType(ContentType.JSON)
               .cookies(cookies)
                .header ("Authorization", "Bearer "+token)
        .when()
               .log().all()
                .post("https://api-demo.ebanq.com/accounts/private/v1/admin/requests/execute/"+ id)

       .then()
                .log().all()
                .statusCode(200);










        }
    }
