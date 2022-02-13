@bookit
  Feature: BookIt API login verifications

    Scenario: verify login with valid credentials
      Given User logged in to Bookit api as teacher role
      And User sends request /api/users/me
      Then status code should be 200
      And content type is application/json