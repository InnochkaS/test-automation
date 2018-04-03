package lesson07.g_simple_api_as_base_class;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class MainPage implements MainPageLocators {

    private WebDriver driver;

    MainPage(WebDriver driver) {

        super (driver);
    }



    void enterQuery (String query){
       $(FIELD_QUERY_LOCATOR).click();
       $(FIELD_QUERY_LOCATOR).clear();
       $(FIELD_QUERY_LOCATOR).sendKeys(query);
    }
 //added method visit which page to visit
    void visit (){

        driver.get("http://automationpractice.com/index.php");
    }

//    WebElement $(By locator){
//
//        return driver.findElement(locator);
//    }
//

    //find element and return this elelemnt
    WebElement $(By locator){
//wait for this assert 30seconds
        return asserThat(ExpectedConditions.visibilityOfElementLocated(locator),30);
    }


}
