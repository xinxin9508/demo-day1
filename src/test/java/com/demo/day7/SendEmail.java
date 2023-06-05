package com.demo.day7;

import com.po.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendEmail {
    static WebDriver driver;
    static WebDriverWait wait = new WebDriverWait(driver, 10);


    @BeforeMethod
    public void open() {
        System.setProperty("webdriver.chrome.driver", "D:\\chrome下载\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.sina.com.cn/");
    }

    public static void loginTest(String zhanghao, String psw) {
        driver.findElement(LoginPage.zhanghao).sendKeys(zhanghao);
        driver.findElement(LoginPage.pwd).sendKeys(psw);
        driver.findElement(LoginPage.loginbtn).click();
    }

    @Test
    public static void sendMail(){

        Login.loginTest("19144720817@sina.cn", "gu944714679");
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginPage.out));
        //校验登录成功
        String el1 = driver.findElement(LoginPage.out).getText();
        Assert.assertEquals(el1,"[退出]");

        //点击写信
        driver.findElement(By.xpath("//*[@id=\"coreBtn\"]/ul/li[1]/a")).click();
        //添加附件
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("atth1")));
        driver.findElement(By.name("atth1")).sendKeys("C:\\Users\\xinxin\\Pictures\\Screenshots\\test.png");

        //收件人
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tr_to\"]/td/ul/li/input")));
        driver.findElement(By.xpath("//*[@id=\"tr_to\"]/td/ul/li/input")).sendKeys("944714679@qq.com");
        //主题
        driver.findElement(By.name("subj")).sendKeys("TestEmail");
//        WebElement frame1 = driver.findElement(By.xpath("//*[@id=\"SinaEditor\"]/iframe"));
//        driver.switchTo().frame(frame1);x
////        frame1.sendKeys("This is Test");
//        driver.findElement(By.xpath("//*[@id=\"SinaEditor\"]/iframe")).sendKeys("This is Test");
//        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id=\"panel_main\"]/div[1]/span/span[1]/a/i[2]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='您的邮件已发送']")));
        Boolean success = driver.findElement(By.xpath(".//*[text()='您的邮件已发送']")).isDisplayed();
        Assert.assertTrue(success);
    }


    @AfterMethod
    public void close() {
        driver.quit();
    }
}
