package test;

import HomeWorks.HomeworkPage;
import HomeWorks.LoginPageHW6;
import Tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;


public class HomeWorkTest extends TestBase {
    HomeworkPage homeworkPage;
    LoginPageHW6 loginPageHW6;

    @BeforeClass

    public void setupPage() {
        homeworkPage = new HomeworkPage(driver);
        loginPageHW6 = new LoginPageHW6(driver);

    }

    @Test
    public void patientCreation() throws InterruptedException {
        driver.get("https://demo.openemr.io/openemr");
        Thread.sleep(2000);
        loginPageHW6.LoginPageHW6("admin", "pass");
        Thread.sleep(2000);
        // loginPageHW6.loginButton.click();
        Thread.sleep(2000);
        loginPageHW6.searchButton.sendKeys("Belford");
        loginPageHW6.clickSearchButton.click();




        List<WebElement> patientValidation = driver.findElements(By.xpath("//tr[@class='odd']"));

      List<String> actualResult = new ArrayList();

        for (WebElement p : patientValidation) {
            actualResult.add(p.getText());
            System.out.println(actualResult.toString());

        }
    }
}