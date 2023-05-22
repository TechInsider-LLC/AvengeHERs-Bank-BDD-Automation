package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ScenarioData;

import java.time.Duration;

public class UpdateFirstNamePage {


        WebDriver driver;
        WebDriverWait wait;


        @FindBy(xpath = "//*[contains(text(), \"My Profile\")]")
        WebElement myProfile;

        @FindBy(xpath = "//*[@ng-reflect-router-link=\"profile\"]")
        WebElement editProfile;

        @FindBy(xpath = "//*[@ng-reflect-name=\"firstName\"]")
        WebElement firsName;

        @FindBy(xpath="//*[contains(text(), \" Update profile \")]")
        WebElement updateProfile;

        @FindBy(xpath = "//*[@ng-reflect-router-link=\"summary\"]")
        WebElement summary;


        public UpdateFirstNamePage(WebDriver driver){
            this.driver = driver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            PageFactory.initElements(driver, this);
        }

        public void updateFirstName() throws InterruptedException {

            myProfile.click();
            editProfile.click();
            firsName.click();
            firsName.clear();
            firsName.sendKeys(ScenarioData.get("newFirstName"));
            Thread.sleep(2000);
            updateProfile.click();
            summary.click();
        }

         public void changeBackFirstName() throws InterruptedException {
            wait.until(ExpectedConditions.visibilityOf(editProfile));
            editProfile.click();
            firsName.click();
            firsName.clear();
            firsName.sendKeys(ScenarioData.get("oldFirstName"));
            updateProfile.click();
            wait.until(ExpectedConditions.elementToBeClickable(summary));
            summary.click();
        }
}

