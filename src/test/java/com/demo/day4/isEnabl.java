package com.demo.day4;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class isEnabl {

    WebDriver driver;


    @BeforeMethod
    public void openCherom(){
        System.setProperty("webdriver.chrome.driver","D:\\chrome下载\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    /*
    打开网页
    校验按钮是否激活
     */
    @Test
    public void isEnble(){
        driver.get("file:///D:/java%E5%AD%A6%E4%B9%A0/selenium%20java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/demo1.html");
        Boolean B = driver.findElement(By.xpath("//*[@id=\"button\"]/input")).isEnabled();
        Assert.assertFalse(B);
    }

    /*
    截图
     */

    @Test
    public  void  shut(){
        driver.get("https://www.baidu.com");
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils s = new file();
        try{
            s.copyFile(file,new File("D:\\test1.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void close(){

        driver.quit();
    }
}
