
  @ui @rooms @db
  Feature: Verify room reservation functionality

    Scenario: Team lead should be able to see the available rooms
      Given User logged in to Bookit app as team lead role
      When User goes to room hunt page
      And User searches for room with date:
        |date |February 21, 2022|
        |from |7:00am           |
        |to   |7:30am           |
      Then User should see available rooms
      And User logged in to Bookit api as team lead role
      And User sends GET request to "/api/rooms/available" with:
         | year | 2022 |
         | month | 2 |
         | day | 21 |
         | conference-type | SOLID |
         | cluster-name | light-side |
         | timeline-id | 11237 |
      Then status code should be 200
      And available rooms in response should match UI results
      And available rooms in database should match UI and API results

