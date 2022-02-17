@ui @zip
Feature: USPS Zipcode look up UI and API validation

  Scenario: User should see same city for API and UI zipcode lookup

    Given User sends GET request to "http://api.zippopotam.us/us/{postal-code}" with "15235" zipcode
    Then city name should be "Pittsburgh" in response
    And User searches for "15235" on USPS website
    Then city name should be "Pittsburgh PA" in result
