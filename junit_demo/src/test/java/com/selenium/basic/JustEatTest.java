package com.selenium.basic;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class JustEatTest {
    private WebDriver driver;
    private String baseUrl;


    public void InitTest(){
        String os = (System.getProperty("os.name"));
        System.out.println(os);
        if (os.equalsIgnoreCase("Mac OS X"))
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        else System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
       // ChromeOptions chromeOptions = new ChromeOptions();
      //  chromeOptions.addArguments("--kiosk");
        driver = new ChromeDriver();
        baseUrl = "https://www.just-eat.ca";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("当前打开页面的标题是： "+ driver.getTitle());



    }
    public void testSearchH3A()  {

        driver.findElement(By.id("homepage-search-fullAddress")).clear();
        driver.findElement(By.id("homepage-search-fullAddress")).sendKeys("");
        driver.findElement(By.id("homepage-search-fullAddress")).clear();
        driver.findElement(By.id("homepage-search-fullAddress")).sendKeys("Service ECVictor Inc., Sherbrooke Street West, Montreal, QC, Canada");
        //driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div[1]/ul/li[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"skipToMain\"]/div[2]/div/div/button")).click();//问题 为什么不点button 而是选li

    }
    public static void main(String[] args) {
        JustEatTest jt = new JustEatTest();
       jt.InitTest();
       jt.testSearchH3A();
    }

}
