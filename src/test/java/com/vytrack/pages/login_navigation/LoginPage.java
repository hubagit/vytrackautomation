package com.vytrack.pages.login_navigation;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver = Driver.getDriver();

    @FindBy(id = "prependedInput")
    public WebElement userNameElement;
    @FindBy(id = "prependedInput2")
    public WebElement passwordElement;
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
}
