package com.bookit.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingStatusPage extends BasePage{

    // coming from ConfirmationPage

    //clicking scheduleLink brings you to MyBookedSchedulePage

    @FindBy(xpath = "//h1[.='yey, you got it']")
    public WebElement confirmMsg;


    @FindBy(xpath = "//p[@class='has-text-grey']")
    public WebElement scheduleDetails;

    @FindBy(xpath = "(//a[.='schedule'])[2]")
    public WebElement scheduleLink;

    public void checkScheduleLink(){
        scheduleLink.click();
    }





}
