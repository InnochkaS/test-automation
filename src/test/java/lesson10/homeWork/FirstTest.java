package lesson10.homeWork;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {



    LoginPage loginPage = new LoginPage(driver);
    @Test
    public void loginTest(){
        loginPage.visit();
        assertThat(titleContains("Login"));
        loginPage.email();
        loginPage.password();
        assertEquals("Invalid password.",driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText());

    }
}

/*
1. Добавьте в проект получение скриншотов для тестов, которые не прошли.
2. Проверьте работу скриншотера, на примере неудачного логина.*/