package com.demo.day7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class seleniumGrid {

    @Test
    public void testChrom() throws InterruptedException, MalformedURLException {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.131.200:4444/wd/hub"),desiredCapabilities);
        driver.get("https://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
    }


    //数据驱动 以object开头
    @DataProvider(name = "test1")
    public Object[][] teat(){
        return new Object[][]{
                {"chrome"},
                {"firefox"}
        };
    }

    //调用数据驱动方法
    @Test(dataProvider = "test1")
    public void testGrid(String browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = null;
        if (browser.equals("chrome")){
            desiredCapabilities = DesiredCapabilities.chrome();
        } else if (browser.equals("firefox")) {
            desiredCapabilities = DesiredCapabilities.firefox();

        }else {
            System.out.println("error");
        }
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.131.200:4444/wd/hub"),desiredCapabilities);
        driver.get("https://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void close(){
        System.out.println("git");
    }
}
