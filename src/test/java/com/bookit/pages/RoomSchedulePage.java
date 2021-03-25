package com.bookit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoomSchedulePage extends BasePage{

    @FindBy(xpath = "//h2[@class='subtitle']")
    public WebElement roomName;

    public String getRoomName() {
        return roomName.getText().trim();
    }



}
