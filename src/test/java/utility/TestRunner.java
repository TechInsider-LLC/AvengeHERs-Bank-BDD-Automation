package utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;


@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions", "utility"},
        tags = "@smoke",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

    private static WebDriver driver;
    private Config config;

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
            driver = new RemoteWebDriver(new URL(config.getUrl()), options);
        } else if (browser.equalsIgnoreCase("safari")) {
            SafariOptions options = loadSafariOptions();
            driver = new RemoteWebDriver(new URL(config.getUrl()), options);
        }
    }

    private void loadConfig() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            config = mapper.readValue(new File("src/test/resources/saucelabsconfig.yml"), Config.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load saucelabsconfig.yml", e);
        }
    }

    private ChromeOptions loadChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setPlatformName(config.getChromeOptions().getPlatformName());
        options.setBrowserVersion(config.getChromeOptions().getBrowserVersion());
        options.setCapability("sauce:options", config.getChromeSauceOptions());
        return options;
    }


    private SafariOptions loadSafariOptions() {
        SafariOptions options = new SafariOptions();
        options.setPlatformName(config.getSafariOptions().getPlatformName());
        options.setBrowserVersion(config.getSafariOptions().getBrowserVersion());
        options.setCapability("sauce:options", config.getSafariSauceOptions());
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
