package utility;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.SystemUtils.getUserDir;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions", "utility"},
        tags = "@smoke",
        plugin = { "pretty", "html:target/cucumber-reports.html" }
)

public class TestRunner extends AbstractTestNGCucumberTests {

    private static WebDriver driver;
    private static Map<String, Object> browserStackYamlMap;

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
        File file = new File(getUserDir() + "/src/test/resources/browserstack.yml");
        browserStackYamlMap = convertYamlFileToMap(file, new HashMap<>());
        String userName = (String) browserStackYamlMap.get("userName");
        String accessKey = (String) browserStackYamlMap.get("accessKey");

        List<Map<String, String>> platforms = (List<Map<String, String>>) browserStackYamlMap.get("platforms");
        Map<String, String> selectedPlatform = null;
        for (Map<String, String> platform : platforms) {
            if (browser.equalsIgnoreCase(platform.get("browserName"))) {
                selectedPlatform = platform;
                break;
            }
        }

        if (selectedPlatform == null) {
            throw new RuntimeException("Invalid browser configuration in browserstack.yml");
        }

        HashMap<String, Object> bStackOptions = new HashMap<>();
        bStackOptions.put("source", "junit4:sample-master:v1.2");
        bStackOptions.put("os", selectedPlatform.get("os"));
        bStackOptions.put("osVersion", String.valueOf(selectedPlatform.get("osVersion")));
        bStackOptions.put("browserName", selectedPlatform.get("browserName"));
        bStackOptions.put("browserVersion", selectedPlatform.get("browserVersion"));

        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("bstack:options", bStackOptions);

        driver = new RemoteWebDriver(new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub", userName, accessKey)), capabilities);
    }

    private Map<String, Object> convertYamlFileToMap(File yamlFile, Map<String, Object> map) {
        try {
            InputStream inputStream = Files.newInputStream(yamlFile.toPath());
            Yaml yaml = new Yaml();
            Map<String, Object> config = yaml.load(inputStream);
            map.putAll(config);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Malformed browserstack.yml file - %s.", e));
        }
        return map;
    }

    public static WebDriver getDriver(){
        return driver;
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}


