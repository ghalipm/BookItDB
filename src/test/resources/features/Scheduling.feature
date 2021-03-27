Feature: Schedules Info

  @wip3 @db # this feature has to run after conference booking is completed
  Scenario: Verify schedules information for myself on UI matches the database
    Given the user logs in using "karzu92@istockphoto.com" "weidarfarrell"
    When the user goes to my under schedule module
    Then the user sees booking information related to the user
    And Booking Info on UI should match the info on database for the user

  @wip3 @db
    Scenario: Verify schedules information for general users on UI matches the database
    Given the user logs in using "karzu92@istockphoto.com" "weidarfarrell"
    When the user goes to general under schedule module
    Then the user sees reservations for today  including his and for other others
    And reservation Info on UI should match the info on database for today

