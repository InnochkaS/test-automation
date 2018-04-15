package lesson06.homeWork;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class ATest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        //System.setProperty("webdriver.chrome.driver", "/Users/Andrew/Downloads/chromedriver2");
        System.setProperty("webdriver.chrome.driver", "C:/Dev/Drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown (){
        driver.quit();
    }

    @Test @Ignore
    public void logInFirstType() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        AccountPage accountPage = loginPage.logIn("sotnyk.inna@gmail.com", "123456");
        assertThat(driver.findElement(By.className("page-heading")).getText(),
                containsString("MY ACCOUNT"));
    }

    @Test @Ignore
    public void logInSecondType(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername("sotnyk.inna@gmail.com").enterPassword("123456").clickSignInBtn();
        assertThat(driver.findElement(By.className("page-heading")).getText(),
                containsString("MY ACCOUNT"));
    }

    @Test
    public void logOut(){
        String str1 = "MY ACCOUNT";
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        AccountPage accountPage = loginPage.logIn("sotnyk.inna@gmail.com", "123456");

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("page-heading")), str1));

        LoginPage lp2 = accountPage.signOut();
        assertThat(driver.findElement(By.id("login_form")).getText(),
                containsString("ALREADY REGISTERED?"));

    }
}

/*
4. Сделать тестовый класс с тремя тестами:
1 - на логин через метод logIn,
2 - на логин с использованием цепочки методов,
3 - на логаут (в тестах проверять, что нужная страница открылась, assertThat в помощь).
При запуске тестов делайте игнор для 1 или 2 теста.
 */