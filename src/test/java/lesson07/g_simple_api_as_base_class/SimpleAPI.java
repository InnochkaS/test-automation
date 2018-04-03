package lesson07.g_simple_api_as_base_class;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static lesson07.g_simple_api_as_base_class.BaseTest.driver;

public abstract class SimpleAPI {

    abstract WebDriver getWebdriver();

    protected void open(String url){
        driver.get(url);
    }

    protected WebElement $(By locator){
        return assertThat(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement $(String xpath){
        return $(By.xpath(xpath));

    protected List<WebElement> $$(By locator){
        return assertThat(visibilityOfElementLocated(locator));
        }
    }
    protected void assertThat(ExpectedCondition<WebElement> condition){
        (new WebDriverWait(driver, 10)).until(condition);
    }


    protected void assertThat(ExpectedCondition<Boolean>condition, int timeout){
        (new WebDriverWait(driver, 10)).until(condition);
    }


    protected private <V> V asserThat(Function<? super WebDriver, V> condition){
        return (new WebDriverWait(driver, 10)).until(condition);
    }

    protected private <V> V asserThat(Function<? super WebDriver, V> condition, int timeout){
        return (new WebDriverWait(driver, timeout).until(condition));
    }

    abstract WebDriver getWebDriver();
}
