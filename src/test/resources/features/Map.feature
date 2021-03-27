Feature: Map Info

  @wip1b @db # this feature can run after login
  Scenario: Check availability info for each bookable room
    Given the user logs in using "karzu92@istockphoto.com" "weidarfarrell"
    When the user goes through bookable rooms
    Then the user sees reservation info for the room for the coming 7 days including today
    And reservation info on UI should match the info on database for the room


