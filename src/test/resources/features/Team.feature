Feature: Team Info

  @wip2b @db
  Scenario: Verify team information on UI matches the database
    Given the user logs in using "karzu92@istockphoto.com" "weidarfarrell"
    When the user goes to team page
    Then the team information on UI should match the info on database for user "karzu92@istockphoto.com"