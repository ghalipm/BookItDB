package com.bookit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//h1[.='me']")
    public WebElement me;

    @FindBy(xpath = "//p[.='team']")
    public WebElement teamSubtitle;

    public List<WebElement> getUserInfo() {
        List<WebElement> elements = new ArrayList<>();
        elements.add(name);
        elements.add(team);
        elements.add(role);
        elements.add(batch);
        elements.add(campus);
        return elements;
    }
}
