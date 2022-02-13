
  Feature: BookIt API login verifications

    Scenario: verify login with valid credentials
      Given User logged in to Bookit api as teacher role
      And User sends GET request to "/api/users/me"
      Then status code should be 200
      And content type is "application/json"
      And role is "teacher"

    @ui
    Scenario: verify user details with ui and api
      Given User logged in to Bookit api as teacher role
      And User sends GET request to "/api/users/me"
      And User logged in to Bookit app as teacher role
      And User is on self page
      Then User should see same info on UI and API