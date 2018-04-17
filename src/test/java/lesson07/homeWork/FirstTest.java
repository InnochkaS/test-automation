package lesson07.homeWork;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static lesson07.homeWork.CustomExpectedCondition.listNthElementHasText;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {

    @Test
    public void firstResultShouldContainExpectedText() {
        String query1 = "Dress";
        String query2 = "T-shirt";
        MainPage mainPage = new MainPage(driver);
        mainPage.visit();
        assertThat(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().equals("My Store");
            }
        });

        mainPage.enterQuery(query1);
        assertThat(CustomExpectedCondition.listShouldHaveSize(mainPage.ADVICE_LOCATOR, 7));
        assertThat(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query1));

        mainPage.enterQuery(query2);
        assertThat(CustomExpectedCondition.listShouldHaveSize(mainPage.ADVICE_LOCATOR, 1));
        assertThat(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query2));
    }

   @Test
    public void testListNthElementHasText(){
       String query1 = "Dress";
       String query2 = "T-shirt";
       MainPage mainPage = new MainPage(driver);
       mainPage.visit();
       assertThat(new ExpectedCondition<Boolean>() {
           @Override
           public Boolean apply(WebDriver driver) {
               return driver.getTitle().equals("My Store");
           }
       });

       mainPage.enterQuery(query1);
       assertThat(CustomExpectedCondition.listNthElementHasText(mainPage.ADVICE_LOCATOR, 4, "Dress"), 20);
       assertThat(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query1));

       mainPage.enterQuery(query2);
       assertThat(CustomExpectedCondition.listNthElementHasText(mainPage.ADVICE_LOCATOR, 0, "T-shirt"));
       assertThat(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query2));
   }

   @Test
   public void testPageIsLoaded(){

        MainPage mainPage = new MainPage(driver);
        mainPage.visit();
        assertThat(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().equals("My Store");
            }
        });

        assertThat(CustomExpectedCondition.pageIsLoaded("My Store", "http://automationpractice.com/index.php"));

    }

    @Test
    public void tesStalenessOfElement(){

       String query1 = "Dress";
       String query2 = "T-shirt";
        MainPage mainPage = new MainPage(driver);
        mainPage.visit();
        assertThat(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().equals("My Store");
            }
        });

        mainPage.enterQuery(query1);
        assertThat(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query1));
        mainPage.enterQuery(query2);
        assertThat(CustomExpectedCondition.stalenessOfElement(mainPage.MISSED_LOCATOR));



    }


}


/* 1. Создайте три кастомные ожидания:
listNthElementHasText,
pageIsLoaded
stalenessOfElement
2. Сделайте тест сьют с тремя тестами по одному на каждое ожидание
*/