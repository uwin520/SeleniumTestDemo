package com.test.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_test2 {
    @Test
    //判定参数是否相等，如果不相等，结束执行
    public void assertEqualTest_test1(){
        String a="1";
        String b="2";

        Assert.assertEquals(a,b, "a不等于b");
        System.out.println("如果a不等于b，则不会打印");
    }
    @Test
    //判定参数不相等
    public void assertNoEqualTest_test1(){
        int a = 1;
        String b = "1";
        int c = 1;
        Assert.assertNotEquals(a,c);
    }
    @Test
    //判定参数是否为空
    public void assertnullTest_test1(){
        String a = null;
        Assert.assertNull(a);
    }
    @Test
    //判定参数不为空
    public void assertNonullTest_test1(){
        String a = null;
        Assert.assertNotNull(a);
    }

}
