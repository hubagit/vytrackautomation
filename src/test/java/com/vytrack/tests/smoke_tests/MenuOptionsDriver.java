package com.vytrack.tests.smoke_tests;

import com.vytrack.tests.utilities.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MenuOptionsDriver {

    WebDriver driver = BrowserFactory.getDriver("chrome");
    Actions action =new Actions(driver);

    @BeforeMethod
    public void setUp(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
    }

    @Test (priority = 1)
    public void driverTest1() {
        driver.findElement(By.id("prependedInput")).sendKeys("User151");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);

        //=================================Step-2==================================

        WebElement fleetModule =driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[1]"));
        SeleniumUtils.waitPlease(3);
        action.moveToElement(fleetModule);
        SeleniumUtils.waitPlease(3);
        WebElement vehicle = driver.findElement(By.xpath("(//span[@class='title title-level-2'][contains(text(),'Vehicles')])[1]"));
        SeleniumUtils.waitPlease(3);
        action.moveToElement(vehicle);
        action.click().build().perform();
        SeleniumUtils.waitPlease(3);

        String expectedTitle1 = "Car - Entities - System - Car - Entities - System";
        String actualTitle1 = driver.getTitle();
        Assert.assertEquals(expectedTitle1,actualTitle1);
        SeleniumUtils.waitPlease(3);

        String expectedPageName1 ="Cars";
        String actualPageName1 = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedPageName1,actualPageName1);
        SeleniumUtils.waitPlease(3);

        //==============================Step-3=============================================


        WebElement customers = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        SeleniumUtils.waitPlease(3);
        action.moveToElement(customers);
        SeleniumUtils.waitPlease(3);
        WebElement accounts = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span"));
        SeleniumUtils.waitPlease(3);
        action.moveToElement(accounts);
        action.click().build().perform();
        SeleniumUtils.waitPlease(3);

        String expectedTitle2 = "Accounts - Customers";
        String actualTitle2 = driver.getTitle();
        Assert.assertEquals(expectedTitle2,actualTitle2);
        SeleniumUtils.waitPlease(3);

        String expectedPageName2 ="Accounts";
        String actualPageName2 = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/h1")).getText();
        Assert.assertEquals(expectedPageName2,actualPageName2);
        SeleniumUtils.waitPlease(3);

        //=============================Step-4==================================


        action.moveToElement(customers);
        SeleniumUtils.waitPlease(3);
        WebElement contacts = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[4]/a/span"));
        SeleniumUtils.waitPlease(3);
        action.moveToElement(contacts);
        action.click().build().perform();
        SeleniumUtils.waitPlease(3);

        String expectedTitle3 = "Contacts - Customers";
        String actualTitle3 = driver.getTitle();
        Assert.assertEquals(expectedTitle3,actualTitle3);
        SeleniumUtils.waitPlease(2);

        String expectedPageName3 ="Contacts";
        String actualPageName3 = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/h1")).getText();
        Assert.assertEquals(expectedPageName3,actualPageName3);
        SeleniumUtils.waitPlease(2);

        //========================================Step-5===========================================

        WebElement activities =  driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span"));
        action.moveToElement(activities);
        SeleniumUtils.waitPlease(3);
        WebElement calendarEvents =  driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/div/div/ul/li[3]/a/span"));
        SeleniumUtils.waitPlease(3);
        action.moveToElement(calendarEvents);
        action.click().build().perform();
        SeleniumUtils.waitPlease(3);

        String expectedTitle4 = "Calendar Events - Activities";
        String actualTitle4 = driver.getTitle();
        Assert.assertEquals(expectedTitle4,actualTitle4);
        SeleniumUtils.waitPlease(2);

        String expectedPageName4 ="Calendar Events";
        String actualPageName4 = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/h1")).getText();
        Assert.assertEquals(expectedPageName4,actualPageName4);
        SeleniumUtils.waitPlease(2);


    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
