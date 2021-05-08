package com.framework.listeners;

import org.testng.annotations.*;

public class runner {

    @BeforeSuite
    public void setUpSuite(){
        System.out.println("before suite in runner");
    }

    @AfterSuite
    public void tearDownSuite(){
        System.out.println("tear down suite in runner");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before method in runner");
}

    @AfterMethod
    public void tearDown(){
        System.out.println("After method in runner");
    }

    @Test
    public void test1(){
        System.out.println("test - 1  ");
    }

    @Test
    public void test2(){
        System.out.println("test - 2 ");
    }

    @Test
    public void test3(){
        System.out.println("test - 3  ");
    }
}
