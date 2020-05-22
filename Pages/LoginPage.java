package Pages;

import Tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

public class LoginPage {

    public LoginPage(WebDriver driver) {
//Page factory with init elements method
// will help us to initialize our web elements.
       PageFactory.initElements(driver, this);

    }
// FindBy annotation
// id, tagName,className,name,xpath,css selector, linkTest and Partial Link test

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//input[@id='loginsubmit']")
    public WebElement loginButton;

    @FindBy (xpath = "//tr[@class='odd']")
    public WebElement patientInfo;

    //if you have general reusable method for automation, you need to store them Util/Browser
    //if it is only related with one functionality, or one page you can create under class.

    public  void login(String username,String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

}
