package com.demo.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class openBrowser {
    @Test
    public void openC(){
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);
    }
    @Test
    public void openFF() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();
    }
}
