package utility;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.time.Duration;



public class Hooks {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static final ThreadLocal<String> browser = new ThreadLocal<>();

    @Before
    public void setUp() {
        Hooks.chooseBrowser(browser.get());

    }

    public static WebDriver getDriver(){
        return driver.get();
    }
    public static void setDriver(WebDriver driver) {
        Hooks.driver.set(driver);
    }

    public static void chooseBrowser(String browserType) {
        System.out.println("choose browser");
        System.out.println(Thread.currentThread().getName());
        if ("firefox".equalsIgnoreCase(browserType)) {
            WebDriverManager.firefoxdriver().setup();
            WebDriver local = new FirefoxDriver();
            local.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            local.manage().window().maximize();
            driver.set(local);
        } else if ("chrome".equalsIgnoreCase(browserType) || StringUtils.isEmpty(browserType)) {
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver local = new ChromeDriver();
            local.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            local.manage().window().maximize();
            driver.set(local);
        } else {
            throw new IllegalArgumentException("Browser type not supported: " + browserType);
        }
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.get().quit();
   }

        public static boolean isJUnitTest() {
            for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
                if (element.getClassName().startsWith("org.junit.runner")) {
                    return true;
                }
            }
            return false;
        }

    public static boolean isTestNGTest() {
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            if (element.getClassName().equals("org.testng.")) {
                return true;
            }
        }
        return false;
    }

}

