package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ScenarioData;

public class UpdateFirstNamePage {


        WebDriver driver;


        @FindBy(xpath = "//*[contains(text(), \"My Profile\")]")
        WebElement myProfile;

        @FindBy(xpath = "//*[@ng-reflect-router-link=\"profile\"]")
        WebElement editProfile;

        @FindBy(xpath = "//*[@ng-reflect-name=\"firstName\"]")
        WebElement firsName;

        @FindBy(css= "#internal-notes")
        WebElement updateProfile;

        @FindBy(xpath = "//*[@ng-reflect-router-link=\"summary\"]")
        WebElement summary;


        public UpdateFirstNamePage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void UpdateFirstNamePage(){

            myProfile.click();
            editProfile.click();
            firsName.click();
            firsName.clear();
            firsName.sendKeys(ScenarioData.get("firsName"));
            updateProfile.click();
            summary.click();
            editProfile.click();
            firsName.click();
            firsName.clear();
            firsName.sendKeys(ScenarioData.get("firsName"));
            summary.click();
        }

    }

