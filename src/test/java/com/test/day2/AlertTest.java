package com.test.day2;

import com.sun.glass.ui.Pixels;
import org.apache.bcel.generic.Visitor;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.EmptyStackException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class AlertTest {
    WebDriver webdriver;


    //每次执行完一个Test前就会执行BeforeMethod
    @BeforeMethod
    public void invokingUrlTest(){
        System.setProperty("webdriver.chrome.driver","D:\\java\\TEST\\drivers\\chromedriver.exe");
        webdriver = new ChromeDriver();


        //webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @Test
//启动谷歌浏览器
    public void navigate() throws InterruptedException, AWTException {

        webdriver.get("file:///F:\\学习内容\\java selenium\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        Thread.sleep(2000);
        webdriver.findElement(By.className("alert")).click();
        //alert弹窗,切换到alert窗口
        Thread.sleep(4000);
        Alert alert = webdriver.switchTo().alert();
        alert.accept();

        /**
         * 点击Confirm按钮
         * 在Confirm警告框点击取消按钮
         * 再点击确认按钮
         */
        Thread.sleep(4000);
        webdriver.findElement(By.className("confirm")).click();
        //confirm弹窗,切换到confirm窗口
        Thread.sleep(4000);
        Alert al = webdriver.switchTo().alert();
        al.dismiss();
        Thread.sleep(2000);
        al.accept();




        /**
         * 选择下拉多选项
         * 选择多个选项
         * 按住SHIFT键选择下拉框一个区间内参数
         * 按住control，选择相应点击参数(注意list（0）默认选择)
         */
        Actions as = new Actions(webdriver);
        WebElement w = webdriver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement>  list=webdriver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        //模拟键盘,（keyDown）按住SHIFT键,(keyUp)释放SHIFT键
        //as.keyDown(Keys.SHIFT).click(list.get((0))).click(list.get((2)))
         as.keyDown(Keys.CONTROL).click(list.get((2)))
        .keyUp(Keys.SHIFT).perform();


        /**
         * 下拉选择项
         */
        Thread.sleep(2000);
        Select select  = new Select(webdriver.findElement(By.id("moreSelect")));
        select.selectByValue("huawei");
        Thread.sleep( 2000 );
        select.selectByVisibleText("iphone");
        Thread.sleep(2000);

        /**
         * 全局等待
         * 在限定时间内，校验界面是否有匹配元素
         */
        webdriver.findElement(By.className("wait")).click();
        //设置时长5秒内，判断界面是否存元素（TimeUnit.SECONDS单位秒）
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String text = webdriver.findElement(By.className("red")).getText();
        //判断5秒内如查询不到相应元素，结束线程
        Assert.assertEquals(text,"wait for display");

        /**
         * 上传文件
         *
         */
        webdriver.findElement(By.id("load")).sendKeys("C:\\Users\\liangns\\Documents\\微信图片_20190326194441.jpg");
        Thread.sleep(3000);

        /**
         * 显示等待
         *
         */
        webdriver.findElement(By.className("wait2")).click();
        //设置时长3秒内，判断界面是否存元素,在3面内显示元素则继续继续，超过3秒则返回超时
        WebDriverWait wa =new WebDriverWait(webdriver,3);
        wa.until(ExpectedConditions.presenceOfElementLocated(By.className("red2")));

        String text2 = webdriver.findElement(By.className("red2")).getText();
        //判断5秒内如查询不到相应元素，结束线程
        //Assert.assertEquals(text2,"wait for display2");



        /**
         * 切换到IFrame中
         * 点击操作
         * */
        Thread.sleep(2000);
        //通过ID或name方式转交控制权
        //webdriver.switchTo().frame("aa");
        //通过webdriver方式获取
        WebElement we = webdriver.findElement(By.tagName("iframe"));
        webdriver.switchTo().frame("aa");
        webdriver.findElement(By.className("baidu")).click();
        Thread.sleep(3000);
        //控制权转交原界面
        webdriver.switchTo().defaultContent();
        webdriver.findElement(By.linkText("登陆界面")).click();
        Thread.sleep(3000);

        Robot robot = new Robot();
        //按住Ctrl按键
        robot.keyPress(KeyEvent.VK_CONTROL);
        //按住S按键
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);

        //把需按住的键转换为ASCII值，得到S的ASCII值
        //int keys = (int)new Character('S');
        //松开S键
        //System.out.println(keys);
        //robot.keyRelease(keys);
        //松开Ctrl键
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);




    }

    /**
     * 原界面中点击Open new window
     * 打开新界面点击百度
     */
    @Test
    public void testWin() throws InterruptedException {
        webdriver.get("file:///F:\\学习内容\\java selenium\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        Thread.sleep(2000);
        webdriver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(2000);
        //当前driver所在界面的句柄值
        String handle1 =webdriver.getWindowHandle();
        //判断是否新开界面
        for (String handles : webdriver.getWindowHandles()){
            if (handles.equals(handle1)){
                continue;
            }else {
                webdriver.switchTo().window(handles);
            }
        }
        webdriver.findElement(By.linkText("baidu")).click();
        //重新把操作权给到第一个操作界面
        webdriver.switchTo().window(handle1);
        Thread.sleep(2000);
    }


    /**
     * 点击Prompt按钮
     * 在Prompt弹出中，输入“参数”后
     * 点击确认
     * 再次点击确认按钮
     */
    @Test
    public void promptTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///F:\\学习内容\\java selenium\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        Thread.sleep(2000);
        webdriver.findElement(By.className("prompt")).click();
        Thread.sleep(2000);
        Alert alert1 = webdriver.switchTo().alert();
        alert1.sendKeys("这个是prompt");
        String test = alert1.getText();
        Assert.assertEquals(test,"这个是prompt");
        Thread.sleep(3000);
        alert1.accept();
        Thread.sleep(3000);
        alert1.accept();
        driver.quit();
    }

    @AfterMethod
    public void closeTest() throws InterruptedException {
        Thread.sleep(2000);
        webdriver.quit();
    }
    @Test
    public void Test() throws InterruptedException {
        webdriver.get("file:///F:\\学习内容\\java selenium\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement em = webdriver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        Actions as = new Actions(webdriver);
        Thread.sleep(2000);
        as.moveToElement(em).perform();
        Thread.sleep(3000);
        //xpath语法.//*[text()='Hello World!']，通过text语法查询界面是否存在Hello World!文本
        String hl = webdriver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
        Assert.assertEquals(hl,"Hello World!");
        //使用ctrl+s全选




    }


}
