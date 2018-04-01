package lesson05.homeWork;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class SearchTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver", "/Users/Andrew/Downloads/chromedriver2");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();


    }
    @AfterClass
    public static void tearDown (){
        driver.quit();
    }

    @Test
    public void searchResultHasExpectedContent(){
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("Printed Summer Dress");
        driver.findElement(By.id("search_query_top")).submit();
        assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div[2]/div[2]")).getText(),
                containsString("Showing 1 - 3 of 3 items"));
        assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).getText(),
                containsString("Printed Summer Dress"));
    }

}

/*
2.2. SearchTest с одним тестом: открыть сайт, ввести в поиск "Printed Summer Dress" ,
нажать поиск, проверить, что три результата и первый совпадает с запросом.
 */
