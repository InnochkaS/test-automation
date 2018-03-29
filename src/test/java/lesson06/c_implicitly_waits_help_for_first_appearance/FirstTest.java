package lesson06.c_implicitly_waits_help_for_first_appearance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

@RunWith(JUnit4.class)
public class FirstTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
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
    public void firstResultShoudContainExpectedText() throws InterruptedException {
        String query1 = "Dress";
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys(query1);

        assertThat(driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")).getText(),
                containsString(query1));

        driver.findElement(By.id("search_query_top")).clear();

        String query2 = "T-shirt";
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys(query2);

        assertThat(driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")).getText(),
                containsString(query2));

    }

}

/* not found text because new element was not loaded before comparecing
java.lang.AssertionError:
Expected: a string containing "T-shirt"
     but: was "Summer Dresses > Printed Summer Dress"
Expected :a string containing "T-shirt"
 */
