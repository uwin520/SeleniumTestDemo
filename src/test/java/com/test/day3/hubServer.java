package com.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class hubServer {
    @Test
    public void testHrome() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();

        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.44:8086/wd/hub"),dc);
        driver.get("https://www.baidu.com");
        Thread.sleep(40000);
        driver.quit();
    }

    /**
     * 建立数据驱动，用于不同浏览器跑脚本
     *1、DataProvider设置一个name参数，跟着Object类型返回值
     *2、通过Test调用驱动数据参数
     */
    @DataProvider(name = "date")
    public Object[] test(){
        return new Object[][]{
                //指定相应服务器运行
                {"firefox","http://192.168.0.44:5555"},
                {"chrome","http://192.168.0.44:8088"}};

    }
    @Test(dataProvider = "date")
    public void CallDrive(String drive,String url) throws InterruptedException, MalformedURLException {
        DesiredCapabilities dc = null;
        if (drive.contentEquals("firefox")){
            dc = DesiredCapabilities.firefox();
        }else  if (drive.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else {
            System.out.println("error");
        }
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.44:8086/wd/hub"),dc);
        driver.get("https://www.baidu.com");
        Thread.sleep(40000);
        driver.quit();
    }

}
