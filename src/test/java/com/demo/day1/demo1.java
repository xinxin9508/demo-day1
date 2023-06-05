package com.demo.day1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo1 {

    @Test
    public void testCase1(){
        System.out.println("aaa");
    }

    @Test
    public void testCase2(){
        System.out.println("bbbb");
    }
    @BeforeTest
    public void beforetest(){
        System.out.println("before");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("after");
    }
}
