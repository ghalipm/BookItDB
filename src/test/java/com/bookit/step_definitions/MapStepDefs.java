package com.bookit.step_definitions;

import com.bookit.pages.BasePage;
import com.bookit.pages.MapPage;
import com.bookit.pages.MyBookedSchedulePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MapStepDefs extends BasePage {

    @When("the user goes through bookable rooms")
    public void the_user_goes_through_bookable_rooms() {
        MapPage mapPage = new MapPage();
        mapPage.checkRoomsAvailability();

    }

    @Then("the user sees reservation info for the room for the coming {int} days including today")
    public void the_user_sees_reservation_info_for_the_room_for_the_coming_days_including_today(Integer int1) {

        MyBookedSchedulePage myBookedSchedulePage=new MyBookedSchedulePage();
          myBookedSchedulePage.getConference();



    }

    @Then("reservation info on UI should match the info on database for the room")
    public void reservation_info_on_UI_should_match_the_info_on_database_for_the_room() {



    }


}
