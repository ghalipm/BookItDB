package com.bookit.pages;

import com.bookit.utilities.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FreeSpotsPage extends BasePage{

    //coming from HuntPage

    // clicking one of the book=roomsToBook options,
    // you go to ConfirmationPage

    @FindBy(xpath = "//button[.='book']")
    public List<WebElement> roomsToBook;

    @FindBy(xpath = "(//button[.='book'])[2]")
    public WebElement bookButtonForFirstRoom;

    public void bookConference(){
        WaitUtils.waitUntilClickable(roomsToBook.get(2));
        roomsToBook.get(2).click();
    }


}
