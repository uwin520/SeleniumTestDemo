package com.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmailTest {
        WebDriver webdriver;

    //每次执行完一个Test前就会执行BeforeMethod
    @BeforeMethod
    public void invokingUrlTest(){
        System.setProperty("webdriver.chrome.driver","D:\\java\\TEST\\drivers\\chromedriver.exe");
        webdriver = new ChromeDriver();
        webdriver.get("https://mail.qq.com/");

    }

    /**
     * 封装登录静态方法
     */
    public static void login(WebDriver webdriver,String email,String psw){
        webdriver.switchTo().frame("login_frame");
        webdriver.findElement(By.name("u")).sendKeys(email);
        webdriver.findElement(By.name("p")).sendKeys(psw);
        webdriver.findElement(By.id("login_button")).click();
    }

    /**
     * 登录成功
     */
    @Test
    public void  LoginTest() throws InterruptedException {

        login(webdriver,"649644434@qq.com","aa199273!");

        WebDriverWait xx =new WebDriverWait(webdriver,10);
        xx.until(ExpectedConditions.presenceOfElementLocated(By.linkText("写信")));
        webdriver.findElement(By.linkText("写信")).click();

        WebDriverWait sjr =new WebDriverWait(webdriver,10);
        sjr.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"toAreaCtrl\"]/div[2]/span[1]")));
        webdriver.findElement(By.xpath("//*[@id=\"toAreaCtrl\"]/div[2]/span[1]")).sendKeys("shinyuwin@126.com");

        webdriver.findElement(By.id("subject")).sendKeys("测试");
        Thread.sleep(3000);
        //webdriver.findElement(By.xpath("//*[@id=\"composecontainer\"]/span[2]")).click();

        //webdriver.switchTo().frame("login_frame");

        WebDriverWait wa =new WebDriverWait(webdriver,10);
        wa.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        String tc = webdriver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(tc,"退出");
        webdriver.findElement(By.linkText("退出")).click();
    }

    @Test
    public void LoginError(){
        login(webdriver,"649644434@qq.com","aa199273");

        WebDriverWait wa =new WebDriverWait(webdriver,10);
        wa.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"error_tips\"]/span[2]")));

        String er =webdriver.findElement(By.xpath("//*[@id=\"error_tips\"]/span[2]")).getText();
        Assert.assertEquals(er,"你输入的帐号或密码不正确，请重新输入。");
    }

    @AfterMethod
    public void closeTest() throws InterruptedException {
        //Thread.sleep(2000);
        //webdriver.quit();
    }

}
