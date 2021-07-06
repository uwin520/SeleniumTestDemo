package com.test.day4;

import com.page.object.EmailLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Emailpage {
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
    public static void login(WebDriver webdriver, String email, String psw){
        webdriver.switchTo().frame("login_frame");
        webdriver.findElement(EmailLoginPage.emailInput).sendKeys(email);
        webdriver.findElement(EmailLoginPage.pwdInput).sendKeys(psw);
        webdriver.findElement(EmailLoginPage.loginButton).click();
    }

    /**
     * 登录成功
     */
    @Test
    public void  LoginTest() throws InterruptedException {
        login(webdriver, "649644434@qq.com", "aa199273!");
    }

}
