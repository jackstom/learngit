package com.QA.ass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UatTest {
    public WebDriver driver;
    public String url;

    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.iga.net/");
        driver.manage().window().maximize();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void myAcount(){
        WebElement pageTitle = driver.findElement(By.linkText("My Account"));
        pageTitle.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String t=driver.getTitle();
        assertEquals("Login",t);


    }
    @Test
    public void productTest(){
        driver.findElement(By.xpath("//*[@id=\"body_0_main_0_full61a767ecd2dc40dfae80a3ef0a403968_2_GroceryListControl_GroceryItems_GroceryTemplate_0_ProductImage_0\"]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement pText = driver.findElement(By.xpath("//*[@id=\"mainform\"]/div[3]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/h1/span"));
        assertEquals("Chicken Drumstick",pText.getText());
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
