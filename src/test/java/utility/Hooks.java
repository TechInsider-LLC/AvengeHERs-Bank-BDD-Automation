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
import java.util.List;
import java.util.Map;

public class Hooks {

//
//    private static WebDriver driver;
//    public static String userName, accessKey;
//    public static Map<String, Object> browserStackYamlMap;
//    public static final String USER_DIR = "user.dir";
//
//    public Hooks() {
//        File file = new File(getUserDir() + "/src/test/resources/browserstack.yml");
//        browserStackYamlMap = convertYamlFileToMap(file, new HashMap<>());
//    }
//
//
////    @Before
//    public void setUp() throws MalformedURLException {
//        if (isTestngTest()){
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//            driver.manage().window().maximize();
//        }else {
//            List<Map<String, String>> platforms =  (List<Map<String, String>>) browserStackYamlMap.get("platforms");
//
//            userName = (String) browserStackYamlMap.get("userName");
//            accessKey = (String) browserStackYamlMap.get("accessKey");
//
//            for (Map<String, String> platform : platforms) {
//
//                HashMap<String, Object> bStackOptions = new HashMap<>();
//                bStackOptions.put("source", "junit4:sample-master:v1.2");
//                bStackOptions.put("os", platform.get("os"));
//                bStackOptions.put("osVersion", String.valueOf(platform.get("osVersion")));
//                bStackOptions.put("browserName", platform.get("browserName"));
//                bStackOptions.put("browserVersion", platform.get("browserVersion"));
//
//                MutableCapabilities capabilities = new MutableCapabilities();
//                capabilities.setCapability("bstack:options", bStackOptions);
//
//                driver = new RemoteWebDriver(new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub", userName, accessKey)), capabilities);
//            }
//
//        }
//
//
//    }
//
////    @After
//    public void tearDown() {
//        if(driver != null){
//            driver.quit();
//        }
//    }
//    public static WebDriver getDriver(){
//        return driver;
//    }
//
//    private String getUserDir() {
//        return System.getProperty(USER_DIR);
//    }
//
//    private Map<String, Object> convertYamlFileToMap(File yamlFile, Map<String, Object> map) {
//        try {
//            InputStream inputStream = Files.newInputStream(yamlFile.toPath());
//            Yaml yaml = new Yaml();
//            Map<String, Object> config = yaml.load(inputStream);
//            map.putAll(config);
//        } catch (Exception e) {
//            throw new RuntimeException(String.format("Malformed browserstack.yml file - %s.", e));
//        }
//        return map;
//    }
//
//    public static boolean isTestngTest() {
//        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
//            if (element.getClassName().startsWith("org.testng.runner")) {
//                return true;
//            }
//        }
//        return false;
//    }

}

