package com.bookit.step_definitions;

import com.bookit.pages.MapPage;
import com.bookit.pages.TeamPage;
import com.bookit.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Team_stepDefs {

    @When("the user goes to team page")
    public void the_user_goes_to_team_page() {
        // Write code here that turns the phrase above into concrete actions
        MapPage mapPage = new MapPage();
        mapPage.goToTeam();

    }


    @Then("the team information on UI should match the info on database for user {string}")
    public void the_team_information_on_UI_should_match_the_info_on_database_for_user(String email) {
        // Write code here that turns the phrase above into concrete actions

        String query = "select u.firstname, u.role, t.name from  team t\n" +
                "                                             join users u on t.id = u.team_id\n" +
                "where t.name=(select  t.name from  team t\n" +
                "                                       join users u on t.id = u.team_id\n" +
                "              where u.email='" + email + "');";


        // get firstname, role, team as lists from DB
        List<Object> firstNamesDB=DBUtils.getColumnData(query, "firstname");
        List<Object> rolesDB=DBUtils.getColumnData(query, "role");
        List<Object> teamNamesDB=DBUtils.getColumnData(query, "name");

        /** to test if we got the right content from DB,
         * try out the following print statements
        System.out.println("firstnamesDB = " + DBUtils.getColumnData(query, "firstname"));
        System.out.println("rolesDB = " + rolesDB);
        System.out.println("teamNamesDB = " + teamNamesDB);
         */

        // get firstnames, roles, team names as lists from UI
        TeamPage teamPage=new TeamPage();
        List<String> rolesUI= teamPage.getRoles();
        List<String> teamUI= teamPage.getTeams();
        List<String> namesUI= teamPage.getNames();

        /**  to test if we got the right content from UI,
         * try out the following print statements
        System.out.println("rolesUI = " + rolesUI);
        System.out.println("teamUI = " + teamUI.toString());
        System.out.println("namesUI = " + namesUI);
         */

        assertEquals(namesUI, firstNamesDB);
        assertEquals(teamUI, teamNamesDB);
        assertEquals(rolesUI, rolesDB);
    }


}
