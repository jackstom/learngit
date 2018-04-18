package com.QA.ass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class igaChart {
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
    public void chartTest(){

        WebElement login = driver.findElement(By.id("header_0_LoginLink"));
        login.click();

        System.out.println("Open the login form "+ driver.getTitle());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement username = driver.findElement(By.xpath("//*[@id=\"body_0_main_1_LoginBox_TxtEmail\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"body_0_main_1_LoginBox_TxtPassword\"]"));
        username.sendKeys("coohoh@hotmail.com");
        password.sendKeys("gugu1214");

        driver.findElement(By.xpath("//*[@id=\"body_0_main_1_LoginBox_BtnConnection\"]")).click();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions hover = new Actions(driver);
        WebElement oh = driver.findElement(By.xpath("//*[@id=\"header_0_ctl08_MenuItemList_SubMenuRegularMenu_0_LandingPageLink_0\"]"));
        hover.moveToElement(oh).perform();
        oh.findElement(By.xpath("//*[@id=\"header_0_ctl08_MenuItemList_SubMenuRegularMenu_0_LeafList_0_ctrl0_0_LeafLink_0\"]")).click();

//        WebElement scrollTo = driver.findElement(By.xpath("//*[@id=\"body_0_LeftSideMenu_CategoryFacetsRpt_CategoryFacetLnk_0\"]/span"));
//        JavascriptExecutor je = (JavascriptExecutor) driver;
//        je.executeScript("arguments[0].scrollIntoView(true);",scrollTo);

      WebElement p1 = driver.findElement(By.xpath("//*[@id=\"body_0_main_1_ProductSearch_GroceryBrowsing_TemplateResult_SearchResultListView_ctrl0_ctl00_0_ListOfPrices_0\"]/div/div[1]/div/span/span"));
      String s1 = p1.getText();
      double price1 = Double.parseDouble(s1.substring(1));
      driver.findElement(By.xpath("//*[@id=\"body_0_main_1_ProductSearch_GroceryBrowsing_TemplateResult_SearchResultListView_ctrl0_ItemTemplatePanel_0\"]/div/div/div/div[3]/div/div/div/span/button")).click();
      WebElement p2 = driver.findElement(By.xpath("//*[@id=\"body_0_main_1_ProductSearch_GroceryBrowsing_TemplateResult_SearchResultListView_ctrl0_ctl00_1_ListOfPrices_1\"]/div/div[1]/div/span/span"));
      String s2 = p2.getText();
      double price2 = Double.parseDouble(s2.substring(1));
      driver.findElement(By.xpath("//*[@id=\"body_0_main_1_ProductSearch_GroceryBrowsing_TemplateResult_SearchResultListView_ctrl0_ItemTemplatePanel_1\"]/div/div/div/div[3]/div/div/div/span/button")).click();

//      WebElement scrollTo2 = driver.findElement(By.id("header_0_MyAccountLink"));
//      JavascriptExecutor je2 = (JavascriptExecutor) driver;
//      je2.executeScript("arguments[0].scrollIntoView(true);",scrollTo2);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("header_0_ShoppingCartButton_LnkShoppingCart")).click();

        WebElement total = driver.findElement(By.xpath("//*[@id=\"mainform\"]/div[3]/div/div[2]/div[2]/div[2]/div/div[3]/div[2]/div[1]/div/div/div[1]"));
        String s3 = total.getText();
        double totalPrice = Double.parseDouble(s3.substring(1));
        System.out.println(totalPrice);
        assertEquals(price1+price2+4,totalPrice);






    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
