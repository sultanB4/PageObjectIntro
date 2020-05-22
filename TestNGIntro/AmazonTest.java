package TestNGIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest {
    @Test
    public void test1() {
       WebDriverManager.chromedriver().setup();
      //  WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.amazon.com/");

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("phone");

        WebElement click = driver.findElement(By.xpath("//input[@class='nav-input']"));
        click.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.com : phone";// it will come from business requirement
        Assert.assertEquals(actualTitle,expectedTitle);
    }

}
