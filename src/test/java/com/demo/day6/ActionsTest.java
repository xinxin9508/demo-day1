package com.demo.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import javax.xml.ws.WebEndpoint;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ActionsTest {

    /*
    actions 多操作方法 需要new 传入driver
    contextclick 右键点击
    perform 执行
    doubleclick 双击
    moveToElement 鼠标移动
    dragAndDropBy 拖拽
    keyDown 按下
    keyUp 松开
    robot java类 模拟键盘鼠标操作  actions类不支持字母和数字键
    upload 上传 sendkeys 可以用作上传
     */

    WebDriver driver;

    @BeforeMethod
    public void openC() {
        System.setProperty("webdriver.chrome.driver", "D:\\chrome下载\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void contextclickTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement element = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
        Thread.sleep(3000);

    }

    @Test
    public void doubleTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement element = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
        Thread.sleep(3000);
    }

    @Test
    public void move() {
        driver.get("file:///D:/java%E5%AD%A6%E4%B9%A0/selenium%20java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        WebElement element = driver.findElement(By.className("over"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        WebElement element1 = driver.findElement(By.xpath(".//*[text()=\"Hello World!\"]"));
        String hello = element1.getText();
        Assert.assertEquals(hello, "Hello World!");
    }

    @Test
    public void drop() throws InterruptedException {
        driver.get("file:///D:/java%E5%AD%A6%E4%B9%A0/selenium%20java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, 300, 300).perform();
        Thread.sleep(3000);
        WebElement element1 = driver.findElement(By.xpath(".//*[text()=\"拖到我这里\"]"));
//        actions.dragAndDrop(element,element1).perform();
        Thread.sleep(3000);
        /*clickAndHold 按住
         *release 释放
         */
        actions.clickAndHold(element).moveToElement(element1).release().perform();
    }

    @Test
    public void moreSelectTest() throws AWTException, InterruptedException {
        driver.get("file:///D:/java%E5%AD%A6%E4%B9%A0/selenium%20java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
//        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
//        Robot robot = new Robot();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT)
//                .click(list.get(0))
                .click(list.get(2))
                .keyUp(Keys.SHIFT);
        Thread.sleep(3000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.presenceOfElementLocated())
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);


    }

    @Test
    public void loadup() throws InterruptedException {
        driver.get("file:///D:/java%E5%AD%A6%E4%B9%A0/selenium%20java/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.id("load")).sendKeys("D:\\java学习\\selenium java\\day3\\更多资料获取加 qq1489246768(像风一样).txt");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
