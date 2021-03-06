package lesson07.homeWork;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest extends SimpleAPI {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver", "/Users/Andrew/Downloads/chromedriver2");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Override
    WebDriver getWebDriver() {
        return driver;
    }
}