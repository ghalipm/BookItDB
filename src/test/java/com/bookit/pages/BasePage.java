package com.bookit.pages;

import com.bookit.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.bookit.utilities.BrowserUtils.*;
import static com.bookit.utilities.BrowserUtils.hoverOver;
import static com.bookit.utilities.WaitUtils.*;
import static com.bookit.utilities.WaitUtils.waitUntilClickable;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(linkText = "map")
    public WebElement map;

    @FindBy(linkText = "schedule")
    public WebElement schedule;

    @FindBy(linkText = "hunt")
    public WebElement hunt;

    @FindBy(linkText = "my")
    public WebElement mySchedule;

    @FindBy(xpath = "//a[@class='navbar-link' and .='my']")
    public WebElement my;

    @FindBy(linkText = "self")
    public WebElement self;

    @FindBy(linkText = "team")
    public WebElement team;

    @FindBy(linkText = "sign out")
    public WebElement signOut;

    public void goToSelf() {
        hoverOver(my);
        waitUntilClickable(self).click();
    }

    public void goToTeam() {
        hoverOver(my);
        waitUntilClickable(team).click();
    }

    public void signOut() {
        hoverOver(my);
        waitUntilClickable(signOut).click();
    }
}
