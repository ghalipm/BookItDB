package com.bookit.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

import static com.bookit.utilities.BrowserUtils.hoverOver;
import static com.bookit.utilities.WaitUtils.*;

public class HuntPage extends BasePage{

    //coming from MapPage, click on "hunt' tab
    // you see: : hunt for spot(pick date and time)
    // after picking up everything and clicking searchButton
    // you go to FreeSpotsPage

    //  //button[@class='mat-icon-button']
    //  (//span[@class='mat-button-wrapper'])[1]
    //  //button[@class='mat-icon-button']

    @FindBy(xpath = "//button[@class='mat-icon-button']")
    public WebElement huntDatePicker;

    @FindBy(xpath = "//span[.='available iffy time']")
    public WebElement available_iffy_time;

    @FindBy(xpath = "(//td[@class='mat-calendar-body-cell ng-star-inserted'])[2]")
    // booking 2 days ahead
    public List<WebElement> daysToChoose;

    @FindBy(xpath = "(//span[@class='tag is-transparent'])[1]")
    public WebElement availableTime;


    @FindBy(xpath = "(//div[@class='mat-select-arrow'])[1]")
    public WebElement initialHourPicker;

    //  //mat-option[@id='mat-option-0']
    //  (//span[@class='mat-option-text'])[1]
    // choose first available hour
    @FindBy(xpath = "(//span[@class='mat-option-text'])[2]")
    public WebElement firstAvailableHour;


    @FindBy(xpath = "(//div[@class='mat-select-arrow'])[2]")
    public WebElement terminalHourPicker;

    /*
    public int hourSelector(){
        int k=0;
        waitUntilVisible(firstAvailableHour);
        if(firstAvailableHour.getText().equals(" 30 minutes")){ k=1;}
        if(firstAvailableHour.getText().equals("1 hour ")){ k=2;}
        if(firstAvailableHour.getText().equals("1 hour 30 minutes")){ k=3;}
        if(firstAvailableHour.getText().equals("2 hours ")){ k=4;}

        return k;
    }

    int h=hourSelector();
     */

    String terminalHourXpath="(//span[@class='mat-option-text'])[2]" ;

    @FindBy(xpath = "//span[@class='mat-option-text']" )
    public List<WebElement> terminalHours;
    // taking the hours as List<WebElement> was THE key!
    // then one can click on specific element.
    //taking each element or taking all as one element will not work!!!

    @FindBy(xpath = "(//span[@class='mat-button-wrapper'])[2]")
    public WebElement searchButton;

    @FindBy(xpath = "//span[.='available solid time']")
    public WebElement availableSolidTime;

    public void chooseDate() {
        waitForClickable(huntDatePicker,5);
        //huntDatePicker.click();
        huntDatePicker.sendKeys(Keys.ENTER);
        waitForClickable(daysToChoose.get(0),3);
            int day=daysToChoose.size()-1;
    daysToChoose.get(day).click();
    }

    public void chooseInitialHour() {
        waitUntilVisible(availableSolidTime);
        initialHourPicker.click();
        waitForClickable(firstAvailableHour,2);
        firstAvailableHour.click();
    }

    public void chooseTerminalHour() {
        //waitForClickable(terminalHourPicker,2);
        terminalHourPicker.click(); // problem is below
        waitUntilClickable(terminalHours.get(1));

        hoverOver(terminalHours.get(1)); // without hoverOver, it is lost here and quits!
       //terminalHour.click();
       terminalHours.get(1).click();
    }

    public void clickSearch() {
       //waitUntilVisible(terminalHours.get(1));
        waitForClickable(searchButton, 2);
        searchButton.click();
    }



}
