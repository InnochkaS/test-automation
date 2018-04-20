package lesson09.homeWork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {

    private static final Logger LOG = LogManager.getLogger(FirstTest.class);

    IndexPage indexPage = new IndexPage(driver);

    @Test
    public void iFrameTest() throws InterruptedException {

        indexPage.visit();
        assertThat(titleContains("My Store"));

        WebElement element = driver.findElement(By.xpath("//*[@id=\"facebook_block\"]/div/div/span/iframe"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(element);

        String frameTitle = (String)((JavascriptExecutor) driver).executeScript("return document.title;");

        assertEquals("Facebook", frameTitle);

        driver.switchTo().parentFrame();
        assertThat(titleContains("My Store"));


    }
}

/* 1. Создать тестовый класс со следующим тестом:
проверка текста линки в iFrame (см. скриншот fb-iFrame.png) предусмотреть в тесте scroll к этому iFrame с помощью javaScript.
2. Запустить тестовый класс через мавен и через IDE.
3. Закоммитить изменения, залить их на репозиторий GitHub и прислать ссылку.*/

