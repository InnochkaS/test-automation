package lesson06.homeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "email")
    private WebElement usernameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AccountPage logIn(String username, String password) {

        return enterUsername(username)
            .enterPassword(password)
            .clickSignInBtn();
    }

    public LoginPage enterUsername(String username) {

        usernameInput.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {

        passwordInput.sendKeys(password);
        return this;
    }

    public AccountPage clickSignInBtn() {

        loginButton.click();
        return new AccountPage(driver);
    }
}



/*
1. Создать два класса LoginPage и AccountPage, используя для элементов аннотации PageFactory.

2. LoginPage с методом logIn(String username, String password),
который состоит из enterUsername(String username),
enterPassword(String password) и enterPassword().
Метод logIn должен возвращать новый экземпляр страницы AccountPage.
Предусмотреть возможность логина, через цепочный вызов методов enterUsername, enterPassword и clickSignInBtn.

3. AccountPage с методом signOut(), который возвращает новый экземпляр страницы LoginPage.

4. Сделать тестовый класс с тремя тестами:
1 - на логин через метод logIn,
2 - на логин с использованием цепочки методов,
3 - на логаут (в тестах проверять, что нужная страница открылась, assertThat в помощь).
При запуске тестов делайте игнор для 1 или 2 теста.

5. Запустить тестовый класс через мавен и через IDE.
6. Закоммитить изменения, залить их на репозиторий GitHub и прислать ссылку.
 */