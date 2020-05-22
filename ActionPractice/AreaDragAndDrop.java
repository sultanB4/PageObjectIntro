package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AreaDragAndDrop {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        // How we can use implicitly wait. It takes two parameter (int Value, TimeUnits)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
// It will 5 sec until the elements are loaded in the page.
// If you are not able to find the element after 5 sec. Selenium will throw NoSuchElementException.
    }

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']")).click();
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement circle = driver.findElement(By.id("draggable"));
        WebElement blueBox = driver.findElement(By.className("test1"));
        WebElement orangeBox = driver.findElement(By.className("test2"));
        // drag and drop cn be achieved only with ActionS class
        String expectedBlueBoxDefaultText = "Drag the small circle here ...";
        String actualBlueBox = blueBox.getText();
        Assert.assertEquals(actualBlueBox, expectedBlueBoxDefaultText, "Default text for blueBox has failed");
        // in order to get proper message in output, it is better to use first actual and then expected
        String expectedOrangeText = "... Or here."; // expected is coming from BUS requirements
        String actualOrangeText = orangeBox.getText();
        Assert.assertEquals(actualOrangeText, expectedOrangeText, "Text has failed for OrangeBox");
        Actions actions = new Actions(driver);
        actions.clickAndHold(circle).moveToElement(blueBox).release().perform();
        String expectedAfterDropBlueBox = "You did great!";
        blueBox = driver.findElement(By.className("test1"));
        String actualBlueBoxText = blueBox.getText();
        Assert.assertEquals(actualBlueBoxText, expectedAfterDropBlueBox, "After dropping BlueBox text is failed");
        String expectedOrangeBoxText = "(Drop here)";
        orangeBox = driver.findElement(By.className("test2"));
        String actualOrangeBox = orangeBox.getText();
        Assert.assertEquals(actualOrangeBox, expectedOrangeBoxText, "After dropping blueBox, OrangeBox message is failed");
        actions.clickAndHold(circle).moveToElement(orangeBox).release().perform();
        String expectedAfterDropOrange = "You did great!";
        orangeBox = driver.findElement(By.className("test2"));
        String actualAfterDropOrangeText = orangeBox.getText();
        // StaleElementException --> if the element is not available in your DOM, selenium will throw StaleElementException
        Assert.assertEquals(actualAfterDropOrangeText, expectedAfterDropOrange, "After dropping orangeBox text is failed.");
        String expectedAfterDropBlueText = "(Drop here)";
        blueBox = driver.findElement(By.className("test1"));
        String actualBlueTextAfterOrangeDrop = blueBox.getText();
        Assert.assertEquals(actualBlueTextAfterOrangeDrop, expectedAfterDropBlueText, "After dropping orangeBox BlueBox text is failed");
    }

    @Test
    public void test2() {
        WebElement circle = driver.findElement(By.id("draggable"));
        WebElement blueBox = driver.findElement(By.className("test1"));
        WebElement orangeBox;
        Actions actions = new Actions(driver);
        actions.clickAndHold(circle).moveToElement(blueBox).release().perform();
        String expectedAfterDropBlueBox = "You did great!";
        blueBox = driver.findElement(By.className("test1"));
        String actualBlueBoxText = blueBox.getText();
        Assert.assertEquals(actualBlueBoxText, expectedAfterDropBlueBox, "After dropping BlueBox text is failed");
        String expectedOrangeBoxText = "(Drop here)";
        orangeBox = driver.findElement(By.className("test2"));
        String actualOrangeBox = orangeBox.getText();
        Assert.assertEquals(actualOrangeBox, expectedOrangeBoxText, "After dropping blueBox, OrangeBox message is failed");
    }

    @Test
    public void test3() {
        WebElement circle = driver.findElement(By.id("draggable"));
        WebElement blueBox;
        WebElement orangeBox = driver.findElement(By.className("test2"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(circle).moveToElement(orangeBox).release().perform();
        String expectedAfterDropOrange = "You did great!";
        orangeBox = driver.findElement(By.className("test2"));
        String actualAfterDropOrangeText = orangeBox.getText();
        // StaleElementException --> if the element is not available in your DOM, selenium will throw StaleElementException
        Assert.assertEquals(actualAfterDropOrangeText, expectedAfterDropOrange, "After dropping orangeBox text is failed.");
        String expectedAfterDropBlueText = "(Drop here)";
        blueBox = driver.findElement(By.className("test1"));
        String actualBlueTextAfterOrangeDrop = blueBox.getText();
        Assert.assertEquals(actualBlueTextAfterOrangeDrop, expectedAfterDropBlueText, "After dropping orangeBox BlueBox text is failed");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}





















