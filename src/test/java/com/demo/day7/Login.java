package com.demo.day7;

import com.po.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
    static WebDriver driver;

    @BeforeTest
    public void open() {
        System.setProperty("webdriver.chrome.driver", "D:\\chrome下载\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.sina.com.cn/");
    }

    @DataProvider(name = "test1")
    public Object[][] testLog(){
        return new Object[][]{
                {"user1","944714679"},
                {"user2","123456"}
        };
    }

    public static void loginTest(String zhanghao, String psw) {
        driver.findElement(LoginPage.zhanghao).sendKeys(zhanghao);
        driver.findElement(LoginPage.pwd).sendKeys(psw);
        driver.findElement(LoginPage.loginbtn).click();
    }

    @Test
    public static void LogTest() throws InterruptedException {
        Login.loginTest("19144720817@sina.cn", "gu944714679");
        Thread.sleep(5000);
        //校验登录成功
        String el1 = driver.findElement(LoginPage.out).getText();
        Assert.assertEquals(el1,"[退出]");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
