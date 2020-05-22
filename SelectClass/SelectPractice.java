package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.beans.Transient;
import java.util.List;

public class SelectPractice {
    @Test
    public void tst1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/nursultanmamyrasulov/Downloads/Techtorial.html");


        WebElement drDown = driver.findElement(By.name("country"));
        drDown.sendKeys("MEXICO");
        driver.close();
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver1 = new ChromeDriver();

        driver1.get("file:///Users/nursultanmamyrasulov/Downloads/Techtorial.html");
        WebElement drDown = driver1.findElement(By.name("country"));

        //Select constructor requires one parameter as webelement of Select tag
        Select select = new Select(drDown);
//SelectByIndex will select the option matching with index number
        //index number from 0 in dropdown
        select.selectByIndex(2);


// selectByVisibleText --> it will take one parameter as
        // String which is value of country, it will giving parameter

        Thread.sleep(2000);
        select.selectByVisibleText("KYRGYZSTAN");
//selectByValue --> It will select the option according their values
//Select with value only possible, if Option has attribute
        Thread.sleep(2000);

        select.selectByValue("239"); // --> value of option

driver1.close();
    }

    @Test
    public void test3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver1 = new ChromeDriver();

        driver1.get("file:///Users/nursultanmamyrasulov/Downloads/Techtorial.html");
        WebElement drDown = driver1.findElement(By.name("country"));
        Select select = new Select(drDown);
// getFirstSelectedOption() method will return webElement of default selected option from dropDown
        WebElement defaultOption = select.getFirstSelectedOption();
        String actualResult = defaultOption.getText();
        String expected = "UNITED STATES ";
        Assert.assertEquals(actualResult, expected);

        driver1.close();

    }

    @Test
    public void test4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver1 = new ChromeDriver();

        driver1.get("file:///Users/nursultanmamyrasulov/Downloads/Techtorial.html");

        WebElement drDown = driver1.findElement(By.name("country"));
        Select select = new Select(drDown);
//.getOptions(); --> will return list of webelement for all option the select tag
        List<WebElement> options = select.getOptions();

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        int countryNum = options.size();
        int expectedCountryNum = 264;//business

        Assert.assertTrue(countryNum == expectedCountryNum);


    }

}


