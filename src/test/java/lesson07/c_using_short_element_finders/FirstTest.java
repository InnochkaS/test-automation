package lesson07.c_using_short_element_finders;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

@RunWith(JUnit4.class)
public class FirstTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown (){
        driver.quit();
    }

    @Test
    public void firstResultShoudContainExpectedText() throws InterruptedException {
        String query1 = "Dress";
        String query2 = "T-shirt";
        MainPage mainPage = new MainPage(driver);

        mainPage.enterQuery(query1);
        (new WebDriverWait(driver, 10))
                .until(textToBePresentInElement(mainPage.ADVICE_LOCATOR, query1));

        mainPage.enterQuery(query2);
        (new WebDriverWait(driver, 10))
                .until(textToBePresentInElement(mainPage.ADVICE_LOCATOR, query2));

            }

        class MainPage implements MainPageLocators{

            private  WebDriver driver;

            MainPage(WebDriver driver) {
                this.driver = driver;
            }

            void enterQuery (String query){
               $(FIELD_QUERY_LOCATOR).click();
               $(FIELD_QUERY_LOCATOR).clear();
               $(FIELD_QUERY_LOCATOR).sendKeys(query);
            }

            WebElement $(By locator){
                return driver.findElement(locator);
            }
        }

}

