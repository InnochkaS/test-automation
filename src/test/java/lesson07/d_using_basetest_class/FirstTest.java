package lesson07.d_using_basetest_class;

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

import static lesson07.d_using_basetest_class.MainPageLocators.FIELD_QUERY_LOCATOR;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {

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



        class MainPage implements MainPageLocators {

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

