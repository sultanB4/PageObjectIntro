package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class KeyBordFunctions {

    WebDriver driver;

    @Test
    public void Ttest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }


    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();



        driver.navigate().to("https://www.google.com/");

        WebElement search = driver.findElement(By.name("q"));

        Actions actions = new Actions(driver);
        actions.moveToElement(search).click()
                .keyDown(search, Keys.SHIFT)
                .sendKeys(search, "selenium")
                .keyUp(search, Keys.SHIFT)
                .doubleClick(search)
                .contextClick().perform();

        //Keys is working with Action class and it will also work with WebElement.
        // For WebElement I need send the key to my element

        search.sendKeys(Keys.ARROW_DOWN);
        search.sendKeys(Keys.ARROW_DOWN);
       // search.sendKeys(Keys.ARROW_DOWN);// select the selenium foods
        search.sendKeys(Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains("selenium sulfide"));
        //evaluate the expression
        //Assert.assert.equals(list1,list2);
        //Assert.assertQguals(arr1,arr2);


    }


}
