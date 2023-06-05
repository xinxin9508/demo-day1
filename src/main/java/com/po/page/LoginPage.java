package com.po.page;

import org.openqa.selenium.By;

public class LoginPage {
    //获取账号框
    public static By zhanghao = By.id("freename");
    //获取密码框
    public static By pwd = By.id("freepassword");
    //获取登录按钮
    public static By loginbtn = By.className("loginBtn");
    //获取登录后退出按钮
    public static By out = By.xpath("//*[@id=\"warpMain\"]/div[4]/div[1]/div[3]/div[3]/span/a");

}
