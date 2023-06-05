package com.demo.day7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class register {

    WebDriver driver;

    @BeforeMethod
    public void openC() {
        System.setProperty("webdriver.chrome.driver", "D:\\chrome下载\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mail.sina.com.cn/");
    }

    @Test
    public void registerTest() throws InterruptedException {
        driver.findElement(By.className("registerBtn")).click();
        String handle = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }
        //生产一个随机数+10再*100 通过String.valueOf转化为string类型
        Random random = new Random();
        int num = (random.nextInt(90) + 10)*100;
        int num1 = (random.nextInt(90) + 10)*100;
        String phoneNum = "152"+String.valueOf(num)+String.valueOf(num1);
        String pswNum = "152"+String.valueOf(num)+String.valueOf(num1);
        //定位输入账号
        driver.findElement(By.name("email")).sendKeys("gu"+phoneNum);
        //定位输入密码
        driver.findElement(By.name("psw")).sendKeys("gu"+pswNum);
        //确认密码
        driver.findElement(By.name("npsw")).sendKeys("gu"+pswNum);
        //手机号码
        driver.findElement(By.name("phonenumber")).sendKeys(pswNum);
        //输入验证码
        driver.findElement(By.name("imgvcode")).sendKeys("pswNum");
        //短信验证码
        driver.findElement(By.name("msgvcode")).sendKeys("95554");
        //接受协议
        driver.findElement(By.id("agreement1")).click();

//        Alert alert = driver.switchTo().alert();
//        alert.accept();
        //点击注册
        driver.findElement(By.linkText("立即注册")).click();
        Thread.sleep(3000);

    }

    @Test
    public void random() {
        Random random = new Random();
//        int num = random.nextInt(1000);
        for (int i = 0; i < 10; i++) {
            int num = (random.nextInt(90) + 10) * 100;
            int num1 = (random.nextInt(90) + 10) * 100;
            String phoneNum = "135" + String.valueOf(num) + String.valueOf(num1);
            System.out.println(phoneNum);
        }
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
