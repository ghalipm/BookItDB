package com.bookit.step_definitions;

import com.bookit.pages.LoginPage;
import com.bookit.utilities.BrowserUtils;
import com.bookit.utilities.ConfigurationReader;
import com.bookit.utilities.Driver;
import com.bookit.utilities.WaitUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on login page")
    public void the_user_is_on_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Given("the user logs in using {string} {string}")
    public void the_user_logs_in_using(String email, String password) {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login(email,password);
    }

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().loginAs(userType);
    }

    @Then("the user should be on {string} page")
    public void the_user_should_be_on_page(String expectedPage) {
        WaitUtils.waitUntilURLContains("/" + expectedPage);
        String actualUrl = BrowserUtils.getCurrentPageURL();
        Assert.assertTrue(actualUrl.contains(expectedPage));
    }
}
