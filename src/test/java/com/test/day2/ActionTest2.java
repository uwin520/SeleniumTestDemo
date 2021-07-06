package com.test.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionTest2 {
    WebDriver webdriver;

    //每次执行完一个Test前就会执行BeforeMethod
    @BeforeMethod
    public void invokingUrlTest(){
        System.setProperty("webdriver.chrome.driver","D:\\java\\TEST\\drivers\\chromedriver.exe");
        webdriver = new ChromeDriver();

    }

    @Test
    public void ClickTest() throws InterruptedException {
        webdriver.get("file:///F:\\学习内容\\java selenium\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        Thread.sleep(2000);
    /**
     * 打开百度
     * 在百度一下按钮点击右键
     */
        WebElement we = webdriver.findElement(By.tagName("iframe"));
        webdriver.switchTo().frame("aa");
        webdriver.findElement(By.className("baidu")).click();
        Thread.sleep(3000);
        //控制权转交原界面
        webdriver.switchTo().defaultContent();
        webdriver.findElement(By.linkText("登陆界面")).click();
        Thread.sleep(3000);
        WebElement bd = webdriver.findElement(By.id("su"));
        //实例化Actions类
        Actions actions = new Actions(webdriver);
        //触发点击右键方法(.perform()执行)
        actions.contextClick(bd).perform();

        /**
         * 双击百度一下按钮
         */
        actions.doubleClick().perform();
    }

    /**
     *界面内容拖动
     */
    @Test
    public void dragAndDropTest() throws InterruptedException {
        webdriver.get("file:///F:/%E5%AD%A6%E4%B9%A0%E5%86%85%E5%AE%B9/java%20selenium/Web%E8%87%AA%E5%8A%A8%E5%8C%96selenium%EF%BC%88java%E8%AF%AD%E8%A8%80%E7%89%88%EF%BC%89/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/dragAndDrop.html");
        Thread.sleep(2000);

        WebElement yd = webdriver.findElement(By.id("drag"));
        Actions tp = new Actions(webdriver);
        //指定移动元素
        tp.dragAndDropBy(yd,500,500).perform();
        Thread.sleep(2000);

        //指定元素移动到另一个元素下
        WebElement yd1 = webdriver.findElement(By.id("drag"));
        WebElement yd2 = webdriver.findElement(By.xpath("/html/body/h1"));
        //按住(clickAndHold)需拖动元素,移动（moveToElement）元素上,释放（release）拖动元素
        tp.clickAndHold(yd1).moveToElement(yd2).release(yd1).perform();

    }

    @AfterMethod
    public void closeTest() throws InterruptedException {
        Thread.sleep(2000);
        webdriver.quit();
    }

}
