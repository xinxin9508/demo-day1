package com.demo.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class clickAndgeturl {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\chrome下载\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
    }


    @Test
    public void click(){
        WebElement news = driver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[1]"));
        news.click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://news.baidu.com/");
    }

    /**
     * 打开网页
     * 校验taget
     */

    @Test
    public void tagName(){
       String tagName = driver.findElement(By.id("kw")).getTagName();
       Assert.assertEquals(tagName,"input");
    }

    /**
     * 打开网页
     * 获取百度一下按钮属性是否微“百度一下”
     * @throws InterruptedException
     */
    @Test
    public void getvalue(){
        String AttributeValue = driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(AttributeValue,"百度一下");
    }
    @Test
    public void clear() throws InterruptedException {
        WebElement input = driver.findElement(By.id("kw"));
        input.sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        Thread.sleep(3000);
        String title = driver.getTitle();
        input.clear();
        Thread.sleep(3000);
        Assert.assertEquals(title,"selenium_百度搜索");
    }

    /**
     * 打开网页
     * 判断百度一下按钮是否展示
     */

    @Test
    public void isDisplayed(){
       Boolean b = driver.findElement(By.id("su")).isDisplayed();
       Assert.assertTrue(b);
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
