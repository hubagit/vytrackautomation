package com.vytrack.practices;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPag {

    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Long.valueOf(ConfigurationReader.getProperty("explicitwait")));

    @FindBy(id = "prependedInput")
    public WebElement usernameElement;

    @FindBy(id = "prependedInput2")
    public WebElement passwordElement;

    @FindBy(id = "_submit")
    public WebElement submitBtnElement;

    @FindBy(css = "[class='custom-checkbox__icon']")
    public WebElement rememberMeElement;

    @FindBy(css = "[class='form-signin__footer control-group form-row'] a")
    public WebElement forgotPasswordElement;

    @FindBy(css = "[class='title']")
    public WebElement titleElement;

    @FindBy(css = "[class='alert alert-error'] div")
    public WebElement warningElement;


    public LoginPag(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void login(String username, String password){
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        submitBtnElement.click();
    }

    public String getErrorMessage(){
        return warningElement.getText();
    }

    public void rememberMe(){
        wait.until(ExpectedConditions.elementToBeClickable(rememberMeElement));
        if(!rememberMeElement.isSelected()){
            rememberMeElement.click();
        }
    }
}
