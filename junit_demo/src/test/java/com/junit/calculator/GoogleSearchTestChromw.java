package com.junit.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class GoogleSearchTestChromw {
    private WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
    }
    @Test
    public void  testGoogleSearch(){
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium testing tools cookbook");
        element.submit();
        new WebDriverWait(driver,10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d){
                return  d.getTitle().toLowerCase().startsWith("selenium testing tools cookbook");
            }
        });
        assertEquals("Selenium testing tools cookbook - Google 搜索",
                driver.getTitle());
    }
    @After
    public void tearDown() throws Exception {
        // Close the browser
        driver.quit();
    }
}
