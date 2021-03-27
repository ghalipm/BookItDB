package com.bookit.pages;

import com.bookit.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.bookit.utilities.BrowserUtils.hoverOver;
import static com.bookit.utilities.WaitUtils.waitUntilClickable;

public class MapPage extends BasePage{

    @FindBy(id="room-121")
    public WebElement kilimanjaro;

    @FindBy(id="room-122")
    public WebElement halfDome;

    @FindBy(id="room-123")
    public WebElement denali;

    @FindBy(id="room-124")
    public WebElement meru;

    //under map, there are 4 bookable rooms, it is better to keep them as List<WebElement>
    @FindBy(xpath = "//a[@class='room center-vertically']")
    public List<WebElement> bookableRooms;

    public void checkRoomsAvailability(){
        for (int i = 0; i <bookableRooms.size() ; i++) {
            waitUntilClickable(bookableRooms.get(i)).click();
        }
    }






}
