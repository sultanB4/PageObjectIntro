package HomeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork4 {

    WebDriver driver;

    @BeforeTest
    public void Ttest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();

    }

    @Test

    public void tes1() throws InterruptedException {


        WebElement dropDown = driver.findElement(By.xpath("//select[@name='stockType']"));
        dropDown.click();
        Select select = new Select(dropDown);
        select.selectByVisibleText("Certified Cars");

        WebElement selectToyota = driver.findElement(By.xpath("//select[@name='makeId']"));
        //selectToyota.click();
        Select select1 = new Select(selectToyota);
        select1.selectByVisibleText("Toyota");

        WebElement selectCorolla = driver.findElement(By.xpath("//select[@aria-label='Select a model']"));
        Select select2 = new Select(selectCorolla);
        select2.selectByVisibleText("Corolla");


        WebElement selectPrice = driver.findElement(By.xpath("//select[@name='priceMax']"));
        Select select3 = new Select(selectPrice);
        select3.selectByVisibleText("$30,000");

        WebElement mileSelect = driver.findElement(By.xpath("//select[@name='radius']"));
        Select select4 = new Select(mileSelect);
        select4.selectByIndex(3);

        WebElement zipCode = driver.findElement(By.xpath("//input[@name='zip']"));
        zipCode.clear();
        zipCode.sendKeys("60018");

        WebElement searchButton = driver.findElement(By.xpath("//input[@data-linkname='Search Certified']"));

        searchButton.click();
        Thread.sleep(3000);
        WebElement actualCertified = driver.findElement(By.xpath("(//li[@data-dimension-id='cpoId'])[1]"));
        String expectedCertified = "Certified Used";
        Assert.assertEquals(actualCertified.getText(), expectedCertified);
        System.out.println(actualCertified.getText());

        WebElement displayText = driver.findElement(By.xpath("//h1[.='Certified Used Toyota Corolla for Sale']"));
        Assert.assertTrue(displayText.isDisplayed());
        System.out.println("Certified Used Toyota Corolla for Sale Text is Displayed");


        WebElement milesSelected40 = driver.findElement(By.xpath("//option[.='40 miles']"));
        Assert.assertTrue(milesSelected40.isSelected());
        System.out.println("Mile is selected");

        WebElement certifiedPreOwnedSelected = driver.findElement(By.xpath("//input[@data-dtm='{ \"name\" :\"stkTypId\" ,\"value\": \"Certified Pre-Owned\" }']"));
        Assert.assertTrue(certifiedPreOwnedSelected.isSelected());
        System.out.println("Certified Pre-Owned selected in radio button");

        WebElement toyotaSelected = driver.findElement(By.xpath("//input[@data-dtm='{ \"name\" :\"mkId\" ,\"value\": \"Toyota\" }']"));
        Assert.assertTrue(toyotaSelected.isSelected());
        System.out.println("Toyota is selected in checkbox");

        WebElement corollaSelected = driver.findElement(By.xpath("//input[@data-dtm='{ \"name\" :\"mdId\" ,\"value\": \"Corolla\" }']"));
        Assert.assertTrue(corollaSelected.isSelected());
        System.out.println("Corolla is selected");
    }


    @Test
    public void test2() {

        driver.navigate().to("https://www.cars.com/");

        WebElement selectToyota = driver.findElement(By.xpath("//select[@name='makeId']"));

        Select select1 = new Select(selectToyota);
        select1.selectByVisibleText("Lexus");

        WebElement selectModel = driver.findElement(By.xpath("//select[@name='modelId']"));
        Select select2 = new Select(selectModel);
        select2.selectByValue("21027");

        WebElement selectPrice = driver.findElement(By.xpath("//select[@name='priceMax']"));
        Select select3 = new Select(selectPrice);
        select3.selectByVisibleText("$50,000");

        WebElement mileSelect = driver.findElement(By.xpath("//select[@name='radius']"));
        Select select4 = new Select(mileSelect);
        select4.selectByIndex(4);

        WebElement zipCode = driver.findElement(By.xpath("//input[@name='zip']"));
        zipCode.clear();
        zipCode.sendKeys("60016");

        WebElement searchButton = driver.findElement(By.xpath("//input[@data-linkname='Search Certified']"));
        searchButton.click();

        List<WebElement> carsList = driver.findElements(By.xpath("//h2[@class='listing-row__title']"));
        List<String> carCount = new ArrayList<>();
        for (WebElement cars : carsList) {
            carCount.add(cars.getText());
            System.out.println(cars.getText());
            Assert.assertTrue(carCount.size() == 20);
            System.out.println("cars is not more than 20");


        }
        List<WebElement> car = driver.findElements(By.xpath("//h2[@class='listing-row__title']"));
        List<String>carNames= new ArrayList<>();
        for(WebElement vehicleNames:car){
            carNames.add(vehicleNames.getText());
            for(int i=0;i<carNames.size();i++){
                Assert.assertTrue(carNames.get(i).contains("Lexus ES 350"));


            }

        WebElement mile = driver.findElement(By.xpath("//select[@data-dtm='{ \"name\" :\"rd\" ,\"value\": \"Radius\" }']"));



        }



    }
}



