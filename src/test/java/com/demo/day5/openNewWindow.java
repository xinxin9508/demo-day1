package com.demo.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class openNewWindow {
    /**
     * handle 句柄
     * getwindowhandles 获取窗口句柄
     */

    WebDriver driver;

    @BeforeMethod
    public void openC(){
        System.setProperty("webdriver.chrome.driver","D:\\chrome下载\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void openWindow() {
        driver.get("file:///D:/java%E5%AD%A6%E4%B9%A0/selenium%20java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        String handle = driver.getWindowHandle();
        driver.findElement(By.className("open")).click();
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }
        driver.findElement(By.className("baidu")).click();

    }




    @AfterMethod
    public void close(){
        driver.quit();
    }
}