package com.demo.day5;

//import org.apache.tools.ant.taskdefs.Tstamp;
//import org.apache.tools.ant.taskdefs.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class wait {
    WebDriver driver;

    /*
     *driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  全局等待 一般写在Befor中 对所有case生效
     *wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div"))); 显示等待 直到这个元素出现后再运行下面的代码
     */
    @BeforeMethod
    public void openC() {
        System.setProperty("webdriver.chrome.driver", "D:\\chrome下载\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void waitTest1() {
        driver.get("file:///D:/java%E5%AD%A6%E4%B9%A0/selenium%20java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        String w = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(w, "wait for display");
    }

    @Test
    public void waitTest2() {
        driver.get("file:///D:/java%E5%AD%A6%E4%B9%A0/selenium%20java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));
        String w = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(w, "wait for display");
    }


    @AfterMethod
    public void closeC() {
        driver.quit();
    }
}
