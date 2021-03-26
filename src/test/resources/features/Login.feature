Feature: Login

  @wip
  Scenario Outline: All types of users should be able to login
    Given the user logged in as "<userType>"
    Then the user should be on "map" page

    Examples:
      | userType  |
      | student   |
      | team lead |
      | teacher   |


  Scenario Outline: All users should be able to login
    Given the user is on login page
    When the user logs in using "<email>" "<password>"
    Then the user should be on "map" page

    Examples:
      | email                           | password      |
      | lbraunthal90@reverbnation.com   | mollycossor   |
      | bgreensmith91@nytimes.com       | elbertlaye    |
      | karzu92@istockphoto.com         | weidarfarrell |
      | lruffli93@dailymail.co.uk       | menardnewbatt |
      | uklimes8j@goodreads.com         | joyaprowse    |
      | teachervasctoforstall@gmail.com | scottforstall |
      | bmurkus8q@psu.edu               | alicasanbroke |