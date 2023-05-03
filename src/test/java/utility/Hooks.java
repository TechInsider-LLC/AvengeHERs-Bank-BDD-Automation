package utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Hooks {


    private static WebDriver driver;

    public static WebDriver getDriver(){

        return driver;
    }

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() throws InterruptedException {
//        driver.quit();
    }
}

