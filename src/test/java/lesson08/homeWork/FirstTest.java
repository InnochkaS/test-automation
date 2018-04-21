package lesson08.homeWork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {

    private static final Logger LOG = LogManager.getLogger(FirstTest.class);

    @Test
    public void test_warning(){
        open("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        assertThat(ExpectedConditions.titleContains("Login"));
        Logs logs = getWebDriver().manage().logs();
        LogEntries logEntries = logs.get(LogType.BROWSER);

        for (LogEntry logEntry : logEntries) {
            String logMessage = logEntry.getMessage();
            if (logMessage.contains("credit card")) {
                LOG.info(logMessage);
            }
        }
    }


}

// 1. Создать тестовый класс со следующим тестом: поиск товара,
// добавление его в корзину, оформление заказа, покупка, проверка, что в истории заказов появился ИМЕННО ваш заказ.
// 2. Сделать логирование к методам пейдж-объектов.
// 3. Запустить тестовый класс через мавен и через IDE.
// 4. Закоммитить изменения, залить их на репозиторий GitHub и прислать ссылку.