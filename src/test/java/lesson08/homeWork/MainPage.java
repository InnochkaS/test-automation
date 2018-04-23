package lesson08.homeWork;

import com.oracle.tools.packager.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.CredsManager;

class MainPage extends BasePage implements MainPageLocators {

    private static final Logger LOG = LogManager.getLogger(FirstTest.class);

    private WebDriver driver;

    MainPage(WebDriver driver) {
        super(driver);
    }

    void enterQuery(String query) {

        LOG.info("Method enterQuery has been called with parameter query {}.", query);

        $(FIELD_QUERY_LOCATOR).click();
        $(FIELD_QUERY_LOCATOR).clear();
        $(FIELD_QUERY_LOCATOR).sendKeys(query);
    }

    void visit() {
        LOG.info("Page automationpractice.com was visited.");
        open("http://automationpractice.com/index.php");
    }

    public void login() {
        $(By.id("email")).sendKeys(CredsManager.getCred("username"));
        $(By.id("passwd")).sendKeys(CredsManager.getCred("passwd"));
        $(By.id("SubmitLogin")).click();

    }
}