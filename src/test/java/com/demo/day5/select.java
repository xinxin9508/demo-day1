package com.demo.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class select {
    /**
     * select 下拉框
     * selectByindex 通过索引查找
     * selectByvalue 通过属性来选取
     * selectByVisibleText 通过标签之前的text来选取
     */

    WebDriver driver;


    @BeforeMethod
    public void openC(){
        System.setProperty("webdriver.chrome.driver","D:\\chrome下载\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void Byindex() throws InterruptedException {
        driver.get("file:///D:/java%E5%AD%A6%E4%B9%A0/selenium%20java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement select = driver.findElement(By.id("moreSelect"));
        Select select1 = new Select(select);
        select1.selectByIndex(0);
        Thread.sleep(3000);
        select1.selectByValue("meizu");
        Thread.sleep(3000);
        select1.selectByVisibleText("huawei");
    }



    @AfterMethod
    public void cloes() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
