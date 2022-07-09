package com.meetsky.step_definitions;

import com.meetsky.pages.LoginPage;
import com.meetsky.pages.MainPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Logout_step_definition {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage= new MainPage();

    @Given("user should be in the main page")
    public void user_should_be_in_the_main_page() {
        loginPage.login();
    }
    @When("user clicks to user avatar")
    public void user_clicks_to_user_avatar() {
        //mainPage.avatarButton.click();
        BrowserUtils.clickWithJS(mainPage.avatarButton);

    }

    @When("user clicks the logout")
    public void user_clicks_the_logout() {
        mainPage.logOutButton.click();
        // BrowserUtils.clickWithJS(mainPage.logOutButton);
    }
    @Then("user lands on the login page")
    public void user_lands_on_the_login_page() {
        Assert.assertTrue(loginPage.usernameBox.isDisplayed());
    }

    @Then("user click step back button")
    public void user_click_step_back_button() {
        Driver.getDriver().navigate().back();
    }
}
