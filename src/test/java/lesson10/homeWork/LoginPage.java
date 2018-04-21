package lesson10.homeWork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CredsManager;

public class LoginPage extends BasePage {
    private static final Logger LOG = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void email (){
        $(By.id("email")).sendKeys(CredsManager.getCred("username"));};

    public void password(){
        $(By.id("passwd")).sendKeys("000000");
        $(By.id("SubmitLogin")).click();
    }

    private void setValue(WebElement element, String value){
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public void visit(){
        open("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }
}
