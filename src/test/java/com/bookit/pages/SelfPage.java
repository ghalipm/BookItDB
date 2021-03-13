package com.bookit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelfPage extends BasePage{

    @FindBy(xpath = "//p[.='name']/preceding-sibling::p")
    public WebElement name;

    @FindBy(xpath = "//p[.='role']/preceding-sibling::p")
    public WebElement role;

    @FindBy(xpath = "//p[.='team']/preceding-sibling::p")
    public WebElement team;

    @FindBy(xpath = "//p[.='batch']/preceding-sibling::p")
    public WebElement batch;

    @FindBy(xpath = "//p[.='campus']/preceding-sibling::p")
    public WebElement campus;

    @FindBy(xpath = "//p[.='side']/preceding-sibling::p")
    public WebElement side;
}
