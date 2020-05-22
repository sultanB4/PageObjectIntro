package WindowPractice;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsIntro {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
// maximize of fullscreen
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void test1() {

        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();// this button will open new window
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        String parentPageID = driver.getWindowHandle(); //--> this method will return String or page ID
        System.out.println(parentPageID);
        Set<String> pageIDs = driver.getWindowHandles(); //--> getWindowHandles --> Set<String>
// switchTo() and window(PageId)
        for (String id : pageIDs) {
            if (!id.equals(parentPageID)) {
                driver.switchTo().window(id);

            }


        }
        System.out.println("After switching title" + driver.getTitle());
        System.out.println("After switching title" + driver.getCurrentUrl());
//if you do not switch to new window, you can not use the new window
//Once you switch to the new window,you can not use the parent window unless you switch back parent

        driver.switchTo().window(parentPageID);
        clickHere.click();

    }

    @Test
    public void test2() {

        driver.get("http://www.popuptest.com/popuptest12.html");

        String currentPageId = driver.getWindowHandle();
        System.out.println(currentPageId);
        Set<String> ids = driver.getWindowHandles();
        System.out.println(ids);
        //close all the popup if they are not equals to your currentPage
        for (String id : ids) {
            if (!id.equals(currentPageId)) {// It will switch thr driver to new window if id is not equals to parent id
                driver.switchTo().window(id).close();// it will close your current window
            }
        }
        driver.switchTo().window(currentPageId);// It will switch back to your first window
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

    }

    @Test
    public void test3() {
        driver.get("http://www.popuptest.com/popuptest1.html");

        String parentId=driver.getWindowHandle();
        //Close all the window if they are not equals to first page
        BrowserUtils.closeWindows(driver,parentId);



    }

}
