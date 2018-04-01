package lesson05.homeWork;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.*;
import static org.hamcrest.core.StringContains.containsString;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {

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

    @Before //can be moved to BeforeClass if not needed to log in before each test scenario
    public void signInToWebsiteWithRegisteredUser(){
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("sotnyk.inna@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("123456");
        driver.findElement(By.id("SubmitLogin")).click();
        assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText(),containsString("MY ACCOUNT"));
    }


    @After //if @before is removed so not needed anymore
    public void signOutAfterEachTestCompletion(){
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
        assertThat(driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText()
                ,containsString("Sign in"));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void openPageOrderHistoryAndDetails(){
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a")).click();
        assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText()
                ,containsString("ORDER HISTORY"));
    }

    @Test
    public void openPageMyCreditSlips(){
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[2]/a/span")).click();
        assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText()
                ,containsString("CREDIT SLIPS"));
    }

    @Test
    public void openPageMyAdress(){
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span")).click();
        assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText()
                ,containsString("MY ADDRESSES"));
    }

    @Test
    public void openPageMyPersonalInformation(){
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span")).click();
        assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/h1")).getText()
                ,containsString("YOUR PERSONAL INFORMATION"));
    }

    @Test
    public void openPageMyWishlists(){
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span")).click();
        assertThat(driver.findElement(By.xpath("//*[@id=\"mywishlist\"]/h1")).getText()
                ,containsString("MY WISHLISTS"));
    }
}


/*
2.1. LoginTest со следующими тестами: 1й - логин и
2-6 - возможность открытия страничек "ORDER HISTORY AND DETAILS", "MY CREDIT SLIPS",
"MY ADDRESSES", "MY PERSONAL INFORMATION" и "MY WISHLISTS".
 */