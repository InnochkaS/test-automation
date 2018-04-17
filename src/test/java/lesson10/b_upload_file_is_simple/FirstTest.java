package lesson10.b_upload_file_is_simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {



    LoginPage loginPage = new LoginPage(driver);
    @Test
    public void loginTest(){

        //complete here
        assertThat(titleContains("Google"));
        loginPage.login();
        assertThat(titleContains("My account"));

    }
}