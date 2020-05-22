package Tests.com.Sentrifugo;

import Pages.DepartmentPage;
import Pages.LoginPage;
import Tests.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DepartmentTest extends TestBase {
    DepartmentPage departmentPage;
    LoginPage loginPage;

    @BeforeClass

    public void setupPage() {
        departmentPage = new DepartmentPage(driver);
        loginPage = new LoginPage(driver);

    }

    @Test
    public void departmentCreation() throws InterruptedException {
        driver.get("http://demo.sentrifugo.com/index.php/");
        loginPage.login("EM01", "sentrifugo");
        departmentPage.departmentButton.click();
        departmentPage.addNewButton.click();
        departmentPage.departmentName.sendKeys("Finance");
        departmentPage.departmentCode.sendKeys("FN");
        departmentPage.timeZone.click();
        departmentPage.detroitTime.click();
        departmentPage.saveButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(departmentPage.successMessage.isDisplayed());

        // Every page create page class
        // Store all webelement inside Page class
        // Create Test class under Tests package
        // Inside test class create an object from page class
        // Extent test class with TestBase Class



    }

}
