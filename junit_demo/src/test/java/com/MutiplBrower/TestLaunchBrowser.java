package com.MutiplBrower;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestLaunchBrowser {
    public WebDriver driver;

    @BeforeClass
    public void setUp() throws IOException{

        BrowserEngine browserEngine = new BrowserEngine();
        browserEngine.initConfigData();
        driver=browserEngine.getBrowser();

    }


    @Test
    public void clickNews(){

        driver.findElement(By.id("key")).sendKeys("iPhone 7");
        driver.findElement(By.xpath("//*[@id='search']/div/div[2]/button")).click();

    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
