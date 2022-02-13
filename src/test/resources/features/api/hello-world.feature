
Feature: Hello world

Scenario: Hello world GET api Test
  Given User sends get request to hello world api
  Then status code is 200
  And response body contains "Hello World!"