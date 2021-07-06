package com.test.day2;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.WebDriver.*;

public class ActionTest {
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
        //webdriver.findElement(By.id("su")).clear();
        Thread.sleep(3000);
        //浏览器最大化
        webdriver.manage().window().maximize();


        //截图操作
        File jt = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(jt,new File("D:\\java\\TEST\\screenshot\\test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //getText获取a标签中连接文本
        String link = webdriver.findElement(By.linkText("新闻")).getText();
        Assert.assertEquals(link,"新闻");

        //文本框输入并判断输入文本框内容是否正确
        WebElement Wb1 = webdriver.findElement(By.id("kw"));
        Wb1.sendKeys("广州疫情");

        //获取value值
        String CHbd = webdriver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(CHbd,"百度一下");

        //判断元素是否存在
        boolean b = webdriver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
        System.out.println(b);

        //选择单选项
        //boolean bl = webdriver.findElement(By.xpath("")).isSelected();
        //Assert.assertTrue(bl,"校验单选框已选中");

        //校验按钮是否可点击
        //boolean bl = webdriver.findElement(By.xpath("")).isEnabled();
        //Assert.assertFalse(bl,"校验按钮为禁用状态");



        //点击查询
        WebElement bd = webdriver.findElement(By.id("su"));
        bd.click();
        Thread.sleep(3000);
        //获取界面title
        String tt = webdriver.getTitle();
        //校验是否存在title
        Assert.assertEquals(tt,"广州疫情_百度搜索");

        WebElement Xp = webdriver.findElement(By.xpath("//*[@id=\"2\"]/h3/a"));
        Xp.click();
        }


    @AfterMethod
    public void closeTest(){
        webdriver.quit();
    }


}
