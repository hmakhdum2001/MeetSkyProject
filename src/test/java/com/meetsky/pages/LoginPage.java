package com.meetsky.pages;

import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="user")
    public WebElement usernameBox;

    @FindBy(id ="password")
    public WebElement passwordBox;

    @FindBy(id ="submit-form")
    public WebElement logInButton;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement wrongUsernamePasswordMessage;

    @FindBy (xpath = "//img[@src='/core/img/actions/toggle.svg']")
    public WebElement showPasswordExplicitlyIcon;

    @FindBy (id="lost-password")
    public WebElement forgotPasswordLink;

    @FindBy(id="reset-password-submit")
    public WebElement resetPasswordButton;

    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("username"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        //loginPage.logInButton.click();
        BrowserUtils.clickWithJS(logInButton);
        BrowserUtils.waitFor(5);
    }

}
