Feature: Json Schema validation

  Scenario: GET request and perform json schema validation of response
    Given User logged in to Bookit api as team lead role
    When User sends GET request to "/api/students/me"
    Then status code should be 200
    And response should match "json-schemas/student-schema.json" schema
