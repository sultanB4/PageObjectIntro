package HomeWorks;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class HomeWork3 {

    WebDriver driver;
    @Test
    public void aTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void test1() {
        driver.navigate().to("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Select select =new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByVisibleText("Name (Z to A)");
        List<WebElement> itemNames = driver.findElements(By.className("inventory_item_name"));
        List<String> names = new ArrayList<>();
        for(WebElement name : itemNames){
            names.add(name.getText());
        }
        TreeSet<String> descending = new TreeSet<>(names);
        Assert.assertEquals(names, descending.descendingSet());
    }
    @Test
    public void test2(){
        driver.navigate().to("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Select select =new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByVisibleText("Price (low to high)");
        List<WebElement> itemPrices = driver.findElements(By.className("inventory_item_price"));
        List<Double> prices = new ArrayList<>();
        List<Double> prices2 = new ArrayList<>();
        for (WebElement price : itemPrices){
            String nums = price.getText();
            nums=nums.substring(1, nums.length()-1);
            prices.add(Double.parseDouble(nums));
            Collections.sort(prices);
        }
        for (WebElement price2 : itemPrices) {
            String nums2 = price2.getText();
            nums2 = nums2.substring(1, nums2.length() - 1);
            prices2.add(Double.parseDouble(nums2));
        }
        Assert.assertTrue(prices.equals(prices2));
    }
    @Test
    public void test3() throws InterruptedException {
        driver.navigate().to("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//button[text() = 'Open Menu']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        //BUG:  Crash on clicking the BACK button while after a user logged out from WebPage.
        /*
            Steps To Reproduce:
            1) Navigate to URL "https://www.saucedemo.com/"
            2) Login
            3) Logout
            4) When you see Login page click BACK button
            5) User shouldn't be able to see home page. Instead user still should be in same page
            6) And also see the attached screenshot of the error page.
         */
    }
    @Test
    public void test4() throws InterruptedException {
        driver.navigate().to("http://uitestpractice.com/Students/Select#");
        Select select = new Select(driver.findElement(By.id("countriesSingle")));
        System.out.println(select.getFirstSelectedOption().getText());
        List<WebElement> dropDown = select.getOptions();
        List<String> dropDownSize = new ArrayList<>();
        for(WebElement size : dropDown){
            dropDownSize.add(size.getText());
        }
        Assert.assertTrue(dropDownSize.size()==4);
        List<String> expectedDropDownValues = new ArrayList<>();
        expectedDropDownValues.add("India");
        expectedDropDownValues.add("United states of America");
        expectedDropDownValues.add("China");
        expectedDropDownValues.add("England");
        for (int i=0; i<dropDownSize.size(); i++){
            Assert.assertEquals(dropDownSize.get(i), expectedDropDownValues.get(i));
        }
        select.selectByIndex(3);
        Thread.sleep(2000);
        select.selectByValue("england");
        Thread.sleep(2000);
        select.selectByVisibleText("United states of America");
    }
}

