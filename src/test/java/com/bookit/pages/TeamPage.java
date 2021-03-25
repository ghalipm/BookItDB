package com.bookit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class TeamPage extends BasePage{

    @FindBy(xpath = "//p[.='name']/preceding-sibling::p")
    public List<WebElement> names;

    @FindBy(xpath = "//p[.='role']/preceding-sibling::p")
    public List<WebElement> roles;

    @FindBy(xpath = "//h2")
    public WebElement teamName;
    // if it is set to  xpath = "//h1" or xpath = "//h1[.='team']"
    // we get the content/text "team", but never get
    // the name "GuardiansofGalaxy" of the team!!!

    public List<String> getNames() {
        List<String> namesList = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            namesList.add(names.get(i).getText());
        }
        return namesList;
    }

    public List<String> getRoles() {
        List<String> rolesList = new ArrayList<>();
        for (int i = 0; i < roles.size(); i++) {
            rolesList.add(roles.get(i).getText());
        }
        return rolesList;
    }

    public List<String> getTeams() {
        List<String> teamsList = new LinkedList<>();
        for (int i = 0; i <names.size(); i++) {
            teamsList.add(i, teamName.getText());
        }
        return teamsList;
    }


}
