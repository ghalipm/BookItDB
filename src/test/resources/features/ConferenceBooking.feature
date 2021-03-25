Feature: Conference Booking

  @wip3 @db
  Scenario: Verify conference booking information on UI matches the info on DB
    Given the user logs in using "karzu92@istockphoto.com" "weidarfarrell"
    When the user goes to hunt page
    And picks the Date, picks the initial hour and terminal hour for conference
    And the user chooses one of the available random options
    And the user confirms the conference
    And user clicks the schedule link
    And  the user sees conferences on his - her schedule.
    And the user checks-clicks one of the conferences and writes down the room name, capacity, date, time
    Then the conference information on UI should match the info on DB for user "karzu92@istockphoto.com"