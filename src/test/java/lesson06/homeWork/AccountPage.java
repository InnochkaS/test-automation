package lesson06.homeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    @FindBy(className = "logout")
    private WebElement signOutButton;

    private WebDriver driver;

    public AccountPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage signOut() {

        signOutButton.click();
        return new LoginPage(driver);
    }
}


//3. AccountPage с методом signOut(), который возвращает новый экземпляр страницы LoginPage.