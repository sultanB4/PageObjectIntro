package HomeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class HomeWork5 {
    WebDriver driver;


    @BeforeTest

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void test1() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement clickCookieButton = driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']"));
        clickCookieButton.click();
        WebElement clickAndHoldBlueCircle = driver.findElement(By.xpath("// div[@id='draggable']"));
        actions.clickAndHold(clickAndHoldBlueCircle).moveByOffset(-55, 0).perform();

        WebElement isDisplayedBlue = driver.findElement(By.xpath("//div[@class='test1']"));
        Assert.assertTrue(isDisplayedBlue.isDisplayed());
        System.out.println("BlueBox isDisplayed");

        WebElement isDisplayedOrange = driver.findElement(By.xpath("//div[@class='test2']"));
        Assert.assertTrue(isDisplayedOrange.isDisplayed());
        System.out.println("OrangeBox isDisplayed");
    }

    @Test
    public void test2() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(2000);
//        WebElement cookie = driver.findElement(By.xpath("//button[@class='optanon-allow-all accept-cookies-button']"));
//        cookie.click();

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        actions.clickAndHold(source).moveToElement(target).moveByOffset(-23, 0).perform();

        WebElement validateTextInBlueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        Assert.assertEquals(validateTextInBlueBox.getText(), ("Now you can drop it."));
        System.out.println("Validated text in BlueBox");


        WebElement orangeBox = driver.findElement(By.xpath("//div[.='(Drop here)']"));
        String expected = "(Drop here)";
        String actual = orangeBox.getText();
        Assert.assertEquals(orangeBox.getText(), ("(Drop here)"));


    }

    @Test
    public void test3() {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");


        Actions actions = new Actions(driver);
        WebElement blueCircle = driver.findElement(By.id("draggable"));
        actions.clickAndHold(blueCircle).perform();

        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        actions.clickAndHold(blueCircle).moveToElement(orangeBox).perform();

        WebElement orangeBoxTest = driver.findElement(By.xpath("//div[.='Now you can drop it.']"));

        Assert.assertTrue(orangeBoxTest.isDisplayed());
        System.out.println("Orange box text is displayed");

        WebElement blueBoxTest = driver.findElement(By.xpath("//div[.='(Drop here)']"));
        Assert.assertEquals(blueBoxTest.getText(), "(Drop here)");
        System.out.println("Blue box text is validated");


    }

    @Test
    public void test4() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Actions actions = new Actions(driver);
        Thread.sleep(2000);

        WebElement clickAndHoldMinusFiveThousand = driver.findElement(By.xpath("//li[@data-id='1']"));
        System.out.println(clickAndHoldMinusFiveThousand.getText());
        actions.clickAndHold(clickAndHoldMinusFiveThousand).moveByOffset(-55, 0).perform();
        actions.clickAndHold(clickAndHoldMinusFiveThousand).release().perform();

        WebElement textDisplay = driver.findElement(By.xpath("//div[@id = 'e1']"));
        Assert.assertTrue(textDisplay.isDisplayed());
        System.out.println(textDisplay.getText());

        Thread.sleep(2000);
        WebElement dropFiveThousand = driver.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));
        WebElement debitSide = driver.findElement(By.xpath("(//li[@class='placeholder'])[2]"));
        actions.dragAndDrop(dropFiveThousand, debitSide).perform();


        String validatingDebitSide = driver.findElement(By.xpath("//div[@id='bal3']")).getText();
        Assert.assertEquals(validatingDebitSide, "Debit Movement\n" + "5000\n" + "Credit Movement\n" + "0");
        System.out.println("Validated debit 5000 and credit 0");


        WebElement dropSecondFiveThousand = driver.findElement(By.xpath("(//a[@class='button button-orange'])[4]"));
        WebElement creditSide = driver.findElement(By.xpath("(//li[@class='placeholder'])[3]"));
        actions.dragAndDrop(dropSecondFiveThousand, creditSide).perform();

        String validateBothSide = driver.findElement(By.xpath("//div[@id='bal3']")).getText();
        Assert.assertEquals(validateBothSide, "Debit Movement\n" + "5000\n" + "Credit Movement\n" + "5000");
        System.out.println("Validated both cards");

        WebElement bankButton = driver.findElement(By.xpath("(//a[@class='button button-orange'])[5]"));
        WebElement dropDebitSide = driver.findElement(By.xpath("(//li[@class='placeholder'])[1]"));
        actions.dragAndDrop(bankButton, dropDebitSide).perform();

        WebElement bankIsDisplayed = driver.findElement(By.xpath("(//li[@data-id='5'])[2]"));
        Assert.assertTrue(bankIsDisplayed.isDisplayed());
        System.out.println("Bank is displayed");

        WebElement salesButton = driver.findElement(By.xpath("(//a[@class='button button-orange'])[6]"));
        WebElement dropCreditSide = driver.findElement(By.xpath("//li[@class='placeholder']"));
        actions.dragAndDrop(salesButton, dropCreditSide).perform();

        WebElement salesIsDisplayed = driver.findElement(By.xpath("(//li[@data-id='6'])[2]"));
        Assert.assertTrue(salesIsDisplayed.isDisplayed());
        System.out.println("Sales is displayed");


    }

    @Test
    public void test5() {
        driver.get("http://www.popuptest.com/popuptest4.html");
        Actions action = new Actions(driver);
        WebElement hoverOver = driver.findElement(By.xpath("//a[@href='#']"));
        action.moveToElement(hoverOver).perform();

        Assert.assertEquals(driver.getWindowHandles().size(), 3);
        System.out.println("There is " + driver.getWindowHandles().size() + " opened sites");

        String parentId = driver.getWindowHandle();
        System.out.println(parentId);

        Set<String> pageId = driver.getWindowHandles();
        LocalDate date = LocalDate.now();
        String todaysDate = " " + date.getDayOfWeek() + " " + date.getMonth() + ", " + date.getDayOfMonth() + " " + date.getYear();
        System.out.println(todaysDate);
        for (String id : pageId) {
            if (!id.equals(parentId)) {
                driver.switchTo().window(id);
                System.out.println(driver.getTitle() + " This is window title");
                Assert.assertEquals(driver.getTitle().substring(driver.getTitle().indexOf(" ")).toUpperCase(), todaysDate);
            }
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("popup9"));
        Set<String> otherNewWindow = driver.getWindowHandles();
        for (String id : otherNewWindow) {
            if (id.equals(otherNewWindow)) {
                driver.switchTo().window(id);
                Assert.assertTrue(driver.getCurrentUrl().contains("popup10"));
            }
        }
    }


    @Test
    public void test6() throws InterruptedException {
        driver.get("http://seleniumpractise.blogspot.com/2017/");
        driver.findElement(By.xpath("//a[.=' Click here for Facebook ']")).click();
        String parentPageId = driver.getWindowHandle();
        Set<String> pageID = driver.getWindowHandles();
        for (String id : pageID) {
            if (!id.equals(parentPageId)) {
                driver.switchTo().window(id);
            }
        }
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Techtorial");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Academy");
        WebElement phoneNumber = driver.findElement(By.name("reg_email__"));
        phoneNumber.sendKeys("2223334455");
        WebElement password = driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("techtorial123");
        Select month = new Select(driver.findElement(By.name("birthday_month")));
        month.selectByVisibleText("Apr");
        Select day = new Select(driver.findElement(By.name("birthday_day")));
        day.selectByVisibleText("20");
        Select year = new Select(driver.findElement(By.name("birthday_year")));
        year.selectByVisibleText("2002");
        WebElement closePage = driver.findElement(By.xpath("//input[@id = 'u_0_b']"));
        closePage.click();
        driver.close();
        String parendWindowTitle = driver.switchTo().window(parentPageId).getTitle();
        Assert.assertEquals(parendWindowTitle, "Selenium Practise: 2017");
    }

}


