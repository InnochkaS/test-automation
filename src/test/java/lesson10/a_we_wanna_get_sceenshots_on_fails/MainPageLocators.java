package lesson10.a_we_wanna_get_sceenshots_on_fails;

import org.openqa.selenium.By;

public interface MainPageLocators {
    By ADVICE_LOCATOR = By.xpath("//*[@id='index']/div[2]/ul/li[1]");
    By FIELD_QUERY_LOCATOR = By.id("search_query_top");
}