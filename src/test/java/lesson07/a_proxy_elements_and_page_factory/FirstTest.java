package lesson07.a_proxy_elements_and_page_factory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.applet.Main;

import java.util.concurrent.TimeUnit;

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
        MainPage mainPage = new MainPage();

        mainPage.enterQuery(query1);
        (new WebDriverWait(driver, 10))
                .until(textToBePresentInElement(mainPage.advice, query1));

        mainPage.enterQuery(query2);
        (new WebDriverWait(driver, 10))
                .until(textToBePresentInElement(mainPage.advice, query2));

            }
//Page Factory to use
        class MainPage {

            //find and initialize all elements on the page
            @FindBy (xpath = "//*[@id=\"index\"]/div[2]/ul/li[1]")
            WebElement advice;

            @FindBy (id = "search_query_top")
            WebElement fieldQuery;

            //create constructor, запустить драйвер и проинициализировать параметрі класса
            MainPage() {
                PageFactory.initElements(driver, this);
            }

            void enterQuery (String query){
                fieldQuery.click();
                fieldQuery.clear();
                fieldQuery.sendKeys(query);
            }
        }

}

