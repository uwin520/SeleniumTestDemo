package com.test.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {
    @Test
    //默认安装火狐
    public void openFF(){
        WebDriver webdriver = new FirefoxDriver();
    }

    @Test
    //自定义安装火狐
    public void openFF2(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver webdriver = new FirefoxDriver();
    }

    @Test
    //启动谷歌浏览器
    public void openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\java\\TEST\\drivers\\chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();
        Thread.sleep(5000);
        //关闭当前页面
        //webdriver.close();
        //完全退出浏览器
        webdriver.quit();
    }

    @Test
    //启动Edge浏览器
    public void openEdge(){
        System.setProperty("webdriver.edge.driver","D:\\java\\TEST\\drivers\\msedgedriver.exe");
        WebDriver webdriver = new EdgeDriver();
    }
}
