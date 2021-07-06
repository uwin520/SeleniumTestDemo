package com.test.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrowserActionTest {
    WebDriver webdriver;

    //每次执行完一个Test前就会执行BeforeMethod
    @BeforeMethod
    public void invokingUrlTest(){
        System.setProperty("webdriver.chrome.driver","D:\\java\\TEST\\drivers\\chromedriver.exe");
        webdriver = new ChromeDriver();
    }

    @Test
    //启动谷歌浏览器
    public void navigate() throws InterruptedException {

        webdriver.get("http://www.baidu.com");

        //关闭当前页面
        //webdriver.close()
        WebElement Wb = webdriver.findElement(By.id("kw"));
        WebElement Nm = webdriver.findElement(By.name("wd"));
        WebElement cl = webdriver.findElement(By.className("quickdelete"));
        //webdriver.findElement(By.id("su")).clear();
        Thread.sleep(3000);
        //浏览器操作后退
        webdriver.navigate().back();
        Thread.sleep(3000);
        //浏览器最大化
        webdriver.manage().window().maximize();
        //刷新浏览器
        webdriver.navigate().refresh();
        Thread.sleep(2000);
        //浏览器操作前进
        webdriver.navigate().forward();
        Thread.sleep(5000);
        //浏览器窗口大小设置
        Dimension ds = new Dimension(900,800);
        webdriver.manage().window().setSize(ds);
        //webdriver.findElement(By.linkText("新闻"));
        //模糊查询Link连接元素
        webdriver.findElement(By.partialLinkText("新"));
        //通过查询界面input并指定获取第几个input
        List<WebElement> list =webdriver.findElements(By.tagName("input"));
        //查询界面有多少个input元素
        System.out.println(list.size());
        //操作第5个input元素，并输入相应的文本内容
        //list.get(5).sendKeys("");
        System.out.println("=====================================");

        //XPath获取单个标签
        WebElement Xp = webdriver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[1]"));
        //XPath获取所有标签，默认选择第一个
        WebElement Xp2 = webdriver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a"));
        System.out.println(Xp2.getText());
        System.out.println("=====================================");
        //XPath获取所有标签
        List<WebElement> ls= webdriver.findElements(By.xpath("//*[@id=\"s-top-left\"]/a"));
        //打印获取1个标签
        //String text = ls.get(2).getText();
        //打印获取所有标签
        for (int i=0; i<ls.size() ;i++) {
            String text = ls.get(i).getText();
            System.out.println(text);
        }
        //获取class值
        WebElement Cl = webdriver.findElement(By.className("index-logo-src"));

        Thread.sleep(2000);
        //完全退出浏览器
        webdriver.quit();
    }

    //获取Url
    @Test
    public void acquireUrlTest() throws InterruptedException {
        webdriver.get("https://www.baidu.com");
        String url = webdriver.getCurrentUrl();
        System.out.println("获取url地址:"+ url);
        Assert.assertEquals(url,"https://www.baidu.com/");
        Thread.sleep(2000);

    }


    //每次执行完一个Test后就会执行AfterMethod
    @AfterMethod
    public void closeTest(){
        webdriver.quit();
    }
}
