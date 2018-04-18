package com.selenium.basic;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestElementsList {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void InitTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://pinpineat.com/#!/";
        driver.get(baseUrl);
        driver.manage().window().maximize();

        System.out.println("当前打开页面的标题是： "+ driver.getTitle());


    }

    // 获取文本
    @Test
    public void TestElementText (){

        WebElement message = driver.findElement(By.id("message"));
        String messageText = message.getText();
        assertEquals("get The Text",messageText);

          // assertTrue(messageText.contains("ddd"));
         //assertTrue(messageText.startsWith("ddd"));
        //assertTrue(messageText.endsWith("ddd"));
    }
    //获取属性信息
    @Test
    public void  testElementAttribute(){
        WebElement message = driver.findElement(By.id("message"));
        assertEquals("justify",message.getAttribute("align"));

    }
    //获取css属性值
    @Test
    public void testElementCssStyle(){
        WebElement message = driver.findElement(By.id("message"));
        String width = message.getCssValue("width");
        assertEquals("150px",width);
    }
    @Test
    public void testRowUsingCtrlKey(){
        List<WebElement> tableRows = driver.findElements(By.xpath("trfirst"));
        Actions build = new Actions(driver);
        build.click(tableRows.get(1)).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();

        
    }

}
