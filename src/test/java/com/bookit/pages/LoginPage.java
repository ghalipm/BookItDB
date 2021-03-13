package com.bookit.pages;

import com.bookit.utilities.ConfigurationReader;
import com.bookit.utilities.Driver;
import com.bookit.utilities.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(name = "email")
    public WebElement emailBox;

    @FindBy(name = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[.='sign in']")
    public WebElement signInButton;

    public void login(String username, String password) {
        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
        WaitUtils.waitUntilClickable(signInButton).click();
    }

    public void loginAs(String userType) {
        String username;
        String password;
        if (userType.equalsIgnoreCase("student")) {
            username = ConfigurationReader.get("student_username");
            password = ConfigurationReader.get("student_password");
            login(username,password);
        } else if (userType.equalsIgnoreCase("teacher")) {
            username = ConfigurationReader.get("teacher_username");
            password = ConfigurationReader.get("teacher_password");
            login(username,password);
        } else if (userType.equalsIgnoreCase("team lead")) {
            username = ConfigurationReader.get("team_leader_username");
            password = ConfigurationReader.get("team_leader_password");
            login(username,password);
        } else {
            throw new RuntimeException("Invalid User Type");
        }
    }
}
