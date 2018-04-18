package com.junit.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SelectTest {

    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://cookbook.seleniumacademy.com/Config.html");
    }
    @Test
    public void testDropDown(){
        Select make = new Select(driver.findElement(By.name("make")));
        assertFalse(make.isMultiple());
        assertEquals(4,make.getOptions().size());
        List<String> exp_options = Arrays.asList("BMW", "Mercedes", "Audi",
                "Honda");
        List<String> act_options = new ArrayList<>();
        for(WebElement option :make.getOptions()){
            act_options.add(option.getText());
        }
        assertArrayEquals(exp_options.toArray(),act_options.toArray());
        make.selectByVisibleText("Honda");
        assertEquals("Honda",make.getFirstSelectedOption().getText());
        make.selectByValue("audi");
        assertEquals("Audi",make.getFirstSelectedOption().getText());
        make.selectByIndex(0);
        assertEquals("BMW",make.getFirstSelectedOption().getText());


    }

    @Test
    public  void testMultipleSelectList(){
        Select color = new Select(driver.findElement(By.name("color")));
        assertTrue(color.isMultiple());
        assertEquals(5,color.getOptions().size());

        color.selectByVisibleText("Black");
        color.selectByVisibleText("Red");
        color.selectByVisibleText("Silver");
        assertEquals(3, color.getAllSelectedOptions().size());

        List<String> exp_sel_options = Arrays.asList("Black", "Red", "Silver");
        List<String> act_sel_options = new ArrayList<>();

        for (WebElement option : color.getAllSelectedOptions()) {
            act_sel_options.add(option.getText());
        }

        // Verify expected options match with actual options selected
        assertArrayEquals(exp_sel_options.toArray(), act_sel_options.toArray());

        // Deselect an option using visible text
        color.deselectByVisibleText("Silver");
        // Verify selected options count
        assertEquals(2, color.getAllSelectedOptions().size());

        // Deselect an option using value attribute of the option
        color.deselectByValue("rd");
        // Verify selected options count
        assertEquals(1, color.getAllSelectedOptions().size());

        // Deselect an option using index of the option
        color.deselectByIndex(0);
        // Verify selected options count
        assertEquals(0, color.getAllSelectedOptions().size());


    }
    @After
    public void tearDown() {
        driver.close();
    }

}
