package lesson07.e_move_page_object_to_separate_class;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {

    @Test
    public void firstResultShoudContainExpectedText() throws InterruptedException {
        String query1 = "Dress";
        String query2 = "T-shirt";
        MainPage mainPage = new MainPage(driver);
        mainPage.visit();

        mainPage.enterQuery(query1);
        (new WebDriverWait(driver, 10))
                .until(textToBePresentInElement(mainPage.ADVICE_LOCATOR, query1));

        mainPage.enterQuery(query2);
        (new WebDriverWait(driver, 10))
                .until(textToBePresentInElement(mainPage.ADVICE_LOCATOR, query2));

    }

}

