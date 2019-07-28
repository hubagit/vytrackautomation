package com.vytrack.tests.components.login_navigation;


import com.vytrack.utilities.BrowserFactory;
import com.vytrack.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PageAccessTest {

    WebDriver driver = BrowserFactory.getDriver("chrome");


    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
    }
    @Test (priority = 1)
    public void vehicleContractsStoreManagerTest(){
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager216");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]")).click();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("(//span[@class='title title-level-2'])[6]")).click();
        SeleniumUtils.waitPlease(5);

        String expectedPageName = "All Vehicle Contract";
        String actualPageName = driver.findElement(By.xpath("(//h1[@class='oro-subtitle'])")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);
        SeleniumUtils.waitPlease(2);
    }
    @Test (priority = 2)
    public void vehicleContractsSalesManagerTest(){
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager282");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]")).click();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("(//span[@class='title title-level-2'])[6]")).click();
        SeleniumUtils.waitPlease(5);

        String expectedPageName = "All Vehicle Contract";
        String actualPageName = driver.findElement(By.xpath("(//h1[@class='oro-subtitle'])")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);
        SeleniumUtils.waitPlease(2);
    }
    @Test (priority = 3)
    public void vehicleContractsDriverTest(){
        driver.findElement(By.id("prependedInput")).sendKeys("user183");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]")).click();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("(//span[@class='title title-level-2'])[4]")).click();
        SeleniumUtils.waitPlease(5);

        String expectedMessage = "You do not have permission to perform this action.";
        String actualMessage = driver.findElement(By.xpath("(//div[@class='message'])[2]")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
        SeleniumUtils.waitPlease(2);
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='message'])[2]")).isDisplayed());
        SeleniumUtils.waitPlease(2);
    }



    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
