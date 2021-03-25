package com.bookit.pages;

import com.bookit.utilities.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyBookedSchedulePage extends BasePage{

    // coming from BookingStatusPage
    // clicking myBookedTimeSlotTab (greyTab)
    // it brings you to BookingSummaryWindow

    // there are problems in this page with WebElements

    @FindBy(xpath = "(//*[@class='conference ng-star-inserted'])[1]")
    public List<WebElement> firstExistingConference;

    // if firstExistingConference=null or empty, no conference or room booked.

    // if there is conference, i.e., firstExistingConference=!null,
    // you click the tab , you go to BookingSummaryWindow


    public void getConference() {
        WaitUtils.waitUntilClickable(firstExistingConference.get(0));
        System.out.println("firstExistingConference.get(0).getText() = " + firstExistingConference.get(0).getText());
        firstExistingConference.get(0).click();
    }
}
