package lesson07.h_custom_condition;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest extends SimpleAPI {

    protected static WebDriver driver;

    @Before
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver", "/Users/Andrew/Downloads/chromedriver2");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public static void tearDown(){
        driver.quit();
    }

    @Override
    WebDriver getWebDriver() {
        return driver;
    }
}