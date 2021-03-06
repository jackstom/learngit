package com.junit.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class JQuerySelector {
    protected WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://cookbook.seleniumacademy.com/Locators.html");
    }

    @Test
    public void testDefaultSelectedCheckbox() {

        // Expected list of selected Checkbox
        List<String> checked = Arrays
                .asList("user128_admin", "user220_browser");

        // Create an instance of JavaScript Executor from driver
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Locate all the Checkbox which are checked by calling jQuery find()
        // method.
        // find() method returns elements in array
        @SuppressWarnings("unchecked")
        List<WebElement> elements = (List<WebElement>) js
                .executeScript("return jQuery.find(':checked')");

        // Verify two Checkbox are selected
        assertEquals(elements.size(), 2);

        // Verify correct Checkbox are selected
        for (WebElement element : elements) {
            assertTrue(checked.contains(element.getAttribute("id")));
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
