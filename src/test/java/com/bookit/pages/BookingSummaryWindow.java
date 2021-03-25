package com.bookit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class BookingSummaryWindow extends BasePage {

     // coming from MyBookedSchedulePage, you see bookingSummary.
    // you can cancel your booking or accept it by clicking
     // outside the window or doing nothing
    //in both cases, you go back to MyBookedSchedulePage

    @FindBy(xpath = "(//p/time)[1]")
    public WebElement bookedDate;

    @FindBy(xpath = "(//p/time)[2]")
    public WebElement bookedHours;

    // size 6:
    @FindBy(xpath = "//p[@class='title is-6']")
    public List<WebElement> bookingInfoTitles;

    //size 5: we need to have extendedBookingInfoSubTitles
    // = capacityClue+ bookingInfoSubTitles to match bookingInfoTitles
    @FindBy(xpath = "//p[@class='subtitle is-7']")
    public List<WebElement> bookingInfoSubTitles;


    @FindBy(xpath = "(//p[@class='title is-size-4'])[1]")
    public WebElement bookedRoomName;

    @FindBy(xpath = "//p[@class='subtitle is-7 ng-star-inserted']")
    public WebElement capacityClue;
    // if capacityClue.getText()="the more the better", int capacity=6
    // if capacityClue.getText()="less is more", int capacity=4

    // only UI-info from this window  should be compared to DB-info.

    @FindBy(xpath = "//button[.='cancel conference']")
    public WebElement cancelConferenceButton;


    //size 5: we need to have extendedBookingInfoSubTitles
    // = capacityClue+ bookingInfoSubTitles to match bookingInfoTitles

    public List<WebElement> extendedBookingInfoSubTitles(){

        List<WebElement> extendedBookingInfoSubTitles=new ArrayList<WebElement>();
        extendedBookingInfoSubTitles.addAll(Collections.singletonList(capacityClue));
        extendedBookingInfoSubTitles.addAll(bookingInfoSubTitles);

        return extendedBookingInfoSubTitles;
    }

    public List<WebElement> getBookingInfoTitles(){
        return bookingInfoTitles;
    }

    public String getBookedRoomName(){
        return bookedRoomName.getText();
    }

    public int getBookedRoomCapacityValue(){
        int capVal=0;
        if(capacityClue.getText().equals("less is more")){capVal=4;}
        else if (capacityClue.getText().equals("the more the better")){capVal=6;}
        else{}
        return capVal;
    }






    public List<String> getBookingInfo(){
        List<String> bookingInfoText=null;

        return bookingInfoText;
    }

}
