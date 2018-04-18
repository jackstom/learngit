package com.pinpineat.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;


public class pinpinLoginTest {
    public WebDriver driver;
    public String baseUrl = "https://pinpineat.com/#!/login";
    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }
    @Test
    public void  loginTest(){

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("coohoh@hotmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("gugu1214");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"loginDiv\"]/div[2]/div/form/div[3]/button")).click();

        WebDriverWait wait = new WebDriverWait(driver,4);
        WebElement user =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myNavBar\"]/ul/li[2]/a/span/span[2]")));

        user.click();

        WebElement userMail = driver.findElement(By.xpath("//*[@id=\"view\"]/div/div[2]/div/h3"));
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        assertEquals("coohoh@hotmail.com",userMail.getText());


    }
    @Test
    public void  failedloginTest(){

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("hotmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("gggfhf");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"loginDiv\"]/div[2]/div/form/div[3]/button")).click();

        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement failedMsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginDiv\"]/div[2]/div/p")));
        assertEquals("Wrong username or password",failedMsg.getText());


    }

    @Test
    public void forgeButtonTest(){
        driver.findElement(By.xpath("//*[@id=\"loginDiv\"]/div[2]/div/form/div[3]/p[1]/a")).click();
        WebElement msg = driver.findElement(By.xpath("//*[@id=\"loginDiv\"]/div[4]/div/div/h4"));
        assertEquals("Request new password",msg.getText());

    }
    @Test
    public void  checkTest(){

        WebElement checkBox =  driver.findElement(By.xpath("//*[@id=\"loginDiv\"]/div[2]/div/form/div[3]/div/label/input"));
        if(!checkBox.isSelected()) {
            checkBox.click();
        }
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeSelected(checkBox));
        assertTrue(checkBox.isSelected());

    }
    @Test
    public  void alerttest(){
       WebElement alertBox = driver.findElement(By.xpath("//*[@id=\"myNavBar\"]/ul/li[3]/a/i"));
       alertBox.click();
       WebDriverWait wait = new WebDriverWait(driver,4);
       wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
       assertEquals("Please sign in or sign up first!",alert.getText());


    }

    @Test
    public void languageList(){
        List<String> exp_sel_options = Arrays.asList("English", "Français", "中文");
        List<String> act_sel_options = new ArrayList<>();
        driver.findElement(By.xpath("//*[@id=\"myNavBar\"]/ul/li[4]/a/span")).click();
        List<WebElement> languageList =driver.findElements(By.xpath("//*[@id=\"myNavBar\"]/ul/li[4]/ul/li/a"));


        for(WebElement li:languageList){
            act_sel_options.add(li.getText());

        }
        System.out.println(act_sel_options.size());
        assertArrayEquals(exp_sel_options.toArray(),act_sel_options.toArray());
    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
