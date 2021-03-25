package com.bookit.pages;

import com.bookit.utilities.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends BasePage{

    //coming from FreeSpotsPage
    // clicking confirmButton, you go to BookingStatusPage
@FindBy(xpath = "//button[.='confirm']")
    public WebElement confirmButton;

public void confirm(){
    WaitUtils.waitUntilClickable(confirmButton);
    confirmButton.click();
}

}
