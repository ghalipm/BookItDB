package com.bookit.step_definitions;

import com.bookit.pages.*;
import com.bookit.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;
import java.util.List;

import static com.bookit.utilities.BrowserUtils.getTextOfElements;
import static com.bookit.utilities.WaitUtils.waitForClickable;
import static com.bookit.utilities.WaitUtils.waitForPageToLoad;

public class ConferenceBookingStepDefs {


    @When("the user goes to hunt page")
    public void the_user_goes_to_hunt_page() {
        // Write code here that turns the phrase above into concrete actions
        MapPage mapPage = new MapPage();
        mapPage.goToHunt();

    }

    @When("picks the Date, picks the initial hour and terminal hour for conference")
    public void picks_the_Date_picks_the_initial_hour_and_terminal_hour_for_conference() {
        // Write code here that turns the phrase above into concrete actions
        HuntPage huntPage=new HuntPage();
        waitForClickable(huntPage.huntDatePicker, 3);
        huntPage.chooseDate();
        huntPage.chooseInitialHour();
        waitForClickable(huntPage.terminalHourPicker, 2);
        huntPage.chooseTerminalHour();
        waitForClickable(huntPage.searchButton, 3);
        huntPage.clickSearch();



    }

    @When("the user chooses one of the available random options")
    public void the_user_chooses_one_of_the_available_random_options() {
        // Write code here that turns the phrase above into concrete actions
        FreeSpotsPage freeSpotsPage=new FreeSpotsPage();
        freeSpotsPage.bookConference();
    }

    @When("the user confirms the conference")
    public void the_user_confirms_the_conference() {
        // Write code here that turns the phrase above into concrete actions
        ConfirmationPage confirmationPage=new ConfirmationPage();
        confirmationPage.confirm();

    }


    @When("user clicks the schedule link")
    public void user_clicks_the_schedule_link() {
        // Write code here that turns the phrase above into concrete actions
        BookingStatusPage bookingStatusPage=new BookingStatusPage();
        bookingStatusPage.checkScheduleLink();

    }

    @When("the user sees conferences on his - her schedule.")
    public void the_user_sees_conferences_on_his_her_schedule() {
        // Write code here that turns the phrase above into concrete actions
        MyBookedSchedulePage myBookedSchedulePage=new MyBookedSchedulePage();
        myBookedSchedulePage.getConference();

    }


    @When("the user checks-clicks one of the conferences and writes down the room name, capacity, date, time")
    public void the_user_checks_clicks_one_of_the_conferences_and_writes_down_the_room_name_capacity_date_time() {
        // Write code here that turns the phrase above into concrete actions

        BookingSummaryWindow bookingSummaryWindow=new BookingSummaryWindow();

        // get info about bookingInfoTitles and bookingInfoSubTitles from UI
        List<String> bookingInfoTitlesText=getTextOfElements(bookingSummaryWindow.getBookingInfoTitles());
        List<String> extendedBookingInfoSubTitlesText=getTextOfElements(bookingSummaryWindow.extendedBookingInfoSubTitles());

        //to verify if we have collected correct info, print out title and subTitle info and verify visually against the info on UI - webpage

        String roomNameUI=bookingSummaryWindow.getBookedRoomName();

        System.out.println("BookingInfoTitles = " + getTextOfElements(bookingSummaryWindow.getBookingInfoTitles()));
        System.out.println("extendedBookingInfoSubTitles = " + getTextOfElements(bookingSummaryWindow.extendedBookingInfoSubTitles()));
        System.out.println("BookedRoomName = " + bookingSummaryWindow.getBookedRoomName());
        System.out.println("BookedRoomCapacityValue = " + bookingSummaryWindow.getBookedRoomCapacityValue());

    }

    @Then("the conference information on UI should match the info on DB for user {string}")
    public void the_conference_information_on_UI_should_match_the_info_on_DB_for_user(String string) {
        // Write code here that turns the phrase above into concrete actions

        String query = "select r.name                           as Roomname,\n" +
                "       r.capacity,\n" +
                "       u.firstname || ' ' || u.lastname as fullname,\n" +
                "       t.start,\n" +
                "       t.finish,\n" +
                "       date,\n" +
                "       room_id,\n" +
                "       reservator_id\n" +
                "from conference c\n" +
                "         join users u on u.id = c.reservator_id\n" +
                "         join room r on c.room_id = r.id\n" +
                "         join conference_timeline ct on c.id = ct.conference_id\n" +
                "         join timeline t on ct.timelines_id = t.id\n" +
                "where email = 'karzu92@istockphoto.com';";

        //get roomname, capacity, fullname, min(start) - max(finish), date in "M/DD" format:
        List<String> titleRowDB= DBUtils.getColumnNames(query);
        System.out.println("titleRowDB = " + titleRowDB);
        String roomNameDB=DBUtils.getFirstRowFirstColumn();
        int capacityDB= Integer.parseInt(DBUtils.get_i_Row_k_Column(1,2));

        String fullNameDB=DBUtils.get_i_Row_k_Column(1,3);
        String startTime=DBUtils.get_i_Row_k_Column(1,4);
        int lastRowNum=DBUtils.getRowCount();
        String finishTime = DBUtils.get_i_Row_k_Column(lastRowNum, 5);
        String bookingTimeDB=startTime+"am - "+finishTime+"am";

        BookingSummaryWindow bookingSummaryWindow=new BookingSummaryWindow();
        int capacityUI=bookingSummaryWindow.getBookedRoomCapacityValue();

        LocalDate bookedDate= LocalDate.parse(DBUtils.get_i_Row_k_Column(1,6));

        Month month = bookedDate.getMonth();
        int   dayOfMonth = bookedDate.getDayOfMonth();
        String monthDate=""+month+"/"+dayOfMonth;
        System.out.println("monthDate = " + monthDate);


    }


}

/**
 *
 --> room_id, reservation_id, date, roomname, capacity, timelines_id, fullname,
 select r.name as Roomname, r.capacity,  u.firstname || ' ' || u.lastname as fullname,  t.start, t.finish, date , room_id, reservator_id from conference c
 join users u on u.id = c.reservator_id
 join room r on c.room_id = r.id
 join conference_timeline ct on c.id = ct.conference_id
 join timeline t on ct.timelines_id = t.id;


 -->  roomname, capacity,  fullname, start, finish, date
 select r.name  as Roomname,
 r.capacity,
 u.firstname || ' ' || u.lastname as fullname,
 t.start,
 t.finish,
 date
 from conference c
 join users u on u.id = c.reservator_id
 join room r on c.room_id = r.id
 join conference_timeline ct on c.id = ct.conference_id
 join timeline t on ct.timelines_id = t.id
 where email = 'karzu92@istockphoto.com';

 */