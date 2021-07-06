package com.test.day4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriverTest {
    @DataProvider(name = "loginUser")
    public Object[][] data(){
        return new Object[][]{{"user1","pwd2"},
                {"user2","pwd2"}};
    }
    @Test(dataProvider = "loginUser")
    public void loginUser(String user,String pad){
        System.out.println("user" + user);
        System.out.println("pad" + pad);
    }
}
