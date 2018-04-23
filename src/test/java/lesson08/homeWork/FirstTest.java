package lesson08.homeWork;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {

    //private static final Logger LOG = LogManager.getLogger(FirstTest.class);

    @Test
    public void test_buying() {

        String query = "Printed Summer Dress";

        MainPage mainPage = new MainPage(driver);
        mainPage.visit();
        assertThat(ExpectedConditions.titleContains("My Store"));
        mainPage.enterQuery(query);
        assertThat(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query));
        driver.findElement(By.name("submit_search")).click();
        assertThat(ExpectedConditions.titleContains("Search - My Store"));
        driver.findElement(By.linkText("Printed Summer Dress")).click();
        assertThat(ExpectedConditions.titleContains("Printed Summer Dress - My Store"));
        driver.findElement(By.id("add_to_cart")).click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));
        driver.findElement(By.linkText("Proceed to checkout")).click();
        driver.findElement(By.linkText("Proceed to checkout")).click();
        mainPage.login();
        driver.findElement(By.name("processAddress")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("uniform-cgv"))).click();
        driver.findElement(By.name("processCarrier")).click();
        assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText());
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
        assertEquals("ORDER SUMMARY", driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText());
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
        assertEquals("Your order on My Store is complete.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong\n")).getText());

        WebElement we = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div"));
        String str = we.getText();
        String orderRef = str.substring(str.indexOf("your order reference ") + "your order reference ".length(), str.indexOf(" in the subject of your bank wire"));

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        assertEquals("MY ACCOUNT", driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText());
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")).click();

        assertEquals(orderRef, driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[1]")).getText());
    }
}

// 1. Создать тестовый класс со следующим тестом:
// поиск товара, добавление его в корзину, оформление заказа, покупка, проверка, что в истории заказов появился ИМЕННО ваш заказ.
// 2. Сделать логирование к методам пейдж-объектов.
// 3. Запустить тестовый класс через мавен и через IDE.
// 4. Закоммитить изменения, залить их на репозиторий GitHub и прислать ссылку.