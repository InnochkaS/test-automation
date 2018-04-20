package lesson09.homeWork;

import org.openqa.selenium.WebDriver;

public class IndexPage extends BasePage {
    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void visit(){
            open("http://automationpractice.com/index.php");
        }

}
