package com.demo.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import javax.lang.model.util.Elements;
import java.util.List;

public class findAndclick {
    WebDriver driver;

    @BeforeMethod
    public void openC(){
        System.setProperty("webdriver.chrome.driver","D:\\chrome下载\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
    }

    @Test
    public void findElemen(){
        WebElement input = driver.findElement(By.id("kw"));
        input.sendKeys("selenium");
    }
    @Test
    public void click(){
        WebElement button = driver.findElement(By.xpath("//*[@id=\"su\"]"));
        button.click();
    }

    @Test
    public void findList() throws InterruptedException {
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"s-top-left\"]/a[1]"));
        Thread.sleep(3000);
        System.out.println(list);
    }

    @Test
    public void findList1() throws InterruptedException {
        WebElement list = driver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[1]"));
        System.out.println(list);
        list.click();
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        System.out.println(url);
    }

    @AfterMethod
    public void closeC(){
        driver.quit();
    }
}
