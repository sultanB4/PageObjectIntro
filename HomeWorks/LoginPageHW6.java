package HomeWorks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageHW6 {



         public LoginPageHW6(WebDriver driver) {
//Page factory with init elements method
// will help us to initialize our web elements.
            PageFactory.initElements(driver, this);

        }
// FindBy annotation
// id, tagName,className,name,xpath,css selector, linkTest and Partial Link test

        @FindBy(id = "authUser")
        public WebElement userName;

        @FindBy(id = "clearPass")
        public WebElement password;

        @FindBy(xpath = "//button[@type='submit']")
        public WebElement loginButton;

        @FindBy(id="anySearchBox")
        public  WebElement searchButton;

        @FindBy(id = "search_globals")
        public WebElement clickSearchButton;

//        @FindBy (xpath = "//tr[@id='pid_1']//td[contains(text(),'Belford, Phil')]")
//        public  WebElement patientName;



        //if you have general reusable method for automation, you need to store them Util/Browser
        //if it is only related with one functionality, or one page you can create under class.

        public  void LoginPageHW6(String admin,String pass){
            this.userName.sendKeys(admin);
            this.password.sendKeys(pass);
            this.loginButton.click();
            this.searchButton.sendKeys("");
           // this.patientName=patientName;
    }

}