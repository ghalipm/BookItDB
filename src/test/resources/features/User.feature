Feature: User Info
  
  @wip @db
  Scenario: Verify user information on UI matches the database
    Given the user logs in using "karzu92@istockphoto.com" "weidarfarrell"
    When the user goes to self page
    Then the information on UI should match the database for user "karzu92@istockphoto.com"