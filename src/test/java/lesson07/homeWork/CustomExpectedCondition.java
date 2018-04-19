package lesson07.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CustomExpectedCondition {

    public static ExpectedCondition<List<WebElement>> listShouldHaveSize(By locator, int expSize) {
        return new ExpectedCondition<List<WebElement>>() {
            @Override
            public List<WebElement> apply(WebDriver driver) {
                List<WebElement> list = driver.findElements(locator);
                return list.size() == expSize ? list : null;
            }
        };
    }

    public static ExpectedCondition<Boolean> listNthElementHasText(By locator, int position, String text) {

        return new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {

                List<WebElement> elements = driver.findElements(locator);
                return position < elements.size() && elements.get(position).getText().contains(text);
            }
        };
    }


    public static ExpectedCondition<Boolean> pageIsLoaded(String title, String url) {

        return new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().contains(title) && driver.getCurrentUrl().contains(url);
            }
        };
    }

    public static ExpectedCondition<Boolean> stalenessOfElement(By locator) {

        return new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {

                List<WebElement> elements = driver.findElements(locator);
                return !elements.isEmpty() && ExpectedConditions.invisibilityOf(elements.get(0)).apply(driver);
            }
        };
    }
}

/* 1. Создайте три кастомные ожидания:

- listNthElementHasText,
которое по локатору, проверяет, что элемент с указанным номером содержит указанный текст
(не забудьте обработать IndexOutOfBoundsException!!!);

- pageIsLoaded, которое, ждет, чтоб титул страницы и ее url содержали указанные тексты;

- stalenessOfElement, которое проверяет, что элемент исчез со страницы.

2. Сделайте тест сьют с тремя тестами по одному на каждое ожидание
*/