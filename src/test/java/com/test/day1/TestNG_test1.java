package com.test.day1;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.testng.annotations.*;

public class TestNG_test1 {
    @BeforeTest
    public void Beforetestday1() {
        System.out.println("Beforetestday1");
    }
    @BeforeMethod
    public void BeforeMethodday1() {
        System.out.println("BeforeMethodday1");
    }
    @Test
    public void testday3(){
        System.out.println("test3");
    }
    @Test
    public void testday2(){
        System.out.println("test2");
    }
    @Test
    public void aestday1(){
        System.out.println("aest1");
    }
    @AfterMethod
    public void AfterMethod1(){
        System.out.println("AfterMethod1");
    }
    @AfterTest
    public void AfterTestday1(){
        System.out.println("AfterTestday1");
    }
}
