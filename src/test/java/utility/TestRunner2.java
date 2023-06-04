package utility;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;


@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions", "utility"},
        tags = "@smoke",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner2 extends AbstractTestNGCucumberTests {

    private static WebDriver driver;
    private static Map<String, Object> config;

    @Parameters({"browser", "isRemote"})
    @BeforeTest
    public void setUp(String browser, @Optional("false") Boolean isRemote) throws MalformedURLException {
        if (isRemote) {
            setUpRemoteDriver(browser);
        } else {
            setUpLocalDriver(browser);
        }
    }

    private void setUpLocalDriver(String browser) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    private void setUpRemoteDriver(String browser) throws MalformedURLException {
        loadConfig();
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = loadChromeOptions();
            driver = new RemoteWebDriver(new URL((String) config.get("url")), options);
        } else if (browser.equalsIgnoreCase("safari")) {
            SafariOptions options = loadSafariOptions();
            driver = new RemoteWebDriver(new URL((String) config.get("url")), options);
        }
    }

    private void loadConfig() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("saucelabsconfig.yml");
        config = yaml.load(inputStream);
    }

    private ChromeOptions loadChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setPlatformName((String) ((Map) config.get("chromeOptions")).get("platformName"));
        options.setBrowserVersion((String) ((Map) config.get("chromeOptions")).get("browserVersion"));
        Map<String, Object> sauceOptions = (Map<String, Object>) ( config.get("chromeSauceOptions"));
        options.setCapability("sauce:options", sauceOptions);
        return options;
    }

    private SafariOptions loadSafariOptions() {
        SafariOptions options = new SafariOptions();
        options.setPlatformName((String) ((Map) config.get("safariOptions")).get("platformName"));
        options.setBrowserVersion((String) ((Map) config.get("safariOptions")).get("browserVersion"));
        Map<String, Object> sauceOptions = (Map<String, Object>) ( config.get("safariSauceOptions"));
        options.setCapability("sauce:options", sauceOptions);
        return options;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
