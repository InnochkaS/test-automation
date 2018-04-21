package lesson10.homeWork;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class BaseTest extends SimpleAPI {

    protected static WebDriver driver;

    private static final Logger LOG = LogManager.getLogger(FirstTest.class);

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            captureScreenshot(description.getMethodName());
        }

        private void captureScreenshot(String methodName) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("report.path")+"/screenshots/" + screenshot.getName();

            try {
                FileUtils.copyFile(screenshot, new File(path));
                LOG.error("Screenshot was got :"+ screenshot.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };


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