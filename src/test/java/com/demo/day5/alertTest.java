package com.demo.day5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class alertTest {
    /**
     * alert弹窗
     * dismiss 取消
     * accept 确定
     * switchto 移交控制
     * frame 内嵌网页
     * defaulcontent 原控制权
     */

    WebDriver driver;


    @BeforeMethod
    public void openC(){
        System.setProperty("webdriver.chrome.driver","D:\\chrome下载\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void alertAccept() throws InterruptedException {
        driver.get("file:///D:/java%E5%AD%A6%E4%B9%A0/selenium%20java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void  dismissTest() throws InterruptedException {
        driver.get("file:///D:/java%E5%AD%A6%E4%B9%A0/selenium%20java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        Alert aleat = driver.switchTo().alert();
        aleat.dismiss();
        Thread.sleep(1000);
        aleat.accept();
    }

    @Test
    public void promptTest() throws InterruptedException {
        driver.get("file:///D:/java%E5%AD%A6%E4%B9%A0/selenium%20java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("944714");
        String a = alert.getText();
        Assert.assertEquals(a,"我是提示信息");
        alert.dismiss();
        Thread.sleep(2000);
        alert.accept();
    }

    @Test
    public void frameTest() throws InterruptedException {
        driver.get("file:///D:/java%E5%AD%A6%E4%B9%A0/selenium%20java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement element = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(element);
        driver.findElement(By.className("baidu")).click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登陆界面")).click();
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

}
