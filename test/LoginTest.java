package test;

import Pages.LoginPage;
import Tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    //We want to make sure before the test annotation My object from loginPage is instantiated
    LoginPage page;

    @BeforeClass
    public void pageSetup() {
        //Webdriver
        page = new LoginPage(driver);
    }

    //All test annotation will be implemented in this class
    @Test
    public void LoginTest1() {
        driver.get("https://demo.openemr.io/openemr");

        page.userName.sendKeys("admin");
        page.password.sendKeys("pass");
        page.loginButton.click();

    }
}




