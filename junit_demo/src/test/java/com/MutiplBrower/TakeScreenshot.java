package com.MutiplBrower;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class TakeScreenshot {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.baidu.com");

        Thread.sleep(1000);

        // 调用截图方法
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

        try{

            ImageIO.write(image, "png", new File("C:\\Users\\cooho\\Desktop\\test\\junit_demo\\pic\\screen_robot.png"));

        }catch(IOException e){

            System.out.println(e.getMessage());
        }

    }
}
