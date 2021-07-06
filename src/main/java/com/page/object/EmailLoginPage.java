package com.page.object;
import org.openqa.selenium.By;

public class EmailLoginPage {
    //定义邮箱输入文本框
    public static By emailInput = By.name("u");
    //定义密码输入文本框
    public static By pwdInput = By.name("p");
    //定义点击登录输入按钮
    public static By loginButton = By.id("login_button");
}
