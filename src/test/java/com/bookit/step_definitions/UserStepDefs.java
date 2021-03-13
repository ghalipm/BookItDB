package com.bookit.step_definitions;

import com.bookit.pages.MapPage;
import com.bookit.pages.SelfPage;
import com.bookit.utilities.DBUtils;
import com.bookit.utilities.WaitUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;

import static org.junit.Assert.*;

public class UserStepDefs {

    @When("the user goes to self page")
    public void the_user_goes_to_self_page() {
        MapPage mapPage = new MapPage();
        mapPage.goToSelf();
    }

    @Then("the information on UI should match the database for user {string}")
    public void the_information_on_UI_should_match_the_database_for_user(String email) {
        String query = "select firstname, lastname, role, t.name, t.batch_number, location\n" +
                "from users u\n" +
                "         join team t on u.team_id = t.id\n" +
                "         join campus c on t.campus_id = c.id\n" +
                "where email = '"+ email +"';";
        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        String expectedName = rowMap.get("firstname") + " " + rowMap.get("lastname");
        String expectedTeam = (String) rowMap.get("name");
        String expectedRole = (String) rowMap.get("role");
        String expectedBatch = "#" + rowMap.get("batch_number");
        String expectedCampus = (String) rowMap.get("location");

        SelfPage selfPage = new SelfPage();

        WaitUtils.waitUntilTextToBe(selfPage.team,expectedTeam);

        String actualName = selfPage.name.getText().trim();
        String actualTeam = selfPage.team.getText().trim();
        String actualRole = selfPage.role.getText().trim();
        String actualBatch = selfPage.batch.getText().trim();
        String actualCampus = selfPage.campus.getText().trim();

        assertEquals(expectedName,actualName);
        assertEquals(expectedTeam,actualTeam);
        assertEquals(expectedRole,actualRole);
        assertEquals(expectedBatch,actualBatch);
        assertEquals(expectedCampus,actualCampus);

    }

}
