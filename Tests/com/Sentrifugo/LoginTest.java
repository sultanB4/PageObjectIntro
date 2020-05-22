package Tests.com.Sentrifugo;

import Pages.LoginPage;
import Tests.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    //We want to make sure before the test annotation My object from loginPage is instantiated
    LoginPage page;
    @BeforeClass
    public void pageSetup() {
        //Webdriver
        page=new LoginPage(driver);
    }

    //All test annotation will be implemented in this class
    @Test
    public void LoginTest1() {
        driver.get("http://demo.sentrifugo.com/index.php/");

        page.userName.sendKeys("EM01");
        page.password.sendKeys("sentrifugo");
        page.loginButton.click();


    }

}
