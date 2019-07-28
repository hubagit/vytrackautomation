package com.vytrack.practices;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VYTrackUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {


    @Test
    public void loginTest1(){
        LoginPag loginPag = new LoginPag();
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        loginPag.login(username,password);

        Assert.assertEquals(VYTrackUtils.getPageSubTitle(),"Dashboard");
    }

    @Test
    public void negativeLoginTest1(){
        LoginPag loginPag = new LoginPag();
        loginPag.login("wrong","123");
        Assert.assertEquals(loginPag.getErrorMessage(),"Invalid user name or password.");
    }
}
