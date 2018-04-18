package com.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoinfailedTest {




    private WebDriver driver;
    private String baseUrl;

    public void InitTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://pinpineat.com/#!/";
        driver.get(baseUrl);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();

        System.out.println("当前打开页面的标题是： "+ driver.getTitle());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void ClickLogin(){

        WebElement menu = driver.findElement(By.xpath("//*[@id=\"myNavBar\"]/ul/li[1]/a"));
        Actions actions = new Actions(this.driver);
        actions.moveToElement(menu);
        actions.click().build().perform();


    }
    public void LoginAction(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("coohoh22@hotmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("gugu1214");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"loginDiv\"]/div[2]/div/form/div[3]/button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String failedText = driver.findElement(By.className("redTxt")).getText();
        System.out.println(failedText);



    }



    public static void main(String[] args) {
        LoinfailedTest lft = new LoinfailedTest();
        lft.InitTest();
        lft.ClickLogin();
        lft.LoginAction();
        //lt.driver.quit();


    }

}
