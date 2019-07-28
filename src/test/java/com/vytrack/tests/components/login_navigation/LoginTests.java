package com.vytrack.tests.components.login_navigation;


import com.vytrack.pages.login_navigation.LoginPage;
import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests extends TestBase {

    @Test
    public void loginTest1(){
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        loginPage.clickRememberMe();
        loginPage.login(username, password);
        //to verify that Dashboard page opened
        //Once page name Dashboard displays, means that we are logged successfully
        Assert.assertEquals(VYTrackUtils.getPageSubTitle(), "Dashboard");
    }
    @Test
    public void negativeLoginTest1(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrongusername", "wrongpassword");
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid user name or password.");
    }

}















    //========================HomeWork==========================
//    WebDriver driver = BrowserFactory.getDriver("chrome");
//
//
//    @BeforeMethod
//    public void setUp(){
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.get("http://qa2.vytrack.com/user/login");
//    }
//    @Test (priority = 1)
//    public void positiveLoginTest(){
//        driver.findElement(By.id("prependedInput")).sendKeys("storemanager216");
//        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
//        SeleniumUtils.waitPlease(2);
//        String userName = driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]")).getText();
//        Assert.assertTrue(driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]")).isDisplayed());
//        SeleniumUtils.waitPlease(2);
//        String expectedPageName = "Dashboard";
//        String actualPageName = driver.findElement(By.xpath("(//h1[@class='oro-subtitle'])")).getText();
//        Assert.assertEquals(actualPageName,expectedPageName);
//        SeleniumUtils.waitPlease(2);
//        driver.findElement(By.xpath("(//i[@class='fa-caret-down'])")).click();
//        SeleniumUtils.waitPlease(2);
//        driver.findElement(By.xpath("(//a[@class='no-hash'])")).click();
//        SeleniumUtils.waitPlease(2);
//
//        //============================================Step-5===================================
//
//        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager282");
//        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
//        SeleniumUtils.waitPlease(2);
//        String username1 = driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]")).getText();
//        Assert.assertNotEquals(userName,username1);
//        SeleniumUtils.waitPlease(2);
//        String expectedPageName1 = "Dashboard";
//        String actualPageName1 = driver.findElement(By.xpath("(//h1[@class='oro-subtitle'])")).getText();
//        Assert.assertEquals(actualPageName1,expectedPageName1);
//        SeleniumUtils.waitPlease(2);
//        driver.findElement(By.xpath("(//i[@class='fa-caret-down'])")).click();
//        SeleniumUtils.waitPlease(2);
//        driver.findElement(By.xpath("(//a[@class='no-hash'])")).click();
//        SeleniumUtils.waitPlease(2);
//
//        //============================================Step-9===================================
//
//        driver.findElement(By.id("prependedInput")).sendKeys("user183");
//        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
//        SeleniumUtils.waitPlease(2);
//        String expectedPageName2 = "Quick Launchpad";
//        String actualPageName2 = driver.findElement(By.xpath("(//h1[@class='oro-subtitle'])")).getText();
//        Assert.assertEquals(actualPageName2,expectedPageName2);
//        SeleniumUtils.waitPlease(2);
//        String username2 = driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]")).getText();
//        Assert.assertNotEquals(userName,username2);
//        SeleniumUtils.waitPlease(2);
//        Assert.assertNotEquals(username1,username2);
//        SeleniumUtils.waitPlease(2);
//
//    }
//    @Test (priority = 2)
//    public void negativeLoginTest(){
//        driver.findElement(By.id("prependedInput")).sendKeys("user183");
//        driver.findElement(By.id("prependedInput2")).sendKeys("12345", Keys.ENTER);
//        SeleniumUtils.waitPlease(2);
//        String expectedMessage = "Invalid user name or password.";
//        String actualMessage = driver.findElement(By.xpath("(//div[@class='alert alert-error'])/div")).getText();
//        Assert.assertEquals(actualMessage,expectedMessage);
//        SeleniumUtils.waitPlease(2);
//        String expectedTitle = "Login";
//        String actualTitle = driver.findElement(By.xpath("(//h2[@class='title'])")).getText();
//        Assert.assertEquals(actualTitle,expectedTitle);
//        SeleniumUtils.waitPlease(2);
//        String expectedURL = "http://qa2.vytrack.com/user/login";
//        String actualURL = driver.getCurrentUrl();
//        Assert.assertEquals(actualURL,expectedURL);
//        SeleniumUtils.waitPlease(2 );
//
//
//
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        driver.close();
//    }

