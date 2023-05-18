package utility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Hooks {


    private static WebDriver driver;
    public static String userName, accessKey;
    public static Map<String, Object> browserStackYamlMap;
    public static final String USER_DIR = "user.dir";

    public Hooks() {
        File file = new File(getUserDir() + "/src/test/resources/browserstack.yml");
        browserStackYamlMap = convertYamlFileToMap(file, new HashMap<>());
    }


    @Before
    public void setUp() throws MalformedURLException {
        if (!isJUnitTest()){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();

        }else {
            MutableCapabilities capabilities = new MutableCapabilities();
            userName = System.getenv("BROWSERSTACK_USERNAME") != null ? System.getenv("BROWSERSTACK_USERNAME") : (String) browserStackYamlMap.get("userName");
            accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY") != null ? System.getenv("BROWSERSTACK_ACCESS_KEY") : (String) browserStackYamlMap.get("accessKey");
            HashMap<String, Object> bStackOptions = new HashMap<>();
            bStackOptions.put("source", "junit4:sample-master:v1.2");
            capabilities.setCapability("bstack:options", bStackOptions);
            driver = new RemoteWebDriver(
                    new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub", userName, accessKey)), capabilities);

        }


    }

    @After
    public void tearDown() {
        driver.quit();
    }
    public static WebDriver getDriver(){
        return driver;
    }

    private String getUserDir() {
        return System.getProperty(USER_DIR);
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

    public static boolean isJUnitTest() {
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            if (element.getClassName().startsWith("org.junit.runner")) {
                return true;
            }
        }
        return false;
    }

}

