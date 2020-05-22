package MavenProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SeleniumMavenProject3 {

    WebDriver driver;
    Actions actions;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }


    @Test
    public void test1() {
        driver.get("http://automationpractice.com/index.php");
        WebElement emptyCart = driver.findElement(By.xpath("//span[.='(empty)']"));
        Assert.assertTrue(emptyCart.getText().equals("(empty)"));
        System.out.println("Cart is empty");

        List<WebElement> price = driver.findElements(By.xpath("//li//span[@itemprop='price']"));
        List<Double> listOfPrices = new ArrayList<>();
        for (WebElement p : price) {
            if(p.getText().startsWith("$"))
            listOfPrices.add(Double.valueOf(p.getText().substring(1)));
            for (int i=0;i<listOfPrices.size();i++){
                double minPrice;

            }


        }
        System.out.println(listOfPrices);

        List<WebElement> products = driver.findElements(By.xpath("//h5//a[@class='product-name']"));
        List<String > listOfProducts=new ArrayList<>();
        for(WebElement l:products){
            if(!l.getText().isBlank())
            listOfProducts.add(l.getText());

        }
        System.out.println(listOfProducts);
        System.out.println(listOfProducts.size());

    Map<Double,String> cheapest = new LinkedHashMap<>();

    for(int i=0; i<listOfPrices.size();i++){
        cheapest.put(listOfPrices.get(i), listOfProducts.get(i));
    }
        System.out.println(cheapest);


    double temp=1.99;
    for(int i=0;i<listOfPrices.size();i++){
        if(temp>listOfPrices.size());
        //    temp=price;
    }

    }

}
