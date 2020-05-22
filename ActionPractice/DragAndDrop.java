package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop {

    WebDriver driver;

    @Test
    public void test1() throws InterruptedException {
        // 1. user webdriver Manager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //Instantiate the Actions object
        driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']")).click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.id("droptarget"));
        String expectedText = "Drag the small circle here.";
        String actualText = target.getText();
        Assert.assertEquals(actualText, expectedText);
        System.out.println("Matching");
        // 8 locators --> name,id,xpath,css selector,ClassName, TagName,LinkTest, PartialLinktext

        actions.dragAndDrop(source, target).perform();
        //Assertion After Drag and Drop
        String expectedDropText = "You did great!";
        String actualDropText = target.getText();
        Assert.assertTrue(expectedDropText.equals(actualDropText), "afer drop text is not matching");

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        // driver.manage().window().maximize();

        Actions actions = new Actions(driver);
//clickAndHold -- moveToElement -- release --> perform();
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        actions.clickAndHold(source).moveToElement(target).perform();
        actions.release().perform();
//release() --> will release the mouse in current location of mouse
//release(target) --> will release the mouse in target location

    }


}
