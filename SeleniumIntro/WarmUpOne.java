package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class WarmUpOne {
    /*
    Task:
    Go to google search with selenium
    Validate all the results related with Selenium
    Find the titles and validate titles Selenium Keyword
    To adjust the structure of your code you can use
     */

    public static void main(String[] args) {
//WebdriverManager to get the chromedriver
//System.setProperty("web.....","chromedriver") --> we dont need anymore

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.google.com");

      WebElement sel= driver.findElement(By.name("q"));
             sel.sendKeys("Selenium");

      WebElement googleSearch = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@class='gNO89b']"));
        googleSearch.click();


       List<WebElement> headers = driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));
for(WebElement head: headers){
  //  System.out.println(head.getText());
    String hd = head.getText();
    if(!hd.equals(""))
    if(hd.contains("Selenium")||hd.contains("selenium")){
        System.out.println("Include selenium");
    }else{
        System.out.println("Doesn't include Selenium");
    }

}

}


    }

