package com.bookit.pages;

import com.bookit.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.bookit.utilities.BrowserUtils.*;
import static com.bookit.utilities.BrowserUtils.hoverOver;
import static com.bookit.utilities.WaitUtils.*;
import static com.bookit.utilities.WaitUtils.waitUntilClickable;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//a[.='map']")
    public WebElement map;

    @FindBy(xpath = "//a[.='schedule']")
    public WebElement schedule;

    @FindBy(xpath = "//a[.='hunt']")
    public WebElement hunt;

    @FindBy(linkText = "my")
    public WebElement mySchedule;

    @FindBy(linkText = "general")
    public WebElement generalSchedule;

    @FindBy(xpath = "//a[@class='navbar-link' and .='my']")
    public WebElement my;

    @FindBy(linkText = "self")
    public WebElement self;

    @FindBy(linkText = "team")
    public WebElement team;

    @FindBy(linkText = "sign out")
    public WebElement signOut;

    //under map, there are 4 bookable rooms, it is better to keep them as List<WebElement>
    //@FindBy(xpath = "//a[@class='room center-vertically']")
    //public List<WebElement> bookableRooms;


    //under "my" module: self, team, sign out

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

    public void goToHunt() {
        hoverOver(hunt);
        waitUntilClickable(hunt).click();
    }

}
