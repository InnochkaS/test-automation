package lesson07.e_move_page_object_to_separate_class;

import org.openqa.selenium.By;

public interface MainPageLocators {
    By ADVICE_LOCATOR = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");
    By FIELD_QUERY_LOCATOR = By.id("search_query_top");


}
