package lesson07.homeWork;

import org.openqa.selenium.By;

public interface MainPageLocators {
    By ADVICE_LOCATOR = By.xpath("//*[@id='index']/div[2]/ul/li");
    By FIELD_QUERY_LOCATOR = By.id("search_query_top");
    By MISSED_LOCATOR = By.xpath("//*[@id=\"blockbestsellers\"]");
            //By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a");
}