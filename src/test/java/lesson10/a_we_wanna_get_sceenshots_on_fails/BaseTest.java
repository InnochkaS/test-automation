package lesson10.a_we_wanna_get_sceenshots_on_fails;


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
import java.text.SimpleDateFormat;
import java.util.Date;

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
            String path = System.getProperty("reports.path")+"/screenshots/" + screenshot.getName();

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

//        System.setProperty("webdriver.chrome.driver", "C:/Dev/Drivers/chromedriver");

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