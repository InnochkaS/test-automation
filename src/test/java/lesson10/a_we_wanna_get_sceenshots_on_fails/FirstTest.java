package lesson10.a_we_wanna_get_sceenshots_on_fails;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {



    LoginPage loginPage = new LoginPage(driver);
    @Test
    public void loginTest(){
        loginPage.visit();
        assertThat(titleContains("Login"));
        loginPage.login();
        assertThat(titleContains("My accountgrgtrgtr"));

    }
}